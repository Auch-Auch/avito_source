package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
public class ShapeAppearanceModel {
    public static final CornerSize PILL = new RelativeCornerSize(0.5f);
    public CornerTreatment a;
    public CornerTreatment b;
    public CornerTreatment c;
    public CornerTreatment d;
    public CornerSize e;
    public CornerSize f;
    public CornerSize g;
    public CornerSize h;
    public EdgeTreatment i;
    public EdgeTreatment j;
    public EdgeTreatment k;
    public EdgeTreatment l;

    public static final class Builder {
        @NonNull
        public CornerTreatment a = new RoundedCornerTreatment();
        @NonNull
        public CornerTreatment b = new RoundedCornerTreatment();
        @NonNull
        public CornerTreatment c = new RoundedCornerTreatment();
        @NonNull
        public CornerTreatment d = new RoundedCornerTreatment();
        @NonNull
        public CornerSize e = new AbsoluteCornerSize(0.0f);
        @NonNull
        public CornerSize f = new AbsoluteCornerSize(0.0f);
        @NonNull
        public CornerSize g = new AbsoluteCornerSize(0.0f);
        @NonNull
        public CornerSize h = new AbsoluteCornerSize(0.0f);
        @NonNull
        public EdgeTreatment i = new EdgeTreatment();
        @NonNull
        public EdgeTreatment j = new EdgeTreatment();
        @NonNull
        public EdgeTreatment k = new EdgeTreatment();
        @NonNull
        public EdgeTreatment l = new EdgeTreatment();

        public Builder() {
        }

        public static float a(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).a;
            }
            return -1.0f;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCorners(int i2, @Dimension float f2) {
            return setAllCorners(MaterialShapeUtils.a(i2)).setAllCornerSizes(f2);
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.k = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setBottomLeftCorner(int i2, @Dimension float f2) {
            return setBottomLeftCorner(MaterialShapeUtils.a(i2)).setBottomLeftCornerSize(f2);
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float f2) {
            this.h = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(int i2, @Dimension float f2) {
            return setBottomRightCorner(MaterialShapeUtils.a(i2)).setBottomRightCornerSize(f2);
        }

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float f2) {
            this.g = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.l = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.j = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.i = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(int i2, @Dimension float f2) {
            return setTopLeftCorner(MaterialShapeUtils.a(i2)).setTopLeftCornerSize(f2);
        }

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float f2) {
            this.e = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(int i2, @Dimension float f2) {
            return setTopRightCorner(MaterialShapeUtils.a(i2)).setTopRightCornerSize(f2);
        }

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float f2) {
            this.f = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.h = cornerSize;
            return this;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize cornerSize) {
            this.g = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.e = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize cornerSize) {
            this.f = cornerSize;
            return this;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        @NonNull
        public Builder setBottomLeftCorner(int i2, @NonNull CornerSize cornerSize) {
            return setBottomLeftCorner(MaterialShapeUtils.a(i2)).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setBottomRightCorner(int i2, @NonNull CornerSize cornerSize) {
            return setBottomRightCorner(MaterialShapeUtils.a(i2)).setBottomRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopLeftCorner(int i2, @NonNull CornerSize cornerSize) {
            return setTopLeftCorner(MaterialShapeUtils.a(i2)).setTopLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopRightCorner(int i2, @NonNull CornerSize cornerSize) {
            return setTopRightCorner(MaterialShapeUtils.a(i2)).setTopRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCornerSizes(@Dimension float f2) {
            return setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomRightCornerSize(f2).setBottomLeftCornerSize(f2);
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.d = cornerTreatment;
            float a3 = a(cornerTreatment);
            if (a3 != -1.0f) {
                setBottomLeftCornerSize(a3);
            }
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.c = cornerTreatment;
            float a3 = a(cornerTreatment);
            if (a3 != -1.0f) {
                setBottomRightCornerSize(a3);
            }
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.a = cornerTreatment;
            float a3 = a(cornerTreatment);
            if (a3 != -1.0f) {
                setTopLeftCornerSize(a3);
            }
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.b = cornerTreatment;
            float a3 = a(cornerTreatment);
            if (a3 != -1.0f) {
                setTopRightCornerSize(a3);
            }
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            this.a = shapeAppearanceModel.a;
            this.b = shapeAppearanceModel.b;
            this.c = shapeAppearanceModel.c;
            this.d = shapeAppearanceModel.d;
            this.e = shapeAppearanceModel.e;
            this.f = shapeAppearanceModel.f;
            this.g = shapeAppearanceModel.g;
            this.h = shapeAppearanceModel.h;
            this.i = shapeAppearanceModel.i;
            this.j = shapeAppearanceModel.j;
            this.k = shapeAppearanceModel.k;
            this.l = shapeAppearanceModel.l;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize);
    }

    public ShapeAppearanceModel(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
    }

    @NonNull
    public static Builder a(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull CornerSize cornerSize) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            CornerSize b2 = b(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize b3 = b(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, b2);
            CornerSize b4 = b(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, b2);
            CornerSize b5 = b(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, b2);
            return new Builder().setTopLeftCorner(i5, b3).setTopRightCorner(i6, b4).setBottomRightCorner(i7, b5).setBottomLeftCorner(i8, b(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, b2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static CornerSize b(TypedArray typedArray, int i2, @NonNull CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cornerSize;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new AbsoluteCornerSize((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        return this.k;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        return this.d;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        return this.h;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        return this.c;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        return this.g;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        return this.l;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        return this.j;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        return this.i;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        return this.a;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        return this.e;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        return this.b;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        return this.f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF rectF) {
        boolean z = this.l.getClass().equals(EdgeTreatment.class) && this.j.getClass().equals(EdgeTreatment.class) && this.i.getClass().equals(EdgeTreatment.class) && this.k.getClass().equals(EdgeTreatment.class);
        float cornerSize = this.e.getCornerSize(rectF);
        boolean z2 = this.f.getCornerSize(rectF) == cornerSize && this.h.getCornerSize(rectF) == cornerSize && this.g.getCornerSize(rectF) == cornerSize;
        boolean z3 = (this.b instanceof RoundedCornerTreatment) && (this.a instanceof RoundedCornerTreatment) && (this.c instanceof RoundedCornerTreatment) && (this.d instanceof RoundedCornerTreatment);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(float f2) {
        return toBuilder().setAllCornerSizes(f2).build();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return builder(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return builder(context, attributeSet, i2, i3, new AbsoluteCornerSize((float) i4));
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cornerSize);
    }

    @NonNull
    public static Builder builder(Context context, @StyleRes int i2, @StyleRes int i3) {
        return a(context, i2, i3, new AbsoluteCornerSize((float) 0));
    }

    public ShapeAppearanceModel() {
        this.a = new RoundedCornerTreatment();
        this.b = new RoundedCornerTreatment();
        this.c = new RoundedCornerTreatment();
        this.d = new RoundedCornerTreatment();
        this.e = new AbsoluteCornerSize(0.0f);
        this.f = new AbsoluteCornerSize(0.0f);
        this.g = new AbsoluteCornerSize(0.0f);
        this.h = new AbsoluteCornerSize(0.0f);
        this.i = new EdgeTreatment();
        this.j = new EdgeTreatment();
        this.k = new EdgeTreatment();
        this.l = new EdgeTreatment();
    }
}
