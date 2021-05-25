package o6;

import bolts.CancellationToken;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import java.util.concurrent.CancellationException;
public final class d implements Runnable {
    public final /* synthetic */ CancellationToken a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ Continuation c;
    public final /* synthetic */ Task d;

    public d(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.a = cancellationToken;
        this.b = taskCompletionSource;
        this.c = continuation;
        this.d = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        CancellationToken cancellationToken = this.a;
        if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
            try {
                this.b.setResult(this.c.then(this.d));
            } catch (CancellationException unused) {
                this.b.setCancelled();
            } catch (Exception e) {
                this.b.setError(e);
            }
        } else {
            this.b.setCancelled();
        }
    }
}
