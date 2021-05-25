package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzeam extends zzegp<zzeam, zza> implements zzeib {
    private static volatile zzeim<zzeam> zzel;
    private static final zzeam zzhuc;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;

    public static final class zza extends zzegp.zzb<zzeam, zza> implements zzeib {
        private zza() {
            super(zzeam.zzhuc);
        }

        public final zza zzew(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzeam) this.zzift).setVersion(0);
            return this;
        }

        public final zza zzw(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzeam) this.zzift).zzs(zzeff);
            return this;
        }

        public /* synthetic */ zza(zzean zzean) {
            this();
        }
    }

    static {
        zzeam zzeam = new zzeam();
        zzhuc = zzeam;
        zzegp.zza(zzeam.class, zzeam);
    }

    private zzeam() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    public static zza zzazm() {
        return (zza) zzhuc.zzbfj();
    }

    public static zzeam zzk(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzeam) zzegp.zza(zzhuc, zzeff, zzegc);
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
        switch (zzean.zzdv[i - 1]) {
            case 1:
                return new zzeam();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhuc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhtf", "zzhtg"});
            case 4:
                return zzhuc;
            case 5:
                zzeim<zzeam> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzeam.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhuc);
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
}
