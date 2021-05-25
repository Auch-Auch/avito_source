package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.util.List;
import java.util.Objects;
public final class zzgw {

    public static final class zza extends zzcg<zza, C0211zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        private static final zza zzbir;
        private zzcn<zzb> zzbiq = zzcg.zzbb();

        /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zza  reason: collision with other inner class name */
        public static final class C0211zza extends zzcg.zza<zza, C0211zza> implements zzdq {
            private C0211zza() {
                super(zza.zzbir);
            }

            public /* synthetic */ C0211zza(zzgx zzgx) {
                this();
            }
        }

        public static final class zzb extends zzcg<zzb, C0212zza> implements zzdq {
            private static volatile zzdz<zzb> zzbg;
            private static final zzb zzbiv;
            private int zzbb;
            private String zzbis = "";
            private long zzbit;
            private long zzbiu;
            private int zzya;

            /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0212zza extends zzcg.zza<zzb, C0212zza> implements zzdq {
                private C0212zza() {
                    super(zzb.zzbiv);
                }

                public /* synthetic */ C0212zza(zzgx zzgx) {
                    this();
                }

                public final C0212zza zzn(String str) {
                    zzbf();
                    ((zzb) this.zzjt).zzm(str);
                    return this;
                }

                public final C0212zza zzr(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzp(j);
                    return this;
                }

                public final C0212zza zzs(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzq(j);
                    return this;
                }
            }

            static {
                zzb zzb = new zzb();
                zzbiv = zzb;
                zzcg.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            public static C0212zza zzfz() {
                return (C0212zza) ((zzcg.zza) zzbiv.zza(zzcg.zzg.zzkh, (Object) null, (Object) null));
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzm(String str) {
                Objects.requireNonNull(str);
                this.zzbb |= 2;
                this.zzbis = str;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzp(long j) {
                this.zzbb |= 4;
                this.zzbit = j;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzq(long j) {
                this.zzbb |= 8;
                this.zzbiu = j;
            }

            public final int getEventCode() {
                return this.zzya;
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.clearcut.zzcg
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
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
                    com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg     // Catch:{ all -> 0x002c }
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv     // Catch:{ all -> 0x002c }
                    r2.<init>(r4)     // Catch:{ all -> 0x002c }
                    com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg = r2     // Catch:{ all -> 0x002c }
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
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzbb"
                    r2[r3] = r0
                    java.lang.String r3 = "zzya"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zzbis"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzbit"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzbiu"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003"
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv
                    java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb
                    r2.<init>()
                    return r2
                    switch-data {1->0x005d, 2->0x0057, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }

            public final boolean zzfv() {
                return (this.zzbb & 1) == 1;
            }

            public final String zzfw() {
                return this.zzbis;
            }

            public final long zzfx() {
                return this.zzbit;
            }

            public final long zzfy() {
                return this.zzbiu;
            }
        }

        static {
            zza zza = new zza();
            zzbir = zza;
            zzcg.zza(zza.class, zza);
        }

        private zza() {
        }

        public static zza zzft() {
            return zzbir;
        }

        public static zza zzi(byte[] bArr) throws zzco {
            return (zza) zzcg.zzb(zzbir, bArr);
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.clearcut.zzcg
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
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
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.clearcut.zzgw$zza r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.clearcut.zzgw.zza.zzbg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.clearcut.zzgw$zza r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbiq"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.clearcut.zzgw$zza r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir
                java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.clearcut.zzgw$zza$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.clearcut.zzgw$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza
                r2.<init>()
                return r2
                switch-data {1->0x004e, 2->0x0048, 3->0x0033, 4->0x0030, 5->0x0016, 6->0x0011, 7->0x0010, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final List<zzb> zzfs() {
            return this.zzbiq;
        }
    }
}
