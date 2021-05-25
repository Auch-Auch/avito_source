package com.avito.android.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0019B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/avito/android/design/widget/BoundedFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", "attributeSet", "", "init", "(Landroid/util/AttributeSet;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Lcom/avito/android/design/widget/BoundedViewSpecCalculator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/BoundedViewSpecCalculator;", "widthSpecCalculator", AuthSource.BOOKING_ORDER, "heightSpecCalculator", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BoundedFrameLayout extends FrameLayout {
    public BoundedViewSpecCalculator a;
    public BoundedViewSpecCalculator b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(null);
    }

    public final void init(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BoundedFrameLayout);
            this.a = new BoundedViewSpecCalculator(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoundedFrameLayout_android_minWidth, -1), obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoundedFrameLayout_android_maxWidth, -1));
            this.b = new BoundedViewSpecCalculator(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoundedFrameLayout_android_minHeight, -1), obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoundedFrameLayout_android_maxHeight, -1));
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        BoundedViewSpecCalculator boundedViewSpecCalculator = this.a;
        if (boundedViewSpecCalculator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widthSpecCalculator");
        }
        int calculate = boundedViewSpecCalculator.calculate(i);
        BoundedViewSpecCalculator boundedViewSpecCalculator2 = this.b;
        if (boundedViewSpecCalculator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("heightSpecCalculator");
        }
        super.onMeasure(calculate, boundedViewSpecCalculator2.calculate(i2));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundedFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        init(attributeSet);
    }
}
