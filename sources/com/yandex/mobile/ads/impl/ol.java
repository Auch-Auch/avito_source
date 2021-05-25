package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.r;
import java.util.List;
public final class ol {
    @NonNull
    private final ok a;

    public ol(@NonNull fo foVar, @NonNull cq cqVar, @NonNull oh ohVar, @NonNull ag agVar, @NonNull r rVar) {
        this.a = new ok(foVar, cqVar, ohVar, agVar, rVar);
    }

    public final void a(@NonNull Context context, @Nullable List<pa> list) {
        if (!(list == null || list.isEmpty())) {
            for (pa paVar : list) {
                oj a3 = this.a.a(context, paVar);
                if (a3 != null) {
                    a3.a(context, paVar);
                }
            }
        }
    }
}
