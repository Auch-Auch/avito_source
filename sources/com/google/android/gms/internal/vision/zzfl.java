package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import kotlin.text.Typography;
public final class zzfl {

    public static final class zza extends zzid<zza, C0270zza> implements zzjp {
        private static volatile zzjw<zza> zzbk;
        private static final zza zzof;
        private int zzbm;
        private String zzod = "";
        private String zzoe = "";

        /* renamed from: com.google.android.gms.internal.vision.zzfl$zza$zza  reason: collision with other inner class name */
        public static final class C0270zza extends zzid.zza<zza, C0270zza> implements zzjp {
            private C0270zza() {
                super(zza.zzof);
            }

            public final C0270zza zzm(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zza) this.zzxx).zzo(str);
                return this;
            }

            public final C0270zza zzn(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zza) this.zzxx).zzp(str);
                return this;
            }

            public /* synthetic */ C0270zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzof = zza;
            zzid.zza(zza.class, zza);
        }

        private zza() {
        }

        public static C0270zza zzdd() {
            return (C0270zza) zzof.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zzod = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(String str) {
            str.getClass();
            this.zzbm |= 2;
            this.zzoe = str;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zza>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zza> r2 = com.google.android.gms.internal.vision.zzfl.zza.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zza> r3 = com.google.android.gms.internal.vision.zzfl.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zza> r2 = com.google.android.gms.internal.vision.zzfl.zza.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zza r4 = com.google.android.gms.internal.vision.zzfl.zza.zzof     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zza.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zza r2 = com.google.android.gms.internal.vision.zzfl.zza.zzof
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzod"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzoe"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001"
                com.google.android.gms.internal.vision.zzfl$zza r4 = com.google.android.gms.internal.vision.zzfl.zza.zzof
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.vision.zzfl$zza$zza r2 = new com.google.android.gms.internal.vision.zzfl$zza$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.vision.zzfl$zza r2 = new com.google.android.gms.internal.vision.zzfl$zza
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzid<zzb, zza> implements zzjp {
        private static volatile zzjw<zzb> zzbk;
        private static final zzil<Integer, zzfz> zzoh = new zzfm();
        private static final zzb zzoi;
        private zzii zzog = zzid.zzha();

        public static final class zza extends zzid.zza<zzb, zza> implements zzjp {
            private zza() {
                super(zzb.zzoi);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzfm, com.google.android.gms.internal.vision.zzil<java.lang.Integer, com.google.android.gms.internal.vision.zzfz>] */
        static {
            zzb zzb = new zzb();
            zzoi = zzb;
            zzid.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0050;
                    case 2: goto L_0x004a;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzb> r2 = com.google.android.gms.internal.vision.zzfl.zzb.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzb> r3 = com.google.android.gms.internal.vision.zzfl.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzb> r2 = com.google.android.gms.internal.vision.zzfl.zzb.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzb r4 = com.google.android.gms.internal.vision.zzfl.zzb.zzoi     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzb.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzb r2 = com.google.android.gms.internal.vision.zzfl.zzb.zzoi
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzog"
                r2[r3] = r0
                com.google.android.gms.internal.vision.zzij r3 = com.google.android.gms.internal.vision.zzfz.zzal()
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e"
                com.google.android.gms.internal.vision.zzfl$zzb r4 = com.google.android.gms.internal.vision.zzfl.zzb.zzoi
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004a:
                com.google.android.gms.internal.vision.zzfl$zzb$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x0050:
                com.google.android.gms.internal.vision.zzfl$zzb r2 = new com.google.android.gms.internal.vision.zzfl$zzb
                r2.<init>()
                return r2
                switch-data {1->0x0050, 2->0x004a, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzc extends zzid<zzc, zza> implements zzjp {
        private static volatile zzjw<zzc> zzbk;
        private static final zzc zzom;
        private int zzbm;
        private int zzoj;
        private int zzok;
        private String zzol = "";

        public static final class zza extends zzid.zza<zzc, zza> implements zzjp {
            private zza() {
                super(zzc.zzom);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzom = zzc;
            zzid.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzc>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0066;
                    case 2: goto L_0x0060;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzc> r2 = com.google.android.gms.internal.vision.zzfl.zzc.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzc> r3 = com.google.android.gms.internal.vision.zzfl.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzc> r2 = com.google.android.gms.internal.vision.zzfl.zzc.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzc r4 = com.google.android.gms.internal.vision.zzfl.zzc.zzom     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzc.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzc r2 = com.google.android.gms.internal.vision.zzfl.zzc.zzom
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzoj"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfz.zzal()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzok"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzgd.zzal()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzol"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002"
                com.google.android.gms.internal.vision.zzfl$zzc r4 = com.google.android.gms.internal.vision.zzfl.zzc.zzom
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0060:
                com.google.android.gms.internal.vision.zzfl$zzc$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzc$zza
                r2.<init>(r3)
                return r2
            L_0x0066:
                com.google.android.gms.internal.vision.zzfl$zzc r2 = new com.google.android.gms.internal.vision.zzfl$zzc
                r2.<init>()
                return r2
                switch-data {1->0x0066, 2->0x0060, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzid<zze, zzb> implements zzjp {
        private static volatile zzjw<zze> zzbk;
        private static final zze zzox;
        private int zzbm;
        private String zzop = "";
        private boolean zzoq;
        private int zzor;
        private long zzos;
        private long zzot;
        private long zzou;
        private String zzov = "";
        private boolean zzow;

        public enum zza implements zzih {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);
            
            private static final zzig<zza> zzhq = new zzfo();
            private final int value;

            private zza(int i) {
                this.value = i;
            }

            public static zzij zzal() {
                return zzfn.zzht;
            }

            public static zza zzz(int i) {
                if (i == 0) {
                    return REASON_UNKNOWN;
                }
                if (i == 1) {
                    return REASON_MISSING;
                }
                if (i == 2) {
                    return REASON_UPGRADE;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        public static final class zzb extends zzid.zza<zze, zzb> implements zzjp {
            private zzb() {
                super(zze.zzox);
            }

            public /* synthetic */ zzb(zzfk zzfk) {
                this();
            }
        }

        static {
            zze zze = new zze();
            zzox = zze;
            zzid.zza(zze.class, zze);
        }

        private zze() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zze>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zze> r2 = com.google.android.gms.internal.vision.zzfl.zze.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zze> r3 = com.google.android.gms.internal.vision.zzfl.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zze> r2 = com.google.android.gms.internal.vision.zzfl.zze.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zze r4 = com.google.android.gms.internal.vision.zzfl.zze.zzox     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zze.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zze r2 = com.google.android.gms.internal.vision.zzfl.zze.zzox
                return r2
            L_0x0033:
                r2 = 10
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzop"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzoq"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzor"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zze.zza.zzal()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzos"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzot"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzou"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzov"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzow"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007"
                com.google.android.gms.internal.vision.zzfl$zze r4 = com.google.android.gms.internal.vision.zzfl.zze.zzox
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.vision.zzfl$zze$zzb r2 = new com.google.android.gms.internal.vision.zzfl$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.vision.zzfl$zze r2 = new com.google.android.gms.internal.vision.zzfl$zze
                r2.<init>()
                return r2
                switch-data {1->0x007b, 2->0x0075, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzid<zzf, zza> implements zzjp {
        private static volatile zzjw<zzf> zzbk;
        private static final zzf zzpl;
        private int zzbm;
        private String zzpd = "";
        private String zzpe = "";
        private zzik<String> zzpf = zzid.zzhb();
        private int zzpg;
        private String zzph = "";
        private long zzpi;
        private long zzpj;
        private zzik<zzn> zzpk = zzid.zzhb();

        public static final class zza extends zzid.zza<zzf, zza> implements zzjp {
            private zza() {
                super(zzf.zzpl);
            }

            public final zza zzc(Iterable<? extends zzn> iterable) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzd(iterable);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzf(j);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzg(j);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).setName(str);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        public enum zzb implements zzih {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);
            
            private static final zzig<zzb> zzhq = new zzfp();
            private final int value;

            private zzb(int i) {
                this.value = i;
            }

            public static zzb zzaa(int i) {
                if (i == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i == 1) {
                    return RESULT_SUCCESS;
                }
                if (i == 2) {
                    return RESULT_FAIL;
                }
                if (i != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public static zzij zzal() {
                return zzfq.zzht;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        static {
            zzf zzf = new zzf();
            zzpl = zzf;
            zzid.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setName(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zzpd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(Iterable<? extends zzn> iterable) {
            zzik<zzn> zzik = this.zzpk;
            if (!zzik.zzei()) {
                this.zzpk = zzid.zza(zzik);
            }
            zzge.zza(iterable, this.zzpk);
        }

        public static zza zzdk() {
            return (zza) zzpl.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(long j) {
            this.zzbm |= 16;
            this.zzpi = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(long j) {
            this.zzbm |= 32;
            this.zzpj = j;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzf>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzf> r2 = com.google.android.gms.internal.vision.zzfl.zzf.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzf> r3 = com.google.android.gms.internal.vision.zzfl.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzf> r2 = com.google.android.gms.internal.vision.zzfl.zzf.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzf r4 = com.google.android.gms.internal.vision.zzfl.zzf.zzpl     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzf.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzf r2 = com.google.android.gms.internal.vision.zzfl.zzf.zzpl
                return r2
            L_0x0033:
                r2 = 11
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzpd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzpe"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzpf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzpg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zzf.zzb.zzal()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzph"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzpi"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzpj"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzpk"
                r2[r3] = r4
                r3 = 10
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzn> r4 = com.google.android.gms.internal.vision.zzfl.zzn.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b"
                com.google.android.gms.internal.vision.zzfl$zzf r4 = com.google.android.gms.internal.vision.zzfl.zzf.zzpl
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x007b:
                com.google.android.gms.internal.vision.zzfl$zzf$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzf$zza
                r2.<init>(r3)
                return r2
            L_0x0081:
                com.google.android.gms.internal.vision.zzfl$zzf r2 = new com.google.android.gms.internal.vision.zzfl$zzf
                r2.<init>()
                return r2
                switch-data {1->0x0081, 2->0x007b, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzh extends zzid<zzh, zza> implements zzjp {
        private static volatile zzjw<zzh> zzbk;
        private static final zzh zzqq;
        private int zzbm;
        private float zzqk;
        private float zzql;
        private float zzqm;
        private float zzqn;
        private float zzqo;
        private float zzqp;

        public static final class zza extends zzid.zza<zzh, zza> implements zzjp {
            private zza() {
                super(zzh.zzqq);
            }

            public final zza zzg(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzm(f);
                return this;
            }

            public final zza zzh(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzn(f);
                return this;
            }

            public final zza zzi(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzo(f);
                return this;
            }

            public final zza zzj(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzp(f);
                return this;
            }

            public final zza zzk(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzq(f);
                return this;
            }

            public final zza zzl(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzh) this.zzxx).zzr(f);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzqq = zzh;
            zzid.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        public static zza zzdo() {
            return (zza) zzqq.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm(float f) {
            this.zzbm |= 1;
            this.zzqk = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzn(float f) {
            this.zzbm |= 2;
            this.zzql = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(float f) {
            this.zzbm |= 4;
            this.zzqm = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(float f) {
            this.zzbm |= 8;
            this.zzqn = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzq(float f) {
            this.zzbm |= 16;
            this.zzqo = f;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzr(float f) {
            this.zzbm |= 32;
            this.zzqp = f;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzh>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzh> r2 = com.google.android.gms.internal.vision.zzfl.zzh.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzh> r3 = com.google.android.gms.internal.vision.zzfl.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzh> r2 = com.google.android.gms.internal.vision.zzfl.zzh.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzh r4 = com.google.android.gms.internal.vision.zzfl.zzh.zzqq     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzh.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzh r2 = com.google.android.gms.internal.vision.zzfl.zzh.zzqq
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzqk"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzql"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzqm"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzqn"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzqo"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzqp"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.vision.zzfl$zzh r4 = com.google.android.gms.internal.vision.zzfl.zzh.zzqq
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.vision.zzfl$zzh$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.vision.zzfl$zzh r2 = new com.google.android.gms.internal.vision.zzfl$zzh
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzj extends zzid<zzj, zza> implements zzjp {
        private static volatile zzjw<zzj> zzbk;
        private static final zzj zzqz;
        private int zzbm;
        private int zzoj;
        private long zzqv;
        private long zzqw;
        private long zzqx;
        private long zzqy;

        public static final class zza extends zzid.zza<zzj, zza> implements zzjp {
            private zza() {
                super(zzj.zzqz);
            }

            public final zza zzh(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzj) this.zzxx).zzl(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzj) this.zzxx).zzm(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzj) this.zzxx).zzn(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzj) this.zzxx).zzo(j);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        public enum zzb implements zzih {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);
            
            private static final zzig<zzb> zzhq = new zzfx();
            private final int value;

            private zzb(int i) {
                this.value = i;
            }

            public static zzb zzae(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i == 2) {
                    return FORMAT_RGB8;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public static zzij zzal() {
                return zzfy.zzht;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        static {
            zzj zzj = new zzj();
            zzqz = zzj;
            zzid.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        public static zza zzdt() {
            return (zza) zzqz.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzl(long j) {
            this.zzbm |= 2;
            this.zzqv = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm(long j) {
            this.zzbm |= 4;
            this.zzqw = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzn(long j) {
            this.zzbm |= 8;
            this.zzqx = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(long j) {
            this.zzbm |= 16;
            this.zzqy = j;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzj>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzj> r2 = com.google.android.gms.internal.vision.zzfl.zzj.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzj> r3 = com.google.android.gms.internal.vision.zzfl.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzj> r2 = com.google.android.gms.internal.vision.zzfl.zzj.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzj r4 = com.google.android.gms.internal.vision.zzfl.zzj.zzqz     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzj.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzj r2 = com.google.android.gms.internal.vision.zzfl.zzj.zzqz
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzoj"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zzj.zzb.zzal()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzqv"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzqw"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzqy"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzqx"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003"
                com.google.android.gms.internal.vision.zzfl$zzj r4 = com.google.android.gms.internal.vision.zzfl.zzj.zzqz
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.vision.zzfl$zzj$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.vision.zzfl$zzj r2 = new com.google.android.gms.internal.vision.zzfl$zzj
                r2.<init>()
                return r2
                switch-data {1->0x0069, 2->0x0063, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzl extends zzid<zzl, zza> implements zzjp {
        private static volatile zzjw<zzl> zzbk;
        private static final zzl zzrk;
        private int zzbm;
        private long zzpi;
        private long zzpj;

        public static final class zza extends zzid.zza<zzl, zza> implements zzjp {
            private zza() {
                super(zzl.zzrk);
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzrk = zzl;
            zzid.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzl>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzl> r2 = com.google.android.gms.internal.vision.zzfl.zzl.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzl> r3 = com.google.android.gms.internal.vision.zzfl.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzl> r2 = com.google.android.gms.internal.vision.zzfl.zzl.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzl r4 = com.google.android.gms.internal.vision.zzfl.zzl.zzrk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzl.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzl r2 = com.google.android.gms.internal.vision.zzfl.zzl.zzrk
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzpi"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzpj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001"
                com.google.android.gms.internal.vision.zzfl$zzl r4 = com.google.android.gms.internal.vision.zzfl.zzl.zzrk
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.vision.zzfl$zzl$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.vision.zzfl$zzl r2 = new com.google.android.gms.internal.vision.zzfl$zzl
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzm extends zzid<zzm, zza> implements zzjp {
        private static volatile zzjw<zzm> zzbk;
        private static final zzm zzrn;
        private int zzbm;
        private int zzrl;
        private int zzrm;

        public static final class zza extends zzid.zza<zzm, zza> implements zzjp {
            private zza() {
                super(zzm.zzrn);
            }

            public final zza zzaf(int i) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzm) this.zzxx).setX(i);
                return this;
            }

            public final zza zzag(int i) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzm) this.zzxx).setY(i);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzm zzm = new zzm();
            zzrn = zzm;
            zzid.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setX(int i) {
            this.zzbm |= 1;
            this.zzrl = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setY(int i) {
            this.zzbm |= 2;
            this.zzrm = i;
        }

        public static zza zzdy() {
            return (zza) zzrn.zzgy();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzm>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzm> r2 = com.google.android.gms.internal.vision.zzfl.zzm.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzm> r3 = com.google.android.gms.internal.vision.zzfl.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzm> r2 = com.google.android.gms.internal.vision.zzfl.zzm.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzm r4 = com.google.android.gms.internal.vision.zzfl.zzm.zzrn     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzm.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzm r2 = com.google.android.gms.internal.vision.zzfl.zzm.zzrn
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzrl"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzrm"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001"
                com.google.android.gms.internal.vision.zzfl$zzm r4 = com.google.android.gms.internal.vision.zzfl.zzm.zzrn
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.vision.zzfl$zzm$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.vision.zzfl$zzm r2 = new com.google.android.gms.internal.vision.zzfl$zzm
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzid<zzg, zzb> implements zzjp {
        private static volatile zzjw<zzg> zzbk;
        private static final zzg zzpv;
        private int zzbm;
        private float zzkp;
        private boolean zzkt;
        private int zzpr;
        private int zzps;
        private int zzpt;
        private boolean zzpu;

        public enum zza implements zzih {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzig<zza> zzhq = new zzfs();
            private final int value;

            private zza(int i) {
                this.value = i;
            }

            public static zza zzab(int i) {
                if (i == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public static zzij zzal() {
                return zzfr.zzht;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        public static final class zzb extends zzid.zza<zzg, zzb> implements zzjp {
            private zzb() {
                super(zzg.zzpv);
            }

            public final zzb zzb(zzd zzd) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zza(zzd);
                return this;
            }

            public final zzb zzf(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zzd(f);
                return this;
            }

            public final zzb zzh(boolean z) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zza(z);
                return this;
            }

            public final zzb zzi(boolean z) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zzg(z);
                return this;
            }

            public /* synthetic */ zzb(zzfk zzfk) {
                this();
            }

            public final zzb zzb(zzc zzc) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zza(zzc);
                return this;
            }

            public final zzb zzb(zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zza(zza);
                return this;
            }
        }

        public enum zzc implements zzih {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzig<zzc> zzhq = new zzft();
            private final int value;

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzac(int i) {
                if (i == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 1) {
                    return LANDMARK_NONE;
                }
                if (i == 2) {
                    return LANDMARK_ALL;
                }
                if (i != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public static zzij zzal() {
                return zzfu.zzht;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        public enum zzd implements zzih {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzig<zzd> zzhq = new zzfw();
            private final int value;

            private zzd(int i) {
                this.value = i;
            }

            public static zzd zzad(int i) {
                if (i == 0) {
                    return MODE_UNKNOWN;
                }
                if (i == 1) {
                    return MODE_ACCURATE;
                }
                if (i == 2) {
                    return MODE_FAST;
                }
                if (i != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public static zzij zzal() {
                return zzfv.zzht;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        static {
            zzg zzg = new zzg();
            zzpv = zzg;
            zzid.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd2) {
            this.zzpr = zzd2.zzak();
            this.zzbm |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(float f) {
            this.zzbm |= 32;
            this.zzkp = f;
        }

        public static zzb zzdm() {
            return (zzb) zzpv.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(boolean z) {
            this.zzbm |= 16;
            this.zzpu = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzc zzc2) {
            this.zzps = zzc2.zzak();
            this.zzbm |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            this.zzpt = zza2.zzak();
            this.zzbm |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzbm |= 8;
            this.zzkt = z;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzg>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzg> r2 = com.google.android.gms.internal.vision.zzfl.zzg.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzg> r3 = com.google.android.gms.internal.vision.zzfl.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzg> r2 = com.google.android.gms.internal.vision.zzfl.zzg.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzg r4 = com.google.android.gms.internal.vision.zzfl.zzg.zzpv     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzg.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzg r2 = com.google.android.gms.internal.vision.zzfl.zzg.zzpv
                return r2
            L_0x0033:
                r2 = 10
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzpr"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zzg.zzd.zzal()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzps"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zzg.zzc.zzal()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzpt"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzfl.zzg.zza.zzal()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzkt"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzpu"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzkp"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.vision.zzfl$zzg r4 = com.google.android.gms.internal.vision.zzfl.zzg.zzpv
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.vision.zzfl$zzg$zzb r2 = new com.google.android.gms.internal.vision.zzfl$zzg$zzb
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.vision.zzfl$zzg r2 = new com.google.android.gms.internal.vision.zzfl$zzg
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzi extends zzid<zzi, zza> implements zzjp {
        private static volatile zzjw<zzi> zzbk;
        private static final zzi zzqu;
        private int zzbm;
        private zzj zzqr;
        private zzl zzqs;
        private zzik<zzf> zzqt = zzid.zzhb();

        public static final class zza extends zzid.zza<zzi, zza> implements zzjp {
            private zza() {
                super(zzi.zzqu);
            }

            public final zza zza(zzj zzj) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzi) this.zzxx).zzb(zzj);
                return this;
            }

            public final zza zze(Iterable<? extends zzf> iterable) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzi) this.zzxx).zzf(iterable);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }

            public final zza zza(zzf.zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzi) this.zzxx).zza((zzf) ((zzid) zza.zzgw()));
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzqu = zzi;
            zzid.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzf zzf) {
            zzf.getClass();
            zzdq();
            this.zzqt.add(zzf);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzj zzj) {
            zzj.getClass();
            this.zzqr = zzj;
            this.zzbm |= 1;
        }

        private final void zzdq() {
            zzik<zzf> zzik = this.zzqt;
            if (!zzik.zzei()) {
                this.zzqt = zzid.zza(zzik);
            }
        }

        public static zza zzdr() {
            return (zza) zzqu.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(Iterable<? extends zzf> iterable) {
            zzdq();
            zzge.zza(iterable, this.zzqt);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzi>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzi> r2 = com.google.android.gms.internal.vision.zzfl.zzi.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzi> r3 = com.google.android.gms.internal.vision.zzfl.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzi> r2 = com.google.android.gms.internal.vision.zzfl.zzi.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzi r4 = com.google.android.gms.internal.vision.zzfl.zzi.zzqu     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzi.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzi r2 = com.google.android.gms.internal.vision.zzfl.zzi.zzqu
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzqr"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzqs"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzqt"
                r2[r3] = r4
                r3 = 4
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzf> r4 = com.google.android.gms.internal.vision.zzfl.zzf.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b"
                com.google.android.gms.internal.vision.zzfl$zzi r4 = com.google.android.gms.internal.vision.zzfl.zzi.zzqu
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzfl$zzi$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzi$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzfl$zzi r2 = new com.google.android.gms.internal.vision.zzfl$zzi
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzk extends zzid<zzk, zza> implements zzjp {
        private static volatile zzjw<zzk> zzbk;
        private static final zzk zzrj;
        private int zzbm;
        private String zzov = "";
        private String zzpd = "";
        private long zzrf;
        private zza zzrg;
        private zzg zzrh;
        private zzb zzri;

        public static final class zza extends zzid.zza<zzk, zza> implements zzjp {
            private zza() {
                super(zzk.zzrj);
            }

            public final zza zza(zzg.zzb zzb) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzk) this.zzxx).zza((zzg) ((zzid) zzb.zzgw()));
                return this;
            }

            public final zza zzb(zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzk) this.zzxx).zza(zza);
                return this;
            }

            public final zza zzq(long j) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzk) this.zzxx).zzp(j);
                return this;
            }

            public final zza zzs(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzk) this.zzxx).setName(str);
                return this;
            }

            public final zza zzt(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzk) this.zzxx).zzr(str);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzrj = zzk;
            zzid.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setName(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zzpd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            zza2.getClass();
            this.zzrg = zza2;
            this.zzbm |= 4;
        }

        public static zza zzdv() {
            return (zza) zzrj.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(long j) {
            this.zzbm |= 2;
            this.zzrf = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzr(String str) {
            str.getClass();
            this.zzbm |= 8;
            this.zzov = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzg zzg) {
            zzg.getClass();
            this.zzrh = zzg;
            this.zzbm |= 16;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzk>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzk> r2 = com.google.android.gms.internal.vision.zzfl.zzk.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzk> r3 = com.google.android.gms.internal.vision.zzfl.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzk> r2 = com.google.android.gms.internal.vision.zzfl.zzk.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzk r4 = com.google.android.gms.internal.vision.zzfl.zzk.zzrj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzk.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzk r2 = com.google.android.gms.internal.vision.zzfl.zzk.zzrj
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzpd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzrf"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzrg"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzov"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzrh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzri"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005"
                com.google.android.gms.internal.vision.zzfl$zzk r4 = com.google.android.gms.internal.vision.zzfl.zzk.zzrj
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.vision.zzfl$zzk$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.vision.zzfl$zzk r2 = new com.google.android.gms.internal.vision.zzfl$zzk
                r2.<init>()
                return r2
                switch-data {1->0x0067, 2->0x0061, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzn extends zzid<zzn, zza> implements zzjp {
        private static volatile zzjw<zzn> zzbk;
        private static final zzn zzrs;
        private int zzbm;
        private zzd zzro;
        private int zzrp;
        private zzh zzrq;
        private zzc zzrr;

        public static final class zza extends zzid.zza<zzn, zza> implements zzjp {
            private zza() {
                super(zzn.zzrs);
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzn) this.zzxx).zza((zzd) ((zzid) zza.zzgw()));
                return this;
            }

            public final zza zzah(int i) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzn) this.zzxx).setId(i);
                return this;
            }

            public final zza zzb(zzh zzh) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzn) this.zzxx).zza(zzh);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzn zzn = new zzn();
            zzrs = zzn;
            zzid.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setId(int i) {
            this.zzbm |= 2;
            this.zzrp = i;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd) {
            zzd.getClass();
            this.zzro = zzd;
            this.zzbm |= 1;
        }

        public static zza zzea() {
            return (zza) zzrs.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzh zzh) {
            zzh.getClass();
            this.zzrq = zzh;
            this.zzbm |= 4;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzn>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzn> r2 = com.google.android.gms.internal.vision.zzfl.zzn.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzn> r3 = com.google.android.gms.internal.vision.zzfl.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzn> r2 = com.google.android.gms.internal.vision.zzfl.zzn.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzn r4 = com.google.android.gms.internal.vision.zzfl.zzn.zzrs     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzn.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzn r2 = com.google.android.gms.internal.vision.zzfl.zzn.zzrs
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzro"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzrp"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzrq"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzrr"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003"
                com.google.android.gms.internal.vision.zzfl$zzn r4 = com.google.android.gms.internal.vision.zzfl.zzn.zzrs
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzfl$zzn$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzn$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzfl$zzn r2 = new com.google.android.gms.internal.vision.zzfl$zzn
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzo extends zzid<zzo, zza> implements zzjp {
        private static volatile zzjw<zzo> zzbk;
        private static final zzo zzrx;
        private int zzbm;
        private zze zzrt;
        private zzk zzru;
        private zzi zzrv;
        private int zzrw;

        public static final class zza extends zzid.zza<zzo, zza> implements zzjp {
            private zza() {
                super(zzo.zzrx);
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzo) this.zzxx).zza((zzk) ((zzid) zza.zzgw()));
                return this;
            }

            public final zza zzb(zzi zzi) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzo) this.zzxx).zza(zzi);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzo zzo = new zzo();
            zzrx = zzo;
            zzid.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzk zzk) {
            zzk.getClass();
            this.zzru = zzk;
            this.zzbm |= 2;
        }

        public static zza zzec() {
            return (zza) zzrx.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzi zzi) {
            zzi.getClass();
            this.zzrv = zzi;
            this.zzbm |= 4;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzo>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzo> r2 = com.google.android.gms.internal.vision.zzfl.zzo.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzo> r3 = com.google.android.gms.internal.vision.zzfl.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzo> r2 = com.google.android.gms.internal.vision.zzfl.zzo.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzo r4 = com.google.android.gms.internal.vision.zzfl.zzo.zzrx     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzo.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzo r2 = com.google.android.gms.internal.vision.zzfl.zzo.zzrx
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzrt"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzru"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzrv"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzrw"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003"
                com.google.android.gms.internal.vision.zzfl$zzo r4 = com.google.android.gms.internal.vision.zzfl.zzo.zzrx
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzfl$zzo$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzfl$zzo r2 = new com.google.android.gms.internal.vision.zzfl$zzo
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzid<zzd, zza> implements zzjp {
        private static volatile zzjw<zzd> zzbk;
        private static final zzd zzoo;
        private zzik<zzm> zzon = zzid.zzhb();

        public static final class zza extends zzid.zza<zzd, zza> implements zzjp {
            private zza() {
                super(zzd.zzoo);
            }

            public final zza zzb(zzm zzm) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza(zzm);
                return this;
            }

            public /* synthetic */ zza(zzfk zzfk) {
                this();
            }
        }

        static {
            zzd zzd = new zzd();
            zzoo = zzd;
            zzid.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzm zzm) {
            zzm.getClass();
            zzik<zzm> zzik = this.zzon;
            if (!zzik.zzei()) {
                this.zzon = zzid.zza(zzik);
            }
            this.zzon.add(zzm);
        }

        public static zza zzdh() {
            return (zza) zzoo.zzgy();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzd>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzfk.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzd> r2 = com.google.android.gms.internal.vision.zzfl.zzd.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzd> r3 = com.google.android.gms.internal.vision.zzfl.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzfl$zzd> r2 = com.google.android.gms.internal.vision.zzfl.zzd.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl$zzd r4 = com.google.android.gms.internal.vision.zzfl.zzd.zzoo     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzfl.zzd.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzfl$zzd r2 = com.google.android.gms.internal.vision.zzfl.zzd.zzoo
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzon"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.vision.zzfl$zzm> r3 = com.google.android.gms.internal.vision.zzfl.zzm.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.vision.zzfl$zzd r4 = com.google.android.gms.internal.vision.zzfl.zzd.zzoo
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.vision.zzfl$zzd$zza r2 = new com.google.android.gms.internal.vision.zzfl$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.vision.zzfl$zzd r2 = new com.google.android.gms.internal.vision.zzfl$zzd
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
