package com.evernote.android.job.patched.internal.v21;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Bundle;
import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.JobConfig;
import com.evernote.android.job.patched.internal.JobManager;
import com.evernote.android.job.patched.internal.JobProxy;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.JobCat;
import java.util.Objects;
@TargetApi(21)
public class PlatformJobService extends JobService {
    public static final JobCat a = new JobCat("PlatformJobService");

    public class a implements Runnable {
        public final /* synthetic */ JobParameters a;

        public a(JobParameters jobParameters) {
            this.a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            boolean z = false;
            try {
                int jobId = this.a.getJobId();
                PlatformJobService platformJobService = PlatformJobService.this;
                JobCat jobCat = PlatformJobService.a;
                JobProxy.Common common = new JobProxy.Common(platformJobService, jobCat, jobId);
                JobRequest pendingRequest = common.getPendingRequest(true, false);
                if (pendingRequest != null) {
                    if (pendingRequest.isTransient()) {
                        if (a2.f.a.a.i.a.h.a.b(PlatformJobService.this, pendingRequest)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                jobCat.d("PendingIntent for transient bundle is not null although running on O, using compat mode, request %s", pendingRequest);
                            }
                        } else if (Build.VERSION.SDK_INT < 26) {
                            jobCat.d("PendingIntent for transient job %s expired", pendingRequest);
                        }
                    }
                    common.markStarting(pendingRequest);
                    PlatformJobService platformJobService2 = PlatformJobService.this;
                    JobParameters jobParameters = this.a;
                    Objects.requireNonNull(platformJobService2);
                    if (Build.VERSION.SDK_INT >= 26) {
                        bundle = jobParameters.getTransientExtras();
                    } else {
                        bundle = Bundle.EMPTY;
                    }
                    common.executeJobRequest(pendingRequest, bundle);
                    PlatformJobService.this.jobFinished(this.a, false);
                }
            } finally {
                PlatformJobService.this.jobFinished(this.a, z);
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        JobConfig.getExecutorService().execute(new a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Job job = JobManager.create(this).getJob(jobParameters.getJobId());
        if (job != null) {
            job.cancel();
            a.d("Called onStopJob for %s", job);
        } else {
            a.d("Called onStopJob, job %d not found", Integer.valueOf(jobParameters.getJobId()));
        }
        return false;
    }
}
