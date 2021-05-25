package com.yarolegovich.discretescrollview;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RecyclerViewProxy {
    public RecyclerView.LayoutManager a;

    public RecyclerViewProxy(@NonNull RecyclerView.LayoutManager layoutManager) {
        this.a = layoutManager;
    }

    public void attachView(View view) {
        this.a.attachView(view);
    }

    public void detachAndScrapAttachedViews(RecyclerView.Recycler recycler) {
        this.a.detachAndScrapAttachedViews(recycler);
    }

    public void detachAndScrapView(View view, RecyclerView.Recycler recycler) {
        this.a.detachAndScrapView(view, recycler);
    }

    public void detachView(View view) {
        this.a.detachView(view);
    }

    public View getChildAt(int i) {
        return this.a.getChildAt(i);
    }

    public int getChildCount() {
        return this.a.getChildCount();
    }

    public int getHeight() {
        return this.a.getHeight();
    }

    public int getItemCount() {
        return this.a.getItemCount();
    }

    public View getMeasuredChildForAdapterPosition(int i, RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(i);
        this.a.addView(viewForPosition);
        this.a.measureChildWithMargins(viewForPosition, 0, 0);
        return viewForPosition;
    }

    public int getMeasuredHeightWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.a.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public int getMeasuredWidthWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.a.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public int getPosition(View view) {
        return this.a.getPosition(view);
    }

    public int getWidth() {
        return this.a.getWidth();
    }

    public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
        this.a.layoutDecoratedWithMargins(view, i, i2, i3, i4);
    }

    public void offsetChildrenHorizontal(int i) {
        this.a.offsetChildrenHorizontal(i);
    }

    public void offsetChildrenVertical(int i) {
        this.a.offsetChildrenVertical(i);
    }

    public void recycleView(View view, RecyclerView.Recycler recycler) {
        recycler.recycleView(view);
    }

    public void removeAllViews() {
        this.a.removeAllViews();
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        this.a.removeAndRecycleAllViews(recycler);
    }

    public void requestLayout() {
        this.a.requestLayout();
    }

    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        this.a.startSmoothScroll(smoothScroller);
    }
}
