package com.avito.android.similar_adverts;

import a2.b.a.a.a;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.avito.android.serp.adapter.skeleton.SkeletonView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "columnPadding", "c", "columnCount", AuthSource.SEND_ABUSE, "padding", "<init>", "(III)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public SimilarAdvertsItemDecoration(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof GridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
        int spanIndex = layoutParams2 != null ? layoutParams2.getSpanIndex() : -1;
        boolean z = true;
        boolean z2 = spanIndex == 0;
        if (spanIndex != this.c - 1) {
            z = false;
        }
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if ((childViewHolder instanceof RdsAdvertItemView) || (childViewHolder instanceof SkeletonView)) {
            if (z2) {
                rect.set(0, this.a, this.b / 2, 0);
            } else if (z) {
                rect.set(this.b / 2, this.a, 0, 0);
            } else {
                int i = this.b;
                rect.set(i / 2, this.a, i / 2, 0);
            }
        }
    }
}
