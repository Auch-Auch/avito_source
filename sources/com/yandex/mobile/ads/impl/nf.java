package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import android.view.View;
public final class nf implements View.OnClickListener {
    private final View a;

    public nf(@Nullable View view) {
        this.a = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2 = this.a;
        if (view2 != null) {
            view2.setSelected(!view2.isSelected());
        }
    }
}
