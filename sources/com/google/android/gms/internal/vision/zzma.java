package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
public final class zzma extends zzid<zzma, zza> implements zzjp {
    private static final zzma zzaih;
    private static volatile zzjw<zzma> zzbk;
    private zzik<zzls> zzaig = zzid.zzhb();
    private byte zzkn = 2;

    public static final class zza extends zzid.zza<zzma, zza> implements zzjp {
        private zza() {
            super(zzma.zzaih);
        }

        public /* synthetic */ zza(zzmc zzmc) {
            this();
        }
    }

    static {
        zzma zzma = new zzma();
        zzaih = zzma;
        zzid.zza(zzma.class, zzma);
    }

    private zzma() {
    }

    public static zzma zzkh() {
        return zzaih;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzma>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzid
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
        /*
            r2 = this;
            int[] r5 = com.google.android.gms.internal.vision.zzmc.zzbl
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
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzma> r3 = com.google.android.gms.internal.vision.zzma.zzbk
            if (r3 != 0) goto L_0x0038
            java.lang.Class<com.google.android.gms.internal.vision.zzma> r4 = com.google.android.gms.internal.vision.zzma.class
            monitor-enter(r4)
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzma> r3 = com.google.android.gms.internal.vision.zzma.zzbk     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0033
            com.google.android.gms.internal.vision.zzid$zzc r3 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.vision.zzma r5 = com.google.android.gms.internal.vision.zzma.zzaih     // Catch:{ all -> 0x0035 }
            r3.<init>(r5)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.vision.zzma.zzbk = r3     // Catch:{ all -> 0x0035 }
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
            com.google.android.gms.internal.vision.zzma r3 = com.google.android.gms.internal.vision.zzma.zzaih
            return r3
        L_0x003c:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "zzaig"
            r3[r5] = r4
            java.lang.Class<com.google.android.gms.internal.vision.zzls> r4 = com.google.android.gms.internal.vision.zzls.class
            r3[r0] = r4
            java.lang.String r4 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л"
            com.google.android.gms.internal.vision.zzma r5 = com.google.android.gms.internal.vision.zzma.zzaih
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzid.zza(r5, r4, r3)
            return r3
        L_0x0050:
            com.google.android.gms.internal.vision.zzma$zza r3 = new com.google.android.gms.internal.vision.zzma$zza
            r3.<init>(r1)
            return r3
        L_0x0056:
            com.google.android.gms.internal.vision.zzma r3 = new com.google.android.gms.internal.vision.zzma
            r3.<init>()
            return r3
            switch-data {1->0x0056, 2->0x0050, 3->0x003c, 4->0x0039, 5->0x001f, 6->0x0018, 7->0x0011, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzma.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final zzls zzcj(int i) {
        return this.zzaig.get(i);
    }

    public final int zzkg() {
        return this.zzaig.size();
    }
}
