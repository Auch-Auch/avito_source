package com.avito.android.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.LinearLayoutCompat;
public class CheckableLinearLayout extends LinearLayoutCompat implements Checkable {
    public static final int[] q = {16842912};
    public boolean p = false;

    public CheckableLinearLayout(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z != this.p) {
            this.p = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.p);
    }

    public CheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
