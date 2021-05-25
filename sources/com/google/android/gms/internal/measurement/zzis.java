package com.google.android.gms.internal.measurement;
public class zzis {
    private static final zzho zza = zzho.zza();
    private zzgt zzb;
    private volatile zzjj zzc;
    private volatile zzgt zzd;

    private final zzjj zzb(zzjj zzjj) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjj;
                        this.zzd = zzgt.zza;
                    } catch (zzij unused) {
                        this.zzc = zzjj;
                        this.zzd = zzgt.zza;
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
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzis = (zzis) obj;
        zzjj zzjj = this.zzc;
        zzjj zzjj2 = zzis.zzc;
        if (zzjj == null && zzjj2 == null) {
            return zzc().equals(zzis.zzc());
        }
        if (zzjj != null && zzjj2 != null) {
            return zzjj.equals(zzjj2);
        }
        if (zzjj != null) {
            return zzjj.equals(zzis.zzb(zzjj.h_()));
        }
        return zzb(zzjj2.h_()).equals(zzjj2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjj zza(zzjj zzjj) {
        zzjj zzjj2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjj;
        return zzjj2;
    }

    public final zzgt zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzgt.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            return this.zzd;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbm();
        }
        return 0;
    }
}
