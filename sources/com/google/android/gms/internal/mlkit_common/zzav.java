package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzjf;
import kotlin.text.Typography;
public final class zzav {

    public static final class zza extends zzfq<zza, C0217zza> implements zzhd {
        private static final zza zzg;
        private static volatile zzhl<zza> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zza$zza  reason: collision with other inner class name */
        public static final class C0217zza extends zzfq.zzb<zza, C0217zza> implements zzhd {
            private C0217zza() {
                super(zza.zzg);
            }

            public /* synthetic */ C0217zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, C0218zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0218zza extends zzfq.zzb<zzb, C0218zza> implements zzhd {
                private C0218zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ C0218zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zza$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zza$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zza$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzav$zza$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzav$zza$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zza$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzav$zza$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zza$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zza.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zza zza = new zza();
            zzg = zza;
            zzfq.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza> r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zza> r3 = com.google.android.gms.internal.mlkit_common.zzav.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zza> r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zza r4 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zza r2 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zza r4 = com.google.android.gms.internal.mlkit_common.zzav.zza.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zza$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zza
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaa extends zzfq<zzaa, zza> implements zzhd {
        private static final zzaa zzg;
        private static volatile zzhl<zzaa> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzfq.zzb<zzaa, zza> implements zzhd {
            private zza() {
                super(zzaa.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzg = zzaa;
            zzfq.zza(zzaa.class, zzaa);
        }

        private zzaa() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaa>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaa> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaa> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaa> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaa r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaa r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzg
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzaa r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaa.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_common.zzav$zzaa$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaa$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_common.zzav$zzaa r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaa
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaa.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzab extends zzfq<zzab, zza> implements zzhd {
        private static final zzab zzj;
        private static volatile zzhl<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        public static final class zza extends zzfq.zzb<zzab, zza> implements zzhd {
            private zza() {
                super(zzab.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzab zzab = new zzab();
            zzj = zzab;
            zzfq.zza(zzab.class, zzab);
        }

        private zzab() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzab>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0061;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzab> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzab.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzab> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzab.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzab> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzab.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzab r4 = com.google.android.gms.internal.mlkit_common.zzav.zzab.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzab.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzab r2 = com.google.android.gms.internal.mlkit_common.zzav.zzab.zzj
                return r2
            L_0x0033:
                r2 = 7
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
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005"
                com.google.android.gms.internal.mlkit_common.zzav$zzab r4 = com.google.android.gms.internal.mlkit_common.zzav.zzab.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_common.zzav$zzab$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzab$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzav$zzab r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzab
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzab.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzac extends zzfq<zzac, zza> implements zzhd {
        private static final zzac zzj;
        private static volatile zzhl<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        public static final class zza extends zzfq.zzb<zzac, zza> implements zzhd {
            private zza() {
                super(zzac.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public enum zzb implements zzfv {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzfu<zzb> zzd = new zzbk();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzbl.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzc implements zzfv {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzfu<zzc> zzd = new zzbn();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzbm.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzd implements zzfv {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzfu<zzd> zzd = new zzbo();
            private final int zze;

            private zzd(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzbp.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        public enum zze implements zzfv {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzfu<zze> zzd = new zzbr();
            private final int zze;

            private zze(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzbq.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzac = new zzac();
            zzj = zzac;
            zzfq.zza(zzac.class, zzac);
        }

        private zzac() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzac>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0087;
                    case 2: goto L_0x0081;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzac> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzac> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzac.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzac> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzac r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzac.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzac r2 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzj
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzb.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zze.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzc.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_common.zzav$zzac r4 = com.google.android.gms.internal.mlkit_common.zzav.zzac.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_common.zzav$zzac$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzac$zza
                r2.<init>(r3)
                return r2
            L_0x0087:
                com.google.android.gms.internal.mlkit_common.zzav$zzac r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzac
                r2.<init>()
                return r2
                switch-data {1->0x0087, 2->0x0081, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzac.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzae extends zzfq<zzae, zza> implements zzhd {
        private static final zzae zzg;
        private static volatile zzhl<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public static final class zza extends zzfq.zzb<zzae, zza> implements zzhd {
            private zza() {
                super(zzae.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public enum zzb implements zzfv {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzfu<zzb> zzj = new zzbs();
            private final int zzk;

            private zzb(int i) {
                this.zzk = i;
            }

            public static zzfx zzb() {
                return zzbt.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzk;
            }
        }

        static {
            zzae zzae = new zzae();
            zzg = zzae;
            zzfq.zza(zzae.class, zzae);
        }

        private zzae() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzae>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzae> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzae> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzae.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzae> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzae r4 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzae.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzae r2 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzg
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzae r4 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_common.zzav$zzae$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzae$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_common.zzav$zzae r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzae
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzae.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaf extends zzfq<zzaf, zza> implements zzhd {
        private static final zzaf zzl;
        private static volatile zzhl<zzaf> zzm;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;
        private zzfy<zzbf> zzk = zzfq.zzl();

        public static final class zza extends zzfq.zzb<zzaf, zza> implements zzhd {
            private zza() {
                super(zzaf.zzl);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzaf zzaf = new zzaf();
            zzl = zzaf;
            zzfq.zza(zzaf.class, zzaf);
        }

        private zzaf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaf>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0081;
                    case 2: goto L_0x007b;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaf> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaf r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzl
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                r3 = 10
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006\b\u001b"
                com.google.android.gms.internal.mlkit_common.zzav$zzaf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaf.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_common.zzav$zzaf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaf$zza
                r2.<init>(r3)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_common.zzav$zzaf r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaf
                r2.<init>()
                return r2
                switch-data {1->0x0081, 2->0x007b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzag extends zzfq<zzag, zzb> implements zzhd {
        private static final zzag zzk;
        private static volatile zzhl<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        public enum zza implements zzfv {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzfu<zza> zzg = new zzbv();
            private final int zzh;

            private zza(int i) {
                this.zzh = i;
            }

            public static zzfx zzb() {
                return zzbu.zza;
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

        public static final class zzb extends zzfq.zzb<zzag, zzb> implements zzhd {
            private zzb() {
                super(zzag.zzk);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        static {
            zzag zzag = new zzag();
            zzk = zzag;
            zzfq.zza(zzag.class, zzag);
        }

        private zzag() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzag>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007d;
                    case 2: goto L_0x0077;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzag> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzag> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzag.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzag> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzag r4 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzag.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzag r2 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zzk
                return r2
            L_0x0033:
                r2 = 10
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zza.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzae.zzb.zzb()
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
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006"
                com.google.android.gms.internal.mlkit_common.zzav$zzag r4 = com.google.android.gms.internal.mlkit_common.zzav.zzag.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_common.zzav$zzag$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzag$zzb
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_common.zzav$zzag r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzag
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzag.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzah extends zzfq<zzah, zza> implements zzhd {
        private static final zzah zzg;
        private static volatile zzhl<zzah> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzfq.zzb<zzah, zza> implements zzhd {
            private zza() {
                super(zzah.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzah zzah = new zzah();
            zzg = zzah;
            zzfq.zza(zzah.class, zzah);
        }

        private zzah() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzah>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzah> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzah.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzah> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzah.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzah> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzah.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzah r4 = com.google.android.gms.internal.mlkit_common.zzav.zzah.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzah.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzah r2 = com.google.android.gms.internal.mlkit_common.zzav.zzah.zzg
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzah r4 = com.google.android.gms.internal.mlkit_common.zzav.zzah.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_common.zzav$zzah$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzah$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_common.zzav$zzah r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzah
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzah.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzai extends zzfq<zzai, zza> implements zzhd {
        private static final zzai zzg;
        private static volatile zzhl<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        public static final class zza extends zzfq.zzb<zzai, zza> implements zzhd {
            private zza() {
                super(zzai.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzai zzai = new zzai();
            zzg = zzai;
            zzfq.zza(zzai.class, zzai);
        }

        private zzai() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzai>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzai> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzai.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzai> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzai.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzai> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzai.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzai r4 = com.google.android.gms.internal.mlkit_common.zzav.zzai.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzai.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzai r2 = com.google.android.gms.internal.mlkit_common.zzav.zzai.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzai r4 = com.google.android.gms.internal.mlkit_common.zzav.zzai.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzai$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzai$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzai r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzai
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzai.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaj extends zzfq<zzaj, zzb> implements zzhd {
        private static final zzaj zze;
        private static volatile zzhl<zzaj> zzf;
        private int zzc;
        private int zzd;

        public enum zza implements zzfv {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzfu<zza> zzc = new zzbx();
            private final int zzd;

            private zza(int i) {
                this.zzd = i;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i != 1) {
                    return null;
                }
                return TRANSLATE;
            }

            public static zzfx zzb() {
                return zzbw.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzd;
            }
        }

        public static final class zzb extends zzfq.zzb<zzaj, zzb> implements zzhd {
            private zzb() {
                super(zzaj.zze);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }

            public final zzb zza(zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaj) this.zza).zza(zza);
                return this;
            }
        }

        static {
            zzaj zzaj = new zzaj();
            zze = zzaj;
            zzfq.zza(zzaj.class, zzaj);
        }

        private zzaj() {
        }

        public static zzb zza() {
            return (zzb) zze.zzh();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            this.zzd = zza2.zza();
            this.zzc |= 1;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaj>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0055;
                    case 2: goto L_0x004f;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaj> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaj> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaj> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaj r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaj r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zze
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_common.zzav$zzaj r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_common.zzav$zzaj$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaj$zzb
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_common.zzav$zzaj r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzan extends zzfq<zzan, zza> implements zzhd {
        private static final zzan zzh;
        private static volatile zzhl<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        public static final class zza extends zzfq.zzb<zzan, zza> implements zzhd {
            private zza() {
                super(zzan.zzh);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public enum zzb implements zzfv {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzfu<zzb> zzh = new zzce();
            private final int zzi;

            private zzb(int i) {
                this.zzi = i;
            }

            public static zzfx zzb() {
                return zzcf.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzan zzan = new zzan();
            zzh = zzan;
            zzfq.zza(zzan.class, zzan);
        }

        private zzan() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzan>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzan> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzan> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzan.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzan> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzan r4 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzan.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzan r2 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzh
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003"
                com.google.android.gms.internal.mlkit_common.zzav$zzan r4 = com.google.android.gms.internal.mlkit_common.zzav.zzan.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzav$zzan$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzan$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzav$zzan r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzan
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzan.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzao extends zzfq<zzao, zzc> implements zzhd {
        private static final zzfz<Integer, zza> zzg = new zzch();
        private static final zzfz<Integer, zzb> zzi = new zzcg();
        private static final zzao zzk;
        private static volatile zzhl<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzdf.zza zze;
        private zzfw zzf = zzfq.zzk();
        private zzfw zzh = zzfq.zzk();
        private zzae zzj;

        public enum zza implements zzfv {
            FORMAT_UNKNOWN(0),
            FORMAT_CODE_128(1),
            FORMAT_CODE_39(2),
            FORMAT_CODE_93(4),
            FORMAT_CODABAR(8),
            FORMAT_DATA_MATRIX(16),
            FORMAT_EAN_13(32),
            FORMAT_EAN_8(64),
            FORMAT_ITF(128),
            FORMAT_QR_CODE(256),
            FORMAT_UPC_A(512),
            FORMAT_UPC_E(1024),
            FORMAT_PDF417(2048),
            FORMAT_AZTEC(4096);
            
            private static final zzfu<zza> zzo = new zzci();
            private final int zzp;

            private zza(int i) {
                this.zzp = i;
            }

            public static zzfx zzb() {
                return zzcj.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzp;
            }
        }

        public enum zzb implements zzfv {
            TYPE_UNKNOWN(0),
            TYPE_CONTACT_INFO(1),
            TYPE_EMAIL(2),
            TYPE_ISBN(3),
            TYPE_PHONE(4),
            TYPE_PRODUCT(5),
            TYPE_SMS(6),
            TYPE_TEXT(7),
            TYPE_URL(8),
            TYPE_WIFI(9),
            TYPE_GEO(10),
            TYPE_CALENDAR_EVENT(11),
            TYPE_DRIVER_LICENSE(12);
            
            private static final zzfu<zzb> zzn = new zzcl();
            private final int zzo;

            private zzb(int i) {
                this.zzo = i;
            }

            public static zzfx zzb() {
                return zzck.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzo;
            }
        }

        public static final class zzc extends zzfq.zzb<zzao, zzc> implements zzhd {
            private zzc() {
                super(zzao.zzk);
            }

            public /* synthetic */ zzc(zzau zzau) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzch, com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzao$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzcg, com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzao$zzb>] */
        static {
            zzao zzao = new zzao();
            zzk = zzao;
            zzfq.zza(zzao.class, zzao);
        }

        private zzao() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzao>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0071;
                    case 2: goto L_0x006b;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzao> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzao> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzao.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzao> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzao r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzao.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzao r2 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzk
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzb.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzao r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x006b:
                com.google.android.gms.internal.mlkit_common.zzav$zzao$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzao$zzc
                r2.<init>(r3)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_common.zzav$zzao r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzao
                r2.<init>()
                return r2
                switch-data {1->0x0071, 2->0x006b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzao.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzap extends zzfq<zzap, zza> implements zzhd {
        private static final zzap zzj;
        private static volatile zzhl<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzdf.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        public static final class zza extends zzfq.zzb<zzap, zza> implements zzhd {
            private zza() {
                super(zzap.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzap zzap = new zzap();
            zzj = zzap;
            zzfq.zza(zzap.class, zzap);
        }

        private zzap() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzap>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0061;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzap> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzap.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzap> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzap.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzap> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzap.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzap r4 = com.google.android.gms.internal.mlkit_common.zzav.zzap.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzap.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzap r2 = com.google.android.gms.internal.mlkit_common.zzav.zzap.zzj
                return r2
            L_0x0033:
                r2 = 7
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
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005"
                com.google.android.gms.internal.mlkit_common.zzav$zzap r4 = com.google.android.gms.internal.mlkit_common.zzav.zzap.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_common.zzav$zzap$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzap$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzav$zzap r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzap
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzap.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaq extends zzfq<zzaq, zza> implements zzhd {
        private static final zzaq zzf;
        private static volatile zzhl<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        public static final class zza extends zzfq.zzb<zzaq, zza> implements zzhd {
            private zza() {
                super(zzaq.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzaq zzaq = new zzaq();
            zzf = zzaq;
            zzfq.zza(zzaq.class, zzaq);
        }

        private zzaq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaq>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaq> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaq> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaq> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaq r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaq r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzaq r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaq.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzav$zzaq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaq$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzav$zzaq r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaq
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzar extends zzfq<zzar, zza> implements zzhd {
        private static final zzar zzi;
        private static volatile zzhl<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        public static final class zza extends zzfq.zzb<zzar, zza> implements zzhd {
            private zza() {
                super(zzar.zzi);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzar zzar = new zzar();
            zzi = zzar;
            zzfq.zza(zzar.class, zzar);
        }

        private zzar() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzar>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzar> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzar.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzar> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzar.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzar> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzar.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzar r4 = com.google.android.gms.internal.mlkit_common.zzav.zzar.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzar.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzar r2 = com.google.android.gms.internal.mlkit_common.zzav.zzar.zzi
                return r2
            L_0x0033:
                r2 = 6
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
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004"
                com.google.android.gms.internal.mlkit_common.zzav$zzar r4 = com.google.android.gms.internal.mlkit_common.zzav.zzar.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzav$zzar$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzar$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzav$zzar r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzar
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzar.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzas extends zzfq<zzas, zza> implements zzhd {
        private static final zzfz<Integer, zzbf> zzf = new zzcm();
        private static final zzas zzj;
        private static volatile zzhl<zzas> zzk;
        private int zzc;
        private zzat zzd;
        private zzfw zze = zzfq.zzk();
        private long zzg;
        private long zzh;
        private zzfy<zzbf> zzi = zzfq.zzl();

        public static final class zza extends zzfq.zzb<zzas, zza> implements zzhd {
            private zza() {
                super(zzas.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzbf>, com.google.android.gms.internal.mlkit_common.zzcm] */
        static {
            zzas zzas = new zzas();
            zzj = zzas;
            zzfq.zza(zzas.class, zzas);
        }

        private zzas() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzas>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzas> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzas.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzas> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzas.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzas> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzas.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzas r4 = com.google.android.gms.internal.mlkit_common.zzav.zzas.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzas.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzas r2 = com.google.android.gms.internal.mlkit_common.zzav.zzas.zzj
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002\u0005\u001b"
                com.google.android.gms.internal.mlkit_common.zzav$zzas r4 = com.google.android.gms.internal.mlkit_common.zzav.zzas.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzav$zzas$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzas$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzav$zzas r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzas
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzas.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzat extends zzfq<zzat, zza> implements zzhd {
        private static final zzat zzg;
        private static volatile zzhl<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        public static final class zza extends zzfq.zzb<zzat, zza> implements zzhd {
            private zza() {
                super(zzat.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzat zzat = new zzat();
            zzg = zzat;
            zzfq.zza(zzat.class, zzat);
        }

        private zzat() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzat>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzat> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzat.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzat> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzat.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzat> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzat.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzat r4 = com.google.android.gms.internal.mlkit_common.zzav.zzat.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzat.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzat r2 = com.google.android.gms.internal.mlkit_common.zzav.zzat.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzat r4 = com.google.android.gms.internal.mlkit_common.zzav.zzat.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzat$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzat$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzat r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzat
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzat.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzau extends zzfq<zzau, zza> implements zzhd {
        private static final zzau zzh;
        private static volatile zzhl<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        public static final class zza extends zzfq.zzb<zzau, zza> implements zzhd {
            private zza() {
                super(zzau.zzh);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzf;
            private static volatile zzhl<zzb> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzf);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzf = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzf
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
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001"
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzc extends zzfq<zzc, zza> implements zzhd {
            private static final zzc zze;
            private static volatile zzhl<zzc> zzf;
            private int zzc;
            private zzb zzd;

            public static final class zza extends zzfq.zzb<zzc, zza> implements zzhd {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzfq.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zze
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000"
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzau.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzd extends zzfq<zzd, zza> implements zzhd {
            private static final zzd zzd;
            private static volatile zzhl<zzd> zze;
            private zzfy<zzb> zzc = zzfq.zzl();

            public static final class zza extends zzfq.zzb<zzd, zza> implements zzhd {
                private zza() {
                    super(zzd.zzd);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzd = zzd2;
                zzfq.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zze
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zze     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zzd     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zze = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zzd
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzau$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzb.class
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zzd
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzau.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzau zzau = new zzau();
            zzh = zzau;
            zzfq.zza(zzau.class, zzau);
        }

        private zzau() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzau> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzau.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzau> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzau r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzau.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzau r2 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzh
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
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                com.google.android.gms.internal.mlkit_common.zzav$zzau r4 = com.google.android.gms.internal.mlkit_common.zzav.zzau.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_common.zzav$zzau$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_common.zzav$zzau r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzau
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzau.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zzav  reason: collision with other inner class name */
    public static final class C0219zzav extends zzfq<C0219zzav, zza> implements zzhd {
        private static final C0219zzav zzf;
        private static volatile zzhl<C0219zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zzav$zza */
        public static final class zza extends zzfq.zzb<C0219zzav, zza> implements zzhd {
            private zza() {
                super(C0219zzav.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            C0219zzav zzav = new C0219zzav();
            zzf = zzav;
            zzfq.zza(C0219zzav.class, zzav);
        }

        private C0219zzav() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzav>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzav> r2 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzav> r3 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzav> r2 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzav r4 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzav r2 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzav r4 = com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzav$zzav$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzav$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzav$zzav r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzav
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.C0219zzav.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaw extends zzfq<zzaw, zza> implements zzhd {
        private static final zzaw zzj;
        private static volatile zzhl<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        public static final class zza extends zzfq.zzb<zzaw, zza> implements zzhd {
            private zza() {
                super(zzaw.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public enum zzb implements zzfv {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzfu<zzb> zzd = new zzcn();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzco.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzaw zzaw = new zzaw();
            zzj = zzaw;
            zzfq.zza(zzaw.class, zzaw);
        }

        private zzaw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaw>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaw> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaw> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaw> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaw r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaw r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzj
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005"
                com.google.android.gms.internal.mlkit_common.zzav$zzaw r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaw.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzav$zzaw$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaw$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzav$zzaw r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaw
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzax extends zzfq<zzax, zza> implements zzhd {
        private static final zzax zzh;
        private static volatile zzhl<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzfy<zzan> zzg = zzfq.zzl();

        public static final class zza extends zzfq.zzb<zzax, zza> implements zzhd {
            private zza() {
                super(zzax.zzh);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzax zzax = new zzax();
            zzh = zzax;
            zzfq.zza(zzax.class, zzax);
        }

        private zzax() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzax>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzax> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzax.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzax> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzax.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzax> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzax.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzax r4 = com.google.android.gms.internal.mlkit_common.zzav.zzax.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzax.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzax r2 = com.google.android.gms.internal.mlkit_common.zzav.zzax.zzh
                return r2
            L_0x0033:
                r2 = 6
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
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzan> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzan.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b"
                com.google.android.gms.internal.mlkit_common.zzav$zzax r4 = com.google.android.gms.internal.mlkit_common.zzav.zzax.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzav$zzax$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzax$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzav$zzax r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzax
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzax.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzay extends zzfq<zzay, zza> implements zzhd {
        private static final zzay zzi;
        private static volatile zzhl<zzay> zzj;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;
        private zzfy<zzbf> zzh = zzfq.zzl();

        public static final class zza extends zzfq.zzb<zzay, zza> implements zzhd {
            private zza() {
                super(zzay.zzi);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzay zzay = new zzay();
            zzi = zzay;
            zzfq.zza(zzay.class, zzay);
        }

        private zzay() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzay>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzay> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzay.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzay> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzay.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzay> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzay.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzay r4 = com.google.android.gms.internal.mlkit_common.zzav.zzay.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzay.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzay r2 = com.google.android.gms.internal.mlkit_common.zzav.zzay.zzi
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005\u001b"
                com.google.android.gms.internal.mlkit_common.zzav$zzay r4 = com.google.android.gms.internal.mlkit_common.zzav.zzay.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzav$zzay$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzay$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzav$zzay r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzay
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzay.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaz extends zzfq<zzaz, zza> implements zzhd {
        private static final zzaz zzg;
        private static volatile zzhl<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        public static final class zza extends zzfq.zzb<zzaz, zza> implements zzhd {
            private zza() {
                super(zzaz.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzaz zzaz = new zzaz();
            zzg = zzaz;
            zzfq.zza(zzaz.class, zzaz);
        }

        private zzaz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaz>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaz> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzaz> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzaz> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzaz r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzaz r2 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzaz r4 = com.google.android.gms.internal.mlkit_common.zzav.zzaz.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzaz$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaz$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzaz r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzaz
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzaz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzfq<zzb, zza> implements zzhd {
        private static final zzb zzg;
        private static volatile zzhl<zzb> zzh;
        private int zzc;
        private C0220zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
            private zza() {
                super(zzb.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb  reason: collision with other inner class name */
        public static final class C0220zzb extends zzfq<C0220zzb, zza> implements zzhd {
            private static final C0220zzb zzi;
            private static volatile zzhl<C0220zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzfy<zzy.zzb> zzf = zzfq.zzl();
            private zzfy<zzy.zzb> zzg = zzfq.zzl();
            private zzam zzh;

            /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb$zza */
            public static final class zza extends zzfq.zzb<C0220zzb, zza> implements zzhd {
                private zza() {
                    super(C0220zzb.zzi);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                C0220zzb zzb = new C0220zzb();
                zzi = zzb;
                zzfq.zza(C0220zzb.class, zzb);
            }

            private C0220zzb() {
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.class
                    int[] r5 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r0 = 1
                    int r3 = r3 - r0
                    r3 = r5[r3]
                    r5 = 0
                    switch(r3) {
                        case 1: goto L_0x0073;
                        case 2: goto L_0x006d;
                        case 3: goto L_0x0035;
                        case 4: goto L_0x0032;
                        case 5: goto L_0x0018;
                        case 6: goto L_0x0013;
                        case 7: goto L_0x0012;
                        default: goto L_0x000c;
                    }
                L_0x000c:
                    java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                    r3.<init>()
                    throw r3
                L_0x0012:
                    return r5
                L_0x0013:
                    java.lang.Byte r3 = java.lang.Byte.valueOf(r0)
                    return r3
                L_0x0018:
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzj
                    if (r3 != 0) goto L_0x0031
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.class
                    monitor-enter(r4)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzj     // Catch:{ all -> 0x002e }
                    if (r3 != 0) goto L_0x002c
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r3 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb r5 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzi     // Catch:{ all -> 0x002e }
                    r3.<init>(r5)     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzj = r3     // Catch:{ all -> 0x002e }
                L_0x002c:
                    monitor-exit(r4)     // Catch:{ all -> 0x002e }
                    goto L_0x0031
                L_0x002e:
                    r3 = move-exception
                    monitor-exit(r4)     // Catch:{ all -> 0x002e }
                    throw r3
                L_0x0031:
                    return r3
                L_0x0032:
                    com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb r3 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzi
                    return r3
                L_0x0035:
                    r3 = 9
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    r5 = 0
                    java.lang.String r1 = "zzc"
                    r3[r5] = r1
                    java.lang.String r5 = "zzd"
                    r3[r0] = r5
                    r5 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r0 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r3[r5] = r0
                    r5 = 3
                    java.lang.String r0 = "zze"
                    r3[r5] = r0
                    r5 = 4
                    java.lang.String r0 = "zzf"
                    r3[r5] = r0
                    r5 = 5
                    r3[r5] = r4
                    r5 = 6
                    java.lang.String r0 = "zzg"
                    r3[r5] = r0
                    r5 = 7
                    r3[r5] = r4
                    r4 = 8
                    java.lang.String r5 = "zzh"
                    r3[r4] = r5
                    java.lang.String r4 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002"
                    com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb r5 = com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zzi
                    java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r5, r4, r3)
                    return r3
                L_0x006d:
                    com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb$zza r3 = new com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb$zza
                    r3.<init>(r5)
                    return r3
                L_0x0073:
                    com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb r3 = new com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb
                    r3.<init>()
                    return r3
                    switch-data {1->0x0073, 2->0x006d, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzb.C0220zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzb zzb = new zzb();
            zzg = zzb;
            zzfq.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzb.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzb.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzb.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzb.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzb.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzb.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzb
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzba extends zzfq<zzba, zzb> implements zzhd {
        private static final zzba zzg;
        private static volatile zzhl<zzba> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public enum zza implements zzfv {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzfu<zza> zzd = new zzcq();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzcp.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzfq.zzb<zzba, zzb> implements zzhd {
            private zzb() {
                super(zzba.zzg);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        public enum zzc implements zzfv {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzfu<zzc> zzd = new zzcr();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzcs.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzba = new zzba();
            zzg = zzba;
            zzfq.zza(zzba.class, zzba);
        }

        private zzba() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzba>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzba> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzba> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzba.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzba> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzba r4 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzba.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzba r2 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzg
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzc.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzba r4 = com.google.android.gms.internal.mlkit_common.zzav.zzba.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzav$zzba$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzba$zzb
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_common.zzav$zzba r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzba
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzba.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbb extends zzfq<zzbb, zza> implements zzhd {
        private static final zzbb zzf;
        private static volatile zzhl<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzfq.zzb<zzbb, zza> implements zzhd {
            private zza() {
                super(zzbb.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzbb zzbb = new zzbb();
            zzf = zzbb;
            zzfq.zza(zzbb.class, zzbb);
        }

        private zzbb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzf
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
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzbb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbb.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzav$zzbb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbb$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzav$zzbb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbb
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbc extends zzfq<zzbc, zzb> implements zzhd {
        private static final zzbc zzi;
        private static volatile zzhl<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzfy<zzc> zze = zzfq.zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        public enum zza implements zzfv {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzfu<zza> zzh = new zzcu();
            private final int zzi;

            private zza(int i) {
                this.zzi = i;
            }

            public static zzfx zzb() {
                return zzct.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzb extends zzfq.zzb<zzbc, zzb> implements zzhd {
            private zzb() {
                super(zzbc.zzi);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        public static final class zzc extends zzfq<zzc, zza> implements zzhd {
            private static final zzc zze;
            private static volatile zzhl<zzc> zzf;
            private int zzc;
            private float zzd;

            public static final class zza extends zzfq.zzb<zzc, zza> implements zzhd {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzfq.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zze
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000"
                    com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzbc zzbc = new zzbc();
            zzi = zzbc;
            zzfq.zza(zzbc.class, zzbc);
        }

        private zzbc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbc> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbc r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzi
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
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzc.class
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zza.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003"
                com.google.android.gms.internal.mlkit_common.zzav$zzbc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbc.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzb
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzav$zzbc r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbc
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbd extends zzfq<zzbd, zza> implements zzhd {
        private static final zzbd zzf;
        private static volatile zzhl<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzfq.zzb<zzbd, zza> implements zzhd {
            private zza() {
                super(zzbd.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzbd zzbd = new zzbd();
            zzf = zzbd;
            zzfq.zza(zzbd.class, zzbd);
        }

        private zzbd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbd>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbd> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbd r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzf
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
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzbd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbd.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzav$zzbd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbd$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzav$zzbd r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbd
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbe extends zzfq<zzbe, zza> implements zzhd {
        private static final zzbe zzl;
        private static volatile zzhl<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbi zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        public static final class zza extends zzfq.zzb<zzbe, zza> implements zzhd {
            private zza() {
                super(zzbe.zzl);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public enum zzb implements zzfv {
            NO_ERROR(0),
            METADATA_FILE_UNAVAILABLE(1),
            METADATA_ENTRY_NOT_FOUND(2),
            METADATA_JSON_INVALID(3),
            METADATA_HASH_NOT_FOUND(4),
            DOWNLOAD_MANAGER_SERVICE_MISSING(5),
            DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
            DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
            DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
            DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
            DOWNLOAD_MANAGER_HTTP_NOT_FOUND(404),
            DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
            DOWNLOAD_MANAGER_HTTP_ABORTED(409),
            DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(429),
            DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
            DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(501),
            DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(500),
            DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(503),
            DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(504),
            DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(511),
            DOWNLOAD_MANAGER_FILE_ERROR(7),
            DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
            DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
            DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
            DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
            DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
            DOWNLOAD_MANAGER_CANNOT_RESUME(13),
            DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
            DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
            POST_DOWNLOAD_FILE_NOT_FOUND(16),
            POST_DOWNLOAD_MOVE_FILE_FAILED(17),
            POST_DOWNLOAD_UNZIP_FAILED(18),
            RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
            DRIVER_OBJECT_DEALLOCATED(20);
            
            private static final zzfu<zzb> zzai = new zzcv();
            private final int zzaj;

            private zzb(int i) {
                this.zzaj = i;
            }

            public static zzfx zzb() {
                return zzcw.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzaj;
            }
        }

        static {
            zzbe zzbe = new zzbe();
            zzl = zzbe;
            zzfq.zza(zzbe.class, zzbe);
        }

        private zzbe() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbe>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007b;
                    case 2: goto L_0x0075;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbe> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbe> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbe> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbe r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbe r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzl
                return r2
            L_0x0033:
                r2 = 10
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzb.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007"
                com.google.android.gms.internal.mlkit_common.zzav$zzbe r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbe.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_common.zzav$zzbe$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbe$zza
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_common.zzav$zzbe r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbe
                r2.<init>()
                return r2
                switch-data {1->0x007b, 2->0x0075, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbf extends zzfq<zzbf, zzb> implements zzhd {
        private static final zzbf zzf;
        private static volatile zzhl<zzbf> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public enum zza implements zzfv {
            UNKNOWN(0),
            CANONICAL(1),
            TFLITE(2),
            TFLITE_SUPPORT(3);
            
            private static final zzfu<zza> zze = new zzcy();
            private final int zzf;

            private zza(int i) {
                this.zzf = i;
            }

            public static zzfx zzb() {
                return zzcx.zza;
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

        public static final class zzb extends zzfq.zzb<zzbf, zzb> implements zzhd {
            private zzb() {
                super(zzbf.zzf);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        static {
            zzbf zzbf = new zzbf();
            zzf = zzbf;
            zzfq.zza(zzbf.class, zzbf);
        }

        private zzbf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbf>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbf r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzbf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbf.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzav$zzbf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbf$zzb
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzav$zzbf r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbf
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbg extends zzfq<zzbg, zzb> implements zzhd {
        private static final zzfz<Integer, zza> zzf = new zzcz();
        private static final zzfz<Integer, zza> zzh = new zzdb();
        private static final zzfz<Integer, zza> zzj = new zzda();
        private static final zzbg zzl;
        private static volatile zzhl<zzbg> zzm;
        private int zzc;
        private long zzd;
        private zzfw zze = zzfq.zzk();
        private zzfw zzg = zzfq.zzk();
        private zzfw zzi = zzfq.zzk();
        private int zzk;

        public enum zza implements zzfv {
            UNKNOWN_ERROR(0),
            NO_CONNECTION(1),
            RPC_ERROR(2),
            RPC_RETURNED_INVALID_RESULT(3),
            RPC_RETURNED_MALFORMED_RESULT(4),
            RPC_EXPONENTIAL_BACKOFF_FAILED(5),
            DIRECTORY_CREATION_FAILED(10),
            FILE_WRITE_FAILED_DISK_FULL(11),
            FILE_WRITE_FAILED(12),
            FILE_READ_FAILED(13),
            FILE_READ_RETURNED_INVALID_DATA(14),
            FILE_READ_RETURNED_MALFORMED_DATA(15);
            
            private static final zzfu<zza> zzm = new zzdd();
            private final int zzn;

            private zza(int i) {
                this.zzn = i;
            }

            public static zzfx zzb() {
                return zzdc.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzn;
            }
        }

        public static final class zzb extends zzfq.zzb<zzbg, zzb> implements zzhd {
            private zzb() {
                super(zzbg.zzl);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzbg$zza>, com.google.android.gms.internal.mlkit_common.zzcz] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzbg$zza>, com.google.android.gms.internal.mlkit_common.zzdb] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzbg$zza>, com.google.android.gms.internal.mlkit_common.zzda] */
        static {
            zzbg zzbg = new zzbg();
            zzl = zzbg;
            zzfq.zza(zzbg.class, zzbg);
        }

        private zzbg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbg>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0079;
                    case 2: goto L_0x0073;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbg> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbg> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbg> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbg r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbg r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzl
                return r2
            L_0x0033:
                r2 = 9
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zza.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zza.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zza.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzbg r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbg.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0073:
                com.google.android.gms.internal.mlkit_common.zzav$zzbg$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbg$zzb
                r2.<init>(r3)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_common.zzav$zzbg r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbg
                r2.<init>()
                return r2
                switch-data {1->0x0079, 2->0x0073, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbi extends zzfq<zzbi, zza> implements zzhd {
        private static final zzbi zzf;
        private static volatile zzhl<zzbi> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        public static final class zza extends zzfq.zzb<zzbi, zza> implements zzhd {
            private zza() {
                super(zzbi.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzbi zzbi = new zzbi();
            zzf = zzbi;
            zzfq.zza(zzbi.class, zzbi);
        }

        private zzbi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbi>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbi> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbi> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbi> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbi r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbi r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzf
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
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzbi r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbi.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzav$zzbi$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbi$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzav$zzbi r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbi
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzfq<zzc, zza> implements zzhd {
        private static final zzc zzg;
        private static volatile zzhl<zzc> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzc, zza> implements zzhd {
            private zza() {
                super(zzc.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzfz<Integer, zzao.zza> zzj = new zzaw();
            private static final zzfz<Integer, zzao.zzb> zzl = new zzax();
            private static final zzb zzm;
            private static volatile zzhl<zzb> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzdf.zza zzh;
            private zzfw zzi = zzfq.zzk();
            private zzfw zzk = zzfq.zzk();

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzm);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzao$zza>, com.google.android.gms.internal.mlkit_common.zzaw] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzav$zzao$zzb>, com.google.android.gms.internal.mlkit_common.zzax] */
            static {
                zzb zzb = new zzb();
                zzm = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0085;
                        case 2: goto L_0x007f;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzn
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzn     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzm     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzn = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzm
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
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    r3 = 7
                    java.lang.String r4 = "zzi"
                    r2[r3] = r4
                    r3 = 8
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zza.zzb()
                    r2[r3] = r4
                    r3 = 9
                    java.lang.String r4 = "zzk"
                    r2[r3] = r4
                    r3 = 10
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzao.zzb.zzb()
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e"
                    com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zzm
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x007f:
                    com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0085:
                    com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzc.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzfq.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzc.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzc r2 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzc r4 = com.google.android.gms.internal.mlkit_common.zzav.zzc.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzc$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzc
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzfq<zzd, zza> implements zzhd {
        private static final zzd zzg;
        private static volatile zzhl<zzd> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzd, zza> implements zzhd {
            private zza() {
                super(zzd.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzj;
            private static volatile zzhl<zzb> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzj);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzj = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x006f;
                        case 2: goto L_0x0069;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzk     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzj     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzk = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzj
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
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    r3 = 7
                    java.lang.String r4 = "zzi"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005"
                    com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zzj
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x006f:
                    com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzd$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzd.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzg = zzd2;
            zzfq.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzd.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzd r2 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzd r4 = com.google.android.gms.internal.mlkit_common.zzav.zzd.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzd
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzfq<zze, zza> implements zzhd {
        private static final zze zzg;
        private static volatile zzhl<zze> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zze, zza> implements zzhd {
            private zza() {
                super(zze.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zze$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zze$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zze$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzav$zze$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzav$zze$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zze$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzav$zze$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zze$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zze.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zze zze2 = new zze();
            zzg = zze2;
            zzfq.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze> r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zze> r3 = com.google.android.gms.internal.mlkit_common.zzav.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zze> r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zze r4 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zze.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zze r2 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zze r4 = com.google.android.gms.internal.mlkit_common.zzav.zze.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zze$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zze$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zze r2 = new com.google.android.gms.internal.mlkit_common.zzav$zze
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzfq<zzf, zza> implements zzhd {
        private static final zzf zzg;
        private static volatile zzhl<zzf> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzf, zza> implements zzhd {
            private zza() {
                super(zzf.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzi;
            private static volatile zzhl<zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzi);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzi = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0069;
                        case 2: goto L_0x0063;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzj
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzj     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzi     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzj = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzi
                    return r2
                L_0x0033:
                    r2 = 7
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004"
                    com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zzi
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0063:
                    com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzf$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzf.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzg = zzf2;
            zzfq.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzf> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzf> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzf.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzf r2 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzf r4 = com.google.android.gms.internal.mlkit_common.zzav.zzf.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzf$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzf r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzf
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzfq<zzg, zza> implements zzhd {
        private static final zzg zzg;
        private static volatile zzhl<zzg> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzg, zza> implements zzhd {
            private zza() {
                super(zzg.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzg$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzg.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzg = zzg2;
            zzfq.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzg> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzg> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzg r4 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzg.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzg r2 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzg r4 = com.google.android.gms.internal.mlkit_common.zzav.zzg.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzg$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzg$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzg r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzg
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzfq<zzh, zza> implements zzhd {
        private static final zzh zzg;
        private static volatile zzhl<zzh> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzh, zza> implements zzhd {
            private zza() {
                super(zzh.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzg;
            private static volatile zzhl<zzb> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzg);
                }

                public /* synthetic */ zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzg
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
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002"
                    com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0059:
                    com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005f:
                    com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzh$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzh.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzh zzh2 = new zzh();
            zzg = zzh2;
            zzfq.zza(zzh.class, zzh2);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzh> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzh r4 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzh.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzh r2 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzh r4 = com.google.android.gms.internal.mlkit_common.zzav.zzh.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzh$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzh r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzfq<zzi, zza> implements zzhd {
        private static final zzi zzg;
        private static volatile zzhl<zzi> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzfq.zzb<zzi, zza> implements zzhd {
            private zza() {
                super(zzi.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzi$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzi.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzfq.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzi> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzi r4 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzi.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzi r2 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzi r4 = com.google.android.gms.internal.mlkit_common.zzav.zzi.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzi$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzi$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzi r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzi
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzfq<zzj, zza> implements zzhd {
        private static final zzj zze;
        private static volatile zzhl<zzj> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzfq.zzb<zzj, zza> implements zzhd {
            private zza() {
                super(zzj.zze);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zze = zzj;
            zzfq.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzj>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0055;
                    case 2: goto L_0x004f;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzj> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzj r4 = com.google.android.gms.internal.mlkit_common.zzav.zzj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzj r2 = com.google.android.gms.internal.mlkit_common.zzav.zzj.zze
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_common.zzav$zzj r4 = com.google.android.gms.internal.mlkit_common.zzav.zzj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_common.zzav$zzj$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_common.zzav$zzj r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzfq<zzk, zza> implements zzhd {
        private static final zzk zzi;
        private static volatile zzhl<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        public static final class zza extends zzfq.zzb<zzk, zza> implements zzhd {
            private zza() {
                super(zzk.zzi);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzi = zzk;
            zzfq.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzk>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzk.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzk> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzk.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzk r4 = com.google.android.gms.internal.mlkit_common.zzav.zzk.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzk.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzk r2 = com.google.android.gms.internal.mlkit_common.zzav.zzk.zzi
                return r2
            L_0x0033:
                r2 = 6
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
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004"
                com.google.android.gms.internal.mlkit_common.zzav$zzk r4 = com.google.android.gms.internal.mlkit_common.zzav.zzk.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzav$zzk$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzav$zzk r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzk
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzfq<zzl, zza> implements zzhd {
        private static final zzfz<Integer, zzbf> zzg = new zzay();
        private static final zzl zzi;
        private static volatile zzhl<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfw zzf = zzfq.zzk();
        private long zzh;

        public static final class zza extends zzfq.zzb<zzl, zza> implements zzhd {
            private zza() {
                super(zzl.zzi);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzbf>, com.google.android.gms.internal.mlkit_common.zzay] */
        static {
            zzl zzl = new zzl();
            zzi = zzl;
            zzfq.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzl>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzl> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzl.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzl> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzl> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzl.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzl r4 = com.google.android.gms.internal.mlkit_common.zzav.zzl.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzl.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzl r2 = com.google.android.gms.internal.mlkit_common.zzav.zzl.zzi
                return r2
            L_0x0033:
                r2 = 6
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzl r4 = com.google.android.gms.internal.mlkit_common.zzav.zzl.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzav$zzl$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzav$zzl r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzl
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzm extends zzfq<zzm, zza> implements zzhd {
        private static final zzm zzg;
        private static volatile zzhl<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzm, zza> implements zzhd {
            private zza() {
                super(zzm.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzm zzm = new zzm();
            zzg = zzm;
            zzfq.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzm>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzm> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzm.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzm> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzm> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzm.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzm r4 = com.google.android.gms.internal.mlkit_common.zzav.zzm.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzm.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzm r2 = com.google.android.gms.internal.mlkit_common.zzav.zzm.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzm r4 = com.google.android.gms.internal.mlkit_common.zzav.zzm.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzm$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzm r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzm
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzn extends zzfq<zzn, zzb> implements zzhd {
        private static final zzn zzf;
        private static volatile zzhl<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public enum zza implements zzfv {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzfu<zza> zzd = new zzba();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzaz.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzfq.zzb<zzn, zzb> implements zzhd {
            private zzb() {
                super(zzn.zzf);
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }
        }

        static {
            zzn zzn = new zzn();
            zzf = zzn;
            zzfq.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzn>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzn> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzn> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzn> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzn r4 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzn.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzn r2 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzn r4 = com.google.android.gms.internal.mlkit_common.zzav.zzn.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzav$zzn$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzn$zzb
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzav$zzn r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzn
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzo extends zzfq<zzo, zza> implements zzhd {
        private static final zzo zzg;
        private static volatile zzhl<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzo, zza> implements zzhd {
            private zza() {
                super(zzo.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzo zzo = new zzo();
            zzg = zzo;
            zzfq.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzo>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzo> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzo.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzo> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzo> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzo.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzo r4 = com.google.android.gms.internal.mlkit_common.zzav.zzo.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzo.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzo r2 = com.google.android.gms.internal.mlkit_common.zzav.zzo.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzo r4 = com.google.android.gms.internal.mlkit_common.zzav.zzo.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzo$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzo r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzo
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzp extends zzfq<zzp, zza> implements zzhd {
        private static final zzp zzg;
        private static volatile zzhl<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzp, zza> implements zzhd {
            private zza() {
                super(zzp.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzp zzp = new zzp();
            zzg = zzp;
            zzfq.zza(zzp.class, zzp);
        }

        private zzp() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzp>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzp> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzp.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzp> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzp.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzp> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzp.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzp r4 = com.google.android.gms.internal.mlkit_common.zzav.zzp.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzp.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzp r2 = com.google.android.gms.internal.mlkit_common.zzav.zzp.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzp r4 = com.google.android.gms.internal.mlkit_common.zzav.zzp.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzp$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzp$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzp r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzp
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzq extends zzfq<zzq, zza> implements zzhd {
        private static final zzq zzg;
        private static volatile zzhl<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzq, zza> implements zzhd {
            private zza() {
                super(zzq.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzq zzq = new zzq();
            zzg = zzq;
            zzfq.zza(zzq.class, zzq);
        }

        private zzq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzq>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzq> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzq.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzq> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzq> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzq.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzq r4 = com.google.android.gms.internal.mlkit_common.zzav.zzq.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzq.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzq r2 = com.google.android.gms.internal.mlkit_common.zzav.zzq.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzq r4 = com.google.android.gms.internal.mlkit_common.zzav.zzq.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzq$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzq r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzq
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzr extends zzfq<zzr, zza> implements zzhd {
        private static final zzr zzg;
        private static volatile zzhl<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzr, zza> implements zzhd {
            private zza() {
                super(zzr.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzr zzr = new zzr();
            zzg = zzr;
            zzfq.zza(zzr.class, zzr);
        }

        private zzr() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzfq$zza, com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzr>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzr> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzr.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzr> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzr.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzr> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzr.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzr r4 = com.google.android.gms.internal.mlkit_common.zzav.zzr.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzr.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzr r2 = com.google.android.gms.internal.mlkit_common.zzav.zzr.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzr r4 = com.google.android.gms.internal.mlkit_common.zzav.zzr.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzr$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzr$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzr r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzr
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzs extends zzfq<zzs, zza> implements zzhd {
        private static final zzs zzg;
        private static volatile zzhl<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzs, zza> implements zzhd {
            private zza() {
                super(zzs.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzs zzs = new zzs();
            zzg = zzs;
            zzfq.zza(zzs.class, zzs);
        }

        private zzs() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzs>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzs> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzs.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzs> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzs.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzs> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzs.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzs r4 = com.google.android.gms.internal.mlkit_common.zzav.zzs.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzs.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzs r2 = com.google.android.gms.internal.mlkit_common.zzav.zzs.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzs r4 = com.google.android.gms.internal.mlkit_common.zzav.zzs.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzs$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzs$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzs r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzs
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzs.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzt extends zzfq<zzt, zza> implements zzhd {
        private static final zzt zzg;
        private static volatile zzhl<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzt, zza> implements zzhd {
            private zza() {
                super(zzt.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzt zzt = new zzt();
            zzg = zzt;
            zzfq.zza(zzt.class, zzt);
        }

        private zzt() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzt>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzt> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzt.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzt> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzt.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzt> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzt.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzt r4 = com.google.android.gms.internal.mlkit_common.zzav.zzt.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzt.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzt r2 = com.google.android.gms.internal.mlkit_common.zzav.zzt.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzt r4 = com.google.android.gms.internal.mlkit_common.zzav.zzt.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzt$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzt$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzt r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzt
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzu extends zzfq<zzu, zza> implements zzhd {
        private static final zzu zzg;
        private static volatile zzhl<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzu, zza> implements zzhd {
            private zza() {
                super(zzu.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzu zzu = new zzu();
            zzg = zzu;
            zzfq.zza(zzu.class, zzu);
        }

        private zzu() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzu>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzu> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzu.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzu> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzu.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzu> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzu.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzu r4 = com.google.android.gms.internal.mlkit_common.zzav.zzu.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzu.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzu r2 = com.google.android.gms.internal.mlkit_common.zzav.zzu.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzu r4 = com.google.android.gms.internal.mlkit_common.zzav.zzu.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzu$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzu$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzu r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzu
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzu.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzv extends zzfq<zzv, zza> implements zzhd {
        private static final zzv zzg;
        private static volatile zzhl<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzv, zza> implements zzhd {
            private zza() {
                super(zzv.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzv zzv = new zzv();
            zzg = zzv;
            zzfq.zza(zzv.class, zzv);
        }

        private zzv() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzv>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzv> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzv.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzv> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzv.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzv> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzv.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzv r4 = com.google.android.gms.internal.mlkit_common.zzav.zzv.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzv.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzv r2 = com.google.android.gms.internal.mlkit_common.zzav.zzv.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzv r4 = com.google.android.gms.internal.mlkit_common.zzav.zzv.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzv$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzv$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzv r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzv
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzv.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzw extends zzfq<zzw, zza> implements zzhd {
        private static final zzw zzg;
        private static volatile zzhl<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzfq.zzb<zzw, zza> implements zzhd {
            private zza() {
                super(zzw.zzg);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzw zzw = new zzw();
            zzg = zzw;
            zzfq.zza(zzw.class, zzw);
        }

        private zzw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzw>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzw> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzw.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzw> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzw> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzw.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzw r4 = com.google.android.gms.internal.mlkit_common.zzav.zzw.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzw.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzw r2 = com.google.android.gms.internal.mlkit_common.zzav.zzw.zzg
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
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzw r4 = com.google.android.gms.internal.mlkit_common.zzav.zzw.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzav$zzw$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzw$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzav$zzw r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzw
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzx extends zzfq<zzx, zza> implements zzhd {
        private static final zzx zzf;
        private static volatile zzhl<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        public static final class zza extends zzfq.zzb<zzx, zza> implements zzhd {
            private zza() {
                super(zzx.zzf);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        static {
            zzx zzx = new zzx();
            zzf = zzx;
            zzfq.zza(zzx.class, zzx);
        }

        private zzx() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzx>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzx> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzx.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzx> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzx.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzx> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzx.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzx.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzx.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzx r2 = com.google.android.gms.internal.mlkit_common.zzav.zzx.zzf
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzav$zzx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzx.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzav$zzx$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzx$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzav$zzx r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzx
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzx.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzy extends zzfq<zzy, zza> implements zzhd {
        private static final zzy zzi;
        private static volatile zzhl<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzfy<zzb> zzf = zzfq.zzl();
        private zzfy<zzb> zzg = zzfq.zzl();
        private long zzh;

        public static final class zza extends zzfq.zzb<zzy, zza> implements zzhd {
            private zza() {
                super(zzy.zzi);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzf;
            private static volatile zzhl<zzb> zzg;
            private int zzc;
            private int zzd;
            private zzfw zze = zzfq.zzk();

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzf);
                }

                public /* synthetic */ zza(zzau zzau) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb$zzb  reason: collision with other inner class name */
            public enum EnumC0221zzb implements zzfv {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzfu<EnumC0221zzb> zzf = new zzbb();
                private final int zzg;

                private EnumC0221zzb(int i) {
                    this.zzg = i;
                }

                public static zzfx zzb() {
                    return zzbc.zza;
                }

                @Override // java.lang.Enum, java.lang.Object
                public final String toString() {
                    return "<" + EnumC0221zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.mlkit_common.zzfv
                public final int zza() {
                    return this.zzg;
                }
            }

            static {
                zzb zzb = new zzb();
                zzf = zzb;
                zzfq.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzf
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
                    com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.EnumC0221zzb.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016"
                    com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0054:
                    com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005a:
                    com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzy zzy = new zzy();
            zzi = zzy;
            zzfq.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzb.class
                int[] r5 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r0 = 1
                int r3 = r3 - r0
                r3 = r5[r3]
                r5 = 0
                switch(r3) {
                    case 1: goto L_0x006b;
                    case 2: goto L_0x0065;
                    case 3: goto L_0x0035;
                    case 4: goto L_0x0032;
                    case 5: goto L_0x0018;
                    case 6: goto L_0x0013;
                    case 7: goto L_0x0012;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                r3.<init>()
                throw r3
            L_0x0012:
                return r5
            L_0x0013:
                java.lang.Byte r3 = java.lang.Byte.valueOf(r0)
                return r3
            L_0x0018:
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzj
                if (r3 != 0) goto L_0x0031
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzy> r4 = com.google.android.gms.internal.mlkit_common.zzav.zzy.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzy> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzj     // Catch:{ all -> 0x002e }
                if (r3 != 0) goto L_0x002c
                com.google.android.gms.internal.mlkit_common.zzfq$zza r3 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_common.zzav$zzy r5 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzi     // Catch:{ all -> 0x002e }
                r3.<init>(r5)     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_common.zzav.zzy.zzj = r3     // Catch:{ all -> 0x002e }
            L_0x002c:
                monitor-exit(r4)     // Catch:{ all -> 0x002e }
                goto L_0x0031
            L_0x002e:
                r3 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x002e }
                throw r3
            L_0x0031:
                return r3
            L_0x0032:
                com.google.android.gms.internal.mlkit_common.zzav$zzy r3 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzi
                return r3
            L_0x0035:
                r3 = 8
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r5 = 0
                java.lang.String r1 = "zzc"
                r3[r5] = r1
                java.lang.String r5 = "zzd"
                r3[r0] = r5
                r5 = 2
                java.lang.String r0 = "zze"
                r3[r5] = r0
                r5 = 3
                java.lang.String r0 = "zzf"
                r3[r5] = r0
                r5 = 4
                r3[r5] = r4
                r5 = 5
                java.lang.String r0 = "zzg"
                r3[r5] = r0
                r5 = 6
                r3[r5] = r4
                r4 = 7
                java.lang.String r5 = "zzh"
                r3[r4] = r5
                java.lang.String r4 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002"
                com.google.android.gms.internal.mlkit_common.zzav$zzy r5 = com.google.android.gms.internal.mlkit_common.zzav.zzy.zzi
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r5, r4, r3)
                return r3
            L_0x0065:
                com.google.android.gms.internal.mlkit_common.zzav$zzy$zza r3 = new com.google.android.gms.internal.mlkit_common.zzav$zzy$zza
                r3.<init>(r5)
                return r3
            L_0x006b:
                com.google.android.gms.internal.mlkit_common.zzav$zzy r3 = new com.google.android.gms.internal.mlkit_common.zzav$zzy
                r3.<init>()
                return r3
                switch-data {1->0x006b, 2->0x0065, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzy.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzz extends zzfq<zzz, zza> implements zzhd {
        private static final zzfz<Integer, zzbf> zzg = new zzbd();
        private static final zzz zzj;
        private static volatile zzhl<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfw zzf = zzfq.zzk();
        private long zzh;
        private boolean zzi;

        public static final class zza extends zzfq.zzb<zzz, zza> implements zzhd {
            private zza() {
                super(zzz.zzj);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzbf>, com.google.android.gms.internal.mlkit_common.zzbd] */
        static {
            zzz zzz = new zzz();
            zzj = zzz;
            zzfq.zza(zzz.class, zzz);
        }

        private zzz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzz>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0069;
                    case 2: goto L_0x0063;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzz> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzz.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzz> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzz> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzz.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzz r4 = com.google.android.gms.internal.mlkit_common.zzav.zzz.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzz.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzz r2 = com.google.android.gms.internal.mlkit_common.zzav.zzz.zzj
                return r2
            L_0x0033:
                r2 = 7
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003"
                com.google.android.gms.internal.mlkit_common.zzav$zzz r4 = com.google.android.gms.internal.mlkit_common.zzav.zzz.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.mlkit_common.zzav$zzz$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzz$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzav$zzz r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzz
                r2.<init>()
                return r2
                switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzad extends zzfq.zzc<zzad, zza> implements zzhd {
        private static final zzad zzbd;
        private static volatile zzhl<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private zzr zzad;
        private zzq zzae;
        private zzs zzaf;
        private zzt zzag;
        private zzu zzah;
        private zzv zzai;
        private zzw zzaj;
        private zzj zzak;
        private zzl zzal;
        private zzk zzam;
        private zzah zzan;
        private zzaa zzao;
        private zza zzap;
        private zzb zzaq;
        private zzd zzar;
        private zzc zzas;
        private zze zzat;
        private zzf zzau;
        private zzi zzav;
        private zzg zzaw;
        private zzh zzax;
        private zzfy<zzjf.zzf> zzay = zzfq.zzl();
        private zzbg zzaz;
        private zzag zzba;
        private zzaj zzbb;
        private byte zzbc = 2;
        private int zzd;
        private int zze;
        private zzbh zzf;
        private int zzg;
        private boolean zzh;
        private zzak zzi;
        private zzz zzj;
        private zzy zzk;
        private zzx zzl;
        private zzap zzm;
        private zzbd zzn;
        private zzao zzo;
        private zzaq zzp;
        private zzas zzq;
        private zzar zzr;
        private C0219zzav zzs;
        private zzay zzt;
        private zzax zzu;
        private zzaz zzv;
        private zzbb zzw;
        private zzbc zzx;
        private zzau zzy;
        private zzbe zzz;

        static {
            zzad zzad2 = new zzad();
            zzbd = zzad2;
            zzfq.zza(zzad.class, zzad2);
        }

        private zzad() {
        }

        public static zza zza(zzad zzad2) {
            return (zza) zzbd.zza(zzad2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzaj zzaj2) {
            zzaj2.getClass();
            this.zzbb = zzaj2;
            this.zze |= 32768;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzak zzak2) {
            zzak2.getClass();
            this.zzi = zzak2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzbh zzbh) {
            zzbh.getClass();
            this.zzf = zzbh;
            this.zzd |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzbg zzbg) {
            this.zzg = zzbg.zza();
            this.zzd |= 2;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbh zza() {
            zzbh zzbh = this.zzf;
            return zzbh == null ? zzbh.zzc() : zzbh;
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzad>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
            // Method dump skipped, instructions count: 414
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzad.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public static final class zza extends zzfq.zzd<zzad, zza> implements zzhd {
            private zza() {
                super(zzad.zzbd);
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }

            public final zza zza(zzbh.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbh) ((zzfq) zza.zzg()));
                return this;
            }

            public final zzbh zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzbg zzbg) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzbg);
                return this;
            }

            public final zza zza(zzak.zzb zzb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzak) ((zzfq) zzb.zzg()));
                return this;
            }

            public final zza zza(zzaj.zzb zzb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzaj) ((zzfq) zzb.zzg()));
                return this;
            }
        }
    }

    public static final class zzak extends zzfq<zzak, zzb> implements zzhd {
        private static final zzak zzk;
        private static volatile zzhl<zzak> zzl;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;
        private zzfw zzj = zzfq.zzk();

        public enum zza implements zzfv {
            UNKNOWN_STATUS(0),
            EXPLICITLY_REQUESTED(1),
            IMPLICITLY_REQUESTED(2),
            MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
            MODEL_INFO_RETRIEVAL_FAILED(4),
            SCHEDULED(5),
            DOWNLOADING(6),
            SUCCEEDED(7),
            FAILED(8),
            LIVE(9),
            UPDATE_AVAILABLE(10),
            DOWNLOADED(11),
            STARTED(12);
            
            private static final zzfu<zza> zzn = new zzbz();
            private final int zzo;

            private zza(int i) {
                this.zzo = i;
            }

            public static zzfx zzb() {
                return zzby.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzo;
            }
        }

        public static final class zzb extends zzfq.zzb<zzak, zzb> implements zzhd {
            private zzb() {
                super(zzak.zzk);
            }

            public final zzb zza(zzam zzam) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzam);
                return this;
            }

            public final zzb zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzb(j);
                return this;
            }

            public final zzb zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzc(j);
                return this;
            }

            public /* synthetic */ zzb(zzau zzau) {
                this();
            }

            public final zzb zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(j);
                return this;
            }

            public final zzb zza(zzbf zzbf) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzbf);
                return this;
            }

            public final zzb zza(zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zza);
                return this;
            }
        }

        static {
            zzak zzak = new zzak();
            zzk = zzak;
            zzfq.zza(zzak.class, zzak);
        }

        private zzak() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzam zzam) {
            zzam.getClass();
            this.zzd = zzam;
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzbf zzbf) {
            this.zzf = zzbf.zza();
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            this.zzh = zza2.zza();
            this.zzc |= 16;
        }

        public static zzb zza() {
            return (zzb) zzk.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzak>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007d;
                    case 2: goto L_0x0077;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzak> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzak> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzak.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzak> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzak r4 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzak.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzak r2 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zzk
                return r2
            L_0x0033:
                r2 = 10
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzbf.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zza.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005\u0007\u0016"
                com.google.android.gms.internal.mlkit_common.zzav$zzak r4 = com.google.android.gms.internal.mlkit_common.zzav.zzak.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_common.zzav$zzak$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzak$zzb
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_common.zzav$zzak r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzak
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzak.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzal extends zzfq<zzal, zza> implements zzhd {
        private static final zzal zzl;
        private static volatile zzhl<zzal> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private int zzf;
        private String zzg = "";
        private String zzh = "";
        private int zzi;
        private long zzj;
        private boolean zzk;

        public static final class zza extends zzfq.zzb<zzal, zza> implements zzhd {
            private zza() {
                super(zzal.zzl);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zzb(str);
                return this;
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }

            public final zza zza(zzc zzc) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzc);
                return this;
            }

            public final zza zza(zzb zzb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzb);
                return this;
            }
        }

        public enum zzb implements zzfv {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5),
            BASE_ENTITY_EXTRACTION(6);
            
            private static final zzfu<zzb> zzh = new zzca();
            private final int zzi;

            private zzb(int i) {
                this.zzi = i;
            }

            public static zzfx zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzi;
            }
        }

        public enum zzc implements zzfv {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4),
            URI(5);
            
            private static final zzfu<zzc> zzg = new zzcd();
            private final int zzh;

            private zzc(int i) {
                this.zzh = i;
            }

            public static zzfx zzb() {
                return zzcc.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzal zzal = new zzal();
            zzl = zzal;
            zzfq.zza(zzal.class, zzal);
        }

        private zzal() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzc zzc2) {
            this.zzf = zzc2.zza();
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzb zzb2) {
            this.zzi = zzb2.zza();
            this.zzc |= 32;
        }

        public static zza zza() {
            return (zza) zzl.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzal>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0083;
                    case 2: goto L_0x007d;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzal> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzal> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzal.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzal> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzal r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzal.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzal r2 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzl
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzb.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007"
                com.google.android.gms.internal.mlkit_common.zzav$zzal r4 = com.google.android.gms.internal.mlkit_common.zzav.zzal.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_common.zzav$zzal$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzal$zza
                r2.<init>(r3)
                return r2
            L_0x0083:
                com.google.android.gms.internal.mlkit_common.zzav$zzal r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzal
                r2.<init>()
                return r2
                switch-data {1->0x0083, 2->0x007d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzal.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzam extends zzfq<zzam, zza> implements zzhd {
        private static final zzam zzh;
        private static volatile zzhl<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zzb zze;
        private zzb zzf;
        private boolean zzg;

        public static final class zza extends zzfq.zzb<zzam, zza> implements zzhd {
            private zza() {
                super(zzam.zzh);
            }

            public final zza zza(zzal.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzam) this.zza).zza((zzal) ((zzfq) zza.zzg()));
                return this;
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }
        }

        public static final class zzb extends zzfq<zzb, zza> implements zzhd {
            private static final zzb zzh;
            private static volatile zzhl<zzb> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            public static final class zza extends zzfq.zzb<zzb, zza> implements zzhd {
                private zza() {
                    super(zzb.zzh);
                }

                public /* synthetic */ zza(zzau zzau) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzfq
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzh
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
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb r4 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzam.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzam zzam = new zzam();
            zzh = zzam;
            zzfq.zza(zzam.class, zzam);
        }

        private zzam() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzal zzal) {
            zzal.getClass();
            this.zzd = zzal;
            this.zzc |= 1;
        }

        public static zza zza() {
            return (zza) zzh.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzam> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzam.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzam> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzam r4 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzam.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzam r2 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzh
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
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003"
                com.google.android.gms.internal.mlkit_common.zzav$zzam r4 = com.google.android.gms.internal.mlkit_common.zzav.zzam.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_common.zzav$zzam$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzam$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_common.zzav$zzam r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzam
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzam.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbh extends zzfq<zzbh, zza> implements zzhd {
        private static final zzbh zzo;
        private static volatile zzhl<zzbh> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzfy<String> zzk = zzfq.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        public static final class zza extends zzfq.zzb<zzbh, zza> implements zzhd {
            private zza() {
                super(zzbh.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zze(str);
                return this;
            }

            public /* synthetic */ zza(zzau zzau) {
                this();
            }

            public final zza zza(Iterable<String> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzb(true);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(true);
                return this;
            }
        }

        static {
            zzbh zzbh = new zzbh();
            zzo = zzbh;
            zzfq.zza(zzbh.class, zzbh);
        }

        private zzbh() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzl = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzn = true;
        }

        public static zzbh zzc() {
            return zzo;
        }

        public final String zza() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<String> iterable) {
            zzfy<String> zzfy = this.zzk;
            if (!zzfy.zza()) {
                int size = zzfy.size();
                this.zzk = zzfy.zzb(size == 0 ? 10 : size << 1);
            }
            zzeg.zza(iterable, this.zzk);
        }

        public static zza zzb() {
            return (zza) zzo.zzh();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 256;
            this.zzm = true;
        }

        public static zza zza(zzbh zzbh) {
            return (zza) zzo.zza(zzbh);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbh>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzau.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0085;
                    case 2: goto L_0x007f;
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbh> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzp
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzav$zzbh> r3 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzav$zzbh> r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzp     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav$zzbh r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzo     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzp = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_common.zzav$zzbh r2 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzo
                return r2
            L_0x0033:
                r2 = 12
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
                r3 = 11
                java.lang.String r4 = "zzn"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t"
                com.google.android.gms.internal.mlkit_common.zzav$zzbh r4 = com.google.android.gms.internal.mlkit_common.zzav.zzbh.zzo
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza
                r2.<init>(r3)
                return r2
            L_0x0085:
                com.google.android.gms.internal.mlkit_common.zzav$zzbh r2 = new com.google.android.gms.internal.mlkit_common.zzav$zzbh
                r2.<init>()
                return r2
                switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzav.zzbh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
