package com.n8.marveldroid;

import android.support.annotation.NonNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Signature required for all requests per Marvels API documentation. Signatures
 * are a combination of the public and private keys as well as a generated timestamp that
 * makes each request unique.
 */
public class Request {

    public static String sPublicKey;
    public static String sPrivateKey;

    private long mTimeStamp;

    private String mHash;

    public static void initialize(@NonNull String privateKey, @NonNull String publicKey) {
        if (privateKey == null || privateKey.length() == 0) {
            throw new IllegalArgumentException("Private key must be non-null, non-empty");
        }else if (publicKey == null || publicKey.length() == 0) {
            throw new IllegalArgumentException("Public key must be non-null, non-empty");
        }

        sPublicKey = publicKey;
        sPrivateKey = privateKey;
    }

    /**
     * Returns a new request object that can be used to authorize a call to an endpoint
     */
    public static Request newInstance() {
        return new Request();
    }

    public String getHash() {
        return mHash;
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    private Request() {
        mTimeStamp = System.currentTimeMillis() / 1000L;
        mHash = createMD5Hash(String.valueOf(mTimeStamp) + sPrivateKey + sPublicKey);
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
