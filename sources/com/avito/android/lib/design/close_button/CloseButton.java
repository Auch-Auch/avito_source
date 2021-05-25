package com.avito.android.lib.design.close_button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ColorStateListsKt;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/design/close_button/CloseButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class CloseButton extends AppCompatImageView implements AppearanceChangeableView {
    @JvmOverloads
    public CloseButton(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public CloseButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloseButton(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(TypedArray typedArray) {
        ColorStateList colorStateList;
        Integer rippleColor;
        new ShapeAppearanceModel();
        typedArray.getDimensionPixelSize(R.styleable.CloseButton_closeButton_backgroundMargin, 0);
        ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.CloseButton_closeButton_backgroundColor);
        ColorStateList colorStateList3 = typedArray.getColorStateList(R.styleable.CloseButton_closeButton_backgroundRipple);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(R.styleable.CloseButton_closeButton_backgroundShape, 0), 0).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…  0\n            ).build()");
        Drawable drawable = typedArray.getDrawable(R.styleable.CloseButton_android_src);
        ColorStateList colorStateList4 = typedArray.getColorStateList(R.styleable.CloseButton_android_tint);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        if (colorStateList2 != null) {
            colorStateList = colorStateList2;
        } else {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
        if (colorStateList3 == null) {
            colorStateList3 = ColorStateList.valueOf((colorStateList2 == null || (rippleColor = ColorStateListsKt.getRippleColor(colorStateList2)) == null) ? 0 : rippleColor.intValue());
            Intrinsics.checkNotNullExpressionValue(colorStateList3, "ColorStateList.valueOf(\n…lor.TRANSPARENT\n        )");
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(build);
        materialShapeDrawable2.setFillColor(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3, materialShapeDrawable, materialShapeDrawable2);
        if (drawable != null) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.CloseButton_android_maxWidth, 0);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.CloseButton_android_maxHeight, 0);
            int intrinsicWidth = (dimensionPixelSize - drawable.getIntrinsicWidth()) / 2;
            int intrinsicHeight = (dimensionPixelSize2 - drawable.getIntrinsicHeight()) / 2;
            Views.changePadding(this, intrinsicWidth, intrinsicHeight, intrinsicWidth, intrinsicHeight);
        }
        Object[] array = CollectionsKt__CollectionsKt.listOfNotNull(rippleDrawable).toArray(new RippleDrawable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        setBackground(new LayerDrawable((Drawable[]) array));
        setImageDrawable(drawable);
        setImageTintList(colorStateList4);
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.CloseButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CloseButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CloseButton, i, R.style.Design_Widget_CloseButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
