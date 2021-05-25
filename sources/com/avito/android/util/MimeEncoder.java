package com.avito.android.util;

import a2.b.a.a.a;
import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/util/MimeEncoder;", "", "", "word", "encodeWord", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "okhttp_release"}, k = 1, mv = {1, 4, 2})
public final class MimeEncoder {
    @NotNull
    public final String encodeWord(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "word");
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (MimeEncoderKt.isNonAscii(str.charAt(i3))) {
                i++;
            } else {
                i2++;
            }
        }
        if ((i == 0 ? 1 : i2 > i ? (char) 2 : 3) == 1) {
            return str;
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return a.e3("=?UTF-8?B?", Base64.encodeToString(bytes, 2), "?=");
    }
}
