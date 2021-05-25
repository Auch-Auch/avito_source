package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzdzr extends zzegp<zzdzr, zza> implements zzeib {
    private static volatile zzeim<zzdzr> zzel;
    private static final zzdzr zzhti;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;
    private zzdzv zzhth;

    public static final class zza extends zzegp.zzb<zzdzr, zza> implements zzeib {
        private zza() {
            super(zzdzr.zzhti);
        }

        public final zza zzd(zzdzv zzdzv) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzr) this.zzift).zzc(zzdzv);
            return this;
        }

        public final zza zzes(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzr) this.zzift).setVersion(0);
            return this;
        }

        public final zza zzt(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzr) this.zzift).zzs(zzeff);
            return this;
        }

        public /* synthetic */ zza(zzdzq zzdzq) {
            this();
        }
    }

    static {
        zzdzr zzdzr = new zzdzr();
        zzhti = zzdzr;
        zzegp.zza(zzdzr.class, zzdzr);
    }

    private zzdzr() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    public static zza zzayk() {
        return (zza) zzhti.zzbfj();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzc(zzdzv zzdzv) {
        zzdzv.getClass();
        this.zzhth = zzdzv;
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
        switch (zzdzq.zzdv[i - 1]) {
            case 1:
                return new zzdzr();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhti, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzhtf", "zzhtg", "zzhth"});
            case 4:
                return zzhti;
            case 5:
                zzeim<zzdzr> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdzr.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhti);
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

    public final zzdzv zzayj() {
        zzdzv zzdzv = this.zzhth;
        return zzdzv == null ? zzdzv.zzayo() : zzdzv;
    }

    public static zzdzr zzc(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzdzr) zzegp.zza(zzhti, zzeff, zzegc);
    }
}
