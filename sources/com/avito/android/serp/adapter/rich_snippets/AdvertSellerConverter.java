package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.remote.model.AdvertSellerInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "advertSellerInfo", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "convert", "(Lcom/avito/android/remote/model/AdvertSellerInfo;)Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSellerConverter {
    @Nullable
    CarouselSellerItem convert(@NotNull AdvertSellerInfo advertSellerInfo);
}
