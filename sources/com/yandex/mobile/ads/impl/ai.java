package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.rz;
public final class ai {
    private static volatile ai a;
    private static final Object b = new Object();

    public static ai a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new ai();
                }
            }
        }
        return a;
    }

    public final synchronized void a(Context context, ry ryVar) {
        bv.a(context).a(ryVar);
    }

    public final void a(@NonNull Context context, @NonNull final Object obj) {
        bv.a(context).a(new rz.a() { // from class: com.yandex.mobile.ads.impl.ai.1
            @Override // com.yandex.mobile.ads.impl.rz.a
            public final boolean a(ry<?> ryVar) {
                return obj.equals(ryVar.e());
            }
        });
    }
}
