package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzrn {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbts;

    @VisibleForTesting
    public zzrn(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbts = i;
    }

    public final float zzml() {
        return this.left;
    }

    public final float zzmm() {
        return this.top;
    }

    public final float zzmn() {
        return this.right;
    }

    public final float zzmo() {
        return this.bottom;
    }

    public final int zzmp() {
        return this.zzbts;
    }
}
