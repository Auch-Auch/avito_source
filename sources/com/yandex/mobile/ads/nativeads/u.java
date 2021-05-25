package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.yandex.mobile.ads.nativeads.ba;
public abstract class u<T extends ba> extends FrameLayout {
    @Nullable
    private T a;

    public u(Context context) {
        super(context);
    }

    public final void a(@NonNull T t) {
        this.a = t;
    }

    @Nullable
    public T getNativeAd() {
        return this.a;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        T t = this.a;
        if (t != null) {
            t.b();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        T t = this.a;
        if (t != null) {
            t.c();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        a((i != 0 || !isShown()) ? 8 : 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        getVisibility();
        a((i == 0 && getVisibility() == 0) ? 0 : 8);
        super.onWindowVisibilityChanged(i);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i) {
        T t = this.a;
        if (t != null) {
            t.a(i);
        }
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
