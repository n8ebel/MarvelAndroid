package com.n8.marveldroid.Endpoints;

import android.support.annotation.NonNull;

import com.google.common.base.Joiner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class BaseEndpoint {
    protected String mPublicKey;

    protected String mPrivateKey;

    public static String getJoinedList(List<?> list) {
        if (list == null) {
            return null;
        }

        Joiner joiner = Joiner.on(',');
        return joiner.join(list);
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

    final protected long getTimestamp(){
        return System.currentTimeMillis() / 1000L;
    }

    final protected String getApiKey(){
        return mPublicKey;
    }

    final protected String getHashSignature(){
        return createMD5Hash(String.valueOf(getTimestamp()) + mPrivateKey + mPublicKey);
    }

    private static String createMD5Hash(@NonNull final String s) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder sb = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) {
                    h = "0" + h;
                }
                sb.append(h);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
