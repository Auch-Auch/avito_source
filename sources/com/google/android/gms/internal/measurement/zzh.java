package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@TargetApi(24)
public final class zzh {
    @Nullable
    private static final Method zzb = zza();
    @Nullable
    private static final Method zzc = zzb();
    private final JobScheduler zza;

    private zzh(JobScheduler jobScheduler) {
        this.zza = jobScheduler;
    }

    @Nullable
    private static Method zza() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            Log.isLoggable("JobSchedulerCompat", 6);
            return null;
        }
    }

    @Nullable
    private static Method zzb() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return null;
    }

    private static int zzc() {
        Method method = zzc;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return 0;
    }

    private final int zza(JobInfo jobInfo, String str, int i, String str2) {
        Method method = zzb;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.zza, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return this.zza.schedule(jobInfo);
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (zzb == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new zzh(jobScheduler).zza(jobInfo, str, zzc(), str2);
    }
}
