package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeat extends zzegp<zzeat, zza> implements zzeib {
    private static volatile zzeim<zzeat> zzel;
    private static final zzeat zzhuf;

    public static final class zza extends zzegp.zzb<zzeat, zza> implements zzeib {
        private zza() {
            super(zzeat.zzhuf);
        }

        public /* synthetic */ zza(zzeas zzeas) {
            this();
        }
    }

    static {
        zzeat zzeat = new zzeat();
        zzhuf = zzeat;
        zzegp.zza(zzeat.class, zzeat);
    }

    private zzeat() {
    }

    public static zzeat zzn(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeat) zzegp.zza(zzhuf, zzeff, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeas.zzdv[i - 1]) {
            case 1:
                return new zzeat();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhuf, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhuf;
            case 5:
                zzeim<zzeat> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeat.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhuf);
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
