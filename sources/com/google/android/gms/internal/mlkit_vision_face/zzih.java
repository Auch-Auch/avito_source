package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Map;
public final class zzih extends zzin {
    private final /* synthetic */ zzig zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzih(zzig zzig) {
        super(zzig, null);
        this.zza = zzig;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzin, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzii(this.zza, null);
    }

    public /* synthetic */ zzih(zzig zzig, zzif zzif) {
        this(zzig);
    }
}
