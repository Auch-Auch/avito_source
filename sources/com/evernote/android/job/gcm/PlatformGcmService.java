package com.evernote.android.job.gcm;

import androidx.annotation.RestrictTo;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobManagerCreateException;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PlatformGcmService extends GcmTaskService {
    public static final JobCat a = new JobCat("PlatformGcmService");

    public void onInitializeTasks() {
        PlatformGcmService.super.onInitializeTasks();
        try {
            JobManager.create(getApplicationContext());
        } catch (JobManagerCreateException unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.evernote.android.job.gcm.PlatformGcmService */
    /* JADX WARN: Multi-variable type inference failed */
    public int onRunTask(TaskParams taskParams) {
        JobProxy.Common common = new JobProxy.Common(this, a, Integer.parseInt(taskParams.getTag()));
        JobRequest pendingRequest = common.getPendingRequest(true, true);
        if (pendingRequest == null) {
            return 2;
        }
        if (Job.Result.SUCCESS.equals(common.executeJobRequest(pendingRequest, taskParams.getExtras()))) {
            return 0;
        }
        return 2;
    }
}
