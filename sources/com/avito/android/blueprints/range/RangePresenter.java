package com.avito.android.blueprints.range;

import com.avito.android.items.RangeItem;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R(\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/blueprints/range/RangePresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/blueprints/range/RangeItemView;", "Lcom/avito/android/items/RangeItem;", "Lio/reactivex/Observable;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "", "getViewSelectionObservable", "viewSelectionObservable", "Lkotlin/Pair;", "", "getFocusChangesObservable", "focusChangesObservable", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface RangePresenter extends PayloadItemPresenter<RangeItemView, RangeItem> {
    @NotNull
    Observable<Pair<Boolean, RangeItem>> getFocusChangesObservable();

    @NotNull
    Observable<RangeItem> getValueChangesObservable();

    @NotNull
    Observable<String> getViewSelectionObservable();
}
