package com.google.android.gms.internal.ads;
public final class zzdtx extends zzdtg<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhnp;

    public zzdtx(Object[] objArr, int i, int i2) {
        this.zzhnp = objArr;
        this.offset = i;
        this.size = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdsv.zzs(i, this.size);
        return this.zzhnp[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return true;
    }
}
