package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
public final class zzavy implements zzqu {
    private final Object lock;
    private String zzbuo;
    private final Context zzcle;
    private boolean zzdwp;

    public zzavy(Context context, String str) {
        this.zzcle = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbuo = str;
        this.zzdwp = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbuo;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqr) {
        zzam(zzqr.zzbrk);
    }

    public final void zzam(boolean z) {
        if (zzp.zzln().zzac(this.zzcle)) {
            synchronized (this.lock) {
                if (this.zzdwp != z) {
                    this.zzdwp = z;
                    if (!TextUtils.isEmpty(this.zzbuo)) {
                        if (this.zzdwp) {
                            zzp.zzln().zzf(this.zzcle, this.zzbuo);
                        } else {
                            zzp.zzln().zzg(this.zzcle, this.zzbuo);
                        }
                    }
                }
            }
        }
    }
}
