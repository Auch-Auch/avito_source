package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", MimeTypes.VIDEO_MATROSKA, "glb", "model/gltf-binary");

    @Nullable
    public static String extractMime(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String substring = (lastIndexOf < 0 || lastIndexOf == str.length() + -1) ? null : str.substring(lastIndexOf + 1);
        if (substring == null) {
            return null;
        }
        String lowerCase = substring.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase) : mimeTypeFromExtension;
    }

    public static boolean isNonNativeSupportedMimeType(String str) {
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(str);
    }

    public static boolean isPhoto(@Nullable String str) {
        return str != null && str.startsWith("image/");
    }

    public static boolean isThreeD(@Nullable String str) {
        return str != null && str.equals("model/gltf-binary");
    }

    public static boolean isVideo(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }
}
