package com.avito.android.extended_profile.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/extended_profile/adapter/CategoryAdvertGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "columnCount", AuthSource.BOOKING_ORDER, "padding", "<init>", "(II)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public CategoryAdvertGridItemDecoration(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        GridLayoutManager.LayoutParams layoutParams2 = null;
        if (!(layoutParams instanceof GridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        GridLayoutManager.LayoutParams layoutParams3 = (GridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams3 != null) {
            boolean z = true;
            if (layoutParams3.getSpanSize() != 1) {
                return;
            }
            if (this.a == 1) {
                int i = this.b;
                rect.set(i, 0, i, 0);
                return;
            }
            ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
            if (layoutParams4 instanceof GridLayoutManager.LayoutParams) {
                layoutParams2 = layoutParams4;
            }
            GridLayoutManager.LayoutParams layoutParams5 = layoutParams2;
            int spanIndex = layoutParams5 != null ? layoutParams5.getSpanIndex() : -1;
            boolean z2 = spanIndex == 0;
            if (spanIndex != this.a - 1) {
                z = false;
            }
            if (z2) {
                rect.set(this.b, 0, 0, 0);
            } else if (z) {
                rect.set(0, 0, this.b, 0);
            }
        }
    }
}
