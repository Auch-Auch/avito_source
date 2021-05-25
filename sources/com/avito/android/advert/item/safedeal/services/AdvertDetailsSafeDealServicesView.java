package com.avito.android.advert.item.safedeal.services;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.remote.model.SafeDeal;
import com.avito.konveyor.blueprint.ItemView;
import com.jakewharton.rxrelay3.Relay;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "viewModel", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "dataRelay", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", "router", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "showServices", "(Lcom/avito/android/remote/model/SafeDeal;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;Landroidx/lifecycle/LifecycleOwner;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsSafeDealServicesView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsSafeDealServicesView advertDetailsSafeDealServicesView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsSafeDealServicesView);
        }
    }

    void showServices(@NotNull SafeDeal safeDeal, @NotNull MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel, @NotNull Relay<MyAdvertSafeDeal> relay, @NotNull MyAdvertSafeDealServicesView.Router router, @NotNull LifecycleOwner lifecycleOwner);
}
