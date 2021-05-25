package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzak extends zzz<K, V> {
    @NullableDecl
    private final K zza;
    private int zzb;
    private final /* synthetic */ zzaf zzc;

    public zzak(zzaf zzaf, int i) {
        this.zzc = zzaf;
        this.zza = (K) zzaf.zzb[i];
        this.zzb = i;
    }

    private final void zza() {
        int i = this.zzb;
        if (i == -1 || i >= this.zzc.size() || !zzh.zza(this.zza, this.zzc.zzb[this.zzb])) {
            this.zzb = this.zzc.zza((Object) this.zza);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        Map zzb2 = this.zzc.zzb();
        if (zzb2 != null) {
            return (V) zzb2.get(this.zza);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return (V) this.zzc.zzc[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzz, java.util.Map.Entry
    public final V setValue(V v) {
        Map zzb2 = this.zzc.zzb();
        if (zzb2 != null) {
            return (V) zzb2.put(this.zza, v);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            this.zzc.put(this.zza, v);
            return null;
        }
        Object[] objArr = this.zzc.zzc;
        V v2 = (V) objArr[i];
        objArr[i] = v;
        return v2;
    }
}
