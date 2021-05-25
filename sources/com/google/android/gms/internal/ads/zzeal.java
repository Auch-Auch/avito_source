package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeal extends zzegp<zzeal, zza> implements zzeib {
    private static volatile zzeim<zzeal> zzel;
    private static final zzeal zzhub;
    private int zzhtw;

    public static final class zza extends zzegp.zzb<zzeal, zza> implements zzeib {
        private zza() {
            super(zzeal.zzhub);
        }

        public /* synthetic */ zza(zzeak zzeak) {
            this();
        }
    }

    static {
        zzeal zzeal = new zzeal();
        zzhub = zzeal;
        zzegp.zza(zzeal.class, zzeal);
    }

    private zzeal() {
    }

    public static zzeal zzazk() {
        return zzhub;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeak.zzdv[i - 1]) {
            case 1:
                return new zzeal();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhub, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhtw"});
            case 4:
                return zzhub;
            case 5:
                zzeim<zzeal> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeal.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhub);
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

    public final int zzazd() {
        return this.zzhtw;
    }
}
