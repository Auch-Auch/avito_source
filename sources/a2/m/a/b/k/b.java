package a2.m.a.b.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.util.concurrent.CancellationException;
public class b implements Runnable {
    public final /* synthetic */ CameraOrchestrator.Job a;
    public final /* synthetic */ WorkerHandler b;
    public final /* synthetic */ CameraOrchestrator c;

    public class a implements OnCompleteListener<T> {
        public a() {
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<T> task) {
            Exception exception = task.getException();
            if (exception != null) {
                CameraOrchestrator.LOG.w(b.this.a.name.toUpperCase(), "- Finished with ERROR.", exception);
                b bVar = b.this;
                CameraOrchestrator.Job job = bVar.a;
                if (job.dispatchExceptions) {
                    bVar.c.mCallback.handleJobException(job.name, exception);
                }
                b.this.a.source.trySetException(exception);
            } else if (task.isCanceled()) {
                CameraOrchestrator.LOG.i(b.this.a.name.toUpperCase(), "- Finished because ABORTED.");
                b.this.a.source.trySetException(new CancellationException());
            } else {
                CameraOrchestrator.LOG.i(b.this.a.name.toUpperCase(), "- Finished.");
                b.this.a.source.trySetResult(task.getResult());
            }
            synchronized (b.this.c.mJobsLock) {
                b bVar2 = b.this;
                CameraOrchestrator.a(bVar2.c, bVar2.a);
            }
        }
    }

    public b(CameraOrchestrator cameraOrchestrator, CameraOrchestrator.Job job, WorkerHandler workerHandler) {
        this.c = cameraOrchestrator;
        this.a = job;
        this.b = workerHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CameraOrchestrator.LOG.i(this.a.name.toUpperCase(), "- Executing.");
            Task<T> call = this.a.scheduler.call();
            WorkerHandler workerHandler = this.b;
            a aVar = new a();
            if (call.isComplete()) {
                workerHandler.run(new c(aVar, call));
            } else {
                call.addOnCompleteListener(workerHandler.getExecutor(), aVar);
            }
        } catch (Exception e) {
            CameraOrchestrator.LOG.i(this.a.name.toUpperCase(), "- Finished with ERROR.", e);
            CameraOrchestrator.Job job = this.a;
            if (job.dispatchExceptions) {
                this.c.mCallback.handleJobException(job.name, e);
            }
            this.a.source.trySetException(e);
            synchronized (this.c.mJobsLock) {
                CameraOrchestrator.a(this.c, this.a);
            }
        }
    }
}
