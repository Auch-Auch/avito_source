package okhttp3.logging;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Buffer;", "", "isProbablyUtf8", "(Lokio/Buffer;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 4, 0})
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$isProbablyUtf8");
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, e.coerceAtMost(buffer.size(), 64L));
            for (int i = 0; i < 16; i++) {
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
