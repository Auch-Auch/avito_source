package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
public final class zzeld implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzele zziqn;

    public zzeld(zzele zzele) {
        this.zziqn = zzele;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos < this.zziqn.zziqo.size() || this.zziqn.zziqp.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zziqn.zziqo.size()) {
            zzele zzele = this.zziqn;
            zzele.zziqo.add(zzele.zziqp.next());
        }
        List<E> list = this.zziqn.zziqo;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
