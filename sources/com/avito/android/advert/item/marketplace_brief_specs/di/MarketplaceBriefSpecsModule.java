package com.avito.android.advert.item.marketplace_brief_specs.di;

import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsBlueprint;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsItem;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenterImpl;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsView;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/marketplace_brief_specs/di/MarketplaceBriefSpecsModule;", "", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter;", "bindMarketplaceBriefSpecsPresenter", "(Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenterImpl;)Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsView;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;", "bindMarketplaceBriefSpecsBlueprint", "(Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface MarketplaceBriefSpecsModule {
    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<MarketplaceBriefSpecsView, MarketplaceBriefSpecsItem> bindMarketplaceBriefSpecsBlueprint(@NotNull MarketplaceBriefSpecsBlueprint marketplaceBriefSpecsBlueprint);

    @PerFragment
    @Binds
    @NotNull
    MarketplaceBriefSpecsPresenter bindMarketplaceBriefSpecsPresenter(@NotNull MarketplaceBriefSpecsPresenterImpl marketplaceBriefSpecsPresenterImpl);
}
