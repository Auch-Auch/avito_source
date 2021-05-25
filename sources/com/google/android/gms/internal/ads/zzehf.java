package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
public final class zzehf<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzihd;

    public zzehf(Iterator<Map.Entry<K, Object>> it) {
        this.zzihd = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzihd.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzihd.next();
        return next.getValue() instanceof zzehe ? new zzehg(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzihd.remove();
    }
}
