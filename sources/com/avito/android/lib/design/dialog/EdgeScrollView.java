package com.avito.android.lib.design.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u001d\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B%\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0013\u0010\u001aJ%\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/dialog/EdgeScrollView;", "Landroid/widget/ScrollView;", "Landroid/graphics/drawable/Drawable;", "top", "bottom", "", "setEdgeDrawables", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable;", "topDrawable", AuthSource.BOOKING_ORDER, "bottomDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class EdgeScrollView extends ScrollView {
    public Drawable a;
    public Drawable b;

    public EdgeScrollView(@Nullable Context context) {
        super(context);
    }

    public static /* synthetic */ void setEdgeDrawables$default(EdgeScrollView edgeScrollView, Drawable drawable, Drawable drawable2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = edgeScrollView.a;
        }
        if ((i & 2) != 0) {
            drawable2 = edgeScrollView.b;
        }
        edgeScrollView.setEdgeDrawables(drawable, drawable2);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            int i = 0;
            View childAt = getChildAt(0);
            int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            Drawable drawable = this.b;
            if (drawable != null) {
                drawable.setBounds(computeHorizontalScrollOffset + 0, (getMeasuredHeight() + computeVerticalScrollOffset) - (childAt != null ? childAt.getPaddingBottom() : 0), getMeasuredWidth() + computeHorizontalScrollOffset, getMeasuredHeight() + computeVerticalScrollOffset);
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.a;
            if (drawable2 != null) {
                int i2 = computeHorizontalScrollOffset + 0;
                int measuredWidth = getMeasuredWidth() + computeHorizontalScrollOffset;
                if (childAt != null) {
                    i = childAt.getPaddingTop();
                }
                drawable2.setBounds(i2, computeVerticalScrollOffset, measuredWidth, i + computeVerticalScrollOffset);
                drawable2.draw(canvas);
            }
        }
    }

    public final void setEdgeDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this.a = drawable;
        this.b = drawable2;
        invalidate();
    }

    public EdgeScrollView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EdgeScrollView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
