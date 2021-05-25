package com.avito.android.shop.list.presentation;

import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryKt;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.shop.list.presentation.item.ShopItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListConverter;", "", "", "Lcom/avito/android/remote/model/ShopsListResult$Shop;", AmenityMarkerIconFactoryKt.AMENITY_TYPE_SHOPS, "Lcom/avito/android/shop/list/presentation/item/ShopItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListConverter {
    @NotNull
    List<ShopItem> convert(@NotNull List<ShopsListResult.Shop> list);
}
