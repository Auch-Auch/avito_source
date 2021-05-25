package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
public class Utils {
    public static void a(Activity activity, int i) {
        View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setSystemUiVisibility(i | rootView.getSystemUiVisibility());
    }

    public static float b(float f) {
        float f2 = f / 255.0f;
        return f2 < 0.03928f ? f2 / 12.92f : (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static boolean c(@ColorInt int i) {
        return Math.abs(1.05f / (((b((float) Color.blue(i)) * 0.0722f) + ((b((float) Color.green(i)) * 0.7152f) + (b((float) Color.red(i)) * 0.2126f))) + 0.05f)) < 3.0f;
    }

    @Nullable
    public static Bitmap convertDrawableToBitmap(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable == null) {
            return null;
        }
        Drawable wrap = DrawableCompat.wrap(drawable);
        Bitmap createBitmap = Bitmap.createBitmap(wrap.getIntrinsicWidth(), wrap.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        wrap.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        wrap.draw(canvas);
        return createBitmap;
    }

    public static void setNavigationBarColor(Activity activity, @ColorInt int i) {
        int i2 = Build.VERSION.SDK_INT;
        activity.getWindow().setNavigationBarColor(i);
        if (i2 >= 26 && c(i)) {
            a(activity, 16);
        }
    }

    public static void setStatusBarColor(Activity activity, @ColorInt int i) {
        int i2 = Build.VERSION.SDK_INT;
        activity.getWindow().setStatusBarColor(i);
        if (i2 >= 23 && c(i)) {
            a(activity, 8192);
        }
    }
}
