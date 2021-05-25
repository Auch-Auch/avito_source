package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
public final class zzfr extends zzgm {
    public zzfr(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 24);
    }

    private final void zzcz() {
        AdvertisingIdClient zzcs = this.zzwg.zzcs();
        if (zzcs != null) {
            try {
                AdvertisingIdClient.Info info = zzcs.getInfo();
                String zzar = zzfg.zzar(info.getId());
                if (zzar != null) {
                    synchronized (this.zzabc) {
                        this.zzabc.zzac(zzar);
                        this.zzabc.zza(info.isLimitAdTrackingEnabled());
                        this.zzabc.zza(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwg.zzck()) {
            zzcz();
            return;
        }
        synchronized (this.zzabc) {
            this.zzabc.zzac((String) this.zzabm.invoke(null, this.zzwg.getContext()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    /* renamed from: zzcy */
    public final Void call() throws Exception {
        if (this.zzwg.isInitialized()) {
            return super.call();
        }
        if (!this.zzwg.zzck()) {
            return null;
        }
        zzcz();
        return null;
    }
}
