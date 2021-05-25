package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebp extends zzegp<zzebp, zza> implements zzeib {
    private static volatile zzeim<zzebp> zzel;
    private static final zzebp zzhvt;
    private int zzhtf;
    private int zzhtj;
    private zzebq zzhvr;

    public static final class zza extends zzegp.zzb<zzebp, zza> implements zzeib {
        private zza() {
            super(zzebp.zzhvt);
        }

        public /* synthetic */ zza(zzebo zzebo) {
            this();
        }
    }

    static {
        zzebp zzebp = new zzebp();
        zzhvt = zzebp;
        zzegp.zza(zzebp.class, zzebp);
    }

    private zzebp() {
    }

    public static zzebp zzbat() {
        return zzhvt;
    }

    public static zzebp zzs(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzebp) zzegp.zza(zzhvt, zzeff, zzegc);
    }

    public final int getKeySize() {
        return this.zzhtj;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebo.zzdv[i - 1]) {
            case 1:
                return new zzebp();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhvt, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzhvr", "zzhtj", "zzhtf"});
            case 4:
                return zzhvt;
            case 5:
                zzeim<zzebp> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebp.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhvt);
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

    public final zzebq zzbap() {
        zzebq zzebq = this.zzhvr;
        return zzebq == null ? zzebq.zzbaw() : zzebq;
    }
}
