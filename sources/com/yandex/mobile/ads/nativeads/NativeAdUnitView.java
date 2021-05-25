package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
public class NativeAdUnitView extends u<ab> {
    @Nullable
    private View.OnTouchListener a;
    private TextView b;

    public NativeAdUnitView(Context context) {
        super(context);
    }

    public final TextView a() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setSponsoredView(TextView textView) {
        this.b = textView;
    }

    public NativeAdUnitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(@NonNull View.OnTouchListener onTouchListener) {
        this.a = onTouchListener;
    }

    @Override // com.yandex.mobile.ads.nativeads.u
    public ab getNativeAd() {
        return (ab) super.getNativeAd();
    }

    public NativeAdUnitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
