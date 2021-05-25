package com.avito.android.advert.item.price;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/price/AdvertDetailsPricePresenterImpl;", "Lcom/avito/android/advert/item/price/AdvertDetailsPricePresenter;", "Lcom/avito/android/advert/item/price/AdvertDetailsPriceView;", "view", "Lcom/avito/android/advert/item/price/AdvertDetailsPriceItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/price/AdvertDetailsPriceView;Lcom/avito/android/advert/item/price/AdvertDetailsPriceItem;I)V", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPricePresenterImpl implements AdvertDetailsPricePresenter {
    public void bindView(@NotNull AdvertDetailsPriceView advertDetailsPriceView, @NotNull AdvertDetailsPriceItem advertDetailsPriceItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsPriceView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsPriceItem, "item");
        advertDetailsPriceView.showPrice(advertDetailsPriceItem.getPrice(), advertDetailsPriceItem.getOldPrice());
        if (advertDetailsPriceItem.getClosedAdvert()) {
            advertDetailsPriceView.applyClosedAdvert();
        }
    }
}
