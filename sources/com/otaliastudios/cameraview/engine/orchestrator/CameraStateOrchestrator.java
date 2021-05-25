package com.otaliastudios.cameraview.engine.orchestrator;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import java.util.Iterator;
import java.util.concurrent.Callable;
public class CameraStateOrchestrator extends CameraOrchestrator {
    public CameraState a;
    public CameraState b;
    public int c = 0;

    public class a implements OnCompleteListener<T> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<T> task) {
            int i = this.a;
            CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
            if (i == cameraStateOrchestrator.c) {
                cameraStateOrchestrator.b = cameraStateOrchestrator.a;
            }
        }
    }

    public class b implements Callable<Task<T>> {
        public final /* synthetic */ CameraState a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CameraState c;
        public final /* synthetic */ Callable d;
        public final /* synthetic */ boolean e;

        public b(CameraState cameraState, String str, CameraState cameraState2, Callable callable, boolean z) {
            this.a = cameraState;
            this.b = str;
            this.c = cameraState2;
            this.d = callable;
            this.e = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            if (CameraStateOrchestrator.this.getCurrentState() == this.a) {
                return ((Task) this.d.call()).continueWithTask(CameraStateOrchestrator.this.mCallback.getJobWorker(this.b).getExecutor(), new a2.m.a.b.k.d(this));
            }
            CameraOrchestrator.LOG.w(this.b.toUpperCase(), "- State mismatch, aborting. current:", CameraStateOrchestrator.this.getCurrentState(), "from:", this.a, "to:", this.c);
            return Tasks.forCanceled();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ CameraState a;
        public final /* synthetic */ Runnable b;

        public c(CameraState cameraState, Runnable runnable) {
            this.a = cameraState;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraStateOrchestrator.this.getCurrentState().isAtLeast(this.a)) {
                this.b.run();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ CameraState a;
        public final /* synthetic */ Runnable b;

        public d(CameraState cameraState, Runnable runnable) {
            this.a = cameraState;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraStateOrchestrator.this.getCurrentState().isAtLeast(this.a)) {
                this.b.run();
            }
        }
    }

    public CameraStateOrchestrator(@NonNull CameraOrchestrator.Callback callback) {
        super(callback);
        CameraState cameraState = CameraState.OFF;
        this.a = cameraState;
        this.b = cameraState;
    }

    @NonNull
    public CameraState getCurrentState() {
        return this.a;
    }

    @NonNull
    public CameraState getTargetState() {
        return this.b;
    }

    public boolean hasPendingStateChange() {
        synchronized (this.mJobsLock) {
            Iterator<CameraOrchestrator.Job<?>> it = this.mJobs.iterator();
            while (it.hasNext()) {
                CameraOrchestrator.Job<?> next = it.next();
                if (next.name.contains(" >> ") || next.name.contains(" << ")) {
                    if (!next.source.getTask().isComplete()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @NonNull
    public <T> Task<T> scheduleStateChange(@NonNull CameraState cameraState, @NonNull CameraState cameraState2, boolean z, @NonNull Callable<Task<T>> callable) {
        StringBuilder sb;
        String str;
        int i = this.c + 1;
        this.c = i;
        this.b = cameraState2;
        boolean z2 = !cameraState2.isAtLeast(cameraState);
        if (z2) {
            sb.append(cameraState.name());
            sb.append(" << ");
            sb.append(cameraState2.name());
            str = sb.toString();
        } else {
            sb = new StringBuilder();
            sb.append(cameraState.name());
            sb.append(" >> ");
            sb.append(cameraState2.name());
            str = sb.toString();
        }
        return schedule(str, z, new b(cameraState, str, cameraState2, callable, z2)).addOnCompleteListener(new a(i));
    }

    @NonNull
    public Task<Void> scheduleStateful(@NonNull String str, @NonNull CameraState cameraState, @NonNull Runnable runnable) {
        return schedule(str, true, (Runnable) new c(cameraState, runnable));
    }

    public void scheduleStatefulDelayed(@NonNull String str, @NonNull CameraState cameraState, long j, @NonNull Runnable runnable) {
        scheduleDelayed(str, true, j, new d(cameraState, runnable));
    }
}
