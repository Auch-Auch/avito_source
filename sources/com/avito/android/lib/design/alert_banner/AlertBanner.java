package com.avito.android.lib.design.alert_banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.close_button.CloseButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u0004\u0012\b\b\u0002\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\b2\b\b\u0003\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\b2\b\b\u0003\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001bJ#\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R(\u0010?\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006H"}, d2 = {"Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "", "visible", "setCloseButtonVisible", "(Z)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseButtonListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/content/res/ColorStateList;", "colorStateList", "rippleColor", "setBackground", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "layoutRes", "styleAttr", "setContentByAttr", "(II)V", "styleRes", "setContentByRes", "Landroid/content/res/TypedArray;", "array", "overrideContentLayoutRes", AuthSource.BOOKING_ORDER, "(Landroid/content/res/TypedArray;Ljava/lang/Integer;)V", "Lcom/google/android/material/shape/ShapeAppearanceModel;", VKApiConst.VERSION, "Lcom/google/android/material/shape/ShapeAppearanceModel;", "backgroundShape", "Lcom/avito/android/lib/design/close_button/CloseButton;", "r", "Lcom/avito/android/lib/design/close_button/CloseButton;", "closeButton", "<set-?>", "u", "I", "getContentLayoutRes", "()I", "contentLayoutRes", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "t", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "getContent", "()Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "content", "Landroid/view/ViewGroup;", VKApiConst.Q, "Landroid/view/ViewGroup;", "container", "s", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"CustomViewStyleable"})
public final class AlertBanner extends ConstraintLayout {
    public ViewGroup q;
    public CloseButton r;
    @Nullable
    public View s;
    @NotNull
    public final AlertBannerContent t;
    public int u;
    public ShapeAppearanceModel v;

    @JvmOverloads
    public AlertBanner(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public AlertBanner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public AlertBanner(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlertBanner(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.alertBanner : i, (i3 & 8) != 0 ? R.style.Design_Widget_AlertBanner : i2);
    }

    public static /* synthetic */ void setBackground$default(AlertBanner alertBanner, ColorStateList colorStateList, ColorStateList colorStateList2, int i, Object obj) {
        if ((i & 2) != 0) {
            colorStateList2 = null;
        }
        alertBanner.setBackground(colorStateList, colorStateList2);
    }

    public static /* synthetic */ void setContentByAttr$default(AlertBanner alertBanner, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = alertBanner.u;
        }
        alertBanner.setContentByAttr(i, i2);
    }

    public static /* synthetic */ void setContentByRes$default(AlertBanner alertBanner, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = alertBanner.u;
        }
        alertBanner.setContentByRes(i, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(@Nullable View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.container;
        if (valueOf != null && valueOf.intValue() == i2) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            this.q = (ViewGroup) view;
        } else {
            int i3 = R.id.close_button;
            if (valueOf == null || valueOf.intValue() != i3) {
                throw new UnsupportedOperationException("Operation addView isn't supported. You should use setContentByRes");
            }
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.close_button.CloseButton");
            this.r = (CloseButton) view;
        }
        super.addView(view, i, layoutParams);
    }

    public final void b(TypedArray typedArray, Integer num) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.AlertBanner_alertBanner_backgroundColor);
            ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.AlertBanner_alertBanner_backgroundRipple);
            ShapeAppearanceModel build = ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(R.styleable.AlertBanner_alertBanner_backgroundShape, 0), 0).build();
            ShapeStateDrawable.Companion companion = ShapeStateDrawable.Companion;
            Intrinsics.checkNotNullExpressionValue(build, "this");
            setBackground(ShapeStateDrawable.Companion.invoke$default(companion, build, 0, 0, 0, 0, colorStateList, colorStateList2, 30, null));
            Unit unit = Unit.INSTANCE;
            this.v = build;
            int i5 = R.styleable.AlertBanner_alertBanner_contentMargin;
            if (typedArray.hasValue(i5)) {
                i4 = typedArray.getDimensionPixelSize(i5, 0);
                i3 = i4;
                i2 = i3;
                i = i2;
            } else {
                i = typedArray.getDimensionPixelSize(R.styleable.AlertBanner_alertBanner_contentMarginRight, 0);
                i2 = typedArray.getDimensionPixelSize(R.styleable.AlertBanner_alertBanner_contentMarginBottom, 0);
                i4 = 0;
                i3 = 0;
            }
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.AlertBanner_alertBanner_closeAndContentSpacing, 0);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i4;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = dimensionPixelSize;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2;
            layoutParams2.goneEndMargin = i;
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.AlertBanner_alertBanner_closeMarginTop, 0);
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R.styleable.AlertBanner_alertBanner_closeMarginRight, 0);
            CloseButton closeButton = this.r;
            if (closeButton != null) {
                Views.changeMargin$default(closeButton, 0, dimensionPixelSize2, dimensionPixelSize3, 0, 9, null);
            }
            CloseButton closeButton2 = this.r;
            if (closeButton2 != null) {
                closeButton2.setAppearance(typedArray.getResourceId(R.styleable.AlertBanner_alertBanner_closeStyle, 0));
            }
            int resourceId = typedArray.getResourceId(R.styleable.AlertBanner_alertBanner_contentStyle, 0);
            this.u = num != null ? num.intValue() : typedArray.getResourceId(R.styleable.AlertBanner_alertBanner_content, 0);
            View inflate = LayoutInflater.from(new ContextThemeWrapper(getContext(), resourceId)).inflate(this.u, viewGroup, false);
            this.s = inflate;
            this.t.attachView$components_release(inflate);
            viewGroup.removeAllViews();
            viewGroup.addView(this.s, 0);
            return;
        }
        throw new IllegalStateException("Alert hasn't been initialized yet");
    }

    @NotNull
    public final AlertBannerContent getContent() {
        return this.t;
    }

    public final int getContentLayoutRes() {
        return this.u;
    }

    @Nullable
    public final View getContentView() {
        return this.s;
    }

    public final void setBackground(@NotNull ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        ShapeAppearanceModel shapeAppearanceModel = this.v;
        if (shapeAppearanceModel != null) {
            setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, shapeAppearanceModel, 0, 0, 0, 0, colorStateList, colorStateList2, 30, null));
        }
    }

    public final void setCloseButtonListener(@Nullable View.OnClickListener onClickListener) {
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            closeButton.setOnClickListener(onClickListener);
        }
    }

    public final void setCloseButtonVisible(boolean z) {
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            Views.setVisible(closeButton, z);
        }
    }

    public final void setContentByAttr(@LayoutRes int i, @AttrRes int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setContentByRes(i, Contexts.getResourceIdByAttr(context, i2));
    }

    public final void setContentByRes(@LayoutRes int i, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.AlertBanner, 0, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes, Integer.valueOf(i));
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlertBanner(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.design_alert_banner, (ViewGroup) this, true);
        this.t = new AlertBannerContent(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AlertBanner, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes, null);
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            Views.setVisible(closeButton, obtainStyledAttributes.getBoolean(R.styleable.AlertBanner_alertBanner_closeVisible, false));
        }
        obtainStyledAttributes.recycle();
    }
}
