package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    @NonNull
    public final Dialog a;
    public final int b;
    public final int c;
    public final int d;

    public InsetDialogOnTouchListener(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.a = dialog;
        this.b = rect.left;
        this.c = rect.top;
        this.d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.b;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.c;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.d;
            obtain.setLocation((float) ((-i) - 1), (float) ((-i) - 1));
        }
        view.performClick();
        return this.a.onTouchEvent(obtain);
    }
}
