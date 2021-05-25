package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.util.Parcels;
import com.facebook.appevents.integrity.IntegrityManager;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\u00020\u0001:\u0001RBÕ\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001f\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010-\u001a\u0004\u0018\u00010+\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u000100\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0019\u0012\u000e\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\"\u0012\b\u00107\u001a\u0004\u0018\u00010\u000b\u0012\b\u00108\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\"\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010G\u001a\u0004\u0018\u00010+\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\b\u0010M\u001a\u0004\u0018\u00010+\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010O\u001a\u00020+¢\u0006\u0004\bP\u0010QJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006S"}, d2 = {"Lcom/avito/android/remote/model/SerpAdvertXl;", "Lcom/avito/android/remote/model/SerpAdvert;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Action;", "callAction", "Lcom/avito/android/remote/model/Action;", "getCallAction", "()Lcom/avito/android/remote/model/Action;", "", "id", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "location", "Lcom/avito/android/remote/model/SerpAdvertDelivery;", "delivery", Sort.DISTANCE, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "", "time", "title", "userType", "Lcom/avito/android/remote/model/AdvertImage;", "image", "Lcom/avito/android/remote/model/NameIdEntity;", "category", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "", VKApiConst.SERVICES, "price", "priceWithoutDiscount", "previousPrice", "discountPercentage", "Lcom/avito/android/remote/model/Video;", "video", "status", "", "isFavorite", "isVerifiedSeller", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "analyticParams", "Lcom/avito/android/remote/model/SerpAdvertStr;", "shortTermRent", "uniqueId", "Lcom/avito/android/remote/model/Image;", "imageList", "additionalAction", "additionalName", "Lcom/avito/android/remote/model/LegacySerpAdvertBadge;", "badge", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "badgeBar", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "Lcom/avito/android/remote/model/AdvertActions;", "contacts", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "sellerInfo", "hasVideo", "inStock", "trustFactor", "description", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "isMarketplace", "locationId", "hidesViewedBadge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SerpAdvertDelivery;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertImage;Lcom/avito/android/remote/model/NameIdEntity;Lcom/avito/android/remote/model/NameIdEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Video;Ljava/lang/String;ZLjava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Lcom/avito/android/remote/model/SerpAdvertStr;JLjava/util/List;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Lcom/avito/android/remote/model/LegacySerpAdvertBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/AdvertItemActions;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/RadiusInfo;Ljava/util/List;Lcom/avito/android/remote/model/AdvertSellerInfo;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/ForegroundImage;Ljava/lang/Boolean;Ljava/lang/Integer;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertXl extends SerpAdvert {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpAdvertXl> CREATOR = Parcels.creator(SerpAdvertXl$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("callAction")
    @Nullable
    private final Action callAction;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SerpAdvertXl$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SerpAdvertXl;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpAdvertXl(String str, String str2, String str3, SerpAdvertDelivery serpAdvertDelivery, String str4, Coordinates coordinates, Long l, String str5, String str6, AdvertImage advertImage, NameIdEntity nameIdEntity, NameIdEntity nameIdEntity2, List list, String str7, String str8, String str9, String str10, Video video, String str11, boolean z, Boolean bool, DeepLink deepLink, Map map, SerpAdvertStr serpAdvertStr, long j, List list2, Action action, String str12, LegacySerpAdvertBadge legacySerpAdvertBadge, SerpBadgeBar serpBadgeBar, AdvertItemActions advertItemActions, AdvertActions advertActions, RadiusInfo radiusInfo, List list3, AdvertSellerInfo advertSellerInfo, Boolean bool2, String str13, String str14, String str15, Action action2, ForegroundImage foregroundImage, Boolean bool3, Integer num, boolean z2, int i, int i2, j jVar) {
        this(str, str2, str3, serpAdvertDelivery, str4, coordinates, l, str5, str6, advertImage, nameIdEntity, nameIdEntity2, list, str7, str8, str9, str10, video, str11, z, bool, deepLink, map, serpAdvertStr, (i & 16777216) != 0 ? 0 : j, list2, action, str12, legacySerpAdvertBadge, serpBadgeBar, advertItemActions, advertActions, radiusInfo, list3, advertSellerInfo, bool2, str13, str14, str15, action2, foregroundImage, bool3, num, z2);
    }

    @Override // com.avito.android.remote.model.SerpAdvert, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getCallAction() {
        return this.callAction;
    }

    @Override // com.avito.android.remote.model.SerpAdvert, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.callAction, i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerpAdvertXl(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable SerpAdvertDelivery serpAdvertDelivery, @Nullable String str4, @Nullable Coordinates coordinates, @Nullable Long l, @NotNull String str5, @Nullable String str6, @Nullable AdvertImage advertImage, @Nullable NameIdEntity nameIdEntity, @Nullable NameIdEntity nameIdEntity2, @Nullable List<String> list, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Video video, @Nullable String str11, boolean z, @Nullable Boolean bool, @Nullable DeepLink deepLink, @Nullable Map<String, String> map, @Nullable SerpAdvertStr serpAdvertStr, long j, @Nullable List<Image> list2, @Nullable Action action, @Nullable String str12, @Nullable LegacySerpAdvertBadge legacySerpAdvertBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable AdvertItemActions advertItemActions, @Nullable AdvertActions advertActions, @Nullable RadiusInfo radiusInfo, @Nullable List<GeoReference> list3, @Nullable AdvertSellerInfo advertSellerInfo, @Nullable Boolean bool2, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable Action action2, @Nullable ForegroundImage foregroundImage, @Nullable Boolean bool3, @Nullable Integer num, boolean z2) {
        super(str, str2, str3, serpAdvertDelivery, str4, coordinates, l, str5, str15, str6, advertImage, nameIdEntity, nameIdEntity2, list, str7, str8, str9, str10, video, str11, z, bool, deepLink, map, serpAdvertStr, list2, action, str12, legacySerpAdvertBadge, serpBadgeBar, advertItemActions, advertActions, list3, radiusInfo, advertSellerInfo, bool2, str13, str14, foregroundImage, bool3, num, z2);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str5, "title");
        this.callAction = action2;
        setUniqueId(j);
    }
}
