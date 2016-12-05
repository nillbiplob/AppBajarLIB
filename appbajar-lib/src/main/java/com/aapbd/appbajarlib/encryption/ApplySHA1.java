package com.aapbd.appbajarlib.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApplySHA1 {

    private static String convertToHex(byte[] data) {
        final StringBuilder buf = new StringBuilder();
        for (final byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte)
                        : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String getSHA1(String text) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        final MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        final byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

}
