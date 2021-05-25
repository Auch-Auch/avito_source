package com.evernote.android.job.v26;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.v24.JobProxy24;
@TargetApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobProxy26 extends JobProxy24 {
    public JobProxy26(Context context) {
        super(context, "JobProxy26");
    }

    @Override // com.evernote.android.job.v24.JobProxy24, com.evernote.android.job.v21.JobProxy21
    public int convertNetworkType(@NonNull JobRequest.NetworkType networkType) {
        if (networkType.ordinal() != 4) {
            return super.convertNetworkType(networkType);
        }
        if (Build.VERSION.SDK_INT >= 28) {
        }
        return 4;
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    public JobInfo.Builder createBaseBuilder(JobRequest jobRequest, boolean z) {
        return super.createBaseBuilder(jobRequest, z).setRequiresBatteryNotLow(jobRequest.requiresBatteryNotLow()).setRequiresStorageNotLow(jobRequest.requiresStorageNotLow());
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    public boolean isJobInfoScheduled(@Nullable JobInfo jobInfo, @NonNull JobRequest jobRequest) {
        return jobInfo != null && jobInfo.getId() == jobRequest.getJobId();
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    public JobInfo.Builder setTransientBundle(JobRequest jobRequest, JobInfo.Builder builder) {
        return builder.setTransientExtras(jobRequest.getTransientExtras());
    }

    public JobProxy26(Context context, String str) {
        super(context, str);
    }
}
