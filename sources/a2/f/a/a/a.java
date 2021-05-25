package a2.f.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.JobApi;
import com.evernote.android.job.gcm.JobProxyGcm;
import com.evernote.android.job.util.JobCat;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class a {
    public static final JobCat a = new JobCat("GcmAvailableHelper");
    public static final boolean b;
    public static int c = -1;
    public static boolean d;

    static {
        boolean z;
        try {
            Class.forName("com.google.android.gms.gcm.GcmNetworkManager");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        b = z;
    }

    public static String a() {
        return JobProxyGcm.class.getPackage().getName() + ".PlatformGcmService";
    }

    public static boolean b(List<ResolveInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (ResolveInfo resolveInfo : list) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE".equals(serviceInfo.permission) && resolveInfo.serviceInfo.exported) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        try {
            if (!d) {
                d = true;
                boolean z = b;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    ComponentName componentName = new ComponentName(context, a());
                    int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
                    if (componentEnabledSetting != 0) {
                        if (componentEnabledSetting != 1) {
                            if (componentEnabledSetting != 2) {
                            }
                        } else if (!z) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                            a.i("GCM service disabled");
                        }
                    }
                    if (z) {
                        packageManager.setComponentEnabledSetting(componentName, 1, 1);
                        a.i("GCM service enabled");
                    }
                } catch (Throwable unused) {
                }
            }
            if (b && GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0 && d(context) == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static int d(Context context) {
        if (c < 0) {
            synchronized (JobApi.class) {
                if (c < 0) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context, a()));
                    if (!b(context.getPackageManager().queryIntentServices(intent, 0))) {
                        c = 1;
                        return 1;
                    }
                    Intent intent2 = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
                    intent2.setPackage(context.getPackageName());
                    if (!b(context.getPackageManager().queryIntentServices(intent2, 0))) {
                        c = 1;
                        return 1;
                    }
                    c = 0;
                }
            }
        }
        return c;
    }
}
