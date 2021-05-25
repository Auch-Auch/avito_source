package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzfl<T extends zzfn<T>> {
    private static final zzfl zzd = new zzfl(true);
    public final zzhs<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfl() {
        this.zza = zzhs.zza(16);
    }

    public static <T extends zzfn<T>> zzfl<T> zza() {
        return zzd;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfl zzfl = new zzfl();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzfl.zzb((zzfl) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzfl.zzb((zzfl) entry.getKey(), entry.getValue());
        }
        zzfl.zzc = this.zzc;
        return zzfl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        return this.zza.equals(((zzfl) obj).zza);
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
            return new zzgh(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzgh(this.zza.zze().iterator());
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
        if (!(obj instanceof zzgc)) {
            return obj;
        }
        zzgc zzgc = (zzgc) obj;
        return zzgc.zza();
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzja.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzfn<?>) key, value);
        }
        if (value instanceof zzgc) {
            return zzfc.zzb(entry.getKey().zza(), (zzgc) value);
        }
        return zzfc.zzb(entry.getKey().zza(), (zzhb) value);
    }

    private zzfl(boolean z) {
        this(zzhs.zza(0));
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
        if (obj instanceof zzgc) {
            this.zzc = true;
        }
        this.zza.zza((zzhs<T, Object>) t, (T) obj);
    }

    private zzfl(zzhs<T, Object> zzhs) {
        this.zza = zzhs;
        zzb();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_common.zzfv) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.mlkit_common.zzgc) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.mlkit_common.zzix r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_common.zzfs.zza(r3)
            int[] r0 = com.google.android.gms.internal.mlkit_common.zzfk.zza
            com.google.android.gms.internal.mlkit_common.zzja r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzhb
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzgc
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzfv
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.mlkit_common.zzep
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzfl.zza(com.google.android.gms.internal.mlkit_common.zzix, java.lang.Object):void");
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzhb zzhb;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgc) {
            zzgc zzgc = (zzgc) value;
            value = zzgc.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzfl<T>) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.zza((zzhs<T, Object>) key, (T) zza2);
        } else if (key.zzc() == zzja.MESSAGE) {
            Object zza3 = zza((zzfl<T>) key);
            if (zza3 == null) {
                this.zza.zza((zzhs<T, Object>) key, (T) zza(value));
                return;
            }
            if (zza3 instanceof zzhh) {
                zzhb = key.zza((zzhh) zza3, (zzhh) value);
            } else {
                zzhb = key.zza(((zzhb) zza3).zzm(), (zzhb) value).zzg();
            }
            this.zza.zza((zzhs<T, Object>) key, (T) zzhb);
        } else {
            this.zza.zza((zzhs<T, Object>) key, (T) zza(value));
        }
    }

    private static <T extends zzfn<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzja.MESSAGE) {
            if (key.zzd()) {
                for (zzhb zzhb : (List) entry.getValue()) {
                    if (!zzhb.zzi()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhb) {
                    if (!((zzhb) value).zzi()) {
                        return false;
                    }
                } else if (value instanceof zzgc) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfl<T> zzfl) {
        for (int i = 0; i < zzfl.zza.zzc(); i++) {
            zzb(zzfl.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzfl.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzhh) {
            return ((zzhh) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int zzb(zzix zzix, Object obj) {
        switch (zzfk.zzb[zzix.ordinal()]) {
            case 1:
                return zzfc.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfc.zzb(((Float) obj).floatValue());
            case 3:
                return zzfc.zzd(((Long) obj).longValue());
            case 4:
                return zzfc.zze(((Long) obj).longValue());
            case 5:
                return zzfc.zzf(((Integer) obj).intValue());
            case 6:
                return zzfc.zzg(((Long) obj).longValue());
            case 7:
                return zzfc.zzi(((Integer) obj).intValue());
            case 8:
                return zzfc.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzfc.zzc((zzhb) obj);
            case 10:
                if (obj instanceof zzgc) {
                    return zzfc.zza((zzgc) obj);
                }
                return zzfc.zzb((zzhb) obj);
            case 11:
                if (obj instanceof zzep) {
                    return zzfc.zzb((zzep) obj);
                }
                return zzfc.zzb((String) obj);
            case 12:
                if (obj instanceof zzep) {
                    return zzfc.zzb((zzep) obj);
                }
                return zzfc.zzb((byte[]) obj);
            case 13:
                return zzfc.zzg(((Integer) obj).intValue());
            case 14:
                return zzfc.zzj(((Integer) obj).intValue());
            case 15:
                return zzfc.zzh(((Long) obj).longValue());
            case 16:
                return zzfc.zzh(((Integer) obj).intValue());
            case 17:
                return zzfc.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfv) {
                    return zzfc.zzk(((zzfv) obj).zza());
                }
                return zzfc.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void zza(zzfc zzfc, zzix zzix, int i, Object obj) throws IOException {
        if (zzix == zzix.GROUP) {
            zzhb zzhb = (zzhb) obj;
            zzfs.zza(zzhb);
            zzfc.zza(i, 3);
            zzhb.zza(zzfc);
            zzfc.zza(i, 4);
            return;
        }
        zzfc.zza(i, zzix.zzb());
        switch (zzfk.zzb[zzix.ordinal()]) {
            case 1:
                zzfc.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfc.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfc.zza(((Long) obj).longValue());
                return;
            case 4:
                zzfc.zza(((Long) obj).longValue());
                return;
            case 5:
                zzfc.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzfc.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzfc.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzfc.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhb) obj).zza(zzfc);
                return;
            case 10:
                zzfc.zza((zzhb) obj);
                return;
            case 11:
                if (obj instanceof zzep) {
                    zzfc.zza((zzep) obj);
                    return;
                } else {
                    zzfc.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzep) {
                    zzfc.zza((zzep) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfc.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzfc.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzfc.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzfc.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzfc.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzfc.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfv) {
                    zzfc.zza(((zzfv) obj).zza());
                    return;
                } else {
                    zzfc.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzix zzix, int i, Object obj) {
        int zze = zzfc.zze(i);
        if (zzix == zzix.GROUP) {
            zzfs.zza((zzhb) obj);
            zze <<= 1;
        }
        return zze + zzb(zzix, obj);
    }

    public static int zza(zzfn<?> zzfn, Object obj) {
        zzix zzb2 = zzfn.zzb();
        int zza2 = zzfn.zza();
        if (!zzfn.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzfn.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzfc.zzl(i) + zzfc.zze(zza2) + i;
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }
}
