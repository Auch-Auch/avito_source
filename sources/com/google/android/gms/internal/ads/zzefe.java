package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
public final class zzefe extends zzefg {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzeff zzibc;

    public zzefe(zzeff zzeff) {
        this.zzibc = zzeff;
        this.limit = zzeff.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzefk
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzibc.zzfv(i);
        }
        throw new NoSuchElementException();
    }
}
