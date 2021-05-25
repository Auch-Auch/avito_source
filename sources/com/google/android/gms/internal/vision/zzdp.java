package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdp<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzmf = new Object();
    private transient int size;
    @NullableDecl
    private transient Object zzmg;
    @NullableDecl
    public transient int[] zzmh;
    @NullableDecl
    public transient Object[] zzmi;
    @NullableDecl
    public transient Object[] zzmj;
    private transient int zzmk = zzfc.zzc(3, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    @NullableDecl
    private transient Set<K> zzml;
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzmm;
    @NullableDecl
    private transient Collection<V> zzmn;

    public zzdp() {
        zzde.checkArgument(true, "Expected size must be >= 0");
    }

    /* access modifiers changed from: private */
    public final int indexOf(@NullableDecl Object obj) {
        if (zzce()) {
            return -1;
        }
        int zzf = zzec.zzf(obj);
        int zzcg = zzcg();
        int zza = zzea.zza(this.zzmg, zzf & zzcg);
        if (zza == 0) {
            return -1;
        }
        int i = ~zzcg;
        int i2 = zzf & i;
        do {
            int i3 = zza - 1;
            int i4 = this.zzmh[i3];
            if ((i4 & i) == i2 && zzcz.equal(obj, this.zzmi[i3])) {
                return i3;
            }
            zza = i4 & zzcg;
        } while (zza != 0);
        return -1;
    }

    private final int zza(int i, int i2, int i3, int i4) {
        Object zzv = zzea.zzv(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzea.zza(zzv, i3 & i5, i4 + 1);
        }
        Object obj = this.zzmg;
        int[] iArr = this.zzmh;
        for (int i6 = 0; i6 <= i; i6++) {
            int zza = zzea.zza(obj, i6);
            while (zza != 0) {
                int i7 = zza - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zza2 = zzea.zza(zzv, i10);
                zzea.zza(zzv, i10, zza);
                iArr[i7] = zzea.zzb(i9, zza2, i5);
                zza = i8 & i;
            }
        }
        this.zzmg = zzv;
        zzs(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final int zzcg() {
        return (1 << (this.zzmk & 31)) - 1;
    }

    public static /* synthetic */ int zzd(zzdp zzdp) {
        int i = zzdp.size;
        zzdp.size = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public final Object zze(@NullableDecl Object obj) {
        if (zzce()) {
            return zzmf;
        }
        int zzcg = zzcg();
        int zza = zzea.zza(obj, null, zzcg, this.zzmg, this.zzmh, this.zzmi, null);
        if (zza == -1) {
            return zzmf;
        }
        Object obj2 = this.zzmj[zza];
        zzf(zza, zzcg);
        this.size--;
        zzch();
        return obj2;
    }

    public static int zzg(int i, int i2) {
        return i - 1;
    }

    private final void zzs(int i) {
        this.zzmk = zzea.zzb(this.zzmk, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (!zzce()) {
            zzch();
            Map<K, V> zzcf = zzcf();
            if (zzcf != null) {
                this.zzmk = zzfc.zzc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                zzcf.clear();
                this.zzmg = null;
                this.size = 0;
                return;
            }
            Arrays.fill(this.zzmi, 0, this.size, (Object) null);
            Arrays.fill(this.zzmj, 0, this.size, (Object) null);
            Object obj = this.zzmg;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, (short) 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zzmh, 0, this.size, 0);
            this.size = 0;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.containsValue(obj);
        }
        for (int i = 0; i < this.size; i++) {
            if (zzcz.equal(obj, this.zzmj[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzmm;
        if (set != null) {
            return set;
        }
        zzdt zzdt = new zzdt(this);
        this.zzmm = zzdt;
        return zzdt;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.zzmj[indexOf];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.zzml;
        if (set != null) {
            return set;
        }
        zzdv zzdv = new zzdv(this);
        this.zzml = zzdv;
        return zzdv;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int min;
        if (zzce()) {
            zzde.checkState(zzce(), "Arrays already allocated");
            int i = this.zzmk;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            int max2 = Math.max(4, (max <= ((int) (((double) highestOneBit) * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) ? highestOneBit : 1073741824);
            this.zzmg = zzea.zzv(max2);
            zzs(max2 - 1);
            this.zzmh = new int[i];
            this.zzmi = new Object[i];
            this.zzmj = new Object[i];
        }
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.put(k, v);
        }
        int[] iArr = this.zzmh;
        Object[] objArr = this.zzmi;
        Object[] objArr2 = this.zzmj;
        int i2 = this.size;
        int i3 = i2 + 1;
        int zzf = zzec.zzf(k);
        int zzcg = zzcg();
        int i4 = zzf & zzcg;
        int zza = zzea.zza(this.zzmg, i4);
        if (zza != 0) {
            int i5 = ~zzcg;
            int i6 = zzf & i5;
            int i7 = 0;
            while (true) {
                int i8 = zza - 1;
                int i9 = iArr[i8];
                if ((i9 & i5) != i6 || !zzcz.equal(k, objArr[i8])) {
                    int i10 = i9 & zzcg;
                    int i11 = i7 + 1;
                    if (i10 != 0) {
                        i7 = i11;
                        zza = i10;
                        objArr = objArr;
                    } else if (i11 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzcg() + 1, 1.0f);
                        int zzci = zzci();
                        while (zzci >= 0) {
                            linkedHashMap.put(this.zzmi[zzci], this.zzmj[zzci]);
                            zzci = zzt(zzci);
                        }
                        this.zzmg = linkedHashMap;
                        this.zzmh = null;
                        this.zzmi = null;
                        this.zzmj = null;
                        zzch();
                        return (V) linkedHashMap.put(k, v);
                    } else if (i3 > zzcg) {
                        zzcg = zza(zzcg, zzea.zzw(zzcg), zzf, i2);
                    } else {
                        iArr[i8] = zzea.zzb(i9, i3, zzcg);
                    }
                } else {
                    V v2 = (V) objArr2[i8];
                    objArr2[i8] = v;
                    return v2;
                }
            }
        } else if (i3 > zzcg) {
            zzcg = zza(zzcg, zzea.zzw(zzcg), zzf, i2);
        } else {
            zzea.zza(this.zzmg, i4, i3);
        }
        int length = this.zzmh.length;
        if (i3 > length && (min = Math.min((int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.zzmh = Arrays.copyOf(this.zzmh, min);
            this.zzmi = Arrays.copyOf(this.zzmi, min);
            this.zzmj = Arrays.copyOf(this.zzmj, min);
        }
        this.zzmh[i2] = zzea.zzb(zzf, 0, zzcg);
        this.zzmi[i2] = k;
        this.zzmj[i2] = v;
        this.size = i3;
        zzch();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.remove(obj);
        }
        V v = (V) zze(obj);
        if (v == zzmf) {
            return null;
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> zzcf = zzcf();
        return zzcf != null ? zzcf.size() : this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzmn;
        if (collection != null) {
            return collection;
        }
        zzdx zzdx = new zzdx(this);
        this.zzmn = zzdx;
        return zzdx;
    }

    public final boolean zzce() {
        return this.zzmg == null;
    }

    @NullableDecl
    public final Map<K, V> zzcf() {
        Object obj = this.zzmg;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzch() {
        this.zzmk += 32;
    }

    public final int zzci() {
        return isEmpty() ? -1 : 0;
    }

    public final Iterator<K> zzcj() {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.keySet().iterator();
        }
        return new zzds(this);
    }

    public final Iterator<Map.Entry<K, V>> zzck() {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.entrySet().iterator();
        }
        return new zzdr(this);
    }

    public final Iterator<V> zzcl() {
        Map<K, V> zzcf = zzcf();
        if (zzcf != null) {
            return zzcf.values().iterator();
        }
        return new zzdu(this);
    }

    public final void zzf(int i, int i2) {
        int size2 = size() - 1;
        if (i < size2) {
            Object[] objArr = this.zzmi;
            Object obj = objArr[size2];
            objArr[i] = obj;
            Object[] objArr2 = this.zzmj;
            objArr2[i] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            int[] iArr = this.zzmh;
            iArr[i] = iArr[size2];
            iArr[size2] = 0;
            int zzf = zzec.zzf(obj) & i2;
            int zza = zzea.zza(this.zzmg, zzf);
            int i3 = size2 + 1;
            if (zza == i3) {
                zzea.zza(this.zzmg, zzf, i + 1);
                return;
            }
            while (true) {
                int i4 = zza - 1;
                int[] iArr2 = this.zzmh;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == i3) {
                    iArr2[i4] = zzea.zzb(i5, i + 1, i2);
                    return;
                }
                zza = i6;
            }
        } else {
            this.zzmi[i] = null;
            this.zzmj[i] = null;
            this.zzmh[i] = 0;
        }
    }

    public final int zzt(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }
}
