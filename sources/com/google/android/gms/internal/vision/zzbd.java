package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;
public final class zzbd implements zzay {
    @GuardedBy("GservicesLoader.class")
    private static zzbd zzgb;
    @Nullable
    private final ContentObserver zzfr;
    @Nullable
    private final Context zzg;

    private zzbd(Context context) {
        this.zzg = context;
        zzbf zzbf = new zzbf(this, null);
        this.zzfr = zzbf;
        context.getContentResolver().registerContentObserver(zzaq.CONTENT_URI, true, zzbf);
    }

    public static synchronized void zzae() {
        Context context;
        synchronized (zzbd.class) {
            zzbd zzbd = zzgb;
            if (!(zzbd == null || (context = zzbd.zzg) == null || zzbd.zzfr == null)) {
                context.getContentResolver().unregisterContentObserver(zzgb.zzfr);
            }
            zzgb = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zzb(String str) {
        if (this.zzg == null) {
            return null;
        }
        try {
            return (String) zzbb.zza(new zzba(this, str) { // from class: com.google.android.gms.internal.vision.zzbc
                private final zzbd zzfz;
                private final String zzga;

                {
                    this.zzfz = r1;
                    this.zzga = r2;
                }

                @Override // com.google.android.gms.internal.vision.zzba
                public final Object zzac() {
                    return this.zzfz.zzd(this.zzga);
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

    public static zzbd zze(Context context) {
        zzbd zzbd;
        synchronized (zzbd.class) {
            if (zzgb == null) {
                zzgb = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzbd(context) : new zzbd();
            }
            zzbd = zzgb;
        }
        return zzbd;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzaq.zza(this.zzg.getContentResolver(), str, (String) null);
    }

    private zzbd() {
        this.zzg = null;
        this.zzfr = null;
    }
}
