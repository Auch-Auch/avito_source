package a2.j.h.a.c;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.mlkit.common.sdkinternal.TaskQueue;
public final /* synthetic */ class p implements Runnable {
    public final TaskQueue a;
    public final Runnable b;

    public p(TaskQueue taskQueue, Runnable runnable) {
        this.a = taskQueue;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskQueue taskQueue = this.a;
        Runnable runnable = this.b;
        Preconditions.checkState(taskQueue.d.getAndSet(Thread.currentThread()) == null);
        try {
            runnable.run();
            taskQueue.d.set(null);
            taskQueue.a();
            return;
        } catch (Throwable th) {
            zzan.zza(th, th);
        }
        throw th;
    }
}
