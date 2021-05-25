package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\bG\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001BÅ\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\u001a\b\u0002\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0018\u00010\u0017\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u000101¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\"\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\rJ\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b \u0010\u0014J\u0012\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b!\u0010\rJ\u0012\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b%\u0010\rJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b(\u0010$J\u0012\u0010)\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b)\u0010$J\u0012\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b*\u0010\rJ\u0012\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b+\u0010\rJ\u0012\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b/\u0010\rJ\u0012\u00100\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b0\u0010$J\u0012\u00102\u001a\u0004\u0018\u000101HÆ\u0003¢\u0006\u0004\b2\u00103JÌ\u0002\u0010K\u001a\u00020\u00002\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u001a\b\u0002\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0018\u00010\u00172\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010J\u001a\u0004\u0018\u000101HÆ\u0001¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bM\u0010\rJ\u0010\u0010N\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bN\u0010\u0004J\u001a\u0010Q\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010OHÖ\u0003¢\u0006\u0004\bQ\u0010RR$\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010S\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010VR$\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u0010S\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010VR$\u0010G\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010Y\u001a\u0004\bZ\u0010.\"\u0004\b[\u0010\\R$\u0010H\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010S\u001a\u0004\b]\u0010\r\"\u0004\b^\u0010VR$\u0010<\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010_\u001a\u0004\b`\u0010\u001d\"\u0004\ba\u0010bR$\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010S\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010VR$\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u0010S\u001a\u0004\be\u0010\r\"\u0004\bf\u0010VR*\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010g\u001a\u0004\bh\u0010\u0014\"\u0004\bi\u0010jR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010k\u001a\u0004\bl\u0010'\"\u0004\bm\u0010nR$\u0010;\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010_\u001a\u0004\bo\u0010\u001d\"\u0004\bp\u0010bR$\u0010C\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010q\u001a\u0004\br\u0010$\"\u0004\bs\u0010tR$\u0010D\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010q\u001a\u0004\bu\u0010$\"\u0004\bv\u0010tR$\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u0010w\u001a\u0004\bx\u0010\u0010\"\u0004\by\u0010zR*\u00108\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u0010g\u001a\u0004\b{\u0010\u0014\"\u0004\b|\u0010jR%\u0010J\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0013\n\u0004\bJ\u0010}\u001a\u0004\b~\u00103\"\u0005\b\u0010\u0001R&\u0010@\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\b@\u0010q\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010tR&\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\bF\u0010S\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010VR&\u0010E\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\bE\u0010S\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010VR&\u0010I\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\bI\u0010q\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010tR8\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b:\u0010\u0001\u001a\u0005\b\u0001\u0010\u001a\"\u0006\b\u0001\u0010\u0001R&\u0010A\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\bA\u0010S\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010VR,\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\b7\u0010g\u001a\u0005\b\u0001\u0010\u0014\"\u0005\b\u0001\u0010jR,\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\b9\u0010g\u001a\u0005\b\u0001\u0010\u0014\"\u0005\b\u0001\u0010j¨\u0006\u0001"}, d2 = {"Lcom/avito/android/remote/model/SearchParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Coordinates;", "component2", "()Lcom/avito/android/remote/model/Coordinates;", "component3", "", "component4", "()Ljava/util/List;", "component5", "component6", "", "Lcom/avito/android/remote/model/SearchParam;", "component7", "()Ljava/util/Map;", "", "component8", "()Ljava/lang/Long;", "component9", "component10", "component11", "component12", "", "component13", "()Ljava/lang/Boolean;", "component14", "component15", "()Ljava/lang/Integer;", "component16", "component17", "component18", "component19", "Lcom/avito/android/remote/model/SerpDisplayType;", "component20", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component21", "component22", "Lcom/avito/android/remote/model/search/map/Area;", "component23", "()Lcom/avito/android/remote/model/search/map/Area;", "categoryId", UrlParams.GEO_COORDS, "locationId", "metroIds", UrlParams.DIRECTION_ID, UrlParams.DISTRICT_ID, "params", UrlParams.PRICE_MAX, UrlParams.PRICE_MIN, "query", UrlParams.OWNER, "sort", UrlParams.WITH_IMAGES_ONLY, "searchRadius", "radius", UrlParams.WITH_DELIVERY_ONLY, UrlParams.LOCAL_PRIORITY, PanelStateKt.PANEL_EXPANDED, "sellerId", "displayType", "shopId", "forcedLocationForRecommendation", "area", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/map/Area;)Lcom/avito/android/remote/model/SearchParams;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSort", "setSort", "(Ljava/lang/String;)V", "getLocationId", "setLocationId", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "getShopId", "setShopId", "Ljava/lang/Long;", "getPriceMin", "setPriceMin", "(Ljava/lang/Long;)V", "getCategoryId", "setCategoryId", "getQuery", "setQuery", "Ljava/util/List;", "getOwner", "setOwner", "(Ljava/util/List;)V", "Ljava/lang/Integer;", "getRadius", "setRadius", "(Ljava/lang/Integer;)V", "getPriceMax", "setPriceMax", "Ljava/lang/Boolean;", "getWithDeliveryOnly", "setWithDeliveryOnly", "(Ljava/lang/Boolean;)V", "getLocalPriority", "setLocalPriority", "Lcom/avito/android/remote/model/Coordinates;", "getGeoCoords", "setGeoCoords", "(Lcom/avito/android/remote/model/Coordinates;)V", "getDirectionId", "setDirectionId", "Lcom/avito/android/remote/model/search/map/Area;", "getArea", "setArea", "(Lcom/avito/android/remote/model/search/map/Area;)V", "getWithImagesOnly", "setWithImagesOnly", "getSellerId", "setSellerId", "getExpanded", "setExpanded", "getForcedLocationForRecommendation", "setForcedLocationForRecommendation", "Ljava/util/Map;", "getParams", "setParams", "(Ljava/util/Map;)V", "getSearchRadius", "setSearchRadius", "getMetroIds", "setMetroIds", "getDistrictId", "setDistrictId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/map/Area;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchParams implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SearchParams> CREATOR = Parcels.creator(SearchParams$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Area area;
    @Nullable
    private String categoryId;
    @Nullable
    private List<String> directionId;
    @Nullable
    private SerpDisplayType displayType;
    @Nullable
    private List<String> districtId;
    @Nullable
    private String expanded;
    @Nullable
    private Boolean forcedLocationForRecommendation;
    @Nullable
    private Coordinates geoCoords;
    @Nullable
    private Boolean localPriority;
    @Nullable
    private String locationId;
    @Nullable
    private List<String> metroIds;
    @Nullable
    private List<String> owner;
    @Nullable
    private Map<String, ? extends SearchParam<?>> params;
    @Nullable
    private Long priceMax;
    @Nullable
    private Long priceMin;
    @Nullable
    private String query;
    @Nullable
    private Integer radius;
    @Nullable
    private String searchRadius;
    @Nullable
    private String sellerId;
    @Nullable
    private String shopId;
    @Nullable
    private String sort;
    @Nullable
    private Boolean withDeliveryOnly;
    @Nullable
    private Boolean withImagesOnly;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchParams$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchParams;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SearchParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public SearchParams(@Nullable String str, @Nullable Coordinates coordinates, @Nullable String str2, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Map<String, ? extends SearchParam<?>> map, @Nullable Long l, @Nullable Long l2, @Nullable String str3, @Nullable List<String> list4, @Nullable String str4, @Nullable Boolean bool, @Nullable String str5, @Nullable Integer num, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str6, @Nullable String str7, @Nullable SerpDisplayType serpDisplayType, @Nullable String str8, @Nullable Boolean bool4, @Nullable Area area2) {
        this.categoryId = str;
        this.geoCoords = coordinates;
        this.locationId = str2;
        this.metroIds = list;
        this.directionId = list2;
        this.districtId = list3;
        this.params = map;
        this.priceMax = l;
        this.priceMin = l2;
        this.query = str3;
        this.owner = list4;
        this.sort = str4;
        this.withImagesOnly = bool;
        this.searchRadius = str5;
        this.radius = num;
        this.withDeliveryOnly = bool2;
        this.localPriority = bool3;
        this.expanded = str6;
        this.sellerId = str7;
        this.displayType = serpDisplayType;
        this.shopId = str8;
        this.forcedLocationForRecommendation = bool4;
        this.area = area2;
    }

    public static /* synthetic */ SearchParams copy$default(SearchParams searchParams, String str, Coordinates coordinates, String str2, List list, List list2, List list3, Map map, Long l, Long l2, String str3, List list4, String str4, Boolean bool, String str5, Integer num, Boolean bool2, Boolean bool3, String str6, String str7, SerpDisplayType serpDisplayType, String str8, Boolean bool4, Area area2, int i, Object obj) {
        return searchParams.copy((i & 1) != 0 ? searchParams.categoryId : str, (i & 2) != 0 ? searchParams.geoCoords : coordinates, (i & 4) != 0 ? searchParams.locationId : str2, (i & 8) != 0 ? searchParams.metroIds : list, (i & 16) != 0 ? searchParams.directionId : list2, (i & 32) != 0 ? searchParams.districtId : list3, (i & 64) != 0 ? searchParams.params : map, (i & 128) != 0 ? searchParams.priceMax : l, (i & 256) != 0 ? searchParams.priceMin : l2, (i & 512) != 0 ? searchParams.query : str3, (i & 1024) != 0 ? searchParams.owner : list4, (i & 2048) != 0 ? searchParams.sort : str4, (i & 4096) != 0 ? searchParams.withImagesOnly : bool, (i & 8192) != 0 ? searchParams.searchRadius : str5, (i & 16384) != 0 ? searchParams.radius : num, (i & 32768) != 0 ? searchParams.withDeliveryOnly : bool2, (i & 65536) != 0 ? searchParams.localPriority : bool3, (i & 131072) != 0 ? searchParams.expanded : str6, (i & 262144) != 0 ? searchParams.sellerId : str7, (i & 524288) != 0 ? searchParams.displayType : serpDisplayType, (i & 1048576) != 0 ? searchParams.shopId : str8, (i & 2097152) != 0 ? searchParams.forcedLocationForRecommendation : bool4, (i & 4194304) != 0 ? searchParams.area : area2);
    }

    @Nullable
    public final String component1() {
        return this.categoryId;
    }

    @Nullable
    public final String component10() {
        return this.query;
    }

    @Nullable
    public final List<String> component11() {
        return this.owner;
    }

    @Nullable
    public final String component12() {
        return this.sort;
    }

    @Nullable
    public final Boolean component13() {
        return this.withImagesOnly;
    }

    @Nullable
    public final String component14() {
        return this.searchRadius;
    }

    @Nullable
    public final Integer component15() {
        return this.radius;
    }

    @Nullable
    public final Boolean component16() {
        return this.withDeliveryOnly;
    }

    @Nullable
    public final Boolean component17() {
        return this.localPriority;
    }

    @Nullable
    public final String component18() {
        return this.expanded;
    }

    @Nullable
    public final String component19() {
        return this.sellerId;
    }

    @Nullable
    public final Coordinates component2() {
        return this.geoCoords;
    }

    @Nullable
    public final SerpDisplayType component20() {
        return this.displayType;
    }

    @Nullable
    public final String component21() {
        return this.shopId;
    }

    @Nullable
    public final Boolean component22() {
        return this.forcedLocationForRecommendation;
    }

    @Nullable
    public final Area component23() {
        return this.area;
    }

    @Nullable
    public final String component3() {
        return this.locationId;
    }

    @Nullable
    public final List<String> component4() {
        return this.metroIds;
    }

    @Nullable
    public final List<String> component5() {
        return this.directionId;
    }

    @Nullable
    public final List<String> component6() {
        return this.districtId;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends com.avito.android.remote.model.SearchParam<?>>, java.util.Map<java.lang.String, com.avito.android.remote.model.SearchParam<?>> */
    @Nullable
    public final Map<String, SearchParam<?>> component7() {
        return this.params;
    }

    @Nullable
    public final Long component8() {
        return this.priceMax;
    }

    @Nullable
    public final Long component9() {
        return this.priceMin;
    }

    @NotNull
    public final SearchParams copy(@Nullable String str, @Nullable Coordinates coordinates, @Nullable String str2, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Map<String, ? extends SearchParam<?>> map, @Nullable Long l, @Nullable Long l2, @Nullable String str3, @Nullable List<String> list4, @Nullable String str4, @Nullable Boolean bool, @Nullable String str5, @Nullable Integer num, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str6, @Nullable String str7, @Nullable SerpDisplayType serpDisplayType, @Nullable String str8, @Nullable Boolean bool4, @Nullable Area area2) {
        return new SearchParams(str, coordinates, str2, list, list2, list3, map, l, l2, str3, list4, str4, bool, str5, num, bool2, bool3, str6, str7, serpDisplayType, str8, bool4, area2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchParams)) {
            return false;
        }
        SearchParams searchParams = (SearchParams) obj;
        return Intrinsics.areEqual(this.categoryId, searchParams.categoryId) && Intrinsics.areEqual(this.geoCoords, searchParams.geoCoords) && Intrinsics.areEqual(this.locationId, searchParams.locationId) && Intrinsics.areEqual(this.metroIds, searchParams.metroIds) && Intrinsics.areEqual(this.directionId, searchParams.directionId) && Intrinsics.areEqual(this.districtId, searchParams.districtId) && Intrinsics.areEqual(this.params, searchParams.params) && Intrinsics.areEqual(this.priceMax, searchParams.priceMax) && Intrinsics.areEqual(this.priceMin, searchParams.priceMin) && Intrinsics.areEqual(this.query, searchParams.query) && Intrinsics.areEqual(this.owner, searchParams.owner) && Intrinsics.areEqual(this.sort, searchParams.sort) && Intrinsics.areEqual(this.withImagesOnly, searchParams.withImagesOnly) && Intrinsics.areEqual(this.searchRadius, searchParams.searchRadius) && Intrinsics.areEqual(this.radius, searchParams.radius) && Intrinsics.areEqual(this.withDeliveryOnly, searchParams.withDeliveryOnly) && Intrinsics.areEqual(this.localPriority, searchParams.localPriority) && Intrinsics.areEqual(this.expanded, searchParams.expanded) && Intrinsics.areEqual(this.sellerId, searchParams.sellerId) && Intrinsics.areEqual(this.displayType, searchParams.displayType) && Intrinsics.areEqual(this.shopId, searchParams.shopId) && Intrinsics.areEqual(this.forcedLocationForRecommendation, searchParams.forcedLocationForRecommendation) && Intrinsics.areEqual(this.area, searchParams.area);
    }

    @Nullable
    public final Area getArea() {
        return this.area;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final List<String> getDirectionId() {
        return this.directionId;
    }

    @Nullable
    public final SerpDisplayType getDisplayType() {
        return this.displayType;
    }

    @Nullable
    public final List<String> getDistrictId() {
        return this.districtId;
    }

    @Nullable
    public final String getExpanded() {
        return this.expanded;
    }

    @Nullable
    public final Boolean getForcedLocationForRecommendation() {
        return this.forcedLocationForRecommendation;
    }

    @Nullable
    public final Coordinates getGeoCoords() {
        return this.geoCoords;
    }

    @Nullable
    public final Boolean getLocalPriority() {
        return this.localPriority;
    }

    @Nullable
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final List<String> getMetroIds() {
        return this.metroIds;
    }

    @Nullable
    public final List<String> getOwner() {
        return this.owner;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends com.avito.android.remote.model.SearchParam<?>>, java.util.Map<java.lang.String, com.avito.android.remote.model.SearchParam<?>> */
    @Nullable
    public final Map<String, SearchParam<?>> getParams() {
        return this.params;
    }

    @Nullable
    public final Long getPriceMax() {
        return this.priceMax;
    }

    @Nullable
    public final Long getPriceMin() {
        return this.priceMin;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Integer getRadius() {
        return this.radius;
    }

    @Nullable
    public final String getSearchRadius() {
        return this.searchRadius;
    }

    @Nullable
    public final String getSellerId() {
        return this.sellerId;
    }

    @Nullable
    public final String getShopId() {
        return this.shopId;
    }

    @Nullable
    public final String getSort() {
        return this.sort;
    }

    @Nullable
    public final Boolean getWithDeliveryOnly() {
        return this.withDeliveryOnly;
    }

    @Nullable
    public final Boolean getWithImagesOnly() {
        return this.withImagesOnly;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.categoryId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Coordinates coordinates = this.geoCoords;
        int hashCode2 = (hashCode + (coordinates != null ? coordinates.hashCode() : 0)) * 31;
        String str2 = this.locationId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.metroIds;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.directionId;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.districtId;
        int hashCode6 = (hashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Map<String, ? extends SearchParam<?>> map = this.params;
        int hashCode7 = (hashCode6 + (map != null ? map.hashCode() : 0)) * 31;
        Long l = this.priceMax;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.priceMin;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str3 = this.query;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<String> list4 = this.owner;
        int hashCode11 = (hashCode10 + (list4 != null ? list4.hashCode() : 0)) * 31;
        String str4 = this.sort;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.withImagesOnly;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str5 = this.searchRadius;
        int hashCode14 = (hashCode13 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.radius;
        int hashCode15 = (hashCode14 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool2 = this.withDeliveryOnly;
        int hashCode16 = (hashCode15 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.localPriority;
        int hashCode17 = (hashCode16 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str6 = this.expanded;
        int hashCode18 = (hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sellerId;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 31;
        SerpDisplayType serpDisplayType = this.displayType;
        int hashCode20 = (hashCode19 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
        String str8 = this.shopId;
        int hashCode21 = (hashCode20 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Boolean bool4 = this.forcedLocationForRecommendation;
        int hashCode22 = (hashCode21 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Area area2 = this.area;
        if (area2 != null) {
            i = area2.hashCode();
        }
        return hashCode22 + i;
    }

    public final void setArea(@Nullable Area area2) {
        this.area = area2;
    }

    public final void setCategoryId(@Nullable String str) {
        this.categoryId = str;
    }

    public final void setDirectionId(@Nullable List<String> list) {
        this.directionId = list;
    }

    public final void setDisplayType(@Nullable SerpDisplayType serpDisplayType) {
        this.displayType = serpDisplayType;
    }

    public final void setDistrictId(@Nullable List<String> list) {
        this.districtId = list;
    }

    public final void setExpanded(@Nullable String str) {
        this.expanded = str;
    }

    public final void setForcedLocationForRecommendation(@Nullable Boolean bool) {
        this.forcedLocationForRecommendation = bool;
    }

    public final void setGeoCoords(@Nullable Coordinates coordinates) {
        this.geoCoords = coordinates;
    }

    public final void setLocalPriority(@Nullable Boolean bool) {
        this.localPriority = bool;
    }

    public final void setLocationId(@Nullable String str) {
        this.locationId = str;
    }

    public final void setMetroIds(@Nullable List<String> list) {
        this.metroIds = list;
    }

    public final void setOwner(@Nullable List<String> list) {
        this.owner = list;
    }

    public final void setParams(@Nullable Map<String, ? extends SearchParam<?>> map) {
        this.params = map;
    }

    public final void setPriceMax(@Nullable Long l) {
        this.priceMax = l;
    }

    public final void setPriceMin(@Nullable Long l) {
        this.priceMin = l;
    }

    public final void setQuery(@Nullable String str) {
        this.query = str;
    }

    public final void setRadius(@Nullable Integer num) {
        this.radius = num;
    }

    public final void setSearchRadius(@Nullable String str) {
        this.searchRadius = str;
    }

    public final void setSellerId(@Nullable String str) {
        this.sellerId = str;
    }

    public final void setShopId(@Nullable String str) {
        this.shopId = str;
    }

    public final void setSort(@Nullable String str) {
        this.sort = str;
    }

    public final void setWithDeliveryOnly(@Nullable Boolean bool) {
        this.withDeliveryOnly = bool;
    }

    public final void setWithImagesOnly(@Nullable Boolean bool) {
        this.withImagesOnly = bool;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchParams(categoryId=");
        L.append(this.categoryId);
        L.append(", geoCoords=");
        L.append(this.geoCoords);
        L.append(", locationId=");
        L.append(this.locationId);
        L.append(", metroIds=");
        L.append(this.metroIds);
        L.append(", directionId=");
        L.append(this.directionId);
        L.append(", districtId=");
        L.append(this.districtId);
        L.append(", params=");
        L.append(this.params);
        L.append(", priceMax=");
        L.append(this.priceMax);
        L.append(", priceMin=");
        L.append(this.priceMin);
        L.append(", query=");
        L.append(this.query);
        L.append(", owner=");
        L.append(this.owner);
        L.append(", sort=");
        L.append(this.sort);
        L.append(", withImagesOnly=");
        L.append(this.withImagesOnly);
        L.append(", searchRadius=");
        L.append(this.searchRadius);
        L.append(", radius=");
        L.append(this.radius);
        L.append(", withDeliveryOnly=");
        L.append(this.withDeliveryOnly);
        L.append(", localPriority=");
        L.append(this.localPriority);
        L.append(", expanded=");
        L.append(this.expanded);
        L.append(", sellerId=");
        L.append(this.sellerId);
        L.append(", displayType=");
        L.append(this.displayType);
        L.append(", shopId=");
        L.append(this.shopId);
        L.append(", forcedLocationForRecommendation=");
        L.append(this.forcedLocationForRecommendation);
        L.append(", area=");
        L.append(this.area);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeNullableValue(parcel, this.categoryId);
        parcel.writeParcelable(this.geoCoords, i);
        ParcelsKt.writeNullableValue(parcel, this.locationId);
        parcel.writeStringList(this.metroIds);
        parcel.writeStringList(this.directionId);
        parcel.writeStringList(this.districtId);
        ParcelsKt.writeValueMap(parcel, this.params);
        ParcelsKt.writeNullableValue(parcel, this.priceMax);
        ParcelsKt.writeNullableValue(parcel, this.priceMin);
        ParcelsKt.writeNullableValue(parcel, this.query);
        parcel.writeStringList(this.owner);
        parcel.writeString(this.sort);
        ParcelsKt.writeNullableValue(parcel, this.withImagesOnly);
        parcel.writeString(this.searchRadius);
        ParcelsKt.writeNullableValue(parcel, this.radius);
        ParcelsKt.writeNullableValue(parcel, this.withDeliveryOnly);
        ParcelsKt.writeNullableValue(parcel, this.localPriority);
        ParcelsKt.writeNullableValue(parcel, this.expanded);
        parcel.writeString(this.sellerId);
        ParcelsKt.writeOptEnum(parcel, this.displayType);
        parcel.writeString(this.shopId);
        ParcelsKt.writeNullableValue(parcel, this.forcedLocationForRecommendation);
        parcel.writeParcelable(this.area, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchParams(String str, Coordinates coordinates, String str2, List list, List list2, List list3, Map map, Long l, Long l2, String str3, List list4, String str4, Boolean bool, String str5, Integer num, Boolean bool2, Boolean bool3, String str6, String str7, SerpDisplayType serpDisplayType, String str8, Boolean bool4, Area area2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : coordinates, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : l2, (i & 512) != 0 ? null : str3, (i & 1024) != 0 ? null : list4, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : num, (i & 32768) != 0 ? null : bool2, (i & 65536) != 0 ? null : bool3, (i & 131072) != 0 ? null : str6, (i & 262144) != 0 ? null : str7, (i & 524288) != 0 ? null : serpDisplayType, (i & 1048576) != 0 ? null : str8, (i & 2097152) != 0 ? null : bool4, (i & 4194304) != 0 ? null : area2);
    }
}
