package com.avito.android.shop.list.business;

import a2.b.a.a.a;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.ShopsListResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/list/business/ShopListResultConverterImpl;", "Lcom/avito/android/shop/list/business/ShopListResultConverter;", "", "Lcom/avito/android/remote/model/ShopsListResult$Element;", "shopList", "Lcom/avito/android/remote/model/ShopsListResult$Shop;", "convertShops", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/shop/list/business/ShopLocation;", "convertLocation", "(Lcom/avito/android/remote/model/Location;)Lcom/avito/android/shop/list/business/ShopLocation;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListResultConverterImpl implements ShopListResultConverter {
    @Override // com.avito.android.shop.list.business.ShopListResultConverter
    @NotNull
    public ShopLocation convertLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return new ShopLocation(location.getId(), location.getNames());
    }

    @Override // com.avito.android.shop.list.business.ShopListResultConverter
    @NotNull
    public List<ShopsListResult.Shop> convertShops(@NotNull List<? extends ShopsListResult.Element> list) {
        ArrayList i0 = a.i0(list, "shopList");
        for (T t : list) {
            Objects.requireNonNull(t, "null cannot be cast to non-null type com.avito.android.remote.model.ShopsListResult.Shop");
            i0.add(t);
        }
        return i0;
    }
}
