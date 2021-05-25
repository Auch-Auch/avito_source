package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.JobIntentService;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class FixedJobIntentService extends JobIntentService {

    @RequiresApi(26)
    public static final class a extends JobServiceEngine implements JobIntentService.b {
        public final JobIntentService a;
        public final Object b = new Object();
        public JobParameters c;

        /* renamed from: androidx.core.app.FixedJobIntentService$a$a  reason: collision with other inner class name */
        public final class C0109a implements JobIntentService.e {
            public final JobWorkItem a;

            public C0109a(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void complete() {
                synchronized (a.this.b) {
                    JobParameters jobParameters = a.this.c;
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

        public a(JobIntentService jobIntentService) {
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
            return new C0109a(jobWorkItem);
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

    @Override // androidx.core.app.JobIntentService
    public JobIntentService.e a() {
        try {
            return super.a();
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new a(this);
        }
    }
}
