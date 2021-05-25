package com.google.android.gms.internal.vision;
public class zzis {
    private static final zzho zzth = zzho.zzgf();
    private zzgs zzzn;
    private volatile zzjn zzzo;
    private volatile zzgs zzzp;

    private final zzjn zzh(zzjn zzjn) {
        if (this.zzzo == null) {
            synchronized (this) {
                if (this.zzzo == null) {
                    try {
                        this.zzzo = zzjn;
                        this.zzzp = zzgs.zztt;
                    } catch (zzin unused) {
                        this.zzzo = zzjn;
                        this.zzzp = zzgs.zztt;
                    }
                }
            }
        }
        return this.zzzo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzis = (zzis) obj;
        zzjn zzjn = this.zzzo;
        zzjn zzjn2 = zzis.zzzo;
        if (zzjn == null && zzjn2 == null) {
            return zzee().equals(zzis.zzee());
        }
        if (zzjn != null && zzjn2 != null) {
            return zzjn.equals(zzjn2);
        }
        if (zzjn != null) {
            return zzjn.equals(zzis.zzh(zzjn.zzgx()));
        }
        return zzh(zzjn2.zzgx()).equals(zzjn2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzgs zzee() {
        if (this.zzzp != null) {
            return this.zzzp;
        }
        synchronized (this) {
            if (this.zzzp != null) {
                return this.zzzp;
            }
            if (this.zzzo == null) {
                this.zzzp = zzgs.zztt;
            } else {
                this.zzzp = this.zzzo.zzee();
            }
            return this.zzzp;
        }
    }

    public final int zzgz() {
        if (this.zzzp != null) {
            return this.zzzp.size();
        }
        if (this.zzzo != null) {
            return this.zzzo.zzgz();
        }
        return 0;
    }

    public final zzjn zzi(zzjn zzjn) {
        zzjn zzjn2 = this.zzzo;
        this.zzzn = null;
        this.zzzp = null;
        this.zzzo = zzjn;
        return zzjn2;
    }
}
