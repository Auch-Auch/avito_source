package com.avito.android.brandspace.view.decorators;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.R;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/brandspace/view/decorators/SnippetSkeletonItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetSkeletonItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Integer num = null;
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager != null) {
            int spanCount = gridLayoutManager.getSpanCount();
            int itemCount = gridLayoutManager.getItemCount();
            boolean z = true;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) + 1;
            int i = childAdapterPosition % spanCount;
            int i2 = itemCount + 1;
            Integer valueOf = Integer.valueOf(itemCount % spanCount);
            int i3 = 0;
            if (valueOf.intValue() > 0) {
                num = valueOf;
            }
            boolean contains = new IntRange(i2 - (num != null ? num.intValue() : spanCount), itemCount).contains(childAdapterPosition);
            boolean contains2 = new IntRange(0, spanCount).contains(childAdapterPosition);
            boolean z2 = i == 1;
            if (i != 0) {
                z = false;
            }
            Resources resources = view.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.brandspace_column_offset) / 2;
            rect.left = z2 ? 0 : dimensionPixelSize;
            if (z) {
                dimensionPixelSize = 0;
            }
            rect.right = dimensionPixelSize;
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.brandspace_advert_rowspacing) / 2;
            rect.top = contains2 ? 0 : dimensionPixelSize2;
            if (!contains) {
                i3 = dimensionPixelSize2;
            }
            rect.bottom = i3;
        }
    }
}
