package com.facebook.animated.webpdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.animated.webp.WebPFrame;
import com.facebook.animated.webp.WebPImage;
import com.facebook.fresco.animation.backend.AnimationBackend;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class WebpAnimationBackend implements AnimationBackend {
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    public final WebPImage c;
    public Rect d;
    @GuardedBy("this")
    @Nullable
    public Bitmap e;

    public WebpAnimationBackend(WebPImage webPImage) {
        this.c = webPImage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[SYNTHETIC, Splitter:B:13:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.animated.webpdrawable.WebpAnimationBackend create(java.lang.String r2) throws java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002b }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r2)     // Catch:{ all -> 0x002b }
            r0.<init>(r1)     // Catch:{ all -> 0x002b }
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.mark(r2)     // Catch:{ all -> 0x0029 }
            int r2 = r0.available()     // Catch:{ all -> 0x0029 }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0029 }
            r0.read(r2)     // Catch:{ all -> 0x0029 }
            com.facebook.animated.webp.WebPImage r2 = com.facebook.animated.webp.WebPImage.createFromByteArray(r2)     // Catch:{ all -> 0x0029 }
            r0.reset()     // Catch:{ all -> 0x0029 }
            com.facebook.animated.webpdrawable.WebpAnimationBackend r1 = new com.facebook.animated.webpdrawable.WebpAnimationBackend     // Catch:{ all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ all -> 0x0029 }
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r1
        L_0x0029:
            r2 = move-exception
            goto L_0x002d
        L_0x002b:
            r2 = move-exception
            r0 = 0
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            r0.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.animated.webpdrawable.WebpAnimationBackend.create(java.lang.String):com.facebook.animated.webpdrawable.WebpAnimationBackend");
    }

    public final synchronized void a(int i, int i2) {
        Bitmap bitmap = this.e;
        if (bitmap != null && (bitmap.getWidth() < i || this.e.getHeight() < i2)) {
            synchronized (this) {
                Bitmap bitmap2 = this.e;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.e = null;
                }
            }
        }
        if (this.e == null) {
            this.e = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.e.eraseColor(0);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.c.dispose();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        WebPFrame frame = this.c.getFrame(i);
        double width = ((double) this.d.width()) / ((double) drawable.getIntrinsicWidth());
        double height = ((double) this.d.height()) / ((double) drawable.getIntrinsicHeight());
        int round = (int) Math.round(((double) frame.getWidth()) * width);
        int round2 = (int) Math.round(((double) frame.getHeight()) * height);
        int xOffset = (int) (((double) frame.getXOffset()) * width);
        int yOffset = (int) (((double) frame.getYOffset()) * height);
        synchronized (this) {
            int width2 = this.d.width();
            int height2 = this.d.height();
            a(width2, height2);
            Bitmap bitmap = this.e;
            if (bitmap == null) {
                return false;
            }
            frame.renderFrame(round, round2, bitmap);
            this.b.set(0, 0, width2, height2);
            this.a.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.e, this.b, this.a, (Paint) null);
            return true;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.c.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.c.getFrameDurations()[i];
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.c.getHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.c.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.c.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public synchronized void setBounds(Rect rect) {
        this.d = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
