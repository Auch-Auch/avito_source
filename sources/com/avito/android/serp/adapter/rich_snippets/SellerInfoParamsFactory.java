package com.avito.android.serp.adapter.rich_snippets;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "createVasParams", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "createRegularParams", "createSmallParams", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SellerInfoParamsFactory {
    @NotNull
    SellerInfoParams createRegularParams();

    @NotNull
    SellerInfoParams createSmallParams();

    @NotNull
    SellerInfoParams createVasParams();
}
