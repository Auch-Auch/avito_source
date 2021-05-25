package com.google.android.gms.internal.mlkit_vision_common;
public final class zzi<E> extends zzh<E> {
    public static final zzh<Object> zza = new zzi(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzi(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzd.zza(i, this.zzc);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh, com.google.android.gms.internal.mlkit_vision_common.zze
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc + 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final int zzd() {
        return this.zzc;
    }
}
