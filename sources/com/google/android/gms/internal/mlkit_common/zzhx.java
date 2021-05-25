package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;
public final class zzhx extends zzid {
    private final /* synthetic */ zzhs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzhx(zzhs zzhs) {
        super(zzhs, null);
        this.zza = zzhs;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhu(this.zza, null);
    }

    public /* synthetic */ zzhx(zzhs zzhs, zzhv zzhv) {
        this(zzhs);
    }
}
