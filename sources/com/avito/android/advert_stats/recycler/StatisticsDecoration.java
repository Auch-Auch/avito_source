package com.avito.android.advert_stats.recycler;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.R;
import com.avito.android.advert_stats.item.PlotItemView;
import com.avito.android.advert_stats.item.details.StatDetailItemView;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItemView;
import com.avito.android.advert_stats.item.hint.HintItemView;
import com.avito.android.advert_stats.item.period.PeriodItemView;
import com.avito.android.advert_stats.item.title.TitleItemView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_stats/recycler/StatisticsDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "mediumMargin", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", AuthSource.SEND_ABUSE, "largeMargin", "<init>", "(Landroid/content/res/Resources;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticsDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Resources c;

    public StatisticsDecoration(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.c = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.recycler_side_margin);
        this.b = resources.getDimensionPixelSize(R.dimen.details_item_margin);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        Intrinsics.checkNotNullExpressionValue(childViewHolder, "viewHolder");
        int i3 = 0;
        if (childViewHolder instanceof TitleItemView) {
            i = this.b;
        } else if (childViewHolder instanceof HintItemView) {
            i = this.c.getDimensionPixelSize(R.dimen.period_to_title_margin);
        } else if (childViewHolder instanceof PlotItemView) {
            i = this.a;
        } else if (childViewHolder instanceof NewStatisticsBannerItemView) {
            i = this.a;
        } else if (childViewHolder instanceof PeriodItemView) {
            i = childAdapterPosition == 0 ? this.c.getDimensionPixelSize(R.dimen.period_to_top_padding) : this.c.getDimensionPixelSize(R.dimen.period_to_title_margin);
        } else {
            i = 0;
        }
        rect.top = i;
        rect.bottom = childViewHolder instanceof StatDetailItemView ? ((StatDetailItemView) childViewHolder).isStatusView() ? this.a : this.b : 0;
        boolean z = childViewHolder instanceof PlotItemView;
        if (z) {
            i2 = 0;
        } else if (childViewHolder instanceof NewStatisticsBannerItemView) {
            i2 = this.b;
        } else {
            i2 = this.a;
        }
        rect.left = i2;
        if (!z) {
            if (childViewHolder instanceof NewStatisticsBannerItemView) {
                i3 = this.b;
            } else {
                i3 = this.a;
            }
        }
        rect.right = i3;
    }
}
