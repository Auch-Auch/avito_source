package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.Rating;
public final class ne implements View.OnTouchListener {
    private static volatile ne a;
    private static final Object b = new Object();
    private final Handler c = new Handler();
    private final GestureDetector d;
    private boolean e;

    private ne(@NonNull Context context) {
        this.d = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener()) { // from class: com.yandex.mobile.ads.impl.ne.1
            @Override // android.view.GestureDetector
            public final boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }
        };
    }

    public static ne a(@NonNull Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new ne(context);
                }
            }
        }
        return a;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(final View view, MotionEvent motionEvent) {
        if (!(view instanceof TextView) && !(view instanceof Rating)) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            if (view != null && !this.e) {
                view.setAlpha(view.getAlpha() / 2.0f);
                this.e = true;
            }
            this.c.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.ne.2
                @Override // java.lang.Runnable
                public final void run() {
                    ne.a(ne.this, view);
                }
            }, 100);
        }
        return this.d.onTouchEvent(motionEvent);
    }

    public static /* synthetic */ void a(ne neVar, View view) {
        if (view != null && neVar.e) {
            view.setAlpha(view.getAlpha() * 2.0f);
            neVar.e = false;
        }
    }
}
