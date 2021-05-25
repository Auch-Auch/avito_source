package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.di.UserStatsChart;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.android.user_stats.tab.list.items.ChartItemPayload;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;", "view", "Lcom/avito/android/user_stats/tab/list/items/ChartItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;Lcom/avito/android/user_stats/tab/list/items/ChartItem;I)V", "", "", "payloads", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;Lcom/avito/android/user_stats/tab/list/items/ChartItem;ILjava/util/List;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/core/Observable;", "getClicksObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clicksObservable", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenter;", "barItemPresenter", "<init>", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ChartItemPresenterImpl implements ChartItemPresenter {
    @NotNull
    public final Observable<ChartItem.BarItem> a;

    @Inject
    public ChartItemPresenterImpl(@UserStatsChart @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull BarItemPresenter barItemPresenter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(barItemPresenter, "barItemPresenter");
        this.a = barItemPresenter.getClicksObservable();
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter
    @NotNull
    public Observable<ChartItem.BarItem> getClicksObservable() {
        return this.a;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(ChartItemView chartItemView, ChartItem chartItem, int i, List list) {
        bindView(chartItemView, chartItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull ChartItemView chartItemView, @NotNull ChartItem chartItem, int i) {
        Intrinsics.checkNotNullParameter(chartItemView, "view");
        Intrinsics.checkNotNullParameter(chartItem, "item");
        chartItemView.setItems(chartItem.getBarList());
        Iterator<ChartItem.BarItem> it = chartItem.getBarList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().isSelected()) {
                break;
            } else {
                i2++;
            }
        }
        chartItemView.scrollIfNeeded(i2);
    }

    public void bindView(@NotNull ChartItemView chartItemView, @NotNull ChartItem chartItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(chartItemView, "view");
        Intrinsics.checkNotNullParameter(chartItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof ChartItemPayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(chartItemView, chartItem, i);
        } else {
            chartItemView.setItems(t3.getItems());
        }
    }
}
