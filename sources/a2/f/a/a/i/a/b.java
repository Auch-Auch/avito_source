package a2.f.a.a.i.a;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.LruCache;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.JobConfig;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.JobCat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public class b {
    public static final JobCat e = new JobCat("JobExecutor");
    public static final long f = TimeUnit.MINUTES.toMillis(3);
    public final SparseArray<Job> a = new SparseArray<>();
    public final LruCache<Integer, WeakReference<Job>> b = new LruCache<>(20);
    public final SparseArray<Job.Result> c = new SparseArray<>();
    public final Set<JobRequest> d = new HashSet();

    /* renamed from: a2.f.a.a.i.a.b$b  reason: collision with other inner class name */
    public final class CallableC0023b implements Callable<Job.Result> {
        public final Job a;
        public final PowerManager.WakeLock b;

        public CallableC0023b(Job job, a aVar) {
            this.a = job;
            this.b = f.a(job.getContext(), "JobExecutor", b.f);
        }

        public final void a(Job job, Job.Result result) {
            JobRequest jobRequest = this.a.getParams().a;
            boolean z = false;
            boolean z2 = true;
            if (!jobRequest.isPeriodic() && Job.Result.RESCHEDULE.equals(result) && !job.isDeleted()) {
                jobRequest = jobRequest.d(true, true);
                this.a.onReschedule(jobRequest.getJobId());
            } else if (!jobRequest.isPeriodic()) {
                z2 = false;
            } else if (!Job.Result.SUCCESS.equals(result)) {
                z = true;
            }
            if (job.isDeleted()) {
                return;
            }
            if (z || z2) {
                jobRequest.f(z, z2);
            }
        }

        public final Job.Result b() {
            try {
                Job.Result runJob = this.a.runJob();
                b.e.i("Finished %s", this.a);
                a(this.a, runJob);
                return runJob;
            } catch (Throwable th) {
                b.e.e(th, "Crashed %s", this.a);
                return this.a.getResult();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Job.Result call() throws Exception {
            try {
                f.b(this.a.getContext(), this.b, b.f);
                Job.Result b2 = b();
                b.this.c(this.a);
                PowerManager.WakeLock wakeLock = this.b;
                if (wakeLock == null || !wakeLock.isHeld()) {
                    b.e.w("Wake lock was not held after job %s was done. The job took too long to complete. This could have unintended side effects on your app.", this.a);
                }
                f.c(this.b);
                return b2;
            } catch (Throwable th) {
                b.this.c(this.a);
                PowerManager.WakeLock wakeLock2 = this.b;
                if (wakeLock2 == null || !wakeLock2.isHeld()) {
                    b.e.w("Wake lock was not held after job %s was done. The job took too long to complete. This could have unintended side effects on your app.", this.a);
                }
                f.c(this.b);
                throw th;
            }
        }
    }

    public synchronized Future<Job.Result> a(@NonNull Context context, @NonNull JobRequest jobRequest, @Nullable Job job, @NonNull Bundle bundle) {
        this.d.remove(jobRequest);
        if (job == null) {
            e.w("JobCreator returned null for tag %s", jobRequest.getTag());
            return null;
        } else if (!job.isFinished()) {
            job.setContext(context).setRequest(jobRequest, bundle);
            e.i("Executing %s, context %s", jobRequest, context.getClass().getSimpleName());
            this.a.put(jobRequest.getJobId(), job);
            return JobConfig.getExecutorService().submit(new CallableC0023b(job, null));
        } else {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "Job for tag %s was already run, a creator should always create a new Job instance", jobRequest.getTag()));
        }
    }

    public synchronized Set<Job> b(String str) {
        HashSet hashSet;
        hashSet = new HashSet();
        for (int i = 0; i < this.a.size(); i++) {
            Job valueAt = this.a.valueAt(i);
            if (str == null || str.equals(valueAt.getParams().getTag())) {
                hashSet.add(valueAt);
            }
        }
        for (WeakReference<Job> weakReference : this.b.snapshot().values()) {
            Job job = weakReference.get();
            if (job != null) {
                if (str == null || str.equals(job.getParams().getTag())) {
                    hashSet.add(job);
                }
            }
        }
        return hashSet;
    }

    @VisibleForTesting
    public synchronized void c(Job job) {
        int id = job.getParams().getId();
        this.a.remove(id);
        LruCache<Integer, WeakReference<Job>> lruCache = this.b;
        HashMap hashMap = new HashMap(lruCache.snapshot());
        for (Integer num : hashMap.keySet()) {
            if (hashMap.get(num) == null || ((WeakReference) hashMap.get(num)).get() == null) {
                lruCache.remove(num);
            }
        }
        this.c.put(id, job.getResult());
        this.b.put(Integer.valueOf(id), new WeakReference<>(job));
    }
}
