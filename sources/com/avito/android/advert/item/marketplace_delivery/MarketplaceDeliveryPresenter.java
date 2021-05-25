package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Location;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "Lcom/avito/android/remote/model/Location;", "location", "", "onLocationChanged", "(Lcom/avito/android/remote/model/Location;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceDeliveryPresenter extends ItemPresenter<MarketplaceDeliveryView, MarketplaceDeliveryItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", "", "", "onMarketplaceDeliveryChangeCity", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "onMarketplaceDeliveryMapClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onMarketplaceDeliveryChangeCity();

        void onMarketplaceDeliveryMapClick(@Nullable DeepLink deepLink);
    }

    void onLocationChanged(@Nullable Location location);
}
