package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.MediaView;
public final class mn extends mf {
    @NonNull
    private final ml<es, ov> a;

    public mn(@NonNull MediaView mediaView, @NonNull mh mhVar) {
        super(mediaView);
        this.a = new ml<>(mhVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ void a(@NonNull MediaView mediaView) {
        this.a.a();
        super.a((mn) mediaView);
    }

    @Override // com.yandex.mobile.ads.impl.mf
    public final void a(@NonNull ow owVar) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull MediaView mediaView, @NonNull ow owVar) {
        ow owVar2 = owVar;
        if (owVar2.a() != null) {
            this.a.a(owVar2.a());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull MediaView mediaView, @NonNull ow owVar) {
        ow owVar2 = owVar;
        if (owVar2.a() != null) {
            return this.a.b(owVar2.a());
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        this.a.a(oqVar, mqVar);
    }
}
