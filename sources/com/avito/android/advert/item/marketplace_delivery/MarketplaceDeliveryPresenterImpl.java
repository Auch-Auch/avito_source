package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenterImpl;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "view", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;I)V", "Lcom/avito/android/remote/model/Location;", "location", "onLocationChanged", "(Lcom/avito/android/remote/model/Location;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "currentView", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", "c", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "currentItem", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "d", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "locationStorage", "<init>", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryPresenterImpl implements MarketplaceDeliveryPresenter {
    public MarketplaceDeliveryView a;
    public MarketplaceDeliveryItem b;
    public final MarketplaceDeliveryPresenter.Listener c;
    public final MarketplaceDeliveryStorage d;

    @Inject
    public MarketplaceDeliveryPresenterImpl(@NotNull MarketplaceDeliveryPresenter.Listener listener, @NotNull MarketplaceDeliveryStorage marketplaceDeliveryStorage) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(marketplaceDeliveryStorage, "locationStorage");
        this.c = listener;
        this.d = marketplaceDeliveryStorage;
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter
    public void onLocationChanged(@Nullable Location location) {
        if (location != null) {
            MarketplaceDeliveryView marketplaceDeliveryView = this.a;
            if (marketplaceDeliveryView != null) {
                marketplaceDeliveryView.disableDeliveryInfo();
            }
            MarketplaceDeliveryItem marketplaceDeliveryItem = this.b;
            if (marketplaceDeliveryItem != null) {
                marketplaceDeliveryItem.setLocationTo(location);
            }
            this.d.saveLocation(location);
        }
    }

    public void bindView(@NotNull MarketplaceDeliveryView marketplaceDeliveryView, @NotNull MarketplaceDeliveryItem marketplaceDeliveryItem, int i) {
        Intrinsics.checkNotNullParameter(marketplaceDeliveryView, "view");
        Intrinsics.checkNotNullParameter(marketplaceDeliveryItem, "item");
        this.a = marketplaceDeliveryView;
        this.b = marketplaceDeliveryItem;
        marketplaceDeliveryView.showDelivery(marketplaceDeliveryItem, this.c);
    }
}
