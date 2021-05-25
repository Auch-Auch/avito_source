package com.avito.android.advert.item.price_marketplace;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "price", "oldPrice", "discountPercentage", "", "hideDiscountPercent", "", "showPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "applyClosedAdvert", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsPriceMarketplaceView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsPriceMarketplaceView advertDetailsPriceMarketplaceView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsPriceMarketplaceView);
        }
    }

    void applyClosedAdvert();

    void showPrice(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z);
}
