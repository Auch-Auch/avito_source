package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.vt;
public class fa {
    @NonNull
    public hl<hk, ey> a(@NonNull ey eyVar) {
        return new hl<>(new hd(eyVar), eyVar);
    }

    @NonNull
    public di<ey> a(@NonNull ey eyVar, @NonNull yc ycVar) {
        return new di<>(eyVar, new yg(ycVar));
    }

    @NonNull
    public vt.a a(@NonNull final yc ycVar) {
        return new vt.a() { // from class: com.yandex.metrica.impl.ob.fa.1
            @Override // com.yandex.metrica.impl.ob.vt.a
            public boolean a(@NonNull vu vuVar, @NonNull bd bdVar) {
                if (TextUtils.isEmpty(vuVar.a)) {
                    return false;
                }
                ycVar.a(vuVar.a, bdVar);
                return false;
            }
        };
    }
}
