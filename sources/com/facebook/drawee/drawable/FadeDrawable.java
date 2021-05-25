package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
public class FadeDrawable extends ArrayDrawable {
    @VisibleForTesting
    public static final int TRANSITION_NONE = 2;
    @VisibleForTesting
    public static final int TRANSITION_RUNNING = 1;
    @VisibleForTesting
    public static final int TRANSITION_STARTING = 0;
    public final Drawable[] i;
    public final boolean j;
    public final int k;
    @VisibleForTesting
    public int l;
    @VisibleForTesting
    public int m;
    @VisibleForTesting
    public long n;
    @VisibleForTesting
    public int[] o;
    @VisibleForTesting
    public int[] p;
    @VisibleForTesting
    public int q;
    @VisibleForTesting
    public boolean[] r;
    @VisibleForTesting
    public int s;
    @Nullable
    public OnFadeFinishedListener t;
    public boolean u;

    public interface OnFadeFinishedListener {
        void onFadeFinished();
    }

    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    public final void a() {
        OnFadeFinishedListener onFadeFinishedListener = this.t;
        if (onFadeFinishedListener != null && this.u) {
            onFadeFinishedListener.onFadeFinished();
            this.u = false;
        }
    }

    public final void b() {
        this.l = 2;
        Arrays.fill(this.o, this.k);
        this.o[0] = 255;
        Arrays.fill(this.p, this.k);
        this.p[0] = 255;
        Arrays.fill(this.r, this.j);
        this.r[0] = true;
    }

    public void beginBatchMode() {
        this.s++;
    }

    public final boolean c(float f) {
        boolean z = true;
        for (int i2 = 0; i2 < this.i.length; i2++) {
            boolean[] zArr = this.r;
            int i3 = zArr[i2] ? 1 : -1;
            int[] iArr = this.p;
            iArr[i2] = (int) ((((float) (i3 * 255)) * f) + ((float) this.o[i2]));
            if (iArr[i2] < 0) {
                iArr[i2] = 0;
            }
            if (iArr[i2] > 255) {
                iArr[i2] = 255;
            }
            if (zArr[i2] && iArr[i2] < 255) {
                z = false;
            }
            if (!zArr[i2] && iArr[i2] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        int i2 = this.l;
        int i3 = 2;
        int i4 = 0;
        if (i2 == 0) {
            System.arraycopy(this.p, 0, this.o, 0, this.i.length);
            this.n = getCurrentTimeMs();
            z = c(this.m == 0 ? 1.0f : 0.0f);
            if (!z) {
                i3 = 1;
            }
            this.l = i3;
            if (z) {
                a();
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                a();
            }
            z = true;
        } else {
            Preconditions.checkState(this.m > 0);
            z = c(((float) (getCurrentTimeMs() - this.n)) / ((float) this.m));
            if (!z) {
                i3 = 1;
            }
            this.l = i3;
            if (z) {
                a();
            }
        }
        while (true) {
            Drawable[] drawableArr = this.i;
            if (i4 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i4];
            int i5 = (this.p[i4] * this.q) / 255;
            if (drawable != null && i5 > 0) {
                this.s++;
                drawable.mutate().setAlpha(i5);
                this.s--;
                drawable.draw(canvas);
            }
            i4++;
        }
        if (!z) {
            invalidateSelf();
        }
    }

    public void endBatchMode() {
        this.s--;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.l = 0;
        Arrays.fill(this.r, true);
        invalidateSelf();
    }

    public void fadeInLayer(int i2) {
        this.u = i2 == 2;
        this.l = 0;
        this.r[i2] = true;
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.l = 0;
        Arrays.fill(this.r, false);
        invalidateSelf();
    }

    public void fadeOutLayer(int i2) {
        this.l = 0;
        this.r[i2] = false;
        invalidateSelf();
    }

    public void fadeToLayer(int i2) {
        this.l = 0;
        Arrays.fill(this.r, false);
        this.r[i2] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i2) {
        this.l = 0;
        int i3 = i2 + 1;
        Arrays.fill(this.r, 0, i3, true);
        Arrays.fill(this.r, i3, this.i.length, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.l = 2;
        for (int i2 = 0; i2 < this.i.length; i2++) {
            this.p[i2] = this.r[i2] ? 255 : 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public int getTransitionDuration() {
        return this.m;
    }

    @VisibleForTesting
    public int getTransitionState() {
        return this.l;
    }

    public void hideLayerImmediately(int i2) {
        this.r[i2] = false;
        this.p[i2] = 0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.s == 0) {
            super.invalidateSelf();
        }
    }

    public boolean isDefaultLayerIsOn() {
        return this.j;
    }

    public boolean isLayerOn(int i2) {
        return this.r[i2];
    }

    public void reset() {
        b();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.q != i2) {
            this.q = i2;
            invalidateSelf();
        }
    }

    public void setOnFadeFinishedListener(OnFadeFinishedListener onFadeFinishedListener) {
        this.t = onFadeFinishedListener;
    }

    public void setTransitionDuration(int i2) {
        this.m = i2;
        if (this.l == 1) {
            this.l = 0;
        }
    }

    public void showLayerImmediately(int i2) {
        this.r[i2] = true;
        this.p[i2] = 255;
        invalidateSelf();
    }

    public FadeDrawable(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        int i2 = 0;
        Preconditions.checkState(drawableArr.length < 1 ? false : true, "At least one layer required!");
        this.i = drawableArr;
        this.o = new int[drawableArr.length];
        this.p = new int[drawableArr.length];
        this.q = 255;
        this.r = new boolean[drawableArr.length];
        this.s = 0;
        this.j = z;
        this.k = z ? 255 : i2;
        b();
    }
}
