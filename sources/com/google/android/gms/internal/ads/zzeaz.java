package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeaz extends zzegp<zzeaz, zza> implements zzeib {
    private static volatile zzeim<zzeaz> zzel;
    private static final zzeaz zzhup;
    private zzeba zzhuo;

    public static final class zza extends zzegp.zzb<zzeaz, zza> implements zzeib {
        private zza() {
            super(zzeaz.zzhup);
        }

        public /* synthetic */ zza(zzeay zzeay) {
            this();
        }
    }

    static {
        zzeaz zzeaz = new zzeaz();
        zzhup = zzeaz;
        zzegp.zza(zzeaz.class, zzeaz);
    }

    private zzeaz() {
    }

    public static zzeaz zzo(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeaz) zzegp.zza(zzhup, zzeff, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeay.zzdv[i - 1]) {
            case 1:
                return new zzeaz();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhup, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzhuo"});
            case 4:
                return zzhup;
            case 5:
                zzeim<zzeaz> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeaz.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhup);
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

    public final zzeba zzazv() {
        zzeba zzeba = this.zzhuo;
        return zzeba == null ? zzeba.zzbaa() : zzeba;
    }
}
