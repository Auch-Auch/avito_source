package com.evernote.android.job.gcm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobProxyGcm implements JobProxy {
    public static final JobCat c = new JobCat("JobProxyGcm");
    public final Context a;
    public final GcmNetworkManager b;

    public JobProxyGcm(Context context) {
        this.a = context;
        this.b = GcmNetworkManager.getInstance(context);
    }

    public final void a(Task task) {
        try {
            this.b.schedule(task);
        } catch (IllegalArgumentException e) {
            if (e.getMessage() == null || !e.getMessage().startsWith("The GcmTaskService class you provided")) {
                throw e;
            }
            throw new JobProxyIllegalStateException(e);
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void cancel(int i) {
        try {
            this.b.cancelTask(createTag(i), PlatformGcmService.class);
        } catch (IllegalArgumentException e) {
            if (e.getMessage() == null || !e.getMessage().startsWith("The GcmTaskService class you provided")) {
                throw e;
            }
            throw new JobProxyIllegalStateException(e);
        }
    }

    public int convertNetworkType(@NonNull JobRequest.NetworkType networkType) {
        int ordinal = networkType.ordinal();
        if (ordinal == 0) {
            return 2;
        }
        if (ordinal == 1) {
            return 0;
        }
        if (ordinal == 2 || ordinal == 3) {
            return 1;
        }
        throw new IllegalStateException("not implemented");
    }

    public String createTag(JobRequest jobRequest) {
        return createTag(jobRequest.getJobId());
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean isPlatformJobScheduled(JobRequest jobRequest) {
        return true;
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantOneOff(JobRequest jobRequest) {
        long startMs = JobProxy.Common.getStartMs(jobRequest);
        long j = startMs / 1000;
        long endMs = JobProxy.Common.getEndMs(jobRequest);
        a(prepareBuilder(new OneoffTask.Builder(), jobRequest).setExecutionWindow(j, Math.max(endMs / 1000, 1 + j)).build());
        c.d("Scheduled OneoffTask, %s, start %s, end %s (from now), reschedule count %d", jobRequest, JobUtil.timeToString(startMs), JobUtil.timeToString(endMs), Integer.valueOf(JobProxy.Common.getRescheduleCount(jobRequest)));
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodic(JobRequest jobRequest) {
        a(prepareBuilder(new PeriodicTask.Builder(), jobRequest).setPeriod(jobRequest.getIntervalMs() / 1000).setFlex(jobRequest.getFlexMs() / 1000).build());
        c.d("Scheduled PeriodicTask, %s, interval %s, flex %s", jobRequest, JobUtil.timeToString(jobRequest.getIntervalMs()), JobUtil.timeToString(jobRequest.getFlexMs()));
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodicFlexSupport(JobRequest jobRequest) {
        JobCat jobCat = c;
        jobCat.w("plantPeriodicFlexSupport called although flex is supported");
        long startMsSupportFlex = JobProxy.Common.getStartMsSupportFlex(jobRequest);
        long endMsSupportFlex = JobProxy.Common.getEndMsSupportFlex(jobRequest);
        a(prepareBuilder(new OneoffTask.Builder(), jobRequest).setExecutionWindow(startMsSupportFlex / 1000, endMsSupportFlex / 1000).build());
        jobCat.d("Scheduled periodic (flex support), %s, start %s, end %s, flex %s", jobRequest, JobUtil.timeToString(startMsSupportFlex), JobUtil.timeToString(endMsSupportFlex), JobUtil.timeToString(jobRequest.getFlexMs()));
    }

    public <T extends Task.Builder> T prepareBuilder(T t, JobRequest jobRequest) {
        t.setTag(createTag(jobRequest)).setService(PlatformGcmService.class).setUpdateCurrent(true).setRequiredNetwork(convertNetworkType(jobRequest.requiredNetworkType())).setPersisted(JobUtil.hasBootPermission(this.a)).setRequiresCharging(jobRequest.requiresCharging()).setExtras(jobRequest.getTransientExtras());
        return t;
    }

    public String createTag(int i) {
        return String.valueOf(i);
    }
}
