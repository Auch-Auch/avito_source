package com.vk.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
public class WebView extends android.webkit.WebView {
    public WebView(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this;
        while (view.getParent() instanceof View) {
            view = (View) view.getParent();
            view.setBackgroundColor(0);
        }
    }

    public WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
