package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.util.List;
@Deprecated
public final class zzeco extends zzegp<zzeco, zza> implements zzeib {
    private static volatile zzeim<zzeco> zzel;
    private static final zzeco zzhxw;
    private String zzhxu = "";
    private zzeha<zzeca> zzhxv = zzegp.zzbfo();

    public static final class zza extends zzegp.zzb<zzeco, zza> implements zzeib {
        private zza() {
            super(zzeco.zzhxw);
        }

        public /* synthetic */ zza(zzecq zzecq) {
            this();
        }
    }

    static {
        zzeco zzeco = new zzeco();
        zzhxw = zzeco;
        zzegp.zza(zzeco.class, zzeco);
    }

    private zzeco() {
    }

    public static zzeco zzbcl() {
        return zzhxw;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecq.zzdv[i - 1]) {
            case 1:
                return new zzeco();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxw, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzhxu", "zzhxv", zzeca.class});
            case 4:
                return zzhxw;
            case 5:
                zzeim<zzeco> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeco.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxw);
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

    public final List<zzeca> zzbck() {
        return this.zzhxv;
    }
}
