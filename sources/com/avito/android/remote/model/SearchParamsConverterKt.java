package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b!\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0005\"\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005\"\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0005\"\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0005\"\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005\"\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0005\"\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0005\"\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0005\"\u0016\u0010\u0014\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0005\"\u0016\u0010\u0015\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0005\"\u0016\u0010\u0016\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0005\"\u0016\u0010\u0017\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0005\"\u0016\u0010\u0018\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0005\"\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0005\"\u0016\u0010\u001a\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0005\"\u0016\u0010\u001b\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0005\"\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0005\"\u0016\u0010\u001d\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0005\"\u0016\u0010\u001e\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0005\"\u0016\u0010\u001f\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0005\"\u0016\u0010 \u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u0005\"\u0016\u0010!\u001a\u00020\u00018\u0002@\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\u0005¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/Coordinates;", "", "toValue", "(Lcom/avito/android/remote/model/Coordinates;)Ljava/lang/String;", "LOCATION_ID", "Ljava/lang/String;", "SIMPLE_MAP", "PRIVATE_ONLY", "FALSE", "DISTRICT_ID", "RADIUS", "WITH_IMAGES_ONLY", "COMPANY_ONLY", "PRICE_MAX", "FROM", "CATEGORY_ID", "EXPANDED", "DIRECTION_ID", "WITH_DELIVERY_ONLY", "QUERY", "METRO_ID", "SEARCH_RADIUS", "OWNER", "PRICE_MIN", "SELLER_ID", "TRUE", "GEO_COORDS", "TO", "SHOP_ID", "LOCAL_PRIORITY", "SORT", "COMPANY_KEY", "PARAMS", "PRIVATE_KEY", "api_release"}, k = 2, mv = {1, 4, 2})
public final class SearchParamsConverterKt {
    private static final String CATEGORY_ID = "categoryId";
    private static final String COMPANY_KEY = "company";
    private static final String COMPANY_ONLY = "companyOnly";
    private static final String DIRECTION_ID = "directionId";
    private static final String DISTRICT_ID = "districtId";
    private static final String EXPANDED = "expanded";
    private static final String FALSE = "0";
    private static final String FROM = "from";
    private static final String GEO_COORDS = "geoCoords";
    private static final String LOCAL_PRIORITY = "localPriority";
    private static final String LOCATION_ID = "locationId";
    private static final String METRO_ID = "metroId";
    private static final String OWNER = "owner";
    private static final String PARAMS = "params";
    private static final String PRICE_MAX = "priceMax";
    private static final String PRICE_MIN = "priceMin";
    private static final String PRIVATE_KEY = "private";
    private static final String PRIVATE_ONLY = "privateOnly";
    private static final String QUERY = "query";
    private static final String RADIUS = "radius";
    private static final String SEARCH_RADIUS = "searchRadius";
    private static final String SELLER_ID = "sellerId";
    private static final String SHOP_ID = "shopId";
    private static final String SIMPLE_MAP = "showSimpleMap";
    private static final String SORT = "sort";
    private static final String TO = "to";
    private static final String TRUE = "1";
    private static final String WITH_DELIVERY_ONLY = "withDeliveryOnly";
    private static final String WITH_IMAGES_ONLY = "withImagesOnly";

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x000a: INVOKE  (r1v0 double) = (r3v0 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLatitude():double), (',' char), (wrap: double : 0x0016: INVOKE  (r1v2 double) = (r3v0 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLongitude():double)] */
    @NotNull
    public static final String toValue(@NotNull Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "$this$toValue");
        StringBuilder sb = new StringBuilder();
        sb.append(coordinates.getLatitude());
        sb.append(',');
        sb.append(coordinates.getLongitude());
        return sb.toString();
    }
}
