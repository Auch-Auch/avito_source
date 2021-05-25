package com.google.android.material.card;

import a2.j.b.d.h.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.maps.android.heatmaps.WeightedLatLng;
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    public static final int[] o = {16842911};
    public static final int[] p = {16842912};
    public static final int[] q = {R.attr.state_dragged};
    public static final int r = R.style.Widget_MaterialComponents_CardView;
    @NonNull
    public final a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public OnCheckedChangeListener n;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.j.c.getBounds());
        return rectF;
    }

    public final void b() {
        a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 26 && (drawable = (aVar = this.j).n) != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            aVar.n.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.j.c.getFillColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.j.d.getFillColor();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.j.i;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.j.e;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.j.f;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.j.k;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.j.b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.j.b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.j.b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.j.b.top;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.j.c.getInterpolation();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.j.c.getTopLeftCornerResolvedSize();
    }

    public ColorStateList getRippleColor() {
        return this.j.j;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.j.l;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.j.m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.j.m;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.j.g;
    }

    public boolean isCheckable() {
        a aVar = this.j;
        return aVar != null && aVar.s;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    public boolean isDragged() {
        return this.m;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.j.c);
    }

    @Override // android.view.View, android.view.ViewGroup
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, o);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isDragged()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        a aVar = this.j;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.o != null) {
            int i5 = aVar.e;
            int i6 = aVar.f;
            int i7 = (measuredWidth - i5) - i6;
            int i8 = (measuredHeight - i5) - i6;
            if (aVar.a.getUseCompatPadding()) {
                i8 -= (int) Math.ceil((double) (aVar.d() * 2.0f));
                i7 -= (int) Math.ceil((double) (aVar.c() * 2.0f));
            }
            int i9 = aVar.e;
            if (ViewCompat.getLayoutDirection(aVar.a) == 1) {
                i3 = i7;
                i4 = i9;
            } else {
                i4 = i7;
                i3 = i9;
            }
            aVar.o.setLayerInset(2, i4, aVar.e, i3, i8);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.k) {
            a aVar = this.j;
            if (!aVar.r) {
                aVar.r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        a aVar = this.j;
        aVar.c.setFillColor(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        a aVar = this.j;
        aVar.c.setElevation(aVar.a.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.j.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.j.s = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.l != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.j.g(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i) {
        this.j.e = i;
    }

    public void setCheckedIconMarginResource(@DimenRes int i) {
        if (i != -1) {
            this.j.e = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        this.j.g(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(@Dimension int i) {
        this.j.f = i;
    }

    public void setCheckedIconSizeResource(@DimenRes int i) {
        if (i != 0) {
            this.j.f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        a aVar = this.j;
        aVar.k = colorStateList;
        Drawable drawable = aVar.i;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        a aVar = this.j;
        if (aVar != null) {
            Drawable drawable = aVar.h;
            Drawable e = aVar.a.isClickable() ? aVar.e() : aVar.d;
            aVar.h = e;
            if (drawable == e) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || !(aVar.a.getForeground() instanceof InsetDrawable)) {
                aVar.a.setForeground(aVar.f(e));
            } else {
                ((InsetDrawable) aVar.a.getForeground()).setDrawable(e);
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        a aVar = this.j;
        aVar.b.set(i, i2, i3, i4);
        aVar.k();
    }

    public void setDragged(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.j.l();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.n = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.j.l();
        this.j.k();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        a aVar = this.j;
        aVar.c.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = aVar.d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = aVar.q;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        a aVar = this.j;
        aVar.h(aVar.l.withCornerSize(f));
        aVar.h.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        a aVar = this.j;
        aVar.j = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(@ColorRes int i) {
        a aVar = this.j;
        aVar.j = AppCompatResources.getColorStateList(getContext(), i);
        aVar.m();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.j.h(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i) {
        a aVar = this.j;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (aVar.m != valueOf) {
            aVar.m = valueOf;
            aVar.n();
        }
    }

    public void setStrokeWidth(@Dimension int i) {
        a aVar = this.j;
        if (i != aVar.g) {
            aVar.g = i;
            aVar.n();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.j.l();
        this.j.k();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.l = !this.l;
            refreshDrawableState();
            b();
            OnCheckedChangeListener onCheckedChangeListener = this.n;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.l);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.j.c.setFillColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        a aVar = this.j;
        if (aVar.m != colorStateList) {
            aVar.m = colorStateList;
            aVar.n();
        }
    }
}
