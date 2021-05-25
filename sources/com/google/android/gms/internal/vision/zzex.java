package com.google.android.gms.internal.vision;
public final class zzex<E> extends zzej<E> {
    private final transient E zznu;
    private transient int zznv;

    public zzex(E e) {
        this.zznu = (E) zzde.checkNotNull(e);
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zznu.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzej, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int i = this.zznv;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zznu.hashCode();
        this.zznv = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public final String toString() {
        String obj = this.zznu.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zznu;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* renamed from: zzcp */
    public final zzfa<E> iterator() {
        return new zzeo(this.zznu);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final boolean zzcz() {
        return this.zznv != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final zzee<E> zzda() {
        return zzee.zzg(this.zznu);
    }

    public zzex(E e, int i) {
        this.zznu = e;
        this.zznv = i;
    }
}
