package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzeb<T extends zzed<T>> {
    private static final zzeb zzd = new zzeb(true);
    public final zzgm<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzeb() {
        this.zza = zzgm.zza(16);
    }

    public static <T extends zzed<T>> zzeb<T> zza() {
        return zzd;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeb zzeb = new zzeb();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzeb.zzb((zzeb) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzeb.zzb((zzeb) entry.getKey(), entry.getValue());
        }
        zzeb.zzc = this.zzc;
        return zzeb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return false;
        }
        return this.zza.equals(((zzeb) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzex(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzex(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzew)) {
            return obj;
        }
        zzew zzew = (zzew) obj;
        return zzew.zza();
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzhu.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzed<?>) key, value);
        }
        if (value instanceof zzew) {
            return zzdw.zzb(entry.getKey().zza(), (zzew) value);
        }
        return zzdw.zzb(entry.getKey().zza(), (zzfr) value);
    }

    private zzeb(boolean z) {
        this(zzgm.zza(0));
        zzb();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzew) {
            this.zzc = true;
        }
        this.zza.zza((zzgm<T, Object>) t, (T) obj);
    }

    private zzeb(zzgm<T, Object> zzgm) {
        this.zza = zzgm;
        zzb();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzel) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzew) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.mlkit_vision_common.zzhn r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_vision_common.zzem.zza(r3)
            int[] r0 = com.google.android.gms.internal.mlkit_vision_common.zzee.zza
            com.google.android.gms.internal.mlkit_vision_common.zzhu r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzfr
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzew
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzel
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_common.zzdf
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
            switch-data {1->0x0040, 2->0x003d, 3->0x003a, 4->0x0037, 5->0x0034, 6->0x0031, 7->0x0028, 8->0x001f, 9->0x0016, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzeb.zza(com.google.android.gms.internal.mlkit_vision_common.zzhn, java.lang.Object):void");
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzfr zzfr;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzew) {
            zzew zzew = (zzew) value;
            value = zzew.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzeb<T>) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.zza((zzgm<T, Object>) key, (T) zza2);
        } else if (key.zzc() == zzhu.MESSAGE) {
            Object zza3 = zza((zzeb<T>) key);
            if (zza3 == null) {
                this.zza.zza((zzgm<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza3 instanceof zzfx) {
                zzfr = key.zza((zzfx) zza3, (zzfx) value);
            } else {
                zzfr = key.zza(((zzfr) zza3).zzm(), (zzfr) value).zzh();
            }
            this.zza.zza((zzgm<T, Object>) key, (T) zzfr);
        } else {
            this.zza.zza((zzgm<T, Object>) key, (T) zza(value));
        }
    }

    private static <T extends zzed<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzhu.MESSAGE) {
            if (key.zzd()) {
                for (zzfr zzfr : (List) entry.getValue()) {
                    if (!zzfr.a_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzfr) {
                    if (!((zzfr) value).a_()) {
                        return false;
                    }
                } else if (value instanceof zzew) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzeb<T> zzeb) {
        for (int i = 0; i < zzeb.zza.zzc(); i++) {
            zzb(zzeb.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzeb.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzfx) {
            return ((zzfx) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int zzb(zzhn zzhn, Object obj) {
        switch (zzee.zzb[zzhn.ordinal()]) {
            case 1:
                return zzdw.zzb(((Double) obj).doubleValue());
            case 2:
                return zzdw.zzb(((Float) obj).floatValue());
            case 3:
                return zzdw.zzd(((Long) obj).longValue());
            case 4:
                return zzdw.zze(((Long) obj).longValue());
            case 5:
                return zzdw.zzf(((Integer) obj).intValue());
            case 6:
                return zzdw.zzg(((Long) obj).longValue());
            case 7:
                return zzdw.zzi(((Integer) obj).intValue());
            case 8:
                return zzdw.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzdw.zzc((zzfr) obj);
            case 10:
                if (obj instanceof zzew) {
                    return zzdw.zza((zzew) obj);
                }
                return zzdw.zzb((zzfr) obj);
            case 11:
                if (obj instanceof zzdf) {
                    return zzdw.zzb((zzdf) obj);
                }
                return zzdw.zzb((String) obj);
            case 12:
                if (obj instanceof zzdf) {
                    return zzdw.zzb((zzdf) obj);
                }
                return zzdw.zzb((byte[]) obj);
            case 13:
                return zzdw.zzg(((Integer) obj).intValue());
            case 14:
                return zzdw.zzj(((Integer) obj).intValue());
            case 15:
                return zzdw.zzh(((Long) obj).longValue());
            case 16:
                return zzdw.zzh(((Integer) obj).intValue());
            case 17:
                return zzdw.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzel) {
                    return zzdw.zzk(((zzel) obj).zza());
                }
                return zzdw.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void zza(zzdw zzdw, zzhn zzhn, int i, Object obj) throws IOException {
        if (zzhn == zzhn.GROUP) {
            zzfr zzfr = (zzfr) obj;
            zzem.zza(zzfr);
            zzdw.zza(i, 3);
            zzfr.zza(zzdw);
            zzdw.zza(i, 4);
            return;
        }
        zzdw.zza(i, zzhn.zzb());
        switch (zzee.zzb[zzhn.ordinal()]) {
            case 1:
                zzdw.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzdw.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzdw.zza(((Long) obj).longValue());
                return;
            case 4:
                zzdw.zza(((Long) obj).longValue());
                return;
            case 5:
                zzdw.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzdw.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzdw.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzdw.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzfr) obj).zza(zzdw);
                return;
            case 10:
                zzdw.zza((zzfr) obj);
                return;
            case 11:
                if (obj instanceof zzdf) {
                    zzdw.zza((zzdf) obj);
                    return;
                } else {
                    zzdw.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdf) {
                    zzdw.zza((zzdf) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzdw.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzdw.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzdw.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzdw.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzdw.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzdw.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzel) {
                    zzdw.zza(((zzel) obj).zza());
                    return;
                } else {
                    zzdw.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzhn zzhn, int i, Object obj) {
        int zze = zzdw.zze(i);
        if (zzhn == zzhn.GROUP) {
            zzem.zza((zzfr) obj);
            zze <<= 1;
        }
        return zze + zzb(zzhn, obj);
    }

    public static int zza(zzed<?> zzed, Object obj) {
        zzhn zzb2 = zzed.zzb();
        int zza2 = zzed.zza();
        if (!zzed.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzed.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzdw.zzl(i) + zzdw.zze(zza2) + i;
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }
}
