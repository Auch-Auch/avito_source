package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzdzz extends zzegp<zzdzz, zza> implements zzeib {
    private static volatile zzeim<zzdzz> zzel;
    private static final zzdzz zzhts;
    private zzead zzhtq;
    private zzebp zzhtr;

    public static final class zza extends zzegp.zzb<zzdzz, zza> implements zzeib {
        private zza() {
            super(zzdzz.zzhts);
        }

        public /* synthetic */ zza(zzdzy zzdzy) {
            this();
        }
    }

    static {
        zzdzz zzdzz = new zzdzz();
        zzhts = zzdzz;
        zzegp.zza(zzdzz.class, zzdzz);
    }

    private zzdzz() {
    }

    public static zzdzz zzf(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzdzz) zzegp.zza(zzhts, zzeff, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzy.zzdv[i - 1]) {
            case 1:
                return new zzdzz();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhts, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzhtq", "zzhtr"});
            case 4:
                return zzhts;
            case 5:
                zzeim<zzdzz> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdzz.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhts);
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

    public final zzead zzayu() {
        zzead zzead = this.zzhtq;
        return zzead == null ? zzead.zzazb() : zzead;
    }

    public final zzebp zzayv() {
        zzebp zzebp = this.zzhtr;
        return zzebp == null ? zzebp.zzbat() : zzebp;
    }
}
