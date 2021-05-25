package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
@CheckReturnValue
public final class zzc {
    private static volatile zzr zza;
    private static final Object zzb = new Object();
    private static Context zzc;

    public static synchronized void zza(Context context) {
        synchronized (zzc.class) {
            if (zzc == null && context != null) {
                zzc = context.getApplicationContext();
            }
        }
    }

    private static zzl zzb(String str, zzd zzd, boolean z, boolean z2) {
        try {
            if (zza == null) {
                Preconditions.checkNotNull(zzc);
                synchronized (zzb) {
                    if (zza == null) {
                        zza = zzq.zza(DynamiteModule.load(zzc, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(zzc);
            try {
                if (zza.zza(new zzj(str, zzd, z, z2), ObjectWrapper.wrap(zzc.getPackageManager()))) {
                    return zzl.zza();
                }
                return zzl.zza(new Callable(z, str, zzd) { // from class: com.google.android.gms.common.zze
                    private final boolean zza;
                    private final String zzb;
                    private final zzd zzc;

                    {
                        this.zza = r1;
                        this.zzb = r2;
                        this.zzc = r3;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzc.zza(this.zza, this.zzb, this.zzc);
                    }
                });
            } catch (RemoteException e) {
                return zzl.zza("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            return zzl.zza(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }

    public static zzl zza(String str, zzd zzd, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzb(str, zzd, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static final /* synthetic */ String zza(boolean z, String str, zzd zzd) throws Exception {
        boolean z2 = true;
        if (z || !zzb(str, zzd, true, false).zza) {
            z2 = false;
        }
        return zzl.zza(str, zzd, z, z2);
    }
}
