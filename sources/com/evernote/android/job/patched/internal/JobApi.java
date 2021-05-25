package com.evernote.android.job.patched.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import com.evernote.android.job.patched.internal.v14.JobProxy14;
import com.evernote.android.job.patched.internal.v14.PlatformAlarmReceiver;
import com.evernote.android.job.patched.internal.v14.PlatformAlarmService;
import com.evernote.android.job.patched.internal.v14.PlatformAlarmServiceExact;
import com.evernote.android.job.patched.internal.v19.JobProxy19;
import com.evernote.android.job.patched.internal.v21.JobProxy21;
import com.evernote.android.job.patched.internal.v21.PlatformJobService;
import com.evernote.android.job.patched.internal.v24.JobProxy24;
import com.evernote.android.job.patched.internal.v26.JobProxy26;
import java.util.List;
public enum JobApi {
    V_26(true, false, true),
    V_24(true, false, false),
    V_21(true, true, false),
    V_19(true, true, true),
    V_14(false, true, true);
    
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
        JobApi jobApi = V_26;
        if (jobApi.isSupported(context) && JobConfig.isApiEnabled(jobApi)) {
            return jobApi;
        }
        JobApi jobApi2 = V_24;
        if (jobApi2.isSupported(context) && JobConfig.isApiEnabled(jobApi2)) {
            return jobApi2;
        }
        JobApi jobApi3 = V_21;
        if (jobApi3.isSupported(context) && JobConfig.isApiEnabled(jobApi3)) {
            return jobApi3;
        }
        JobApi jobApi4 = V_19;
        if (jobApi4.isSupported(context) && JobConfig.isApiEnabled(jobApi4)) {
            return jobApi4;
        }
        JobApi jobApi5 = V_14;
        if (JobConfig.isApiEnabled(jobApi5)) {
            return jobApi5;
        }
        throw new IllegalStateException("All supported APIs are disabled");
    }

    @NonNull
    public final JobProxy a(Context context) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return new JobProxy26(context);
        }
        if (ordinal == 1) {
            return new JobProxy24(context);
        }
        if (ordinal == 2) {
            return new JobProxy21(context);
        }
        if (ordinal == 3) {
            return new JobProxy19(context);
        }
        if (ordinal == 4) {
            return new JobProxy14(context);
        }
        throw new IllegalStateException("not implemented");
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
        int ordinal = ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            throw new IllegalStateException("not implemented");
                        } else if (JobConfig.isForceAllowApi14() || (d(context, PlatformAlarmService.class) && d(context, PlatformAlarmServiceExact.class) && c(context, PlatformAlarmReceiver.class))) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (!d(context, PlatformAlarmService.class) || !c(context, PlatformAlarmReceiver.class)) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (e(context, PlatformJobService.class, "android.permission.BIND_JOB_SERVICE")) {
                    return true;
                } else {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT < 24 || !e(context, PlatformJobService.class, "android.permission.BIND_JOB_SERVICE")) {
                return false;
            } else {
                return true;
            }
        } else if (Build.VERSION.SDK_INT < 26 || !d(context, PlatformJobService.class)) {
            return false;
        } else {
            return true;
        }
    }
}
