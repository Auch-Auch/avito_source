package com.avito.android.blueprints.switcher;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.items.CheckBoxItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "Lcom/avito/android/items/CheckBoxItem;", "Lio/reactivex/Observable;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLinkClicksObservable", "deepLinkClicksObservable", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateSwitcherItemPresenter extends ItemPresenter<MultiStateSwitcherItemView, CheckBoxItem> {
    @NotNull
    Observable<DeepLink> getDeepLinkClicksObservable();

    @NotNull
    Observable<CheckBoxItem> getValueChangesObservable();
}
