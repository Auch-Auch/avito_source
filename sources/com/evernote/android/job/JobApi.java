package com.evernote.android.job;

import a2.f.a.a.a;
import a2.f.a.a.h;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import com.evernote.android.job.gcm.JobProxyGcm;
import com.evernote.android.job.v14.JobProxy14;
import com.evernote.android.job.v14.PlatformAlarmReceiver;
import com.evernote.android.job.v14.PlatformAlarmService;
import com.evernote.android.job.v14.PlatformAlarmServiceExact;
import com.evernote.android.job.v19.JobProxy19;
import com.evernote.android.job.v21.JobProxy21;
import com.evernote.android.job.v21.PlatformJobService;
import com.evernote.android.job.v24.JobProxy24;
import com.evernote.android.job.v26.JobProxy26;
import com.evernote.android.job.work.JobProxyWorkManager;
import java.util.List;
public enum JobApi {
    WORK_MANAGER(true, false, true),
    V_26(true, false, true),
    V_24(true, false, false),
    V_21(true, true, false),
    V_19(true, true, true),
    V_14(false, true, true),
    GCM(true, false, true);
    
    public volatile JobProxy a;
    public final boolean b;
    public final boolean c;

    /* access modifiers changed from: public */
    JobApi(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
    }

    public static boolean e(@NonNull Context context, @NonNull Class<? extends Service> cls, @NonNull String str) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, cls), 0);
            if (queryIntentServices != null) {
                if (!queryIntentServices.isEmpty()) {
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        if (serviceInfo != null && str.equals(serviceInfo.permission)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @NonNull
    public static JobApi getDefault(Context context) {
        JobApi jobApi = WORK_MANAGER;
        if (jobApi.isSupported(context) && JobConfig.isApiEnabled(jobApi)) {
            return jobApi;
        }
        JobApi jobApi2 = V_26;
        if (jobApi2.isSupported(context) && JobConfig.isApiEnabled(jobApi2)) {
            return jobApi2;
        }
        JobApi jobApi3 = V_24;
        if (jobApi3.isSupported(context) && JobConfig.isApiEnabled(jobApi3)) {
            return jobApi3;
        }
        JobApi jobApi4 = V_21;
        if (jobApi4.isSupported(context) && JobConfig.isApiEnabled(jobApi4)) {
            return jobApi4;
        }
        JobApi jobApi5 = GCM;
        if (jobApi5.isSupported(context) && JobConfig.isApiEnabled(jobApi5)) {
            return jobApi5;
        }
        JobApi jobApi6 = V_19;
        if (jobApi6.isSupported(context) && JobConfig.isApiEnabled(jobApi6)) {
            return jobApi6;
        }
        JobApi jobApi7 = V_14;
        if (JobConfig.isApiEnabled(jobApi7)) {
            return jobApi7;
        }
        throw new IllegalStateException("All supported APIs are disabled");
    }

    @NonNull
    public final JobProxy a(Context context) {
        switch (ordinal()) {
            case 0:
                return new JobProxyWorkManager(context);
            case 1:
                return new JobProxy26(context);
            case 2:
                return new JobProxy24(context);
            case 3:
                return new JobProxy21(context);
            case 4:
                return new JobProxy19(context);
            case 5:
                return new JobProxy14(context);
            case 6:
                return new JobProxyGcm(context);
            default:
                throw new IllegalStateException("not implemented");
        }
    }

    @NonNull
    public synchronized JobProxy b(Context context) {
        if (this.a == null) {
            this.a = a(context);
        }
        return this.a;
    }

    public final boolean c(@NonNull Context context, @NonNull Class<? extends BroadcastReceiver> cls) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(@NonNull Context context, @NonNull Class<? extends Service> cls) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, cls), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void invalidateCachedProxy() {
        this.a = null;
    }

    public boolean isSupported(Context context) {
        switch (ordinal()) {
            case 0:
                return h.a;
            case 1:
                if (Build.VERSION.SDK_INT < 26 || !d(context, PlatformJobService.class)) {
                    return false;
                }
                return true;
            case 2:
                if (Build.VERSION.SDK_INT < 24 || !e(context, PlatformJobService.class, "android.permission.BIND_JOB_SERVICE")) {
                    return false;
                }
                return true;
            case 3:
                if (e(context, PlatformJobService.class, "android.permission.BIND_JOB_SERVICE")) {
                    return true;
                }
                return false;
            case 4:
                if (!d(context, PlatformAlarmService.class) || !c(context, PlatformAlarmReceiver.class)) {
                    return false;
                }
                return true;
            case 5:
                if (JobConfig.isForceAllowApi14()) {
                    return true;
                }
                if (!d(context, PlatformAlarmService.class) || !d(context, PlatformAlarmServiceExact.class) || !c(context, PlatformAlarmReceiver.class)) {
                    return false;
                }
                return true;
            case 6:
                try {
                    return a.c(context);
                } catch (Exception unused) {
                    return false;
                }
            default:
                throw new IllegalStateException("not implemented");
        }
    }
}
