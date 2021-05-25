package com.google.android.gms.internal.mlkit_vision_face;

import java.util.List;
import java.util.ListIterator;
public final class zzw extends zzu implements ListIterator<V> {
    private final /* synthetic */ zzx zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzw(zzx zzx) {
        super(zzx);
        this.zzb = zzx;
    }

    private final ListIterator<V> zzb() {
        zza();
        return (ListIterator) this.zza;
    }

    @Override // java.util.ListIterator
    public final void add(V v) {
        boolean isEmpty = this.zzb.isEmpty();
        zzb().add(v);
        zzm.zzc(this.zzb.zzd);
        if (isEmpty) {
            this.zzb.zzc();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return zzb().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return zzb().nextIndex();
    }

    @Override // java.util.ListIterator
    public final V previous() {
        return (V) zzb().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return zzb().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(V v) {
        zzb().set(v);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzw(zzx zzx, int i) {
        super(zzx, ((List) zzx.zzb).listIterator(i));
        this.zzb = zzx;
    }
}
