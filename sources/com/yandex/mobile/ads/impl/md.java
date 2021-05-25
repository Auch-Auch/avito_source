package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.j;
public final class md extends mk<TextView, os> {
    @NonNull
    private final j a;
    @NonNull
    private final mr b;

    public md(@NonNull TextView textView, @NonNull j jVar) {
        super(textView);
        this.a = jVar;
        this.b = new mr(jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ void a(@NonNull TextView textView) {
        super.a(textView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull TextView textView, @NonNull os osVar) {
        Bitmap a3;
        TextView textView2 = textView;
        ot a4 = osVar.a();
        if (a4 != null && (a3 = this.a.a(a4)) != null) {
            textView2.setBackground(new BitmapDrawable(textView2.getResources(), a3));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull TextView textView, @NonNull os osVar) {
        TextView textView2 = textView;
        ot a3 = osVar.a();
        if (a3 == null) {
            return true;
        }
        return this.b.a(textView2.getBackground(), a3);
    }
}
