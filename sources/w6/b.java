package w6;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
public final class b implements Source {
    public final InputStream a;
    public final Timeout b;

    public b(@NotNull InputStream inputStream, @NotNull Timeout timeout) {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.a = inputStream;
        this.b = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        if (i >= 0) {
            try {
                this.b.throwIfReached();
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int read = this.a.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, (long) (8192 - writableSegment$okio.limit)));
                if (read != -1) {
                    writableSegment$okio.limit += read;
                    long j2 = (long) read;
                    buffer.setSize$okio(buffer.size() + j2);
                    return j2;
                } else if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1;
                } else {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1;
                }
            } catch (AssertionError e) {
                if (Okio.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("source(");
        L.append(this.a);
        L.append(')');
        return L.toString();
    }
}
