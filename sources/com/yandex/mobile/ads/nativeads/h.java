package com.yandex.mobile.ads.nativeads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.yandex.mobile.ads.impl.ay;
public final class h implements View.OnTouchListener {
    @NonNull
    private final ay a;
    @NonNull
    private final GestureDetector b;

    public static class a extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public h(@NonNull Context context, @NonNull ay ayVar) {
        this.a = ayVar;
        this.b = new GestureDetector(context.getApplicationContext(), new a());
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (!this.b.onTouchEvent(motionEvent)) {
            return false;
        }
        this.a.c();
        return false;
    }
}
