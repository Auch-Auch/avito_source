package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeap extends zzegp<zzeap, zza> implements zzeib {
    private static volatile zzeim<zzeap> zzel;
    private static final zzeap zzhud;
    private int zzhtf;
    private int zzhtj;

    public static final class zza extends zzegp.zzb<zzeap, zza> implements zzeib {
        private zza() {
            super(zzeap.zzhud);
        }

        public /* synthetic */ zza(zzeao zzeao) {
            this();
        }
    }

    static {
        zzeap zzeap = new zzeap();
        zzhud = zzeap;
        zzegp.zza(zzeap.class, zzeap);
    }

    private zzeap() {
    }

    public static zzeap zzl(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeap) zzegp.zza(zzhud, zzeff, zzegc);
    }

    public final int getKeySize() {
        return this.zzhtj;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeao.zzdv[i - 1]) {
            case 1:
                return new zzeap();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhud, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzhtj", "zzhtf"});
            case 4:
                return zzhud;
            case 5:
                zzeim<zzeap> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeap.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhud);
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
