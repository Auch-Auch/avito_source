package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
public class InterpolateOnScrollPositionChangeHelper {
    public View a;
    public MaterialShapeDrawable b;
    public ScrollView c;
    public final int[] d = new int[2];
    public final int[] e = new int[2];
    public final ViewTreeObserver.OnScrollChangedListener f = new a();

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            InterpolateOnScrollPositionChangeHelper.this.updateInterpolationForScreenPosition();
        }
    }

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        this.a = view;
        this.b = materialShapeDrawable;
        this.c = scrollView;
    }

    public void setContainingScrollView(ScrollView scrollView) {
        this.c = scrollView;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable) {
        this.b = materialShapeDrawable;
    }

    public void startListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f);
    }

    public void stopListeningForScrollChanges(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView scrollView = this.c;
        if (scrollView != null) {
            if (scrollView.getChildCount() != 0) {
                this.c.getLocationInWindow(this.d);
                this.c.getChildAt(0).getLocationInWindow(this.e);
                int top = (this.a.getTop() - this.d[1]) + this.e[1];
                int height = this.a.getHeight();
                int height2 = this.c.getHeight();
                if (top < 0) {
                    this.b.setInterpolation(Math.max(0.0f, Math.min(1.0f, (((float) top) / ((float) height)) + 1.0f)));
                    this.a.invalidate();
                    return;
                }
                int i = top + height;
                if (i > height2) {
                    this.b.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - (((float) (i - height2)) / ((float) height)))));
                    this.a.invalidate();
                } else if (this.b.getInterpolation() != 1.0f) {
                    this.b.setInterpolation(1.0f);
                    this.a.invalidate();
                }
            } else {
                throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
            }
        }
    }
}
