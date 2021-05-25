package com.avito.android.lib.design.shadow_layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b,\u0010.B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010/\u001a\u00020\u001d¢\u0006\u0004\b,\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "enabled", "setShadowEnabled", "(Z)V", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/LinearLayout$LayoutParams;", "Landroid/util/AttributeSet;", "attrs", "(Landroid/util/AttributeSet;)Landroid/widget/LinearLayout$LayoutParams;", "Lcom/avito/android/lib/design/shadow_layout/ShadowLinearLayout$LayoutParams;", "generateDefaultLayoutParams", "()Lcom/avito/android/lib/design/shadow_layout/ShadowLinearLayout$LayoutParams;", "params", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "shadowPaint", "", "d", "I", "offsetY", "c", "offsetX", "Landroid/graphics/Rect;", AuthSource.SEND_ABUSE, "Landroid/graphics/Rect;", "rect", "e", "Z", "shadowEnabled", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ShadowLinearLayout extends LinearLayout {
    public final Rect a;
    public Paint b;
    public int c;
    public int d;
    public boolean e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.e) {
            int i = 0;
            int childCount = getChildCount() - 1;
            if (childCount >= 0) {
                while (true) {
                    View childAt = getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (!(layoutParams instanceof LayoutParams)) {
                        layoutParams = null;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                    if (layoutParams2 != null && layoutParams2.isShadowEnabled()) {
                        childAt.getDrawingRect(this.a);
                        offsetDescendantRectToMyCoords(childAt, this.a);
                        Rect rect = this.a;
                        int i2 = rect.left;
                        int i3 = this.c;
                        float f = (float) (i2 + i3);
                        int i4 = rect.top;
                        int i5 = this.d;
                        float f2 = (float) (i4 + i5);
                        float f3 = (float) (rect.right + i3);
                        float f4 = (float) (rect.bottom + i5);
                        Paint paint = this.b;
                        if (paint == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shadowPaint");
                        }
                        canvas.drawRect(f, f2, f3, f4, paint);
                    }
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void setShadowEnabled(boolean z) {
        this.e = z;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.shadowLayout);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setWillNotDraw(false);
        setLayerType(1, null);
        this.a = new Rect();
        this.e = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout, i, R.style.Design_Widget_ShadowLayout);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ShadowLayout_shadowLayout_shadowDx, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ShadowLayout_shadowLayout_shadowDy, 0);
        int i2 = R.styleable.ShadowLayout_shadowLayout_shadowColor;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int color = obtainStyledAttributes.getColor(i2, Contexts.getColorByAttr(context2, R.attr.black));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShadowLayout_shadowLayout_shadowBlurRadius, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_shadowLayout_shadowEnabled, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        paint.setMaskFilter(new BlurMaskFilter((float) dimensionPixelSize, BlurMaskFilter.Blur.NORMAL));
        paint.setColor(color);
        Unit unit = Unit.INSTANCE;
        this.b = paint;
        this.c = dimensionPixelOffset;
        this.d = dimensionPixelOffset2;
        this.e = z;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return new LayoutParams(layoutParams);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\r\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0016¢\u0006\u0004\b\r\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowLinearLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "", AuthSource.SEND_ABUSE, "Z", "isShadowEnabled", "()Z", "setShadowEnabled", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/LinearLayout$LayoutParams;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        public boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout_Layout);
            this.a = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_Layout_layout_shadowEnabled, false);
            obtainStyledAttributes.recycle();
        }

        public final boolean isShadowEnabled() {
            return this.a;
        }

        public final void setShadowEnabled(boolean z) {
            this.a = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                this.a = ((LayoutParams) layoutParams).a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Intrinsics.checkNotNullParameter(marginLayoutParams, "source");
            if (marginLayoutParams instanceof LayoutParams) {
                this.a = ((LayoutParams) marginLayoutParams).a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                this.a = ((LayoutParams) layoutParams).a;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new LayoutParams(context, attributeSet);
    }
}
