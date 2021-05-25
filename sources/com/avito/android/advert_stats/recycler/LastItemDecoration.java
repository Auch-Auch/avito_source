package com.avito.android.advert_stats.recycler;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.R;
import com.avito.android.advert_stats.item.details.StatDetailItemView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert_stats/recycler/LastItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "e", "I", "bottomPadding", AuthSource.BOOKING_ORDER, "listEmptyArea", "d", "initialGap", "c", "initialItemCount", AuthSource.SEND_ABUSE, "minGapToBottomView", "Landroid/content/res/Resources;", "resources", "<init>", "(ILandroid/content/res/Resources;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class LastItemDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public final int b;
    public int c;
    public int d = -1;
    public final int e;

    public LastItemDecoration(int i, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.e = i;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.button_top_margin) / 2;
        this.a = dimensionPixelSize;
        this.b = i - dimensionPixelSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        boolean z = true;
        int i2 = 0;
        if (recyclerView.getChildAdapterPosition(view) != state.getItemCount() - 1) {
            z = false;
        }
        boolean z2 = recyclerView.getChildViewHolder(view) instanceof StatDetailItemView;
        if (z && z2) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                Intrinsics.checkNotNullExpressionValue(layoutManager, "parent.layoutManager ?: return 0");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == recyclerView.getChildCount() || (i = this.c) <= 0) {
                    int childCount = recyclerView.getChildCount();
                    int i3 = 0;
                    while (i2 < childCount) {
                        i3 += layoutManager.getDecoratedMeasuredHeight(recyclerView.getChildAt(i2));
                        i2++;
                    }
                    i2 = recyclerView.getHeight() - i3;
                    if (this.c == 0) {
                        this.c = itemCount;
                        this.d = i2;
                    }
                } else {
                    i2 = itemCount > i ? -1 : this.d;
                }
            }
            if (i2 < this.b) {
                rect.bottom = this.e;
            }
        }
    }
}
