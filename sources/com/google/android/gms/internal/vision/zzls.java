package com.google.android.gms.internal.vision;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.gms.internal.vision.zzid;
import java.util.List;
import kotlin.text.Typography;
public final class zzls extends zzid.zze<zzls, zzd> implements zzjp {
    private static final zzls zzaew;
    private static volatile zzjw<zzls> zzbk;
    private zzb zzaek;
    private zzik<zze> zzael = zzid.zzhb();
    private float zzaem;
    private float zzaen;
    private float zzaeo;
    private float zzaep;
    private zzik<zzc> zzaeq = zzid.zzhb();
    private zzik<zza> zzaer = zzid.zzhb();
    private long zzaes;
    private long zzaet;
    private long zzaeu;
    private float zzaev;
    private int zzbm;
    private byte zzkn = 2;

    public static final class zza extends zzid<zza, zzb> implements zzjp {
        private static final zza zzafb;
        private static volatile zzjw<zza> zzbk;
        private float zzaem;
        private float zzafa;
        private int zzbm;
        private int zzjo;
        private String zzpd = "";

        /* renamed from: com.google.android.gms.internal.vision.zzls$zza$zza  reason: collision with other inner class name */
        public enum EnumC0271zza implements zzih {
            TYPE_UNKNOWN(0),
            FREE_FORM(1),
            FEMALE(2),
            MALE(3),
            AGE(5),
            NON_HUMAN(6),
            GLASSES(7),
            DARK_GLASSES(8),
            HEADWEAR(9),
            EYES_VISIBLE(10),
            LEFT_EYELID_CLOSED(16),
            RIGHT_EYELID_CLOSED(17),
            MOUTH_OPEN(11),
            FACIAL_HAIR(12),
            LONG_HAIR(13),
            FRONTAL_GAZE(14),
            SMILING(15),
            UNDER_EXPOSED(18),
            BLURRED(19),
            LEFT_EYE_VISIBLE(20),
            RIGHT_EYE_VISIBLE(21),
            LEFT_EAR_VISIBLE(22),
            RIGHT_EAR_VISIBLE(23),
            NOSE_TIP_VISIBLE(24),
            MOUTH_CENTER_VISIBLE(25);
            
            private static final zzig<EnumC0271zza> zzhq = new zzlw();
            private final int value;

            private EnumC0271zza(int i) {
                this.value = i;
            }

            public static zzij zzal() {
                return zzlv.zzht;
            }

            public static EnumC0271zza zzcg(int i) {
                switch (i) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return FREE_FORM;
                    case 2:
                        return FEMALE;
                    case 3:
                        return MALE;
                    case 4:
                    default:
                        return null;
                    case 5:
                        return AGE;
                    case 6:
                        return NON_HUMAN;
                    case 7:
                        return GLASSES;
                    case 8:
                        return DARK_GLASSES;
                    case 9:
                        return HEADWEAR;
                    case 10:
                        return EYES_VISIBLE;
                    case 11:
                        return MOUTH_OPEN;
                    case 12:
                        return FACIAL_HAIR;
                    case 13:
                        return LONG_HAIR;
                    case 14:
                        return FRONTAL_GAZE;
                    case 15:
                        return SMILING;
                    case 16:
                        return LEFT_EYELID_CLOSED;
                    case 17:
                        return RIGHT_EYELID_CLOSED;
                    case 18:
                        return UNDER_EXPOSED;
                    case 19:
                        return BLURRED;
                    case 20:
                        return LEFT_EYE_VISIBLE;
                    case 21:
                        return RIGHT_EYE_VISIBLE;
                    case 22:
                        return LEFT_EAR_VISIBLE;
                    case 23:
                        return RIGHT_EAR_VISIBLE;
                    case 24:
                        return NOSE_TIP_VISIBLE;
                    case 25:
                        return MOUTH_CENTER_VISIBLE;
                }
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + EnumC0271zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.vision.zzih
            public final int zzak() {
                return this.value;
            }
        }

        public static final class zzb extends zzid.zza<zza, zzb> implements zzjp {
            private zzb() {
                super(zza.zzafb);
            }

            public /* synthetic */ zzb(zzlu zzlu) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzafb = zza;
            zzid.zza(zza.class, zza);
        }

        private zza() {
        }

        public final float getConfidence() {
            return this.zzaem;
        }

        public final String getName() {
            return this.zzpd;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzlu.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zza> r2 = com.google.android.gms.internal.vision.zzls.zza.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzls$zza> r3 = com.google.android.gms.internal.vision.zzls.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zza> r2 = com.google.android.gms.internal.vision.zzls.zza.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls$zza r4 = com.google.android.gms.internal.vision.zzls.zza.zzafb     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls.zza.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzls$zza r2 = com.google.android.gms.internal.vision.zzls.zza.zzafb
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzjo"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzls.zza.EnumC0271zza.zzal()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzpd"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzaem"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzafa"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003"
                com.google.android.gms.internal.vision.zzls$zza r4 = com.google.android.gms.internal.vision.zzls.zza.zzafb
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.vision.zzls$zza$zzb r2 = new com.google.android.gms.internal.vision.zzls$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.vision.zzls$zza r2 = new com.google.android.gms.internal.vision.zzls$zza
                r2.<init>()
                return r2
                switch-data {1->0x0064, 2->0x005e, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzls.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzid<zzb, zza> implements zzjp {
        private static final zzb zzagg;
        private static volatile zzjw<zzb> zzbk;
        private float zzagc;
        private float zzagd;
        private float zzage;
        private float zzagf;
        private int zzbm;

        public static final class zza extends zzid.zza<zzb, zza> implements zzjp {
            private zza() {
                super(zzb.zzagg);
            }

            public /* synthetic */ zza(zzlu zzlu) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzagg = zzb;
            zzid.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public static zzb zzkb() {
            return zzagg;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzlu.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzb> r2 = com.google.android.gms.internal.vision.zzls.zzb.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzls$zzb> r3 = com.google.android.gms.internal.vision.zzls.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzb> r2 = com.google.android.gms.internal.vision.zzls.zzb.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls$zzb r4 = com.google.android.gms.internal.vision.zzls.zzb.zzagg     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls.zzb.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzls$zzb r2 = com.google.android.gms.internal.vision.zzls.zzb.zzagg
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzagc"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzagd"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzage"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzagf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003"
                com.google.android.gms.internal.vision.zzls$zzb r4 = com.google.android.gms.internal.vision.zzls.zzb.zzagg
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzls$zzb$zza r2 = new com.google.android.gms.internal.vision.zzls$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzls$zzb r2 = new com.google.android.gms.internal.vision.zzls$zzb
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzls.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final float zzjx() {
            return this.zzagc;
        }

        public final float zzjy() {
            return this.zzagd;
        }

        public final float zzjz() {
            return this.zzage;
        }

        public final float zzka() {
            return this.zzagf;
        }
    }

    public static final class zzc extends zzid<zzc, zza> implements zzjp {
        private static final zzc zzagk;
        private static volatile zzjw<zzc> zzbk;
        private float zzaem;
        private int zzagh;
        private zzgs zzagi = zzgs.zztt;
        private String zzagj = "";
        private int zzbm;

        public static final class zza extends zzid.zza<zzc, zza> implements zzjp {
            private zza() {
                super(zzc.zzagk);
            }

            public /* synthetic */ zza(zzlu zzlu) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzagk = zzc;
            zzid.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzc>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzlu.zzbl
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
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzc> r2 = com.google.android.gms.internal.vision.zzls.zzc.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzls$zzc> r3 = com.google.android.gms.internal.vision.zzls.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zzc> r2 = com.google.android.gms.internal.vision.zzls.zzc.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls$zzc r4 = com.google.android.gms.internal.vision.zzls.zzc.zzagk     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls.zzc.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzls$zzc r2 = com.google.android.gms.internal.vision.zzls.zzc.zzagk
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbm"
                r2[r3] = r0
                java.lang.String r3 = "zzagh"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzagi"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzagj"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzaem"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003"
                com.google.android.gms.internal.vision.zzls$zzc r4 = com.google.android.gms.internal.vision.zzls.zzc.zzagk
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.vision.zzls$zzc$zza r2 = new com.google.android.gms.internal.vision.zzls$zzc$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.vision.zzls$zzc r2 = new com.google.android.gms.internal.vision.zzls$zzc
                r2.<init>()
                return r2
                switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzls.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzd extends zzid.zzb<zzls, zzd> implements zzjp {
        private zzd() {
            super(zzls.zzaew);
        }

        public /* synthetic */ zzd(zzlu zzlu) {
            this();
        }
    }

    public static final class zze extends zzid<zze, zzb> implements zzjp {
        private static final zze zzagm;
        private static volatile zzjw<zze> zzbk;
        private float zzaem;
        private int zzagl;
        private int zzbm;
        private int zzjo = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
        private float zzjr;
        private float zzjs;
        private float zzjt;

        public enum zza implements zzih {
            LEFT_EYE(0),
            RIGHT_EYE(1),
            LEFT_OF_LEFT_EYEBROW(2),
            RIGHT_OF_LEFT_EYEBROW(3),
            LEFT_OF_RIGHT_EYEBROW(4),
            RIGHT_OF_RIGHT_EYEBROW(5),
            MIDPOINT_BETWEEN_EYES(6),
            NOSE_TIP(9),
            UPPER_LIP(10),
            LOWER_LIP(11),
            MOUTH_LEFT(12),
            MOUTH_RIGHT(13),
            MOUTH_CENTER(45),
            NOSE_BOTTOM_RIGHT(43),
            NOSE_BOTTOM_LEFT(44),
            NOSE_BOTTOM_CENTER(200),
            LEFT_EYE_TOP_BOUNDARY(220),
            LEFT_EYE_RIGHT_CORNER(221),
            LEFT_EYE_BOTTOM_BOUNDARY(222),
            LEFT_EYE_LEFT_CORNER(223),
            RIGHT_EYE_TOP_BOUNDARY(224),
            RIGHT_EYE_RIGHT_CORNER(225),
            RIGHT_EYE_BOTTOM_BOUNDARY(226),
            RIGHT_EYE_LEFT_CORNER(227),
            LEFT_EYEBROW_UPPER_MIDPOINT(300),
            RIGHT_EYEBROW_UPPER_MIDPOINT(302),
            LEFT_EAR_TRAGION(240),
            RIGHT_EAR_TRAGION(241),
            LEFT_EYE_PUPIL(304),
            RIGHT_EYE_PUPIL(305),
            FOREHEAD_GLABELLA(312),
            CHIN_GNATHION(314),
            CHIN_LEFT_GONION(315),
            CHIN_RIGHT_GONION(316),
            LEFT_CHEEK_CENTER(238),
            RIGHT_CHEEK_CENTER(239),
            LEFT_EAR_TOP(242),
            RIGHT_EAR_TOP(243),
            LANDMARK_UNKNOWN(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
            
            private static final zzig<zza> zzhq = new zzly();
            private final int value;

            private zza(int i) {
                this.value = i;
            }

            public static zzij zzal() {
                return zzlx.zzht;
            }

            public static zza zzch(int i) {
                if (i == 200) {
                    return NOSE_BOTTOM_CENTER;
                }
                if (i == 300) {
                    return LEFT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 302) {
                    return RIGHT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 312) {
                    return FOREHEAD_GLABELLA;
                }
                if (i == 15000) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 304) {
                    return LEFT_EYE_PUPIL;
                }
                if (i == 305) {
                    return RIGHT_EYE_PUPIL;
                }
                switch (i) {
                    case 0:
                        return LEFT_EYE;
                    case 1:
                        return RIGHT_EYE;
                    case 2:
                        return LEFT_OF_LEFT_EYEBROW;
                    case 3:
                        return RIGHT_OF_LEFT_EYEBROW;
                    case 4:
                        return LEFT_OF_RIGHT_EYEBROW;
                    case 5:
                        return RIGHT_OF_RIGHT_EYEBROW;
                    case 6:
                        return MIDPOINT_BETWEEN_EYES;
                    default:
                        switch (i) {
                            case 9:
                                return NOSE_TIP;
                            case 10:
                                return UPPER_LIP;
                            case 11:
                                return LOWER_LIP;
                            case 12:
                                return MOUTH_LEFT;
                            case 13:
                                return MOUTH_RIGHT;
                            default:
                                switch (i) {
                                    case 43:
                                        return NOSE_BOTTOM_RIGHT;
                                    case 44:
                                        return NOSE_BOTTOM_LEFT;
                                    case 45:
                                        return MOUTH_CENTER;
                                    default:
                                        switch (i) {
                                            case 220:
                                                return LEFT_EYE_TOP_BOUNDARY;
                                            case 221:
                                                return LEFT_EYE_RIGHT_CORNER;
                                            case 222:
                                                return LEFT_EYE_BOTTOM_BOUNDARY;
                                            case 223:
                                                return LEFT_EYE_LEFT_CORNER;
                                            case 224:
                                                return RIGHT_EYE_TOP_BOUNDARY;
                                            case 225:
                                                return RIGHT_EYE_RIGHT_CORNER;
                                            case 226:
                                                return RIGHT_EYE_BOTTOM_BOUNDARY;
                                            case 227:
                                                return RIGHT_EYE_LEFT_CORNER;
                                            default:
                                                switch (i) {
                                                    case 238:
                                                        return LEFT_CHEEK_CENTER;
                                                    case 239:
                                                        return RIGHT_CHEEK_CENTER;
                                                    case 240:
                                                        return LEFT_EAR_TRAGION;
                                                    case 241:
                                                        return RIGHT_EAR_TRAGION;
                                                    case 242:
                                                        return LEFT_EAR_TOP;
                                                    case 243:
                                                        return RIGHT_EAR_TOP;
                                                    default:
                                                        switch (i) {
                                                            case 314:
                                                                return CHIN_GNATHION;
                                                            case 315:
                                                                return CHIN_LEFT_GONION;
                                                            case 316:
                                                                return CHIN_RIGHT_GONION;
                                                            default:
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
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
                super(zze.zzagm);
            }

            public /* synthetic */ zzb(zzlu zzlu) {
                this();
            }
        }

        public enum zzc implements zzih {
            VISIBILITY_UNKNOWN(0),
            VISIBLE(1),
            OCCLUDED_SELF(2),
            OCCLUDED_OTHER(3);
            
            private static final zzig<zzc> zzhq = new zzlz();
            private final int value;

            private zzc(int i) {
                this.value = i;
            }

            public static zzij zzal() {
                return zzmb.zzht;
            }

            public static zzc zzci(int i) {
                if (i == 0) {
                    return VISIBILITY_UNKNOWN;
                }
                if (i == 1) {
                    return VISIBLE;
                }
                if (i == 2) {
                    return OCCLUDED_SELF;
                }
                if (i != 3) {
                    return null;
                }
                return OCCLUDED_OTHER;
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
            zze zze = new zze();
            zzagm = zze;
            zzid.zza(zze.class, zze);
        }

        private zze() {
        }

        public final float getX() {
            return this.zzjr;
        }

        public final float getY() {
            return this.zzjs;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zze>, com.google.android.gms.internal.vision.zzid$zzc] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.vision.zzid
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.vision.zzlu.zzbl
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0077;
                    case 2: goto L_0x0071;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zze> r2 = com.google.android.gms.internal.vision.zzls.zze.zzbk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.vision.zzls$zze> r3 = com.google.android.gms.internal.vision.zzls.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls$zze> r2 = com.google.android.gms.internal.vision.zzls.zze.zzbk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls$zze r4 = com.google.android.gms.internal.vision.zzls.zze.zzagm     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.vision.zzls.zze.zzbk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.vision.zzls$zze r2 = com.google.android.gms.internal.vision.zzls.zze.zzagm
                return r2
            L_0x0033:
                r2 = 9
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
                r3 = 4
                java.lang.String r4 = "zzjo"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzls.zze.zza.zzal()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzagl"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzls.zze.zzc.zzal()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzaem"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.vision.zzls$zze r4 = com.google.android.gms.internal.vision.zzls.zze.zzagm
                java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
                return r2
            L_0x0071:
                com.google.android.gms.internal.vision.zzls$zze$zzb r2 = new com.google.android.gms.internal.vision.zzls$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x0077:
                com.google.android.gms.internal.vision.zzls$zze r2 = new com.google.android.gms.internal.vision.zzls$zze
                r2.<init>()
                return r2
                switch-data {1->0x0077, 2->0x0071, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzls.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final zza zzke() {
            zza zzch = zza.zzch(this.zzjo);
            return zzch == null ? zza.LANDMARK_UNKNOWN : zzch;
        }
    }

    static {
        zzls zzls = new zzls();
        zzaew = zzls;
        zzid.zza(zzls.class, zzls);
    }

    private zzls() {
    }

    public static zzls zzju() {
        return zzaew;
    }

    public final float getConfidence() {
        return this.zzaem;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls>, com.google.android.gms.internal.vision.zzid$zzc] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzid
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
        /*
            r2 = this;
            int[] r5 = com.google.android.gms.internal.vision.zzlu.zzbl
            r0 = 1
            int r3 = r3 - r0
            r3 = r5[r3]
            r5 = 0
            r1 = 0
            switch(r3) {
                case 1: goto L_0x00a5;
                case 2: goto L_0x009f;
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
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls> r3 = com.google.android.gms.internal.vision.zzls.zzbk
            if (r3 != 0) goto L_0x0038
            java.lang.Class<com.google.android.gms.internal.vision.zzls> r4 = com.google.android.gms.internal.vision.zzls.class
            monitor-enter(r4)
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzls> r3 = com.google.android.gms.internal.vision.zzls.zzbk     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0033
            com.google.android.gms.internal.vision.zzid$zzc r3 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.vision.zzls r5 = com.google.android.gms.internal.vision.zzls.zzaew     // Catch:{ all -> 0x0035 }
            r3.<init>(r5)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.vision.zzls.zzbk = r3     // Catch:{ all -> 0x0035 }
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
            com.google.android.gms.internal.vision.zzls r3 = com.google.android.gms.internal.vision.zzls.zzaew
            return r3
        L_0x003c:
            r3 = 16
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "zzbm"
            r3[r5] = r4
            java.lang.String r4 = "zzaek"
            r3[r0] = r4
            r4 = 2
            java.lang.String r5 = "zzael"
            r3[r4] = r5
            r4 = 3
            java.lang.Class<com.google.android.gms.internal.vision.zzls$zze> r5 = com.google.android.gms.internal.vision.zzls.zze.class
            r3[r4] = r5
            r4 = 4
            java.lang.String r5 = "zzaem"
            r3[r4] = r5
            r4 = 5
            java.lang.String r5 = "zzaen"
            r3[r4] = r5
            r4 = 6
            java.lang.String r5 = "zzaeo"
            r3[r4] = r5
            r4 = 7
            java.lang.String r5 = "zzaep"
            r3[r4] = r5
            r4 = 8
            java.lang.String r5 = "zzaeq"
            r3[r4] = r5
            r4 = 9
            java.lang.Class<com.google.android.gms.internal.vision.zzls$zzc> r5 = com.google.android.gms.internal.vision.zzls.zzc.class
            r3[r4] = r5
            r4 = 10
            java.lang.String r5 = "zzaer"
            r3[r4] = r5
            r4 = 11
            java.lang.Class<com.google.android.gms.internal.vision.zzls$zza> r5 = com.google.android.gms.internal.vision.zzls.zza.class
            r3[r4] = r5
            r4 = 12
            java.lang.String r5 = "zzaet"
            r3[r4] = r5
            r4 = 13
            java.lang.String r5 = "zzaev"
            r3[r4] = r5
            r4 = 14
            java.lang.String r5 = "zzaeu"
            r3[r4] = r5
            r4 = 15
            java.lang.String r5 = "zzaes"
            r3[r4] = r5
            java.lang.String r4 = "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0006\nခ\b\u000bဃ\u0007\fဃ\u0005"
            com.google.android.gms.internal.vision.zzls r5 = com.google.android.gms.internal.vision.zzls.zzaew
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzid.zza(r5, r4, r3)
            return r3
        L_0x009f:
            com.google.android.gms.internal.vision.zzls$zzd r3 = new com.google.android.gms.internal.vision.zzls$zzd
            r3.<init>(r1)
            return r3
        L_0x00a5:
            com.google.android.gms.internal.vision.zzls r3 = new com.google.android.gms.internal.vision.zzls
            r3.<init>()
            return r3
            switch-data {1->0x00a5, 2->0x009f, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzls.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final zzb zzjm() {
        zzb zzb2 = this.zzaek;
        return zzb2 == null ? zzb.zzkb() : zzb2;
    }

    public final List<zze> zzjn() {
        return this.zzael;
    }

    public final boolean zzjo() {
        return (this.zzbm & 2) != 0;
    }

    public final float zzjp() {
        return this.zzaen;
    }

    public final float zzjq() {
        return this.zzaeo;
    }

    public final float zzjr() {
        return this.zzaep;
    }

    public final List<zza> zzjs() {
        return this.zzaer;
    }

    public final long zzjt() {
        return this.zzaet;
    }
}
