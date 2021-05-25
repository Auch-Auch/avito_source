package com.avito.android.advert_stats.item;

import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "Lcom/avito/android/advert_stats/item/OnBarItemClickListener;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/PlotItemView;", "Lcom/avito/android/advert_stats/item/PlotItem;", "Lio/reactivex/Observable;", "", "getPlotScrollObservable", "()Lio/reactivex/Observable;", "plotScrollObservable", "Lcom/avito/android/advert_stats/item/BarItem;", "getBarSelectedObservable", "barSelectedObservable", "Lcom/avito/android/advert_stats/item/WeekItem;", "getWeekSelectedObservable", "weekSelectedObservable", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface PlotItemPresenter extends OnBarItemClickListener, ItemPresenter<PlotItemView, PlotItem> {
    @NotNull
    Observable<BarItem> getBarSelectedObservable();

    @NotNull
    Observable<Unit> getPlotScrollObservable();

    @NotNull
    Observable<WeekItem> getWeekSelectedObservable();
}
