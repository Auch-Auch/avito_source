package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzecs extends zzegp<zzecs, zza> implements zzeib {
    private static volatile zzeim<zzecs> zzel;
    private static final zzecs zzhxx;
    private int zzhtf;
    private zzeff zzhtg = zzeff.zzibd;

    public static final class zza extends zzegp.zzb<zzecs, zza> implements zzeib {
        private zza() {
            super(zzecs.zzhxx);
        }

        public final zza zzag(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecs) this.zzift).zzs(zzeff);
            return this;
        }

        public final zza zzfn(int i) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzecs) this.zzift).setVersion(0);
            return this;
        }

        public /* synthetic */ zza(zzecr zzecr) {
            this();
        }
    }

    static {
        zzecs zzecs = new zzecs();
        zzhxx = zzecs;
        zzegp.zza(zzecs.class, zzecs);
    }

    private zzecs() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzhtf = i;
    }

    public static zza zzbcn() {
        return (zza) zzhxx.zzbfj();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzs(zzeff zzeff) {
        zzeff.getClass();
        this.zzhtg = zzeff;
    }

    public static zzecs zzx(zzeff zzeff, zzegc zzegc) throws zzegz {
        return (zzecs) zzegp.zza(zzhxx, zzeff, zzegc);
    }

    public final int getVersion() {
        return this.zzhtf;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecr.zzdv[i - 1]) {
            case 1:
                return new zzecs();
            case 2:
                return new zza(null);
            case 3:
                return zzegp.zza(zzhxx, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhtf", "zzhtg"});
            case 4:
                return zzhxx;
            case 5:
                zzeim<zzecs> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzecs.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhxx);
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
