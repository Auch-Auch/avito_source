package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
@Deprecated
public final class zzeca extends zzegp<zzeca, zza> implements zzeib {
    private static volatile zzeim<zzeca> zzel;
    private static final zzeca zzhwt;
    private String zzhvw = "";
    private String zzhwp = "";
    private int zzhwq;
    private boolean zzhwr;
    private String zzhws = "";

    public static final class zza extends zzegp.zzb<zzeca, zza> implements zzeib {
        private zza() {
            super(zzeca.zzhwt);
        }

        public /* synthetic */ zza(zzebz zzebz) {
            this();
        }
    }

    static {
        zzeca zzeca = new zzeca();
        zzhwt = zzeca;
        zzegp.zza(zzeca.class, zzeca);
    }

    private zzeca() {
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebz.zzdv[i - 1]) {
            case 1:
                return new zzeca();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhwt, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzhwp", "zzhvw", "zzhwq", "zzhwr", "zzhws"});
            case 4:
                return zzhwt;
            case 5:
                zzeim<zzeca> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeca.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhwt);
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

    public final String zzbbg() {
        return this.zzhwp;
    }

    public final int zzbbh() {
        return this.zzhwq;
    }

    public final boolean zzbbi() {
        return this.zzhwr;
    }

    public final String zzbbj() {
        return this.zzhws;
    }
}
