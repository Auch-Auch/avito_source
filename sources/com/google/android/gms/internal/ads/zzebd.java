package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebd extends zzegp<zzebd, zza> implements zzeib {
    private static volatile zzeim<zzebd> zzel;
    private static final zzebd zzhuv;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;
    private zzebe zzhuu;

    public static final class zza extends zzegp.zzb<zzebd, zza> implements zzeib {
        private zza() {
            super(zzebd.zzhuv);
        }

        public final zza zzaa(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebd) this.zzift).zzs(zzeff);
            return this;
        }

        public final zza zzb(zzebe zzebe) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebd) this.zzift).zza(zzebe);
            return this;
        }

        public final zza zzez(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebd) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzebc zzebc) {
            this();
        }
    }

    static {
        zzebd zzebd = new zzebd();
        zzhuv = zzebd;
        zzegp.zza(zzebd.class, zzebd);
    }

    private zzebd() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzebe zzebe) {
        zzebe.getClass();
        this.zzhuu = zzebe;
    }

    public static zza zzbad() {
        return (zza) zzhuv.zzbfj();
    }

    public static zzebd zzp(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzebd) zzegp.zza(zzhuv, zzeff, zzegc);
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

    public final zzebe zzbac() {
        zzebe zzebe = this.zzhuu;
        return zzebe == null ? zzebe.zzbai() : zzebe;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebc.zzdv[i - 1]) {
            case 1:
                return new zzebd();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhuv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhtf", "zzhuu", "zzhtg"});
            case 4:
                return zzhuv;
            case 5:
                zzeim<zzebd> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebd.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhuv);
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
