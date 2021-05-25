package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 ©\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002©\u0001BÐ\u0003\u0012\u0006\u0010N\u001a\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0012\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\u0007\u0010\u0001\u001a\u00020\u0012\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0012\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010u\u001a\u0004\u0018\u00010t\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\t\u0010\u0001\u001a\u0004\u0018\u000107\u0012\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000101\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010f\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010z\u001a\u0004\u0018\u00010y\u0012\u0016\u0010\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0001\u0012\b\u0010b\u001a\u0004\u0018\u00010a\u0012\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020^\u0018\u000101\u0012\b\u0010n\u001a\u0004\u0018\u00010m\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001a\u0004\u0018\u00010~\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0012\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010>\u001a\u00020\u000e¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0011R\u001e\u0010(\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016R\u001e\u0010*\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010\u0016R\u001e\u0010,\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016R\u001e\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b.\u0010\u0011R\u001e\u0010/\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R$\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001e\u00108\u001a\u0004\u0018\u0001078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010\u0014\u001a\u0004\b=\u0010\u0016R\u001c\u0010>\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u0019R\u001e\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010E\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001e\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010N\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bN\u0010\u0014\u001a\u0004\bO\u0010\u0016R\u001e\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001e\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001e\u0010Z\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bZ\u0010\u0014\u001a\u0004\b[\u0010\u0016R\u001e\u0010\\\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\\\u0010\u0014\u001a\u0004\b]\u0010\u0016R$\u0010_\u001a\n\u0012\u0004\u0012\u00020^\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b_\u00104\u001a\u0004\b`\u00106R\u001e\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001e\u0010f\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bf\u0010\u0014\u001a\u0004\bg\u0010\u0016R\u001e\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001e\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR$\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\br\u00104\u001a\u0004\bs\u00106R\u001e\u0010u\u001a\u0004\u0018\u00010t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001e\u0010z\u001a\u0004\u0018\u00010y8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R!\u0010\u001a\u0004\u0018\u00010~8\u0006@\u0007X\u0004¢\u0006\u000f\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u0010\u0016R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u0010\u0016R0\u0010\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u0010\u0016R!\u0010\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u0010\u0016R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0004\u0018\u0001078\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00109\u001a\u0005\b \u0001\u0010;R)\u0010¡\u0001\u001a\u00020@8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/avito/android/remote/model/SerpAdvert;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/remote/model/section/SectionElement;", "Lcom/avito/android/remote/model/ShopsListResult$Element;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "isVerifiedSeller", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "price", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "isFavorite", "Z", "()Z", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "badgeBar", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "getBadgeBar", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "hasVideo", "getHasVideo", "inStock", "getInStock", "location", "getLocation", "additionalName", "getAdditionalName", "isMarketplace", "trustFactor", "getTrustFactor", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "Ljava/util/List;", "getGeoReferences", "()Ljava/util/List;", "Lcom/avito/android/remote/model/NameIdEntity;", "category", "Lcom/avito/android/remote/model/NameIdEntity;", "getCategory", "()Lcom/avito/android/remote/model/NameIdEntity;", "previousPrice", "getPreviousPrice", "hidesViewedBadge", "getHidesViewedBadge", "", "time", "Ljava/lang/Long;", "getTime", "()Ljava/lang/Long;", "locationId", "Ljava/lang/Integer;", "getLocationId", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "Lcom/avito/android/remote/model/RadiusInfo;", "getRadiusInfo", "()Lcom/avito/android/remote/model/RadiusInfo;", "id", "getId", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "Lcom/avito/android/remote/model/AdvertItemActions;", "getMoreActions", "()Lcom/avito/android/remote/model/AdvertItemActions;", "description", "getDescription", "priceWithoutDiscount", "getPriceWithoutDiscount", "Lcom/avito/android/remote/model/Image;", "imageList", "getImageList", "Lcom/avito/android/remote/model/SerpAdvertStr;", "shortTermRent", "Lcom/avito/android/remote/model/SerpAdvertStr;", "getShortTermRent", "()Lcom/avito/android/remote/model/SerpAdvertStr;", "discountPercentage", "getDiscountPercentage", "Lcom/avito/android/remote/model/AdvertActions;", "contacts", "Lcom/avito/android/remote/model/AdvertActions;", "getContacts", "()Lcom/avito/android/remote/model/AdvertActions;", "Lcom/avito/android/remote/model/Action;", "additionalAction", "Lcom/avito/android/remote/model/Action;", "getAdditionalAction", "()Lcom/avito/android/remote/model/Action;", VKApiConst.SERVICES, "getServices", "Lcom/avito/android/remote/model/AdvertImage;", "image", "Lcom/avito/android/remote/model/AdvertImage;", "getImage", "()Lcom/avito/android/remote/model/AdvertImage;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/LegacySerpAdvertBadge;", "badge", "Lcom/avito/android/remote/model/LegacySerpAdvertBadge;", "getBadge", "()Lcom/avito/android/remote/model/LegacySerpAdvertBadge;", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "()Lcom/avito/android/remote/model/ForegroundImage;", Sort.DISTANCE, "getDistance", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "sellerInfo", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "getSellerInfo", "()Lcom/avito/android/remote/model/AdvertSellerInfo;", "title", "getTitle", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "status", "getStatus", "userType", "getUserType", "Lcom/avito/android/remote/model/SerpAdvertDelivery;", "delivery", "Lcom/avito/android/remote/model/SerpAdvertDelivery;", "getDelivery", "()Lcom/avito/android/remote/model/SerpAdvertDelivery;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "getShop", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SerpAdvertDelivery;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertImage;Lcom/avito/android/remote/model/NameIdEntity;Lcom/avito/android/remote/model/NameIdEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Video;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Lcom/avito/android/remote/model/SerpAdvertStr;Ljava/util/List;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Lcom/avito/android/remote/model/LegacySerpAdvertBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/AdvertItemActions;Lcom/avito/android/remote/model/AdvertActions;Ljava/util/List;Lcom/avito/android/remote/model/RadiusInfo;Lcom/avito/android/remote/model/AdvertSellerInfo;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Ljava/lang/Boolean;Ljava/lang/Integer;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public class SerpAdvert implements Parcelable, SerpElement, SectionElement, ShopsListResult.Element {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpAdvert> CREATOR = Parcels.creator(SerpAdvert$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("additionalAction")
    @Nullable
    private final Action additionalAction;
    @SerializedName("additionalName")
    @Nullable
    private final String additionalName;
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final String address;
    @SerializedName("analyticParams")
    @Nullable
    private final Map<String, String> analyticParams;
    @SerializedName("badge")
    @Nullable
    private final LegacySerpAdvertBadge badge;
    @SerializedName("badgeBar")
    @Nullable
    private final SerpBadgeBar badgeBar;
    @SerializedName("category")
    @Nullable
    private final NameIdEntity category;
    @SerializedName("contacts")
    @Nullable
    private final AdvertActions contacts;
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coordinates;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("delivery")
    @Nullable
    private final SerpAdvertDelivery delivery;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("discountPercent")
    @Nullable
    private final String discountPercentage;
    @SerializedName(Sort.DISTANCE)
    @Nullable
    private final String distance;
    @SerializedName("geoReferences")
    @Nullable
    private final List<GeoReference> geoReferences;
    @SerializedName("hasVideo")
    @Nullable
    private final Boolean hasVideo;
    @SerializedName("hidesSeenBadge")
    private final boolean hidesViewedBadge;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final AdvertImage image;
    @SerializedName("imageList")
    @Nullable
    private final List<Image> imageList;
    @SerializedName("marketplaceSnippetInfo")
    @Nullable
    private final String inStock;
    @SerializedName("infoImage")
    @Nullable
    private final ForegroundImage infoImage;
    @SerializedName("isFavorite")
    private final boolean isFavorite;
    @SerializedName("isMarketplace")
    @Nullable
    private final Boolean isMarketplace;
    @SerializedName("isVerified")
    @Nullable
    private final Boolean isVerifiedSeller;
    @SerializedName("location")
    @Nullable
    private final String location;
    @SerializedName("locationId")
    @Nullable
    private final Integer locationId;
    @SerializedName("moreActions")
    @Nullable
    private final AdvertItemActions moreActions;
    @SerializedName("previousPrice")
    @Nullable
    private final String previousPrice;
    @SerializedName("price")
    @Nullable
    private final String price;
    @SerializedName("priceWithoutDiscount")
    @Nullable
    private final String priceWithoutDiscount;
    @SerializedName("radiusInfo")
    @Nullable
    private final RadiusInfo radiusInfo;
    @SerializedName("sellerInfo")
    @Nullable
    private final AdvertSellerInfo sellerInfo;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final List<String> services;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_SHOP)
    @Nullable
    private final NameIdEntity shop;
    @SerializedName("shortTermRent")
    @Nullable
    private final SerpAdvertStr shortTermRent;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("time")
    @Nullable
    private final Long time;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("marketplaceSnippetTrustFactor")
    @Nullable
    private final String trustFactor;
    private long uniqueId;
    @SerializedName("userType")
    @Nullable
    private final String userType;
    @SerializedName("video")
    @Nullable
    private final Video video;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SerpAdvert$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SerpAdvert;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SerpAdvert(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable SerpAdvertDelivery serpAdvertDelivery, @Nullable String str4, @Nullable Coordinates coordinates2, @Nullable Long l, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable AdvertImage advertImage, @Nullable NameIdEntity nameIdEntity, @Nullable NameIdEntity nameIdEntity2, @Nullable List<String> list, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Video video2, @Nullable String str12, boolean z, @Nullable Boolean bool, @Nullable DeepLink deepLink2, @Nullable Map<String, String> map, @Nullable SerpAdvertStr serpAdvertStr, @Nullable List<Image> list2, @Nullable Action action, @Nullable String str13, @Nullable LegacySerpAdvertBadge legacySerpAdvertBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable AdvertItemActions advertItemActions, @Nullable AdvertActions advertActions, @Nullable List<GeoReference> list3, @Nullable RadiusInfo radiusInfo2, @Nullable AdvertSellerInfo advertSellerInfo, @Nullable Boolean bool2, @Nullable String str14, @Nullable String str15, @Nullable ForegroundImage foregroundImage, @Nullable Boolean bool3, @Nullable Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str5, "title");
        this.id = str;
        this.address = str2;
        this.location = str3;
        this.delivery = serpAdvertDelivery;
        this.distance = str4;
        this.coordinates = coordinates2;
        this.time = l;
        this.title = str5;
        this.description = str6;
        this.userType = str7;
        this.image = advertImage;
        this.category = nameIdEntity;
        this.shop = nameIdEntity2;
        this.services = list;
        this.price = str8;
        this.priceWithoutDiscount = str9;
        this.previousPrice = str10;
        this.discountPercentage = str11;
        this.video = video2;
        this.status = str12;
        this.isFavorite = z;
        this.isVerifiedSeller = bool;
        this.deepLink = deepLink2;
        this.analyticParams = map;
        this.shortTermRent = serpAdvertStr;
        this.imageList = list2;
        this.additionalAction = action;
        this.additionalName = str13;
        this.badge = legacySerpAdvertBadge;
        this.badgeBar = serpBadgeBar;
        this.moreActions = advertItemActions;
        this.contacts = advertActions;
        this.geoReferences = list3;
        this.radiusInfo = radiusInfo2;
        this.sellerInfo = advertSellerInfo;
        this.hasVideo = bool2;
        this.inStock = str14;
        this.trustFactor = str15;
        this.infoImage = foregroundImage;
        this.isMarketplace = bool3;
        this.locationId = num;
        this.hidesViewedBadge = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAdditionalAction() {
        return this.additionalAction;
    }

    @Nullable
    public final String getAdditionalName() {
        return this.additionalName;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.analyticParams;
    }

    @Nullable
    public final LegacySerpAdvertBadge getBadge() {
        return this.badge;
    }

    @Nullable
    public final SerpBadgeBar getBadgeBar() {
        return this.badgeBar;
    }

    @Nullable
    public final NameIdEntity getCategory() {
        return this.category;
    }

    @Nullable
    public final AdvertActions getContacts() {
        return this.contacts;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final SerpAdvertDelivery getDelivery() {
        return this.delivery;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.geoReferences;
    }

    @Nullable
    public final Boolean getHasVideo() {
        return this.hasVideo;
    }

    public final boolean getHidesViewedBadge() {
        return this.hidesViewedBadge;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AdvertImage getImage() {
        return this.image;
    }

    @Nullable
    public final List<Image> getImageList() {
        return this.imageList;
    }

    @Nullable
    public final String getInStock() {
        return this.inStock;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.infoImage;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final Integer getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final AdvertItemActions getMoreActions() {
        return this.moreActions;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.previousPrice;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.priceWithoutDiscount;
    }

    @Nullable
    public final RadiusInfo getRadiusInfo() {
        return this.radiusInfo;
    }

    @Nullable
    public final AdvertSellerInfo getSellerInfo() {
        return this.sellerInfo;
    }

    @Nullable
    public final List<String> getServices() {
        return this.services;
    }

    @Nullable
    public final NameIdEntity getShop() {
        return this.shop;
    }

    @Nullable
    public final SerpAdvertStr getShortTermRent() {
        return this.shortTermRent;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrustFactor() {
        return this.trustFactor;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    @Nullable
    public final Video getVideo() {
        return this.video;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Nullable
    public final Boolean isMarketplace() {
        return this.isMarketplace;
    }

    @Nullable
    public final Boolean isVerifiedSeller() {
        return this.isVerifiedSeller;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.address);
        parcel.writeString(this.location);
        parcel.writeString(this.distance);
        parcel.writeParcelable(this.delivery, i);
        parcel.writeParcelable(this.coordinates, i);
        ParcelsKt.writeNullableValue(parcel, this.time);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.userType);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.category, i);
        parcel.writeParcelable(this.shop, i);
        parcel.writeStringList(this.services);
        parcel.writeString(this.price);
        parcel.writeString(this.priceWithoutDiscount);
        parcel.writeString(this.previousPrice);
        parcel.writeString(this.discountPercentage);
        parcel.writeParcelable(this.video, i);
        parcel.writeString(this.status);
        ParcelsKt.writeBool(parcel, this.isFavorite);
        ParcelsKt.writeNullableValue(parcel, this.isVerifiedSeller);
        parcel.writeParcelable(this.deepLink, i);
        ParcelsKt.writeValueMap(parcel, this.analyticParams);
        parcel.writeParcelable(this.shortTermRent, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.imageList, 0, 2, null);
        parcel.writeParcelable(this.additionalAction, i);
        parcel.writeString(this.additionalName);
        parcel.writeParcelable(this.badge, i);
        parcel.writeParcelable(this.badgeBar, i);
        parcel.writeParcelable(this.moreActions, i);
        parcel.writeParcelable(this.contacts, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.geoReferences, i);
        parcel.writeParcelable(this.radiusInfo, i);
        parcel.writeParcelable(this.sellerInfo, i);
        ParcelsKt.writeNullableValue(parcel, this.hasVideo);
        parcel.writeString(this.inStock);
        parcel.writeString(this.trustFactor);
        parcel.writeParcelable(this.infoImage, i);
        ParcelsKt.writeNullableValue(parcel, this.isMarketplace);
        ParcelsKt.writeNullableValue(parcel, this.locationId);
        ParcelsKt.writeBool(parcel, this.hidesViewedBadge);
        parcel.writeLong(getUniqueId());
    }
}
