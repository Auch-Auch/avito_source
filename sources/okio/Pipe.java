package okio;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020)¢\u0006\u0004\b3\u00104J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u0006R\u0019\u0010\u0003\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u0003\u0010\bR\u001c\u0010&\u001a\u00020!8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\f\u001a\u00020\t8G@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\f\u0010\u000bR\u001c\u0010.\u001a\u00020)8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00102\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015¨\u00065"}, d2 = {"Lokio/Pipe;", "", "Lokio/Sink;", "sink", "", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", "source", "cancel", "()V", "", "c", "Z", "getSinkClosed$okio", "()Z", "setSinkClosed$okio", "(Z)V", "sinkClosed", "d", "getSourceClosed$okio", "setSourceClosed$okio", "sourceClosed", "e", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "foldedSink", "f", "Lokio/Buffer;", AuthSource.SEND_ABUSE, "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "buffer", g.a, "Lokio/Source;", "", "h", "J", "getMaxBufferSize$okio", "()J", "maxBufferSize", AuthSource.BOOKING_ORDER, "getCanceled$okio", "setCanceled$okio", PaymentStateKt.PAYMENT_STATE_CANCELED, "<init>", "(J)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class Pipe {
    @NotNull
    public final Buffer a = new Buffer();
    public boolean b;
    public boolean c;
    public boolean d;
    @Nullable
    public Sink e;
    @NotNull
    public final Sink f;
    @NotNull
    public final Source g;
    public final long h;

    public Pipe(long j) {
        this.h = j;
        if (j >= 1) {
            this.f = new Sink(this) { // from class: okio.Pipe$sink$1
                public final Timeout a = new Timeout();
                public final /* synthetic */ Pipe b;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.b = r1;
                }

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Sink foldedSink$okio;
                    synchronized (this.b.getBuffer$okio()) {
                        if (!this.b.getSinkClosed$okio()) {
                            foldedSink$okio = this.b.getFoldedSink$okio();
                            if (foldedSink$okio == null) {
                                if (!this.b.getSourceClosed$okio() || this.b.getBuffer$okio().size() <= 0) {
                                    this.b.setSinkClosed$okio(true);
                                    Buffer buffer$okio = this.b.getBuffer$okio();
                                    if (buffer$okio != null) {
                                        buffer$okio.notifyAll();
                                        foldedSink$okio = null;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                } else {
                                    throw new IOException("source is closed");
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = this.b;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (timeout.hasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th;
                            }
                        } else {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th2;
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink$okio;
                    synchronized (this.b.getBuffer$okio()) {
                        if (!(!this.b.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        } else if (!this.b.getCanceled$okio()) {
                            foldedSink$okio = this.b.getFoldedSink$okio();
                            if (foldedSink$okio == null) {
                                if (this.b.getSourceClosed$okio()) {
                                    if (this.b.getBuffer$okio().size() > 0) {
                                        throw new IOException("source is closed");
                                    }
                                }
                                foldedSink$okio = null;
                            }
                        } else {
                            throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                        }
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = this.b;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (timeout.hasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th;
                            }
                        } else {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th2;
                            }
                        }
                    }
                }

                @Override // okio.Sink
                @NotNull
                public Timeout timeout() {
                    return this.a;
                }

                @Override // okio.Sink
                public void write(@NotNull Buffer buffer, long j2) {
                    Sink sink;
                    Intrinsics.checkNotNullParameter(buffer, "source");
                    synchronized (this.b.getBuffer$okio()) {
                        if (!(!this.b.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        } else if (!this.b.getCanceled$okio()) {
                            while (true) {
                                if (j2 <= 0) {
                                    sink = null;
                                    break;
                                }
                                sink = this.b.getFoldedSink$okio();
                                if (sink != null) {
                                    break;
                                } else if (!this.b.getSourceClosed$okio()) {
                                    long maxBufferSize$okio = this.b.getMaxBufferSize$okio() - this.b.getBuffer$okio().size();
                                    if (maxBufferSize$okio == 0) {
                                        this.a.waitUntilNotified(this.b.getBuffer$okio());
                                        if (this.b.getCanceled$okio()) {
                                            throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                                        }
                                    } else {
                                        long min = Math.min(maxBufferSize$okio, j2);
                                        this.b.getBuffer$okio().write(buffer, min);
                                        j2 -= min;
                                        Buffer buffer$okio = this.b.getBuffer$okio();
                                        if (buffer$okio != null) {
                                            buffer$okio.notifyAll();
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                        }
                                    }
                                } else {
                                    throw new IOException("source is closed");
                                }
                            }
                        } else {
                            throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                        }
                    }
                    if (sink != null) {
                        Pipe pipe = this.b;
                        Timeout timeout = sink.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (timeout.hasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                sink.write(buffer, j2);
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th;
                            }
                        } else {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                sink.write(buffer, j2);
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th2;
                            }
                        }
                    }
                }
            };
            this.g = new Source(this) { // from class: okio.Pipe$source$1
                public final Timeout a = new Timeout();
                public final /* synthetic */ Pipe b;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.b = r1;
                }

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (this.b.getBuffer$okio()) {
                        this.b.setSourceClosed$okio(true);
                        Buffer buffer$okio = this.b.getBuffer$okio();
                        if (buffer$okio != null) {
                            buffer$okio.notifyAll();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                    }
                }

                @Override // okio.Source
                public long read(@NotNull Buffer buffer, long j2) {
                    Intrinsics.checkNotNullParameter(buffer, "sink");
                    synchronized (this.b.getBuffer$okio()) {
                        if (!(!this.b.getSourceClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        } else if (!this.b.getCanceled$okio()) {
                            while (this.b.getBuffer$okio().size() == 0) {
                                if (this.b.getSinkClosed$okio()) {
                                    return -1;
                                }
                                this.a.waitUntilNotified(this.b.getBuffer$okio());
                                if (this.b.getCanceled$okio()) {
                                    throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                                }
                            }
                            long read = this.b.getBuffer$okio().read(buffer, j2);
                            Buffer buffer$okio = this.b.getBuffer$okio();
                            if (buffer$okio != null) {
                                buffer$okio.notifyAll();
                                return read;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        } else {
                            throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                        }
                    }
                }

                @Override // okio.Source
                @NotNull
                public Timeout timeout() {
                    return this.a;
                }
            };
            return;
        }
        throw new IllegalArgumentException(a.T2("maxBufferSize < 1: ", j).toString());
    }

    public static final void access$forward(Pipe pipe, Sink sink, Function1 function1) {
        Objects.requireNonNull(pipe);
        Timeout timeout = sink.timeout();
        Timeout timeout2 = pipe.sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink);
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink);
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m694deprecated_sink() {
        return this.f;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m695deprecated_source() {
        return this.g;
    }

    public final void cancel() {
        synchronized (this.a) {
            this.b = true;
            this.a.clear();
            Buffer buffer = this.a;
            if (buffer != null) {
                buffer.notifyAll();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    public final void fold(@NotNull Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            synchronized (this.a) {
                if (!(this.e == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                } else if (this.b) {
                    this.e = sink;
                    throw new IOException(PaymentStateKt.PAYMENT_STATE_CANCELED);
                } else if (this.a.exhausted()) {
                    this.d = true;
                    this.e = sink;
                    return;
                } else {
                    z = this.c;
                    buffer = new Buffer();
                    Buffer buffer2 = this.a;
                    buffer.write(buffer2, buffer2.size());
                    Buffer buffer3 = this.a;
                    if (buffer3 != null) {
                        buffer3.notifyAll();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.a) {
                    this.d = true;
                    Buffer buffer4 = this.a;
                    if (buffer4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer4.notifyAll();
                    throw th;
                }
            }
        }
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.a;
    }

    public final boolean getCanceled$okio() {
        return this.b;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.e;
    }

    public final long getMaxBufferSize$okio() {
        return this.h;
    }

    public final boolean getSinkClosed$okio() {
        return this.c;
    }

    public final boolean getSourceClosed$okio() {
        return this.d;
    }

    public final void setCanceled$okio(boolean z) {
        this.b = z;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.e = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.c = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.d = z;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.f;
    }

    @JvmName(name = "source")
    @NotNull
    public final Source source() {
        return this.g;
    }
}
