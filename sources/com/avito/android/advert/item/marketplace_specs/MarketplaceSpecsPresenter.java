package com.avito.android.advert.item.marketplace_specs;

import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsView;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceSpecsPresenter extends ItemPresenter<MarketplaceSpecsView, MarketplaceSpecsItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", "", "", "onMarketplaceSpecsClick", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onMarketplaceSpecsClick();
    }
}
