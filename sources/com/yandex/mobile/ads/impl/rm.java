package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
public final class rm implements ri<Drawable> {
    private final rl a = new rl();

    public static class a {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        public a(int i) {
            this.a = Color.alpha(i);
            this.b = Color.red(i);
            this.c = Color.green(i);
            this.d = Color.blue(i);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ri
    public final boolean a(@NonNull Drawable drawable, @NonNull Bitmap bitmap) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                bitmap2 = bitmapDrawable.getBitmap();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, 1, 1, true);
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
                a aVar = new a(createScaledBitmap.getPixel(0, 0));
                a aVar2 = new a(createScaledBitmap2.getPixel(0, 0));
                return Math.abs(aVar.a - aVar2.a) > 20 && Math.abs(aVar.b - aVar2.b) <= 20 && Math.abs(aVar.c - aVar2.c) <= 20 && Math.abs(aVar.d - aVar2.d) <= 20;
            }
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            bitmap3 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap3 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap3);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        bitmap2 = bitmap3;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, 1, 1, true);
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
        a aVar = new a(createScaledBitmap.getPixel(0, 0));
        a aVar2 = new a(createScaledBitmap2.getPixel(0, 0));
        if (Math.abs(aVar.a - aVar2.a) > 20) {
        }
    }
}
