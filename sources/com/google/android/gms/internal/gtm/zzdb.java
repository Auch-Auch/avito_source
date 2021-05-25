package com.google.android.gms.internal.gtm;

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
public final class zzdb {
    @Nullable
    private static final Method zzacz = zzgk();
    @Nullable
    private static final Method zzada = zzgl();
    private static volatile zzdd zzadb = zzdc.zzadc;
    private final JobScheduler zzacy;

    private zzdb(JobScheduler jobScheduler) {
        this.zzacy = jobScheduler;
    }

    private final int zza(JobInfo jobInfo, String str, int i, String str2) {
        Method method = zzacz;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.zzacy, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return this.zzacy.schedule(jobInfo);
    }

    @Nullable
    private static Method zzgk() {
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
    private static Method zzgl() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return null;
    }

    private static int zzgm() {
        Method method = zzada;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return 0;
    }

    public static final /* synthetic */ boolean zzgn() {
        return false;
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (zzacz == null || !zzadb.zzgo() || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new zzdb(jobScheduler).zza(jobInfo, str, zzgm(), str2);
    }
}
