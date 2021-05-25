package com.avito.http.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Buffer;", "", "isPlaintext", "(Lokio/Buffer;)Z", "okhttp"}, k = 2, mv = {1, 4, 2})
public final class BuffersKt {
    public static final boolean isPlaintext(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$isPlaintext");
        try {
            Buffer buffer2 = new Buffer();
            buffer.getBuffer().copyTo(buffer2, 0, buffer.getBuffer().size() < ((long) 64) ? buffer.getBuffer().size() : 64);
            for (int i = 0; i <= 15; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
