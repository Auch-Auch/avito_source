package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzgq extends zzegp<zzgq, zza> implements zzeib {
    private static final zzgq zzacb;
    private static volatile zzeim<zzgq> zzel;
    private zzgr zzaby;
    private zzeff zzabz;
    private zzeff zzaca;
    private int zzdw;

    public static final class zza extends zzegp.zzb<zzgq, zza> implements zzeib {
        private zza() {
            super(zzgq.zzacb);
        }

        public /* synthetic */ zza(zzgp zzgp) {
            this();
        }
    }

    static {
        zzgq zzgq = new zzgq();
        zzacb = zzgq;
        zzegp.zza(zzgq.class, zzgq);
    }

    private zzgq() {
        zzeff zzeff = zzeff.zzibd;
        this.zzabz = zzeff;
        this.zzaca = zzeff;
    }

    public static zzgq zza(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzgq) zzegp.zza(zzacb, zzeff, zzegc);
    }

    public final zzgr zzdc() {
        zzgr zzgr = this.zzaby;
        return zzgr == null ? zzgr.zzdm() : zzgr;
    }

    public final zzeff zzdd() {
        return this.zzabz;
    }

    public final zzeff zzde() {
        return this.zzaca;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgp.zzdv[i - 1]) {
            case 1:
                return new zzgq();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzacb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzaby", "zzabz", "zzaca"});
            case 4:
                return zzacb;
            case 5:
                zzeim<zzgq> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzgq.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzacb);
                            zzel = zzeim;
                        }
                    }
                }
                return zzeim;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
