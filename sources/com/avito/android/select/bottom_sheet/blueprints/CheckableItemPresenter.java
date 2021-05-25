package com.avito.android.select.bottom_sheet.blueprints;

import com.avito.android.select.VariantItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemView;", "Lcom/avito/android/select/VariantItem;", "Lio/reactivex/rxjava3/core/Observable;", "getItemClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "itemClickObservable", "Router", "select_release"}, k = 1, mv = {1, 4, 2})
public interface CheckableItemPresenter extends ItemPresenter<CheckableItemView, VariantItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter$Router;", "", "Lcom/avito/android/select/VariantItem;", "item", "", "onItemClicked", "(Lcom/avito/android/select/VariantItem;)V", "select_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onItemClicked(@NotNull VariantItem variantItem);
    }

    @NotNull
    Observable<VariantItem> getItemClickObservable();
}
