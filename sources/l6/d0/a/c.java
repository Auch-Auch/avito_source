package l6.d0.a;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
public class c implements Runnable {
    public final /* synthetic */ SettableFuture a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WorkerWrapper c;

    public c(WorkerWrapper workerWrapper, SettableFuture settableFuture, String str) {
        this.c = workerWrapper;
        this.a = settableFuture;
        this.b = str;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        try {
            ListenableWorker.Result result = (ListenableWorker.Result) this.a.get();
            if (result == null) {
                Logger.get().error(WorkerWrapper.t, String.format("%s returned a null result. Treating it as a failure.", this.c.e.workerClassName), new Throwable[0]);
            } else {
                Logger.get().debug(WorkerWrapper.t, String.format("%s returned a %s result.", this.c.e.workerClassName, result), new Throwable[0]);
                this.c.g = result;
            }
        } catch (CancellationException e) {
            Logger.get().info(WorkerWrapper.t, String.format("%s was cancelled", this.b), e);
        } catch (InterruptedException | ExecutionException e2) {
            Logger.get().error(WorkerWrapper.t, String.format("%s failed because it threw an exception/error", this.b), e2);
        } catch (Throwable th) {
            this.c.c();
            throw th;
        }
        this.c.c();
    }
}
