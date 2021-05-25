package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzdzs extends zzegp<zzdzs, zza> implements zzeib {
    private static volatile zzeim<zzdzs> zzel;
    private static final zzdzs zzhtk;
    private zzdzv zzhth;
    private int zzhtj;

    public static final class zza extends zzegp.zzb<zzdzs, zza> implements zzeib {
        private zza() {
            super(zzdzs.zzhtk);
        }

        public /* synthetic */ zza(zzdzt zzdzt) {
            this();
        }
    }

    static {
        zzdzs zzdzs = new zzdzs();
        zzhtk = zzdzs;
        zzegp.zza(zzdzs.class, zzdzs);
    }

    private zzdzs() {
    }

    public static zzdzs zzd(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzdzs) zzegp.zza(zzhtk, zzeff, zzegc);
    }

    public final int getKeySize() {
        return this.zzhtj;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzt.zzdv[i - 1]) {
            case 1:
                return new zzdzs();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhtk, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhtj", "zzhth"});
            case 4:
                return zzhtk;
            case 5:
                zzeim<zzdzs> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdzs.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhtk);
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

    public final zzdzv zzayj() {
        zzdzv zzdzv = this.zzhth;
        return zzdzv == null ? zzdzv.zzayo() : zzdzv;
    }
}
