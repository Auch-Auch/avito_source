package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "c", "I", "shadowPadding", AuthSource.SEND_ABUSE, "paddingBetweenItems", AuthSource.BOOKING_ORDER, "borderPadding", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public BarItemDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources.getDimensionPixelSize(R.dimen.user_stats_bar_item_padding);
        this.b = resources.getDimensionPixelSize(R.dimen.user_stats_chart_border_padding);
        this.c = resources.getDimensionPixelSize(R.dimen.user_stats_bar_item_card_padding) + resources.getDimensionPixelSize(R.dimen.user_stats_bar_shadow_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(childViewHolder.itemView);
        int i = 0;
        int i2 = childAdapterPosition == 0 ? this.b : 0;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
            i = this.b;
        }
        int i3 = this.a;
        int i4 = i2 + i3;
        int i5 = i + i3;
        if (!(childViewHolder instanceof BarItemViewHolder) || !((BarItemViewHolder) childViewHolder).isSelected()) {
            rect.left = i4;
            rect.right = i5;
            return;
        }
        int i6 = this.c;
        rect.left = i4 - i6;
        rect.right = i5 - i6;
    }
}
