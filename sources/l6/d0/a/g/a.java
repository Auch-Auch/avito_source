package l6.d0.a.g;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;
public class a implements Runnable {
    public final /* synthetic */ ListenableFuture a;
    public final /* synthetic */ ConstraintTrackingWorker b;

    public a(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        this.b = constraintTrackingWorker;
        this.a = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.g) {
            if (this.b.h) {
                this.b.b();
            } else {
                this.b.i.setFuture(this.a);
            }
        }
    }
}
