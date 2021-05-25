package com.evernote.android.job.v14;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobProxy14 implements JobProxy {
    public AlarmManager a;
    public final JobCat mCat;
    public final Context mContext;

    public JobProxy14(Context context) {
        this(context, "JobProxy14");
    }

    public final void a(JobRequest jobRequest) {
        this.mCat.d("Scheduled alarm, %s, delay %s (from now), exact %b, reschedule count %d", jobRequest, JobUtil.timeToString(JobProxy.Common.getAverageDelayMs(jobRequest)), Boolean.valueOf(jobRequest.isExact()), Integer.valueOf(JobProxy.Common.getRescheduleCount(jobRequest)));
    }

    @Override // com.evernote.android.job.JobProxy
    public void cancel(int i) {
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager != null) {
            try {
                alarmManager.cancel(getPendingIntent(i, false, null, createPendingIntentFlags(true)));
                alarmManager.cancel(getPendingIntent(i, false, null, createPendingIntentFlags(false)));
            } catch (Exception e) {
                this.mCat.e(e);
            }
        }
    }

    public int createPendingIntentFlags(boolean z) {
        return !z ? 1207959552 : 134217728;
    }

    @Nullable
    public AlarmManager getAlarmManager() {
        if (this.a == null) {
            this.a = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.a == null) {
            this.mCat.e("AlarmManager is null");
        }
        return this.a;
    }

    public PendingIntent getPendingIntent(JobRequest jobRequest, boolean z) {
        return getPendingIntent(jobRequest, createPendingIntentFlags(z));
    }

    public long getTriggerAtMillis(JobRequest jobRequest) {
        long elapsedRealtime;
        long averageDelayMs;
        if (JobConfig.isForceRtc()) {
            elapsedRealtime = JobConfig.getClock().currentTimeMillis();
            averageDelayMs = JobProxy.Common.getAverageDelayMs(jobRequest);
        } else {
            elapsedRealtime = JobConfig.getClock().elapsedRealtime();
            averageDelayMs = JobProxy.Common.getAverageDelayMs(jobRequest);
        }
        return averageDelayMs + elapsedRealtime;
    }

    public int getType(boolean z) {
        return z ? JobConfig.isForceRtc() ? 0 : 2 : JobConfig.isForceRtc() ? 1 : 3;
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean isPlatformJobScheduled(JobRequest jobRequest) {
        return getPendingIntent(jobRequest, 536870912) != null;
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantOneOff(JobRequest jobRequest) {
        PendingIntent pendingIntent = getPendingIntent(jobRequest, false);
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager != null) {
            try {
                if (!jobRequest.isExact()) {
                    plantOneOffInexact(jobRequest, alarmManager, pendingIntent);
                } else if (jobRequest.getStartMs() != 1 || jobRequest.getFailureCount() > 0) {
                    plantOneOffExact(jobRequest, alarmManager, pendingIntent);
                } else {
                    PlatformAlarmService.start(this.mContext, jobRequest.getJobId(), jobRequest.getTransientExtras());
                }
            } catch (Exception e) {
                this.mCat.e(e);
            }
        }
    }

    public void plantOneOffExact(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        long triggerAtMillis = getTriggerAtMillis(jobRequest);
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(getType(true), triggerAtMillis, pendingIntent);
        } else {
            alarmManager.setExact(getType(true), triggerAtMillis, pendingIntent);
        }
        a(jobRequest);
    }

    public void plantOneOffFlexSupport(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.set(1, JobProxy.Common.getAverageDelayMsSupportFlex(jobRequest) + JobConfig.getClock().currentTimeMillis(), pendingIntent);
        this.mCat.d("Scheduled repeating alarm (flex support), %s, interval %s, flex %s", jobRequest, JobUtil.timeToString(jobRequest.getIntervalMs()), JobUtil.timeToString(jobRequest.getFlexMs()));
    }

    public void plantOneOffInexact(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.set(getType(false), getTriggerAtMillis(jobRequest), pendingIntent);
        a(jobRequest);
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodic(JobRequest jobRequest) {
        PendingIntent pendingIntent = getPendingIntent(jobRequest, true);
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager != null) {
            alarmManager.setRepeating(getType(true), getTriggerAtMillis(jobRequest), jobRequest.getIntervalMs(), pendingIntent);
        }
        this.mCat.d("Scheduled repeating alarm, %s, interval %s", jobRequest, JobUtil.timeToString(jobRequest.getIntervalMs()));
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodicFlexSupport(JobRequest jobRequest) {
        PendingIntent pendingIntent = getPendingIntent(jobRequest, false);
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager != null) {
            try {
                plantOneOffFlexSupport(jobRequest, alarmManager, pendingIntent);
            } catch (Exception e) {
                this.mCat.e(e);
            }
        }
    }

    public JobProxy14(Context context, String str) {
        this.mContext = context;
        this.mCat = new JobCat(str);
    }

    public PendingIntent getPendingIntent(JobRequest jobRequest, int i) {
        return getPendingIntent(jobRequest.getJobId(), jobRequest.isExact(), jobRequest.getTransientExtras(), i);
    }

    public PendingIntent getPendingIntent(int i, boolean z, @Nullable Bundle bundle, int i2) {
        Context context = this.mContext;
        int i3 = PlatformAlarmReceiver.a;
        Intent putExtra = new Intent(context, PlatformAlarmReceiver.class).putExtra("EXTRA_JOB_ID", i).putExtra("EXTRA_JOB_EXACT", z);
        if (bundle != null) {
            putExtra.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        try {
            return PendingIntent.getBroadcast(this.mContext, i, putExtra, i2);
        } catch (Exception e) {
            this.mCat.e(e);
            return null;
        }
    }
}
