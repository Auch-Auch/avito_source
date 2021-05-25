package l6.d0.a;

import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
public class b implements Runnable {
    public final /* synthetic */ SettableFuture a;
    public final /* synthetic */ WorkerWrapper b;

    public b(WorkerWrapper workerWrapper, SettableFuture settableFuture) {
        this.b = workerWrapper;
        this.a = settableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Logger.get().debug(WorkerWrapper.t, String.format("Starting work for %s", this.b.e.workerClassName), new Throwable[0]);
            WorkerWrapper workerWrapper = this.b;
            workerWrapper.r = workerWrapper.f.startWork();
            this.a.setFuture(this.b.r);
        } catch (Throwable th) {
            this.a.setException(th);
        }
    }
}
