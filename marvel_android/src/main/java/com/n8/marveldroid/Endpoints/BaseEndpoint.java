package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.common.base.Joiner;
import com.n8.marveldroid.MarvelAndroid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class BaseEndpoint {
    private static final String TAG = BaseEndpoint.class.getSimpleName();

    private String mPublicKey;

    private String mPrivateKey;

    public static String getCommaSeparatedList(List<?> items) {
        if (items == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(items);
    }

    public BaseEndpoint(@NonNull String publicKey, @NonNull String privateKey) {
        if (privateKey == null || privateKey.length() == 0) {
            throw new IllegalArgumentException("Private key must be non-null, non-empty");
        }else if (publicKey == null || publicKey.length() == 0) {
            throw new IllegalArgumentException("Public key must be non-null, non-empty");
        }

        mPublicKey = publicKey;
        mPrivateKey = privateKey;
    }

    protected long getTimestamp(){
        return System.currentTimeMillis() / 1000L;
    }

    protected String getApiKey(){
        return mPublicKey;
    }

    protected String getHashSignature(){
        return createMD5Hash(String.valueOf(getTimestamp()) + mPrivateKey + mPublicKey);
    }

    private static String createMD5Hash(@NonNull final String string) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(string.getBytes());
            byte messageDigestArray[] = digest.digest();

            StringBuilder sb = new StringBuilder();
            for (byte messageDigest : messageDigestArray) {
                String h = Integer.toHexString(0xFF & messageDigest);
                while (h.length() < 2) {
                    h = "0" + h;
                }
                sb.append(h);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            if (MarvelAndroid.LOGGING_ENABLED) {
                Log.d(TAG, e.getLocalizedMessage());
            }
        }

        return "";
    }
}
