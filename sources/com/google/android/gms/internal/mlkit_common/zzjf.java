package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import kotlin.text.Typography;
public final class zzjf {

    public static final class zza extends zzfq<zza, C0224zza> implements zzhd {
        private static final zza zzf;
        private static volatile zzhl<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzjf$zza$zza  reason: collision with other inner class name */
        public static final class C0224zza extends zzfq.zzb<zza, C0224zza> implements zzhd {
            private C0224zza() {
                super(zza.zzf);
            }

            public /* synthetic */ C0224zza(zzje zzje) {
                this();
            }
        }

        public enum zzb implements zzfv {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final zzfu<zzb> zzc = new zzjg();
            private final int zzd;

            private zzb(int i) {
                this.zzd = i;
            }

            public static zzfx zzb() {
                return zzjh.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzd;
            }
        }

        static {
            zza zza = new zza();
            zzf = zza;
            zzfq.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zza>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zza> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zza r4 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zza r2 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_common.zzjf$zza r4 = com.google.android.gms.internal.mlkit_common.zzjf.zza.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzjf$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zza$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzjf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zza
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzfq<zzb, zza> implements zzhd {
        private static final zzb zzn;
        private static volatile zzhl<zzb> zzo;
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

        public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
            private zza() {
                super(zzb.zzn);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzn = zzb;
            zzfq.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzo
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzo     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzn     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzo = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzb r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzn
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzb.zzn
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_common.zzjf$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_common.zzjf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzb
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzfq<zzc, zzb> implements zzhd {
        private static final zzc zzm;
        private static volatile zzhl<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private zzfy<zzg> zzk = zzfq.zzl();
        private int zzl;

        public enum zza implements zzfv {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4),
            VALIDATION(5);
            
            private static final zzfu<zza> zzg = new zzji();
            private final int zzh;

            private zza(int i) {
                this.zzh = i;
            }

            public static zzfx zzb() {
                return zzjj.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzh;
            }
        }

        public static final class zzb extends zzfq.zzb<zzc, zzb> implements zzhd {
            private zzb() {
                super(zzc.zzm);
            }

            public /* synthetic */ zzb(zzje zzje) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc  reason: collision with other inner class name */
        public static final class C0225zzc extends zzfq<C0225zzc, zza> implements zzhd {
            private static final C0225zzc zzf;
            private static volatile zzhl<C0225zzc> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            /* renamed from: com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc$zza */
            public static final class zza extends zzfq.zzb<C0225zzc, zza> implements zzhd {
                private zza() {
                    super(C0225zzc.zzf);
                }

                public /* synthetic */ zza(zzje zzje) {
                    this();
                }
            }

            static {
                C0225zzc zzc2 = new C0225zzc();
                zzf = zzc2;
                zzfq.zza(C0225zzc.class, zzc2);
            }

            private C0225zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzf
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzc.C0225zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzd extends zzfq<zzd, zza> implements zzhd {
            private static final zzd zzg;
            private static volatile zzhl<zzd> zzh;
            private int zzc;
            private C0225zzc zzd;
            private C0225zzc zze;
            private boolean zzf;

            public static final class zza extends zzfq.zzb<zzd, zza> implements zzhd {
                private zza() {
                    super(zzd.zzg);
                }

                public /* synthetic */ zza(zzje zzje) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzg = zzd2;
                zzfq.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzg
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0052:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x0058:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public enum zze implements zzfv {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final zzfu<zze> zzg = new zzjk();
            private final int zzh;

            private zze(int i) {
                this.zzh = i;
            }

            public static zzfx zzb() {
                return zzjm.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzm = zzc2;
            zzfq.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzn
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzn     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzc r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzm     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzn = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzc r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzm
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zze.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzg> r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.class
                r2[r3] = r4
                r3 = 12
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007"
                com.google.android.gms.internal.mlkit_common.zzjf$zzc r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzc.zzm
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0089:
                com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x008f:
                com.google.android.gms.internal.mlkit_common.zzjf$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzc
                r2.<init>()
                return r2
                switch-data {1->0x008f, 2->0x0089, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzfq<zzd, zza> implements zzhd {
        private static final zzd zzk;
        private static volatile zzhl<zzd> zzl;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private int zzg;
        private int zzh;
        private String zzi = "";
        private int zzj;

        public static final class zza extends zzfq.zzb<zzd, zza> implements zzhd {
            private zza() {
                super(zzd.zzk);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzk = zzd2;
            zzfq.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzd>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzd r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzd r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzk
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzd r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzd.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzjf$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_common.zzjf$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzd
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzfq<zze, zza> implements zzhd {
        private static final zze zze;
        private static volatile zzhl<zze> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzfq.zzb<zze, zza> implements zzhd {
            private zza() {
                super(zze.zze);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zze = zze2;
            zzfq.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zze>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zze> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zze.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zze> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zze> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zze.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zze r4 = com.google.android.gms.internal.mlkit_common.zzjf.zze.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zze.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zze r2 = com.google.android.gms.internal.mlkit_common.zzjf.zze.zze
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
                com.google.android.gms.internal.mlkit_common.zzjf$zze r4 = com.google.android.gms.internal.mlkit_common.zzjf.zze.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_common.zzjf$zze$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zze$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_common.zzjf$zze r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zze
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzfq<zzf, zza> implements zzhd {
        private static final zzf zzo;
        private static volatile zzhl<zzf> zzp;
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

        public static final class zza extends zzfq.zzb<zzf, zza> implements zzhd {
            private zza() {
                super(zzf.zzo);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzo = zzf2;
            zzfq.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzf>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzf> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzp
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzf> r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzf> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzp     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_common.zzfq$zza r3 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_common.zzjf$zzf r5 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzo     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzp = r3     // Catch:{ all -> 0x0035 }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzf r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzo
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
                com.google.android.gms.internal.mlkit_common.zzfx r5 = com.google.android.gms.internal.mlkit_common.zzjl.zzb()
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzf r5 = com.google.android.gms.internal.mlkit_common.zzjf.zzf.zzo
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r5, r4, r3)
                return r3
            L_0x0089:
                com.google.android.gms.internal.mlkit_common.zzjf$zzf$zza r3 = new com.google.android.gms.internal.mlkit_common.zzjf$zzf$zza
                r3.<init>(r1)
                return r3
            L_0x008f:
                com.google.android.gms.internal.mlkit_common.zzjf$zzf r3 = new com.google.android.gms.internal.mlkit_common.zzjf$zzf
                r3.<init>()
                return r3
                switch-data {1->0x008f, 2->0x0089, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzfq<zzg, zza> implements zzhd {
        private static final zzg zzd;
        private static volatile zzhl<zzg> zze;
        private zzfw zzc = zzfq.zzk();

        public static final class zza extends zzfq.zzb<zzg, zza> implements zzhd {
            private zza() {
                super(zzg.zzd);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zzg zzg = new zzg();
            zzd = zzg;
            zzfq.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzg>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r1, java.lang.Object r2, java.lang.Object r3) {
            /*
                r0 = this;
                int[] r2 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzg> r1 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.zze
                if (r1 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzg> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.class
                monitor-enter(r2)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzg> r1 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.zze     // Catch:{ all -> 0x002c }
                if (r1 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r1 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzg r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.zzd     // Catch:{ all -> 0x002c }
                r1.<init>(r3)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzg.zze = r1     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzg r1 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.zzd
                return r1
            L_0x0033:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r2 = 0
                java.lang.String r3 = "zzc"
                r1[r2] = r3
                java.lang.String r2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016"
                com.google.android.gms.internal.mlkit_common.zzjf$zzg r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzg.zzd
                java.lang.Object r1 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r3, r2, r1)
                return r1
            L_0x0043:
                com.google.android.gms.internal.mlkit_common.zzjf$zzg$zza r1 = new com.google.android.gms.internal.mlkit_common.zzjf$zzg$zza
                r1.<init>(r2)
                return r1
            L_0x0049:
                com.google.android.gms.internal.mlkit_common.zzjf$zzg r1 = new com.google.android.gms.internal.mlkit_common.zzjf$zzg
                r1.<init>()
                return r1
                switch-data {1->0x0049, 2->0x0043, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzfq<zzh, zza> implements zzhd {
        private static final zzh zzf;
        private static volatile zzhl<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        public static final class zza extends zzfq.zzb<zzh, zza> implements zzhd {
            private zza() {
                super(zzh.zzf);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzfq.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzh>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzh> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzh r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzh r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzf
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzh r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzjf$zzh$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzjf$zzh r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzfq<zzi, zza> implements zzhd {
        private static final zzi zzd;
        private static volatile zzhl<zzi> zze;
        private zzfy<zzb> zzc = zzfq.zzl();

        public static final class zza extends zzfq.zzb<zzi, zza> implements zzhd {
            private zza() {
                super(zzi.zzd);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private String zzd = "";
            private int zze;
            private String zzf = "";
            private long zzg;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ zza(zzje zzje) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzh = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzh
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzi zzi = new zzi();
            zzd = zzi;
            zzfq.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zze
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzi> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zze     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzi r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzd     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzi.zze = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzi r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzd
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzb.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_common.zzjf$zzi r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzi.zzd
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_common.zzjf$zzi$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzi$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_common.zzjf$zzi r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzi
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzfq<zzj, zza> implements zzhd {
        private static final zzj zzg;
        private static volatile zzhl<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        public static final class zza extends zzfq.zzb<zzj, zza> implements zzhd {
            private zza() {
                super(zzj.zzg);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        public enum zzb implements zzfv {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3),
            EDGETPU(4);
            
            private static final zzfu<zzb> zzf = new zzjp();
            private final int zzg;

            private zzb(int i) {
                this.zzg = i;
            }

            public static zzfx zzb() {
                return zzjq.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzg;
            }
        }

        static {
            zzj zzj = new zzj();
            zzg = zzj;
            zzfq.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzj>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzj> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzj r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzj r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzg
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzjf$zzj r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzj.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_common.zzjf$zzj$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_common.zzjf$zzj r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzj
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzfq<zzk, zzb> implements zzhd {
        private static final zzk zzf;
        private static volatile zzhl<zzk> zzg;
        private int zzc;
        private int zzd;
        private float zze;

        public enum zza implements zzfv {
            UNKNOWN_METRIC(0),
            MEAN_ABSOLUTE_ERROR(1),
            MEAN_SQUARED_ERROR(2),
            ROOT_MEAN_SQUARED_ERROR(3);
            
            private static final zzfu<zza> zze = new zzjs();
            private final int zzf;

            private zza(int i) {
                this.zzf = i;
            }

            public static zzfx zzb() {
                return zzjr.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzf;
            }
        }

        public static final class zzb extends zzfq.zzb<zzk, zzb> implements zzhd {
            private zzb() {
                super(zzk.zzf);
            }

            public /* synthetic */ zzb(zzje zzje) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzf = zzk;
            zzfq.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzk>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzk> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf$zzk r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzk r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001"
                com.google.android.gms.internal.mlkit_common.zzjf$zzk r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzjf$zzk$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzk$zzb
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzjf$zzk r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzk
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzfq.zzc<zzl, zza> implements zzhd {
        private static final zzl zzf;
        private static volatile zzhl<zzl> zzg;
        private zzfy<zzb> zzd = zzfq.zzl();
        private byte zze = 2;

        public static final class zza extends zzfq.zzd<zzl, zza> implements zzhd {
            private zza() {
                super(zzl.zzf);
            }

            public /* synthetic */ zza(zzje zzje) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzg;
            private static volatile zzhl<zzb> zzh;
            private int zzc;
            private int zzd;
            private int zze;
            private zzfy<zzk> zzf = zzfq.zzl();

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzg);
                }

                public /* synthetic */ zza(zzje zzje) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzg = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb r2 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzg
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
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzk> r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzk.class
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003\u001b"
                    com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzl zzl = new zzl();
            zzf = zzl;
            zzfq.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_common.zzje.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzg
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzl> r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzjf$zzl> r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzg     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_common.zzfq$zza r3 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_common.zzjf$zzl r5 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzf     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzg = r3     // Catch:{ all -> 0x0035 }
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
                com.google.android.gms.internal.mlkit_common.zzjf$zzl r3 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzf
                return r3
            L_0x003c:
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzd"
                r3[r5] = r4
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb> r4 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzb.class
                r3[r0] = r4
                java.lang.String r4 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_common.zzjf$zzl r5 = com.google.android.gms.internal.mlkit_common.zzjf.zzl.zzf
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r5, r4, r3)
                return r3
            L_0x0050:
                com.google.android.gms.internal.mlkit_common.zzjf$zzl$zza r3 = new com.google.android.gms.internal.mlkit_common.zzjf$zzl$zza
                r3.<init>(r1)
                return r3
            L_0x0056:
                com.google.android.gms.internal.mlkit_common.zzjf$zzl r3 = new com.google.android.gms.internal.mlkit_common.zzjf$zzl
                r3.<init>()
                return r3
                switch-data {1->0x0056, 2->0x0050, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzjf.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
