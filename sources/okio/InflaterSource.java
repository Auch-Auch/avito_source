package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"B\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b!\u0010#J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", DecodeProducer.EXTRA_BITMAP_BYTES, "read", "(Lokio/Buffer;J)J", "readOrInflate", "", "refill", "()Z", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", AuthSource.BOOKING_ORDER, "Z", "closed", "Lokio/BufferedSource;", "c", "Lokio/BufferedSource;", "source", "Ljava/util/zip/Inflater;", "d", "Ljava/util/zip/Inflater;", "inflater", "", AuthSource.SEND_ABUSE, "I", "bufferBytesHeldByInflater", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class InflaterSource implements Source {
    public int a;
    public boolean b;
    public final BufferedSource c;
    public final Inflater d;

    public InflaterSource(@NotNull BufferedSource bufferedSource, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.c = bufferedSource;
        this.d = inflater;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.b) {
            this.d.end();
            this.b = true;
            this.c.close();
        }
    }

    @Override // okio.Source
    public long read(@NotNull Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        do {
            long readOrInflate = readOrInflate(buffer, j);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.d.finished() || this.d.needsDictionary()) {
                return -1;
            }
        } while (!this.c.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (!(!this.b)) {
            throw new IllegalStateException("closed".toString());
        } else if (i == 0) {
            return 0;
        } else {
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int min = (int) Math.min(j, (long) (8192 - writableSegment$okio.limit));
                refill();
                int inflate = this.d.inflate(writableSegment$okio.data, writableSegment$okio.limit, min);
                int i2 = this.a;
                if (i2 != 0) {
                    int remaining = i2 - this.d.getRemaining();
                    this.a -= remaining;
                    this.c.skip((long) remaining);
                }
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j2 = (long) inflate;
                    buffer.setSize$okio(buffer.size() + j2);
                    return j2;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                return 0;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }

    public final boolean refill() throws IOException {
        if (!this.d.needsInput()) {
            return false;
        }
        if (this.c.exhausted()) {
            return true;
        }
        Segment segment = this.c.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        int i = segment.limit;
        int i2 = segment.pos;
        int i3 = i - i2;
        this.a = i3;
        this.d.setInput(segment.data, i2, i3);
        return false;
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.c.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source, @NotNull Inflater inflater) {
        this(Okio.buffer(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }
}
