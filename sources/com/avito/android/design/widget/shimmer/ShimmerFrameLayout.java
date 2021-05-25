package com.avito.android.design.widget.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.avito.android.design.widget.shimmer.Shimmer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-B\u0019\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b,\u0010\"B!\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010.\u001a\u00020\f¢\u0006\u0004\b,\u0010/B)\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010.\u001a\u00020\f\u0012\u0006\u00100\u001a\u00020\f¢\u0006\u0004\b,\u00101J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ7\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"R\u0013\u0010#\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/design/widget/shimmer/ShimmerFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/shimmer/Shimmer;", "shimmer", "setShimmer", "(Lcom/avito/android/design/widget/shimmer/Shimmer;)Lcom/avito/android/design/widget/shimmer/ShimmerFrameLayout;", "", "startShimmer", "()V", "stopShimmer", "", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShimmerStarted", "()Z", "Lcom/avito/android/design/widget/shimmer/ShimmerDrawable;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/shimmer/ShimmerDrawable;", "mShimmerDrawable", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mContentPaint", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShimmerFrameLayout extends FrameLayout {
    public final Paint a = new Paint();
    public final ShimmerDrawable b = new ShimmerDrawable();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Shimmer.Builder builder;
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            int i = R.styleable.ShimmerFrameLayout_shimmer_colored;
            if (!obtainStyledAttributes.hasValue(i) || !obtainStyledAttributes.getBoolean(i, false)) {
                builder = new Shimmer.AlphaHighlightBuilder();
            } else {
                builder = new Shimmer.ColorHighlightBuilder();
            }
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
            setShimmer(builder.consumeAttributes$ui_components_release(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        this.b.draw(canvas);
    }

    public final boolean isShimmerStarted() {
        return this.b.isShimmerStarted();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.maybeStartShimmer$ui_components_release();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.setBounds(0, 0, getWidth(), getHeight());
    }

    @NotNull
    public final ShimmerFrameLayout setShimmer(@Nullable Shimmer shimmer) {
        this.b.setShimmer(shimmer);
        if (shimmer == null || !shimmer.getClipToChildren$ui_components_release()) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.a);
        }
        return this;
    }

    public final void startShimmer() {
        this.b.startShimmer();
    }

    public final void stopShimmer() {
        this.b.stopShimmer();
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        return super.verifyDrawable(drawable) || drawable == this.b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }
}
