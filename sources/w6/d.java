package w6;

import a2.b.a.a.a;
import com.vk.sdk.api.VKApiConst;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import org.jetbrains.annotations.NotNull;
public final class d implements Sink {
    public final OutputStream a;
    public final Timeout b;

    public d(@NotNull OutputStream outputStream, @NotNull Timeout timeout) {
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.a = outputStream;
        this.b = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("sink(");
        L.append(this.a);
        L.append(')');
        return L.toString();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j);
        while (j > 0) {
            this.b.throwIfReached();
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.a.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = (long) min;
            j -= j2;
            buffer.setSize$okio(buffer.size() - j2);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
