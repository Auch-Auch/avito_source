package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
public final class zzcb extends zzid<zzcb, zza> implements zzjp {
    private static volatile zzjw<zzcb> zzbk;
    private static final zzcb zzib;
    private int zzbm;
    private int zzhu;
    private int zzhv;
    private int zzhw;
    private int zzhx;
    private boolean zzhy;
    private long zzhz;
    private String zzia = "";

    public static final class zza extends zzid.zza<zzcb, zza> implements zzjp {
        private zza() {
            super(zzcb.zzib);
        }

        public final zza zzb(zzbw zzbw) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            ((zzcb) this.zzxx).zza(zzbw);
            return this;
        }

        public final zza zzc(long j) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            ((zzcb) this.zzxx).zzb(j);
            return this;
        }

        public final zza zzj(int i) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            ((zzcb) this.zzxx).setWidth(i);
            return this;
        }

        public final zza zzk(int i) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            ((zzcb) this.zzxx).setHeight(i);
            return this;
        }

        public /* synthetic */ zza(zzca zzca) {
            this();
        }

        public final zza zzb(zzcc zzcc) {
            if (this.zzxy) {
                zzgs();
                this.zzxy = false;
            }
            ((zzcb) this.zzxx).zza(zzcc);
            return this;
        }
    }

    static {
        zzcb zzcb = new zzcb();
        zzib = zzcb;
        zzid.zza(zzcb.class, zzcb);
    }

    private zzcb() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setHeight(int i) {
        this.zzbm |= 2;
        this.zzhv = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setWidth(int i) {
        this.zzbm |= 1;
        this.zzhu = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzbw zzbw) {
        this.zzhw = zzbw.zzak();
        this.zzbm |= 4;
    }

    public static zza zzam() {
        return (zza) zzib.zzgy();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzb(long j) {
        this.zzbm |= 32;
        this.zzhz = j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzcc zzcc) {
        this.zzhx = zzcc.zzak();
        this.zzbm |= 8;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzid$zzc, com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzcb>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzid
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
            r1 = this;
            int[] r3 = com.google.android.gms.internal.vision.zzca.zzbl
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
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzcb> r2 = com.google.android.gms.internal.vision.zzcb.zzbk
            if (r2 != 0) goto L_0x002f
            java.lang.Class<com.google.android.gms.internal.vision.zzcb> r3 = com.google.android.gms.internal.vision.zzcb.class
            monitor-enter(r3)
            com.google.android.gms.internal.vision.zzjw<com.google.android.gms.internal.vision.zzcb> r2 = com.google.android.gms.internal.vision.zzcb.zzbk     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.vision.zzid$zzc r2 = new com.google.android.gms.internal.vision.zzid$zzc     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.vision.zzcb r4 = com.google.android.gms.internal.vision.zzcb.zzib     // Catch:{ all -> 0x002c }
            r2.<init>(r4)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.vision.zzcb.zzbk = r2     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            goto L_0x002f
        L_0x002c:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            throw r2
        L_0x002f:
            return r2
        L_0x0030:
            com.google.android.gms.internal.vision.zzcb r2 = com.google.android.gms.internal.vision.zzcb.zzib
            return r2
        L_0x0033:
            r2 = 10
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r0 = "zzbm"
            r2[r3] = r0
            java.lang.String r3 = "zzhu"
            r2[r4] = r3
            r3 = 2
            java.lang.String r4 = "zzhv"
            r2[r3] = r4
            r3 = 3
            java.lang.String r4 = "zzhw"
            r2[r3] = r4
            r3 = 4
            com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzbw.zzal()
            r2[r3] = r4
            r3 = 5
            java.lang.String r4 = "zzhx"
            r2[r3] = r4
            r3 = 6
            com.google.android.gms.internal.vision.zzij r4 = com.google.android.gms.internal.vision.zzcc.zzal()
            r2[r3] = r4
            r3 = 7
            java.lang.String r4 = "zzhy"
            r2[r3] = r4
            r3 = 8
            java.lang.String r4 = "zzhz"
            r2[r3] = r4
            r3 = 9
            java.lang.String r4 = "zzia"
            r2[r3] = r4
            java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဈ\u0006"
            com.google.android.gms.internal.vision.zzcb r4 = com.google.android.gms.internal.vision.zzcb.zzib
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzid.zza(r4, r3, r2)
            return r2
        L_0x0077:
            com.google.android.gms.internal.vision.zzcb$zza r2 = new com.google.android.gms.internal.vision.zzcb$zza
            r2.<init>(r3)
            return r2
        L_0x007d:
            com.google.android.gms.internal.vision.zzcb r2 = new com.google.android.gms.internal.vision.zzcb
            r2.<init>()
            return r2
            switch-data {1->0x007d, 2->0x0077, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzcb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
