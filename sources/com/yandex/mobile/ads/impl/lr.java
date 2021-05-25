package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.MediaView;
public final class lr implements lm<ow>, lp<ow> {
    @Nullable
    private final me a;
    @Nullable
    private final mf b;

    public lr(@Nullable me meVar, @Nullable mf mfVar) {
        this.a = meVar;
        this.b = mfVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.lm
    public final /* synthetic */ void a(@NonNull ow owVar) {
        ow owVar2 = owVar;
        a(owVar2.b());
        MediaView mediaView = (MediaView) a((mk<View, T>) this.b);
        if (mediaView != null) {
            this.b.b(mediaView, owVar2);
            mediaView.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.lm
    public final /* synthetic */ boolean b(@NonNull ow owVar) {
        ow owVar2 = owVar;
        return a(this.a, owVar2.b()) || a(this.b, owVar2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.lp
    public final /* synthetic */ void c(@NonNull ow owVar) {
        ow owVar2 = owVar;
        a(owVar2.b());
        MediaView mediaView = (MediaView) a((mk<View, T>) this.b);
        if (mediaView != null) {
            this.b.a(owVar2);
            mediaView.setVisibility(0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean d() {
        mf mfVar = this.b;
        boolean z = mfVar != null && mfVar.d();
        me meVar = this.a;
        return z || (meVar != null && meVar.d());
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean b() {
        mf mfVar = this.b;
        boolean z = mfVar != null && mfVar.b();
        me meVar = this.a;
        return z || (meVar != null && meVar.b());
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final void a() {
        ImageView imageView = (ImageView) a((mk<View, T>) this.a);
        if (imageView != null) {
            this.a.a(imageView);
        }
        MediaView mediaView = (MediaView) a((mk<View, T>) this.b);
        if (mediaView != null) {
            this.b.a((mf) mediaView);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final boolean c() {
        mf mfVar = this.b;
        boolean z = mfVar != null && mfVar.c();
        me meVar = this.a;
        return z || (meVar != null && meVar.c());
    }

    private void a(@Nullable ot otVar) {
        ImageView imageView = (ImageView) a((mk<View, T>) this.a);
        if (imageView != null && otVar != null) {
            this.a.b(imageView, otVar);
            imageView.setVisibility(0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lm
    public final void a(@NonNull oq oqVar, @NonNull mq mqVar) {
        me meVar = this.a;
        if (meVar != null) {
            meVar.a(oqVar, mqVar);
        }
        mf mfVar = this.b;
        if (mfVar != null) {
            mfVar.a(oqVar, mqVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.mobile.ads.impl.mk<V extends android.view.View, T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <V extends View, T> boolean a(@Nullable mk<V, T> mkVar, @Nullable T t) {
        View a3 = a((mk<View, T>) mkVar);
        return (a3 == null || t == null || !mkVar.a(a3, t)) ? false : true;
    }

    @Nullable
    private static <V extends View, T> V a(@Nullable mk<V, T> mkVar) {
        if (mkVar != null) {
            return mkVar.a();
        }
        return null;
    }
}
