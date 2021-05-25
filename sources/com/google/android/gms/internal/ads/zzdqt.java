package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import kotlin.text.Typography;
public final class zzdqt extends zzegp<zzdqt, zzb> implements zzeib {
    private static volatile zzeim<zzdqt> zzel;
    private static final zzegy<Integer, zza> zzhjq = new zzdqw();
    private static final zzdqt zzhju;
    private int zzdw;
    private zzegv zzhjp = zzegp.zzbfm();
    private String zzhjr = "";
    private String zzhjs = "";
    private String zzhjt = "";

    public enum zza implements zzegu {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzegt<zza> zzes = new zzdqx();
        private final int value;

        private zza(int i) {
            this.value = i;
        }

        public static zza zzeg(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzegw zzw() {
            return zzdqy.zzeu;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        @Override // com.google.android.gms.internal.ads.zzegu
        public final int zzv() {
            return this.value;
        }
    }

    public static final class zzb extends zzegp.zzb<zzdqt, zzb> implements zzeib {
        private zzb() {
            super(zzdqt.zzhju);
        }

        public final zzb zzb(zza zza) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdqt) this.zzift).zza(zza);
            return this;
        }

        public final zzb zzhe(String str) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzdqt) this.zzift).zzhd(str);
            return this;
        }

        public /* synthetic */ zzb(zzdqw zzdqw) {
            this();
        }
    }

    static {
        zzdqt zzdqt = new zzdqt();
        zzhju = zzdqt;
        zzegp.zza(zzdqt.class, zzdqt);
    }

    private zzdqt() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zza zza2) {
        zza2.getClass();
        zzegv zzegv = this.zzhjp;
        if (!zzegv.zzbdf()) {
            this.zzhjp = zzegp.zza(zzegv);
        }
        this.zzhjp.zzhc(zza2.zzv());
    }

    public static zzb zzavm() {
        return (zzb) zzhju.zzbfj();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzhd(String str) {
        str.getClass();
        this.zzdw |= 1;
        this.zzhjr = str;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdqv.zzdv[i - 1]) {
            case 1:
                return new zzdqt();
            case 2:
                return new zzb(null);
            case 3:
                return zzegp.zza(zzhju, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdw", "zzhjp", zza.zzw(), "zzhjr", "zzhjs", "zzhjt"});
            case 4:
                return zzhju;
            case 5:
                zzeim<zzdqt> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzdqt.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhju);
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
