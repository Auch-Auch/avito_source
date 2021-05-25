package com.avito.android.blueprints.range.cre_range;

import com.avito.android.blueprints.range.RangeItemView;
import com.avito.android.items.RangeItem;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R(\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/blueprints/range/RangeItemView;", "Lcom/avito/android/items/RangeItem$CreRangeItem;", "Lio/reactivex/Observable;", "Lcom/avito/android/items/RangeItem;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "", "getViewSelectionObservable", "viewSelectionObservable", "Lkotlin/Pair;", "", "getFocusChangesObservable", "focusChangesObservable", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface CreRangePresenter extends PayloadItemPresenter<RangeItemView, RangeItem.CreRangeItem> {
    @NotNull
    Observable<Pair<Boolean, RangeItem>> getFocusChangesObservable();

    @NotNull
    Observable<RangeItem> getValueChangesObservable();

    @NotNull
    Observable<String> getViewSelectionObservable();
}
