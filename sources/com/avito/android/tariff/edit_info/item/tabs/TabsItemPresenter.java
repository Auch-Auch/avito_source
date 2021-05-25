package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "", "unbindListener", "()V", "Lio/reactivex/Observable;", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "getTabSelects", "()Lio/reactivex/Observable;", "tabSelects", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TabsItemPresenter extends ItemPresenter<TabsItemView, TabsItem> {
    @NotNull
    Observable<PeriodTab> getTabSelects();

    void unbindListener();
}
