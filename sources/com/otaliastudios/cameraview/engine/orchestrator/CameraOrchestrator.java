package com.otaliastudios.cameraview.engine.orchestrator;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
public class CameraOrchestrator {
    public static final CameraLogger LOG = CameraLogger.create(CameraOrchestrator.class.getSimpleName());
    public static final String TAG = "CameraOrchestrator";
    public final Callback mCallback;
    public boolean mJobRunning = false;
    public final ArrayDeque<Job<?>> mJobs = new ArrayDeque<>();
    public final Object mJobsLock = new Object();

    public interface Callback {
        @NonNull
        WorkerHandler getJobWorker(@NonNull String str);

        void handleJobException(@NonNull String str, @NonNull Exception exc);
    }

    public static class Job<T> {
        public final boolean dispatchExceptions;
        public final String name;
        public final Callable<Task<T>> scheduler;
        public final TaskCompletionSource<T> source = new TaskCompletionSource<>();
        public final long startTime;

        public Job(String str, Callable callable, boolean z, long j, a aVar) {
            this.name = str;
            this.scheduler = callable;
            this.dispatchExceptions = z;
            this.startTime = j;
        }
    }

    public class a implements Callable<Task<Void>> {
        public final /* synthetic */ Runnable a;

        public a(CameraOrchestrator cameraOrchestrator, Runnable runnable) {
            this.a = runnable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            this.a.run();
            return Tasks.forResult(null);
        }
    }

    public CameraOrchestrator(@NonNull Callback callback) {
        this.mCallback = callback;
    }

    public static void a(CameraOrchestrator cameraOrchestrator, Job job) {
        if (cameraOrchestrator.mJobRunning) {
            cameraOrchestrator.mJobRunning = false;
            cameraOrchestrator.mJobs.remove(job);
            cameraOrchestrator.mCallback.getJobWorker("_sync").post(0, new a2.m.a.b.k.a(cameraOrchestrator));
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("mJobRunning was not true after completing job=");
        L.append(job.name);
        throw new IllegalStateException(L.toString());
    }

    @NonNull
    public final <T> Task<T> b(@NonNull String str, boolean z, long j, @NonNull Callable<Task<T>> callable) {
        LOG.i(str.toUpperCase(), "- Scheduling.");
        Job<?> job = new Job<>(str, callable, z, System.currentTimeMillis() + j, null);
        synchronized (this.mJobsLock) {
            this.mJobs.addLast(job);
            this.mCallback.getJobWorker("_sync").post(j, new a2.m.a.b.k.a(this));
        }
        return job.source.getTask();
    }

    public void remove(@NonNull String str) {
        trim(str, 0);
    }

    public void reset() {
        synchronized (this.mJobsLock) {
            HashSet hashSet = new HashSet();
            Iterator<Job<?>> it = this.mJobs.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().name);
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                remove((String) it2.next());
            }
        }
    }

    @NonNull
    public Task<Void> schedule(@NonNull String str, boolean z, @NonNull Runnable runnable) {
        return scheduleDelayed(str, z, 0, runnable);
    }

    @NonNull
    public Task<Void> scheduleDelayed(@NonNull String str, boolean z, long j, @NonNull Runnable runnable) {
        return b(str, z, j, new a(this, runnable));
    }

    public void trim(@NonNull String str, int i) {
        synchronized (this.mJobsLock) {
            ArrayList arrayList = new ArrayList();
            Iterator<Job<?>> it = this.mJobs.iterator();
            while (it.hasNext()) {
                Job<?> next = it.next();
                if (next.name.equals(str)) {
                    arrayList.add(next);
                }
            }
            LOG.v("trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int max = Math.max(arrayList.size() - i, 0);
            if (max > 0) {
                Collections.reverse(arrayList);
                for (Job job : arrayList.subList(0, max)) {
                    this.mJobs.remove(job);
                }
            }
        }
    }

    @NonNull
    public <T> Task<T> schedule(@NonNull String str, boolean z, @NonNull Callable<Task<T>> callable) {
        return b(str, z, 0, callable);
    }
}
