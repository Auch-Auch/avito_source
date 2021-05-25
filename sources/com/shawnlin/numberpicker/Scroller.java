package com.shawnlin.numberpicker;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
public class Scroller {
    public static float A = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    public static final float[] B = new float[101];
    public static final float[] C = new float[101];
    public final Interpolator a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m;
    public int n;
    public float o;
    public float p;
    public float q;
    public boolean r;
    public boolean s;
    public float t;
    public float u;
    public int v;
    public float w;
    public float x;
    public final float y;
    public float z;

    public static class a implements Interpolator {
        public static final float a;
        public static final float b;

        static {
            float a3 = 1.0f / a(1.0f);
            a = a3;
            b = 1.0f - (a(1.0f) * a3);
        }

        public static float a(float f) {
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
            }
            return a2.b.a.a.a.b(1.0f, (float) Math.exp((double) (1.0f - f2)), 0.63212055f, 0.36787945f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float a3 = a(f) * a;
            return a3 > 0.0f ? a3 + b : a3;
        }
    }

    static {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f14 = ((float) i2) / 100.0f;
            float f15 = 1.0f;
            while (true) {
                f2 = 2.0f;
                f3 = ((f15 - f12) / 2.0f) + f12;
                f4 = 3.0f;
                f5 = 1.0f - f3;
                f6 = f3 * 3.0f * f5;
                f7 = f3 * f3 * f3;
                float f16 = (((f3 * 0.35000002f) + (f5 * 0.175f)) * f6) + f7;
                if (((double) Math.abs(f16 - f14)) < 1.0E-5d) {
                    break;
                } else if (f16 > f14) {
                    f15 = f3;
                } else {
                    f12 = f3;
                }
            }
            B[i2] = (((f5 * 0.5f) + f3) * f6) + f7;
            float f17 = 1.0f;
            while (true) {
                f8 = ((f17 - f13) / f2) + f13;
                f9 = 1.0f - f8;
                f10 = f8 * f4 * f9;
                f11 = f8 * f8 * f8;
                float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                if (((double) Math.abs(f18 - f14)) < 1.0E-5d) {
                    break;
                }
                if (f18 > f14) {
                    f17 = f8;
                } else {
                    f13 = f8;
                }
                f2 = 2.0f;
                f4 = 3.0f;
            }
            C[i2] = (((f8 * 0.35000002f) + (f9 * 0.175f)) * f10) + f11;
        }
        float[] fArr = B;
        C[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    public Scroller(Context context) {
        this(context, null);
    }

    public final float a(float f2) {
        return this.y * 386.0878f * f2;
    }

    public void abortAnimation() {
        this.k = this.e;
        this.l = this.f;
        this.r = true;
    }

    public final double b(float f2) {
        return Math.log((double) ((Math.abs(f2) * 0.35f) / (this.w * this.z)));
    }

    public boolean computeScrollOffset() {
        if (this.r) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
        int i2 = this.n;
        if (currentAnimationTimeMillis < i2) {
            int i3 = this.b;
            if (i3 == 0) {
                float interpolation = this.a.getInterpolation(((float) currentAnimationTimeMillis) * this.o);
                this.k = Math.round(this.p * interpolation) + this.c;
                this.l = Math.round(interpolation * this.q) + this.d;
            } else if (i3 == 1) {
                float f2 = ((float) currentAnimationTimeMillis) / ((float) i2);
                int i4 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i4 < 100) {
                    float f5 = ((float) i4) / 100.0f;
                    int i5 = i4 + 1;
                    float[] fArr = B;
                    float f6 = fArr[i4];
                    f4 = (fArr[i5] - f6) / ((((float) i5) / 100.0f) - f5);
                    f3 = a2.b.a.a.a.b(f2, f5, f4, f6);
                }
                this.u = ((f4 * ((float) this.v)) / ((float) i2)) * 1000.0f;
                int i6 = this.c;
                int round = Math.round(((float) (this.e - i6)) * f3) + i6;
                this.k = round;
                int min = Math.min(round, this.h);
                this.k = min;
                this.k = Math.max(min, this.g);
                int i7 = this.d;
                int round2 = Math.round(f3 * ((float) (this.f - i7))) + i7;
                this.l = round2;
                int min2 = Math.min(round2, this.j);
                this.l = min2;
                int max = Math.max(min2, this.i);
                this.l = max;
                if (this.k == this.e && max == this.f) {
                    this.r = true;
                }
            }
        } else {
            this.k = this.e;
            this.l = this.f;
            this.r = true;
        }
        return true;
    }

    public void extendDuration(int i2) {
        int timePassed = timePassed() + i2;
        this.n = timePassed;
        this.o = 1.0f / ((float) timePassed);
        this.r = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fling(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shawnlin.numberpicker.Scroller.fling(int, int, int, int, int, int, int, int):void");
    }

    public final void forceFinished(boolean z2) {
        this.r = z2;
    }

    public float getCurrVelocity() {
        if (this.b == 1) {
            return this.u;
        }
        return this.t - ((this.x * ((float) timePassed())) / 2000.0f);
    }

    public final int getCurrX() {
        return this.k;
    }

    public final int getCurrY() {
        return this.l;
    }

    public final int getDuration() {
        return this.n;
    }

    public final int getFinalX() {
        return this.e;
    }

    public final int getFinalY() {
        return this.f;
    }

    public final int getStartX() {
        return this.c;
    }

    public final int getStartY() {
        return this.d;
    }

    public final boolean isFinished() {
        return this.r;
    }

    public boolean isScrollingInDirection(float f2, float f3) {
        return !this.r && Math.signum(f2) == Math.signum((float) (this.e - this.c)) && Math.signum(f3) == Math.signum((float) (this.f - this.d));
    }

    public void setFinalX(int i2) {
        this.e = i2;
        this.p = (float) (i2 - this.c);
        this.r = false;
    }

    public void setFinalY(int i2) {
        this.f = i2;
        this.q = (float) (i2 - this.d);
        this.r = false;
    }

    public final void setFriction(float f2) {
        this.x = this.y * 386.0878f * f2;
        this.w = f2;
    }

    public void startScroll(int i2, int i3, int i4, int i5) {
        startScroll(i2, i3, i4, i5, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        this.b = 0;
        this.r = false;
        this.n = i6;
        this.m = AnimationUtils.currentAnimationTimeMillis();
        this.c = i2;
        this.d = i3;
        this.e = i2 + i4;
        this.f = i3 + i5;
        this.p = (float) i4;
        this.q = (float) i5;
        this.o = 1.0f / ((float) this.n);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z2) {
        this.w = ViewConfiguration.getScrollFriction();
        this.r = true;
        if (interpolator == null) {
            this.a = new a();
        } else {
            this.a = interpolator;
        }
        this.y = context.getResources().getDisplayMetrics().density * 160.0f;
        this.x = a(ViewConfiguration.getScrollFriction());
        this.s = z2;
        this.z = a(0.84f);
    }
}
