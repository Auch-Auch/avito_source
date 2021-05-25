package com.vk.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
public class VKUIHelper {
    public static Context a;

    @Nullable
    public static Context getApplicationContext() {
        return a;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i, int i2) {
        Context context;
        if (bitmap == null || (context = a) == null) {
            return bitmap;
        }
        int i3 = (int) (context.getResources().getDisplayMetrics().density * ((float) i));
        int width = (int) (((float) bitmap.getWidth()) / ((((float) bitmap.getHeight()) * 1.0f) / ((float) i3)));
        Bitmap createBitmap = Bitmap.createBitmap(width, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, width, i3);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        float f = (float) i2;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }
}
