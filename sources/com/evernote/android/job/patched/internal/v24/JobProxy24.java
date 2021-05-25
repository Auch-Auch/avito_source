package com.evernote.android.job.patched.internal.v24;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.v21.JobProxy21;
@TargetApi(24)
public class JobProxy24 extends JobProxy21 {
    public JobProxy24(Context context) {
        this(context, "JobProxy24");
    }

    @Override // com.evernote.android.job.patched.internal.v21.JobProxy21
    public int convertNetworkType(@NonNull JobRequest.NetworkType networkType) {
        if (networkType.ordinal() != 3) {
            return super.convertNetworkType(networkType);
        }
        return 3;
    }

    @Override // com.evernote.android.job.patched.internal.v21.JobProxy21
    public JobInfo.Builder createBuilderPeriodic(JobInfo.Builder builder, long j, long j2) {
        return builder.setPeriodic(j, j2);
    }

    @Override // com.evernote.android.job.patched.internal.v21.JobProxy21, com.evernote.android.job.patched.internal.JobProxy
    public boolean isPlatformJobScheduled(JobRequest jobRequest) {
        try {
            return isJobInfoScheduled(getJobScheduler().getPendingJob(jobRequest.getJobId()), jobRequest);
        } catch (Exception e) {
            this.mCat.e(e);
            return false;
        }
    }

    @Override // com.evernote.android.job.patched.internal.v21.JobProxy21, com.evernote.android.job.patched.internal.JobProxy
    public void plantPeriodicFlexSupport(JobRequest jobRequest) {
        this.mCat.w("plantPeriodicFlexSupport called although flex is supported");
        super.plantPeriodicFlexSupport(jobRequest);
    }

    public JobProxy24(Context context, String str) {
        super(context, str);
    }
}
