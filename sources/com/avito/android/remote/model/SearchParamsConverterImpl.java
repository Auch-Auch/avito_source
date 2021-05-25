package com.avito.android.remote.model;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.UrlParams;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\r\u001a\u00020\f*\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\b*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JV\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0013\u001a\u00020\u00122!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "filterNullValues", "(Ljava/util/Map;)Ljava/util/Map;", "", "", "key", "", ResidentialComplexModuleKt.VALUES, "", "appendMultipleValues", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;)V", "", "toValue", "(Z)Ljava/lang/String;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "keyWrapper", "isSubscribeSearch", UrlParams.SIMPLE_MAP, "convertToMap", "(Lcom/avito/android/remote/model/SearchParams;Lkotlin/jvm/functions/Function1;ZZ)Ljava/util/Map;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SearchParamsConverterImpl implements SearchParamsConverter {
    private final void appendMultipleValues(Map<String, String> map, String str, List<String> list) {
        if (list != null) {
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                map.put(str + '[' + i + ']', t);
                i = i2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> Map<K, V> filterNullValues(Map<? extends K, ? extends V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final String toValue(boolean z) {
        return z ? "1" : "0";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.avito.android.remote.model.SearchParamsConverterImpl */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0048: INVOKE  (r5v5 double) = (r2v3 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLatitude():double), (',' char), (wrap: double : 0x0054: INVOKE  (r5v7 double) = (r2v3 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLongitude():double)] */
    @Override // com.avito.android.remote.model.SearchParamsConverter
    @NotNull
    public Map<String, String> convertToMap(@NotNull SearchParams searchParams, @NotNull Function1<? super String, String> function1, boolean z, boolean z2) {
        String str;
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(function1, "keyWrapper");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(function1.invoke("categoryId"), searchParams.getCategoryId());
        linkedHashMap.put(function1.invoke("locationId"), searchParams.getLocationId());
        linkedHashMap.put(function1.invoke("query"), searchParams.getQuery());
        String invoke = function1.invoke(UrlParams.GEO_COORDS);
        Coordinates geoCoords = searchParams.getGeoCoords();
        String str2 = null;
        if (geoCoords != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(geoCoords.getLatitude());
            sb.append(',');
            sb.append(geoCoords.getLongitude());
            str = sb.toString();
        } else {
            str = null;
        }
        linkedHashMap.put(invoke, str);
        String invoke2 = function1.invoke(UrlParams.PRICE_MIN);
        Long priceMin = searchParams.getPriceMin();
        linkedHashMap.put(invoke2, priceMin != null ? String.valueOf(priceMin.longValue()) : null);
        String invoke3 = function1.invoke(UrlParams.PRICE_MAX);
        Long priceMax = searchParams.getPriceMax();
        linkedHashMap.put(invoke3, priceMax != null ? String.valueOf(priceMax.longValue()) : null);
        appendMultipleValues(linkedHashMap, function1.invoke(UrlParams.METRO_ID), searchParams.getMetroIds());
        appendMultipleValues(linkedHashMap, function1.invoke(UrlParams.DIRECTION_ID), searchParams.getDirectionId());
        appendMultipleValues(linkedHashMap, function1.invoke(UrlParams.DISTRICT_ID), searchParams.getDistrictId());
        String invoke4 = function1.invoke(UrlParams.WITH_IMAGES_ONLY);
        Boolean withImagesOnly = searchParams.getWithImagesOnly();
        linkedHashMap.put(invoke4, withImagesOnly != null ? toValue(withImagesOnly.booleanValue()) : null);
        String invoke5 = function1.invoke(UrlParams.WITH_DELIVERY_ONLY);
        Boolean withDeliveryOnly = searchParams.getWithDeliveryOnly();
        linkedHashMap.put(invoke5, withDeliveryOnly != null ? toValue(withDeliveryOnly.booleanValue()) : null);
        String invoke6 = function1.invoke(UrlParams.LOCAL_PRIORITY);
        Boolean localPriority = searchParams.getLocalPriority();
        if (localPriority != null) {
            str2 = toValue(localPriority.booleanValue());
        }
        linkedHashMap.put(invoke6, str2);
        linkedHashMap.put(function1.invoke("sort"), searchParams.getSort());
        appendMultipleValues(linkedHashMap, function1.invoke(UrlParams.OWNER), searchParams.getOwner());
        linkedHashMap.put(function1.invoke(PanelStateKt.PANEL_EXPANDED), searchParams.getExpanded());
        linkedHashMap.put(function1.invoke("sellerId"), searchParams.getSellerId());
        linkedHashMap.put(function1.invoke("shopId"), searchParams.getShopId());
        Integer radius = searchParams.getRadius();
        if (radius != null) {
            int intValue = radius.intValue();
            if (z) {
                linkedHashMap.put(function1.invoke("searchRadius"), String.valueOf(intValue));
            } else {
                linkedHashMap.put(function1.invoke("radius"), String.valueOf(intValue));
            }
        } else {
            String searchRadius = searchParams.getSearchRadius();
            if (searchRadius != null) {
                linkedHashMap.put(function1.invoke("searchRadius"), searchRadius);
            }
        }
        List<String> owner = searchParams.getOwner();
        if (owner != null) {
            if (owner.contains(UserTypeCode.PRIVATE)) {
                linkedHashMap.put(function1.invoke(UrlParams.PRIVATE_ONLY), "1");
            }
            if (owner.contains("company")) {
                linkedHashMap.put(function1.invoke(UrlParams.COMPANY_ONLY), "1");
            }
        }
        if (z2) {
            linkedHashMap.put(function1.invoke(UrlParams.SIMPLE_MAP), toValue(z2));
        }
        Map<String, SearchParam<?>> params = searchParams.getParams();
        if (params != null) {
            for (Map.Entry<String, SearchParam<?>> entry : params.entrySet()) {
                String key = entry.getKey();
                SearchParam<?> value = entry.getValue();
                if (value instanceof StringSearchParam) {
                    linkedHashMap.put(function1.invoke("params") + '[' + key + ']', ((StringSearchParam) value).getValue());
                } else if (value instanceof MultiSelectSearchParam) {
                    appendMultipleValues(linkedHashMap, function1.invoke("params") + '[' + key + ']', ((MultiSelectSearchParam) value).getValue());
                } else if (value instanceof SplitSearchParam) {
                    SplitSearchParam splitSearchParam = (SplitSearchParam) value;
                    linkedHashMap.put(function1.invoke("params") + '[' + key + "-from]", splitSearchParam.getValue().getFrom());
                    linkedHashMap.put(function1.invoke("params") + '[' + key + "-to]", splitSearchParam.getValue().getTo());
                } else if (value instanceof DateSearchParam) {
                    linkedHashMap.put(function1.invoke(key), ((DateSearchParam) value).getValue());
                } else if (value instanceof AreaSearchParams) {
                    linkedHashMap.putAll(AreaKt.toMap(((AreaSearchParams) value).getValue()));
                }
            }
        }
        linkedHashMap.putAll(AreaKt.toMap(searchParams.getArea()));
        return filterNullValues(linkedHashMap);
    }
}
