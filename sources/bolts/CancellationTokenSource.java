package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import o6.b;
import o6.c;
public class CancellationTokenSource implements Closeable {
    public final Object a = new Object();
    public final List<CancellationTokenRegistration> b = new ArrayList();
    public final ScheduledExecutorService c = b.d.b;
    public ScheduledFuture<?> d;
    public boolean e;
    public boolean f;

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.d = null;
        }
    }

    public final void b() {
        if (this.f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    public void cancel() {
        ArrayList arrayList;
        synchronized (this.a) {
            b();
            if (!this.e) {
                a();
                this.e = true;
                arrayList = new ArrayList(this.b);
            } else {
                return;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CancellationTokenRegistration) it.next()).a();
        }
    }

    public void cancelAfter(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("Delay must be >= -1");
        } else if (j == 0) {
            cancel();
        } else {
            synchronized (this.a) {
                if (!this.e) {
                    a();
                    if (i != 0) {
                        this.d = this.c.schedule(new c(this), j, timeUnit);
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (!this.f) {
                a();
                for (CancellationTokenRegistration cancellationTokenRegistration : this.b) {
                    cancellationTokenRegistration.close();
                }
                this.b.clear();
                this.f = true;
            }
        }
    }

    public CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.a) {
            b();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public boolean isCancellationRequested() {
        boolean z;
        synchronized (this.a) {
            b();
            z = this.e;
        }
        return z;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested()));
    }
}
