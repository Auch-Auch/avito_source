package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;
public final class zzcr implements zzcm {
    @GuardedBy("GservicesLoader.class")
    private static zzcr zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzcr(Context context) {
        this.zzb = context;
        zzct zzct = new zzct(this, null);
        this.zzc = zzct;
        context.getContentResolver().registerContentObserver(zzcf.zza, true, zzct);
    }

    public static zzcr zza(Context context) {
        zzcr zzcr;
        synchronized (zzcr.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcr(context) : new zzcr();
            }
            zzcr = zza;
        }
        return zzcr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcp.zza(new zzco(this, str) { // from class: com.google.android.gms.internal.measurement.zzcq
                private final zzcr zza;
                private final String zzb;

                {
                    this.zza = r1;
                    this.zzb = r2;
                }

                @Override // com.google.android.gms.internal.measurement.zzco
                public final Object zza() {
                    return this.zza.zzb(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
            } else {
                new String("Unable to read GServices for: ");
            }
            return null;
        }
    }

    public final /* synthetic */ String zzb(String str) {
        return zzcf.zza(this.zzb.getContentResolver(), str, (String) null);
    }

    private zzcr() {
        this.zzb = null;
        this.zzc = null;
    }

    public static synchronized void zza() {
        Context context;
        synchronized (zzcr.class) {
            zzcr zzcr = zza;
            if (!(zzcr == null || (context = zzcr.zzb) == null || zzcr.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }
}
