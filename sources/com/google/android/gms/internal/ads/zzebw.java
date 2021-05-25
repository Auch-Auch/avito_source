package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebw extends zzegp<zzebw, zza> implements zzeib {
    private static volatile zzeim<zzebw> zzel;
    private static final zzebw zzhwo;
    private String zzhvw = "";
    private zzeff zzhvx = zzeff.zzibd;
    private int zzhwn;

    public static final class zza extends zzegp.zzb<zzebw, zza> implements zzeib {
        private zza() {
            super(zzebw.zzhwo);
        }

        public /* synthetic */ zza(zzeby zzeby) {
            this();
        }
    }

    static {
        zzebw zzebw = new zzebw();
        zzhwo = zzebw;
        zzegp.zza(zzebw.class, zzebw);
    }

    private zzebw() {
    }

    public static zzebw zzbbe() {
        return zzhwo;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeby.zzdv[i - 1]) {
            case 1:
                return new zzebw();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhwo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhvw", "zzhvx", "zzhwn"});
            case 4:
                return zzhwo;
            case 5:
                zzeim<zzebw> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebw.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhwo);
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

    public final String zzbay() {
        return this.zzhvw;
    }

    public final zzeff zzbaz() {
        return this.zzhvx;
    }
}
