package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.aq;
import com.yandex.mobile.ads.nativeads.c;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.w;
public final class np implements ns {
    @Override // com.yandex.mobile.ads.impl.ns
    public final NativeGenericAd a(@NonNull Context context, @NonNull ox oxVar, @NonNull w wVar, @NonNull j jVar, @NonNull c cVar) {
        return new aq(context, oxVar, wVar, jVar, cVar);
    }
}
