package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ+\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017¨\u0006\u001f"}, d2 = {"Lokio/Throttler;", "", "", "bytesPerSecond", "waitByteCount", "maxByteCount", "", "(JJJ)V", DecodeProducer.EXTRA_BITMAP_BYTES, "take$okio", "(J)J", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", "source", "(Lokio/Source;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", AuthSource.SEND_ABUSE, "J", AuthSource.BOOKING_ORDER, "c", "d", "allocatedUntil", "<init>", "(J)V", "()V", "okio"}, k = 1, mv = {1, 4, 0})
public final class Throttler {
    public long a;
    public long b;
    public long c;
    public long d;

    public Throttler(long j) {
        this.d = j;
        this.b = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.c = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.b;
        }
        if ((i & 4) != 0) {
            j3 = throttler.c;
        }
        throttler.bytesPerSecond(j, j2, j3);
    }

    public final long a(long j) {
        return (j * 1000000000) / this.a;
    }

    public final long byteCountOrWaitNanos$okio(long j, long j2) {
        if (this.a == 0) {
            return j2;
        }
        long max = Math.max(this.d - j, 0L);
        long j3 = this.c;
        long j4 = this.a;
        long j5 = j3 - ((max * j4) / 1000000000);
        if (j5 >= j2) {
            this.d = j + max + ((j2 * 1000000000) / j4);
            return j2;
        }
        long j6 = this.b;
        if (j5 >= j6) {
            this.d = a(j3) + j;
            return j5;
        }
        long min = Math.min(j6, j2);
        long a3 = a(min - this.c) + max;
        if (a3 != 0) {
            return -a3;
        }
        this.d = a(this.c) + j;
        return min;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j, long j2, long j3) {
        synchronized (this) {
            boolean z = true;
            if (j >= 0) {
                if (j2 > 0) {
                    if (j3 < j2) {
                        z = false;
                    }
                    if (z) {
                        this.a = j;
                        this.b = j2;
                        this.c = j3;
                        notifyAll();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new ForwardingSink(this, sink, sink) { // from class: okio.Throttler$sink$1
            public final /* synthetic */ Throttler a;
            public final /* synthetic */ Sink b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer buffer, long j) throws IOException {
                Intrinsics.checkNotNullParameter(buffer, "source");
                while (j > 0) {
                    try {
                        long take$okio = this.a.take$okio(j);
                        super.write(buffer, take$okio);
                        j -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new ForwardingSource(this, source, source) { // from class: okio.Throttler$source$1
            public final /* synthetic */ Throttler a;
            public final /* synthetic */ Source b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer buffer, long j) {
                Intrinsics.checkNotNullParameter(buffer, "sink");
                try {
                    return super.read(buffer, this.a.take$okio(j));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j) {
        long byteCountOrWaitNanos$okio;
        if (j > 0) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
                    if (byteCountOrWaitNanos$okio < 0) {
                        long j2 = -byteCountOrWaitNanos$okio;
                        long j3 = j2 / 1000000;
                        Long.signum(j3);
                        wait(j3, (int) (j2 - (1000000 * j3)));
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
