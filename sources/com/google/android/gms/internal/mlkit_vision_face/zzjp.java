package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import kotlin.text.Typography;
public final class zzjp {

    public static final class zza extends zzgd<zza, zzb> implements zzhn {
        private static final zza zzf;
        private static volatile zzhv<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzjp$zza$zza  reason: collision with other inner class name */
        public enum EnumC0263zza implements zzgf {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final zzgi<EnumC0263zza> zzc = new zzjt();
            private final int zzd;

            private EnumC0263zza(int i) {
                this.zzd = i;
            }

            public static zzgh zzb() {
                return zzjs.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + EnumC0263zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzd;
            }
        }

        public static final class zzb extends zzgd.zza<zza, zzb> implements zzhn {
            private zzb() {
                super(zza.zzf);
            }

            public /* synthetic */ zzb(zzjr zzjr) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzf = zza;
            zzgd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzg = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.EnumC0263zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zza
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzgd<zzb, zza> implements zzhn {
        private static final zzb zzn;
        private static volatile zzhv<zzb> zzo;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";

        public static final class zza extends zzgd.zza<zzb, zza> implements zzhn {
            private zza() {
                super(zzb.zzn);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzn = zzb;
            zzgd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007f;
                    case 2: goto L_0x0079;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzo
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzo     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzn     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzo = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzn
                return r2
            L_0x0033:
                r2 = 11
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzm"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zzn
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzgd<zzc, C0264zzc> implements zzhn {
        private static final zzc zzm;
        private static volatile zzhv<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private zzgm<zzg> zzk = zzgd.zzl();
        private int zzl;

        public enum zza implements zzgf {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4),
            VALIDATION(5);
            
            private static final zzgi<zza> zzg = new zzjv();
            private final int zzh;

            private zza(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzju.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        public static final class zzb extends zzgd<zzb, zza> implements zzhn {
            private static final zzb zzf;
            private static volatile zzhv<zzb> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            public static final class zza extends zzgd.zza<zzb, zza> implements zzhn {
                private zza() {
                    super(zzb.zzf);
                }

                public /* synthetic */ zza(zzjr zzjr) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzf = zzb;
                zzgd.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0053;
                        case 2: goto L_0x004d;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzg = r2     // Catch:{ all -> 0x002c }
                L_0x002a:
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzf
                    return r2
                L_0x0033:
                    r2 = 3
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001"
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzc  reason: collision with other inner class name */
        public static final class C0264zzc extends zzgd.zza<zzc, C0264zzc> implements zzhn {
            private C0264zzc() {
                super(zzc.zzm);
            }

            public /* synthetic */ C0264zzc(zzjr zzjr) {
                this();
            }
        }

        public static final class zzd extends zzgd<zzd, zza> implements zzhn {
            private static final zzd zzg;
            private static volatile zzhv<zzd> zzh;
            private int zzc;
            private zzb zzd;
            private zzb zze;
            private boolean zzf;

            public static final class zza extends zzgd.zza<zzd, zza> implements zzhn {
                private zza() {
                    super(zzd.zzg);
                }

                public /* synthetic */ zza(zzjr zzjr) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzg = zzd2;
                zzgd.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0058;
                        case 2: goto L_0x0052;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzh = r2     // Catch:{ all -> 0x002c }
                L_0x002a:
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzg
                    return r2
                L_0x0033:
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002"
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0052:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x0058:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public enum zze implements zzgf {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final zzgi<zze> zzg = new zzjx();
            private final int zzh;

            private zze(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzjw.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzm = zzc2;
            zzgd.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x008f;
                    case 2: goto L_0x0089;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzn
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzn     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzm     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzn = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzm
                return r2
            L_0x0033:
                r2 = 13
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zze.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                r3 = 11
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg> r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.class
                r2[r3] = r4
                r3 = 12
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zzm
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzc
                r2.<init>(r3)
                return r2
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc
                r2.<init>()
                return r2
                switch-data {1->0x008f, 2->0x0089, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzgd<zzd, zza> implements zzhn {
        private static final zzd zzk;
        private static volatile zzhv<zzd> zzl;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private int zzg;
        private int zzh;
        private String zzi = "";
        private int zzj;

        public static final class zza extends zzgd.zza<zzd, zza> implements zzhn {
            private zza() {
                super(zzd.zzk);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzk = zzd2;
            zzgd.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006d;
                    case 2: goto L_0x0067;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzl = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzk
                return r2
            L_0x0033:
                r2 = 8
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzgd<zze, zza> implements zzhn {
        private static final zze zze;
        private static volatile zzhv<zze> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzgd.zza<zze, zza> implements zzhn {
            private zza() {
                super(zze.zze);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zze = zze2;
            zzgd.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zze>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x004e;
                    case 2: goto L_0x0048;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zze> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zze> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zze> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zze r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zzf = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zze r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zze
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zze r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zze$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zze r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zze
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzgd<zzf, zza> implements zzhn {
        private static final zzf zzo;
        private static volatile zzhv<zzf> zzp;
        private int zzc;
        private zzb zzd;
        private zzi zze;
        private zzd zzf;
        private int zzg;
        private zzc zzh;
        private zzl zzi;
        private long zzj;
        private long zzk;
        private boolean zzl;
        private int zzm;
        private byte zzn = 2;

        public static final class zza extends zzgd.zza<zzf, zza> implements zzhn {
            private zza() {
                super(zzf.zzo);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzo = zzf2;
            zzgd.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r0 = 1
                int r3 = r3 - r0
                r3 = r5[r3]
                r5 = 0
                r1 = 0
                switch(r3) {
                    case 1: goto L_0x008f;
                    case 2: goto L_0x0089;
                    case 3: goto L_0x003c;
                    case 4: goto L_0x0039;
                    case 5: goto L_0x001f;
                    case 6: goto L_0x0018;
                    case 7: goto L_0x0011;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                r3.<init>()
                throw r3
            L_0x0011:
                if (r4 != 0) goto L_0x0014
                r0 = 0
            L_0x0014:
                byte r3 = (byte) r0
                r2.zzn = r3
                return r1
            L_0x0018:
                byte r3 = r2.zzn
                java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
                return r3
            L_0x001f:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzp
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf> r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzp     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r3 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf r5 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzo     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzp = r3     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                goto L_0x0038
            L_0x0035:
                r3 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                throw r3
            L_0x0038:
                return r3
            L_0x0039:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzo
                return r3
            L_0x003c:
                r3 = 12
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzc"
                r3[r5] = r4
                java.lang.String r4 = "zzd"
                r3[r0] = r4
                r4 = 2
                java.lang.String r5 = "zze"
                r3[r4] = r5
                r4 = 3
                java.lang.String r5 = "zzg"
                r3[r4] = r5
                r4 = 4
                com.google.android.gms.internal.mlkit_vision_face.zzgh r5 = com.google.android.gms.internal.mlkit_vision_face.zzjz.zzb()
                r3[r4] = r5
                r4 = 5
                java.lang.String r5 = "zzh"
                r3[r4] = r5
                r4 = 6
                java.lang.String r5 = "zzi"
                r3[r4] = r5
                r4 = 7
                java.lang.String r5 = "zzj"
                r3[r4] = r5
                r4 = 8
                java.lang.String r5 = "zzk"
                r3[r4] = r5
                r4 = 9
                java.lang.String r5 = "zzl"
                r3[r4] = r5
                r4 = 10
                java.lang.String r5 = "zzm"
                r3[r4] = r5
                r4 = 11
                java.lang.String r5 = "zzf"
                r3[r4] = r5
                java.lang.String r4 = "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf r5 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zzo
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r5, r4, r3)
                return r3
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf$zza r3 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf$zza
                r3.<init>(r1)
                return r3
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf r3 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf
                r3.<init>()
                return r3
                switch-data {1->0x008f, 2->0x0089, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzgd<zzg, zza> implements zzhn {
        private static final zzg zzd;
        private static volatile zzhv<zzg> zze;
        private zzgk zzc = zzgd.zzk();

        public static final class zza extends zzgd.zza<zzg, zza> implements zzhn {
            private zza() {
                super(zzg.zzd);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zzg zzg = new zzg();
            zzd = zzg;
            zzgd.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r1, java.lang.Object r2, java.lang.Object r3) {
            /*
                r0 = this;
                int[] r2 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r3 = 1
                int r1 = r1 - r3
                r1 = r2[r1]
                r2 = 0
                switch(r1) {
                    case 1: goto L_0x0049;
                    case 2: goto L_0x0043;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x0010:
                return r2
            L_0x0011:
                java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                return r1
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg> r1 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zze
                if (r1 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.class
                monitor-enter(r2)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg> r1 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zze     // Catch:{ all -> 0x002c }
                if (r1 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r1 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zzd     // Catch:{ all -> 0x002c }
                r1.<init>(r3)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zze = r1     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r2)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r1 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002c }
                throw r1
            L_0x002f:
                return r1
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg r1 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zzd
                return r1
            L_0x0033:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r2 = 0
                java.lang.String r3 = "zzc"
                r1[r2] = r3
                java.lang.String r2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zzd
                java.lang.Object r1 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r3, r2, r1)
                return r1
            L_0x0043:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg$zza r1 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg$zza
                r1.<init>(r2)
                return r1
            L_0x0049:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg r1 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg
                r1.<init>()
                return r1
                switch-data {1->0x0049, 2->0x0043, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzgd<zzh, zza> implements zzhn {
        private static final zzh zzf;
        private static volatile zzhv<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        public static final class zza extends zzgd.zza<zzh, zza> implements zzhn {
            private zza() {
                super(zzh.zzf);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzgd.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0053;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzg = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzf
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzgd<zzi, zzb> implements zzhn {
        private static final zzi zzd;
        private static volatile zzhv<zzi> zze;
        private zzgm<zza> zzc = zzgd.zzl();

        public static final class zza extends zzgd<zza, C0265zza> implements zzhn {
            private static final zza zzh;
            private static volatile zzhv<zza> zzi;
            private int zzc;
            private String zzd = "";
            private int zze;
            private String zzf = "";
            private long zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza$zza  reason: collision with other inner class name */
            public static final class C0265zza extends zzgd.zza<zza, C0265zza> implements zzhn {
                private C0265zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0265zza(zzjr zzjr) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzh = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x005d;
                        case 2: goto L_0x0057;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzi = r2     // Catch:{ all -> 0x002c }
                L_0x002a:
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzh
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003"
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzi, zzb> implements zzhn {
            private zzb() {
                super(zzi.zzd);
            }

            public /* synthetic */ zzb(zzjr zzjr) {
                this();
            }
        }

        static {
            zzi zzi = new zzi();
            zzd = zzi;
            zzgd.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x004e;
                    case 2: goto L_0x0048;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zze
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zze     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zzd     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zze = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zzd
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zzd
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzgd<zzj, zzb> implements zzhn {
        private static final zzj zzg;
        private static volatile zzhv<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        public enum zza implements zzgf {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3),
            EDGETPU(4);
            
            private static final zzgi<zza> zzf = new zzkc();
            private final int zzg;

            private zza(int i) {
                this.zzg = i;
            }

            public static zzgh zzb() {
                return zzkb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzg;
            }
        }

        public static final class zzb extends zzgd.zza<zzj, zzb> implements zzhn {
            private zzb() {
                super(zzj.zzg);
            }

            public /* synthetic */ zzb(zzjr zzjr) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zzg = zzj;
            zzgd.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005f;
                    case 2: goto L_0x0059;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzh = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzg
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzgd<zzk, zza> implements zzhn {
        private static final zzk zzf;
        private static volatile zzhv<zzk> zzg;
        private int zzc;
        private int zzd;
        private float zze;

        public static final class zza extends zzgd.zza<zzk, zza> implements zzhn {
            private zza() {
                super(zzk.zzf);
            }

            public /* synthetic */ zza(zzjr zzjr) {
                this();
            }
        }

        public enum zzb implements zzgf {
            UNKNOWN_METRIC(0),
            MEAN_ABSOLUTE_ERROR(1),
            MEAN_SQUARED_ERROR(2),
            ROOT_MEAN_SQUARED_ERROR(3);
            
            private static final zzgi<zzb> zze = new zzkd();
            private final int zzf;

            private zzb(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzke.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzk zzk = new zzk();
            zzf = zzk;
            zzgd.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzg = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzgd.zze<zzl, zzb> implements zzhn {
        private static final zzl zzf;
        private static volatile zzhv<zzl> zzg;
        private zzgm<zza> zzd = zzgd.zzl();
        private byte zze = 2;

        public static final class zza extends zzgd<zza, C0266zza> implements zzhn {
            private static final zza zzg;
            private static volatile zzhv<zza> zzh;
            private int zzc;
            private int zzd;
            private int zze;
            private zzgm<zzk> zzf = zzgd.zzl();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza$zza  reason: collision with other inner class name */
            public static final class C0266zza extends zzgd.zza<zza, C0266zza> implements zzhn {
                private C0266zza() {
                    super(zza.zzg);
                }

                public /* synthetic */ C0266zza(zzjr zzjr) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzg = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x005d;
                        case 2: goto L_0x0057;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzh = r2     // Catch:{ all -> 0x002c }
                L_0x002a:
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzg
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk> r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzk.class
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003\u001b"
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zzb<zzl, zzb> implements zzhn {
            private zzb() {
                super(zzl.zzf);
            }

            public /* synthetic */ zzb(zzjr zzjr) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzf = zzl;
            zzgd.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_vision_face.zzjr.zza
                r0 = 1
                int r3 = r3 - r0
                r3 = r5[r3]
                r5 = 0
                r1 = 0
                switch(r3) {
                    case 1: goto L_0x0056;
                    case 2: goto L_0x0050;
                    case 3: goto L_0x003c;
                    case 4: goto L_0x0039;
                    case 5: goto L_0x001f;
                    case 6: goto L_0x0018;
                    case 7: goto L_0x0011;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                r3.<init>()
                throw r3
            L_0x0011:
                if (r4 != 0) goto L_0x0014
                r0 = 0
            L_0x0014:
                byte r3 = (byte) r0
                r2.zze = r3
                return r1
            L_0x0018:
                byte r3 = r2.zze
                java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
                return r3
            L_0x001f:
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzg
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl> r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl> r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzg     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r3 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl r5 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzf     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzg = r3     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                goto L_0x0038
            L_0x0035:
                r3 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                throw r3
            L_0x0038:
                return r3
            L_0x0039:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl r3 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzf
                return r3
            L_0x003c:
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzd"
                r3[r5] = r4
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza> r4 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza.class
                r3[r0] = r4
                java.lang.String r4 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl r5 = com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zzf
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r5, r4, r3)
                return r3
            L_0x0050:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zzb r3 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zzb
                r3.<init>(r1)
                return r3
            L_0x0056:
                com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl r3 = new com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl
                r3.<init>()
                return r3
                switch-data {1->0x0056, 2->0x0050, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzjp.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
