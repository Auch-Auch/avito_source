package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import com.yandex.mobile.ads.impl.an;
import java.util.ArrayList;
import java.util.List;
public final class nv {
    @NonNull
    private static final List<an.a> a = new ArrayList<an.a>() { // from class: com.yandex.mobile.ads.impl.nv.1
        {
            add(an.a.SUCCESS);
            add(an.a.APPLICATION_INACTIVE);
            add(an.a.NOT_ADDED_TO_HIERARCHY);
        }
    };
    @NonNull
    private final nw b = new nw();

    public final void a(@NonNull an anVar, @NonNull FrameLayout frameLayout) {
        an.a b2 = anVar.b();
        this.b.a(anVar, frameLayout, !a.contains(b2));
    }
}
