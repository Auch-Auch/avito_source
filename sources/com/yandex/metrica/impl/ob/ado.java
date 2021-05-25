package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class ado {
    @Nullable
    public PackageInfo a(Context context, String str) {
        return a(context, str, 0);
    }

    @NonNull
    public List<ResolveInfo> b(@NonNull Context context, Intent intent, int i) {
        try {
            return context.getPackageManager().queryIntentServices(intent, i);
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    @Nullable
    public ResolveInfo c(@NonNull Context context, Intent intent, int i) {
        try {
            return context.getPackageManager().resolveService(intent, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public ResolveInfo d(@NonNull Context context, @NonNull Intent intent, int i) {
        try {
            return context.getPackageManager().resolveActivity(intent, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public PackageInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public List<ResolveInfo> a(@NonNull Context context, Intent intent, int i) {
        try {
            return context.getPackageManager().queryIntentActivities(intent, i);
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    @Nullable
    public ApplicationInfo b(@NonNull Context context, String str, int i) {
        try {
            return context.getPackageManager().getApplicationInfo(str, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b(@NonNull Context context, @NonNull String str) {
        try {
            return context.getPackageManager().hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @NonNull
    public List<PackageInfo> a(@NonNull Context context, int i) {
        try {
            return context.getPackageManager().getInstalledPackages(i);
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public void a(@NonNull Context context, ComponentName componentName, int i, int i2) {
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, i, i2);
        } catch (Throwable unused) {
        }
    }
}
