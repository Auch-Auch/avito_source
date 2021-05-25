package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
public final class eg {
    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int c(Context context) {
        return (int) (((((float) a(context)) + 0.0f) / e(context)) + 0.5f);
    }

    public static int d(Context context) {
        return (int) (((((float) b(context)) + 0.0f) / e(context)) + 0.5f);
    }

    public static float e(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static void a(View view) {
        if (view != null) {
            try {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Exception unused) {
            }
            try {
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).removeAllViews();
                }
            } catch (Exception unused2) {
            }
        }
    }

    @NonNull
    public static Rect b(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static Bitmap c(View view) {
        if (view == null) {
            return null;
        }
        try {
            view.setDrawingCacheEnabled(true);
            float e = (1.0f / e(view.getContext())) / 5.0f;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(view.getDrawingCache(), Math.round(((float) view.getWidth()) * e), Math.round(((float) view.getHeight()) * e), true);
            view.setDrawingCacheEnabled(false);
            return createScaledBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d(@NonNull View view) {
        if (view.isShown()) {
            if (view.getAlpha() != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public static int e(@Nullable View view) {
        int i;
        int i2;
        if (view == null || !view.isShown()) {
            return 0;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0;
        }
        int width = rect.width();
        int height = rect.height();
        if (view.getLayoutParams().width > 0) {
            i = view.getLayoutParams().width;
        } else {
            i = view.getWidth();
        }
        if (view.getLayoutParams().height > 0) {
            i2 = view.getLayoutParams().height;
        } else {
            i2 = view.getHeight();
        }
        return ((width * height) * 100) / (i2 * i);
    }

    public static boolean a(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[2] < 0.5f;
    }

    public static int a(int i, float f) {
        return Color.argb(Math.max(0, Math.min(255, (int) (((100.0f - f) * 255.0f) / 100.0f))), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static boolean b(@Nullable View view, int i) {
        return e(view) >= i;
    }

    public static void a(final View view, final ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.mobile.ads.impl.eg.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                onPreDrawListener.onPreDraw();
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    public static boolean a(@NonNull View view, int i) {
        return view.getWidth() < i || view.getHeight() < i;
    }

    @Deprecated
    public static int a(@NonNull Context context, int i) {
        return Math.round(((float) i) / context.getResources().getDisplayMetrics().density);
    }
}
