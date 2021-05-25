package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class f0<V> extends FluentFuture.a<V> {
    @NullableDecl
    public ListenableFuture<V> h;
    @NullableDecl
    public ScheduledFuture<?> i;

    public static final class b<V> implements Runnable {
        @NullableDecl
        public f0<V> a;

        public b(f0<V> f0Var) {
            this.a = f0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture;
            f0<V> f0Var = this.a;
            if (f0Var != null && (listenableFuture = f0Var.h) != null) {
                this.a = null;
                if (listenableFuture.isDone()) {
                    f0Var.setFuture(listenableFuture);
                    return;
                }
                boolean z = true;
                try {
                    ScheduledFuture<?> scheduledFuture = f0Var.i;
                    f0Var.i = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            f0Var.setException(new c(str, null));
                            throw th;
                        }
                    }
                    f0Var.setException(new c(str + ": " + listenableFuture, null));
                } finally {
                    listenableFuture.cancel(z);
                }
            }
        }
    }

    public static final class c extends TimeoutException {
        public c(String str, a aVar) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    public f0(ListenableFuture<V> listenableFuture) {
        this.h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        m(this.h);
        ScheduledFuture<?> scheduledFuture = this.i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.h = null;
        this.i = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.h;
        ScheduledFuture<?> scheduledFuture = this.i;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
