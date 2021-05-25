package com.google.android.gms.internal.mlkit_common;
public class zzgg {
    private static final zzfh zza = zzfh.zza();
    private zzep zzb;
    private volatile zzhb zzc;
    private volatile zzep zzd;

    private final zzhb zzb(zzhb zzhb) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzhb;
                        this.zzd = zzep.zza;
                    } catch (zzgb unused) {
                        this.zzc = zzhb;
                        this.zzd = zzep.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgg)) {
            return false;
        }
        zzgg zzgg = (zzgg) obj;
        zzhb zzhb = this.zzc;
        zzhb zzhb2 = zzgg.zzc;
        if (zzhb == null && zzhb2 == null) {
            return zzc().equals(zzgg.zzc());
        }
        if (zzhb != null && zzhb2 != null) {
            return zzhb.equals(zzhb2);
        }
        if (zzhb != null) {
            return zzhb.equals(zzgg.zzb(zzhb.zzn()));
        }
        return zzb(zzhb2.zzn()).equals(zzhb2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzhb zza(zzhb zzhb) {
        zzhb zzhb2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhb;
        return zzhb2;
    }

    public final zzep zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzep.zza;
            } else {
                this.zzd = this.zzc.zze();
            }
            return this.zzd;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzj();
        }
        return 0;
    }
}
