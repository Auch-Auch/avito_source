package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzdzw extends zzegp<zzdzw, zza> implements zzeib {
    private static volatile zzeim<zzdzw> zzel;
    private static final zzdzw zzhtp;
    private int zzhtf;
    private zzeaa zzhtn;
    private zzebl zzhto;

    public static final class zza extends zzegp.zzb<zzdzw, zza> implements zzeib {
        private zza() {
            super(zzdzw.zzhtp);
        }

        public final zza zzb(zzeaa zzeaa) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzw) this.zzift).zza(zzeaa);
            return this;
        }

        public final zza zzet(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzw) this.zzift).setVersion(i);
            return this;
        }

        public /* synthetic */ zza(zzdzx zzdzx) {
            this();
        }

        public final zza zzb(zzebl zzebl) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdzw) this.zzift).zza(zzebl);
            return this;
        }
    }

    static {
        zzdzw zzdzw = new zzdzw();
        zzhtp = zzdzw;
        zzegp.zza(zzdzw.class, zzdzw);
    }

    private zzdzw() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzeaa zzeaa) {
        zzeaa.getClass();
        this.zzhtn = zzeaa;
    }

    public static zza zzays() {
        return (zza) zzhtp.zzbfj();
    }

    public static zzdzw zze(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzdzw) zzegp.zza(zzhtp, zzeff, zzegc);
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    public final zzeaa zzayq() {
        zzeaa zzeaa = this.zzhtn;
        return zzeaa == null ? zzeaa.zzayz() : zzeaa;
    }

    public final zzebl zzayr() {
        zzebl zzebl = this.zzhto;
        return zzebl == null ? zzebl.zzbar() : zzebl;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzebl zzebl) {
        zzebl.getClass();
        this.zzhto = zzebl;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzx.zzdv[i - 1]) {
            case 1:
                return new zzdzw();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhtp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzhtf", "zzhtn", "zzhto"});
            case 4:
                return zzhtp;
            case 5:
                zzeim<zzdzw> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdzw.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhtp);
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
