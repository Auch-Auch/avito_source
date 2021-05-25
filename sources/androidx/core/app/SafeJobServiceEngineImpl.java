package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import androidx.core.app.JobIntentService;
@RequiresApi(26)
public class SafeJobServiceEngineImpl extends JobServiceEngine implements JobIntentService.b {
    public final JobIntentService a;
    public final Object b = new Object();
    public JobParameters c;

    public final class a implements JobIntentService.e {
        public final JobWorkItem a;

        public a(JobWorkItem jobWorkItem) {
            this.a = jobWorkItem;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void complete() {
            synchronized (SafeJobServiceEngineImpl.this.b) {
                JobParameters jobParameters = SafeJobServiceEngineImpl.this.c;
                if (jobParameters != null) {
                    try {
                        jobParameters.completeWork(this.a);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.a.getIntent();
        }
    }

    public SafeJobServiceEngineImpl(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.a = jobIntentService;
    }

    @Override // androidx.core.app.JobIntentService.b
    public IBinder compatGetBinder() {
        return getBinder();
    }

    @Override // androidx.core.app.JobIntentService.b
    public JobIntentService.e dequeueWork() {
        JobWorkItem jobWorkItem;
        synchronized (this.b) {
            JobParameters jobParameters = this.c;
            if (jobParameters == null) {
                return null;
            }
            try {
                jobWorkItem = jobParameters.dequeueWork();
            } catch (SecurityException e) {
                e.printStackTrace();
                jobWorkItem = null;
            }
        }
        if (jobWorkItem == null) {
            return null;
        }
        jobWorkItem.getIntent().setExtrasClassLoader(this.a.getClassLoader());
        return new a(jobWorkItem);
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStartJob(JobParameters jobParameters) {
        this.c = jobParameters;
        this.a.c(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStopJob(JobParameters jobParameters) {
        boolean b2 = this.a.b();
        synchronized (this.b) {
            this.c = null;
        }
        return b2;
    }
}
