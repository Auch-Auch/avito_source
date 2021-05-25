package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzect extends zzegp<zzect, zza> implements zzeib {
    private static volatile zzeim<zzect> zzel;
    private static final zzect zzhxy;

    public static final class zza extends zzegp.zzb<zzect, zza> implements zzeib {
        private zza() {
            super(zzect.zzhxy);
        }

        public /* synthetic */ zza(zzecu zzecu) {
            this();
        }
    }

    static {
        zzect zzect = new zzect();
        zzhxy = zzect;
        zzegp.zza(zzect.class, zzect);
    }

    private zzect() {
    }

    public static zzect zzy(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzect) zzegp.zza(zzhxy, zzeff, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecu.zzdv[i - 1]) {
            case 1:
                return new zzect();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxy, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhxy;
            case 5:
                zzeim<zzect> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzect.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxy);
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
