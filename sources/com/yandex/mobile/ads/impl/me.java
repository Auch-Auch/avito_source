package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.j;
public final class me extends mk<ImageView, ot> {
    @NonNull
    private final j a;
    @NonNull
    private final mr b;

    public me(@NonNull ImageView imageView, @NonNull j jVar) {
        super(imageView);
        this.a = jVar;
        this.b = new mr(jVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull ImageView imageView, @NonNull ot otVar) {
        Drawable drawable = imageView.getDrawable();
        return this.b.a(drawable, otVar);
    }

    public final void a(@NonNull ImageView imageView) {
        imageView.setImageDrawable(null);
        super.a((me) imageView);
    }

    /* renamed from: a */
    public final void b(@NonNull ImageView imageView, @NonNull ot otVar) {
        Bitmap a3 = this.a.a(otVar);
        if (a3 != null) {
            imageView.setImageBitmap(a3);
        }
    }
}
