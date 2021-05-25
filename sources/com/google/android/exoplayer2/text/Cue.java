package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.4028235E38f;
    public static final Cue EMPTY = new Builder().setText("").build();
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public static final int VERTICAL_TYPE_LR = 2;
    public static final int VERTICAL_TYPE_RL = 1;
    @Nullable
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    @Nullable
    public final CharSequence text;
    @Nullable
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    @Deprecated
    public Cue(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    public Builder buildUpon() {
        return new Builder(this, null);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, i4, f4, f3, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE);
    }

    @Deprecated
    public Cue(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z, i4, Integer.MIN_VALUE);
    }

    public Cue(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Bitmap bitmap2, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6) {
        if (charSequence == null) {
            Assertions.checkNotNull(bitmap2);
        } else {
            Assertions.checkArgument(bitmap2 == null);
        }
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap2;
        this.line = f;
        this.lineType = i;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
        this.verticalType = i6;
    }

    public static final class Builder {
        @Nullable
        public CharSequence a;
        @Nullable
        public Bitmap b;
        @Nullable
        public Layout.Alignment c;
        public float d;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public float j;
        public float k;
        public float l;
        public boolean m;
        @ColorInt
        public int n;
        public int o;

        public Builder() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = -3.4028235E38f;
            this.e = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.g = -3.4028235E38f;
            this.h = Integer.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = -3.4028235E38f;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = false;
            this.n = ViewCompat.MEASURED_STATE_MASK;
            this.o = Integer.MIN_VALUE;
        }

        public Cue build() {
            return new Cue(this.a, this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }

        public Builder clearWindowColor() {
            this.m = false;
            return this;
        }

        @Nullable
        public Bitmap getBitmap() {
            return this.b;
        }

        public float getBitmapHeight() {
            return this.l;
        }

        public float getLine() {
            return this.d;
        }

        public int getLineAnchor() {
            return this.f;
        }

        public int getLineType() {
            return this.e;
        }

        public float getPosition() {
            return this.g;
        }

        public int getPositionAnchor() {
            return this.h;
        }

        public float getSize() {
            return this.k;
        }

        @Nullable
        public CharSequence getText() {
            return this.a;
        }

        @Nullable
        public Layout.Alignment getTextAlignment() {
            return this.c;
        }

        public float getTextSize() {
            return this.j;
        }

        public int getTextSizeType() {
            return this.i;
        }

        public int getVerticalType() {
            return this.o;
        }

        @ColorInt
        public int getWindowColor() {
            return this.n;
        }

        public boolean isWindowColorSet() {
            return this.m;
        }

        public Builder setBitmap(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public Builder setBitmapHeight(float f2) {
            this.l = f2;
            return this;
        }

        public Builder setLine(float f2, int i2) {
            this.d = f2;
            this.e = i2;
            return this;
        }

        public Builder setLineAnchor(int i2) {
            this.f = i2;
            return this;
        }

        public Builder setPosition(float f2) {
            this.g = f2;
            return this;
        }

        public Builder setPositionAnchor(int i2) {
            this.h = i2;
            return this;
        }

        public Builder setSize(float f2) {
            this.k = f2;
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public Builder setTextAlignment(@Nullable Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public Builder setTextSize(float f2, int i2) {
            this.j = f2;
            this.i = i2;
            return this;
        }

        public Builder setVerticalType(int i2) {
            this.o = i2;
            return this;
        }

        public Builder setWindowColor(@ColorInt int i2) {
            this.n = i2;
            this.m = true;
            return this;
        }

        public Builder(Cue cue, a aVar) {
            this.a = cue.text;
            this.b = cue.bitmap;
            this.c = cue.textAlignment;
            this.d = cue.line;
            this.e = cue.lineType;
            this.f = cue.lineAnchor;
            this.g = cue.position;
            this.h = cue.positionAnchor;
            this.i = cue.textSizeType;
            this.j = cue.textSize;
            this.k = cue.size;
            this.l = cue.bitmapHeight;
            this.m = cue.windowColorSet;
            this.n = cue.windowColor;
            this.o = cue.verticalType;
        }
    }
}
