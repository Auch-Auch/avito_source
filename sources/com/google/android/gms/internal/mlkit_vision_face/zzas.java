package com.google.android.gms.internal.mlkit_vision_face;
public final class zzas extends zzaq<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaq zzc;

    public zzas(zzaq zzaq, int i, int i2) {
        this.zzc = zzaq;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzj.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzaq
    /* renamed from: zza */
    public final zzaq<E> subList(int i, int i2) {
        zzj.zza(i, i2, this.zzb);
        zzaq zzaq = this.zzc;
        int i3 = this.zza;
        return (zzaq) zzaq.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzao
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }
}
