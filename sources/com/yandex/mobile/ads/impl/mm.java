package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.MediaView;
public final class mm extends mf {
    @NonNull
    private final ml<ImageView, ot> a;

    public mm(@NonNull MediaView mediaView, @NonNull me meVar) {
        super(mediaView);
        this.a = new ml<>(meVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ void a(@NonNull MediaView mediaView) {
        this.a.a();
        super.a((mm) mediaView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull MediaView mediaView, @NonNull ow owVar) {
        ow owVar2 = owVar;
        if (owVar2.a() == null && owVar2.b() != null) {
            this.a.a(owVar2.b());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull MediaView mediaView, @NonNull ow owVar) {
        ow owVar2 = owVar;
        if (owVar2.a() != null || owVar2.b() == null) {
            return false;
        }
        return this.a.b(owVar2.b());
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        this.a.a(oqVar, mqVar);
    }

    @Override // com.yandex.mobile.ads.impl.mf
    public final void a(@NonNull ow owVar) {
        if (owVar.a() == null && owVar.b() != null) {
            this.a.a(owVar.b());
        }
    }
}
