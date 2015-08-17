package com.n8.marveldroid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Signature required for all requests per Marvels API documentation. Signatures
 * are a combination of the public and private keys as well as a generated timestamp that
 * makes each request unique.
 */
public class RequestSignature {

    public static String sPublicKey;
    public static String sPrivateKey;

    private static Calendar sCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    private long timeStamp;
    private String hashSignature;

    public static void initialize(String privateKey, String publicKey) {
        sPublicKey = publicKey;
        sPrivateKey = privateKey;
    }

    private RequestSignature() {
        timeStamp = sCalendar.getTimeInMillis() / 1000L;
        hashSignature = createhash(String.valueOf(timeStamp) + sPrivateKey + sPublicKey);
    }

    /**
     * Returnes a new instance of a request signature.
     *
     * @return
     */
    public static RequestSignature create() {
        return new RequestSignature();
    }

    public String getHashSignature() {
        return hashSignature;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    private static String createhash(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
