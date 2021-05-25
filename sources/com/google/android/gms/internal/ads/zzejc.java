package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class zzejc implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeja zzijy;
    private Iterator<Map.Entry<K, V>> zzijz;

    private zzejc(zzeja zzeja) {
        this.zzijy = zzeja;
        this.pos = zzeja.zzijt.size();
    }

    private final Iterator<Map.Entry<K, V>> zzbhv() {
        if (this.zzijz == null) {
            this.zzijz = this.zzijy.zzijw.entrySet().iterator();
        }
        return this.zzijz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzijy.zzijt.size()) || zzbhv().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzbhv().hasNext()) {
            return (Map.Entry) zzbhv().next();
        }
        List list = this.zzijy.zzijt;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzejc(zzeja zzeja, zzeiz zzeiz) {
        this(zzeja);
    }
}
