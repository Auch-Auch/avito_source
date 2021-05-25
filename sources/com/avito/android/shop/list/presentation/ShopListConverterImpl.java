package com.avito.android.shop.list.presentation;

import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.shop.list.presentation.item.ShopItem;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListConverterImpl;", "Lcom/avito/android/shop/list/presentation/ShopListConverter;", "", "Lcom/avito/android/remote/model/ShopsListResult$Shop;", AmenityMarkerIconFactoryKt.AMENITY_TYPE_SHOPS, "Lcom/avito/android/shop/list/presentation/item/ShopItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "", AuthSource.SEND_ABUSE, "I", "spanCount", "<init>", "(I)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListConverterImpl implements ShopListConverter {
    public final int a;

    @Inject
    public ShopListConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListConverter
    @NotNull
    public List<ShopItem> convert(@NotNull List<ShopsListResult.Shop> list) {
        Intrinsics.checkNotNullParameter(list, AmenityMarkerIconFactoryKt.AMENITY_TYPE_SHOPS);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String id = t.getId();
            String category = t.getCategory();
            Long itemsCount = t.getItemsCount();
            arrayList.add(new ShopItem(id, t.getName(), t.getItemsCountDescription(), itemsCount, category, t.getLogo(), this.a, t.getUri()));
        }
        return arrayList;
    }
}
