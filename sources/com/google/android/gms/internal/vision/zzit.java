package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;
public final class zzit<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzzq;

    public zzit(Iterator<Map.Entry<K, Object>> it) {
        this.zzzq = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzzq.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzzq.next();
        return next.getValue() instanceof zzio ? new zziq(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzzq.remove();
    }
}
