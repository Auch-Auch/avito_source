package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzjp;
import kotlin.text.Typography;
public final class zzbm {

    public static final class zza extends zzgd<zza, zzb> implements zzhn {
        private static final zza zzg;
        private static volatile zzhv<zza> zzh;
        private int zzc;
        private C0247zza zzd;
        private int zze;
        private zzab zzf;

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza  reason: collision with other inner class name */
        public static final class C0247zza extends zzgd<C0247zza, C0248zza> implements zzhn {
            private static final C0247zza zzh;
            private static volatile zzhv<C0247zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza$zza  reason: collision with other inner class name */
            public static final class C0248zza extends zzgd.zza<C0247zza, C0248zza> implements zzhn {
                private C0248zza() {
                    super(C0247zza.zzh);
                }

                public /* synthetic */ C0248zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                C0247zza zza = new C0247zza();
                zzh = zza;
                zzgd.zza(C0247zza.class, zza);
            }

            private C0247zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.C0247zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zza, zzb> implements zzhn {
            private zzb() {
                super(zza.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
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

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zza
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaa extends zzgd<zzaa, zza> implements zzhn {
        private static final zzaa zzg;
        private static volatile zzhv<zzaa> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzgd.zza<zzaa, zza> implements zzhn {
            private zza() {
                super(zzaa.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzg = zzaa;
            zzgd.zza(zzaa.class, zzaa);
        }

        private zzaa() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaa
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaa.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzab extends zzgd<zzab, zza> implements zzhn {
        private static final zzab zzj;
        private static volatile zzhv<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        public static final class zza extends zzgd.zza<zzab, zza> implements zzhn {
            private zza() {
                super(zzab.zzj);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zza(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzb(j);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzd(j);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zze(j);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzf(j);
                return this;
            }
        }

        static {
            zzab zzab = new zzab();
            zzj = zzab;
            zzgd.zza(zzab.class, zzab);
        }

        private zzab() {
        }

        public static zza zza() {
            return (zza) zzj.zzh();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(long j) {
            this.zzc |= 16;
            this.zzh = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzab.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzag extends zzgd<zzag, zza> implements zzhn {
        private static final zzag zzk;
        private static volatile zzhv<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        public static final class zza extends zzgd.zza<zzag, zza> implements zzhn {
            private zza() {
                super(zzag.zzk);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzgi<zzb> zzg = new zzcn();
            private final int zzh;

            private zzb(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzco.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzag zzag = new zzag();
            zzk = zzag;
            zzgd.zza(zzag.class, zzag);
        }

        private zzag() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzk
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzag
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzag.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzah extends zzgd<zzah, zza> implements zzhn {
        private static final zzah zzg;
        private static volatile zzhv<zzah> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        public static final class zza extends zzgd.zza<zzah, zza> implements zzhn {
            private zza() {
                super(zzah.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzah zzah = new zzah();
            zzg = zzah;
            zzgd.zza(zzah.class, zzah);
        }

        private zzah() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzah.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzai extends zzgd<zzai, zza> implements zzhn {
        private static final zzai zzg;
        private static volatile zzhv<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        public static final class zza extends zzgd.zza<zzai, zza> implements zzhn {
            private zza() {
                super(zzai.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzai zzai = new zzai();
            zzg = zzai;
            zzgd.zza(zzai.class, zzai);
        }

        private zzai() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzai
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzai.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaj extends zzgd<zzaj, zzb> implements zzhn {
        private static final zzaj zze;
        private static volatile zzhv<zzaj> zzf;
        private int zzc;
        private int zzd;

        public enum zza implements zzgf {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzgi<zza> zzc = new zzcp();
            private final int zzd;

            private zza(int i) {
                this.zzd = i;
            }

            public static zzgh zzb() {
                return zzcq.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzd;
            }
        }

        public static final class zzb extends zzgd.zza<zzaj, zzb> implements zzhn {
            private zzb() {
                super(zzaj.zze);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzaj zzaj = new zzaj();
            zze = zzaj;
            zzgd.zza(zzaj.class, zzaj);
        }

        private zzaj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zze
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj$zzb
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzak extends zzgd<zzak, zza> implements zzhn {
        private static final zzak zzk;
        private static volatile zzhv<zzak> zzl;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;
        private zzgk zzj = zzgd.zzk();

        public static final class zza extends zzgd.zza<zzak, zza> implements zzhn {
            private zza() {
                super(zzak.zzk);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
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
            
            private static final zzgi<zzb> zzn = new zzcr();
            private final int zzo;

            private zzb(int i) {
                this.zzo = i;
            }

            public static zzgh zzb() {
                return zzcs.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzo;
            }
        }

        static {
            zzak zzak = new zzak();
            zzk = zzak;
            zzgd.zza(zzak.class, zzak);
        }

        private zzak() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzk
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005\u0007\u0016"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak
                r2.<init>()
                return r2
                switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzak.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzal extends zzgd<zzal, zzb> implements zzhn {
        private static final zzal zzl;
        private static volatile zzhv<zzal> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private int zzf;
        private String zzg = "";
        private String zzh = "";
        private int zzi;
        private long zzj;
        private boolean zzk;

        public enum zza implements zzgf {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5),
            BASE_ENTITY_EXTRACTION(6);
            
            private static final zzgi<zza> zzh = new zzcu();
            private final int zzi;

            private zza(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzct.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzb extends zzgd.zza<zzal, zzb> implements zzhn {
            private zzb() {
                super(zzal.zzl);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        public enum zzc implements zzgf {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4),
            URI(5);
            
            private static final zzgi<zzc> zzg = new zzcv();
            private final int zzh;

            private zzc(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzcw.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzal zzal = new zzal();
            zzl = zzal;
            zzgd.zza(zzal.class, zzal);
        }

        private zzal() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzl
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzc.zzb()
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zzb
                r2.<init>(r3)
                return r2
            L_0x0083:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal
                r2.<init>()
                return r2
                switch-data {1->0x0083, 2->0x007d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzal.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzam extends zzgd<zzam, zzb> implements zzhn {
        private static final zzam zzh;
        private static volatile zzhv<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        public static final class zza extends zzgd<zza, C0249zza> implements zzhn {
            private static final zza zzh;
            private static volatile zzhv<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza$zza  reason: collision with other inner class name */
            public static final class C0249zza extends zzgd.zza<zza, C0249zza> implements zzhn {
                private C0249zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0249zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzam, zzb> implements zzhn {
            private zzb() {
                super(zzam.zzh);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzam zzam = new zzam();
            zzh = zzam;
            zzgd.zza(zzam.class, zzam);
        }

        private zzam() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzh
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzam.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzan extends zzgd<zzan, zzb> implements zzhn {
        private static final zzan zzh;
        private static volatile zzhv<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        public enum zza implements zzgf {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzgi<zza> zzh = new zzcy();
            private final int zzi;

            private zza(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzcx.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzb extends zzgd.zza<zzan, zzb> implements zzhn {
            private zzb() {
                super(zzan.zzh);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzan zzan = new zzan();
            zzh = zzan;
            zzgd.zza(zzan.class, zzan);
        }

        private zzan() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzh
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan$zzb
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzao extends zzgd<zzao, zzc> implements zzhn {
        private static final zzgj<Integer, zza> zzg = new zzcz();
        private static final zzgj<Integer, zzb> zzi = new zzda();
        private static final zzao zzk;
        private static volatile zzhv<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzdx.zza zze;
        private zzgk zzf = zzgd.zzk();
        private zzgk zzh = zzgd.zzk();
        private zzae zzj;

        public enum zza implements zzgf {
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
            
            private static final zzgi<zza> zzo = new zzdc();
            private final int zzp;

            private zza(int i) {
                this.zzp = i;
            }

            public static zzgh zzb() {
                return zzdb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzp;
            }
        }

        public enum zzb implements zzgf {
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
            
            private static final zzgi<zzb> zzn = new zzdd();
            private final int zzo;

            private zzb(int i) {
                this.zzo = i;
            }

            public static zzgh zzb() {
                return zzde.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzo;
            }
        }

        public static final class zzc extends zzgd.zza<zzao, zzc> implements zzhn {
            private zzc() {
                super(zzao.zzk);
            }

            public /* synthetic */ zzc(zzbo zzbo) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zza>, com.google.android.gms.internal.mlkit_vision_face.zzcz] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzb>, com.google.android.gms.internal.mlkit_vision_face.zzda] */
        static {
            zzao zzao = new zzao();
            zzk = zzao;
            zzgd.zza(zzao.class, zzao);
        }

        private zzao() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzl     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzl = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzk
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzb.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzc
                r2.<init>(r3)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao
                r2.<init>()
                return r2
                switch-data {1->0x0071, 2->0x006b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaq extends zzgd<zzaq, zza> implements zzhn {
        private static final zzaq zzf;
        private static volatile zzhv<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        public static final class zza extends zzgd.zza<zzaq, zza> implements zzhn {
            private zza() {
                super(zzaq.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzaq zzaq = new zzaq();
            zzf = zzaq;
            zzgd.zza(zzaq.class, zzaq);
        }

        private zzaq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaq
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzar extends zzgd<zzar, zza> implements zzhn {
        private static final zzar zzi;
        private static volatile zzhv<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        public static final class zza extends zzgd.zza<zzar, zza> implements zzhn {
            private zza() {
                super(zzar.zzi);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzar zzar = new zzar();
            zzi = zzar;
            zzgd.zza(zzar.class, zzar);
        }

        private zzar() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzi
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzar.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzas extends zzgd<zzas, zza> implements zzhn {
        private static final zzgj<Integer, zzbx> zzf = new zzdf();
        private static final zzas zzj;
        private static volatile zzhv<zzas> zzk;
        private int zzc;
        private zzat zzd;
        private zzgk zze = zzgd.zzk();
        private long zzg;
        private long zzh;
        private zzgm<zzbf> zzi = zzgd.zzl();

        public static final class zza extends zzgd.zza<zzas, zza> implements zzhn {
            private zza() {
                super(zzas.zzj);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzdf, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbx>] */
        static {
            zzas zzas = new zzas();
            zzj = zzas;
            zzgd.zza(zzas.class, zzas);
        }

        private zzas() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002\u0005\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzas.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzat extends zzgd<zzat, zza> implements zzhn {
        private static final zzat zzg;
        private static volatile zzhv<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        public static final class zza extends zzgd.zza<zzat, zza> implements zzhn {
            private zza() {
                super(zzat.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzat zzat = new zzat();
            zzg = zzat;
            zzgd.zza(zzat.class, zzat);
        }

        private zzat() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzat.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzau extends zzgd<zzau, zzb> implements zzhn {
        private static final zzau zzh;
        private static volatile zzhv<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        public static final class zza extends zzgd<zza, C0250zza> implements zzhn {
            private static final zza zzf;
            private static volatile zzhv<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza$zza  reason: collision with other inner class name */
            public static final class C0250zza extends zzgd.zza<zza, C0250zza> implements zzhn {
                private C0250zza() {
                    super(zza.zzf);
                }

                public /* synthetic */ C0250zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzau, zzb> implements zzhn {
            private zzb() {
                super(zzau.zzh);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        public static final class zzc extends zzgd<zzc, zza> implements zzhn {
            private static final zzc zze;
            private static volatile zzhv<zzc> zzf;
            private int zzc;
            private zza zzd;

            public static final class zza extends zzgd.zza<zzc, zza> implements zzhn {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzgd.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzd extends zzgd<zzd, zza> implements zzhn {
            private static final zzd zzd;
            private static volatile zzhv<zzd> zze;
            private zzgm<zza> zzc = zzgd.zzl();

            public static final class zza extends zzgd.zza<zzd, zza> implements zzhn {
                private zza() {
                    super(zzd.zzd);
                }

                public /* synthetic */ zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                zzd zzd2 = new zzd();
                zzd = zzd2;
                zzgd.zza(zzd.class, zzd2);
            }

            private zzd() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zze
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zze     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zzd     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zze = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zzd
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza.class
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zzd
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzau zzau = new zzau();
            zzh = zzau;
            zzgd.zza(zzau.class, zzau);
        }

        private zzau() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzh
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzau.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzav extends zzgd<zzav, zza> implements zzhn {
        private static final zzav zzf;
        private static volatile zzhv<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        public static final class zza extends zzgd.zza<zzav, zza> implements zzhn {
            private zza() {
                super(zzav.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzav zzav = new zzav();
            zzf = zzav;
            zzgd.zza(zzav.class, zzav);
        }

        private zzav() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzav
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzav.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaw extends zzgd<zzaw, zzb> implements zzhn {
        private static final zzaw zzj;
        private static volatile zzhv<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        public enum zza implements zzgf {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzgi<zza> zzd = new zzdh();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdg.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzgd.zza<zzaw, zzb> implements zzhn {
            private zzb() {
                super(zzaw.zzj);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzaw zzaw = new zzaw();
            zzj = zzaw;
            zzgd.zza(zzaw.class, zzaw);
        }

        private zzaw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw$zzb
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzax extends zzgd<zzax, zza> implements zzhn {
        private static final zzax zzh;
        private static volatile zzhv<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzgm<zzan> zzg = zzgd.zzl();

        public static final class zza extends zzgd.zza<zzax, zza> implements zzhn {
            private zza() {
                super(zzax.zzh);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzax zzax = new zzax();
            zzh = zzax;
            zzgd.zza(zzax.class, zzax);
        }

        private zzax() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzi     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzh     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzi = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzh
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzan.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzax.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzay extends zzgd<zzay, zza> implements zzhn {
        private static final zzay zzi;
        private static volatile zzhv<zzay> zzj;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;
        private zzgm<zzbf> zzh = zzgd.zzl();

        public static final class zza extends zzgd.zza<zzay, zza> implements zzhn {
            private zza() {
                super(zzay.zzi);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzay zzay = new zzay();
            zzi = zzay;
            zzgd.zza(zzay.class, zzay);
        }

        private zzay() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzi
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzay.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaz extends zzgd<zzaz, zza> implements zzhn {
        private static final zzaz zzg;
        private static volatile zzhv<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        public static final class zza extends zzgd.zza<zzaz, zza> implements zzhn {
            private zza() {
                super(zzaz.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzaz zzaz = new zzaz();
            zzg = zzaz;
            zzgd.zza(zzaz.class, zzaz);
        }

        private zzaz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaz
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzgd<zzb, C0252zzb> implements zzhn {
        private static final zzb zzg;
        private static volatile zzhv<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0251zza> implements zzhn {
            private static final zza zzi;
            private static volatile zzhv<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzgm<zzy.zza> zzf = zzgd.zzl();
            private zzgm<zzy.zza> zzg = zzgd.zzl();
            private zzam zzh;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza$zza  reason: collision with other inner class name */
            public static final class C0251zza extends zzgd.zza<zza, C0251zza> implements zzhn {
                private C0251zza() {
                    super(zza.zzi);
                }

                public /* synthetic */ C0251zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzi = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.class
                    int[] r5 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzj
                    if (r3 != 0) goto L_0x0031
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.class
                    monitor-enter(r4)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzj     // Catch:{ all -> 0x002e }
                    if (r3 != 0) goto L_0x002c
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r3 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzi     // Catch:{ all -> 0x002e }
                    r3.<init>(r5)     // Catch:{ all -> 0x002e }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzj = r3     // Catch:{ all -> 0x002e }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r0 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zzi
                    java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r5, r4, r3)
                    return r3
                L_0x006d:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza$zza r3 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza$zza
                    r3.<init>(r5)
                    return r3
                L_0x0073:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza r3 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza
                    r3.<init>()
                    return r3
                    switch-data {1->0x0073, 2->0x006d, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zzb  reason: collision with other inner class name */
        public static final class C0252zzb extends zzgd.zza<zzb, C0252zzb> implements zzhn {
            private C0252zzb() {
                super(zzb.zzg);
            }

            public /* synthetic */ C0252zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzg = zzb;
            zzgd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzba extends zzgd<zzba, zza> implements zzhn {
        private static final zzba zzg;
        private static volatile zzhv<zzba> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public static final class zza extends zzgd.zza<zzba, zza> implements zzhn {
            private zza() {
                super(zzba.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzgi<zzb> zzd = new zzdi();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdj.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzc implements zzgf {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzgi<zzc> zzd = new zzdl();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdk.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzba = new zzba();
            zzg = zzba;
            zzgd.zza(zzba.class, zzba);
        }

        private zzba() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzc.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba
                r2.<init>()
                return r2
                switch-data {1->0x006d, 2->0x0067, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzba.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbb extends zzgd<zzbb, zza> implements zzhn {
        private static final zzbb zzf;
        private static volatile zzhv<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzgd.zza<zzbb, zza> implements zzhn {
            private zza() {
                super(zzbb.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzbb zzbb = new zzbb();
            zzf = zzbb;
            zzgd.zza(zzbb.class, zzbb);
        }

        private zzbb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbb
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbc extends zzgd<zzbc, zza> implements zzhn {
        private static final zzbc zzi;
        private static volatile zzhv<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzgm<zzc> zze = zzgd.zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        public static final class zza extends zzgd.zza<zzbc, zza> implements zzhn {
            private zza() {
                super(zzbc.zzi);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzgi<zzb> zzh = new zzdm();
            private final int zzi;

            private zzb(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzdn.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        public static final class zzc extends zzgd<zzc, zza> implements zzhn {
            private static final zzc zze;
            private static volatile zzhv<zzc> zzf;
            private int zzc;
            private float zzd;

            public static final class zza extends zzgd.zza<zzc, zza> implements zzhn {
                private zza() {
                    super(zzc.zze);
                }

                public /* synthetic */ zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                zzc zzc2 = new zzc();
                zze = zzc2;
                zzgd.zza(zzc.class, zzc2);
            }

            private zzc() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zzf     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zze     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zzf = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc
                    r2.<init>()
                    return r2
                    switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        static {
            zzbc zzbc = new zzbc();
            zzi = zzbc;
            zzgd.zza(zzbc.class, zzbc);
        }

        private zzbc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzi
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzc.class
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc
                r2.<init>()
                return r2
                switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbd extends zzgd<zzbd, zza> implements zzhn {
        private static final zzbd zzf;
        private static volatile zzhv<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        public static final class zza extends zzgd.zza<zzbd, zza> implements zzhn {
            private zza() {
                super(zzbd.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzbd zzbd = new zzbd();
            zzf = zzbd;
            zzgd.zza(zzbd.class, zzbd);
        }

        private zzbd() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbd
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbe extends zzgd<zzbe, zzb> implements zzhn {
        private static final zzbe zzl;
        private static volatile zzhv<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbi zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        public enum zza implements zzgf {
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
            
            private static final zzgi<zza> zzai = new zzdp();
            private final int zzaj;

            private zza(int i) {
                this.zzaj = i;
            }

            public static zzgh zzb() {
                return zzdo.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzaj;
            }
        }

        public static final class zzb extends zzgd.zza<zzbe, zzb> implements zzhn {
            private zzb() {
                super(zzbe.zzl);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzbe zzbe = new zzbe();
            zzl = zzbe;
            zzgd.zza(zzbe.class, zzbe);
        }

        private zzbe() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzl
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe$zzb
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbe
                r2.<init>()
                return r2
                switch-data {1->0x007b, 2->0x0075, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbf extends zzgd<zzbf, zza> implements zzhn {
        private static final zzbf zzf;
        private static volatile zzhv<zzbf> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public static final class zza extends zzgd.zza<zzbf, zza> implements zzhn {
            private zza() {
                super(zzbf.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
            UNKNOWN(0),
            CANONICAL(1),
            TFLITE(2),
            TFLITE_SUPPORT(3);
            
            private static final zzgi<zzb> zze = new zzdq();
            private final int zzf;

            private zzb(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzdr.zza;
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
            zzbf zzbf = new zzbf();
            zzf = zzbf;
            zzgd.zza(zzbf.class, zzbf);
        }

        private zzbf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbg extends zzgd<zzbg, zza> implements zzhn {
        private static final zzgj<Integer, zzb> zzf = new zzdt();
        private static final zzgj<Integer, zzb> zzh = new zzds();
        private static final zzgj<Integer, zzb> zzj = new zzdu();
        private static final zzbg zzl;
        private static volatile zzhv<zzbg> zzm;
        private int zzc;
        private long zzd;
        private zzgk zze = zzgd.zzk();
        private zzgk zzg = zzgd.zzk();
        private zzgk zzi = zzgd.zzk();
        private int zzk;

        public static final class zza extends zzgd.zza<zzbg, zza> implements zzhn {
            private zza() {
                super(zzbg.zzl);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
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
            
            private static final zzgi<zzb> zzm = new zzdv();
            private final int zzn;

            private zzb(int i) {
                this.zzn = i;
            }

            public static zzgh zzb() {
                return zzdw.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzn;
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzdt, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zzb>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_face.zzds, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zzb>] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_vision_face.zzdu, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zzb>] */
        static {
            zzbg zzbg = new zzbg();
            zzl = zzbg;
            zzgd.zza(zzbg.class, zzbg);
        }

        private zzbg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzl
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0073:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zza
                r2.<init>(r3)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg
                r2.<init>()
                return r2
                switch-data {1->0x0079, 2->0x0073, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbi extends zzgd<zzbi, zza> implements zzhn {
        private static final zzbi zzf;
        private static volatile zzhv<zzbi> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        public static final class zza extends zzgd.zza<zzbi, zza> implements zzhn {
            private zza() {
                super(zzbi.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzbi zzbi = new zzbi();
            zzf = zzbi;
            zzgd.zza(zzbi.class, zzbi);
        }

        private zzbi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbi
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzgd<zzc, zzb> implements zzhn {
        private static final zzc zzg;
        private static volatile zzhv<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0253zza> implements zzhn {
            private static final zzgj<Integer, zzao.zza> zzj = new zzbq();
            private static final zzgj<Integer, zzao.zzb> zzl = new zzbp();
            private static final zza zzm;
            private static volatile zzhv<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzdx.zza zzh;
            private zzgk zzi = zzgd.zzk();
            private zzgk zzk = zzgd.zzk();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza$zza  reason: collision with other inner class name */
            public static final class C0253zza extends zzgd.zza<zza, C0253zza> implements zzhn {
                private C0253zza() {
                    super(zza.zzm);
                }

                public /* synthetic */ C0253zza(zzbo zzbo) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzbq, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zza>] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzb>, com.google.android.gms.internal.mlkit_vision_face.zzbp] */
            static {
                zza zza = new zza();
                zzm = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzn
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzn     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzm     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzn = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzm
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zza.zzb()
                    r2[r3] = r4
                    r3 = 9
                    java.lang.String r4 = "zzk"
                    r2[r3] = r4
                    r3 = 10
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzao.zzb.zzb()
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e"
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zzm
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x007f:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0085:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzc, zzb> implements zzhn {
            private zzb() {
                super(zzc.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzgd.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzgd<zzd, zzb> implements zzhn {
        private static final zzd zzg;
        private static volatile zzhv<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zzb extends zzgd.zza<zzd, zzb> implements zzhn {
            private zzb() {
                super(zzd.zzg);
            }

            public final zzb zza(zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zza);
                return this;
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }

            public final zzb zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzb(i);
                return this;
            }

            public final zzb zza(zzab zzab) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zzab);
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzg = zzd2;
            zzgd.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            zza2.getClass();
            this.zzd = zza2;
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static final class zza extends zzgd<zza, C0254zza> implements zzhn {
            private static final zza zzj;
            private static volatile zzhv<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza$zza  reason: collision with other inner class name */
            public static final class C0254zza extends zzgd.zza<zza, C0254zza> implements zzhn {
                private C0254zza() {
                    super(zza.zzj);
                }

                public final C0254zza zza(zzbx zzbx) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zza(zzbx);
                    return this;
                }

                public final C0254zza zzb(int i) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zzc(i);
                    return this;
                }

                public /* synthetic */ C0254zza(zzbo zzbo) {
                    this();
                }

                public final C0254zza zza(boolean z) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zza(z);
                    return this;
                }

                public final C0254zza zza(zzae zzae) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zza(zzae);
                    return this;
                }

                public final C0254zza zza(zzac zzac) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zza(zzac);
                    return this;
                }

                public final C0254zza zza(int i) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zza) this.zza).zzb(i);
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzj = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(zzbx zzbx) {
                this.zzd = zzbx.zza();
                this.zzc |= 1;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzb(int i) {
                this.zzc |= 16;
                this.zzh = i;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzc(int i) {
                this.zzc |= 32;
                this.zzi = i;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(boolean z) {
                this.zzc |= 2;
                this.zze = z;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(zzae zzae) {
                zzae.getClass();
                this.zzf = zzae;
                this.zzc |= 4;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(zzac zzac) {
                zzac.getClass();
                this.zzg = zzac;
                this.zzc |= 8;
            }

            public static C0254zza zza() {
                return (C0254zza) zzj.zzh();
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzk     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzj     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzk = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzj
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zzj
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x006f:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x006f, 2->0x0069, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzab zzab) {
            zzab.getClass();
            this.zzf = zzab;
            this.zzc |= 4;
        }

        public static zzb zza() {
            return (zzb) zzg.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzgd<zze, zzb> implements zzhn {
        private static final zze zzg;
        private static volatile zzhv<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0255zza> implements zzhn {
            private static final zza zzh;
            private static volatile zzhv<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza$zza  reason: collision with other inner class name */
            public static final class C0255zza extends zzgd.zza<zza, C0255zza> implements zzhn {
                private C0255zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0255zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zze, zzb> implements zzhn {
            private zzb() {
                super(zze.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zzg = zze2;
            zzgd.zza(zze.class, zze2);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zze> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zze r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zze r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zze r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zze r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zze
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzgd<zzf, zzb> implements zzhn {
        private static final zzf zzg;
        private static volatile zzhv<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0256zza> implements zzhn {
            private static final zza zzi;
            private static volatile zzhv<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza$zza  reason: collision with other inner class name */
            public static final class C0256zza extends zzgd.zza<zza, C0256zza> implements zzhn {
                private C0256zza() {
                    super(zza.zzi);
                }

                public /* synthetic */ C0256zza(zzbo zzbo) {
                    this();
                }
            }

            static {
                zza zza = new zza();
                zzi = zza;
                zzgd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzj
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzj     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzi     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzj = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zzi
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0063:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzf, zzb> implements zzhn {
            private zzb() {
                super(zzf.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzg = zzf2;
            zzgd.zza(zzf.class, zzf2);
        }

        private zzf() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzgd<zzg, zzb> implements zzhn {
        private static final zzg zzg;
        private static volatile zzhv<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0257zza> implements zzhn {
            private static final zza zzh;
            private static volatile zzhv<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza$zza  reason: collision with other inner class name */
            public static final class C0257zza extends zzgd.zza<zza, C0257zza> implements zzhn {
                private C0257zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0257zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzg, zzb> implements zzhn {
            private zzb() {
                super(zzg.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzg = zzg2;
            zzgd.zza(zzg.class, zzg2);
        }

        private zzg() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzgd<zzh, zzb> implements zzhn {
        private static final zzh zzg;
        private static volatile zzhv<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0258zza> implements zzhn {
            private static final zza zzg;
            private static volatile zzhv<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza$zza  reason: collision with other inner class name */
            public static final class C0258zza extends zzgd.zza<zza, C0258zza> implements zzhn {
                private C0258zza() {
                    super(zza.zzg);
                }

                public /* synthetic */ C0258zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzh     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzg     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzh = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzg
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002"
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0059:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005f:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzh, zzb> implements zzhn {
            private zzb() {
                super(zzh.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzh zzh2 = new zzh();
            zzg = zzh2;
            zzgd.zza(zzh.class, zzh2);
        }

        private zzh() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzgd<zzi, zzb> implements zzhn {
        private static final zzi zzg;
        private static volatile zzhv<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        public static final class zza extends zzgd<zza, C0259zza> implements zzhn {
            private static final zza zzh;
            private static volatile zzhv<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza$zza  reason: collision with other inner class name */
            public static final class C0259zza extends zzgd.zza<zza, C0259zza> implements zzhn {
                private C0259zza() {
                    super(zza.zzh);
                }

                public /* synthetic */ C0259zza(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzi     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzh     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzi = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzi, zzb> implements zzhn {
            private zzb() {
                super(zzi.zzg);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzgd.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzi
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzgd<zzj, zza> implements zzhn {
        private static final zzj zze;
        private static volatile zzhv<zzj> zzf;
        private int zzc;
        private int zzd;

        public static final class zza extends zzgd.zza<zzj, zza> implements zzhn {
            private zza() {
                super(zzj.zze);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zze = zzj;
            zzgd.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zzf = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zze
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzj
                r2.<init>()
                return r2
                switch-data {1->0x0055, 2->0x004f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzgd<zzk, zza> implements zzhn {
        private static final zzk zzi;
        private static volatile zzhv<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        public static final class zza extends zzgd.zza<zzk, zza> implements zzhn {
            private zza() {
                super(zzk.zzi);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzi = zzk;
            zzgd.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzi
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzk
                r2.<init>()
                return r2
                switch-data {1->0x0062, 2->0x005c, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzgd<zzl, zza> implements zzhn {
        private static final zzgj<Integer, zzbx> zzg = new zzbr();
        private static final zzl zzi;
        private static volatile zzhv<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgk zzf = zzgd.zzk();
        private long zzh;

        public static final class zza extends zzgd.zza<zzl, zza> implements zzhn {
            private zza() {
                super(zzl.zzi);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzbr, com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbx>] */
        static {
            zzl zzl = new zzl();
            zzi = zzl;
            zzgd.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzj     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzj = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzi
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzl
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzm extends zzgd<zzm, zza> implements zzhn {
        private static final zzm zzg;
        private static volatile zzhv<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzm, zza> implements zzhn {
            private zza() {
                super(zzm.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzm zzm = new zzm();
            zzg = zzm;
            zzgd.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzm
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzn extends zzgd<zzn, zza> implements zzhn {
        private static final zzn zzf;
        private static volatile zzhv<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public static final class zza extends zzgd.zza<zzn, zza> implements zzhn {
            private zza() {
                super(zzn.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        public enum zzb implements zzgf {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzgi<zzb> zzd = new zzbs();
            private final int zze;

            private zzb(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzbt.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzn zzn = new zzn();
            zzf = zzn;
            zzgd.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzb.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzn
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzo extends zzgd<zzo, zza> implements zzhn {
        private static final zzo zzg;
        private static volatile zzhv<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzo, zza> implements zzhn {
            private zza() {
                super(zzo.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzo zzo = new zzo();
            zzg = zzo;
            zzgd.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzo
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzp extends zzgd<zzp, zza> implements zzhn {
        private static final zzp zzg;
        private static volatile zzhv<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzp, zza> implements zzhn {
            private zza() {
                super(zzp.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzp zzp = new zzp();
            zzg = zzp;
            zzgd.zza(zzp.class, zzp);
        }

        private zzp() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzp
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzq extends zzgd<zzq, zza> implements zzhn {
        private static final zzq zzg;
        private static volatile zzhv<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzq, zza> implements zzhn {
            private zza() {
                super(zzq.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzq zzq = new zzq();
            zzg = zzq;
            zzgd.zza(zzq.class, zzq);
        }

        private zzq() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzq
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzr extends zzgd<zzr, zza> implements zzhn {
        private static final zzr zzg;
        private static volatile zzhv<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzr, zza> implements zzhn {
            private zza() {
                super(zzr.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzr zzr = new zzr();
            zzg = zzr;
            zzgd.zza(zzr.class, zzr);
        }

        private zzr() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzr
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzs extends zzgd<zzs, zza> implements zzhn {
        private static final zzs zzg;
        private static volatile zzhv<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzs, zza> implements zzhn {
            private zza() {
                super(zzs.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzs zzs = new zzs();
            zzg = zzs;
            zzgd.zza(zzs.class, zzs);
        }

        private zzs() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzs
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzs.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzt extends zzgd<zzt, zza> implements zzhn {
        private static final zzt zzg;
        private static volatile zzhv<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzt, zza> implements zzhn {
            private zza() {
                super(zzt.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzt zzt = new zzt();
            zzg = zzt;
            zzgd.zza(zzt.class, zzt);
        }

        private zzt() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzt
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzu extends zzgd<zzu, zza> implements zzhn {
        private static final zzu zzg;
        private static volatile zzhv<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzu, zza> implements zzhn {
            private zza() {
                super(zzu.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzu zzu = new zzu();
            zzg = zzu;
            zzgd.zza(zzu.class, zzu);
        }

        private zzu() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzu
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzu.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzv extends zzgd<zzv, zza> implements zzhn {
        private static final zzv zzg;
        private static volatile zzhv<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzv, zza> implements zzhn {
            private zza() {
                super(zzv.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzv zzv = new zzv();
            zzg = zzv;
            zzgd.zza(zzv.class, zzv);
        }

        private zzv() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzv
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzv.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzw extends zzgd<zzw, zza> implements zzhn {
        private static final zzw zzg;
        private static volatile zzhv<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        public static final class zza extends zzgd.zza<zzw, zza> implements zzhn {
            private zza() {
                super(zzw.zzg);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzw zzw = new zzw();
            zzg = zzw;
            zzgd.zza(zzw.class, zzw);
        }

        private zzw() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzw
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzx extends zzgd<zzx, zza> implements zzhn {
        private static final zzx zzf;
        private static volatile zzhv<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        public static final class zza extends zzgd.zza<zzx, zza> implements zzhn {
            private zza() {
                super(zzx.zzf);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        static {
            zzx zzx = new zzx();
            zzf = zzx;
            zzgd.zza(zzx.class, zzx);
        }

        private zzx() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzf
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzx
                r2.<init>()
                return r2
                switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzx.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzy extends zzgd<zzy, zzb> implements zzhn {
        private static final zzy zzi;
        private static volatile zzhv<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzgm<zza> zzf = zzgd.zzl();
        private zzgm<zza> zzg = zzgd.zzl();
        private long zzh;

        public static final class zza extends zzgd<zza, zzb> implements zzhn {
            private static final zza zzf;
            private static volatile zzhv<zza> zzg;
            private int zzc;
            private int zzd;
            private zzgk zze = zzgd.zzk();

            /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza$zza  reason: collision with other inner class name */
            public enum EnumC0260zza implements zzgf {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzgi<EnumC0260zza> zzf = new zzbv();
                private final int zzg;

                private EnumC0260zza(int i) {
                    this.zzg = i;
                }

                public static zzgh zzb() {
                    return zzbu.zza;
                }

                @Override // java.lang.Enum, java.lang.Object
                public final String toString() {
                    return "<" + EnumC0260zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
                public final int zza() {
                    return this.zzg;
                }
            }

            public static final class zzb extends zzgd.zza<zza, zzb> implements zzhn {
                private zzb() {
                    super(zza.zzf);
                }

                public /* synthetic */ zzb(zzbo zzbo) {
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

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzf     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.EnumC0260zza.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016"
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                    return r2
                L_0x0054:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza$zzb
                    r2.<init>(r3)
                    return r2
                L_0x005a:
                    com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza
                    r2.<init>()
                    return r2
                    switch-data {1->0x005a, 2->0x0054, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public static final class zzb extends zzgd.zza<zzy, zzb> implements zzhn {
            private zzb() {
                super(zzy.zzi);
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }
        }

        static {
            zzy zzy = new zzy();
            zzi = zzy;
            zzgd.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza.class
                int[] r5 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzj
                if (r3 != 0) goto L_0x0031
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzj     // Catch:{ all -> 0x002e }
                if (r3 != 0) goto L_0x002c
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r3 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy r5 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzi     // Catch:{ all -> 0x002e }
                r3.<init>(r5)     // Catch:{ all -> 0x002e }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzj = r3     // Catch:{ all -> 0x002e }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzi
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy r5 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zzi
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r5, r4, r3)
                return r3
            L_0x0065:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zzb r3 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zzb
                r3.<init>(r5)
                return r3
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy r3 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy
                r3.<init>()
                return r3
                switch-data {1->0x006b, 2->0x0065, 3->0x0035, 4->0x0032, 5->0x0018, 6->0x0013, 7->0x0012, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzy.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzz extends zzgd<zzz, zza> implements zzhn {
        private static final zzgj<Integer, zzbx> zzg = new zzbw();
        private static final zzz zzj;
        private static volatile zzhv<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgk zzf = zzgd.zzk();
        private long zzh;
        private boolean zzi;

        public static final class zza extends zzgd.zza<zzz, zza> implements zzhn {
            private zza() {
                super(zzz.zzj);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzbx>, com.google.android.gms.internal.mlkit_vision_face.zzbw] */
        static {
            zzz zzz = new zzz();
            zzj = zzz;
            zzgd.zza(zzz.class, zzz);
        }

        private zzz() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz
                r2.<init>()
                return r2
                switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzac extends zzgd<zzac, zzb> implements zzhn {
        private static final zzac zzj;
        private static volatile zzhv<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        public enum zza implements zzgf {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzgi<zza> zzd = new zzce();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcd.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public static final class zzb extends zzgd.zza<zzac, zzb> implements zzhn {
            private zzb() {
                super(zzac.zzj);
            }

            public final zzb zza(zzd zzd) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(zzd);
                return this;
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }

            public final zzb zza(zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(zza);
                return this;
            }

            public final zzb zza(zze zze) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(zze);
                return this;
            }

            public final zzb zza(zzc zzc) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(zzc);
                return this;
            }

            public final zzb zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(z);
                return this;
            }

            public final zzb zza(float f) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzac) this.zza).zza(f);
                return this;
            }
        }

        public enum zzc implements zzgf {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzgi<zzc> zzd = new zzcf();
            private final int zze;

            private zzc(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcg.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzd implements zzgf {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzgi<zzd> zzd = new zzci();
            private final int zze;

            private zzd(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzch.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public enum zze implements zzgf {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzgi<zze> zzd = new zzcj();
            private final int zze;

            private zze(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzck.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzac = new zzac();
            zzj = zzac;
            zzgd.zza(zzac.class, zzac);
        }

        private zzac() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd2) {
            this.zzd = zzd2.zza();
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            this.zze = zza2.zza();
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zze zze2) {
            this.zzf = zze2.zza();
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzc zzc2) {
            this.zzg = zzc2.zza();
            this.zzc |= 8;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(float f) {
            this.zzc |= 32;
            this.zzi = f;
        }

        public static zzb zza() {
            return (zzb) zzj.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zze.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzc.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzb
                r2.<init>(r3)
                return r2
            L_0x0087:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac
                r2.<init>()
                return r2
                switch-data {1->0x0087, 2->0x0081, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzac.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzae extends zzgd<zzae, zzb> implements zzhn {
        private static final zzae zzg;
        private static volatile zzhv<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        public enum zza implements zzgf {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzgi<zza> zzj = new zzcm();
            private final int zzk;

            private zza(int i) {
                this.zzk = i;
            }

            public static zzgh zzb() {
                return zzcl.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzk;
            }
        }

        public static final class zzb extends zzgd.zza<zzae, zzb> implements zzhn {
            private zzb() {
                super(zzae.zzg);
            }

            public final zzb zza(zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zza(zza);
                return this;
            }

            public /* synthetic */ zzb(zzbo zzbo) {
                this();
            }

            public final zzb zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zzb(i);
                return this;
            }
        }

        static {
            zzae zzae = new zzae();
            zzg = zzae;
            zzgd.zza(zzae.class, zzae);
        }

        private zzae() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            this.zzd = zza2.zza();
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zzb zza() {
            return (zzb) zzg.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzh     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzh = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzg
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzae.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzaf extends zzgd<zzaf, zza> implements zzhn {
        private static final zzaf zzl;
        private static volatile zzhv<zzaf> zzm;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;
        private zzgm<zzbf> zzk = zzgd.zzl();

        public static final class zza extends zzgd.zza<zzaf, zza> implements zzhn {
            private zza() {
                super(zzaf.zzl);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(j);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzb(true);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzc(true);
                return this;
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }

            public final zza zza(zzbx zzbx) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(zzbx);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(z);
                return this;
            }
        }

        static {
            zzaf zzaf = new zzaf();
            zzl = zzaf;
            zzgd.zza(zzaf.class, zzaf);
        }

        private zzaf() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(boolean z) {
            this.zzc |= 8;
            this.zzg = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(boolean z) {
            this.zzc |= 16;
            this.zzh = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzbx zzbx) {
            this.zze = zzbx.zza();
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        public static zza zza() {
            return (zza) zzl.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzm     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzm = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzl
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbx.zzb()
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf> r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006\b\u001b"
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf$zza
                r2.<init>(r3)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf
                r2.<init>()
                return r2
                switch-data {1->0x0081, 2->0x007b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzaf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzad extends zzgd.zze<zzad, zza> implements zzhn {
        private static final zzad zzbd;
        private static volatile zzhv<zzad> zzbe;
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
        private zzgm<zzjp.zzf> zzay = zzgd.zzl();
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
            zzgd.zza(zzad.class, zzad2);
        }

        private zzad() {
        }

        public static zza zza(zzad zzad2) {
            return (zza) zzbd.zza(zzad2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzap zzap2) {
            zzap2.getClass();
            this.zzm = zzap2;
            this.zzd |= 128;
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
        private final void zza(zzd zzd2) {
            zzd2.getClass();
            this.zzar = zzd2;
            this.zze |= 64;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzcb zzcb) {
            this.zzg = zzcb.zza();
            this.zzd |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzd |= 4;
            this.zzh = z;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbh zza() {
            zzbh zzbh = this.zzf;
            return zzbh == null ? zzbh.zzc() : zzbh;
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
            // Method dump skipped, instructions count: 414
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzad.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public static final class zza extends zzgd.zzb<zzad, zza> implements zzhn {
            private zza() {
                super(zzad.zzbd);
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }

            public final zza zza(zzbh.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbh) ((zzgd) zza.zzh()));
                return this;
            }

            public final zzbh zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzcb zzcb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzcb);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzap zzap) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzap);
                return this;
            }

            public final zza zza(zzd.zzb zzb) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzd) ((zzgd) zzb.zzh()));
                return this;
            }
        }
    }

    public static final class zzap extends zzgd<zzap, zza> implements zzhn {
        private static final zzap zzj;
        private static volatile zzhv<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzdx.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        public static final class zza extends zzgd.zza<zzap, zza> implements zzhn {
            private zza() {
                super(zzap.zzj);
            }

            public final zza zza(zzaf.zza zza) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzap) this.zza).zza((zzaf) ((zzgd) zza.zzh()));
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzap) this.zza).zzc(i);
                return this;
            }

            public /* synthetic */ zza(zzbo zzbo) {
                this();
            }

            public final zza zza(zzae zzae) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzap) this.zza).zza(zzae);
                return this;
            }

            public final zza zza(zzac zzac) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzap) this.zza).zza(zzac);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzap) this.zza).zzb(i);
                return this;
            }
        }

        static {
            zzap zzap = new zzap();
            zzj = zzap;
            zzgd.zza(zzap.class, zzap);
        }

        private zzap() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzaf zzaf) {
            zzaf.getClass();
            this.zzd = zzaf;
            this.zzc |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            this.zzc |= 16;
            this.zzh = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(int i) {
            this.zzc |= 32;
            this.zzi = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzae zzae) {
            zzae.getClass();
            this.zzf = zzae;
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzac zzac) {
            zzac.getClass();
            this.zzg = zzac;
            this.zzc |= 8;
        }

        public static zza zza() {
            return (zza) zzj.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap>, com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzk = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzap.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzbh extends zzgd<zzbh, zza> implements zzhn {
        private static final zzbh zzo;
        private static volatile zzhv<zzbh> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzgm<String> zzk = zzgd.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        public static final class zza extends zzgd.zza<zzbh, zza> implements zzhn {
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

            public /* synthetic */ zza(zzbo zzbo) {
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
            zzgd.zza(zzbh.class, zzbh);
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
            zzgm<String> zzgm = this.zzk;
            if (!zzgm.zza()) {
                int size = zzgm.size();
                this.zzk = zzgm.zzb(size == 0 ? 10 : size << 1);
            }
            zzeu.zza(iterable, this.zzk);
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

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzbo.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzp
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh> r3 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzp     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzo     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzp = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh r2 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzo
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
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh r4 = com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zzo
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh$zza
                r2.<init>(r3)
                return r2
            L_0x0085:
                com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh r2 = new com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbh
                r2.<init>()
                return r2
                switch-data {1->0x0085, 2->0x007f, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzbm.zzbh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
