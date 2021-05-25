package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
public final class zzeit implements Iterator<zzefm> {
    private final ArrayDeque<zzeis> zzijg;
    private zzefm zzijh;

    private zzeit(zzeff zzeff) {
        if (zzeff instanceof zzeis) {
            zzeis zzeis = (zzeis) zzeff;
            ArrayDeque<zzeis> arrayDeque = new ArrayDeque<>(zzeis.zzbdn());
            this.zzijg = arrayDeque;
            arrayDeque.push(zzeis);
            this.zzijh = zzak(zzeis.zzijc);
            return;
        }
        this.zzijg = null;
        this.zzijh = (zzefm) zzeff;
    }

    private final zzefm zzak(zzeff zzeff) {
        while (zzeff instanceof zzeis) {
            zzeis zzeis = (zzeis) zzeff;
            this.zzijg.push(zzeis);
            zzeff = zzeis.zzijc;
        }
        return (zzefm) zzeff;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzijh != null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzefm next() {
        zzefm zzefm;
        zzefm zzefm2 = this.zzijh;
        if (zzefm2 != null) {
            while (true) {
                ArrayDeque<zzeis> arrayDeque = this.zzijg;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzefm = zzak(this.zzijg.pop().zzijd);
                    if (!zzefm.isEmpty()) {
                        break;
                    }
                } else {
                    break;
                }
            }
            zzefm = null;
            this.zzijh = zzefm;
            return zzefm2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzeit(zzeff zzeff, zzeir zzeir) {
        this(zzeff);
    }
}
