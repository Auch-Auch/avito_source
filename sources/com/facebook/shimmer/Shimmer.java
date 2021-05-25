package com.facebook.shimmer;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.Px;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class Shimmer {
    public final float[] a = new float[4];
    public final int[] b = new int[4];
    public int c;
    @ColorInt
    public int d;
    @ColorInt
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public long s;
    public long t;

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.a.p = true;
        }

        @Override // com.facebook.shimmer.Shimmer.Builder
        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    public static abstract class Builder<T extends Builder<T>> {
        public final Shimmer a = new Shimmer();

        public T a(TypedArray typedArray) {
            int i = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i)) {
                setClipToChildren(typedArray.getBoolean(i, this.a.n));
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i2)) {
                setAutoStart(typedArray.getBoolean(i2, this.a.o));
            }
            int i3 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i3)) {
                setBaseAlpha(typedArray.getFloat(i3, 0.3f));
            }
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i4)) {
                setHighlightAlpha(typedArray.getFloat(i4, 1.0f));
            }
            int i5 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i5)) {
                setDuration((long) typedArray.getInt(i5, (int) this.a.s));
            }
            int i6 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i6)) {
                setRepeatCount(typedArray.getInt(i6, this.a.q));
            }
            int i7 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i7)) {
                setRepeatDelay((long) typedArray.getInt(i7, (int) this.a.t));
            }
            int i8 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i8)) {
                setRepeatMode(typedArray.getInt(i8, this.a.r));
            }
            int i9 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i9)) {
                int i10 = typedArray.getInt(i9, this.a.c);
                if (i10 == 1) {
                    setDirection(1);
                } else if (i10 == 2) {
                    setDirection(2);
                } else if (i10 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i11)) {
                if (typedArray.getInt(i11, this.a.f) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i12)) {
                setDropoff(typedArray.getFloat(i12, this.a.l));
            }
            int i13 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i13)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i13, this.a.g));
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i14)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i14, this.a.h));
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i15)) {
                setIntensity(typedArray.getFloat(i15, this.a.k));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i16)) {
                setWidthRatio(typedArray.getFloat(i16, this.a.i));
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i17)) {
                setHeightRatio(typedArray.getFloat(i17, this.a.j));
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i18)) {
                setTilt(typedArray.getFloat(i18, this.a.m));
            }
            return getThis();
        }

        public Shimmer build() {
            Shimmer shimmer = this.a;
            int i = shimmer.f;
            if (i != 1) {
                int[] iArr = shimmer.b;
                int i2 = shimmer.e;
                iArr[0] = i2;
                int i3 = shimmer.d;
                iArr[1] = i3;
                iArr[2] = i3;
                iArr[3] = i2;
            } else {
                int[] iArr2 = shimmer.b;
                int i4 = shimmer.d;
                iArr2[0] = i4;
                iArr2[1] = i4;
                int i5 = shimmer.e;
                iArr2[2] = i5;
                iArr2[3] = i5;
            }
            if (i != 1) {
                shimmer.a[0] = Math.max(((1.0f - shimmer.k) - shimmer.l) / 2.0f, 0.0f);
                shimmer.a[1] = Math.max(((1.0f - shimmer.k) - 0.001f) / 2.0f, 0.0f);
                shimmer.a[2] = Math.min(((shimmer.k + 1.0f) + 0.001f) / 2.0f, 1.0f);
                shimmer.a[3] = Math.min(((shimmer.k + 1.0f) + shimmer.l) / 2.0f, 1.0f);
            } else {
                float[] fArr = shimmer.a;
                fArr[0] = 0.0f;
                fArr[1] = Math.min(shimmer.k, 1.0f);
                shimmer.a[2] = Math.min(shimmer.k + shimmer.l, 1.0f);
                shimmer.a[3] = 1.0f;
            }
            return this.a;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return a(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public abstract T getThis();

        public T setAutoStart(boolean z) {
            this.a.o = z;
            return getThis();
        }

        public T setBaseAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            Shimmer shimmer = this.a;
            shimmer.e = (((int) (Math.min(1.0f, Math.max(0.0f, f)) * 255.0f)) << 24) | (shimmer.e & ViewCompat.MEASURED_SIZE_MASK);
            return getThis();
        }

        public T setClipToChildren(boolean z) {
            this.a.n = z;
            return getThis();
        }

        public T setDirection(int i) {
            this.a.c = i;
            return getThis();
        }

        public T setDropoff(float f) {
            if (f >= 0.0f) {
                this.a.l = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f);
        }

        public T setDuration(long j) {
            if (j >= 0) {
                this.a.s = j;
                return getThis();
            }
            throw new IllegalArgumentException(a.T2("Given a negative duration: ", j));
        }

        public T setFixedHeight(@Px int i) {
            if (i >= 0) {
                this.a.h = i;
                return getThis();
            }
            throw new IllegalArgumentException(a.M2("Given invalid height: ", i));
        }

        public T setFixedWidth(@Px int i) {
            if (i >= 0) {
                this.a.g = i;
                return getThis();
            }
            throw new IllegalArgumentException(a.M2("Given invalid width: ", i));
        }

        public T setHeightRatio(float f) {
            if (f >= 0.0f) {
                this.a.j = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f);
        }

        public T setHighlightAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            Shimmer shimmer = this.a;
            shimmer.d = (((int) (Math.min(1.0f, Math.max(0.0f, f)) * 255.0f)) << 24) | (shimmer.d & ViewCompat.MEASURED_SIZE_MASK);
            return getThis();
        }

        public T setIntensity(float f) {
            if (f >= 0.0f) {
                this.a.k = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f);
        }

        public T setRepeatCount(int i) {
            this.a.q = i;
            return getThis();
        }

        public T setRepeatDelay(long j) {
            if (j >= 0) {
                this.a.t = j;
                return getThis();
            }
            throw new IllegalArgumentException(a.T2("Given a negative repeat delay: ", j));
        }

        public T setRepeatMode(int i) {
            this.a.r = i;
            return getThis();
        }

        public T setShape(int i) {
            this.a.f = i;
            return getThis();
        }

        public T setTilt(float f) {
            this.a.m = f;
            return getThis();
        }

        public T setWidthRatio(float f) {
            if (f >= 0.0f) {
                this.a.i = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f);
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.a.p = false;
        }

        /* Return type fixed from 'com.facebook.shimmer.Shimmer$Builder' to match base method */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder a(TypedArray typedArray) {
            super.a(typedArray);
            int i = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i)) {
                setBaseColor(typedArray.getColor(i, this.a.e));
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i2)) {
                setHighlightColor(typedArray.getColor(i2, this.a.d));
            }
            return getThis();
        }

        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder setBaseColor(@ColorInt int i) {
            Shimmer shimmer = this.a;
            shimmer.e = (i & ViewCompat.MEASURED_SIZE_MASK) | (shimmer.e & ViewCompat.MEASURED_STATE_MASK);
            return getThis();
        }

        public ColorHighlightBuilder setHighlightColor(@ColorInt int i) {
            this.a.d = i;
            return getThis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public Shimmer() {
        new RectF();
        this.c = 0;
        this.d = -1;
        this.e = 1291845631;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 20.0f;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = -1;
        this.r = 1;
        this.s = 1000;
    }
}
