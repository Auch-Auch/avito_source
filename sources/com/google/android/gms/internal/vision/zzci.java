package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import java.util.List;
import kotlin.text.Typography;
public final class zzci {
    public static final zzid.zzg<zzls, List<zzb>> zzjg = zzid.zza(zzls.zzju(), zzb.zzbm(), null, 202056002, zzlk.MESSAGE, false, zzb.class);

    public static final class zzb extends zzid<zzb, zza> implements zzjp {
        private static volatile zzjw<zzb> zzbk;
        private static final zzb zzjq;
        private int zzbm;
        private int zzjo;
        private zzik<C0269zzb> zzjp = zzid.zzhb();

        public static final class zza extends zzid.zza<zzb, zza> implements zzjp {
            private zza() {
                super(zzb.zzjq);
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.vision.zzci$zzb$zzb  reason: collision with other inner class name */
        public static final class C0269zzb extends zzid<C0269zzb, zza> implements zzjp {
            private static volatile zzjw<C0269zzb> zzbk;
            private static final C0269zzb zzju;
            private int zzbm;
            private float zzjr;
            private float zzjs;
            private float zzjt;

            /* renamed from: com.google.android.gms.internal.vision.zzci$zzb$zzb$zza */
            public static final class zza extends zzid.zza<C0269zzb, zza> implements zzjp {
                private zza() {
                    super(C0269zzb.zzju);
                }

                public /* synthetic */ zza(zzcj zzcj) {
                    this();
                }
            }

            static {
                C0269zzb zzb = new C0269zzb();
                zzju = zzb;
                zzid.zza(C0269zzb.class, zzb);
            }

            private C0269zzb() {
            }

            public final float getX() {
                return this.zzjr;
            }

            public final float getY() {
                return this.zzjs;
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb$zzb>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.vision.zzid
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                    com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb$zzb> r2 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzbk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.vision.zzci$zzb$zzb> r3 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb$zzb> r2 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzbk     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.vision.zzci$zzb$zzb r4 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzju     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzbk = r2     // Catch:{ all -> 0x002c }
                L_0x002a:
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x002c }
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.vision.zzci$zzb$zzb r2 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzju
                    return r2
                L_0x0033:
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzbm"
                    r2[r3] = r0
                    java.lang.String r3 = "zzjr"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zzjs"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzjt"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002"
                    com.google.android.gms.internal.vision.zzci$zzb$zzb r4 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zzju
                    java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                    return r2
                L_0x0052:
                    com.google.android.gms.internal.vision.zzci$zzb$zzb$zza r2 = new com.google.android.gms.internal.vision.zzci$zzb$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x0058:
                    com.google.android.gms.internal.vision.zzci$zzb$zzb r2 = new com.google.android.gms.internal.vision.zzci$zzb$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        public enum zzc implements zzih {
            CONTOUR_UNKNOWN(0),
            FACE_OVAL(1),
            LEFT_EYEBROW_TOP(2),
            LEFT_EYEBROW_BOTTOM(3),
            RIGHT_EYEBROW_TOP(4),
            RIGHT_EYEBROW_BOTTOM(5),
            LEFT_EYE(6),
            RIGHT_EYE(7),
            UPPER_LIP_TOP(8),
            UPPER_LIP_BOTTOM(9),
            LOWER_LIP_TOP(10),
            LOWER_LIP_BOTTOM(11),
            NOSE_BRIDGE(12),
            NOSE_BOTTOM(13),
            LEFT_CHEEK_CENTER(14),
            RIGHT_CHEEK_CENTER(15);
            
            private static final zzig<zzc> zzhq = new zzcn();
            private final int value;

            private zzc(int i) {
                this.value = i;
            }

            public static zzij zzal() {
                return zzco.zzht;
            }

            public static zzc zzp(int i) {
                switch (i) {
                    case 0:
                        return CONTOUR_UNKNOWN;
                    case 1:
                        return FACE_OVAL;
                    case 2:
                        return LEFT_EYEBROW_TOP;
                    case 3:
                        return LEFT_EYEBROW_BOTTOM;
                    case 4:
                        return RIGHT_EYEBROW_TOP;
                    case 5:
                        return RIGHT_EYEBROW_BOTTOM;
                    case 6:
                        return LEFT_EYE;
                    case 7:
                        return RIGHT_EYE;
                    case 8:
                        return UPPER_LIP_TOP;
                    case 9:
                        return UPPER_LIP_BOTTOM;
                    case 10:
                        return LOWER_LIP_TOP;
                    case 11:
                        return LOWER_LIP_BOTTOM;
                    case 12:
                        return NOSE_BRIDGE;
                    case 13:
                        return NOSE_BOTTOM;
                    case 14:
                        return LEFT_CHEEK_CENTER;
                    case 15:
                        return RIGHT_CHEEK_CENTER;
                    default:
                        return null;
                }
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

        static {
            zzb zzb = new zzb();
            zzjq = zzb;
            zzid.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public static zzb zzbm() {
            return zzjq;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb> r2 = com.google.android.gms.internal.vision.zzci.zzb.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzb> r3 = com.google.android.gms.internal.vision.zzci.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzb> r2 = com.google.android.gms.internal.vision.zzci.zzb.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zzb r4 = com.google.android.gms.internal.vision.zzci.zzb.zzjq     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zzb.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zzb r2 = com.google.android.gms.internal.vision.zzci.zzb.zzjq
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzjo"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzci.zzb.zzc.zzal()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzjp"
                r2[r3] = r4
                r3 = 4
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzb$zzb> r4 = com.google.android.gms.internal.vision.zzci.zzb.C0269zzb.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b"
                com.google.android.gms.internal.vision.zzci$zzb r4 = com.google.android.gms.internal.vision.zzci.zzb.zzjq
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.vision.zzci$zzb$zza r2 = new com.google.android.gms.internal.vision.zzci$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.vision.zzci$zzb r2 = new com.google.android.gms.internal.vision.zzci$zzb
                r2.<init>()
                return r2
                switch-data {1->0x005f, 2->0x0059, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final zzc zzbj() {
            zzc zzp = zzc.zzp(this.zzjo);
            return zzp == null ? zzc.CONTOUR_UNKNOWN : zzp;
        }

        public final List<C0269zzb> zzbk() {
            return this.zzjp;
        }

        public final int zzbl() {
            return this.zzjp.size();
        }
    }

    public static final class zzc extends zzid<zzc, zza> implements zzjp {
        private static volatile zzjw<zzc> zzbk;
        private static final zzc zzko;
        private int zzbm;
        private zzma zzkm;
        private byte zzkn = 2;

        public static final class zza extends zzid.zza<zzc, zza> implements zzjp {
            private zza() {
                super(zzc.zzko);
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzko = zzc;
            zzid.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        public static zzc zza(byte[] bArr, zzho zzho) throws zzin {
            return (zzc) zzid.zza(zzko, bArr, zzho);
        }

        public final zzma zzbp() {
            zzma zzma = this.zzkm;
            return zzma == null ? zzma.zzkh() : zzma;
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzc>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                r2.zzkn = r3
                return r1
            L_0x0018:
                byte r3 = r2.zzkn
                java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
                return r3
            L_0x001f:
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzc> r3 = com.google.android.gms.internal.vision.zzci.zzc.zzbk
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzc> r4 = com.google.android.gms.internal.vision.zzci.zzc.class
                monitor-enter(r4)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzc> r3 = com.google.android.gms.internal.vision.zzci.zzc.zzbk     // Catch:{ all -> 0x0035 }
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.vision.zzid$zzc r3 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.vision.zzci$zzc r5 = com.google.android.gms.internal.vision.zzci.zzc.zzko     // Catch:{ all -> 0x0035 }
                r3.<init>(r5)     // Catch:{ all -> 0x0035 }
                com.google.android.gms.internal.vision.zzci.zzc.zzbk = r3     // Catch:{ all -> 0x0035 }
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
                com.google.android.gms.internal.vision.zzci$zzc r3 = com.google.android.gms.internal.vision.zzci.zzc.zzko
                return r3
            L_0x003c:
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzbm"
                r3[r5] = r4
                java.lang.String r4 = "zzkm"
                r3[r0] = r4
                java.lang.String r4 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000"
                com.google.android.gms.internal.vision.zzci$zzc r5 = com.google.android.gms.internal.vision.zzci.zzc.zzko
                java.lang.Object r3 = com.google.android.gms.internal.vision.zzid.zza(r5, r4, r3)
                return r3
            L_0x0050:
                com.google.android.gms.internal.vision.zzci$zzc$zza r3 = new com.google.android.gms.internal.vision.zzci$zzc$zza
                r3.<init>(r1)
                return r3
            L_0x0056:
                com.google.android.gms.internal.vision.zzci$zzc r3 = new com.google.android.gms.internal.vision.zzci$zzc
                r3.<init>()
                return r3
                switch-data {1->0x0056, 2->0x0050, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zze extends zzid<zze, zza> implements zzjp {
        private static volatile zzjw<zze> zzbk;
        private static final zze zzlf;
        private int zzbm;
        private zzg zzlc;
        private zzg zzld;
        private zzg zzle;

        public static final class zza extends zzid.zza<zze, zza> implements zzjp {
            private zza() {
                super(zze.zzlf);
            }

            public final zza zzh(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zze) this.zzxx).zze(zzg);
                return this;
            }

            public final zza zzi(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zze) this.zzxx).zzf(zzg);
                return this;
            }

            public final zza zzj(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zze) this.zzxx).zzg(zzg);
                return this;
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }
        }

        static {
            zze zze = new zze();
            zzlf = zze;
            zzid.zza(zze.class, zze);
        }

        private zze() {
        }

        public static zza zzbv() {
            return (zza) zzlf.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(zzg zzg) {
            zzg.getClass();
            this.zzlc = zzg;
            this.zzbm |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(zzg zzg) {
            zzg.getClass();
            this.zzld = zzg;
            this.zzbm |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(zzg zzg) {
            zzg.getClass();
            this.zzle = zzg;
            this.zzbm |= 4;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zze>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zze> r2 = com.google.android.gms.internal.vision.zzci.zze.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zze> r3 = com.google.android.gms.internal.vision.zzci.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zze> r2 = com.google.android.gms.internal.vision.zzci.zze.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zze r4 = com.google.android.gms.internal.vision.zzci.zze.zzlf     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zze.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zze r2 = com.google.android.gms.internal.vision.zzci.zze.zzlf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzlc"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzld"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzle"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.vision.zzci$zze r4 = com.google.android.gms.internal.vision.zzci.zze.zzlf
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.vision.zzci$zze$zza r2 = new com.google.android.gms.internal.vision.zzci$zze$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.vision.zzci$zze r2 = new com.google.android.gms.internal.vision.zzci$zze
                r2.<init>()
                return r2
                switch-data {1->0x0058, 2->0x0052, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzf extends zzid<zzf, zza> implements zzjp {
        private static volatile zzjw<zzf> zzbk;
        private static final zzf zzlp;
        private int zzbm;
        private zzg zzll;
        private zzg zzlm;
        private zzg zzln;
        private zzg zzlo;

        public static final class zza extends zzid.zza<zzf, zza> implements zzjp {
            private zza() {
                super(zzf.zzlp);
            }

            public final zza zzk(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzo(zzg);
                return this;
            }

            public final zza zzl(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzp(zzg);
                return this;
            }

            public final zza zzm(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzq(zzg);
                return this;
            }

            public final zza zzn(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzf) this.zzxx).zzr(zzg);
                return this;
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }
        }

        static {
            zzf zzf = new zzf();
            zzlp = zzf;
            zzid.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        public static zza zzbx() {
            return (zza) zzlp.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(zzg zzg) {
            zzg.getClass();
            this.zzll = zzg;
            this.zzbm |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(zzg zzg) {
            zzg.getClass();
            this.zzlm = zzg;
            this.zzbm |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzq(zzg zzg) {
            zzg.getClass();
            this.zzln = zzg;
            this.zzbm |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzr(zzg zzg) {
            zzg.getClass();
            this.zzlo = zzg;
            this.zzbm |= 8;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzf>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzf> r2 = com.google.android.gms.internal.vision.zzci.zzf.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzf> r3 = com.google.android.gms.internal.vision.zzci.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzf> r2 = com.google.android.gms.internal.vision.zzci.zzf.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zzf r4 = com.google.android.gms.internal.vision.zzci.zzf.zzlp     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zzf.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zzf r2 = com.google.android.gms.internal.vision.zzci.zzf.zzlp
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzll"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzlm"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzln"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzlo"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                com.google.android.gms.internal.vision.zzci$zzf r4 = com.google.android.gms.internal.vision.zzci.zzf.zzlp
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzci$zzf$zza r2 = new com.google.android.gms.internal.vision.zzci$zzf$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzci$zzf r2 = new com.google.android.gms.internal.vision.zzci$zzf
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzg extends zzid<zzg, zza> implements zzjp {
        private static volatile zzjw<zzg> zzbk;
        private static final zzg zzlx;
        private int zzbm;
        private zzgs zzlv = zzgs.zztt;
        private String zzlw = "";

        public static final class zza extends zzid.zza<zzg, zza> implements zzjp {
            private zza() {
                super(zzg.zzlx);
            }

            public final zza zzk(String str) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzg) this.zzxx).zzj(str);
                return this;
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }
        }

        static {
            zzg zzg = new zzg();
            zzlx = zzg;
            zzid.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        public static zza zzbz() {
            return (zza) zzlx.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzj(String str) {
            str.getClass();
            this.zzbm |= 2;
            this.zzlw = str;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzg>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzg> r2 = com.google.android.gms.internal.vision.zzci.zzg.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzg> r3 = com.google.android.gms.internal.vision.zzci.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzg> r2 = com.google.android.gms.internal.vision.zzci.zzg.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zzg r4 = com.google.android.gms.internal.vision.zzci.zzg.zzlx     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zzg.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zzg r2 = com.google.android.gms.internal.vision.zzci.zzg.zzlx
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzlv"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzlw"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001"
                com.google.android.gms.internal.vision.zzci$zzg r4 = com.google.android.gms.internal.vision.zzci.zzg.zzlx
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.vision.zzci$zzg$zza r2 = new com.google.android.gms.internal.vision.zzci$zzg$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.vision.zzci$zzg r2 = new com.google.android.gms.internal.vision.zzci$zzg
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzid<zzd, zza> implements zzjp {
        private static volatile zzjw<zzd> zzbk;
        private static final zzd zzlb;
        private int zzbm;
        private float zzkp = 0.1f;
        private int zzkq = 1;
        private int zzkr = 1;
        private int zzks = 1;
        private boolean zzkt;
        private boolean zzku;
        private float zzkv = 45.0f;
        private float zzkw = 0.5f;
        private boolean zzkx;
        private zze zzky;
        private zza zzkz;
        private zzf zzla;

        public static final class zza extends zzid.zza<zzd, zza> implements zzjp {
            private zza() {
                super(zzd.zzlb);
            }

            public final zza zza(zze.zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza((zze) ((zzid) zza.zzgw()));
                return this;
            }

            public final zza zzb(zzcp zzcp) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza(zzcp);
                return this;
            }

            public final zza zzd(boolean z) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza(z);
                return this;
            }

            public final zza zze(float f) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zzd(f);
                return this;
            }

            public final zza zzf(boolean z) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zzc(true);
                return this;
            }

            public /* synthetic */ zza(zzcj zzcj) {
                this();
            }

            public final zza zza(zza.C0268zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza((zza) ((zzid) zza.zzgw()));
                return this;
            }

            public final zza zzb(zzck zzck) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza(zzck);
                return this;
            }

            public final zza zze(boolean z) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zzb(z);
                return this;
            }

            public final zza zza(zzf.zza zza) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza((zzf) ((zzid) zza.zzgw()));
                return this;
            }

            public final zza zzb(zzct zzct) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zzd) this.zzxx).zza(zzct);
                return this;
            }
        }

        static {
            zzd zzd = new zzd();
            zzlb = zzd;
            zzid.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzcp zzcp) {
            this.zzkq = zzcp.zzak();
            this.zzbm |= 2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(boolean z) {
            this.zzbm |= 32;
            this.zzku = z;
        }

        public static zza zzbt() {
            return (zza) zzlb.zzgy();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(boolean z) {
            this.zzbm |= 256;
            this.zzkx = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(float f) {
            this.zzbm |= 1;
            this.zzkp = f;
        }

        public final zzcp zzbr() {
            zzcp zzq = zzcp.zzq(this.zzkq);
            return zzq == null ? zzcp.NO_LANDMARK : zzq;
        }

        public final zzck zzbs() {
            zzck zzo = zzck.zzo(this.zzkr);
            return zzo == null ? zzck.NO_CLASSIFICATION : zzo;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzck zzck) {
            this.zzkr = zzck.zzak();
            this.zzbm |= 4;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzct zzct) {
            this.zzks = zzct.zzak();
            this.zzbm |= 8;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzbm |= 16;
            this.zzkt = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zze zze) {
            zze.getClass();
            this.zzky = zze;
            this.zzbm |= 512;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            zza2.getClass();
            this.zzkz = zza2;
            this.zzbm |= 1024;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzf zzf) {
            zzf.getClass();
            this.zzla = zzf;
            this.zzbm |= 2048;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzd>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x00a3;
                    case 2: goto L_0x009d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzd> r2 = com.google.android.gms.internal.vision.zzci.zzd.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zzd> r3 = com.google.android.gms.internal.vision.zzci.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zzd> r2 = com.google.android.gms.internal.vision.zzci.zzd.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zzd r4 = com.google.android.gms.internal.vision.zzci.zzd.zzlb     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zzd.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zzd r2 = com.google.android.gms.internal.vision.zzci.zzd.zzlb
                return r2
            L_0x0033:
                r2 = 16
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzkp"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzkq"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzcp.zzal()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzkr"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzck.zzal()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzks"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzct.zzal()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzkt"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzku"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzkv"
                r2[r3] = r4
                r3 = 11
                java.lang.String r4 = "zzkw"
                r2[r3] = r4
                r3 = 12
                java.lang.String r4 = "zzkx"
                r2[r3] = r4
                r3 = 13
                java.lang.String r4 = "zzky"
                r2[r3] = r4
                r3 = 14
                java.lang.String r4 = "zzkz"
                r2[r3] = r4
                r3 = 15
                java.lang.String r4 = "zzla"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ခ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b\nဉ\t\u000bဉ\n\fဉ\u000b"
                com.google.android.gms.internal.vision.zzci$zzd r4 = com.google.android.gms.internal.vision.zzci.zzd.zzlb
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x009d:
                com.google.android.gms.internal.vision.zzci$zzd$zza r2 = new com.google.android.gms.internal.vision.zzci$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x00a3:
                com.google.android.gms.internal.vision.zzci$zzd r2 = new com.google.android.gms.internal.vision.zzci$zzd
                r2.<init>()
                return r2
                switch-data {1->0x00a3, 2->0x009d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zza extends zzid<zza, C0268zza> implements zzjp {
        private static volatile zzjw<zza> zzbk;
        private static final zza zzjj;
        private int zzbm;
        private zzg zzjh;
        private zzg zzji;

        /* renamed from: com.google.android.gms.internal.vision.zzci$zza$zza  reason: collision with other inner class name */
        public static final class C0268zza extends zzid.zza<zza, C0268zza> implements zzjp {
            private C0268zza() {
                super(zza.zzjj);
            }

            public final C0268zza zzc(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zza) this.zzxx).zza(zzg);
                return this;
            }

            public final C0268zza zzd(zzg zzg) {
                if (this.zzxy) {
                    zzgs();
                    this.zzxy = false;
                }
                ((zza) this.zzxx).zzb(zzg);
                return this;
            }

            public /* synthetic */ C0268zza(zzcj zzcj) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzjj = zza;
            zzid.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzg zzg) {
            zzg.getClass();
            this.zzjh = zzg;
            this.zzbm |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzg zzg) {
            zzg.getClass();
            this.zzji = zzg;
            this.zzbm |= 2;
        }

        public static C0268zza zzbh() {
            return (C0268zza) zzjj.zzgy();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zza>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzcj.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zza> r2 = com.google.android.gms.internal.vision.zzci.zza.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzci$zza> r3 = com.google.android.gms.internal.vision.zzci.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzci$zza> r2 = com.google.android.gms.internal.vision.zzci.zza.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci$zza r4 = com.google.android.gms.internal.vision.zzci.zza.zzjj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzci.zza.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzci$zza r2 = com.google.android.gms.internal.vision.zzci.zza.zzjj
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzjh"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzji"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.vision.zzci$zza r4 = com.google.android.gms.internal.vision.zzci.zza.zzjj
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.vision.zzci$zza$zza r2 = new com.google.android.gms.internal.vision.zzci$zza$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.vision.zzci$zza r2 = new com.google.android.gms.internal.vision.zzci$zza
                r2.<init>()
                return r2
                switch-data {1->0x0053, 2->0x004d, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzci.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
