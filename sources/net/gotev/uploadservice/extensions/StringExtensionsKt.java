package net.gotev.uploadservice.extensions;

import android.webkit.MimeTypeMap;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0005\"\u0017\u0010\n\u001a\u00020\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0017\u0010\f\u001a\u00020\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0016\u0010\r\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"", "autoDetectMimeType", "(Ljava/lang/String;)Ljava/lang/String;", "", "isASCII", "(Ljava/lang/String;)Z", "isValidHttpUrl", "", "getAsciiByes", "(Ljava/lang/String;)[B", "asciiByes", "getUtf8Bytes", "utf8Bytes", "APPLICATION_OCTET_STREAM", "Ljava/lang/String;", "VIDEO_MP4", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class StringExtensionsKt {
    @NotNull
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    @NotNull
    public static final String VIDEO_MP4 = "video/mp4";

    @NotNull
    public static final String autoDetectMimeType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$autoDetectMimeType");
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        int lastIndex = StringsKt__StringsKt.getLastIndex(str);
        String str2 = APPLICATION_OCTET_STREAM;
        if (lastIndexOf$default < 0 || lastIndex <= lastIndexOf$default) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "mp4")) {
            return "video/mp4";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension != null) {
            str2 = mimeTypeFromExtension;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "MimeTypeMap.getSingleton… APPLICATION_OCTET_STREAM");
        return str2;
    }

    @NotNull
    public static final byte[] getAsciiByes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$asciiByes");
        byte[] bytes = str.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    public static final byte[] getUtf8Bytes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$utf8Bytes");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final boolean isASCII(@Nullable String str) {
        if (str == null || m.isBlank(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isValidHttpUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$isValidHttpUrl");
        if (!m.startsWith$default(str, "http://", false, 2, null) && !m.startsWith$default(str, "https://", false, 2, null)) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
