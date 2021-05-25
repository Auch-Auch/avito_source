package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class VerticalSearchFilterItemDecoratorKt {
    public static final int access$getSpanIndex(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof GridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            return layoutParams2.getSpanIndex();
        }
        return 0;
    }

    public static final int access$getSpanSize(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof GridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            return layoutParams2.getSpanSize();
        }
        return 1;
    }
}
