package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzecj extends zzegp<zzecj, zza> implements zzeib {
    private static volatile zzeim<zzecj> zzel;
    private static final zzecj zzhxj;
    private int zzhtf;
    private zzecm zzhxi;

    public static final class zza extends zzegp.zzb<zzecj, zza> implements zzeib {
        private zza() {
            super(zzecj.zzhxj);
        }

        public final zza zzb(zzecm zzecm) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecj) this.zzift).zza(zzecm);
            return this;
        }

        public final zza zzfl(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecj) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzeck zzeck) {
            this();
        }
    }

    static {
        zzecj zzecj = new zzecj();
        zzhxj = zzecj;
        zzegp.zza(zzecj.class, zzecj);
    }

    private zzecj() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzecm zzecm) {
        zzecm.getClass();
        this.zzhxi = zzecm;
    }

    public static zza zzbce() {
        return (zza) zzhxj.zzbfj();
    }

    public static zzecj zzv(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzecj) zzegp.zza(zzhxj, zzeff, zzegc);
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    public final zzecm zzbcd() {
        zzecm zzecm = this.zzhxi;
        return zzecm == null ? zzecm.zzbci() : zzecm;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeck.zzdv[i - 1]) {
            case 1:
                return new zzecj();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhtf", "zzhxi"});
            case 4:
                return zzhxj;
            case 5:
                zzeim<zzecj> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzecj.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxj);
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
