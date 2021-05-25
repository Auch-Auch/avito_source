package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u0001¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010)¨\u0006-"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", DecodeProducer.EXTRA_BITMAP_BYTES, "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "buffer", "offset", AuthSource.BOOKING_ORDER, "(Lokio/Buffer;JJ)V", "", "name", "", "expected", "actual", AuthSource.SEND_ABUSE, "(Ljava/lang/String;II)V", "Lokio/InflaterSource;", "d", "Lokio/InflaterSource;", "inflaterSource", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", "crc", "Lokio/RealBufferedSource;", "Lokio/RealBufferedSource;", "source", "Ljava/util/zip/Inflater;", "c", "Ljava/util/zip/Inflater;", "inflater", "", "B", "section", "<init>", "(Lokio/Source;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class GzipSource implements Source {
    public byte a;
    public final RealBufferedSource b;
    public final Inflater c;
    public final InflaterSource d;
    public final CRC32 e = new CRC32();

    public GzipSource(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.b = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new InflaterSource((BufferedSource) realBufferedSource, inflater);
    }

    public final void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(a.H(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3, "%s: actual 0x%08x != expected 0x%08x", "java.lang.String.format(this, *args)"));
        }
    }

    public final void b(Buffer buffer, long j, long j2) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.pos) + j);
            int min = (int) Math.min((long) (segment.limit - i3), j2);
            this.e.update(segment.data, i3, min);
            j2 -= (long) min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer buffer, long j) throws IOException {
        long j2;
        Intrinsics.checkNotNullParameter(buffer, "sink");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                this.b.require(10);
                byte b2 = this.b.bufferField.getByte(3);
                boolean z = ((b2 >> 1) & 1) == 1;
                if (z) {
                    b(this.b.bufferField, 0, 10);
                }
                a("ID1ID2", 8075, this.b.readShort());
                this.b.skip(8);
                if (((b2 >> 2) & 1) == 1) {
                    this.b.require(2);
                    if (z) {
                        b(this.b.bufferField, 0, 2);
                    }
                    long readShortLe = (long) this.b.bufferField.readShortLe();
                    this.b.require(readShortLe);
                    if (z) {
                        j2 = readShortLe;
                        b(this.b.bufferField, 0, readShortLe);
                    } else {
                        j2 = readShortLe;
                    }
                    this.b.skip(j2);
                }
                if (((b2 >> 3) & 1) == 1) {
                    long indexOf = this.b.indexOf((byte) 0);
                    if (indexOf != -1) {
                        if (z) {
                            b(this.b.bufferField, 0, indexOf + 1);
                        }
                        this.b.skip(indexOf + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((b2 >> 4) & 1) == 1) {
                    long indexOf2 = this.b.indexOf((byte) 0);
                    if (indexOf2 != -1) {
                        if (z) {
                            b(this.b.bufferField, 0, indexOf2 + 1);
                        }
                        this.b.skip(indexOf2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    a("FHCRC", this.b.readShortLe(), (short) ((int) this.e.getValue()));
                    this.e.reset();
                }
                this.a = 1;
            }
            if (this.a == 1) {
                long size = buffer.size();
                long read = this.d.read(buffer, j);
                if (read != -1) {
                    b(buffer, size, read);
                    return read;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                a("CRC", this.b.readIntLe(), (int) this.e.getValue());
                a("ISIZE", this.b.readIntLe(), (int) this.c.getBytesWritten());
                this.a = 3;
                if (!this.b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.b.timeout();
    }
}
