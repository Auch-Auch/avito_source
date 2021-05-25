package com.google.android.gms.internal.mlkit_vision_common;
public class zzfa {
    private static final zzdx zza = zzdx.zza();
    private zzdf zzb;
    private volatile zzfr zzc;
    private volatile zzdf zzd;

    private final zzfr zzb(zzfr zzfr) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzfr;
                        this.zzd = zzdf.zza;
                    } catch (zzer unused) {
                        this.zzc = zzfr;
                        this.zzd = zzdf.zza;
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
        if (!(obj instanceof zzfa)) {
            return false;
        }
        zzfa zzfa = (zzfa) obj;
        zzfr zzfr = this.zzc;
        zzfr zzfr2 = zzfa.zzc;
        if (zzfr == null && zzfr2 == null) {
            return zzc().equals(zzfa.zzc());
        }
        if (zzfr != null && zzfr2 != null) {
            return zzfr.equals(zzfr2);
        }
        if (zzfr != null) {
            return zzfr.equals(zzfa.zzb(zzfr.zzi()));
        }
        return zzb(zzfr2.zzi()).equals(zzfr2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfr zza(zzfr zzfr) {
        zzfr zzfr2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzfr;
        return zzfr2;
    }

    public final zzdf zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzdf.zza;
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
