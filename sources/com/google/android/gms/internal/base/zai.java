package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
public final class zai extends Drawable.ConstantState {
    private zai() {
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return zaf.zaa;
    }
}
