package com.facebook.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.shimmer.Shimmer;
public class ShimmerFrameLayout extends FrameLayout {
    public final Paint a = new Paint();
    public final ShimmerDrawable b = new ShimmerDrawable();

    public ShimmerFrameLayout(Context context) {
        super(context);
        a(context, null);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            int i = R.styleable.ShimmerFrameLayout_shimmer_colored;
            setShimmer(((!obtainStyledAttributes.hasValue(i) || !obtainStyledAttributes.getBoolean(i, false)) ? new Shimmer.AlphaHighlightBuilder() : new Shimmer.ColorHighlightBuilder()).a(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.b.draw(canvas);
    }

    public boolean isShimmerStarted() {
        return this.b.isShimmerStarted();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.a();
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

    public ShimmerFrameLayout setShimmer(@Nullable Shimmer shimmer) {
        this.b.setShimmer(shimmer);
        if (shimmer == null || !shimmer.n) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.a);
        }
        return this;
    }

    public void startShimmer() {
        this.b.startShimmer();
    }

    public void stopShimmer() {
        this.b.stopShimmer();
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }
}
