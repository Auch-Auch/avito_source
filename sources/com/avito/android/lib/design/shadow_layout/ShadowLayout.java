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
import android.widget.FrameLayout;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = "Don't use. You must use ShadowFrameLayout or ShadowLinearLayout instead it", replaceWith = @ReplaceWith(expression = "ShadowFrameLayout", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101B\u0019\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b0\u00102B!\b\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b0\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u0016\u0010-\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010$¨\u00065"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "enableShadows", "setEnableShadows", "(Z)V", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "Landroid/util/AttributeSet;", "attrs", "Landroid/widget/FrameLayout$LayoutParams;", "(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;", "Lcom/avito/android/lib/design/shadow_layout/ShadowLayout$LayoutParams;", "generateDefaultLayoutParams", "()Lcom/avito/android/lib/design/shadow_layout/ShadowLayout$LayoutParams;", "params", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", "", "defStyleAttr", AuthSource.BOOKING_ORDER, "(Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "(Landroid/graphics/Canvas;Landroid/view/View;)V", "e", "Z", "d", "I", "offsetY", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "shadowPaint", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "rect", "c", "offsetX", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ShadowLayout extends FrameLayout {
    public final Rect a = new Rect();
    public Paint b;
    public int c;
    public int d;
    public boolean e = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public final void a(Canvas canvas, View view) {
        view.getDrawingRect(this.a);
        offsetDescendantRectToMyCoords(view, this.a);
        Rect rect = this.a;
        int i = rect.left;
        int i2 = this.c;
        float f = (float) (i + i2);
        int i3 = rect.top;
        int i4 = this.d;
        float f2 = (float) (i3 + i4);
        float f3 = (float) (rect.right + i2);
        float f4 = (float) (rect.bottom + i4);
        Paint paint = this.b;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowPaint");
        }
        canvas.drawRect(f, f2, f3, f4, paint);
    }

    public final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DesignShadowLayout);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.DesignShadowLayout_design_dx, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.DesignShadowLayout_design_dy, 0);
        int i = R.styleable.DesignShadowLayout_android_shadowColor;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int color = obtainStyledAttributes.getColor(i, Contexts.getColorByAttr(context, R.attr.black));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignShadowLayout_design_blur_radius, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DesignShadowLayout_design_enable_shadows, true);
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

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        int childCount;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.e && getChildCount() - 1 >= 0) {
            int i = 0;
            while (true) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (!(childAt instanceof ViewGroup) || !(layoutParams instanceof LayoutParams) || !((LayoutParams) layoutParams).isShadowContainer()) {
                    a(canvas, childAt);
                } else {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    int childCount2 = viewGroup.getChildCount() - 1;
                    if (childCount2 >= 0) {
                        int i2 = 0;
                        while (true) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(i)");
                            a(canvas, childAt2);
                            if (i2 == childCount2) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setEnableShadows(boolean z) {
        this.e = z;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @NotNull
    public ViewGroup.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return new LayoutParams(layoutParams);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0012B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\r\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0018¢\u0006\u0004\b\r\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/shadow_layout/ShadowLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "", AuthSource.SEND_ABUSE, "Z", "isShadowContainer", "()Z", "setShadowContainer", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "gravity", "(III)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/FrameLayout$LayoutParams;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DesignShadowLayout);
            this.a = obtainStyledAttributes.getBoolean(R.styleable.DesignShadowLayout_layout_isShadowContainer, false);
            obtainStyledAttributes.recycle();
        }

        public final boolean isShadowContainer() {
            return this.a;
        }

        public final void setShadowContainer(boolean z) {
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
        public LayoutParams(@NotNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                this.a = ((LayoutParams) layoutParams).a;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setWillNotDraw(false);
        setLayerType(1, null);
        b(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setWillNotDraw(false);
        setLayerType(1, null);
        b(attributeSet);
    }
}
