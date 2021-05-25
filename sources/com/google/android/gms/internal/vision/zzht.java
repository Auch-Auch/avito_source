package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzht<T extends zzhv<T>> {
    private static final zzht zzva = new zzht(true);
    public final zzkg<T, Object> zzux;
    private boolean zzuy;
    private boolean zzuz;

    private zzht() {
        this.zzux = zzkg.zzcb(16);
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzjn zzjn;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzio) {
            zzio zzio = (zzio) value;
            value = zzio.zzhp();
        }
        if (key.zzgo()) {
            Object zza = zza((zzht<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzk(obj));
            }
            this.zzux.zza((zzkg<T, Object>) key, (T) zza);
        } else if (key.zzgn() == zzlr.MESSAGE) {
            Object zza2 = zza((zzht<T>) key);
            if (zza2 == null) {
                this.zzux.zza((zzkg<T, Object>) key, (T) zzk(value));
                return;
            }
            if (zza2 instanceof zzjs) {
                zzjn = key.zza((zzjs) zza2, (zzjs) value);
            } else {
                zzjn = key.zza(((zzjn) zza2).zzhc(), (zzjn) value).zzgw();
            }
            this.zzux.zza((zzkg<T, Object>) key, (T) zzjn);
        } else {
            this.zzux.zza((zzkg<T, Object>) key, (T) zzk(value));
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzgn() != zzlr.MESSAGE || key.zzgo() || key.zzgp()) {
            return zzc(key, value);
        }
        if (value instanceof zzio) {
            return zzhl.zzb(entry.getKey().zzak(), (zzio) value);
        }
        return zzhl.zzb(entry.getKey().zzak(), (zzjn) value);
    }

    public static <T extends zzhv<T>> zzht<T> zzgh() {
        return zzva;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzjs) {
            return ((zzjs) obj).zzeg();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzht zzht = new zzht();
        for (int i = 0; i < this.zzux.zzin(); i++) {
            Map.Entry<T, Object> zzcc = this.zzux.zzcc(i);
            zzht.zza((zzht) zzcc.getKey(), zzcc.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zzux.zzio()) {
            zzht.zza((zzht) entry.getKey(), entry.getValue());
        }
        zzht.zzuz = this.zzuz;
        return zzht;
    }

    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzuz) {
            return new zzit(this.zzux.zzip().iterator());
        }
        return this.zzux.zzip().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzht)) {
            return false;
        }
        return this.zzux.equals(((zzht) obj).zzux);
    }

    public final int hashCode() {
        return this.zzux.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzuy;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzux.zzin(); i++) {
            if (!zzb(this.zzux.zzcc(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zzux.zzio()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzuz) {
            return new zzit(this.zzux.entrySet().iterator());
        }
        return this.zzux.entrySet().iterator();
    }

    public final Object zza(T t) {
        Object obj = this.zzux.get(t);
        if (!(obj instanceof zzio)) {
            return obj;
        }
        zzio zzio = (zzio) obj;
        return zzio.zzhp();
    }

    public final void zzb(T t, Object obj) {
        List list;
        if (t.zzgo()) {
            zza(t.zzgm(), obj);
            Object zza = zza((zzht<T>) t);
            if (zza == null) {
                list = new ArrayList();
                this.zzux.zza((zzkg<T, Object>) t, (T) list);
            } else {
                list = (List) zza;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public final void zzej() {
        if (!this.zzuy) {
            this.zzux.zzej();
            this.zzuy = true;
        }
    }

    public final int zzgi() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzux.zzin(); i2++) {
            i += zzd(this.zzux.zzcc(i2));
        }
        for (Map.Entry<T, Object> entry : this.zzux.zzio()) {
            i += zzd(entry);
        }
        return i;
    }

    private zzht(boolean z) {
        this(zzkg.zzcb(0));
        zzej();
    }

    public final void zza(T t, Object obj) {
        if (!t.zzgo()) {
            zza(t.zzgm(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzgm(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzio) {
            this.zzuz = true;
        }
        this.zzux.zza((zzkg<T, Object>) t, (T) obj);
    }

    private zzht(zzkg<T, Object> zzkg) {
        this.zzux = zzkg;
        zzej();
    }

    private static <T extends zzhv<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzgn() == zzlr.MESSAGE) {
            if (key.zzgo()) {
                for (zzjn zzjn : (List) entry.getValue()) {
                    if (!zzjn.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjn) {
                    if (!((zzjn) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzio) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzih) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzio) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.vision.zzlk r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.vision.zzie.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.vision.zzhw.zzvd
            com.google.android.gms.internal.vision.zzlr r2 = r2.zzjk()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzjn
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzio
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzih
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzgs
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzht.zza(com.google.android.gms.internal.vision.zzlk, java.lang.Object):void");
    }

    private static int zzb(zzlk zzlk, Object obj) {
        switch (zzhw.zztn[zzlk.ordinal()]) {
            case 1:
                return zzhl.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhl.zzt(((Float) obj).floatValue());
            case 3:
                return zzhl.zzv(((Long) obj).longValue());
            case 4:
                return zzhl.zzw(((Long) obj).longValue());
            case 5:
                return zzhl.zzbi(((Integer) obj).intValue());
            case 6:
                return zzhl.zzy(((Long) obj).longValue());
            case 7:
                return zzhl.zzbl(((Integer) obj).intValue());
            case 8:
                return zzhl.zzl(((Boolean) obj).booleanValue());
            case 9:
                return zzhl.zzd((zzjn) obj);
            case 10:
                if (obj instanceof zzio) {
                    return zzhl.zza((zzio) obj);
                }
                return zzhl.zzc((zzjn) obj);
            case 11:
                if (obj instanceof zzgs) {
                    return zzhl.zzb((zzgs) obj);
                }
                return zzhl.zzx((String) obj);
            case 12:
                if (obj instanceof zzgs) {
                    return zzhl.zzb((zzgs) obj);
                }
                return zzhl.zzf((byte[]) obj);
            case 13:
                return zzhl.zzbj(((Integer) obj).intValue());
            case 14:
                return zzhl.zzbm(((Integer) obj).intValue());
            case 15:
                return zzhl.zzz(((Long) obj).longValue());
            case 16:
                return zzhl.zzbk(((Integer) obj).intValue());
            case 17:
                return zzhl.zzx(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzih) {
                    return zzhl.zzbn(((zzih) obj).zzak());
                }
                return zzhl.zzbn(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzhv<?> zzhv, Object obj) {
        zzlk zzgm = zzhv.zzgm();
        int zzak = zzhv.zzak();
        if (!zzhv.zzgo()) {
            return zza(zzgm, zzak, obj);
        }
        int i = 0;
        if (zzhv.zzgp()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzgm, obj2);
            }
            return zzhl.zzbp(i) + zzhl.zzbh(zzak) + i;
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzgm, zzak, obj3);
        }
        return i;
    }

    public final void zza(zzht<T> zzht) {
        for (int i = 0; i < zzht.zzux.zzin(); i++) {
            zzc(zzht.zzux.zzcc(i));
        }
        for (Map.Entry<T, Object> entry : zzht.zzux.zzio()) {
            zzc(entry);
        }
    }

    public static void zza(zzhl zzhl, zzlk zzlk, int i, Object obj) throws IOException {
        if (zzlk == zzlk.GROUP) {
            zzjn zzjn = (zzjn) obj;
            zzie.zzf(zzjn);
            zzhl.writeTag(i, 3);
            zzjn.zzb(zzhl);
            zzhl.writeTag(i, 4);
            return;
        }
        zzhl.writeTag(i, zzlk.zzjl());
        switch (zzhw.zztn[zzlk.ordinal()]) {
            case 1:
                zzhl.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhl.zzs(((Float) obj).floatValue());
                return;
            case 3:
                zzhl.zzs(((Long) obj).longValue());
                return;
            case 4:
                zzhl.zzs(((Long) obj).longValue());
                return;
            case 5:
                zzhl.zzbd(((Integer) obj).intValue());
                return;
            case 6:
                zzhl.zzu(((Long) obj).longValue());
                return;
            case 7:
                zzhl.zzbg(((Integer) obj).intValue());
                return;
            case 8:
                zzhl.zzk(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjn) obj).zzb(zzhl);
                return;
            case 10:
                zzhl.zzb((zzjn) obj);
                return;
            case 11:
                if (obj instanceof zzgs) {
                    zzhl.zza((zzgs) obj);
                    return;
                } else {
                    zzhl.zzw((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgs) {
                    zzhl.zza((zzgs) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhl.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzhl.zzbe(((Integer) obj).intValue());
                return;
            case 14:
                zzhl.zzbg(((Integer) obj).intValue());
                return;
            case 15:
                zzhl.zzu(((Long) obj).longValue());
                return;
            case 16:
                zzhl.zzbf(((Integer) obj).intValue());
                return;
            case 17:
                zzhl.zzt(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzih) {
                    zzhl.zzbd(((zzih) obj).zzak());
                    return;
                } else {
                    zzhl.zzbd(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zza(zzlk zzlk, int i, Object obj) {
        int zzbh = zzhl.zzbh(i);
        if (zzlk == zzlk.GROUP) {
            zzie.zzf((zzjn) obj);
            zzbh <<= 1;
        }
        return zzbh + zzb(zzlk, obj);
    }
}
