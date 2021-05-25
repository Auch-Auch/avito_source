package com.google.android.gms.internal.vision;
public final class zzeg extends zzee<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzee zznb;

    public zzeg(zzee zzee, int i, int i2) {
        this.zznb = zzee;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzde.zzd(i, this.length);
        return (E) this.zznb.get(i + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzcq() {
        return this.zznb.zzcq();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzcr() {
        return this.zznb.zzcr() + this.offset;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzcs() {
        return this.zznb.zzcr() + this.offset + this.length;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzee
    /* renamed from: zzh */
    public final zzee<E> subList(int i, int i2) {
        zzde.zza(i, i2, this.length);
        zzee zzee = this.zznb;
        int i3 = this.offset;
        return (zzee) zzee.subList(i + i3, i2 + i3);
    }
}
