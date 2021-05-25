package com.sothree.slidinguppanel;

import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
public class ScrollableViewHelper {
    public int getScrollableViewScrollPosition(View view, boolean z) {
        int decoratedBottom;
        int bottom;
        int decoratedMeasuredHeight;
        int decoratedTop;
        if (view == null) {
            return 0;
        }
        if (!(view instanceof ScrollView)) {
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                if (listView.getChildCount() > 0) {
                    if (listView.getAdapter() == null) {
                        return 0;
                    }
                    if (z) {
                        View childAt = listView.getChildAt(0);
                        decoratedMeasuredHeight = childAt.getHeight() * listView.getFirstVisiblePosition();
                        decoratedTop = childAt.getTop();
                        return decoratedMeasuredHeight - decoratedTop;
                    }
                    View childAt2 = listView.getChildAt(listView.getChildCount() - 1);
                    int height = childAt2.getHeight();
                    return (childAt2.getBottom() + (height * ((listView.getAdapter().getCount() - listView.getLastVisiblePosition()) - 1))) - listView.getBottom();
                }
            }
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view;
                if (recyclerView.getChildCount() > 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (recyclerView.getAdapter() == null) {
                        return 0;
                    }
                    if (z) {
                        View childAt3 = recyclerView.getChildAt(0);
                        decoratedMeasuredHeight = layoutManager.getDecoratedMeasuredHeight(childAt3) * recyclerView.getChildLayoutPosition(childAt3);
                        decoratedTop = layoutManager.getDecoratedTop(childAt3);
                        return decoratedMeasuredHeight - decoratedTop;
                    }
                    View childAt4 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                    int decoratedMeasuredHeight2 = layoutManager.getDecoratedMeasuredHeight(childAt4);
                    decoratedBottom = layoutManager.getDecoratedBottom(childAt4) + (decoratedMeasuredHeight2 * (recyclerView.getAdapter().getItemCount() - 1));
                    bottom = recyclerView.getBottom();
                }
            }
            return 0;
        } else if (z) {
            return view.getScrollY();
        } else {
            ScrollView scrollView = (ScrollView) view;
            decoratedBottom = scrollView.getChildAt(0).getBottom();
            bottom = scrollView.getScrollY() + scrollView.getHeight();
        }
        return decoratedBottom - bottom;
    }
}
