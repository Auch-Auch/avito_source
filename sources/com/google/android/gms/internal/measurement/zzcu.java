package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
public final class zzcu {
    private static volatile zzdr<Boolean> zza = zzdr.zzc();
    private static final Object zzb = new Object();

    private static boolean zza(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zza(Context context, Uri uri) {
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            String.valueOf(authority).length();
            return false;
        } else if (zza.zza()) {
            return zza.zzb().booleanValue();
        } else {
            synchronized (zzb) {
                if (zza.zza()) {
                    return zza.zzb().booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z = false;
                        if (z && zza(context)) {
                            z2 = true;
                        }
                        zza = zzdr.zza(Boolean.valueOf(z2));
                        return zza.zzb().booleanValue();
                    }
                }
                z = true;
                z2 = true;
                zza = zzdr.zza(Boolean.valueOf(z2));
                return zza.zzb().booleanValue();
            }
        }
    }
}
