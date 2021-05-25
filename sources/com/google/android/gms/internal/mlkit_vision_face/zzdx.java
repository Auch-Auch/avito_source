package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import kotlin.text.Typography;
public final class zzdx {

    public static final class zza extends zzgd<zza, C0261zza> implements zzhn {
        private static final zzgj<Integer, zzeq> zzd = new zzdz();
        private static final zza zze;
        private static volatile zzhv<zza> zzf;
        private zzgk zzc = zzgd.zzk();

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzdx$zza$zza  reason: collision with other inner class name */
        public static final class C0261zza extends zzgd.zza<zza, C0261zza> implements zzhn {
            private C0261zza() {
                super(zza.zze);
            }

            public /* synthetic */ C0261zza(zzdy zzdy) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_face.zzgj<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_face.zzeq>, com.google.android.gms.internal.mlkit_vision_face.zzdz] */
        static {
            zza zza = new zza();
            zze = zza;
            zzgd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzdy.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzdx$zza> r3 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zza> r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zzf     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zze     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zzf = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zza r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zze
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                com.google.android.gms.internal.mlkit_vision_face.zzgh r3 = com.google.android.gms.internal.mlkit_vision_face.zzeq.zzb()
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e"
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zza r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x004a:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzdx$zza$zza
                r2.<init>(r3)
                return r2
            L_0x0050:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzdx$zza
                r2.<init>()
                return r2
                switch-data {1->0x0050, 2->0x004a, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzdx.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public static final class zzb extends zzgd<zzb, zza> implements zzhn {
        private static final zzb zzj;
        private static volatile zzhv<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        public static final class zza extends zzgd.zza<zzb, zza> implements zzhn {
            private zza() {
                super(zzb.zzj);
            }

            public /* synthetic */ zza(zzdy zzdy) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb$zzb  reason: collision with other inner class name */
        public enum EnumC0262zzb implements zzgf {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzgi<EnumC0262zzb> zzd = new zzea();
            private final int zze;

            private EnumC0262zzb(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzeb.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + EnumC0262zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        public enum zzc implements zzgf {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzgi<zzc> zze = new zzed();
            private final int zzf;

            private zzc(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzec.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        public enum zzd implements zzgf {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzgi<zzd> zze = new zzee();
            private final int zzf;

            private zzd(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzef.zza;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzb zzb = new zzb();
            zzj = zzb;
            zzgd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc, com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_face.zzgd
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_face.zzdy.zza
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
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb> r3 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_face.zzhv<com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb> r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzk     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc r2 = new com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzj     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzk = r2     // Catch:{ all -> 0x002c }
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x002c }
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb r2 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzj
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
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_face.zzgh r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.EnumC0262zzb.zzb()
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
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb r4 = com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_face.zzgd.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb r2 = new com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb
                r2.<init>()
                return r2
                switch-data {1->0x007f, 2->0x0079, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzdx.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
