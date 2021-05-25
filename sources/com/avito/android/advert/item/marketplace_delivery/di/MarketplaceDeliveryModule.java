package com.avito.android.advert.item.marketplace_delivery.di;

import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryBlueprint;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenterImpl;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorageImpl;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryView;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/di/MarketplaceDeliveryModule;", "", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "bindMarketplaceDeliveryPresenter", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenterImpl;)Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "bindMarketplaceDeliveryBlueprint", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorageImpl;", "storage", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "bindMarketplaceDeliveryStorage", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorageImpl;)Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface MarketplaceDeliveryModule {
    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<MarketplaceDeliveryView, MarketplaceDeliveryItem> bindMarketplaceDeliveryBlueprint(@NotNull MarketplaceDeliveryBlueprint marketplaceDeliveryBlueprint);

    @PerFragment
    @Binds
    @NotNull
    MarketplaceDeliveryPresenter bindMarketplaceDeliveryPresenter(@NotNull MarketplaceDeliveryPresenterImpl marketplaceDeliveryPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    MarketplaceDeliveryStorage bindMarketplaceDeliveryStorage(@NotNull MarketplaceDeliveryStorageImpl marketplaceDeliveryStorageImpl);
}
