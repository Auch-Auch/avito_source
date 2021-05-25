package o6;

import bolts.CancellationTokenSource;
public class c implements Runnable {
    public final /* synthetic */ CancellationTokenSource a;

    public c(CancellationTokenSource cancellationTokenSource) {
        this.a = cancellationTokenSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        CancellationTokenSource cancellationTokenSource;
        synchronized (this.a.a) {
            cancellationTokenSource = this.a;
            cancellationTokenSource.d = null;
        }
        cancellationTokenSource.cancel();
    }
}
