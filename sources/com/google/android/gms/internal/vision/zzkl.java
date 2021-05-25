package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;
public final class zzkl extends zzkr {
    private final /* synthetic */ zzkg zzabv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkl(zzkg zzkg) {
        super(zzkg, null);
        this.zzabv = zzkg;
    }

    @Override // com.google.android.gms.internal.vision.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzki(this.zzabv, null);
    }

    public /* synthetic */ zzkl(zzkg zzkg, zzkj zzkj) {
        this(zzkg);
    }
}
