package bolts;

import java.io.Closeable;
public class CancellationTokenRegistration implements Closeable {
    public final Object a = new Object();
    public CancellationTokenSource b;
    public Runnable c;
    public boolean d;

    public CancellationTokenRegistration(CancellationTokenSource cancellationTokenSource, Runnable runnable) {
        this.b = cancellationTokenSource;
        this.c = runnable;
    }

    public void a() {
        synchronized (this.a) {
            try {
                if (!this.d) {
                    this.c.run();
                    close();
                } else {
                    throw new IllegalStateException("Object already closed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (!this.d) {
                this.d = true;
                CancellationTokenSource cancellationTokenSource = this.b;
                synchronized (cancellationTokenSource.a) {
                    cancellationTokenSource.b();
                    cancellationTokenSource.b.remove(this);
                }
                this.b = null;
                this.c = null;
            }
        }
    }
}
