package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebe extends zzegp<zzebe, zza> implements zzeib {
    private static volatile zzeim<zzebe> zzel;
    private static final zzebe zzhuy;
    private int zzhtf;
    private zzeba zzhuo;
    private zzeff zzhuw;
    private zzeff zzhux;

    public static final class zza extends zzegp.zzb<zzebe, zza> implements zzeib {
        private zza() {
            super(zzebe.zzhuy);
        }

        public final zza zzab(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebe) this.zzift).zzy(zzeff);
            return this;
        }

        public final zza zzac(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebe) this.zzift).zzz(zzeff);
            return this;
        }

        public final zza zzc(zzeba zzeba) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebe) this.zzift).zzb(zzeba);
            return this;
        }

        public final zza zzfa(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebe) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzebf zzebf) {
            this();
        }
    }

    static {
        zzebe zzebe = new zzebe();
        zzhuy = zzebe;
        zzegp.zza(zzebe.class, zzebe);
    }

    private zzebe() {
        zzeff zzeff = zzeff.zzibd;
        this.zzhuw = zzeff;
        this.zzhux = zzeff;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzb(zzeba zzeba) {
        zzeba.getClass();
        this.zzhuo = zzeba;
    }

    public static zza zzbah() {
        return (zza) zzhuy.zzbfj();
    }

    public static zzebe zzbai() {
        return zzhuy;
    }

    public static zzebe zzq(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzebe) zzegp.zza(zzhuy, zzeff, zzegc);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzy(zzeff zzeff) {
        zzeff.getClass();
        this.zzhuw = zzeff;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzz(zzeff zzeff) {
        zzeff.getClass();
        this.zzhux = zzeff;
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebf.zzdv[i - 1]) {
            case 1:
                return new zzebe();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhuy, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzhtf", "zzhuo", "zzhuw", "zzhux"});
            case 4:
                return zzhuy;
            case 5:
                zzeim<zzebe> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebe.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhuy);
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

    public final zzeba zzazv() {
        zzeba zzeba = this.zzhuo;
        return zzeba == null ? zzeba.zzbaa() : zzeba;
    }

    public final zzeff zzbaf() {
        return this.zzhuw;
    }

    public final zzeff zzbag() {
        return this.zzhux;
    }
}
