package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
public final class rk implements ri<BitmapDrawable> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.graphics.drawable.Drawable, android.graphics.Bitmap] */
    @Override // com.yandex.mobile.ads.impl.ri
    public final /* synthetic */ boolean a(@NonNull BitmapDrawable bitmapDrawable, @NonNull Bitmap bitmap) {
        return bitmap.equals(bitmapDrawable.getBitmap());
    }
}
