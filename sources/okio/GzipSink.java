package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0012\u001a\u00020\u000f8G@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "Lokio/Buffer;", "source", "", DecodeProducer.EXTRA_BITMAP_BYTES, "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Ljava/util/zip/Deflater;", "-deprecated_deflater", "()Ljava/util/zip/Deflater;", "deflater", "Lokio/DeflaterSink;", "c", "Lokio/DeflaterSink;", "deflaterSink", AuthSource.BOOKING_ORDER, "Ljava/util/zip/Deflater;", "Lokio/RealBufferedSink;", AuthSource.SEND_ABUSE, "Lokio/RealBufferedSink;", "sink", "", "d", "Z", "closed", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", "crc", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class GzipSink implements Sink {
    public final RealBufferedSink a;
    @NotNull
    public final Deflater b;
    public final DeflaterSink c;
    public boolean d;
    public final CRC32 e = new CRC32();

    public GzipSink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.a = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        this.c = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    @JvmName(name = "-deprecated_deflater")
    @NotNull
    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m691deprecated_deflater() {
        return this.b;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            Throwable th = null;
            try {
                this.c.finishDeflate$okio();
                this.a.writeIntLe((int) this.e.getValue());
                this.a.writeIntLe((int) this.b.getBytesRead());
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.d = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @JvmName(name = "deflater")
    @NotNull
    public final Deflater deflater() {
        return this.b;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.a.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (i != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            long j2 = j;
            while (j2 > 0) {
                int min = (int) Math.min(j2, (long) (segment.limit - segment.pos));
                this.e.update(segment.data, segment.pos, min);
                j2 -= (long) min;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
            }
            this.c.write(buffer, j);
        }
    }
}
