package com.aapbd.appbajarlib.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApplyMD5 {

    private static String convertToHex(final byte[] data) {
        final StringBuffer buf = new StringBuffer();
        for (final byte element : data) {
            int halfbyte = element >>> 4 & 0x0F;
            int two_halfs = 0;
            do {
                if (0 <= halfbyte && halfbyte <= 9) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = element & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }


    /**
     * function md5 encryption for passwords
     *
     * @param password
     * @return passwordEncrypted
     */
    public static final String applyMD5(final String password) {
        try {

            final MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(password.getBytes());
            final byte messageDigest[] = digest.digest();

            final StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
