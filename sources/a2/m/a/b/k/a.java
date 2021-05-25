package a2.m.a.b.k;

import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.util.Iterator;
public class a implements Runnable {
    public final /* synthetic */ CameraOrchestrator a;

    public a(CameraOrchestrator cameraOrchestrator) {
        this.a = cameraOrchestrator;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraOrchestrator.Job<?> job;
        synchronized (this.a.mJobsLock) {
            job = null;
            if (!this.a.mJobRunning) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<CameraOrchestrator.Job<?>> it = this.a.mJobs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CameraOrchestrator.Job<?> next = it.next();
                    if (next.startTime <= currentTimeMillis) {
                        job = next;
                        break;
                    }
                }
                if (job != null) {
                    this.a.mJobRunning = true;
                }
            }
        }
        if (job != null) {
            CameraOrchestrator cameraOrchestrator = this.a;
            WorkerHandler jobWorker = cameraOrchestrator.mCallback.getJobWorker(job.name);
            jobWorker.run(new b(cameraOrchestrator, job, jobWorker));
        }
    }
}
