package com.avito.android.util.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.Shape;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ColorStateListsKt;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\u00028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/util/drawable/ShapeStateDrawable;", "Landroid/graphics/drawable/StateListDrawable;", "Landroid/graphics/drawable/shapes/Shape;", "d", "Landroid/graphics/drawable/shapes/Shape;", "getShape", "()Landroid/graphics/drawable/shapes/Shape;", "shape", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "getPadding", "()Landroid/graphics/Rect;", "padding", "", AuthSource.SEND_ABUSE, "I", "getRippleColor", "()I", "rippleColor", "Landroid/content/res/ColorStateList;", AuthSource.BOOKING_ORDER, "Landroid/content/res/ColorStateList;", "getColorStateList", "()Landroid/content/res/ColorStateList;", "colorStateList", "<init>", "(Landroid/content/res/ColorStateList;Landroid/graphics/Rect;Landroid/graphics/drawable/shapes/Shape;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"CustomColorsKotlin"})
public abstract class ShapeStateDrawable extends StateListDrawable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    @Nullable
    public final ColorStateList b;
    @NotNull
    public final Rect c;
    @NotNull
    public final Shape d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JV\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/util/drawable/ShapeStateDrawable$Companion;", "", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "shape", "", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "Landroid/content/res/ColorStateList;", "colorStateList", "rippleColorStateList", "Landroid/graphics/drawable/Drawable;", "invoke", "(Lcom/google/android/material/shape/ShapeAppearanceModel;IIIILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)Landroid/graphics/drawable/Drawable;", "getSHAPE_RECT", "()Lcom/google/android/material/shape/ShapeAppearanceModel;", "SHAPE_RECT", "getSHAPE_OVAL", "SHAPE_OVAL", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Drawable invoke$default(Companion companion, ShapeAppearanceModel shapeAppearanceModel, int i, int i2, int i3, int i4, ColorStateList colorStateList, ColorStateList colorStateList2, int i5, Object obj) {
            return companion.invoke(shapeAppearanceModel, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4, colorStateList, (i5 & 64) != 0 ? null : colorStateList2);
        }

        @NotNull
        public final ShapeAppearanceModel getSHAPE_OVAL() {
            ShapeAppearanceModel build = ShapeAppearanceModel.builder().setAllCornerSizes(new RelativeCornerSize(1.0f)).build();
            Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…\n                .build()");
            return build;
        }

        @NotNull
        public final ShapeAppearanceModel getSHAPE_RECT() {
            ShapeAppearanceModel build = ShapeAppearanceModel.builder().setAllCornerSizes(new AbsoluteCornerSize(0.0f)).build();
            Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…\n                .build()");
            return build;
        }

        @NotNull
        public final Drawable invoke(@NotNull ShapeAppearanceModel shapeAppearanceModel, int i, int i2, int i3, int i4, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
            Integer rippleColor;
            Intrinsics.checkNotNullParameter(shapeAppearanceModel, "shape");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            materialShapeDrawable.setFillColor(colorStateList);
            if (colorStateList2 == null) {
                colorStateList2 = ColorStateList.valueOf((colorStateList == null || (rippleColor = ColorStateListsKt.getRippleColor(colorStateList)) == null) ? 0 : rippleColor.intValue());
                Intrinsics.checkNotNullExpressionValue(colorStateList2, "ColorStateList.valueOf(\n…TRANSPARENT\n            )");
            }
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(shapeAppearanceModel);
            materialShapeDrawable2.setFillColor(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
            Object[] array = CollectionsKt__CollectionsKt.listOfNotNull(new RippleDrawable(colorStateList2, materialShapeDrawable, materialShapeDrawable2)).toArray(new RippleDrawable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) array);
            layerDrawable.setLayerInset(0, i, i2, i3, i4);
            return layerDrawable;
        }

        public Companion(j jVar) {
        }
    }

    public ShapeStateDrawable(@Nullable ColorStateList colorStateList, @NotNull Rect rect, @NotNull Shape shape) {
        Integer rippleColor;
        Intrinsics.checkNotNullParameter(rect, "padding");
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.b = colorStateList;
        this.c = rect;
        this.d = shape;
        this.a = (colorStateList == null || (rippleColor = ColorStateListsKt.getRippleColor(colorStateList)) == null) ? 0 : rippleColor.intValue();
    }

    @Nullable
    public final ColorStateList getColorStateList() {
        return this.b;
    }

    @NotNull
    public final Rect getPadding() {
        return this.c;
    }

    public final int getRippleColor() {
        return this.a;
    }

    @NotNull
    public final Shape getShape() {
        return this.d;
    }
}
