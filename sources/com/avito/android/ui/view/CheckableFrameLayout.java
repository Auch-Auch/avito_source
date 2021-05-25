package com.avito.android.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
public class CheckableFrameLayout extends FrameLayout implements Checkable {
    public static final int[] b = {16842912};
    public boolean a = false;

    public CheckableFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.a;
    }

    @Override // android.view.View, android.view.ViewGroup
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z != this.a) {
            this.a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.a);
    }

    public CheckableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
