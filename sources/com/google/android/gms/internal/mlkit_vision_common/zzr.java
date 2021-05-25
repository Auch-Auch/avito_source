package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcc;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzhv;
import kotlin.text.Typography;
public final class zzr {

    public static final class zza extends zzej<zza, zzb> implements zzft {
        private static final zza zzg;
        private static volatile zzgb<zza> zzh;
        private int zzc;
        private C0232zza zzd;
        private int zze;
        private zzab zzf;

        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza  reason: collision with other inner class name */
        public static final class C0232zza extends zzej<C0232zza, C0233zza> implements zzft {
            private static final C0232zza zzh;
            private static volatile zzgb<C0232zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza  reason: collision with other inner class name */
            public static final class C0233zza extends zzej.zza<C0232zza, C0233zza> implements zzft {
                private C0233zza() {
                    super(C0232zza.zzh);
                }

                public /* synthetic */ C0233zza(zzt zzt) {
                    this();
                }
            }

            static {
                C0232zza zza = new C0232zza();
                zzh = zza;
                zzej.zza(C0232zza.class, zza);
            }

            private C0232zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0232zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zza, zzb> implements zzft {
            private zzb() {
                super(zza.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
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

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaa extends zzej<zzaa, zza> implements zzft {
        private static final zzaa zzg;
        private static volatile zzgb<zzaa> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzej.zza<zzaa, zza> implements zzft {
            private zza() {
                super(zzaa.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzg = zzaa;
            zzej.zza(zzaa.class, zzaa);
        }

        private zzaa() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzab extends zzej<zzab, zza> implements zzft {
        private static final zzab zzj;
        private static volatile zzgb<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        public static final class zza extends zzej.zza<zzab, zza> implements zzft {
            private zza() {
                super(zzab.zzj);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzab zzab = new zzab();
            zzj = zzab;
            zzej.zza(zzab.class, zzab);
        }

        private zzab() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzab$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzab
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzac extends zzej<zzac, zzb> implements zzft {
        private static final zzac zzj;
        private static volatile zzgb<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        public enum zza implements zzel {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzeo<zza> zzd = new zzaj();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzai.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzej.zza<zzac, zzb> implements zzft {
            private zzb() {
                super(zzac.zzj);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        public enum zzc implements zzel {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzeo<zzc> zzd = new zzak();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzal.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzd implements zzel {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzeo<zzd> zzd = new zzan();
            private final int zze;

            private zzd(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzam.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        public enum zze implements zzel {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzeo<zze> zzd = new zzao();
            private final int zze;

            private zze(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzap.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzac = new zzac();
            zzj = zzac;
            zzej.zza(zzac.class, zzac);
        }

        private zzac() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zze.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzc.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzb
                r2.<init>(r3)
                return r2
            L_0x0087:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzac
                r2.<init>()
                return r2
                switch-data {1->0x0087, 2->0x0081, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzae extends zzej<zzae, zzb> implements zzft {
        private static final zzae zzg;
        private static volatile zzgb<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public enum zza implements zzel {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzeo<zza> zzj = new zzar();
            private final int zzk;

            private zza(int i) {
                this.zzk = i;
            }

            public static zzen zzb() {
                return zzaq.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzk;
            }
        }

        public static final class zzb extends zzej.zza<zzae, zzb> implements zzft {
            private zzb() {
                super(zzae.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzae zzae = new zzae();
            zzg = zzae;
            zzej.zza(zzae.class, zzae);
        }

        private zzae() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzae$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzae
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaf extends zzej<zzaf, zza> implements zzft {
        private static final zzaf zzl;
        private static volatile zzgb<zzaf> zzm;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;
        private zzes<zzbf> zzk = zzej.zzl();

        public static final class zza extends zzej.zza<zzaf, zza> implements zzft {
            private zza() {
                super(zzaf.zzl);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzaf zzaf = new zzaf();
            zzl = zzaf;
            zzej.zza(zzaf.class, zzaf);
        }

        private zzaf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006\b\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf$zza
                r2.<init>(r3)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf
                r2.<init>()
                return r2
                switch-data {1->0x0081, 2->0x007b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzah extends zzej<zzah, zza> implements zzft {
        private static final zzah zzg;
        private static volatile zzgb<zzah> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzej.zza<zzah, zza> implements zzft {
            private zza() {
                super(zzah.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzah zzah = new zzah();
            zzg = zzah;
            zzej.zza(zzah.class, zzah);
        }

        private zzah() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzah$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzah
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzai extends zzej<zzai, zza> implements zzft {
        private static final zzai zzg;
        private static volatile zzgb<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        public static final class zza extends zzej.zza<zzai, zza> implements zzft {
            private zza() {
                super(zzai.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzai zzai = new zzai();
            zzg = zzai;
            zzej.zza(zzai.class, zzai);
        }

        private zzai() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzai$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzai
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaj extends zzej<zzaj, zzb> implements zzft {
        private static final zzaj zze;
        private static volatile zzgb<zzaj> zzf;
        private int zzc;
        private int zzd;

        public enum zza implements zzel {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzeo<zza> zzc = new zzau();
            private final int zzd;

            private zza(int i) {
                this.zzd = i;
            }

            public static zzen zzb() {
                return zzav.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzd;
            }
        }

        public static final class zzb extends zzej.zza<zzaj, zzb> implements zzft {
            private zzb() {
                super(zzaj.zze);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzaj zzaj = new zzaj();
            zze = zzaj;
            zzej.zza(zzaj.class, zzaj);
        }

        private zzaj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zzb
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzak extends zzej<zzak, zza> implements zzft {
        private static final zzak zzk;
        private static volatile zzgb<zzak> zzl;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;
        private zzeq zzj = zzej.zzk();

        public static final class zza extends zzej.zza<zzak, zza> implements zzft {
            private zza() {
                super(zzak.zzk);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
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
            
            private static final zzeo<zzb> zzn = new zzaw();
            private final int zzo;

            private zzb(int i) {
                this.zzo = i;
            }

            public static zzen zzb() {
                return zzax.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzo;
            }
        }

        static {
            zzak zzak = new zzak();
            zzk = zzak;
            zzej.zza(zzak.class, zzak);
        }

        private zzak() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005\u0007\u0016"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzak
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzal extends zzej<zzal, zzb> implements zzft {
        private static final zzal zzl;
        private static volatile zzgb<zzal> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private int zzf;
        private String zzg = "";
        private String zzh = "";
        private int zzi;
        private long zzj;
        private boolean zzk;

        public enum zza implements zzel {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5),
            BASE_ENTITY_EXTRACTION(6);
            
            private static final zzeo<zza> zzh = new zzaz();
            private final int zzi;

            private zza(int i) {
                this.zzi = i;
            }

            public static zzen zzb() {
                return zzay.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzb extends zzej.zza<zzal, zzb> implements zzft {
            private zzb() {
                super(zzal.zzl);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        public enum zzc implements zzel {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4),
            URI(5);
            
            private static final zzeo<zzc> zzg = new zzba();
            private final int zzh;

            private zzc(int i) {
                this.zzh = i;
            }

            public static zzen zzb() {
                return zzbb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzal zzal = new zzal();
            zzl = zzal;
            zzej.zza(zzal.class, zzal);
        }

        private zzal() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzc.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzb
                r2.<init>(r3)
                return r2
            L_0x0083:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzal
                r2.<init>()
                return r2
                switch-data {1->0x0083, 2->0x007d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzam extends zzej<zzam, zzb> implements zzft {
        private static final zzam zzh;
        private static volatile zzgb<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        public static final class zza extends zzej<zza, C0234zza> implements zzft {
            private static final zza zzh;
            private static volatile zzgb<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza  reason: collision with other inner class name */
            public static final class C0234zza extends zzej.zza<zza, C0234zza> implements zzft {
                private C0234zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0234zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzam, zzb> implements zzft {
            private zzb() {
                super(zzam.zzh);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzam zzam = new zzam();
            zzh = zzam;
            zzej.zza(zzam.class, zzam);
        }

        private zzam() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzan extends zzej<zzan, zzb> implements zzft {
        private static final zzan zzh;
        private static volatile zzgb<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        public enum zza implements zzel {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzeo<zza> zzh = new zzbd();
            private final int zzi;

            private zza(int i) {
                this.zzi = i;
            }

            public static zzen zzb() {
                return zzbc.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzb extends zzej.zza<zzan, zzb> implements zzft {
            private zzb() {
                super(zzan.zzh);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzan zzan = new zzan();
            zzh = zzan;
            zzej.zza(zzan.class, zzan);
        }

        private zzan() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zzb
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzan
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzao extends zzej<zzao, zzc> implements zzft {
        private static final zzep<Integer, zza> zzg = new zzbe();
        private static final zzep<Integer, zzb> zzi = new zzbf();
        private static final zzao zzk;
        private static volatile zzgb<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzcc.zza zze;
        private zzeq zzf = zzej.zzk();
        private zzeq zzh = zzej.zzk();
        private zzae zzj;

        public enum zza implements zzel {
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
            
            private static final zzeo<zza> zzo = new zzbh();
            private final int zzp;

            private zza(int i) {
                this.zzp = i;
            }

            public static zzen zzb() {
                return zzbg.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzp;
            }
        }

        public enum zzb implements zzel {
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
            
            private static final zzeo<zzb> zzn = new zzbi();
            private final int zzo;

            private zzb(int i) {
                this.zzo = i;
            }

            public static zzen zzb() {
                return zzbj.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzo;
            }
        }

        public static final class zzc extends zzej.zza<zzao, zzc> implements zzft {
            private zzc() {
                super(zzao.zzk);
            }

            public /* synthetic */ zzc(zzt zzt) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>, com.google.android.gms.internal.mlkit_vision_common.zzbe] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>, com.google.android.gms.internal.mlkit_vision_common.zzbf] */
        static {
            zzao zzao = new zzao();
            zzk = zzao;
            zzej.zza(zzao.class, zzao);
        }

        private zzao() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzb.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzc
                r2.<init>(r3)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzao
                r2.<init>()
                return r2
                switch-data {1->0x0071, 2->0x006b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzap extends zzej<zzap, zza> implements zzft {
        private static final zzap zzj;
        private static volatile zzgb<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzcc.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        public static final class zza extends zzej.zza<zzap, zza> implements zzft {
            private zza() {
                super(zzap.zzj);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzap zzap = new zzap();
            zzj = zzap;
            zzej.zza(zzap.class, zzap);
        }

        private zzap() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzap$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzap
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaq extends zzej<zzaq, zza> implements zzft {
        private static final zzaq zzf;
        private static volatile zzgb<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        public static final class zza extends zzej.zza<zzaq, zza> implements zzft {
            private zza() {
                super(zzaq.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzaq zzaq = new zzaq();
            zzf = zzaq;
            zzej.zza(zzaq.class, zzaq);
        }

        private zzaq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzar extends zzej<zzar, zza> implements zzft {
        private static final zzar zzi;
        private static volatile zzgb<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        public static final class zza extends zzej.zza<zzar, zza> implements zzft {
            private zza() {
                super(zzar.zzi);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzar zzar = new zzar();
            zzi = zzar;
            zzej.zza(zzar.class, zzar);
        }

        private zzar() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzar$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzar
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzas extends zzej<zzas, zza> implements zzft {
        private static final zzep<Integer, zzac> zzf = new zzbk();
        private static final zzas zzj;
        private static volatile zzgb<zzas> zzk;
        private int zzc;
        private zzat zzd;
        private zzeq zze = zzej.zzk();
        private long zzg;
        private long zzh;
        private zzes<zzbf> zzi = zzej.zzl();

        public static final class zza extends zzej.zza<zzas, zza> implements zzft {
            private zza() {
                super(zzas.zzj);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbk, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzas zzas = new zzas();
            zzj = zzas;
            zzej.zza(zzas.class, zzas);
        }

        private zzas() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002\u0005\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzas$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzas
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzat extends zzej<zzat, zza> implements zzft {
        private static final zzat zzg;
        private static volatile zzgb<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        public static final class zza extends zzej.zza<zzat, zza> implements zzft {
            private zza() {
                super(zzat.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzat zzat = new zzat();
            zzg = zzat;
            zzej.zza(zzat.class, zzat);
        }

        private zzat() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzat$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzat
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzau extends zzej<zzau, zzb> implements zzft {
        private static final zzau zzh;
        private static volatile zzgb<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        public static final class zza extends zzej<zza, C0235zza> implements zzft {
            private static final zza zzf;
            private static volatile zzgb<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza  reason: collision with other inner class name */
            public static final class C0235zza extends zzej.zza<zza, C0235zza> implements zzft {
                private C0235zza() {
                    super(zza.zzf);
                }

                public /* synthetic */ C0235zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzau, zzb> implements zzft {
            private zzb() {
                super(zzau.zzh);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        public static final class zzc extends zzej<zzc, zza> implements zzft {
            private static final zzc zze;
            private static volatile zzgb<zzc> zzf;
            private int zzc;
            private zza zzd;

            public static final class zza extends zzej.zza<zzc, zza> implements zzft {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzt zzt) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzej.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzd extends zzej<zzd, zza> implements zzft {
            private static final zzd zzd;
            private static volatile zzgb<zzd> zze;
            private zzes<zza> zzc = zzej.zzl();

            public static final class zza extends zzej.zza<zzd, zza> implements zzft {
                private zza() {
                    super(zzd.zzd);
                }

                public /* synthetic */ zza(zzt zzt) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzd = zzd2;
                zzej.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.class
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzau zzau = new zzau();
            zzh = zzau;
            zzej.zza(zzau.class, zzau);
        }

        private zzau() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzav extends zzej<zzav, zza> implements zzft {
        private static final zzav zzf;
        private static volatile zzgb<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        public static final class zza extends zzej.zza<zzav, zza> implements zzft {
            private zza() {
                super(zzav.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzav zzav = new zzav();
            zzf = zzav;
            zzej.zza(zzav.class, zzav);
        }

        private zzav() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzav$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzav
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaw extends zzej<zzaw, zzb> implements zzft {
        private static final zzaw zzj;
        private static volatile zzgb<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        public enum zza implements zzel {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzeo<zza> zzd = new zzbm();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzbl.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzej.zza<zzaw, zzb> implements zzft {
            private zzb() {
                super(zzaw.zzj);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzaw zzaw = new zzaw();
            zzj = zzaw;
            zzej.zza(zzaw.class, zzaw);
        }

        private zzaw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw$zzb
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzax extends zzej<zzax, zza> implements zzft {
        private static final zzax zzh;
        private static volatile zzgb<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzes<zzan> zzg = zzej.zzl();

        public static final class zza extends zzej.zza<zzax, zza> implements zzft {
            private zza() {
                super(zzax.zzh);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzax zzax = new zzax();
            zzh = zzax;
            zzej.zza(zzax.class, zzax);
        }

        private zzax() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzax$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzax
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzay extends zzej<zzay, zza> implements zzft {
        private static final zzay zzi;
        private static volatile zzgb<zzay> zzj;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;
        private zzes<zzbf> zzh = zzej.zzl();

        public static final class zza extends zzej.zza<zzay, zza> implements zzft {
            private zza() {
                super(zzay.zzi);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzay zzay = new zzay();
            zzi = zzay;
            zzej.zza(zzay.class, zzay);
        }

        private zzay() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzay$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzay
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaz extends zzej<zzaz, zza> implements zzft {
        private static final zzaz zzg;
        private static volatile zzgb<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        public static final class zza extends zzej.zza<zzaz, zza> implements zzft {
            private zza() {
                super(zzaz.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzaz zzaz = new zzaz();
            zzg = zzaz;
            zzej.zza(zzaz.class, zzaz);
        }

        private zzaz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzej<zzb, C0237zzb> implements zzft {
        private static final zzb zzg;
        private static volatile zzgb<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0236zza> implements zzft {
            private static final zza zzi;
            private static volatile zzgb<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzes<zzy.zza> zzf = zzej.zzl();
            private zzes<zzy.zza> zzg = zzej.zzl();
            private zzam zzh;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza  reason: collision with other inner class name */
            public static final class C0236zza extends zzej.zza<zza, C0236zza> implements zzft {
                private C0236zza() {
                    super(zza.zzi);
                }

                public /* synthetic */ C0236zza(zzt zzt) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzi = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                    int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj
                    if (r3 != 0) goto L_0x0031
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.class
                    monitor-enter(r4)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj     // Catch:{ all -> 0x002e }
                    if (r3 != 0) goto L_0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r3 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi     // Catch:{ all -> 0x002e }
                    r3.<init>(r5)     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj = r3     // Catch:{ all -> 0x002e }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r0 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi
                    java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r5, r4, r3)
                    return r3
                L_0x006d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza
                    r3.<init>(r5)
                    return r3
                L_0x0073:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza
                    r3.<init>()
                    return r3
                    switch-data {1->0x0073, 2->0x006d, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb  reason: collision with other inner class name */
        public static final class C0237zzb extends zzej.zza<zzb, C0237zzb> implements zzft {
            private C0237zzb() {
                super(zzb.zzg);
            }

            public /* synthetic */ C0237zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzg = zzb;
            zzej.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzba extends zzej<zzba, zza> implements zzft {
        private static final zzba zzg;
        private static volatile zzgb<zzba> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public static final class zza extends zzej.zza<zzba, zza> implements zzft {
            private zza() {
                super(zzba.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzeo<zzb> zzd = new zzbn();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzbo.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzc implements zzel {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzeo<zzc> zzd = new zzbq();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzbp.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzba = new zzba();
            zzg = zzba;
            zzej.zza(zzba.class, zzba);
        }

        private zzba() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzc.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzba$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzba
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbb extends zzej<zzbb, zza> implements zzft {
        private static final zzbb zzf;
        private static volatile zzgb<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzej.zza<zzbb, zza> implements zzft {
            private zza() {
                super(zzbb.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzbb zzbb = new zzbb();
            zzf = zzbb;
            zzej.zza(zzbb.class, zzbb);
        }

        private zzbb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbc extends zzej<zzbc, zza> implements zzft {
        private static final zzbc zzi;
        private static volatile zzgb<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzes<zzc> zze = zzej.zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        public static final class zza extends zzej.zza<zzbc, zza> implements zzft {
            private zza() {
                super(zzbc.zzi);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzeo<zzb> zzh = new zzbr();
            private final int zzi;

            private zzb(int i) {
                this.zzi = i;
            }

            public static zzen zzb() {
                return zzbs.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzc extends zzej<zzc, zza> implements zzft {
            private static final zzc zze;
            private static volatile zzgb<zzc> zzf;
            private int zzc;
            private float zzd;

            public static final class zza extends zzej.zza<zzc, zza> implements zzft {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzt zzt) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzej.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzbc zzbc = new zzbc();
            zzi = zzbc;
            zzej.zza(zzbc.class, zzbc);
        }

        private zzbc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.class
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbd extends zzej<zzbd, zza> implements zzft {
        private static final zzbd zzf;
        private static volatile zzgb<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzej.zza<zzbd, zza> implements zzft {
            private zza() {
                super(zzbd.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzbd zzbd = new zzbd();
            zzf = zzbd;
            zzej.zza(zzbd.class, zzbd);
        }

        private zzbd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbe extends zzej<zzbe, zzb> implements zzft {
        private static final zzbe zzl;
        private static volatile zzgb<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbi zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        public enum zza implements zzel {
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
            
            private static final zzeo<zza> zzai = new zzbu();
            private final int zzaj;

            private zza(int i) {
                this.zzaj = i;
            }

            public static zzen zzb() {
                return zzbt.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzaj;
            }
        }

        public static final class zzb extends zzej.zza<zzbe, zzb> implements zzft {
            private zzb() {
                super(zzbe.zzl);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzbe zzbe = new zzbe();
            zzl = zzbe;
            zzej.zza(zzbe.class, zzbe);
        }

        private zzbe() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe$zzb
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe
                r2.<init>()
                return r2
                switch-data {1->0x007b, 2->0x0075, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbf extends zzej<zzbf, zza> implements zzft {
        private static final zzbf zzf;
        private static volatile zzgb<zzbf> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public static final class zza extends zzej.zza<zzbf, zza> implements zzft {
            private zza() {
                super(zzbf.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
            UNKNOWN(0),
            CANONICAL(1),
            TFLITE(2),
            TFLITE_SUPPORT(3);
            
            private static final zzeo<zzb> zze = new zzbv();
            private final int zzf;

            private zzb(int i) {
                this.zzf = i;
            }

            public static zzen zzb() {
                return zzbw.zza;
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
            zzbf zzbf = new zzbf();
            zzf = zzbf;
            zzej.zza(zzbf.class, zzbf);
        }

        private zzbf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbg extends zzej<zzbg, zza> implements zzft {
        private static final zzep<Integer, zzb> zzf = new zzby();
        private static final zzep<Integer, zzb> zzh = new zzbx();
        private static final zzep<Integer, zzb> zzj = new zzbz();
        private static final zzbg zzl;
        private static volatile zzgb<zzbg> zzm;
        private int zzc;
        private long zzd;
        private zzeq zze = zzej.zzk();
        private zzeq zzg = zzej.zzk();
        private zzeq zzi = zzej.zzk();
        private int zzk;

        public static final class zza extends zzej.zza<zzbg, zza> implements zzft {
            private zza() {
                super(zzbg.zzl);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
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
            
            private static final zzeo<zzb> zzm = new zzca();
            private final int zzn;

            private zzb(int i) {
                this.zzn = i;
            }

            public static zzen zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzn;
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzby, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zzb>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzbx, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zzb>] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_vision_common.zzbz, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zzb>] */
        static {
            zzbg zzbg = new zzbg();
            zzl = zzbg;
            zzej.zza(zzbg.class, zzbg);
        }

        private zzbg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0073:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zza
                r2.<init>(r3)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg
                r2.<init>()
                return r2
                switch-data {1->0x0079, 2->0x0073, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbi extends zzej<zzbi, zza> implements zzft {
        private static final zzbi zzf;
        private static volatile zzgb<zzbi> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        public static final class zza extends zzej.zza<zzbi, zza> implements zzft {
            private zza() {
                super(zzbi.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzbi zzbi = new zzbi();
            zzf = zzbi;
            zzej.zza(zzbi.class, zzbi);
        }

        private zzbi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbi
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzej<zzc, zzb> implements zzft {
        private static final zzc zzg;
        private static volatile zzgb<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0238zza> implements zzft {
            private static final zzep<Integer, zzao.zza> zzj = new zzv();
            private static final zzep<Integer, zzao.zzb> zzl = new zzu();
            private static final zza zzm;
            private static volatile zzgb<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzcc.zza zzh;
            private zzeq zzi = zzej.zzk();
            private zzeq zzk = zzej.zzk();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza  reason: collision with other inner class name */
            public static final class C0238zza extends zzej.zza<zza, C0238zza> implements zzft {
                private C0238zza() {
                    super(zza.zzm);
                }

                public /* synthetic */ C0238zza(zzt zzt) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>, com.google.android.gms.internal.mlkit_vision_common.zzv] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>, com.google.android.gms.internal.mlkit_vision_common.zzu] */
            static {
                zza zza = new zza();
                zzm = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza.zzb()
                    r2[r3] = r4
                    r3 = 9
                    java.lang.String r4 = "zzk"
                    r2[r3] = r4
                    r3 = 10
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzb.zzb()
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x007f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0085:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzc, zzb> implements zzft {
            private zzb() {
                super(zzc.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzej.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzej<zzd, zzb> implements zzft {
        private static final zzd zzg;
        private static volatile zzgb<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0239zza> implements zzft {
            private static final zza zzj;
            private static volatile zzgb<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza  reason: collision with other inner class name */
            public static final class C0239zza extends zzej.zza<zza, C0239zza> implements zzft {
                private C0239zza() {
                    super(zza.zzj);
                }

                public /* synthetic */ C0239zza(zzt zzt) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzj = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x006f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzd, zzb> implements zzft {
            private zzb() {
                super(zzd.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
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

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzej<zze, zzb> implements zzft {
        private static final zze zzg;
        private static volatile zzgb<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0240zza> implements zzft {
            private static final zza zzh;
            private static volatile zzgb<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza  reason: collision with other inner class name */
            public static final class C0240zza extends zzej.zza<zza, C0240zza> implements zzft {
                private C0240zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0240zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zze, zzb> implements zzft {
            private zzb() {
                super(zze.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zzg = zze2;
            zzej.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzej<zzf, zzb> implements zzft {
        private static final zzf zzg;
        private static volatile zzgb<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0241zza> implements zzft {
            private static final zza zzi;
            private static volatile zzgb<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza  reason: collision with other inner class name */
            public static final class C0241zza extends zzej.zza<zza, C0241zza> implements zzft {
                private C0241zza() {
                    super(zza.zzi);
                }

                public /* synthetic */ C0241zza(zzt zzt) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzi = zza;
                zzej.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0063:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzf, zzb> implements zzft {
            private zzb() {
                super(zzf.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzg = zzf2;
            zzej.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzej<zzg, zzb> implements zzft {
        private static final zzg zzg;
        private static volatile zzgb<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0242zza> implements zzft {
            private static final zza zzh;
            private static volatile zzgb<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza  reason: collision with other inner class name */
            public static final class C0242zza extends zzej.zza<zza, C0242zza> implements zzft {
                private C0242zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0242zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzg, zzb> implements zzft {
            private zzb() {
                super(zzg.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzg = zzg2;
            zzej.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzej<zzh, zzb> implements zzft {
        private static final zzh zzg;
        private static volatile zzgb<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0243zza> implements zzft {
            private static final zza zzg;
            private static volatile zzgb<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza  reason: collision with other inner class name */
            public static final class C0243zza extends zzej.zza<zza, C0243zza> implements zzft {
                private C0243zza() {
                    super(zza.zzg);
                }

                public /* synthetic */ C0243zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0059:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzh, zzb> implements zzft {
            private zzb() {
                super(zzh.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzh zzh2 = new zzh();
            zzg = zzh2;
            zzej.zza(zzh.class, zzh2);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzej<zzi, zzb> implements zzft {
        private static final zzi zzg;
        private static volatile zzgb<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzej<zza, C0244zza> implements zzft {
            private static final zza zzh;
            private static volatile zzgb<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza  reason: collision with other inner class name */
            public static final class C0244zza extends zzej.zza<zza, C0244zza> implements zzft {
                private C0244zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0244zza(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzi, zzb> implements zzft {
            private zzb() {
                super(zzi.zzg);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzej.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzej<zzj, zza> implements zzft {
        private static final zzj zze;
        private static volatile zzgb<zzj> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzej.zza<zzj, zza> implements zzft {
            private zza() {
                super(zzj.zze);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zze = zzj;
            zzej.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzej<zzk, zza> implements zzft {
        private static final zzk zzi;
        private static volatile zzgb<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        public static final class zza extends zzej.zza<zzk, zza> implements zzft {
            private zza() {
                super(zzk.zzi);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzi = zzk;
            zzej.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzk
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzej<zzl, zza> implements zzft {
        private static final zzep<Integer, zzac> zzg = new zzw();
        private static final zzl zzi;
        private static volatile zzgb<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzej.zzk();
        private long zzh;

        public static final class zza extends zzej.zza<zzl, zza> implements zzft {
            private zza() {
                super(zzl.zzi);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzw, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzl zzl = new zzl();
            zzi = zzl;
            zzej.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzl
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzm extends zzej<zzm, zza> implements zzft {
        private static final zzm zzg;
        private static volatile zzgb<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzm, zza> implements zzft {
            private zza() {
                super(zzm.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzm zzm = new zzm();
            zzg = zzm;
            zzej.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzm
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzn extends zzej<zzn, zza> implements zzft {
        private static final zzn zzf;
        private static volatile zzgb<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public static final class zza extends zzej.zza<zzn, zza> implements zzft {
            private zza() {
                super(zzn.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        public enum zzb implements zzel {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzeo<zzb> zzd = new zzx();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzen zzb() {
                return zzy.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzn zzn = new zzn();
            zzf = zzn;
            zzej.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzb.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzn
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzo extends zzej<zzo, zza> implements zzft {
        private static final zzo zzg;
        private static volatile zzgb<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzo, zza> implements zzft {
            private zza() {
                super(zzo.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzo zzo = new zzo();
            zzg = zzo;
            zzej.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzo
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzp extends zzej<zzp, zza> implements zzft {
        private static final zzp zzg;
        private static volatile zzgb<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzp, zza> implements zzft {
            private zza() {
                super(zzp.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzp zzp = new zzp();
            zzg = zzp;
            zzej.zza(zzp.class, zzp);
        }

        private zzp() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzp$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzp
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzq extends zzej<zzq, zza> implements zzft {
        private static final zzq zzg;
        private static volatile zzgb<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzq, zza> implements zzft {
            private zza() {
                super(zzq.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzq zzq = new zzq();
            zzg = zzq;
            zzej.zza(zzq.class, zzq);
        }

        private zzq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzq$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzq
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr  reason: collision with other inner class name */
    public static final class C0245zzr extends zzej<C0245zzr, zza> implements zzft {
        private static final C0245zzr zzg;
        private static volatile zzgb<C0245zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza */
        public static final class zza extends zzej.zza<C0245zzr, zza> implements zzft {
            private zza() {
                super(C0245zzr.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            C0245zzr zzr = new C0245zzr();
            zzg = zzr;
            zzej.zza(C0245zzr.class, zzr);
        }

        private C0245zzr() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzr
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.C0245zzr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzs extends zzej<zzs, zza> implements zzft {
        private static final zzs zzg;
        private static volatile zzgb<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzs, zza> implements zzft {
            private zza() {
                super(zzs.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzs zzs = new zzs();
            zzg = zzs;
            zzej.zza(zzs.class, zzs);
        }

        private zzs() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzs$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzs
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzt extends zzej<zzt, zza> implements zzft {
        private static final zzt zzg;
        private static volatile zzgb<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzt, zza> implements zzft {
            private zza() {
                super(zzt.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzt zzt = new zzt();
            zzg = zzt;
            zzej.zza(zzt.class, zzt);
        }

        private zzt() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzt$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzt
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzu extends zzej<zzu, zza> implements zzft {
        private static final zzu zzg;
        private static volatile zzgb<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzu, zza> implements zzft {
            private zza() {
                super(zzu.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzu zzu = new zzu();
            zzg = zzu;
            zzej.zza(zzu.class, zzu);
        }

        private zzu() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzu$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzu
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzv extends zzej<zzv, zza> implements zzft {
        private static final zzv zzg;
        private static volatile zzgb<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzv, zza> implements zzft {
            private zza() {
                super(zzv.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzv zzv = new zzv();
            zzg = zzv;
            zzej.zza(zzv.class, zzv);
        }

        private zzv() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzv$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzv
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzw extends zzej<zzw, zza> implements zzft {
        private static final zzw zzg;
        private static volatile zzgb<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzej.zza<zzw, zza> implements zzft {
            private zza() {
                super(zzw.zzg);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzw zzw = new zzw();
            zzg = zzw;
            zzej.zza(zzw.class, zzw);
        }

        private zzw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzw$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzw
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzx extends zzej<zzx, zza> implements zzft {
        private static final zzx zzf;
        private static volatile zzgb<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        public static final class zza extends zzej.zza<zzx, zza> implements zzft {
            private zza() {
                super(zzx.zzf);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        static {
            zzx zzx = new zzx();
            zzf = zzx;
            zzej.zza(zzx.class, zzx);
        }

        private zzx() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx>, com.google.android.gms.internal.mlkit_vision_common.zzej$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzx$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzx
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzy extends zzej<zzy, zzb> implements zzft {
        private static final zzy zzi;
        private static volatile zzgb<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzes<zza> zzf = zzej.zzl();
        private zzes<zza> zzg = zzej.zzl();
        private long zzh;

        public static final class zza extends zzej<zza, zzb> implements zzft {
            private static final zza zzf;
            private static volatile zzgb<zza> zzg;
            private int zzc;
            private int zzd;
            private zzeq zze = zzej.zzk();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zza  reason: collision with other inner class name */
            public enum EnumC0246zza implements zzel {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzeo<EnumC0246zza> zzf = new zzaa();
                private final int zzg;

                private EnumC0246zza(int i) {
                    this.zzg = i;
                }

                public static zzen zzb() {
                    return zzz.zza;
                }

                @Override // java.lang.Enum, java.lang.Object
                public final String toString() {
                    return "<" + EnumC0246zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
                public final int zza() {
                    return this.zzg;
                }
            }

            public static final class zzb extends zzej.zza<zza, zzb> implements zzft {
                private zzb() {
                    super(zza.zzf);
                }

                public /* synthetic */ zzb(zzt zzt) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.EnumC0246zza.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                    return r2
                L_0x0054:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zzb
                    r2.<init>(r3)
                    return r2
                L_0x005a:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzej.zza<zzy, zzb> implements zzft {
            private zzb() {
                super(zzy.zzi);
            }

            public /* synthetic */ zzb(zzt zzt) {
                this();
            }
        }

        static {
            zzy zzy = new zzy();
            zzi = zzy;
            zzej.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj
                if (r3 != 0) goto L_0x0031
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj     // Catch:{ all -> 0x002e }
                if (r3 != 0) goto L_0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r3 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi     // Catch:{ all -> 0x002e }
                r3.<init>(r5)     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj = r3     // Catch:{ all -> 0x002e }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r5, r4, r3)
                return r3
            L_0x0065:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zzb r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zzb
                r3.<init>(r5)
                return r3
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy
                r3.<init>()
                return r3
                switch-data {1->0x006b, 2->0x0065, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzz extends zzej<zzz, zza> implements zzft {
        private static final zzep<Integer, zzac> zzg = new zzab();
        private static final zzz zzj;
        private static volatile zzgb<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzej.zzk();
        private long zzh;
        private boolean zzi;

        public static final class zza extends zzej.zza<zzz, zza> implements zzft {
            private zza() {
                super(zzz.zzj);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzab, com.google.android.gms.internal.mlkit_vision_common.zzep<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzz zzz = new zzz();
            zzj = zzz;
            zzej.zza(zzz.class, zzz);
        }

        private zzz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzz$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzz
                r2.<init>()
                return r2
                switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzag extends zzej<zzag, zza> implements zzft {
        private static final zzag zzk;
        private static volatile zzgb<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        public static final class zza extends zzej.zza<zzag, zza> implements zzft {
            private zza() {
                super(zzag.zzk);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(j);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzc(i);
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzd(i);
                return this;
            }

            public final zza zzd(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zze(i);
                return this;
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }

            public final zza zza(zzb zzb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zzb);
                return this;
            }

            public final zza zza(zzae.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zza);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzb(i);
                return this;
            }
        }

        public enum zzb implements zzel {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzeo<zzb> zzg = new zzas();
            private final int zzh;

            private zzb(int i) {
                this.zzh = i;
            }

            public static zzen zzb() {
                return zzat.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzag zzag = new zzag();
            zzk = zzag;
            zzej.zza(zzag.class, zzag);
        }

        private zzag() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            this.zzc |= 8;
            this.zzg = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(int i) {
            this.zzc |= 16;
            this.zzh = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(int i) {
            this.zzc |= 32;
            this.zzi = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(int i) {
            this.zzc |= 64;
            this.zzj = i;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzen r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzag
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzb zzb2) {
            this.zze = zzb2.zza();
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzae.zza zza2) {
            this.zzf = zza2.zza();
            this.zzc |= 4;
        }

        public static zza zza() {
            return (zza) zzk.zzh();
        }
    }

    public static final class zzad extends zzej.zze<zzad, zza> implements zzft {
        private static final zzad zzbd;
        private static volatile zzgb<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private C0245zzr zzad;
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
        private zzes<zzhv.zzf> zzay = zzej.zzl();
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
        private zzav zzs;
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
            zzej.zza(zzad.class, zzad2);
        }

        private zzad() {
        }

        public static zza zza(zzad zzad2) {
            return (zza) zzbd.zza(zzad2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzag zzag2) {
            this.zzg = zzag2.zza();
            this.zzd |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzag zzag2) {
            zzag2.getClass();
            this.zzba = zzag2;
            this.zze |= 16384;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzbh zzbh) {
            zzbh.getClass();
            this.zzf = zzbh;
            this.zzd |= 1;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbh zza() {
            zzbh zzbh = this.zzf;
            return zzbh == null ? zzbh.zzc() : zzbh;
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzad>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
            // Method dump skipped, instructions count: 414
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzad.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public static final class zza extends zzej.zzb<zzad, zza> implements zzft {
            private zza() {
                super(zzad.zzbd);
            }

            public /* synthetic */ zza(zzt zzt) {
                this();
            }

            public final zza zza(zzbh.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbh) ((zzej) zza.zzh()));
                return this;
            }

            public final zzbh zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzag zzag) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzag);
                return this;
            }

            public final zza zza(zzag zzag) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzag);
                return this;
            }
        }
    }

    public static final class zzbh extends zzej<zzbh, zza> implements zzft {
        private static final zzbh zzo;
        private static volatile zzgb<zzbh> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzes<String> zzk = zzej.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        public static final class zza extends zzej.zza<zzbh, zza> implements zzft {
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

            public /* synthetic */ zza(zzt zzt) {
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
            zzej.zza(zzbh.class, zzbh);
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
            zzes<String> zzes = this.zzk;
            if (!zzes.zza()) {
                int size = zzes.size();
                this.zzk = zzes.zzb(size == 0 ? 10 : size << 1);
            }
            zzda.zza(iterable, this.zzk);
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

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzej$zzc, com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzej
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzp
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgb<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzp     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzej$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzej$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzo     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzp = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzo
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzo
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzej.zza(r4, r3, r2)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza
                r2.<init>(r3)
                return r2
            L_0x0085:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh
                r2.<init>()
                return r2
                switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
