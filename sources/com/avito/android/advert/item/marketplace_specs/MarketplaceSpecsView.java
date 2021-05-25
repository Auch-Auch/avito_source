package com.avito.android.advert.item.marketplace_specs;

import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "item", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showSpecs", "(Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceSpecsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceSpecsView marketplaceSpecsView) {
            ItemView.DefaultImpls.onUnbind(marketplaceSpecsView);
        }
    }

    void showSpecs(@NotNull MarketplaceSpecsItem marketplaceSpecsItem, @NotNull MarketplaceSpecsPresenter.Listener listener);
}
