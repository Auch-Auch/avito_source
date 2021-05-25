package com.google.android.gms.internal.mlkit_vision_face;
public final class zzbe<E> extends zzaq<E> {
    public static final zzaq<Object> zza = new zzbe(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzbe(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzj.zza(i, this.zzc);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzaq, com.google.android.gms.internal.mlkit_vision_face.zzao
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc + 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final int zzd() {
        return this.zzc;
    }
}
