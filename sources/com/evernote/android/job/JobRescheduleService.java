package com.evernote.android.job;

import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.SafeJobIntentService;
import com.evernote.android.job.util.JobCat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class JobRescheduleService extends SafeJobIntentService {
    public static final JobCat j = new JobCat("JobRescheduleService", false);
    @VisibleForTesting
    public static CountDownLatch k;

    public int f(JobManager jobManager, Collection<JobRequest> collection) {
        boolean z;
        int i = 0;
        boolean z2 = false;
        for (JobRequest jobRequest : collection) {
            if (jobRequest.d) {
                z = jobManager.getJob(jobRequest.getJobId()) == null;
            } else {
                z = !jobManager.e(jobRequest.c()).isPlatformJobScheduled(jobRequest);
            }
            if (z) {
                try {
                    jobRequest.cancelAndEdit().build().schedule();
                } catch (Exception e) {
                    if (!z2) {
                        j.e(e);
                        z2 = true;
                    }
                }
                i++;
            }
        }
        return i;
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NonNull Intent intent) {
        CountDownLatch countDownLatch;
        try {
            JobCat jobCat = j;
            jobCat.d("Reschedule service started");
            SystemClock.sleep(JobConfig.getJobReschedulePause());
            try {
                JobManager create = JobManager.create(this);
                Set<JobRequest> d = create.d(null, true, true);
                jobCat.d("Reschedule %d jobs of %d jobs", Integer.valueOf(f(create, d)), Integer.valueOf(((HashSet) d).size()));
            } catch (Exception unused) {
                if (k != null) {
                    k.countDown();
                }
            }
        } finally {
            countDownLatch = k;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
