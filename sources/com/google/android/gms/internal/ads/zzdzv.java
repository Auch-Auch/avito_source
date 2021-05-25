package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzdzv extends zzegp<zzdzv, zza> implements zzeib {
    private static volatile zzeim<zzdzv> zzel;
    private static final zzdzv zzhtm;
    private int zzhtl;

    public static final class zza extends zzegp.zzb<zzdzv, zza> implements zzeib {
        private zza() {
            super(zzdzv.zzhtm);
        }

        public /* synthetic */ zza(zzdzu zzdzu) {
            this();
        }
    }

    static {
        zzdzv zzdzv = new zzdzv();
        zzhtm = zzdzv;
        zzegp.zza(zzdzv.class, zzdzv);
    }

    private zzdzv() {
    }

    public static zzdzv zzayo() {
        return zzhtm;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzu.zzdv[i - 1]) {
            case 1:
                return new zzdzv();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhtm, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhtl"});
            case 4:
                return zzhtm;
            case 5:
                zzeim<zzdzv> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdzv.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhtm);
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

    public final int zzayn() {
        return this.zzhtl;
    }
}
