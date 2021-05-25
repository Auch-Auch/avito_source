package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
public final class zzeji implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeja zzijy;
    private Iterator<Map.Entry<K, V>> zzijz;
    private boolean zzikd;

    private zzeji(zzeja zzeja) {
        this.zzijy = zzeja;
        this.pos = -1;
    }

    private final Iterator<Map.Entry<K, V>> zzbhv() {
        if (this.zzijz == null) {
            this.zzijz = this.zzijy.zziju.entrySet().iterator();
        }
        return this.zzijz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.pos + 1 < this.zzijy.zzijt.size() || (!this.zzijy.zziju.isEmpty() && zzbhv().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzikd = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzijy.zzijt.size()) {
            return (Map.Entry) this.zzijy.zzijt.get(this.pos);
        }
        return (Map.Entry) zzbhv().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.zzikd) {
            this.zzikd = false;
            this.zzijy.zzbht();
            if (this.pos < this.zzijy.zzijt.size()) {
                zzeja zzeja = this.zzijy;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzeja.zzhq(i);
                return;
            }
            zzbhv().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public /* synthetic */ zzeji(zzeja zzeja, zzeiz zzeiz) {
        this(zzeja);
    }
}
