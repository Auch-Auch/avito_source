package com.bumptech.glide.request.target;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    public final int b;
    public final int c;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.b, this.c)) {
            sizeReadyCallback.onSizeReady(this.b, this.c);
            return;
        }
        StringBuilder L = a.L("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        L.append(this.b);
        L.append(" and height: ");
        throw new IllegalArgumentException(a.j(L, this.c, ", either provide dimensions in the constructor or call override()"));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i, int i2) {
        this.b = i;
        this.c = i2;
    }
}
