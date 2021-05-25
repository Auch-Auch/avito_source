package com.avito.android.advert.item.marketplace_brief_specs;

import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter;
import com.avito.android.remote.marketplace.InStock;
import com.avito.android.remote.marketplace.SpecificationItem;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/remote/marketplace/SpecificationItem;", "params", "Lcom/avito/android/remote/marketplace/InStock;", "inStock", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showSpecs", "(Ljava/util/List;Lcom/avito/android/remote/marketplace/InStock;Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceBriefSpecsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceBriefSpecsView marketplaceBriefSpecsView) {
            ItemView.DefaultImpls.onUnbind(marketplaceBriefSpecsView);
        }
    }

    void showSpecs(@NotNull List<SpecificationItem> list, @Nullable InStock inStock, @NotNull MarketplaceBriefSpecsPresenter.Listener listener);
}
