package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzft<E> extends zzey<E> {
    public static final zzft<Object> zza = new zzft<>(new Object[0], 0, null, 0, 0);
    private final transient Object[] zzb;
    private final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    public zzft(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i2;
        this.zze = i;
        this.zzf = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int zza2 = zzeo.zza(obj);
        while (true) {
            int i = zza2 & this.zzd;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<E> iterator() {
        return (zzfz) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzeq<E> zzd() {
        return zzeq.zza(this.zzb, this.zzf);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzf);
        return i + this.zzf;
    }
}
