package com.google.android.gms.internal.vision;
public final class zzew extends zzee<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zznd;

    public zzew(Object[] objArr, int i, int i2) {
        this.zznd = objArr;
        this.offset = i;
        this.size = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzde.zzd(i, this.size);
        return this.zznd[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return true;
    }
}
