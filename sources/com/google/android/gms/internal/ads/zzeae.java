package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeae extends zzegp<zzeae, zza> implements zzeib {
    private static volatile zzeim<zzeae> zzel;
    private static final zzeae zzhtx;
    private int zzhtw;

    public static final class zza extends zzegp.zzb<zzeae, zza> implements zzeib {
        private zza() {
            super(zzeae.zzhtx);
        }

        public /* synthetic */ zza(zzeaf zzeaf) {
            this();
        }
    }

    static {
        zzeae zzeae = new zzeae();
        zzhtx = zzeae;
        zzegp.zza(zzeae.class, zzeae);
    }

    private zzeae() {
    }

    public static zzeae zzaze() {
        return zzhtx;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeaf.zzdv[i - 1]) {
            case 1:
                return new zzeae();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhtx, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhtw"});
            case 4:
                return zzhtx;
            case 5:
                zzeim<zzeae> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeae.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhtx);
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
