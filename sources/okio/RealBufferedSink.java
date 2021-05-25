package okio;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.vk.sdk.api.VKApiConst;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ'\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001fJ\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020 H\u0016¢\u0006\u0004\b\t\u0010!J'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\"J\u0017\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020#H\u0016¢\u0006\u0004\b\t\u0010$J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010(J\u0017\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010,\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u001aJ\u0017\u0010-\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010\u001aJ\u0017\u0010/\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010\u001aJ\u0017\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010\u001aJ\u0017\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u00103J\u0017\u00105\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u00103J\u0017\u00106\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00103J\u000f\u00107\u001a\u00020\u0001H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0001H\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010>J\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0011H\u0016¢\u0006\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010\u0003\u001a\u00020\u00028Ö\u0002@\u0016X\u0004¢\u0006\f\u0012\u0004\bL\u0010>\u001a\u0004\bK\u0010\u0004R\u0016\u0010M\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "source", "", DecodeProducer.EXTRA_BITMAP_BYTES, "", "write", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", Types.STRING, "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/BufferedSink;", AuthSource.BOOKING_ORDER, "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", VKApiConst.VERSION, "writeLong", "(J)Lokio/BufferedSink;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "()Lokio/BufferedSink;", "emit", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "flush", "()V", "", "isOpen", "()Z", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "()Ljava/lang/String;", "Lokio/Sink;", "sink", "Lokio/Sink;", "getBuffer", "getBuffer$annotations", "closed", "Z", "bufferField", "Lokio/Buffer;", "<init>", "(Lokio/Sink;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class RealBufferedSink implements BufferedSink {
    @JvmField
    @NotNull
    public final Buffer bufferField = new Buffer();
    @JvmField
    public boolean closed;
    @JvmField
    @NotNull
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        this.sink = sink2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            Throwable th = null;
            try {
                if (this.bufferField.size() > 0) {
                    Sink sink2 = this.sink;
                    Buffer buffer = this.bufferField;
                    sink2.write(buffer, buffer.size());
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!this.closed) {
            if (this.bufferField.size() > 0) {
                Sink sink2 = this.sink;
                Buffer buffer = this.bufferField;
                sink2.write(buffer, buffer.size());
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream(this) { // from class: okio.RealBufferedSink$outputStream$1
            public final /* synthetic */ RealBufferedSink a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.a.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = this.a;
                if (!realBufferedSink.closed) {
                    realBufferedSink.flush();
                }
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.a + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                RealBufferedSink realBufferedSink = this.a;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.writeByte((int) ((byte) i));
                    this.a.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] bArr, int i, int i2) {
                Intrinsics.checkNotNullParameter(bArr, "data");
                RealBufferedSink realBufferedSink = this.a;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(bArr, i, i2);
                    this.a.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("buffer(");
        L.append(this.sink);
        L.append(')');
        return L.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        if (!this.closed) {
            int write = this.bufferField.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this.bufferField, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int i) {
        if (!this.closed) {
            this.bufferField.writeByte(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long j) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int i) {
        if (!this.closed) {
            this.bufferField.writeInt(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int i) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long j) {
        if (!this.closed) {
            this.bufferField.writeLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long j) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int i) {
        if (!this.closed) {
            this.bufferField.writeShort(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int i) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (!this.closed) {
            this.bufferField.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int i) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (!this.closed) {
            this.bufferField.write(buffer, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String str, int i, int i2, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i, i2, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i, i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i, i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i, i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(this.bufferField, j);
            if (read != -1) {
                j -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
