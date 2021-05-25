package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
@KeepForSdk
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    @Nullable
    private static final Method zzb = zza();
    @Nullable
    private static final Method zzc = zzb();
    @Nullable
    private static final Method zzd = zzc();
    @Nullable
    private static final Method zze = zzd();
    @Nullable
    private static final Method zzf = zze();
    @Nullable
    private static final Method zzg = zzf();
    @Nullable
    private static final Method zzh = zzg();

    private WorkSourceUtil() {
    }

    @RecentlyNullable
    @KeepForSdk
    public static WorkSource fromPackage(@RecentlyNonNull Context context, @Nullable String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo != null) {
                    return zza(applicationInfo.uid, str);
                }
                if (str.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(str);
                } else {
                    new String("Could not get applicationInfo from package: ");
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                if (str.length() != 0) {
                    "Could not find package: ".concat(str);
                } else {
                    new String("Could not find package: ");
                }
            }
        }
        return null;
    }

    @RecentlyNullable
    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        Method method;
        WorkSource workSource = null;
        if (!(context == null || context.getPackageManager() == null || str2 == null || str == null)) {
            int zza2 = zza(context, str);
            if (zza2 < 0) {
                return null;
            }
            workSource = new WorkSource();
            Method method2 = zzg;
            if (method2 == null || (method = zzh) == null) {
                zza(workSource, zza2, str);
            } else {
                try {
                    Object invoke = method2.invoke(workSource, new Object[0]);
                    int i = zza;
                    if (zza2 != i) {
                        method.invoke(invoke, Integer.valueOf(zza2), str);
                    }
                    method.invoke(invoke, Integer.valueOf(i), str2);
                } catch (Exception unused) {
                }
            }
        }
        return workSource;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static List<String> getNames(@Nullable WorkSource workSource) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i = 0;
        } else {
            i = zza(workSource);
        }
        if (i == 0) {
            return arrayList;
        }
        for (int i2 = 0; i2 < i; i2++) {
            String zza2 = zza(workSource, i2);
            if (!Strings.isEmptyOrWhitespace(zza2)) {
                arrayList.add((String) Preconditions.checkNotNull(zza2));
            }
        }
        return arrayList;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean hasWorkSourcePermission(@RecentlyNonNull Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    private static WorkSource zza(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    @Nullable
    private static Method zzb() {
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return WorkSource.class.getMethod(ProductAction.ACTION_ADD, Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Nullable
    private static Method zzc() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static Method zzd() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static Method zze() {
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Nullable
    private static final Method zzf() {
        if (PlatformVersion.isAtLeastP()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Nullable
    @SuppressLint({"PrivateApi"})
    private static final Method zzg() {
        if (PlatformVersion.isAtLeastP()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void zza(WorkSource workSource, int i, @Nullable String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i), str);
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, Integer.valueOf(i));
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }

    private static int zza(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                return ((Integer) Preconditions.checkNotNull(method.invoke(workSource, new Object[0]))).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    @Nullable
    private static String zza(@Nullable WorkSource workSource, int i) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    private static int zza(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Could not get applicationInfo from package: ".concat(valueOf);
            } else {
                new String("Could not get applicationInfo from package: ");
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "Could not find package: ".concat(valueOf2);
            } else {
                new String("Could not find package: ");
            }
            return -1;
        }
    }

    @Nullable
    private static Method zza() {
        try {
            return WorkSource.class.getMethod(ProductAction.ACTION_ADD, Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }
}
