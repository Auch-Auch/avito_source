package com.avito.android.advert.item.safedeal.services;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.util.UrlParams;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesView;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsSafeDealServicesPresenter extends ItemPresenter<AdvertDetailsSafeDealServicesView, AdvertDetailsSafeDealServicesItem> {
    void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner);
}
