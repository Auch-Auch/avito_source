package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "item", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDelivery", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;)V", "disableDeliveryInfo", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceDeliveryView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceDeliveryView marketplaceDeliveryView) {
            ItemView.DefaultImpls.onUnbind(marketplaceDeliveryView);
        }
    }

    void disableDeliveryInfo();

    void showDelivery(@NotNull MarketplaceDeliveryItem marketplaceDeliveryItem, @Nullable MarketplaceDeliveryPresenter.Listener listener);
}
