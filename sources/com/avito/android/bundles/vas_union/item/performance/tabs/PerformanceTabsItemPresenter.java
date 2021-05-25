package com.avito.android.bundles.vas_union.item.performance.tabs;

import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemView;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItem;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", "getTabCheckedObservable", "()Lio/reactivex/rxjava3/core/Observable;", "tabCheckedObservable", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface PerformanceTabsItemPresenter extends ItemPresenter<PerformanceTabsItemView, PerformanceTabsItem> {
    @NotNull
    Observable<Tab> getTabCheckedObservable();
}
