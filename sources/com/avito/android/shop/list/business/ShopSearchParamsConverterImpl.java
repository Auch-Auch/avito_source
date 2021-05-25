package com.avito.android.shop.list.business;

import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/shop/list/business/ShopSearchParamsConverterImpl;", "Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "params", "", "", "convertToMap", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;)Ljava/util/Map;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSearchParamsConverterImpl implements ShopSearchParamsConverter {
    @Override // com.avito.android.shop.list.business.ShopSearchParamsConverter
    @NotNull
    public Map<String, String> convertToMap(@NotNull ShopsSearchParameters shopsSearchParameters) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "params");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String query = shopsSearchParameters.getQuery();
        if (query != null) {
            String str = (String) linkedHashMap.put("query", query);
        }
        String categoryId = shopsSearchParameters.getCategoryId();
        if (categoryId != null) {
            String str2 = (String) linkedHashMap.put("categoryId", categoryId);
        }
        String locationId = shopsSearchParameters.getLocationId();
        if (locationId != null) {
            String str3 = (String) linkedHashMap.put("locationId", locationId);
        }
        return linkedHashMap;
    }
}
