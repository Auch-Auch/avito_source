package com.avito.android.advert.item.commercials;

import com.avito.android.remote.model.SerpDisplayType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "", "", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "banners", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/advert/item/commercials/AdvertCommercials;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/advert/item/commercials/AdvertCommercials;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertCommercialsConverter {
    @NotNull
    AdvertCommercials convert(@NotNull List<PositionedBannerContainer> list, @NotNull SerpDisplayType serpDisplayType);
}
