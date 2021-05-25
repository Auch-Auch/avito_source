package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;
public class CancellationToken {
    public final CancellationTokenSource a;

    public CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.a = cancellationTokenSource;
    }

    public boolean isCancellationRequested() {
        return this.a.isCancellationRequested();
    }

    public CancellationTokenRegistration register(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        CancellationTokenSource cancellationTokenSource = this.a;
        synchronized (cancellationTokenSource.a) {
            cancellationTokenSource.b();
            cancellationTokenRegistration = new CancellationTokenRegistration(cancellationTokenSource, runnable);
            if (cancellationTokenSource.e) {
                cancellationTokenRegistration.a();
            } else {
                cancellationTokenSource.b.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    public void throwIfCancellationRequested() throws CancellationException {
        CancellationTokenSource cancellationTokenSource = this.a;
        synchronized (cancellationTokenSource.a) {
            cancellationTokenSource.b();
            if (cancellationTokenSource.e) {
                throw new CancellationException();
            }
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.a.isCancellationRequested()));
    }
}
