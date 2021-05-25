package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
public abstract class PlatformBitmapFactory {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "width must be > 0");
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "height must be > 0");
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/util/DisplayMetrics;IILandroid/graphics/Bitmap$Config;ZLjava/lang/Object;)Lcom/facebook/common/references/CloseableReference<Landroid/graphics/Bitmap;>; */
    public final CloseableReference b(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, boolean z) {
        a(i, i2);
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
        Bitmap bitmap = createBitmapInternal.get();
        if (displayMetrics != null) {
            bitmap.setDensity(displayMetrics.densityDpi);
        }
        bitmap.setHasAlpha(z);
        if (config == Bitmap.Config.ARGB_8888 && !z) {
            bitmap.eraseColor(ViewCompat.MEASURED_STATE_MASK);
        }
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        return createBitmap(i, i2, config, (Object) null);
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config);

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        return createScaledBitmap(bitmap, i, i2, z, null);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z, @Nullable Object obj) {
        a(i, i2);
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        return createBitmapInternal(i, i2, config);
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, @Nullable Object obj) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, @Nullable Object obj) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return createBitmap(bitmap, i, i2, i3, i4, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Object obj) {
        return createBitmap(bitmap, i, i2, i3, i4, (Matrix) null, false, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Matrix matrix, boolean z) {
        return createBitmap(bitmap, i, i2, i3, i4, matrix, z, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Matrix matrix, boolean z, @Nullable Object obj) {
        Canvas canvas;
        CloseableReference<Bitmap> closeableReference;
        Paint paint;
        Preconditions.checkNotNull(bitmap, "Source bitmap cannot be null");
        Preconditions.checkArgument(i >= 0, "x must be >= 0");
        Preconditions.checkArgument(i2 >= 0, "y must be >= 0");
        a(i3, i4);
        int i5 = i + i3;
        Preconditions.checkArgument(i5 <= bitmap.getWidth(), "x + width must be <= bitmap.width()");
        int i6 = i2 + i4;
        Preconditions.checkArgument(i6 <= bitmap.getHeight(), "y + height must be <= bitmap.height()");
        Rect rect = new Rect(i, i2, i5, i6);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i3, (float) i4);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 != null) {
            int i7 = a.a[config2.ordinal()];
            if (i7 == 1) {
                config = Bitmap.Config.RGB_565;
            } else if (i7 != 2) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.ALPHA_8;
            }
        }
        Bitmap.Config config3 = config;
        if (matrix == null || matrix.isIdentity()) {
            closeableReference = b(null, i3, i4, config3, bitmap.hasAlpha());
            Bitmap bitmap2 = closeableReference.get();
            bitmap2.setDensity(bitmap.getDensity());
            bitmap2.setHasAlpha(bitmap.hasAlpha());
            bitmap2.setPremultiplied(bitmap.isPremultiplied());
            canvas = new Canvas(closeableReference.get());
            paint = null;
        } else {
            boolean z2 = !matrix.rectStaysRect();
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            int round = Math.round(rectF2.width());
            int round2 = Math.round(rectF2.height());
            if (z2) {
                config3 = Bitmap.Config.ARGB_8888;
            }
            closeableReference = b(null, round, round2, config3, z2 || bitmap.hasAlpha());
            Bitmap bitmap3 = closeableReference.get();
            bitmap3.setDensity(bitmap.getDensity());
            bitmap3.setHasAlpha(bitmap.hasAlpha());
            bitmap3.setPremultiplied(bitmap.isPremultiplied());
            canvas = new Canvas(closeableReference.get());
            canvas.translate(-rectF2.left, -rectF2.top);
            canvas.concat(matrix);
            paint = new Paint();
            paint.setFilterBitmap(z);
            if (z2) {
                paint.setAntiAlias(true);
            }
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        canvas.setBitmap(null);
        return closeableReference;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config) {
        return createBitmap(displayMetrics, i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        return b(displayMetrics, i, i2, config, true);
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config) {
        return createBitmap(iArr, i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
        createBitmapInternal.get().setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        return createBitmap(displayMetrics, iArr, 0, i, i, i2, config, obj);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i, i2, i3, i4, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config, @Nullable Object obj) {
        CloseableReference<Bitmap> createBitmap = createBitmap(displayMetrics, i3, i4, config, obj);
        createBitmap.get().setPixels(iArr, i, i2, 0, 0, i3, i4);
        return createBitmap;
    }
}
