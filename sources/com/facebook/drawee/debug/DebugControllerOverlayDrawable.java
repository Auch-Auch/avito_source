package com.facebook.drawee.debug;

import a2.b.a.a.a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.HashMap;
import java.util.Locale;
import javax.annotation.Nullable;
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public String f;
    public ScalingUtils.ScaleType g;
    public HashMap<String, String> h = new HashMap<>();
    public int i;
    public int j;
    public int k = 80;
    public final Paint l = new Paint(1);
    public final Matrix m = new Matrix();
    public final Rect n = new Rect();
    public final RectF o = new RectF();
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public long u;
    public String v;
    public int w = -1;
    public int x = 0;

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public static String b(String str, @Nullable Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(Canvas canvas, String str, String str2, int i2) {
        String c3 = a.c3(str, ": ");
        float measureText = this.l.measureText(c3);
        float measureText2 = this.l.measureText(str2);
        this.l.setColor(1711276032);
        int i3 = this.s;
        int i4 = this.t;
        canvas.drawRect((float) (i3 - 4), (float) (i4 + 8), ((float) i3) + measureText + measureText2 + 4.0f, (float) (i4 + this.r + 8), this.l);
        this.l.setColor(-1);
        canvas.drawText(c3, (float) this.s, (float) this.t, this.l);
        this.l.setColor(i2);
        canvas.drawText(str2, ((float) this.s) + measureText, (float) this.t, this.l);
        this.t += this.r;
    }

    public void addAdditionalData(String str, String str2) {
        this.h.put(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01fc A[LOOP:0: B:40:0x01f6->B:42:0x01fc, LOOP_END] */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r20) {
        /*
        // Method dump skipped, instructions count: 532
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.debug.DebugControllerOverlayDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / 8, rect.height() / 9)));
        this.l.setTextSize((float) min);
        int i2 = min + 8;
        this.r = i2;
        int i3 = this.k;
        if (i3 == 80) {
            this.r = i2 * -1;
        }
        this.p = rect.left + 10;
        this.q = i3 == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j2) {
        this.u = j2;
        invalidateSelf();
    }

    public void reset() {
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.h = new HashMap<>();
        this.i = -1;
        this.j = -1;
        this.f = null;
        setControllerId(null);
        this.u = -1;
        this.v = null;
        this.w = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    public void setAnimationInfo(int i2, int i3) {
        this.i = i2;
        this.j = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setControllerId(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.a = str;
        invalidateSelf();
    }

    public void setDimensions(int i2, int i3) {
        this.c = i2;
        this.d = i3;
        invalidateSelf();
    }

    public void setFinalImageTimeMs(long j2) {
        this.u = j2;
    }

    public void setImageFormat(@Nullable String str) {
        this.f = str;
    }

    public void setImageId(@Nullable String str) {
        this.b = str;
        invalidateSelf();
    }

    public void setImageSize(int i2) {
        this.e = i2;
    }

    public void setOrigin(String str, int i2) {
        this.v = str;
        this.w = i2;
        invalidateSelf();
    }

    public void setOverlayColor(int i2) {
        this.x = i2;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.g = scaleType;
    }

    public void setTextGravity(int i2) {
        this.k = i2;
        invalidateSelf();
    }
}
