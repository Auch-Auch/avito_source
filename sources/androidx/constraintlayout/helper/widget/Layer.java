package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
public class Layer extends ConstraintHelper {
    public float c = Float.NaN;
    public float d = Float.NaN;
    public float e = Float.NaN;
    public ConstraintLayout f;
    public float g = 1.0f;
    public float h = 1.0f;
    public boolean i = true;
    public View[] j = null;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m;
    public float mComputedCenterX = Float.NaN;
    public float mComputedCenterY = Float.NaN;
    public float mComputedMaxX = Float.NaN;
    public float mComputedMaxY = Float.NaN;
    public float mComputedMinX = Float.NaN;
    public float mComputedMinY = Float.NaN;
    public boolean n;

    public Layer(Context context) {
        super(context);
    }

    public void calcCenters() {
        if (this.f != null) {
            if (!(this.i || Float.isNaN(this.mComputedCenterX) || Float.isNaN(this.mComputedCenterY))) {
                return;
            }
            if (Float.isNaN(this.c) || Float.isNaN(this.d)) {
                View[] views = getViews(this.f);
                int left = views[0].getLeft();
                int top = views[0].getTop();
                int right = views[0].getRight();
                int bottom = views[0].getBottom();
                for (int i2 = 0; i2 < this.mCount; i2++) {
                    View view = views[i2];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.mComputedMaxX = (float) right;
                this.mComputedMaxY = (float) bottom;
                this.mComputedMinX = (float) left;
                this.mComputedMinY = (float) top;
                if (Float.isNaN(this.c)) {
                    this.mComputedCenterX = (float) ((left + right) / 2);
                } else {
                    this.mComputedCenterX = this.c;
                }
                if (Float.isNaN(this.d)) {
                    this.mComputedCenterY = (float) ((top + bottom) / 2);
                } else {
                    this.mComputedCenterY = this.d;
                }
            } else {
                this.mComputedCenterY = this.d;
                this.mComputedCenterX = this.c;
            }
        }
    }

    public final void f() {
        int i2;
        if (!(this.f == null || (i2 = this.mCount) == 0)) {
            View[] viewArr = this.j;
            if (viewArr == null || viewArr.length != i2) {
                this.j = new View[i2];
            }
            for (int i3 = 0; i3 < this.mCount; i3++) {
                this.j[i3] = this.f.getViewById(this.mIds[i3]);
            }
        }
    }

    public final void g() {
        if (this.f != null) {
            if (this.j == null) {
                f();
            }
            calcCenters();
            double radians = Float.isNaN(this.e) ? 0.0d : Math.toRadians((double) this.e);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f2 = this.g;
            float f3 = f2 * cos;
            float f4 = this.h;
            float f5 = (-f4) * sin;
            float f6 = f2 * sin;
            float f7 = f4 * cos;
            for (int i2 = 0; i2 < this.mCount; i2++) {
                View view = this.j[i2];
                int left = view.getLeft();
                int top = view.getTop();
                float right = ((float) ((view.getRight() + left) / 2)) - this.mComputedCenterX;
                float bottom = ((float) ((view.getBottom() + top) / 2)) - this.mComputedCenterY;
                view.setTranslationX((((f5 * bottom) + (f3 * right)) - right) + this.k);
                view.setTranslationY((((f7 * bottom) + (right * f6)) - bottom) + this.l);
                view.setScaleY(this.h);
                view.setScaleX(this.g);
                if (!Float.isNaN(this.e)) {
                    view.setRotation(this.e);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.m = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.n = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = (ConstraintLayout) getParent();
        if (this.m || this.n) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.mCount; i2++) {
                View viewById = this.f.getViewById(this.mIds[i2]);
                if (viewById != null) {
                    if (this.m) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.n && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float f2) {
        this.c = f2;
        g();
    }

    @Override // android.view.View
    public void setPivotY(float f2) {
        this.d = f2;
        g();
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.e = f2;
        g();
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        this.g = f2;
        g();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        this.h = f2;
        g();
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        this.k = f2;
        g();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        this.l = f2;
        g();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        f();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), getPaddingRight() + ((int) this.mComputedMaxX), getPaddingBottom() + ((int) this.mComputedMaxY));
        g();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.e = rotation;
        } else if (!Float.isNaN(this.e)) {
            this.e = rotation;
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
