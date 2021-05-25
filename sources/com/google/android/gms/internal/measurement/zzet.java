package com.google.android.gms.internal.measurement;
public final class zzet<E> extends zzdy<E> {
    private final zzeq<E> zza;

    public zzet(zzeq<E> zzeq, int i) {
        super(zzeq.size(), i);
        this.zza = zzeq;
    }

    @Override // com.google.android.gms.internal.measurement.zzdy
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
