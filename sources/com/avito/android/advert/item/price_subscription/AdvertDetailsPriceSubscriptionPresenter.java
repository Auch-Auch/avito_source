package com.avito.android.advert.item.price_subscription;

import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionView;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionItem;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setPriceSubscriptionListener", "(Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsPriceSubscriptionPresenter extends ItemPresenter<AdvertDetailsPriceSubscriptionView, AdvertDetailsPriceSubscriptionItem> {
    void setPriceSubscriptionListener(@NotNull AdvertDetailsPriceSubscriptionView.Listener listener);
}
