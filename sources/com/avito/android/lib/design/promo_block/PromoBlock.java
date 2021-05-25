package com.avito.android.lib.design.promo_block;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.close_button.CloseButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.facebook.internal.AnalyticsEvents;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0017\u0012\b\b\u0002\u0010X\u001a\u00020\u0017¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001b\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010\u001d\u001a\u00020\u00172\b\b\u0001\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00052\b\b\u0001\u0010\u001d\u001a\u00020\u00172\b\b\u0001\u0010!\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0017H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b'\u0010\u0007J\u0015\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b(\u0010\u0007J#\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00103R\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00106R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006["}, d2 = {"Lcom/avito/android/lib/design/promo_block/PromoBlock;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "visible", "", "setCloseButtonVisible", "(Z)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseButtonListener", "(Landroid/view/View$OnClickListener;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "Landroid/content/res/ColorStateList;", "colorStateList", "rippleColor", "setBackground", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "layoutRes", "styleAttr", "setContent", "(II)V", "styleRes", "setContentByRes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "(I)V", "rounded", "setTopEdgeRounded", "setBottomEdgeRounded", "Landroid/content/res/TypedArray;", "array", "overrideContentLayoutRes", AuthSource.BOOKING_ORDER, "(Landroid/content/res/TypedArray;Ljava/lang/Integer;)V", "Landroid/view/ViewGroup;", VKApiConst.Q, "Landroid/view/ViewGroup;", "container", "w", "Landroid/content/res/ColorStateList;", "backgroundColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "bottomEdgeRounded", "Lcom/avito/android/lib/design/close_button/CloseButton;", "r", "Lcom/avito/android/lib/design/close_button/CloseButton;", "closeButton", "", "y", "F", "cornerRadius", "u", "Landroid/view/View;", "contentView", "Lcom/google/android/material/shape/ShapeAppearanceModel;", VKApiConst.VERSION, "Lcom/google/android/material/shape/ShapeAppearanceModel;", "backgroundShape", "x", "backgroundRipple", "z", "topEdgeRounded", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroidx/constraintlayout/widget/Guideline;", "t", "Landroidx/constraintlayout/widget/Guideline;", "guidelineTopPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PromoBlock extends ConstraintLayout implements AppearanceChangeableView {
    public boolean A;
    public ViewGroup q;
    public CloseButton r;
    public TextView s;
    public Guideline t;
    public View u;
    public ShapeAppearanceModel v;
    public ColorStateList w;
    public ColorStateList x;
    public float y;
    public boolean z;

    @JvmOverloads
    public PromoBlock(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public PromoBlock(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public PromoBlock(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoBlock(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.promoBlock : i, (i3 & 8) != 0 ? R.style.Design_Widget_PromoBlock : i2);
    }

    public static /* synthetic */ void setBackground$default(PromoBlock promoBlock, ColorStateList colorStateList, ColorStateList colorStateList2, int i, Object obj) {
        if ((i & 2) != 0) {
            colorStateList2 = null;
        }
        promoBlock.setBackground(colorStateList, colorStateList2);
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
            if (valueOf != null && valueOf.intValue() == i3) {
                Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.close_button.CloseButton");
                this.r = (CloseButton) view;
            } else {
                int i4 = R.id.title;
                if (valueOf != null && valueOf.intValue() == i4) {
                    Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
                    this.s = (TextView) view;
                } else {
                    int i5 = R.id.guideline_top_padding;
                    if (valueOf != null && valueOf.intValue() == i5) {
                        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.constraintlayout.widget.Guideline");
                        this.t = (Guideline) view;
                    } else {
                        int i6 = R.id.container_top_barrier;
                        if (valueOf == null || valueOf.intValue() != i6) {
                            throw new UnsupportedOperationException("Operation addView isn't supported. You should use setContentByRes " + view);
                        }
                    }
                }
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b(TypedArray typedArray, Integer num) {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            TextView textView = this.s;
            if (textView != null) {
                this.w = typedArray.getColorStateList(R.styleable.PromoBlock_promoBlock_backgroundColor);
                this.x = typedArray.getColorStateList(R.styleable.PromoBlock_promoBlock_backgroundRipple);
                this.y = typedArray.getDimension(R.styleable.PromoBlock_promoBlock_cornerRadius, 0.0f);
                ShapeAppearanceModel build = ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(R.styleable.PromoBlock_promoBlock_backgroundShape, 0), 0).setAllCornerSizes(this.y).build();
                Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…\n                .build()");
                setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, build, 0, 0, 0, 0, this.w, this.x, 30, null));
                Unit unit = Unit.INSTANCE;
                this.v = build;
                int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_contentPaddingLeft, 0);
                int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_contentPaddingTop, 0);
                int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_contentPaddingRight, 0);
                setPadding(dimensionPixelSize, 0, 0, typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_contentPaddingBottom, 0));
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).rightMargin = dimensionPixelSize3;
                int dimensionPixelSize4 = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_closeAndContentSpacing, 0);
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
                ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = dimensionPixelSize4;
                layoutParams3.goneEndMargin = dimensionPixelSize3;
                Guideline guideline = this.t;
                if (guideline != null) {
                    guideline.setGuidelineBegin(dimensionPixelSize2);
                }
                int dimensionPixelSize5 = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_closeMarginTop, 0);
                int dimensionPixelSize6 = typedArray.getDimensionPixelSize(R.styleable.PromoBlock_promoBlock_closeMarginRight, 0);
                CloseButton closeButton = this.r;
                if (closeButton != null) {
                    Views.changeMargin$default(closeButton, 0, dimensionPixelSize5, dimensionPixelSize6, 0, 9, null);
                }
                CloseButton closeButton2 = this.r;
                if (closeButton2 != null) {
                    closeButton2.setAppearance(typedArray.getResourceId(R.styleable.PromoBlock_promoBlock_closeStyle, 0));
                }
                TextViews.setTextAppearanceCompat(textView, typedArray.getResourceId(R.styleable.PromoBlock_promoBlock_titleStyle, 0));
                int intValue = num != null ? num.intValue() : typedArray.getResourceId(R.styleable.PromoBlock_promoBlock_content, 0);
                if (intValue != 0) {
                    this.u = LayoutInflater.from(getContext()).inflate(intValue, viewGroup, false);
                    viewGroup.removeAllViews();
                    viewGroup.addView(this.u, 0);
                    return;
                }
                return;
            }
            throw new IllegalStateException("PromoBlock hasn't been initialized yet");
        }
        throw new IllegalStateException("PromoBlock hasn't been initialized yet");
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.PromoBlock);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes, null);
        obtainStyledAttributes.recycle();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setBackground(@NotNull ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        this.w = colorStateList;
        this.x = colorStateList2;
        setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, this.v, 0, 0, 0, 0, colorStateList, colorStateList2, 30, null));
    }

    public final void setBottomEdgeRounded(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            Float valueOf = Float.valueOf(this.y);
            valueOf.floatValue();
            if (!z2) {
                valueOf = null;
            }
            float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
            ShapeAppearanceModel build = this.v.toBuilder().setBottomLeftCornerSize(floatValue).setBottomRightCornerSize(floatValue).build();
            Intrinsics.checkNotNullExpressionValue(build, "backgroundShape\n        …ius)\n            .build()");
            this.v = build;
            setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, build, 0, 0, 0, 0, this.w, this.x, 30, null));
        }
    }

    public final void setCloseButtonListener(@Nullable View.OnClickListener onClickListener) {
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            closeButton.setOnClickListener(onClickListener);
        }
    }

    public final void setCloseButtonVisible(boolean z2) {
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            Views.setVisible(closeButton, z2);
        }
    }

    public final void setContent(@LayoutRes int i, @AttrRes int i2) {
        setContentByRes(i, Contexts.getResourceIdByAttr(getContext(), i2));
    }

    public final void setContentByRes(@LayoutRes int i, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.PromoBlock, 0, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes, Integer.valueOf(i));
        obtainStyledAttributes.recycle();
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        TextView textView = this.s;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setTopEdgeRounded(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            Float valueOf = Float.valueOf(this.y);
            valueOf.floatValue();
            if (!z2) {
                valueOf = null;
            }
            float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
            ShapeAppearanceModel build = this.v.toBuilder().setTopLeftCornerSize(floatValue).setTopRightCornerSize(floatValue).build();
            Intrinsics.checkNotNullExpressionValue(build, "backgroundShape\n        …ius)\n            .build()");
            this.v = build;
            setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, build, 0, 0, 0, 0, this.w, this.x, 30, null));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromoBlock(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.builder().build()");
        this.v = build;
        this.z = true;
        this.A = true;
        LayoutInflater.from(context).inflate(R.layout.design_promo_block, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PromoBlock, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes, null);
        CloseButton closeButton = this.r;
        if (closeButton != null) {
            Views.setVisible(closeButton, obtainStyledAttributes.getBoolean(R.styleable.PromoBlock_promoBlock_closeVisible, false));
        }
        setTitle(obtainStyledAttributes.getString(R.styleable.PromoBlock_promoBlock_title));
        setTopEdgeRounded(obtainStyledAttributes.getBoolean(R.styleable.PromoBlock_promoBlock_topEdgeRounded, this.z));
        setBottomEdgeRounded(obtainStyledAttributes.getBoolean(R.styleable.PromoBlock_promoBlock_bottomEdgeRounded, this.A));
        obtainStyledAttributes.recycle();
    }
}
