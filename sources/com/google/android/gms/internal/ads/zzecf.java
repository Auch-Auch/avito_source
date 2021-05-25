package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzecf extends zzegp<zzecf, zza> implements zzeib {
    private static volatile zzeim<zzecf> zzel;
    private static final zzecf zzhxf;
    private int zzhtf;
    private zzeci zzhxe;

    public static final class zza extends zzegp.zzb<zzecf, zza> implements zzeib {
        private zza() {
            super(zzecf.zzhxf);
        }

        public final zza zzb(zzeci zzeci) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecf) this.zzift).zza(zzeci);
            return this;
        }

        public final zza zzfk(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecf) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzecg zzecg) {
            this();
        }
    }

    static {
        zzecf zzecf = new zzecf();
        zzhxf = zzecf;
        zzegp.zza(zzecf.class, zzecf);
    }

    private zzecf() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzeci zzeci) {
        zzeci.getClass();
        this.zzhxe = zzeci;
    }

    public static zza zzbby() {
        return (zza) zzhxf.zzbfj();
    }

    public static zzecf zzt(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzecf) zzegp.zza(zzhxf, zzeff, zzegc);
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    public final zzeci zzbbx() {
        zzeci zzeci = this.zzhxe;
        return zzeci == null ? zzeci.zzbcb() : zzeci;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecg.zzdv[i - 1]) {
            case 1:
                return new zzecf();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhtf", "zzhxe"});
            case 4:
                return zzhxf;
            case 5:
                zzeim<zzecf> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzecf.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxf);
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
