package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzfv<T extends zzfx<T>> {
    private static final zzfv zzd = new zzfv(true);
    public final zzig<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfv() {
        this.zza = zzig.zza(16);
    }

    public static <T extends zzfx<T>> zzfv<T> zza() {
        return zzd;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfv zzfv = new zzfv();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzfv.zzb((zzfv) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzfv.zzb((zzfv) entry.getKey(), entry.getValue());
        }
        zzfv.zzc = this.zzc;
        return zzfv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        return this.zza.equals(((zzfv) obj).zza);
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
            return new zzgr(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzgr(this.zza.zze().iterator());
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
        if (!(obj instanceof zzgq)) {
            return obj;
        }
        zzgq zzgq = (zzgq) obj;
        return zzgq.zza();
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzjo.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzfx<?>) key, value);
        }
        if (value instanceof zzgq) {
            return zzfq.zzb(entry.getKey().zza(), (zzgq) value);
        }
        return zzfq.zzb(entry.getKey().zza(), (zzhl) value);
    }

    private zzfv(boolean z) {
        this(zzig.zza(0));
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
        if (obj instanceof zzgq) {
            this.zzc = true;
        }
        this.zza.zza((zzig<T, Object>) t, (T) obj);
    }

    private zzfv(zzig<T, Object> zzig) {
        this.zza = zzig;
        zzb();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzgf) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzgq) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.mlkit_vision_face.zzjh r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_vision_face.zzgg.zza(r3)
            int[] r0 = com.google.android.gms.internal.mlkit_vision_face.zzfy.zza
            com.google.android.gms.internal.mlkit_vision_face.zzjo r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzhl
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzgq
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzgf
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face.zzez
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face.zzfv.zza(com.google.android.gms.internal.mlkit_vision_face.zzjh, java.lang.Object):void");
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzhl zzhl;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgq) {
            zzgq zzgq = (zzgq) value;
            value = zzgq.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzfv<T>) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.zza((zzig<T, Object>) key, (T) zza2);
        } else if (key.zzc() == zzjo.MESSAGE) {
            Object zza3 = zza((zzfv<T>) key);
            if (zza3 == null) {
                this.zza.zza((zzig<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza3 instanceof zzhr) {
                zzhl = key.zza((zzhr) zza3, (zzhr) value);
            } else {
                zzhl = key.zza(((zzhl) zza3).zzm(), (zzhl) value).zzh();
            }
            this.zza.zza((zzig<T, Object>) key, (T) zzhl);
        } else {
            this.zza.zza((zzig<T, Object>) key, (T) zza(value));
        }
    }

    private static <T extends zzfx<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzjo.MESSAGE) {
            if (key.zzd()) {
                for (zzhl zzhl : (List) entry.getValue()) {
                    if (!zzhl.a_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhl) {
                    if (!((zzhl) value).a_()) {
                        return false;
                    }
                } else if (value instanceof zzgq) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfv<T> zzfv) {
        for (int i = 0; i < zzfv.zza.zzc(); i++) {
            zzb(zzfv.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzfv.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzhr) {
            return ((zzhr) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int zzb(zzjh zzjh, Object obj) {
        switch (zzfy.zzb[zzjh.ordinal()]) {
            case 1:
                return zzfq.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfq.zzb(((Float) obj).floatValue());
            case 3:
                return zzfq.zzd(((Long) obj).longValue());
            case 4:
                return zzfq.zze(((Long) obj).longValue());
            case 5:
                return zzfq.zzf(((Integer) obj).intValue());
            case 6:
                return zzfq.zzg(((Long) obj).longValue());
            case 7:
                return zzfq.zzi(((Integer) obj).intValue());
            case 8:
                return zzfq.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzfq.zzc((zzhl) obj);
            case 10:
                if (obj instanceof zzgq) {
                    return zzfq.zza((zzgq) obj);
                }
                return zzfq.zzb((zzhl) obj);
            case 11:
                if (obj instanceof zzez) {
                    return zzfq.zzb((zzez) obj);
                }
                return zzfq.zzb((String) obj);
            case 12:
                if (obj instanceof zzez) {
                    return zzfq.zzb((zzez) obj);
                }
                return zzfq.zzb((byte[]) obj);
            case 13:
                return zzfq.zzg(((Integer) obj).intValue());
            case 14:
                return zzfq.zzj(((Integer) obj).intValue());
            case 15:
                return zzfq.zzh(((Long) obj).longValue());
            case 16:
                return zzfq.zzh(((Integer) obj).intValue());
            case 17:
                return zzfq.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzgf) {
                    return zzfq.zzk(((zzgf) obj).zza());
                }
                return zzfq.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void zza(zzfq zzfq, zzjh zzjh, int i, Object obj) throws IOException {
        if (zzjh == zzjh.GROUP) {
            zzhl zzhl = (zzhl) obj;
            zzgg.zza(zzhl);
            zzfq.zza(i, 3);
            zzhl.zza(zzfq);
            zzfq.zza(i, 4);
            return;
        }
        zzfq.zza(i, zzjh.zzb());
        switch (zzfy.zzb[zzjh.ordinal()]) {
            case 1:
                zzfq.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfq.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfq.zza(((Long) obj).longValue());
                return;
            case 4:
                zzfq.zza(((Long) obj).longValue());
                return;
            case 5:
                zzfq.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzfq.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzfq.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzfq.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhl) obj).zza(zzfq);
                return;
            case 10:
                zzfq.zza((zzhl) obj);
                return;
            case 11:
                if (obj instanceof zzez) {
                    zzfq.zza((zzez) obj);
                    return;
                } else {
                    zzfq.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzez) {
                    zzfq.zza((zzez) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfq.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzfq.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzfq.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzfq.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzfq.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzfq.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzgf) {
                    zzfq.zza(((zzgf) obj).zza());
                    return;
                } else {
                    zzfq.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzjh zzjh, int i, Object obj) {
        int zze = zzfq.zze(i);
        if (zzjh == zzjh.GROUP) {
            zzgg.zza((zzhl) obj);
            zze <<= 1;
        }
        return zze + zzb(zzjh, obj);
    }

    public static int zza(zzfx<?> zzfx, Object obj) {
        zzjh zzb2 = zzfx.zzb();
        int zza2 = zzfx.zza();
        if (!zzfx.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzfx.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzfq.zzl(i) + zzfq.zze(zza2) + i;
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }
}
