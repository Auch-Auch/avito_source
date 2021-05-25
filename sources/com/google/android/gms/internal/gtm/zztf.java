package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;
public final class zztf extends zztl {
    private final /* synthetic */ zztc zzbef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zztf(zztc zztc) {
        super(zztc, null);
        this.zzbef = zztc;
    }

    @Override // com.google.android.gms.internal.gtm.zztl, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzte(this.zzbef, null);
    }

    public /* synthetic */ zztf(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
