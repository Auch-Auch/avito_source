package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;
public final class zzgv extends zzgx {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzgs zztw;

    public zzgv(zzgs zzgs) {
        this.zztw = zzgs;
        this.limit = zzgs.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzhb
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zztw.zzav(i);
        }
        throw new NoSuchElementException();
    }
}
