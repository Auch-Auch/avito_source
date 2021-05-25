package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class jf implements jd {
    @Override // com.yandex.mobile.ads.impl.jd
    @NonNull
    public final ja a(@NonNull ev evVar, @NonNull er erVar, @NonNull ej ejVar, @NonNull jk jkVar) {
        jh jhVar = new jh(evVar, erVar, ejVar, jkVar);
        jhVar.a(erVar);
        return jhVar;
    }

    @Override // com.yandex.mobile.ads.impl.jd
    @NonNull
    public final iz a(@NonNull ev evVar, @NonNull er erVar, @NonNull jl jlVar, @NonNull eu euVar, @NonNull jk jkVar) {
        jg jgVar = new jg(evVar, erVar, jlVar, euVar, jkVar);
        jgVar.a(erVar);
        return jgVar;
    }

    @Override // com.yandex.mobile.ads.impl.jd
    @NonNull
    public final ja a(@NonNull ev evVar, @NonNull er erVar) {
        jj jjVar = new jj(evVar, erVar);
        jjVar.a(erVar);
        return jjVar;
    }
}
