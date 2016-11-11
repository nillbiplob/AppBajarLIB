package com.aapbd.appbajarlib.network;

import android.os.Bundle;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

public class UrlUtils {
    private static String mark = "-_.!~*'()\"";

    public static String buildUrl(String baseUrl, Map<String, Object> parameters) {
        final StringBuilder strBuilderUrl = new StringBuilder(baseUrl);
        if (parameters != null && parameters.size() > 0) {
            int i = 0;
            for (final Map.Entry<String, Object> entry : parameters.entrySet()) {
                if (i == 0) {
                    strBuilderUrl.append('?');
                } else {
                    strBuilderUrl.append('&');
                }
                strBuilderUrl.append(entry.getKey());
                strBuilderUrl.append('=');
                strBuilderUrl.append(entry.getValue());
                i++;
            }

        }
        return strBuilderUrl.toString();
    }

    public static String encodeUrl(Bundle parameters) {
        if (parameters == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (final String key : parameters.keySet()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
                // sb.append(key + "=" + parameters.getString(key));
                sb.append(key);
                sb.append("=");
                sb.append(parameters.getString(key));
            }
        }
        return sb.toString();
    }

    public static Bundle decodeUrl(String s) {
        final Bundle params = new Bundle();
        if (s != null) {
            params.putString("url", s);
            final String array[] = s.split("&");
            for (final String parameter : array) {
                final String v[] = parameter.split("=");
                if (v.length > 1) {
                    params.putString(v[0], URLDecoder.decode(v[1]));
                }
            }
        }
        return params;
    }

    public static String urlencode(String original) {
        try {
            // return URLEncoder.encode(original, "utf-8");
            // fixed: to comply with RFC-3986
            return URLEncoder.encode(original, "utf-8").replace("+", "%20")
                    .replace("*", "%2A").replace("%7E", "~");
        } catch (final UnsupportedEncodingException e) {
            // Logger.e(e.toString());
        }
        return null;
    }

    // thisChar == '.' || thisChar == '-' || thisChar == '_' ||
    // thisChar == '~' || thisChar == '=' || thisChar == '&' ||
    // thisChar == '%' || thisChar == '+'
    public static String encode(String s) {
        final StringBuilder sbuf = new StringBuilder();
        int ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            switch (ch) {
                case ' ': {
                    sbuf.append("%20");
                    break;
                }
                case '+': {
                    sbuf.append("%20");
                    break;
                }
                case '!': {
                    sbuf.append("%21");
                    break;
                }
                case '*': {
                    sbuf.append("%2A");
                    break;
                }
                case '\'': {
                    sbuf.append("%27");
                    break;
                }
                case '(': {
                    sbuf.append("%28");
                    break;
                }

                case ')': {
                    sbuf.append("%29");
                    break;
                }
                case ';': {
                    sbuf.append("%3B");
                    break;
                }
            /*
			 * case ':': { sbuf.append("%3A"); break; }
			 */

                case '@': {
                    sbuf.append("%40");
                    break;
                }

                case '$': {
                    sbuf.append("%24");
                    break;
                }
                case ',': {
                    sbuf.append("%2C");
                    break;
                }
			/*
			 * case '/': { sbuf.append("%2F"); break; }
			 */
                case '?': {
                    sbuf.append("%3F");
                    break;
                }

                case '#': {
                    sbuf.append("%23");
                    break;
                }
                case '[': {
                    sbuf.append("%5B");
                    break;
                }
                case ']': {
                    sbuf.append("%5D");
                    break;
                }
                default:
                    sbuf.append((char) ch);
            }
        }
        return sbuf.toString();
    }

    /**
     * @param encoded
     * @return null if fails
     */
    public static String urldecode(String encoded) {
        try {
            return URLDecoder.decode(encoded, "utf-8");
        } catch (final UnsupportedEncodingException e) {
            // Logger.e(e.toString());
        }
        return null;
    }

    public static String encodeURI(String argString) {
        final StringBuilder uri = new StringBuilder(); // Encoded URL
        // thanks Marco!

        final char[] chars = argString.toCharArray();
        for (final char c : chars) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A'
                    && c <= 'Z' || UrlUtils.mark.indexOf(c) != -1) {
                uri.append(c);
            } else {
                uri.append("%");
                uri.append(Integer.toHexString(c));
            }
        }
        return uri.toString();
    }
}
