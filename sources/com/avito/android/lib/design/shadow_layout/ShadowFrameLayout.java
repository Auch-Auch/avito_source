package com.avito.android.lib.design.shadow_layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101B\u001b\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b0\u00102B#\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u00103\u001a\u00020\u001c¢\u0006\u0004\b0\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "enabled", "setShadowEnabled", "(Z)V", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "Landroid/util/AttributeSet;", "attrs", "Landroid/widget/FrameLayout$LayoutParams;", "(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;", "Lcom/avito/android/lib/design/shadow_layout/ShadowFrameLayout$LayoutParams;", "generateDefaultLayoutParams", "()Lcom/avito/android/lib/design/shadow_layout/ShadowFrameLayout$LayoutParams;", "params", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", "e", "Z", "shadowEnabled", "", "d", "I", "offsetY", "c", "offsetX", "Landroid/content/res/ColorStateList;", "f", "Landroid/content/res/ColorStateList;", "shadowColor", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "shadowPaint", "Landroid/graphics/Rect;", AuthSource.SEND_ABUSE, "Landroid/graphics/Rect;", "rect", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ShadowFrameLayout extends FrameLayout {
    public final Rect a;
    public Paint b;
    public int c;
    public int d;
    public boolean e;
    public ColorStateList f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowFrameLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        int childCount;
        ColorStateList colorStateList;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.e && (childCount = getChildCount() - 1) >= 0) {
            int i = 0;
            while (true) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = null;
                if (!(layoutParams instanceof LayoutParams)) {
                    layoutParams = null;
                }
                LayoutParams layoutParams3 = (LayoutParams) layoutParams;
                if (layoutParams3 != null && layoutParams3.isShadowEnabled()) {
                    childAt.getDrawingRect(this.a);
                    offsetDescendantRectToMyCoords(childAt, this.a);
                    Paint paint = this.b;
                    if (paint == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shadowPaint");
                    }
                    ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                    if (layoutParams4 instanceof LayoutParams) {
                        layoutParams2 = layoutParams4;
                    }
                    LayoutParams layoutParams5 = layoutParams2;
                    if (layoutParams5 == null || (colorStateList = layoutParams5.getShadowColor()) == null) {
                        colorStateList = this.f;
                    }
                    paint.setColor(colorStateList != null ? colorStateList.getColorForState(getDrawableState(), 0) : 0);
                    Rect rect = this.a;
                    int i2 = rect.left;
                    int i3 = this.c;
                    float f2 = (float) (i2 + i3);
                    int i4 = rect.top;
                    int i5 = this.d;
                    float f3 = (float) (i4 + i5);
                    float f4 = (float) (rect.right + i3);
                    float f5 = (float) (rect.bottom + i5);
                    Paint paint2 = this.b;
                    if (paint2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shadowPaint");
                    }
                    canvas.drawRect(f2, f3, f4, f5, paint2);
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setShadowEnabled(boolean z) {
        this.e = z;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.shadowLayout);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setWillNotDraw(false);
        setLayerType(1, null);
        this.a = new Rect();
        this.e = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout, i, R.style.Design_Widget_ShadowLayout);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ShadowLayout_shadowLayout_shadowDx, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ShadowLayout_shadowLayout_shadowDy, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.ShadowLayout_shadowLayout_shadowColor);
        if (colorStateList == null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            colorStateList = Contexts.getColorStateListByAttr(context2, R.attr.black);
        }
        this.f = colorStateList;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShadowLayout_shadowLayout_shadowBlurRadius, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_shadowLayout_shadowEnabled, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        paint.setMaskFilter(new BlurMaskFilter((float) dimensionPixelSize, BlurMaskFilter.Blur.NORMAL));
        Unit unit = Unit.INSTANCE;
        this.b = paint;
        this.c = dimensionPixelOffset;
        this.d = dimensionPixelOffset2;
        this.e = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @NotNull
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @NotNull
    public FrameLayout.LayoutParams generateLayoutParams(@NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new LayoutParams(context, attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u001aB!\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0015\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020 ¢\u0006\u0004\b\u0015\u0010!B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\"R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowFrameLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "", AuthSource.SEND_ABUSE, "Z", "isShadowEnabled", "()Z", "setShadowEnabled", "(Z)V", "Landroid/content/res/ColorStateList;", AuthSource.BOOKING_ORDER, "Landroid/content/res/ColorStateList;", "getShadowColor", "()Landroid/content/res/ColorStateList;", "setShadowColor", "(Landroid/content/res/ColorStateList;)V", "shadowColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "gravity", "(III)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/FrameLayout$LayoutParams;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public boolean a;
        @Nullable
        public ColorStateList b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout_Layout);
            this.a = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_Layout_layout_shadowEnabled, false);
            this.b = obtainStyledAttributes.getColorStateList(R.styleable.ShadowLayout_Layout_layout_shadowColor);
            obtainStyledAttributes.recycle();
        }

        @Nullable
        public final ColorStateList getShadowColor() {
            return this.b;
        }

        public final boolean isShadowEnabled() {
            return this.a;
        }

        public final void setShadowColor(@Nullable ColorStateList colorStateList) {
            this.b = colorStateList;
        }

        public final void setShadowEnabled(boolean z) {
            this.a = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.a = layoutParams2.a;
                this.b = layoutParams2.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Intrinsics.checkNotNullParameter(marginLayoutParams, "source");
            if (marginLayoutParams instanceof LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) marginLayoutParams;
                this.a = layoutParams.a;
                this.b = layoutParams.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.a = layoutParams2.a;
                this.b = layoutParams2.b;
            }
        }
    }
}
