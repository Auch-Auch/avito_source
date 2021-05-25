package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "", "Lcom/avito/android/remote/model/Location;", "location", "()Lcom/avito/android/remote/model/Location;", "", "saveLocation", "(Lcom/avito/android/remote/model/Location;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceDeliveryStorage {
    @Nullable
    Location location();

    void saveLocation(@NotNull Location location);
}
