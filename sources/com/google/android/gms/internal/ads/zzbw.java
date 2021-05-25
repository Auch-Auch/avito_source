package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import kotlin.text.Typography;
public final class zzbw {

    public static final class zza extends zzegp<zza, C0189zza> implements zzeib {
        private static final zza zzek;
        private static volatile zzeim<zza> zzel;
        private int zzdw;
        private String zzdx = "";
        private long zzdy;
        private String zzdz = "";
        private String zzea = "";
        private String zzeb = "";
        private long zzec;
        private long zzed;
        private String zzee = "";
        private long zzef;
        private String zzeg = "";
        private String zzeh = "";
        private zzeha<zzb> zzei = zzegp.zzbfo();
        private int zzej;

        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        public static final class C0189zza extends zzegp.zzb<zza, C0189zza> implements zzeib {
            private C0189zza() {
                super(zza.zzek);
            }

            public final C0189zza zza(zzc zzc) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzb(zzc);
                return this;
            }

            public final C0189zza zzc(long j) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzd(j);
                return this;
            }

            public final C0189zza zzk(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzp(str);
                return this;
            }

            public final C0189zza zzl(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzq(str);
                return this;
            }

            public final C0189zza zzm(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzr(str);
                return this;
            }

            public final C0189zza zzn(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzs(str);
                return this;
            }

            public final C0189zza zzo(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zza) this.zzift).zzt(str);
                return this;
            }

            public /* synthetic */ C0189zza(zzbv zzbv) {
                this();
            }
        }

        public static final class zzb extends zzegp<zzb, C0190zza> implements zzeib {
            private static volatile zzeim<zzb> zzel;
            private static final zzb zzeo;
            private int zzdw;
            private String zzem = "";
            private String zzen = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0190zza extends zzegp.zzb<zzb, C0190zza> implements zzeib {
                private C0190zza() {
                    super(zzb.zzeo);
                }

                public /* synthetic */ C0190zza(zzbv zzbv) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzeo = zzb;
                zzegp.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbv.zzdv[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0190zza(null);
                    case 3:
                        return zzegp.zza(zzeo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdw", "zzem", "zzen"});
                    case 4:
                        return zzeo;
                    case 5:
                        zzeim<zzb> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzb.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzeo);
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

        public enum zzc implements zzegu {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzegt<zzc> zzes = new zzbx();
            private final int value;

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzh(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ENABLED;
                }
                if (i != 2) {
                    return null;
                }
                return DISABLED;
            }

            public static zzegw zzw() {
                return zzbz.zzeu;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzegu
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzek = zza;
            zzegp.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzc zzc2) {
            this.zzej = zzc2.zzv();
            this.zzdw |= 2048;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(long j) {
            this.zzdw |= 2;
            this.zzdy = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(String str) {
            str.getClass();
            this.zzdw |= 1;
            this.zzdx = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzq(String str) {
            str.getClass();
            this.zzdw |= 4;
            this.zzdz = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzr(String str) {
            str.getClass();
            this.zzdw |= 8;
            this.zzea = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzs(String str) {
            str.getClass();
            this.zzdw |= 16;
            this.zzeb = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzt(String str) {
            str.getClass();
            this.zzdw |= 1024;
            this.zzeh = str;
        }

        @Override // com.google.android.gms.internal.ads.zzegp
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbv.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0189zza(null);
                case 3:
                    return zzegp.zza(zzek, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzeh", "zzei", zzb.class, "zzej", zzc.zzw()});
                case 4:
                    return zzek;
                case 5:
                    zzeim<zza> zzeim = zzel;
                    if (zzeim == null) {
                        synchronized (zza.class) {
                            zzeim = zzel;
                            if (zzeim == null) {
                                zzeim = new zzegp.zza<>(zzek);
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

        public static C0189zza zzs() {
            return (C0189zza) zzek.zzbfj();
        }
    }
}
