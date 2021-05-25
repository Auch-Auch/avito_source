package com.evernote.android.job.patched.internal.v19;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.evernote.android.job.patched.internal.JobProxy;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.JobUtil;
import com.evernote.android.job.patched.internal.v14.JobProxy14;
@TargetApi(19)
public class JobProxy19 extends JobProxy14 {
    public JobProxy19(Context context) {
        super(context, "JobProxy19");
    }

    @Override // com.evernote.android.job.patched.internal.v14.JobProxy14
    public void plantOneOffFlexSupport(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.setWindow(1, JobProxy.Common.getStartMsSupportFlex(jobRequest) + System.currentTimeMillis(), JobProxy.Common.getEndMsSupportFlex(jobRequest) - JobProxy.Common.getStartMsSupportFlex(jobRequest), pendingIntent);
        this.mCat.d("Scheduled repeating alarm (flex support), %s, start %s, end %s, flex %s", jobRequest, JobUtil.timeToString(JobProxy.Common.getStartMsSupportFlex(jobRequest)), JobUtil.timeToString(JobProxy.Common.getEndMsSupportFlex(jobRequest)), JobUtil.timeToString(jobRequest.getFlexMs()));
    }

    @Override // com.evernote.android.job.patched.internal.v14.JobProxy14
    public void plantOneOffInexact(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.setWindow(1, JobProxy.Common.getStartMs(jobRequest) + System.currentTimeMillis(), JobProxy.Common.getEndMs(jobRequest) - JobProxy.Common.getStartMs(jobRequest), pendingIntent);
        this.mCat.d("Schedule alarm, %s, start %s, end %s", jobRequest, JobUtil.timeToString(JobProxy.Common.getStartMs(jobRequest)), JobUtil.timeToString(JobProxy.Common.getEndMs(jobRequest)));
    }
}
