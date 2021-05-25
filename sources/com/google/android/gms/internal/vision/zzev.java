package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzev<E> extends zzej<E> {
    public static final zzev<Object> zznq = new zzev<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient Object[] zznr;
    private final transient Object[] zzns;
    private final transient int zznt;

    public zzev(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zznr = objArr;
        this.zzns = objArr2;
        this.mask = i2;
        this.zznt = i;
        this.size = i3;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzns;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzf = zzec.zzf(obj);
        while (true) {
            int i = zzf & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzf = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzej, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        return this.zznt;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zznr, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* renamed from: zzcp */
    public final zzfa<E> iterator() {
        return (zzfa) zzct().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzcq() {
        return this.zznr;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzcr() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzcs() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final boolean zzcz() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final zzee<E> zzda() {
        return zzee.zzb(this.zznr, this.size);
    }
}
