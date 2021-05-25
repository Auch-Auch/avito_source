package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.di.UserStatsChart;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;", "Lcom/avito/android/user_stats/tab/list/items/ChartItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "getPresenter", "()Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "presenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "c", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "<init>", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ChartItemBlueprint implements ItemBlueprint<ChartItemView, ChartItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ChartItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.user_stats_item_chart, new a(this));
    @NotNull
    public final ChartItemPresenter b;
    public final SimpleRecyclerAdapter c;
    public final AdapterPresenter d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ChartItemViewHolder> {
        public final /* synthetic */ ChartItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChartItemBlueprint chartItemBlueprint) {
            super(2);
            this.a = chartItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ChartItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ChartItemViewHolder(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public ChartItemBlueprint(@NotNull ChartItemPresenter chartItemPresenter, @UserStatsChart @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @UserStatsChart @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(chartItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapter");
        this.b = chartItemPresenter;
        this.c = simpleRecyclerAdapter;
        this.d = adapterPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ChartItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ChartItem;
    }

    /* Return type fixed from 'com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ChartItemView, ChartItem> getPresenter() {
        return this.b;
    }
}
