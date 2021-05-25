package com.avito.android.advert.item.spare_parts;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.util.Kundle;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/spare_parts/SparePartsView;", "Lcom/avito/android/advert/item/spare_parts/SparePartsItem;", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "detach", "()V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface SparePartsPresenter extends ItemPresenter<SparePartsView, SparePartsItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter$Router;", "", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", Navigation.GROUP, "", "openSparePartsBottomSheet", "(Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void openSparePartsBottomSheet(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup);
    }

    void attachRouter(@Nullable Router router);

    void detach();

    @NotNull
    Kundle onSaveState();
}
