package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
public final class nw {
    @NonNull
    private final nz a = new nz();
    @NonNull
    private final oc b = new oc();
    @NonNull
    private final dv c = new dv();

    private static void b(@NonNull FrameLayout frameLayout) {
        View findViewById = frameLayout.findViewById(7845);
        if (findViewById != null) {
            frameLayout.removeView(findViewById);
        }
    }

    public final void a(@NonNull an anVar, @NonNull FrameLayout frameLayout, boolean z) {
        ob obVar = (ob) frameLayout.findViewById(7846);
        if (obVar == null) {
            obVar = new ob(frameLayout.getContext(), this.c);
            obVar.setId(7846);
            frameLayout.addView(obVar);
        }
        obVar.setColor(z ? SupportMenu.CATEGORY_MASK : -16711936);
        if (z) {
            oe oeVar = (oe) frameLayout.findViewById(7845);
            if (oeVar == null) {
                oeVar = new oe(frameLayout.getContext());
                oeVar.setId(7845);
                frameLayout.addView(oeVar);
            }
            oeVar.setDescription(this.a.a(anVar));
            return;
        }
        b(frameLayout);
    }

    public static void a(@NonNull FrameLayout frameLayout) {
        View findViewById = frameLayout.findViewById(7846);
        if (findViewById != null) {
            frameLayout.removeView(findViewById);
        }
        b(frameLayout);
    }
}
