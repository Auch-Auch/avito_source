package com.google.android.gms.internal.vision;
public final class zzed<E> extends zzdm<E> {
    private final zzee<E> zzmv;

    public zzed(zzee<E> zzee, int i) {
        super(zzee.size(), i);
        this.zzmv = zzee;
    }

    @Override // com.google.android.gms.internal.vision.zzdm
    public final E get(int i) {
        return this.zzmv.get(i);
    }
}
