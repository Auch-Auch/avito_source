package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.fk;
import com.yandex.metrica.impl.ob.fn;
public class fu<COMPONENT extends fn & fk> implements fh<ft> {
    @NonNull
    private final gk<COMPONENT> a;

    public fu(@NonNull gk<COMPONENT> gkVar) {
        this.a = gkVar;
    }

    /* renamed from: a */
    public ft b(@NonNull Context context, @NonNull fb fbVar, @NonNull ew ewVar) {
        return new ft(context, fbVar, ewVar, this.a);
    }
}
