package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
public final class zzeir extends zzefg {
    private final zzeit zziix;
    private zzefk zziiy = zzbhj();
    private final /* synthetic */ zzeis zziiz;

    public zzeir(zzeis zzeis) {
        this.zziiz = zzeis;
        this.zziix = new zzeit(zzeis, null);
    }

    private final zzefk zzbhj() {
        if (this.zziix.hasNext()) {
            return (zzefk) ((zzefm) this.zziix.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zziiy != null;
    }

    @Override // com.google.android.gms.internal.ads.zzefk
    public final byte nextByte() {
        zzefk zzefk = this.zziiy;
        if (zzefk != null) {
            byte nextByte = zzefk.nextByte();
            if (!this.zziiy.hasNext()) {
                this.zziiy = zzbhj();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
