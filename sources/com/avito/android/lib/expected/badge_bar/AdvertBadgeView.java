package com.avito.android.lib.expected.badge_bar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.avito.android.design.State;
import com.avito.android.lib.design.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u001c\u0010$\u001a\u00020\u001f8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u00061"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "color", "", "setTextColor", "(I)V", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "maxLines", "setTitleMaxLines", "setSubtitleMaxLines", "Landroid/content/res/ColorStateList;", "rippleColor", "setBackground", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "showIconLoading", "()V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "descriptionView", "Lcom/google/android/material/shape/ShapeAppearanceModel;", VKApiConst.Q, "Lcom/google/android/material/shape/ShapeAppearanceModel;", "backgroundShape", "s", "titleView", "Lcom/avito/android/lib/expected/badge_bar/ImageLoadableView;", "u", "Lcom/avito/android/lib/expected/badge_bar/ImageLoadableView;", "getIconView$components_release", "()Lcom/avito/android/lib/expected/badge_bar/ImageLoadableView;", "iconView", "Landroid/graphics/drawable/Drawable;", "r", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeView extends ConstraintLayout {
    public ShapeAppearanceModel q;
    public Drawable r;
    public final TextView s;
    public final TextView t;
    @NotNull
    public final ImageLoadableView u;

    @JvmOverloads
    public AdvertBadgeView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public AdvertBadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public AdvertBadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertBadgeView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.advertBadgeView : i, (i3 & 8) != 0 ? R.style.Design_Widget_AdvertBadgeView : i2);
    }

    @NotNull
    public final ImageLoadableView getIconView$components_release() {
        return this.u;
    }

    public final void setBackground(@NotNull ColorStateList colorStateList, @NotNull ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        Intrinsics.checkNotNullParameter(colorStateList2, "rippleColor");
        ShapeAppearanceModel shapeAppearanceModel = this.q;
        if (shapeAppearanceModel != null) {
            setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, shapeAppearanceModel, 0, 0, 0, 0, colorStateList, colorStateList2, 30, null));
        }
    }

    public final void setSubtitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.t.setText(charSequence);
    }

    public final void setSubtitleMaxLines(int i) {
        this.t.setMaxLines(i);
    }

    public final void setTextColor(int i) {
        this.s.setTextColor(i);
        this.t.setTextColor(i);
    }

    public final void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.s.setText(charSequence);
    }

    public final void setTitleMaxLines(int i) {
        this.s.setMaxLines(i);
    }

    public final void showIconLoading() {
        this.u.setState(State.PLACEHOLDER);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdvertBadgeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.advert_badge_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.s = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.t = textView2;
        View findViewById3 = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.icon)");
        ImageLoadableView imageLoadableView = (ImageLoadableView) findViewById3;
        this.u = imageLoadableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdvertBadgeView, i, i2);
        int i3 = R.styleable.AdvertBadgeView_advertBadgeView_titleAppearance;
        if (obtainStyledAttributes.hasValue(i3)) {
            TextViews.setTextAppearanceCompat(textView, obtainStyledAttributes.getResourceId(i3, 0));
        }
        int i4 = R.styleable.AdvertBadgeView_advertBadgeView_descriptionAppearance;
        if (obtainStyledAttributes.hasValue(i4)) {
            TextViews.setTextAppearanceCompat(textView2, obtainStyledAttributes.getResourceId(i4, 0));
        }
        int i5 = R.styleable.AdvertBadgeView_advertBadgeView_iconWidth;
        if (obtainStyledAttributes.hasValue(i5)) {
            imageLoadableView.getLayoutParams().width = obtainStyledAttributes.getDimensionPixelOffset(i5, 0);
        }
        int i6 = R.styleable.AdvertBadgeView_advertBadgeView_iconHeight;
        if (obtainStyledAttributes.hasValue(i6)) {
            imageLoadableView.getLayoutParams().height = obtainStyledAttributes.getDimensionPixelOffset(i6, 0);
        }
        int i7 = R.styleable.AdvertBadgeView_advertBadgeView_iconLeftMargin;
        if (obtainStyledAttributes.hasValue(i7)) {
            ViewGroup.LayoutParams layoutParams = imageLoadableView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = obtainStyledAttributes.getDimensionPixelOffset(i7, 0);
        }
        int i8 = R.styleable.AdvertBadgeView_advertBadgeView_iconTopMargin;
        if (obtainStyledAttributes.hasValue(i8)) {
            ViewGroup.LayoutParams layoutParams2 = imageLoadableView.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = obtainStyledAttributes.getDimensionPixelOffset(i8, 0);
        }
        int i9 = R.styleable.AdvertBadgeView_advertBadgeView_iconBottomMargin;
        if (obtainStyledAttributes.hasValue(i9)) {
            ViewGroup.LayoutParams layoutParams3 = imageLoadableView.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = obtainStyledAttributes.getDimensionPixelOffset(i9, 0);
        }
        int i10 = R.styleable.AdvertBadgeView_advertBadgeView_textStartMargin;
        if (obtainStyledAttributes.hasValue(i10)) {
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = obtainStyledAttributes.getDimensionPixelOffset(i10, 0);
            ViewGroup.LayoutParams layoutParams5 = textView2.getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = obtainStyledAttributes.getDimensionPixelOffset(i10, 0);
        }
        int i11 = R.styleable.AdvertBadgeView_advertBadgeView_textEndMargin;
        if (obtainStyledAttributes.hasValue(i11)) {
            ViewGroup.LayoutParams layoutParams6 = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = obtainStyledAttributes.getDimensionPixelOffset(i11, 0);
            ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
            Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = obtainStyledAttributes.getDimensionPixelOffset(i11, 0);
        }
        int i12 = R.styleable.AdvertBadgeView_advertBadgeView_titleTopMargin;
        if (obtainStyledAttributes.hasValue(i12)) {
            ViewGroup.LayoutParams layoutParams8 = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = obtainStyledAttributes.getDimensionPixelOffset(i12, 0);
        }
        int i13 = R.styleable.AdvertBadgeView_advertBadgeView_descriptionBottomMargin;
        if (obtainStyledAttributes.hasValue(i13)) {
            ViewGroup.LayoutParams layoutParams9 = textView2.getLayoutParams();
            Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin = obtainStyledAttributes.getDimensionPixelOffset(i13, 0);
        }
        int i14 = R.styleable.AdvertBadgeView_advertBadgeView_textDividerSize;
        if (obtainStyledAttributes.hasValue(i14)) {
            ViewGroup.LayoutParams layoutParams10 = textView2.getLayoutParams();
            Objects.requireNonNull(layoutParams10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = obtainStyledAttributes.getDimensionPixelOffset(i14, 0);
        }
        int i15 = R.styleable.AdvertBadgeView_advertBadgeView_iconPlaceholder;
        if (obtainStyledAttributes.hasValue(i15)) {
            Drawable drawable = ContextCompat.getDrawable(context, obtainStyledAttributes.getResourceId(i15, 0));
            this.r = drawable;
            imageLoadableView.setPlaceholderDrawable(drawable);
        }
        int i16 = R.styleable.AdvertBadgeView_advertBadgeView_titleMaxLines;
        if (obtainStyledAttributes.hasValue(i16)) {
            textView.setMaxLines(obtainStyledAttributes.getInteger(i16, 0));
        }
        int i17 = R.styleable.AdvertBadgeView_advertBadgeView_descriptionMaxLines;
        if (obtainStyledAttributes.hasValue(i17)) {
            textView2.setMaxLines(obtainStyledAttributes.getInteger(i17, 0));
        }
        int i18 = R.styleable.AdvertBadgeView_advertBadgeView_backgroundShape;
        if (obtainStyledAttributes.hasValue(i18)) {
            this.q = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(i18, 0), 0).build();
        }
        obtainStyledAttributes.recycle();
        showIconLoading();
    }
}
