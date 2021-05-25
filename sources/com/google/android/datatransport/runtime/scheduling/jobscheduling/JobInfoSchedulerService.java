package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.facebook.applinks.AppLinkData;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.firebase.messaging.Constants;
@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int a = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(AppLinkData.ARGUMENTS_EXTRAS_KEY);
        int i = jobParameters.getExtras().getInt(Constants.FirelogAnalytics.PARAM_PRIORITY);
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder priority = TransportContext.builder().setBackendName(string).setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            priority.setExtras(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(priority.build(), i2, new Runnable(this, jobParameters) { // from class: a2.j.b.a.c.m.c.d
            public final JobInfoSchedulerService a;
            public final JobParameters b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JobInfoSchedulerService jobInfoSchedulerService = this.a;
                JobParameters jobParameters2 = this.b;
                int i3 = JobInfoSchedulerService.a;
                jobInfoSchedulerService.jobFinished(jobParameters2, false);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
