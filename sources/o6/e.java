package o6;

import bolts.CancellationToken;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import java.util.concurrent.CancellationException;
public final class e implements Runnable {
    public final /* synthetic */ CancellationToken a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ Continuation c;
    public final /* synthetic */ Task d;

    public class a implements Continuation<TContinuationResult, Void> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // bolts.Continuation
        public Void then(Task task) throws Exception {
            CancellationToken cancellationToken = e.this.a;
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                e.this.b.setCancelled();
                return null;
            } else if (task.isCancelled()) {
                e.this.b.setCancelled();
                return null;
            } else if (task.isFaulted()) {
                e.this.b.setError(task.getError());
                return null;
            } else {
                e.this.b.setResult(task.getResult());
                return null;
            }
        }
    }

    public e(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
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
                Task task = (Task) this.c.then(this.d);
                if (task == null) {
                    this.b.setResult(null);
                } else {
                    task.continueWith(new a());
                }
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
