package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import kotlin.text.Typography;
public final class zzhv {

    public static final class zza extends zzej<zza, zzb> implements zzft {
        private static final zza zzf;
        private static volatile zzgb<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhv$zza$zza  reason: collision with other inner class name */
        public enum EnumC0228zza implements zzel {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final zzeo<EnumC0228zza> zzc = new zzhz();
            private final int zzd;

            private EnumC0228zza(int i) {
                this.zzd = i;
            }

            public static zzen zzb() {
                return zzhy.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + EnumC0228zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzd;
            }
        }

        public static final class zzb extends zzej.zza<zza, zzb> implements zzft {
            private zzb() {
                super(zza.zzf);
            }

            public /* synthetic */ zzb(zzhx zzhx) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzf = zza;
            zzej.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.EnumC0228zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zza
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzej<zzb, zza> implements zzft {
        private static final zzb zzn;
        private static volatile zzgb<zzb> zzo;
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

        public static final class zza extends zzej.zza<zzb, zza> implements zzft {
            private zza() {
                super(zzb.zzn);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzn = zzb;
            zzej.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzo
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzo     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzn     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzo = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzn
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zzn
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzej<zzc, C0229zzc> implements zzft {
        private static final zzc zzm;
        private static volatile zzgb<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private zzes<zzg> zzk = zzej.zzl();
        private int zzl;

        public enum zza implements zzel {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4),
            VALIDATION(5);
            
            private static final zzeo<zza> zzg = new zzib();
            private final int zzh;

            private zza(int i) {
                this.zzh = i;
            }

            public static zzen zzb() {
                return zzia.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzh;
            }
        }

        public static final class zzb extends zzej<zzb, zza> implements zzft {
            private static final zzb zzf;
            private static volatile zzgb<zzb> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            public static final class zza extends zzej.zza<zzb, zza> implements zzft {
                private zza() {
                    super(zzb.zzf);
                }

                public /* synthetic */ zza(zzhx zzhx) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzf = zzb;
                zzej.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzf
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzc  reason: collision with other inner class name */
        public static final class C0229zzc extends zzej.zza<zzc, C0229zzc> implements zzft {
            private C0229zzc() {
                super(zzc.zzm);
            }

            public /* synthetic */ C0229zzc(zzhx zzhx) {
                this();
            }
        }

        public static final class zzd extends zzej<zzd, zza> implements zzft {
            private static final zzd zzg;
            private static volatile zzgb<zzd> zzh;
            private int zzc;
            private zzb zzd;
            private zzb zze;
            private boolean zzf;

            public static final class zza extends zzej.zza<zzd, zza> implements zzft {
                private zza() {
                    super(zzd.zzg);
                }

                public /* synthetic */ zza(zzhx zzhx) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzg = zzd2;
                zzej.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzg
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0052:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x0058:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public enum zze implements zzel {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final zzeo<zze> zzg = new zzid();
            private final int zzh;

            private zze(int i) {
                this.zzh = i;
            }

            public static zzen zzb() {
                return zzic.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzm = zzc2;
            zzej.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzn
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzn     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzm     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzn = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzm
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zze.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.class
                r2[r3] = r4
                r3 = 12
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zzm
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzc
                r2.<init>(r3)
                return r2
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc
                r2.<init>()
                return r2
                switch-data {1->0x008f, 2->0x0089, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzej<zzd, zza> implements zzft {
        private static final zzd zzk;
        private static volatile zzgb<zzd> zzl;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private int zzg;
        private int zzh;
        private String zzi = "";
        private int zzj;

        public static final class zza extends zzej.zza<zzd, zza> implements zzft {
            private zza() {
                super(zzd.zzk);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzk = zzd2;
            zzej.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzej<zze, zza> implements zzft {
        private static final zze zze;
        private static volatile zzgb<zze> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzej.zza<zze, zza> implements zzft {
            private zza() {
                super(zze.zze);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zze = zze2;
            zzej.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zze>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zze> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zze r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zze
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zze$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zze r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zze
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzej<zzf, zza> implements zzft {
        private static final zzf zzo;
        private static volatile zzgb<zzf> zzp;
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

        public static final class zza extends zzej.zza<zzf, zza> implements zzft {
            private zza() {
                super(zzf.zzo);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzo = zzf2;
            zzej.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzp
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzp     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r3 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf r5 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzo     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzp = r3     // Catch:{ all -> 0x0035 }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzo
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r5 = com.google.android.gms.internal.mlkit_vision_common.zzif.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf r5 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zzo
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r5, r4, r3)
                return r3
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf$zza
                r3.<init>(r1)
                return r3
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf
                r3.<init>()
                return r3
                switch-data {1->0x008f, 2->0x0089, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzej<zzg, zza> implements zzft {
        private static final zzg zzd;
        private static volatile zzgb<zzg> zze;
        private zzeq zzc = zzej.zzk();

        public static final class zza extends zzej.zza<zzg, zza> implements zzft {
            private zza() {
                super(zzg.zzd);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zzg zzg = new zzg();
            zzd = zzg;
            zzej.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r1, java.lang.Object r2, java.lang.Object r3) {
            /*
                r0 = this;
                int[] r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg> r1 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zze
                if (r1 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.class
                monitor-enter(r2)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg> r1 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zze     // Catch:{ all -> 0x002c }
                if (r1 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r1 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zzd     // Catch:{ all -> 0x002c }
                r1.<init>(r3)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zze = r1     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg r1 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zzd
                return r1
            L_0x0033:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r2 = 0
                java.lang.String r3 = "zzc"
                r1[r2] = r3
                java.lang.String r2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zzd
                java.lang.Object r1 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r3, r2, r1)
                return r1
            L_0x0043:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg$zza r1 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg$zza
                r1.<init>(r2)
                return r1
            L_0x0049:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg r1 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg
                r1.<init>()
                return r1
                switch-data {1->0x0049, 2->0x0043, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzej<zzh, zza> implements zzft {
        private static final zzh zzf;
        private static volatile zzgb<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        public static final class zza extends zzej.zza<zzh, zza> implements zzft {
            private zza() {
                super(zzh.zzf);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzej.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzej<zzi, zzb> implements zzft {
        private static final zzi zzd;
        private static volatile zzgb<zzi> zze;
        private zzes<zza> zzc = zzej.zzl();

        public static final class zza extends zzej<zza, C0230zza> implements zzft {
            private static final zza zzh;
            private static volatile zzgb<zza> zzi;
            private int zzc;
            private String zzd = "";
            private int zze;
            private String zzf = "";
            private long zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza$zza  reason: collision with other inner class name */
            public static final class C0230zza extends zzej.zza<zza, C0230zza> implements zzft {
                private C0230zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0230zza(zzhx zzhx) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzh = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzi, zzb> implements zzft {
            private zzb() {
                super(zzi.zzd);
            }

            public /* synthetic */ zzb(zzhx zzhx) {
                this();
            }
        }

        static {
            zzi zzi = new zzi();
            zzd = zzi;
            zzej.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zze
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zze     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zzd     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zze = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zzd
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zzd
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzej<zzj, zzb> implements zzft {
        private static final zzj zzg;
        private static volatile zzgb<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        public enum zza implements zzel {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3),
            EDGETPU(4);
            
            private static final zzeo<zza> zzf = new zzii();
            private final int zzg;

            private zza(int i) {
                this.zzg = i;
            }

            public static zzen zzb() {
                return zzih.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzg;
            }
        }

        public static final class zzb extends zzej.zza<zzj, zzb> implements zzft {
            private zzb() {
                super(zzj.zzg);
            }

            public /* synthetic */ zzb(zzhx zzhx) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zzg = zzj;
            zzej.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzej<zzk, zza> implements zzft {
        private static final zzk zzf;
        private static volatile zzgb<zzk> zzg;
        private int zzc;
        private int zzd;
        private float zze;

        public static final class zza extends zzej.zza<zzk, zza> implements zzft {
            private zza() {
                super(zzk.zzf);
            }

            public /* synthetic */ zza(zzhx zzhx) {
                this();
            }
        }

        public enum zzb implements zzel {
            UNKNOWN_METRIC(0),
            MEAN_ABSOLUTE_ERROR(1),
            MEAN_SQUARED_ERROR(2),
            ROOT_MEAN_SQUARED_ERROR(3);
            
            private static final zzeo<zzb> zze = new zzij();
            private final int zzf;

            private zzb(int i) {
                this.zzf = i;
            }

            public static zzen zzb() {
                return zzik.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzk zzk = new zzk();
            zzf = zzk;
            zzej.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzej.zze<zzl, zzb> implements zzft {
        private static final zzl zzf;
        private static volatile zzgb<zzl> zzg;
        private zzes<zza> zzd = zzej.zzl();
        private byte zze = 2;

        public static final class zza extends zzej<zza, C0231zza> implements zzft {
            private static final zza zzg;
            private static volatile zzgb<zza> zzh;
            private int zzc;
            private int zzd;
            private int zze;
            private zzes<zzk> zzf = zzej.zzl();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza$zza  reason: collision with other inner class name */
            public static final class C0231zza extends zzej.zza<zza, C0231zza> implements zzft {
                private C0231zza() {
                    super(zza.zzg);
                }

                public /* synthetic */ C0231zza(zzhx zzhx) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzg = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzg
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
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzk.class
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003\u001b"
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zzb<zzl, zzb> implements zzft {
            private zzb() {
                super(zzl.zzf);
            }

            public /* synthetic */ zzb(zzhx zzhx) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzf = zzl;
            zzej.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzg
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzg     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r3 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl r5 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzf     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzg = r3     // Catch:{ all -> 0x0035 }
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
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl r3 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzf
                return r3
            L_0x003c:
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzd"
                r3[r5] = r4
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza.class
                r3[r0] = r4
                java.lang.String r4 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl r5 = com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zzf
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r5, r4, r3)
                return r3
            L_0x0050:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zzb r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zzb
                r3.<init>(r1)
                return r3
            L_0x0056:
                com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl
                r3.<init>()
                return r3
                switch-data {1->0x0056, 2->0x0050, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhv.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
