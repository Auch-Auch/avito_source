package com.my.target;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class gz extends LinearLayoutManager {
    public final int I;
    public int J;
    @Nullable
    public a K;
    public int L;
    public int M;
    public int N;
    public int O;

    public interface a {
        void ei();
    }

    public gz(Context context) {
        super(context, 0, false);
        this.I = io.af(context).L(4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i, int i2) {
        int height = getHeight();
        int width = getWidth();
        if (height != this.O || width != this.N || this.L <= 0 || this.M <= 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
            float width2 = ((float) getWidth()) / ((float) view.getMeasuredWidth());
            this.L = width2 > 1.0f ? (int) (((double) ((float) width)) / (Math.floor((double) width2) + 0.5d)) : (int) (((float) width) / 1.5f);
            this.M = height;
            this.N = width;
            this.O = height;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (view != getChildAt(0)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = io.c(this.J / 2, view.getContext());
        }
        if (view != getChildAt(getChildCount())) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = io.c(this.J / 2, view.getContext());
        }
        int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(width, getWidthMode(), 0, this.L, canScrollHorizontally());
        int heightMode = getHeightMode();
        int i3 = this.I;
        view.measure(childMeasureSpec, RecyclerView.LayoutManager.getChildMeasureSpec(height, heightMode, i3, height - (i3 * 2), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        a aVar = this.K;
        if (aVar != null) {
            aVar.ei();
        }
    }
}
