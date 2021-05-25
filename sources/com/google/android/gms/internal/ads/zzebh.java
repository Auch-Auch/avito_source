package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebh extends zzegp<zzebh, zza> implements zzeib {
    private static volatile zzeim<zzebh> zzel;
    private static final zzebh zzhvc;
    private int zzhuz;
    private int zzhva;
    private zzeff zzhvb = zzeff.zzibd;

    public static final class zza extends zzegp.zzb<zzebh, zza> implements zzeib {
        private zza() {
            super(zzebh.zzhvc);
        }

        public /* synthetic */ zza(zzebg zzebg) {
            this();
        }
    }

    static {
        zzebh zzebh = new zzebh();
        zzhvc = zzebh;
        zzegp.zza(zzebh.class, zzebh);
    }

    private zzebh() {
    }

    public static zzebh zzban() {
        return zzhvc;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebg.zzdv[i - 1]) {
            case 1:
                return new zzebh();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhvc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzhuz", "zzhva", "zzhvb"});
            case 4:
                return zzhvc;
            case 5:
                zzeim<zzebh> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebh.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhvc);
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

    public final zzebi zzbak() {
        zzebi zzfb = zzebi.zzfb(this.zzhuz);
        return zzfb == null ? zzebi.UNRECOGNIZED : zzfb;
    }

    public final zzebj zzbal() {
        zzebj zzfc = zzebj.zzfc(this.zzhva);
        return zzfc == null ? zzebj.UNRECOGNIZED : zzfc;
    }

    public final zzeff zzbam() {
        return this.zzhvb;
    }
}
