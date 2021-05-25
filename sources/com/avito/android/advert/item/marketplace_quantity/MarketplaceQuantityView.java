package com.avito.android.advert.item.marketplace_quantity;

import com.avito.android.remote.marketplace.AdvertQuantity;
import com.avito.konveyor.blueprint.ItemView;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/marketplace_quantity/MarketplaceQuantityView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/marketplace/AdvertQuantity;", FirebaseAnalytics.Param.QUANTITY, "", "setQuantity", "(Lcom/avito/android/remote/marketplace/AdvertQuantity;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceQuantityView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceQuantityView marketplaceQuantityView) {
            ItemView.DefaultImpls.onUnbind(marketplaceQuantityView);
        }
    }

    void setQuantity(@NotNull AdvertQuantity advertQuantity);
}
