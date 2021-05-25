package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeai extends zzegp<zzeai, zza> implements zzeib {
    private static volatile zzeim<zzeai> zzel;
    private static final zzeai zzhua;
    private int zzhtj;
    private zzeal zzhty;

    public static final class zza extends zzegp.zzb<zzeai, zza> implements zzeib {
        private zza() {
            super(zzeai.zzhua);
        }

        public /* synthetic */ zza(zzeaj zzeaj) {
            this();
        }
    }

    static {
        zzeai zzeai = new zzeai();
        zzhua = zzeai;
        zzegp.zza(zzeai.class, zzeai);
    }

    private zzeai() {
    }

    public static zzeai zzj(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeai) zzegp.zza(zzhua, zzeff, zzegc);
    }

    public final int getKeySize() {
        return this.zzhtj;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeaj.zzdv[i - 1]) {
            case 1:
                return new zzeai();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhua, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhty", "zzhtj"});
            case 4:
                return zzhua;
            case 5:
                zzeim<zzeai> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeai.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhua);
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

    public final zzeal zzazg() {
        zzeal zzeal = this.zzhty;
        return zzeal == null ? zzeal.zzazk() : zzeal;
    }
}
