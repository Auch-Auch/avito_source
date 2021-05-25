package com.evernote.android.job.v21;

import a2.f.a.a.k.a;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
import com.evernote.android.job.v14.PlatformAlarmServiceExact;
import java.util.List;
import java.util.concurrent.TimeUnit;
@TargetApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobProxy21 implements JobProxy {
    public final JobCat mCat;
    public final Context mContext;

    public JobProxy21(Context context) {
        this(context, "JobProxy21");
    }

    public static String scheduleResultToString(int i) {
        return i == 1 ? "success" : PublicConstantsKt.FAILURE;
    }

    @Override // com.evernote.android.job.JobProxy
    public void cancel(int i) {
        try {
            getJobScheduler().cancel(i);
        } catch (Exception e) {
            this.mCat.e(e);
        }
        a.a(this.mContext, i, null);
    }

    public int convertNetworkType(@NonNull JobRequest.NetworkType networkType) {
        int ordinal = networkType.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        if (ordinal == 1) {
            return 1;
        }
        if (ordinal == 2 || ordinal == 3) {
            return 2;
        }
        if (ordinal == 4) {
            return 1;
        }
        throw new IllegalStateException("not implemented");
    }

    public JobInfo.Builder createBaseBuilder(JobRequest jobRequest, boolean z) {
        return setTransientBundle(jobRequest, new JobInfo.Builder(jobRequest.getJobId(), new ComponentName(this.mContext, PlatformJobService.class)).setRequiresCharging(jobRequest.requiresCharging()).setRequiresDeviceIdle(jobRequest.requiresDeviceIdle()).setRequiredNetworkType(convertNetworkType(jobRequest.requiredNetworkType())).setPersisted(z && !jobRequest.isTransient() && JobUtil.hasBootPermission(this.mContext)));
    }

    public JobInfo.Builder createBuilderOneOff(JobInfo.Builder builder, long j, long j2) {
        return builder.setMinimumLatency(j).setOverrideDeadline(j2);
    }

    public JobInfo.Builder createBuilderPeriodic(JobInfo.Builder builder, long j, long j2) {
        return builder.setPeriodic(j);
    }

    public final JobScheduler getJobScheduler() {
        return (JobScheduler) this.mContext.getSystemService("jobscheduler");
    }

    public boolean isJobInfoScheduled(@Nullable JobInfo jobInfo, @NonNull JobRequest jobRequest) {
        if (!(jobInfo != null && jobInfo.getId() == jobRequest.getJobId())) {
            return false;
        }
        if (!jobRequest.isTransient()) {
            return true;
        }
        Context context = this.mContext;
        int jobId = jobRequest.getJobId();
        JobCat jobCat = a.a;
        if (PendingIntent.getService(context, jobId, PlatformAlarmServiceExact.createIntent(context, jobId, null), 536870912) != null) {
            return true;
        }
        return false;
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean isPlatformJobScheduled(JobRequest jobRequest) {
        try {
            List<JobInfo> allPendingJobs = getJobScheduler().getAllPendingJobs();
            if (allPendingJobs != null && !allPendingJobs.isEmpty()) {
                for (JobInfo jobInfo : allPendingJobs) {
                    if (isJobInfoScheduled(jobInfo, jobRequest)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            this.mCat.e(e);
            return false;
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantOneOff(JobRequest jobRequest) {
        long startMs = JobProxy.Common.getStartMs(jobRequest);
        long endMs = JobProxy.Common.getEndMs(jobRequest, true);
        int schedule = schedule(createBuilderOneOff(createBaseBuilder(jobRequest, true), startMs, endMs).build());
        if (schedule == -123) {
            schedule = schedule(createBuilderOneOff(createBaseBuilder(jobRequest, false), startMs, endMs).build());
        }
        this.mCat.d("Schedule one-off jobInfo %s, %s, start %s, end %s (from now), reschedule count %d", scheduleResultToString(schedule), jobRequest, JobUtil.timeToString(startMs), JobUtil.timeToString(JobProxy.Common.getEndMs(jobRequest, false)), Integer.valueOf(JobProxy.Common.getRescheduleCount(jobRequest)));
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodic(JobRequest jobRequest) {
        long intervalMs = jobRequest.getIntervalMs();
        long flexMs = jobRequest.getFlexMs();
        int schedule = schedule(createBuilderPeriodic(createBaseBuilder(jobRequest, true), intervalMs, flexMs).build());
        if (schedule == -123) {
            schedule = schedule(createBuilderPeriodic(createBaseBuilder(jobRequest, false), intervalMs, flexMs).build());
        }
        this.mCat.d("Schedule periodic jobInfo %s, %s, interval %s, flex %s", scheduleResultToString(schedule), jobRequest, JobUtil.timeToString(intervalMs), JobUtil.timeToString(flexMs));
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodicFlexSupport(JobRequest jobRequest) {
        long startMsSupportFlex = JobProxy.Common.getStartMsSupportFlex(jobRequest);
        long endMsSupportFlex = JobProxy.Common.getEndMsSupportFlex(jobRequest);
        int schedule = schedule(createBuilderOneOff(createBaseBuilder(jobRequest, true), startMsSupportFlex, endMsSupportFlex).build());
        if (schedule == -123) {
            schedule = schedule(createBuilderOneOff(createBaseBuilder(jobRequest, false), startMsSupportFlex, endMsSupportFlex).build());
        }
        this.mCat.d("Schedule periodic (flex support) jobInfo %s, %s, start %s, end %s, flex %s", scheduleResultToString(schedule), jobRequest, JobUtil.timeToString(startMsSupportFlex), JobUtil.timeToString(endMsSupportFlex), JobUtil.timeToString(jobRequest.getFlexMs()));
    }

    public final int schedule(JobInfo jobInfo) {
        JobScheduler jobScheduler = getJobScheduler();
        if (jobScheduler != null) {
            try {
                return jobScheduler.schedule(jobInfo);
            } catch (IllegalArgumentException e) {
                this.mCat.e(e);
                String message = e.getMessage();
                if (message != null && message.contains("RECEIVE_BOOT_COMPLETED")) {
                    return -123;
                }
                if (message == null || !message.contains("No such service ComponentInfo")) {
                    throw e;
                }
                throw new JobProxyIllegalStateException(e);
            } catch (NullPointerException e2) {
                this.mCat.e(e2);
                throw new JobProxyIllegalStateException(e2);
            }
        } else {
            throw new JobProxyIllegalStateException("JobScheduler is null");
        }
    }

    public JobInfo.Builder setTransientBundle(JobRequest jobRequest, JobInfo.Builder builder) {
        if (jobRequest.isTransient()) {
            Context context = this.mContext;
            JobCat jobCat = a.a;
            PendingIntent service = PendingIntent.getService(context, jobRequest.getJobId(), PlatformAlarmServiceExact.createIntent(context, jobRequest.getJobId(), jobRequest.getTransientExtras()), 134217728);
            long currentTimeMillis = System.currentTimeMillis();
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setExact(1, TimeUnit.DAYS.toMillis(1000) + currentTimeMillis, service);
        }
        return builder;
    }

    public JobProxy21(Context context, String str) {
        this.mContext = context;
        this.mCat = new JobCat(str);
    }
}
