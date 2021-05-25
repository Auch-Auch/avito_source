package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
public class MimeTypeMapWrapper {
    public static final MimeTypeMap a = MimeTypeMap.getSingleton();
    public static final Map<String, String> b = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    public static final Map<String, String> c = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");

    public static String getExtensionFromMimeType(String str) {
        String str2 = b.get(str);
        if (str2 != null) {
            return str2;
        }
        return a.getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        String str2 = c.get(str);
        if (str2 != null) {
            return str2;
        }
        return a.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(String str) {
        return c.containsKey(str) || a.hasExtension(str);
    }

    public static boolean hasMimeType(String str) {
        return b.containsKey(str) || a.hasMimeType(str);
    }
}
