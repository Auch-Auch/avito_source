package com.avito.http;

import com.avito.android.remote.auth.AuthSource;
import com.avito.http.internal.BuffersKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lokhttp3/RequestBody;", "", "toPlainText", "(Lokhttp3/RequestBody;)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/nio/charset/Charset;", "utf8", "okhttp"}, k = 2, mv = {1, 4, 2})
public final class RequestBodiesKt {
    public static final Charset a = Charset.forName("UTF-8");

    @Nullable
    public static final String toPlainText(@NotNull RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "$this$toPlainText");
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        Charset charset = a;
        MediaType contentType = requestBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        if (!BuffersKt.isPlaintext(buffer)) {
            return null;
        }
        Intrinsics.checkNotNull(charset);
        return buffer.readString(charset);
    }
}
