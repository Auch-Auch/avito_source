package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
public class zzcmt extends Exception {
    private final int zzggv;

    public zzcmt(int i) {
        this.zzggv = i;
    }

    public static zzuw zze(Throwable th) {
        if (th instanceof zzcmt) {
            return ((zzcmt) th).zzapd();
        }
        if (!(th instanceof zzazk)) {
            return zzdmb.zza(zzdmd.zzhco, null, null);
        }
        zzazk zzazk = (zzazk) th;
        return new zzuw(zzazk.getErrorCode(), zzdsw.zzhi(zzazk.getMessage()), MobileAds.ERROR_DOMAIN, null);
    }

    public final zzuw zzapd() {
        if (getMessage() == null) {
            return zzdmb.zza(this.zzggv, null, null);
        }
        return zzdmb.zza(this.zzggv, getMessage(), null);
    }

    public zzcmt(int i, String str) {
        super(str);
        this.zzggv = i;
    }

    public zzcmt(int i, String str, Throwable th) {
        super(str, th);
        this.zzggv = i;
    }
}
