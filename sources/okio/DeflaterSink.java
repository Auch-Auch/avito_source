package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", DecodeProducer.EXTRA_BITMAP_BYTES, "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "finishDeflate$okio", "finishDeflate", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "", "syncFlush", AuthSource.SEND_ABUSE, "(Z)V", "Z", "closed", "Lokio/BufferedSink;", AuthSource.BOOKING_ORDER, "Lokio/BufferedSink;", "sink", "Ljava/util/zip/Deflater;", "c", "Ljava/util/zip/Deflater;", "deflater", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class DeflaterSink implements Sink {
    public boolean a;
    public final BufferedSink b;
    public final Deflater c;

    public DeflaterSink(@NotNull BufferedSink bufferedSink, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.b = bufferedSink;
        this.c = deflater;
    }

    @IgnoreJRERequirement
    public final void a(boolean z) {
        Segment writableSegment$okio;
        int i;
        Buffer buffer = this.b.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z) {
                Deflater deflater = this.c;
                byte[] bArr = writableSegment$okio.data;
                int i2 = writableSegment$okio.limit;
                i = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.c;
                byte[] bArr2 = writableSegment$okio.data;
                int i3 = writableSegment$okio.limit;
                i = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                writableSegment$okio.limit += i;
                buffer.setSize$okio(buffer.size() + ((long) i));
                this.b.emitCompleteSegments();
            } else if (this.c.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.a) {
            Throwable th = null;
            try {
                finishDeflate$okio();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.c.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.b.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.a = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final void finishDeflate$okio() {
        this.c.finish();
        a(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.b.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.b.timeout();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeflaterSink(");
        L.append(this.b);
        L.append(')');
        return L.toString();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j);
        while (j > 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            this.c.setInput(segment.data, segment.pos, min);
            a(false);
            long j2 = (long) min;
            buffer.setSize$okio(buffer.size() - j2);
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j -= j2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }
}
