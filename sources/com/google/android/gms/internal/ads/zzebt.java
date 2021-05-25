package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import kotlin.text.Typography;
public final class zzebt extends zzegp<zzebt, zzb> implements zzeib {
    private static volatile zzeim<zzebt> zzel;
    private static final zzebt zzhvz;
    private String zzhvw = "";
    private zzeff zzhvx = zzeff.zzibd;
    private int zzhvy;

    public enum zza implements zzegu {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzegt<zza> zzes = new zzebv();
        private final int value;

        private zza(int i) {
            this.value = i;
        }

        public static zza zzfe(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zza.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        @Override // com.google.android.gms.internal.ads.zzegu
        public final int zzv() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class zzb extends zzegp.zzb<zzebt, zzb> implements zzeib {
        private zzb() {
            super(zzebt.zzhvz);
        }

        public final zzb zzaf(zzeff zzeff) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebt) this.zzift).zzae(zzeff);
            return this;
        }

        public final zzb zzb(zza zza) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebt) this.zzift).zza(zza);
            return this;
        }

        public final zzb zzhq(String str) {
            if (this.zzifu) {
                zzbft();
                this.zzifu = false;
            }
            ((zzebt) this.zzift).zzhp(str);
            return this;
        }

        public /* synthetic */ zzb(zzebs zzebs) {
            this();
        }
    }

    static {
        zzebt zzebt = new zzebt();
        zzhvz = zzebt;
        zzegp.zza(zzebt.class, zzebt);
    }

    private zzebt() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zza zza2) {
        this.zzhvy = zza2.zzv();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzae(zzeff zzeff) {
        zzeff.getClass();
        this.zzhvx = zzeff;
    }

    public static zzb zzbbb() {
        return (zzb) zzhvz.zzbfj();
    }

    public static zzebt zzbbc() {
        return zzhvz;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzhp(String str) {
        str.getClass();
        this.zzhvw = str;
    }

    public final String zzbay() {
        return this.zzhvw;
    }

    public final zzeff zzbaz() {
        return this.zzhvx;
    }

    public final zza zzbba() {
        zza zzfe = zza.zzfe(this.zzhvy);
        return zzfe == null ? zza.UNRECOGNIZED : zzfe;
    }

    @Override // com.google.android.gms.internal.ads.zzegp
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebs.zzdv[i - 1]) {
            case 1:
                return new zzebt();
            case 2:
                return new zzb(null);
            case 3:
                return zzegp.zza(zzhvz, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhvw", "zzhvx", "zzhvy"});
            case 4:
                return zzhvz;
            case 5:
                zzeim<zzebt> zzeim = zzel;
                if (zzeim == null) {
                    synchronized (zzebt.class) {
                        zzeim = zzel;
                        if (zzeim == null) {
                            zzeim = new zzegp.zza<>(zzhvz);
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
