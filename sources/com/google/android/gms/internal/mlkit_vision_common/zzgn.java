package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;
public final class zzgn extends zzgt {
    private final /* synthetic */ zzgm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzgn(zzgm zzgm) {
        super(zzgm, null);
        this.zza = zzgm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgt, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzgo(this.zza, null);
    }

    public /* synthetic */ zzgn(zzgm zzgm, zzgl zzgl) {
        this(zzgm);
    }
}
