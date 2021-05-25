package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
public final class zzejb extends zzejh {
    private final /* synthetic */ zzeja zzijy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzejb(zzeja zzeja) {
        super(zzeja, null);
        this.zzijy = zzeja;
    }

    @Override // com.google.android.gms.internal.ads.zzejh, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzejc(this.zzijy, null);
    }

    public /* synthetic */ zzejb(zzeja zzeja, zzeiz zzeiz) {
        this(zzeja);
    }
}
