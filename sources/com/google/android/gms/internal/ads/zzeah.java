package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeah extends zzegp<zzeah, zza> implements zzeib {
    private static volatile zzeim<zzeah> zzel;
    private static final zzeah zzhtz;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;
    private zzeal zzhty;

    public static final class zza extends zzegp.zzb<zzeah, zza> implements zzeib {
        private zza() {
            super(zzeah.zzhtz);
        }

        public final zza zzb(zzeal zzeal) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzeah) this.zzift).zza(zzeal);
            return this;
        }

        public final zza zzev(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzeah) this.zzift).setVersion(0);
            return this;
        }

        public final zza zzv(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzeah) this.zzift).zzs(zzeff);
            return this;
        }

        public /* synthetic */ zza(zzeag zzeag) {
            this();
        }
    }

    static {
        zzeah zzeah = new zzeah();
        zzhtz = zzeah;
        zzegp.zza(zzeah.class, zzeah);
    }

    private zzeah() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzeal zzeal) {
        zzeal.getClass();
        this.zzhty = zzeal;
    }

    public static zza zzazh() {
        return (zza) zzhtz.zzbfj();
    }

    public static zzeah zzi(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeah) zzegp.zza(zzhtz, zzeff, zzegc);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzs(zzeff zzeff) {
        zzeff.getClass();
        this.zzhtg = zzeff;
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    public final zzeff zzayi() {
        return this.zzhtg;
    }

    public final zzeal zzazg() {
        zzeal zzeal = this.zzhty;
        return zzeal == null ? zzeal.zzazk() : zzeal;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeag.zzdv[i - 1]) {
            case 1:
                return new zzeah();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhtz, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhtf", "zzhty", "zzhtg"});
            case 4:
                return zzhtz;
            case 5:
                zzeim<zzeah> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeah.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhtz);
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
