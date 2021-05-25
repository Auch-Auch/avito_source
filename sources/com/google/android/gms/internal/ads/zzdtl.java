package com.google.android.gms.internal.ads;
public final class zzdtl extends zzdtg<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdtg zzhnh;

    public zzdtl(zzdtg zzdtg, int i, int i2) {
        this.zzhnh = zzdtg;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdsv.zzs(i, this.length);
        return (E) this.zzhnh.get(i + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final Object[] zzawo() {
        return this.zzhnh.zzawo();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zzawp() {
        return this.zzhnh.zzawp() + this.offset;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zzawq() {
        return this.zzhnh.zzawp() + this.offset + this.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdtg
    /* renamed from: zzu */
    public final zzdtg<E> subList(int i, int i2) {
        zzdsv.zzf(i, i2, this.length);
        zzdtg zzdtg = this.zzhnh;
        int i3 = this.offset;
        return (zzdtg) zzdtg.subList(i + i3, i2 + i3);
    }
}
