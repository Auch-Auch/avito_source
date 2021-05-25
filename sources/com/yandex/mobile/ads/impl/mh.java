package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
public final class mh extends mk<es, ov> {
    public mh(@NonNull es esVar) {
        super(esVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ void a(@NonNull es esVar) {
        super.a(esVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ boolean a(@NonNull es esVar, @NonNull ov ovVar) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull es esVar, @NonNull ov ovVar) {
        es esVar2 = esVar;
        ov ovVar2 = ovVar;
        String a = ovVar2.a();
        if (!TextUtils.isEmpty(a)) {
            esVar2.setAspectRatio(ovVar2.b());
            esVar2.c(a);
        }
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        es esVar = (es) a();
        if (esVar != null) {
            mqVar.a(oqVar, esVar);
            mqVar.a(oqVar, new mz(esVar));
        }
    }
}
