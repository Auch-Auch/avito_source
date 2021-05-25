package com.my.target;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class ht extends LinearLayoutManager {
    @Nullable
    public a I;

    public interface a {
        void eA();
    }

    public ht(Context context) {
        super(context, 0, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NonNull View view, int i, int i2) {
        int c = io.c(10, view.getContext());
        if (getPosition(view) > 0) {
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin = c;
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(((int) (((float) getWidth()) * 0.7f)) - c, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight > getHeight()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(((int) (((float) getWidth()) * (((((float) getHeight()) - ((float) (c * 2))) * 0.7f) / ((float) measuredHeight)))) - c, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        a aVar = this.I;
        if (aVar != null) {
            aVar.eA();
        }
    }
}
