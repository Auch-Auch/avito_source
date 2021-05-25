package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzecm extends zzegp<zzecm, zza> implements zzeib {
    private static volatile zzeim<zzecm> zzel;
    private static final zzecm zzhxm;
    private String zzhxk = "";
    private zzebw zzhxl;

    public static final class zza extends zzegp.zzb<zzecm, zza> implements zzeib {
        private zza() {
            super(zzecm.zzhxm);
        }

        public /* synthetic */ zza(zzecl zzecl) {
            this();
        }
    }

    static {
        zzecm zzecm = new zzecm();
        zzhxm = zzecm;
        zzegp.zza(zzecm.class, zzecm);
    }

    private zzecm() {
    }

    public static zzecm zzbci() {
        return zzhxm;
    }

    public static zzecm zzw(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzecm) zzegp.zza(zzhxm, zzeff, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecl.zzdv[i - 1]) {
            case 1:
                return new zzecm();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzhxk", "zzhxl"});
            case 4:
                return zzhxm;
            case 5:
                zzeim<zzecm> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzecm.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxm);
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

    public final String zzbcg() {
        return this.zzhxk;
    }

    public final zzebw zzbch() {
        zzebw zzebw = this.zzhxl;
        return zzebw == null ? zzebw.zzbbe() : zzebw;
    }
}
