package com.avito.android.component.search.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u0002¢\u0006\u0004\b7\u0010=J?\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010!R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010!R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010!R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010!¨\u0006>"}, d2 = {"Lcom/avito/android/component/search/list/SuggestBubbleView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "backgroundColor", "highlightColor", "strokeColor", "titleColor", "descriptionColor", "", "setColors", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "resetColors", "()V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setDescription", "", "largeHeight", "setHeight", "(Z)V", "Landroid/widget/TextView;", VKApiConst.Q, "Landroid/widget/TextView;", "description", "p", "title", "Landroid/graphics/drawable/GradientDrawable;", "r", "Landroid/graphics/drawable/GradientDrawable;", "backgroundDrawable", "u", "I", "defaultHighlightColorColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "horizontalPadding", "w", "defaultTitleColor", "z", "heightSmall", "Landroid/graphics/drawable/Drawable;", "s", "Landroid/graphics/drawable/Drawable;", "highlightDrawable", "x", "defaultDescriptionColor", "y", "heightLarge", VKApiConst.VERSION, "defaultStrokeColor", "t", "defaultBackgroundColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"NewApi"})
public final class SuggestBubbleView extends LinearLayoutCompat {
    public final int A;
    public final TextView p;
    public final TextView q;
    public final GradientDrawable r;
    public final Drawable s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z = getResources().getDimensionPixelSize(R.dimen.suggest_bubble_item_height_small);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestBubbleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.t = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.u = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.blueAlpha24);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.v = Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.gray8);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        this.w = Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        this.x = Contexts.getColorByAttr(context6, com.avito.android.lib.design.R.attr.gray48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.suggest_bubble_item_height_large);
        this.y = dimensionPixelSize;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.suggest_bubble_item_horizontal_padding);
        this.A = dimensionPixelOffset;
        LayoutInflater.from(getContext()).inflate(R.layout.bubble_suggest_item, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.p = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.description)");
        this.q = (TextView) findViewById2;
        Drawable drawable = Views.getDrawable(this, R.drawable.bg_suggest_bubble);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
        Objects.requireNonNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        this.r = (GradientDrawable) findDrawableByLayerId;
        if (layerDrawable instanceof RippleDrawable) {
            this.s = layerDrawable;
        } else {
            Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(R.id.highlight);
            Intrinsics.checkNotNullExpressionValue(findDrawableByLayerId2, "highlightSelectorDrawable");
            Drawable.ConstantState constantState = findDrawableByLayerId2.getConstantState();
            Objects.requireNonNull(constantState, "null cannot be cast to non-null type android.graphics.drawable.DrawableContainer.DrawableContainerState");
            Drawable drawable2 = ((DrawableContainer.DrawableContainerState) constantState).getChildren()[0];
            Intrinsics.checkNotNullExpressionValue(drawable2, "(highlightSelectorDrawab…ntainerState).children[0]");
            this.s = drawable2;
        }
        setOrientation(1);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-2, dimensionPixelSize));
        setBackground(layerDrawable);
        setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
    }

    public final void resetColors() {
        setColors(Integer.valueOf(this.t), Integer.valueOf(this.u), Integer.valueOf(this.v), Integer.valueOf(this.w), Integer.valueOf(this.x));
    }

    public final void setColors(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5) {
        if (num == null || num2 == null || num3 == null || num4 == null || num5 == null) {
            resetColors();
            return;
        }
        GradientDrawable gradientDrawable = this.r;
        gradientDrawable.setColor(num.intValue());
        gradientDrawable.setStroke(Views.dpToPx(this, 1), num3.intValue());
        Drawable drawable = this.s;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(num2.intValue()));
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(num2.intValue());
        }
        this.p.setTextColor(num4.intValue());
        this.q.setTextColor(num5.intValue());
    }

    public final void setDescription(@Nullable String str) {
        this.q.setText(str);
        if (str == null || str.length() == 0) {
            Views.hide(this.q);
        } else {
            Views.show(this.q);
        }
    }

    public final void setHeight(boolean z2) {
        int i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (z2) {
            i = this.y;
        } else {
            i = this.z;
        }
        layoutParams.height = i;
        requestLayout();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.p.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestBubbleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.t = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.u = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.blueAlpha24);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.v = Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.gray8);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        this.w = Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        this.x = Contexts.getColorByAttr(context6, com.avito.android.lib.design.R.attr.gray48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.suggest_bubble_item_height_large);
        this.y = dimensionPixelSize;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.suggest_bubble_item_horizontal_padding);
        this.A = dimensionPixelOffset;
        LayoutInflater.from(getContext()).inflate(R.layout.bubble_suggest_item, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.p = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.description)");
        this.q = (TextView) findViewById2;
        Drawable drawable = Views.getDrawable(this, R.drawable.bg_suggest_bubble);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
        Objects.requireNonNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        this.r = (GradientDrawable) findDrawableByLayerId;
        if (layerDrawable instanceof RippleDrawable) {
            this.s = layerDrawable;
        } else {
            Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(R.id.highlight);
            Intrinsics.checkNotNullExpressionValue(findDrawableByLayerId2, "highlightSelectorDrawable");
            Drawable.ConstantState constantState = findDrawableByLayerId2.getConstantState();
            Objects.requireNonNull(constantState, "null cannot be cast to non-null type android.graphics.drawable.DrawableContainer.DrawableContainerState");
            Drawable drawable2 = ((DrawableContainer.DrawableContainerState) constantState).getChildren()[0];
            Intrinsics.checkNotNullExpressionValue(drawable2, "(highlightSelectorDrawab…ntainerState).children[0]");
            this.s = drawable2;
        }
        setOrientation(1);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-2, dimensionPixelSize));
        setBackground(layerDrawable);
        setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestBubbleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.t = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.u = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.blueAlpha24);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.v = Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.gray8);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        this.w = Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.black);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        this.x = Contexts.getColorByAttr(context6, com.avito.android.lib.design.R.attr.gray48);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.suggest_bubble_item_height_large);
        this.y = dimensionPixelSize;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.suggest_bubble_item_horizontal_padding);
        this.A = dimensionPixelOffset;
        LayoutInflater.from(getContext()).inflate(R.layout.bubble_suggest_item, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.p = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.description)");
        this.q = (TextView) findViewById2;
        Drawable drawable = Views.getDrawable(this, R.drawable.bg_suggest_bubble);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
        Objects.requireNonNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        this.r = (GradientDrawable) findDrawableByLayerId;
        if (layerDrawable instanceof RippleDrawable) {
            this.s = layerDrawable;
        } else {
            Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(R.id.highlight);
            Intrinsics.checkNotNullExpressionValue(findDrawableByLayerId2, "highlightSelectorDrawable");
            Drawable.ConstantState constantState = findDrawableByLayerId2.getConstantState();
            Objects.requireNonNull(constantState, "null cannot be cast to non-null type android.graphics.drawable.DrawableContainer.DrawableContainerState");
            Drawable drawable2 = ((DrawableContainer.DrawableContainerState) constantState).getChildren()[0];
            Intrinsics.checkNotNullExpressionValue(drawable2, "(highlightSelectorDrawab…ntainerState).children[0]");
            this.s = drawable2;
        }
        setOrientation(1);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-2, dimensionPixelSize));
        setBackground(layerDrawable);
        setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
    }
}
