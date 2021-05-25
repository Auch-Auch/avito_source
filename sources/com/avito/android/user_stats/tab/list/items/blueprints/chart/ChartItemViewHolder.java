package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.user_stats.di.UserStatsChart;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemView;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0001\u0010\u0010\u001a\u00020\r\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/conveyor_item/Item;", "items", "", "setItems", "(Ljava/util/List;)V", "", "selectedColumnIndex", "scrollIfNeeded", "(I)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "t", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "plotRecyclerView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "u", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ChartItemViewHolder extends BaseViewHolder implements ChartItemView {
    public final RecyclerView s;
    public final SimpleRecyclerAdapter t;
    public final AdapterPresenter u;

    public static final class a implements Runnable {
        public final /* synthetic */ ChartItemViewHolder a;
        public final /* synthetic */ int b;

        public a(ChartItemViewHolder chartItemViewHolder, int i) {
            this.a = chartItemViewHolder;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.LayoutManager layoutManager = this.a.s.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int i = this.b;
                if (i < findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                    linearLayoutManager.scrollToPosition(i);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChartItemViewHolder(@NotNull View view, @UserStatsChart @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @UserStatsChart @NotNull AdapterPresenter adapterPresenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapter");
        this.t = simpleRecyclerAdapter;
        this.u = adapterPresenter;
        RecyclerView recyclerView = (RecyclerView) view;
        this.s = recyclerView;
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
        recyclerView.addItemDecoration(new BarItemDecoration(resources));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ChartItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemView
    public void scrollIfNeeded(int i) {
        this.s.post(new a(this, i));
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemView
    public void setItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        a2.b.a.a.a.s1(list, this.u);
    }
}
