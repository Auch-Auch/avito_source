package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzegi<T extends zzegk<T>> {
    private static final zzegi zzicw = new zzegi(true);
    public final zzeja<T, Object> zzict;
    private boolean zzicu;
    private boolean zzicv;

    private zzegi() {
        this.zzict = zzeja.zzho(16);
    }

    private final Object zza(T t) {
        Object obj = this.zzict.get(t);
        if (!(obj instanceof zzehe)) {
            return obj;
        }
        zzehe zzehe = (zzehe) obj;
        return zzehe.zzbgl();
    }

    private static Object zzak(Object obj) {
        if (obj instanceof zzeii) {
            return ((zzeii) obj).zzbdc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static <T extends zzegk<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzbff() == zzekh.MESSAGE) {
            if (key.zzbfg()) {
                for (zzehz zzehz : (List) entry.getValue()) {
                    if (!zzehz.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzehz) {
                    if (!((zzehz) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzehe) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static <T extends zzegk<T>> zzegi<T> zzbfc() {
        return zzicw;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzehz zzehz;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzehe) {
            zzehe zzehe = (zzehe) value;
            value = zzehe.zzbgl();
        }
        if (key.zzbfg()) {
            Object zza = zza((zzegi<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzak(obj));
            }
            this.zzict.zza((zzeja<T, Object>) key, (T) zza);
        } else if (key.zzbff() == zzekh.MESSAGE) {
            Object zza2 = zza((zzegi<T>) key);
            if (zza2 == null) {
                this.zzict.zza((zzeja<T, Object>) key, (T) zzak(value));
                return;
            }
            if (zza2 instanceof zzeii) {
                zzehz = key.zza((zzeii) zza2, (zzeii) value);
            } else {
                zzehz = key.zza(((zzehz) zza2).zzbfp(), (zzehz) value).zzbfx();
            }
            this.zzict.zza((zzeja<T, Object>) key, (T) zzehz);
        } else {
            this.zzict.zza((zzeja<T, Object>) key, (T) zzak(value));
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzbff() != zzekh.MESSAGE || key.zzbfg() || key.zzbfh()) {
            return zzb((zzegk<?>) key, value);
        }
        if (value instanceof zzehe) {
            return zzefz.zzb(entry.getKey().zzv(), (zzehe) value);
        }
        return zzefz.zzb(entry.getKey().zzv(), (zzehz) value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzegi zzegi = new zzegi();
        for (int i = 0; i < this.zzict.zzbhq(); i++) {
            Map.Entry<T, Object> zzhp = this.zzict.zzhp(i);
            zzegi.zza((zzegi) zzhp.getKey(), zzhp.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zzict.zzbhr()) {
            zzegi.zza((zzegi) entry.getKey(), entry.getValue());
        }
        zzegi.zzicv = this.zzicv;
        return zzegi;
    }

    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzicv) {
            return new zzehf(this.zzict.zzbhs().iterator());
        }
        return this.zzict.zzbhs().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzegi)) {
            return false;
        }
        return this.zzict.equals(((zzegi) obj).zzict);
    }

    public final int hashCode() {
        return this.zzict.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzicu;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzict.zzbhq(); i++) {
            if (!zzb(this.zzict.zzhp(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zzict.zzbhr()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzicv) {
            return new zzehf(this.zzict.entrySet().iterator());
        }
        return this.zzict.entrySet().iterator();
    }

    public final void zzbdg() {
        if (!this.zzicu) {
            this.zzict.zzbdg();
            this.zzicu = true;
        }
    }

    public final int zzbfd() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzict.zzbhq(); i2++) {
            i += zzd(this.zzict.zzhp(i2));
        }
        for (Map.Entry<T, Object> entry : this.zzict.zzbhr()) {
            i += zzd(entry);
        }
        return i;
    }

    private zzegi(boolean z) {
        this(zzeja.zzho(0));
        zzbdg();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzbfg()) {
            zza(t.zzbfe(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzbfe(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzehe) {
            this.zzicv = true;
        }
        this.zzict.zza((zzeja<T, Object>) t, (T) obj);
    }

    private zzegi(zzeja<T, Object> zzeja) {
        this.zzict = zzeja;
        zzbdg();
    }

    private static int zzb(zzeke zzeke, Object obj) {
        switch (zzegh.zzicc[zzeke.ordinal()]) {
            case 1:
                return zzefz.zzc(((Double) obj).doubleValue());
            case 2:
                return zzefz.zzg(((Float) obj).floatValue());
            case 3:
                return zzefz.zzfl(((Long) obj).longValue());
            case 4:
                return zzefz.zzfm(((Long) obj).longValue());
            case 5:
                return zzefz.zzgr(((Integer) obj).intValue());
            case 6:
                return zzefz.zzfo(((Long) obj).longValue());
            case 7:
                return zzefz.zzgu(((Integer) obj).intValue());
            case 8:
                return zzefz.zzbt(((Boolean) obj).booleanValue());
            case 9:
                return zzefz.zzi((zzehz) obj);
            case 10:
                if (obj instanceof zzehe) {
                    return zzefz.zza((zzehe) obj);
                }
                return zzefz.zzh((zzehz) obj);
            case 11:
                if (obj instanceof zzeff) {
                    return zzefz.zzai((zzeff) obj);
                }
                return zzefz.zzhw((String) obj);
            case 12:
                if (obj instanceof zzeff) {
                    return zzefz.zzai((zzeff) obj);
                }
                return zzefz.zzx((byte[]) obj);
            case 13:
                return zzefz.zzgs(((Integer) obj).intValue());
            case 14:
                return zzefz.zzgv(((Integer) obj).intValue());
            case 15:
                return zzefz.zzfp(((Long) obj).longValue());
            case 16:
                return zzefz.zzgt(((Integer) obj).intValue());
            case 17:
                return zzefz.zzfn(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzegu) {
                    return zzefz.zzgw(((zzegu) obj).zzv());
                }
                return zzefz.zzgw(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzegu) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzehe) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzeke r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzegr.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzegh.zzics
            com.google.android.gms.internal.ads.zzekh r2 = r2.zzbii()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzehz
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzehe
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzegu
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeff
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegi.zza(com.google.android.gms.internal.ads.zzeke, java.lang.Object):void");
    }

    public final void zza(zzegi<T> zzegi) {
        for (int i = 0; i < zzegi.zzict.zzbhq(); i++) {
            zzc(zzegi.zzict.zzhp(i));
        }
        for (Map.Entry<T, Object> entry : zzegi.zzict.zzbhr()) {
            zzc(entry);
        }
    }

    public static void zza(zzefz zzefz, zzeke zzeke, int i, Object obj) throws IOException {
        if (zzeke == zzeke.GROUP) {
            zzehz zzehz = (zzehz) obj;
            zzegr.zzk(zzehz);
            zzefz.writeTag(i, 3);
            zzehz.zzb(zzefz);
            zzefz.writeTag(i, 4);
            return;
        }
        zzefz.writeTag(i, zzeke.zzbij());
        switch (zzegh.zzicc[zzeke.ordinal()]) {
            case 1:
                zzefz.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzefz.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzefz.zzfi(((Long) obj).longValue());
                return;
            case 4:
                zzefz.zzfi(((Long) obj).longValue());
                return;
            case 5:
                zzefz.zzgm(((Integer) obj).intValue());
                return;
            case 6:
                zzefz.zzfk(((Long) obj).longValue());
                return;
            case 7:
                zzefz.zzgp(((Integer) obj).intValue());
                return;
            case 8:
                zzefz.zzbs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzehz) obj).zzb(zzefz);
                return;
            case 10:
                zzefz.zzg((zzehz) obj);
                return;
            case 11:
                if (obj instanceof zzeff) {
                    zzefz.zzah((zzeff) obj);
                    return;
                } else {
                    zzefz.zzhv((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeff) {
                    zzefz.zzah((zzeff) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzefz.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzefz.zzgn(((Integer) obj).intValue());
                return;
            case 14:
                zzefz.zzgp(((Integer) obj).intValue());
                return;
            case 15:
                zzefz.zzfk(((Long) obj).longValue());
                return;
            case 16:
                zzefz.zzgo(((Integer) obj).intValue());
                return;
            case 17:
                zzefz.zzfj(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzegu) {
                    zzefz.zzgm(((zzegu) obj).zzv());
                    return;
                } else {
                    zzefz.zzgm(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zzb(zzegk<?> zzegk, Object obj) {
        zzeke zzbfe = zzegk.zzbfe();
        int zzv = zzegk.zzv();
        if (!zzegk.zzbfg()) {
            return zza(zzbfe, zzv, obj);
        }
        int i = 0;
        if (zzegk.zzbfh()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzbfe, obj2);
            }
            return zzefz.zzgy(i) + zzefz.zzgq(zzv) + i;
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzbfe, zzv, obj3);
        }
        return i;
    }

    public static int zza(zzeke zzeke, int i, Object obj) {
        int zzgq = zzefz.zzgq(i);
        if (zzeke == zzeke.GROUP) {
            zzegr.zzk((zzehz) obj);
            zzgq <<= 1;
        }
        return zzgq + zzb(zzeke, obj);
    }
}
