package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
public final class zzbeq extends zzaxu {
    public final zzbde zzefm;
    private final String zzefy;
    private final String[] zzefz;
    public final zzbev zzekp;

    public zzbeq(zzbde zzbde, zzbev zzbev, String str, String[] strArr) {
        this.zzefm = zzbde;
        this.zzekp = zzbev;
        this.zzefy = str;
        this.zzefz = strArr;
        zzp.zzll().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaxu
    public final void zzuy() {
        try {
            this.zzekp.zze(this.zzefy, this.zzefz);
        } finally {
            zzayh.zzeaj.post(new zzbet(this));
        }
    }
}
