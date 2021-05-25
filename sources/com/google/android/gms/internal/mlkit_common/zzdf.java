package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import kotlin.text.Typography;
public final class zzdf {

    public static final class zza extends zzfq<zza, C0222zza> implements zzhd {
        private static final zzfz<Integer, zzef> zzd = new zzdg();
        private static final zza zze;
        private static volatile zzhl<zza> zzf;
        private zzfw zzc = zzfq.zzk();

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzdf$zza$zza  reason: collision with other inner class name */
        public static final class C0222zza extends zzfq.zzb<zza, C0222zza> implements zzhd {
            private C0222zza() {
                super(zza.zze);
            }

            public /* synthetic */ C0222zza(zzde zzde) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzfz<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzef>, com.google.android.gms.internal.mlkit_common.zzdg] */
        static {
            zza zza = new zza();
            zze = zza;
            zzfq.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zza>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzde.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzdf.zza.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzdf$zza> r3 = com.google.android.gms.internal.mlkit_common.zzdf.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzdf.zza.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzdf$zza r4 = com.google.android.gms.internal.mlkit_common.zzdf.zza.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzdf.zza.zzf = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzdf$zza r2 = com.google.android.gms.internal.mlkit_common.zzdf.zza.zze
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                com.google.android.gms.internal.mlkit_common.zzfx r3 = com.google.android.gms.internal.mlkit_common.zzef.zzb()
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e"
                com.google.android.gms.internal.mlkit_common.zzdf$zza r4 = com.google.android.gms.internal.mlkit_common.zzdf.zza.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x004a:
                com.google.android.gms.internal.mlkit_common.zzdf$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzdf$zza$zza
                r2.<init>(r3)
                return r2
            L_0x0050:
                com.google.android.gms.internal.mlkit_common.zzdf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzdf$zza
                r2.<init>()
                return r2
                switch-data {1->0x0050, 2->0x004a, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzdf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzfq<zzb, C0223zzb> implements zzhd {
        private static final zzb zzj;
        private static volatile zzhl<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        public enum zza implements zzfv {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzfu<zza> zzd = new zzdi();
            private final int zze;

            private zza(int i) {
                this.zze = i;
            }

            public static zzfx zzb() {
                return zzdh.zza;
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

        /* renamed from: com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzb  reason: collision with other inner class name */
        public static final class C0223zzb extends zzfq.zzb<zzb, C0223zzb> implements zzhd {
            private C0223zzb() {
                super(zzb.zzj);
            }

            public /* synthetic */ C0223zzb(zzde zzde) {
                this();
            }
        }

        public enum zzc implements zzfv {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzfu<zzc> zze = new zzdj();
            private final int zzf;

            private zzc(int i) {
                this.zzf = i;
            }

            public static zzfx zzb() {
                return zzdk.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzf;
            }
        }

        public enum zzd implements zzfv {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzfu<zzd> zze = new zzdm();
            private final int zzf;

            private zzd(int i) {
                this.zzf = i;
            }

            public static zzfx zzb() {
                return zzdl.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfv
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzb zzb = new zzb();
            zzj = zzb;
            zzfq.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zzb>, com.google.android.gms.internal.mlkit_common.zzfq$zza] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzfq
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzde.zza
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
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzdf$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzhl<com.google.android.gms.internal.mlkit_common.zzdf$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzfq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzfq$zza     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzdf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzdf$zzb r2 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzj
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
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfx r4 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zza.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_common.zzdf$zzb r4 = com.google.android.gms.internal.mlkit_common.zzdf.zzb.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzfq.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzb
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_common.zzdf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzdf$zzb
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzdf.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
