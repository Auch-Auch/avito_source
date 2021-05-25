package com.avito.android.advert.item.marketplace_info;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoView;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceInfoPresenter extends ItemPresenter<MarketplaceInfoView, MarketplaceInfoItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoPresenter$Listener;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "", "onMarketplaceInfoClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onMarketplaceInfoClick(@Nullable DeepLink deepLink);
    }
}
