package com.google.android.gms.internal.mlkit_vision_face;
public class zzgu {
    private static final zzfr zza = zzfr.zza();
    private zzez zzb;
    private volatile zzhl zzc;
    private volatile zzez zzd;

    private final zzhl zzb(zzhl zzhl) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzhl;
                        this.zzd = zzez.zza;
                    } catch (zzgl unused) {
                        this.zzc = zzhl;
                        this.zzd = zzez.zza;
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
        if (!(obj instanceof zzgu)) {
            return false;
        }
        zzgu zzgu = (zzgu) obj;
        zzhl zzhl = this.zzc;
        zzhl zzhl2 = zzgu.zzc;
        if (zzhl == null && zzhl2 == null) {
            return zzc().equals(zzgu.zzc());
        }
        if (zzhl != null && zzhl2 != null) {
            return zzhl.equals(zzhl2);
        }
        if (zzhl != null) {
            return zzhl.equals(zzgu.zzb(zzhl.zzi()));
        }
        return zzb(zzhl2.zzi()).equals(zzhl2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzhl zza(zzhl zzhl) {
        zzhl zzhl2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhl;
        return zzhl2;
    }

    public final zzez zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzez.zza;
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
