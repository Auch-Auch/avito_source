package com.google.android.gms.internal.ads;
public class zzehi {
    private static final zzegc zziar = zzegc.zzbex();
    private zzeff zzihi;
    private volatile zzehz zzihj;
    private volatile zzeff zzihk;

    private final zzehz zzm(zzehz zzehz) {
        if (this.zzihj == null) {
            synchronized (this) {
                if (this.zzihj == null) {
                    try {
                        this.zzihj = zzehz;
                        this.zzihk = zzeff.zzibd;
                    } catch (zzegz unused) {
                        this.zzihj = zzehz;
                        this.zzihk = zzeff.zzibd;
                    }
                }
            }
        }
        return this.zzihj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzehi)) {
            return false;
        }
        zzehi zzehi = (zzehi) obj;
        zzehz zzehz = this.zzihj;
        zzehz zzehz2 = zzehi.zzihj;
        if (zzehz == null && zzehz2 == null) {
            return zzbda().equals(zzehi.zzbda());
        }
        if (zzehz != null && zzehz2 != null) {
            return zzehz.equals(zzehz2);
        }
        if (zzehz != null) {
            return zzehz.equals(zzehi.zzm(zzehz.zzbfr()));
        }
        return zzm(zzehz2.zzbfr()).equals(zzehz2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeff zzbda() {
        if (this.zzihk != null) {
            return this.zzihk;
        }
        synchronized (this) {
            if (this.zzihk != null) {
                return this.zzihk;
            }
            if (this.zzihj == null) {
                this.zzihk = zzeff.zzibd;
            } else {
                this.zzihk = this.zzihj.zzbda();
            }
            return this.zzihk;
        }
    }

    public final int zzbfl() {
        if (this.zzihk != null) {
            return this.zzihk.size();
        }
        if (this.zzihj != null) {
            return this.zzihj.zzbfl();
        }
        return 0;
    }

    public final zzehz zzn(zzehz zzehz) {
        zzehz zzehz2 = this.zzihj;
        this.zzihi = null;
        this.zzihk = null;
        this.zzihj = zzehz;
        return zzehz2;
    }
}
