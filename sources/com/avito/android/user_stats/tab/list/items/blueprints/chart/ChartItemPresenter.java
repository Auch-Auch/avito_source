package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemView;", "Lcom/avito/android/user_stats/tab/list/items/ChartItem;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "getClicksObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clicksObservable", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface ChartItemPresenter extends PayloadItemPresenter<ChartItemView, ChartItem> {
    @NotNull
    Observable<ChartItem.BarItem> getClicksObservable();
}
