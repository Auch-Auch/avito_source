package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzebl extends zzegp<zzebl, zza> implements zzeib {
    private static volatile zzeim<zzebl> zzel;
    private static final zzebl zzhvs;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;
    private zzebq zzhvr;

    public static final class zza extends zzegp.zzb<zzebl, zza> implements zzeib {
        private zza() {
            super(zzebl.zzhvs);
        }

        public final zza zzad(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebl) this.zzift).zzs(zzeff);
            return this;
        }

        public final zza zzd(zzebq zzebq) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebl) this.zzift).zzc(zzebq);
            return this;
        }

        public final zza zzfd(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebl) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzebn zzebn) {
            this();
        }
    }

    static {
        zzebl zzebl = new zzebl();
        zzhvs = zzebl;
        zzegp.zza(zzebl.class, zzebl);
    }

    private zzebl() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    public static zza zzbaq() {
        return (zza) zzhvs.zzbfj();
    }

    public static zzebl zzbar() {
        return zzhvs;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzc(zzebq zzebq) {
        zzebq.getClass();
        this.zzhvr = zzebq;
    }

    public static zzebl zzr(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzebl) zzegp.zza(zzhvs, zzeff, zzegc);
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

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebn.zzdv[i - 1]) {
            case 1:
                return new zzebl();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhvs, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhtf", "zzhvr", "zzhtg"});
            case 4:
                return zzhvs;
            case 5:
                zzeim<zzebl> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebl.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhvs);
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

    public final zzeff zzayi() {
        return this.zzhtg;
    }

    public final zzebq zzbap() {
        zzebq zzebq = this.zzhvr;
        return zzebq == null ? zzebq.zzbaw() : zzebq;
    }
}
