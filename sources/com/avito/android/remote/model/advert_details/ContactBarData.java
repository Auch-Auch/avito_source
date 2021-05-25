package com.avito.android.remote.model.advert_details;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AdvertisementVerticalAlias;
import com.avito.android.remote.model.IceBreakers;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.VehicleType;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b)\b\b\u0018\u0000 2\u00020\u0001:\u0001B\u0002\u0012\u0006\u0010:\u001a\u00020\u000b\u0012\u0006\u0010;\u001a\u00020\u000e\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010=\u001a\u00020\u0014\u0012\u0006\u0010>\u001a\u00020\u000b\u0012\u0006\u0010?\u001a\u00020\u000b\u0012\u0006\u0010@\u001a\u00020\u000b\u0012\b\u0010A\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010C\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010D\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010E\u001a\u00020 \u0012\b\u0010F\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010G\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010H\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010I\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010J\u001a\u00020'\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010L\u001a\u00020+\u0012\u0006\u0010M\u001a\u00020\u000b\u0012\b\b\u0002\u0010N\u001a\u00020 \u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u000103\u0012\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u000106\u0012\u0006\u0010R\u001a\u00020 ¢\u0006\u0004\b}\u0010~J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0013J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\rJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010!\u001a\u00020 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b#\u0010\rJ\u0012\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b$\u0010\rJ\u0012\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b%\u0010\rJ\u0012\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b&\u0010\rJ\u0010\u0010(\u001a\u00020'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b*\u0010\rJ\u0010\u0010,\u001a\u00020+HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b.\u0010\rJ\u0010\u0010/\u001a\u00020 HÆ\u0003¢\u0006\u0004\b/\u0010\"J\u0012\u00101\u001a\u0004\u0018\u000100HÆ\u0003¢\u0006\u0004\b1\u00102J\u0012\u00104\u001a\u0004\u0018\u000103HÆ\u0003¢\u0006\u0004\b4\u00105J\u001e\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u000106HÆ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020 HÆ\u0003¢\u0006\u0004\b9\u0010\"J°\u0002\u0010S\u001a\u00020\u00002\b\b\u0002\u0010:\u001a\u00020\u000b2\b\b\u0002\u0010;\u001a\u00020\u000e2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010=\u001a\u00020\u00142\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010E\u001a\u00020 2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010L\u001a\u00020+2\b\b\u0002\u0010M\u001a\u00020\u000b2\b\b\u0002\u0010N\u001a\u00020 2\n\b\u0002\u0010O\u001a\u0004\u0018\u0001002\n\b\u0002\u0010P\u001a\u0004\u0018\u0001032\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001062\b\b\u0002\u0010R\u001a\u00020 HÆ\u0001¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bU\u0010\rJ\u0010\u0010V\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bV\u0010\nJ\u001a\u0010Y\u001a\u00020 2\b\u0010X\u001a\u0004\u0018\u00010WHÖ\u0003¢\u0006\u0004\bY\u0010ZR\u0019\u0010?\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010[\u001a\u0004\b\\\u0010\rR\u0019\u0010:\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010[\u001a\u0004\b]\u0010\rR\u001b\u0010K\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010[\u001a\u0004\b^\u0010\rR\u001b\u0010O\u001a\u0004\u0018\u0001008\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010_\u001a\u0004\b`\u00102R\u001b\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010[\u001a\u0004\ba\u0010\rR\u0019\u0010N\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010b\u001a\u0004\bc\u0010\"R'\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010d\u001a\u0004\be\u00108R\u001b\u0010P\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010f\u001a\u0004\bg\u00105R\u0019\u0010L\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010h\u001a\u0004\bi\u0010-R\u001b\u0010I\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010[\u001a\u0004\bj\u0010\rR\u001b\u0010G\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010[\u001a\u0004\bk\u0010\rR\u0019\u0010=\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010l\u001a\u0004\bm\u0010\u0016R\u001b\u0010D\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010[\u001a\u0004\bn\u0010\rR\u0019\u0010E\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010b\u001a\u0004\bE\u0010\"R\u001b\u0010C\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010[\u001a\u0004\bo\u0010\rR\u0019\u0010;\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010p\u001a\u0004\bq\u0010\u0010R\u0019\u0010@\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010[\u001a\u0004\br\u0010\rR\u0019\u0010J\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010s\u001a\u0004\bt\u0010)R\u0019\u0010M\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010[\u001a\u0004\bu\u0010\rR\u001b\u0010A\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010v\u001a\u0004\bw\u0010\u001cR\u001b\u0010<\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010x\u001a\u0004\by\u0010\u0013R\u0019\u0010>\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010[\u001a\u0004\bz\u0010\rR\u001b\u0010B\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010x\u001a\u0004\b{\u0010\u0013R\u001b\u0010H\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010[\u001a\u0004\b|\u0010\rR\u0019\u0010R\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010b\u001a\u0004\bR\u0010\"¨\u0006\u0001"}, d2 = {"Lcom/avito/android/remote/model/advert_details/ContactBarData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "component2", "()Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "component4", "()Lcom/avito/android/remote/model/advert_details/UserIconType;", "component5", "component6", "component7", "Lcom/avito/android/remote/model/AdvertPrice;", "component8", "()Lcom/avito/android/remote/model/AdvertPrice;", "component9", "component10", "component11", "", "component12", "()Z", "component13", "component14", "component15", "component16", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "component17", "()Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "component18", "Lcom/avito/android/remote/model/VehicleType;", "component19", "()Lcom/avito/android/remote/model/VehicleType;", "component20", "component21", "Lcom/avito/android/remote/model/IceBreakers;", "component22", "()Lcom/avito/android/remote/model/IceBreakers;", "", "component23", "()Ljava/lang/Double;", "", "component24", "()Ljava/util/Map;", "component25", "name", "onlineStatus", "avatar", "iconType", BookingInfoActivity.EXTRA_ITEM_ID, "advertTitle", "advertDescription", "advertPrice", "advertImage", "categoryId", "adjustCategoryId", "isFromCompany", UrlParams.METRO_ID, "userHashId", "locationId", "shopId", "verticalAlias", "microCategoryId", "vehicleType", "source", "showTrade", "iceBreakers", "customerValue", "viewItemAndBuyerEventsParams", "isMarketPlace", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/advert_details/UserIconType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertPrice;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertisementVerticalAlias;Ljava/lang/String;Lcom/avito/android/remote/model/VehicleType;Ljava/lang/String;ZLcom/avito/android/remote/model/IceBreakers;Ljava/lang/Double;Ljava/util/Map;Z)Lcom/avito/android/remote/model/advert_details/ContactBarData;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAdvertTitle", "getName", "getMicroCategoryId", "Lcom/avito/android/remote/model/IceBreakers;", "getIceBreakers", "getMetroId", "Z", "getShowTrade", "Ljava/util/Map;", "getViewItemAndBuyerEventsParams", "Ljava/lang/Double;", "getCustomerValue", "Lcom/avito/android/remote/model/VehicleType;", "getVehicleType", "getShopId", "getUserHashId", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "getIconType", "getAdjustCategoryId", "getCategoryId", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "getOnlineStatus", "getAdvertDescription", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "getVerticalAlias", "getSource", "Lcom/avito/android/remote/model/AdvertPrice;", "getAdvertPrice", "Lcom/avito/android/remote/model/Image;", "getAvatar", "getAdvertId", "getAdvertImage", "getLocationId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/advert_details/UserIconType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertPrice;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertisementVerticalAlias;Ljava/lang/String;Lcom/avito/android/remote/model/VehicleType;Ljava/lang/String;ZLcom/avito/android/remote/model/IceBreakers;Ljava/lang/Double;Ljava/util/Map;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ContactBarData implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ContactBarData> CREATOR = Parcels.creator(ContactBarData$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final String adjustCategoryId;
    @NotNull
    private final String advertDescription;
    @NotNull
    private final String advertId;
    @Nullable
    private final Image advertImage;
    @Nullable
    private final AdvertPrice advertPrice;
    @NotNull
    private final String advertTitle;
    @Nullable
    private final Image avatar;
    @Nullable
    private final String categoryId;
    @Nullable
    private final Double customerValue;
    @Nullable
    private final IceBreakers iceBreakers;
    @NotNull
    private final UserIconType iconType;
    private final boolean isFromCompany;
    private final boolean isMarketPlace;
    @Nullable
    private final String locationId;
    @Nullable
    private final String metroId;
    @Nullable
    private final String microCategoryId;
    @NotNull
    private final String name;
    @NotNull
    private final SellerOnlineStatus onlineStatus;
    @Nullable
    private final String shopId;
    private final boolean showTrade;
    @NotNull
    private final String source;
    @Nullable
    private final String userHashId;
    @NotNull
    private final VehicleType vehicleType;
    @NotNull
    private final AdvertisementVerticalAlias verticalAlias;
    @Nullable
    private final Map<String, String> viewItemAndBuyerEventsParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/advert_details/ContactBarData$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ContactBarData(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus, @Nullable Image image, @NotNull UserIconType userIconType, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable AdvertPrice advertPrice2, @Nullable Image image2, @Nullable String str5, @Nullable String str6, boolean z, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @NotNull AdvertisementVerticalAlias advertisementVerticalAlias, @Nullable String str11, @NotNull VehicleType vehicleType2, @NotNull String str12, boolean z2, @Nullable IceBreakers iceBreakers2, @Nullable Double d, @Nullable Map<String, String> map, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "advertTitle");
        Intrinsics.checkNotNullParameter(str4, "advertDescription");
        Intrinsics.checkNotNullParameter(advertisementVerticalAlias, "verticalAlias");
        Intrinsics.checkNotNullParameter(vehicleType2, "vehicleType");
        Intrinsics.checkNotNullParameter(str12, "source");
        this.name = str;
        this.onlineStatus = sellerOnlineStatus;
        this.avatar = image;
        this.iconType = userIconType;
        this.advertId = str2;
        this.advertTitle = str3;
        this.advertDescription = str4;
        this.advertPrice = advertPrice2;
        this.advertImage = image2;
        this.categoryId = str5;
        this.adjustCategoryId = str6;
        this.isFromCompany = z;
        this.metroId = str7;
        this.userHashId = str8;
        this.locationId = str9;
        this.shopId = str10;
        this.verticalAlias = advertisementVerticalAlias;
        this.microCategoryId = str11;
        this.vehicleType = vehicleType2;
        this.source = str12;
        this.showTrade = z2;
        this.iceBreakers = iceBreakers2;
        this.customerValue = d;
        this.viewItemAndBuyerEventsParams = map;
        this.isMarketPlace = z3;
    }

    public static /* synthetic */ ContactBarData copy$default(ContactBarData contactBarData, String str, SellerOnlineStatus sellerOnlineStatus, Image image, UserIconType userIconType, String str2, String str3, String str4, AdvertPrice advertPrice2, Image image2, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, AdvertisementVerticalAlias advertisementVerticalAlias, String str11, VehicleType vehicleType2, String str12, boolean z2, IceBreakers iceBreakers2, Double d, Map map, boolean z3, int i, Object obj) {
        return contactBarData.copy((i & 1) != 0 ? contactBarData.name : str, (i & 2) != 0 ? contactBarData.onlineStatus : sellerOnlineStatus, (i & 4) != 0 ? contactBarData.avatar : image, (i & 8) != 0 ? contactBarData.iconType : userIconType, (i & 16) != 0 ? contactBarData.advertId : str2, (i & 32) != 0 ? contactBarData.advertTitle : str3, (i & 64) != 0 ? contactBarData.advertDescription : str4, (i & 128) != 0 ? contactBarData.advertPrice : advertPrice2, (i & 256) != 0 ? contactBarData.advertImage : image2, (i & 512) != 0 ? contactBarData.categoryId : str5, (i & 1024) != 0 ? contactBarData.adjustCategoryId : str6, (i & 2048) != 0 ? contactBarData.isFromCompany : z, (i & 4096) != 0 ? contactBarData.metroId : str7, (i & 8192) != 0 ? contactBarData.userHashId : str8, (i & 16384) != 0 ? contactBarData.locationId : str9, (i & 32768) != 0 ? contactBarData.shopId : str10, (i & 65536) != 0 ? contactBarData.verticalAlias : advertisementVerticalAlias, (i & 131072) != 0 ? contactBarData.microCategoryId : str11, (i & 262144) != 0 ? contactBarData.vehicleType : vehicleType2, (i & 524288) != 0 ? contactBarData.source : str12, (i & 1048576) != 0 ? contactBarData.showTrade : z2, (i & 2097152) != 0 ? contactBarData.iceBreakers : iceBreakers2, (i & 4194304) != 0 ? contactBarData.customerValue : d, (i & 8388608) != 0 ? contactBarData.viewItemAndBuyerEventsParams : map, (i & 16777216) != 0 ? contactBarData.isMarketPlace : z3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component10() {
        return this.categoryId;
    }

    @Nullable
    public final String component11() {
        return this.adjustCategoryId;
    }

    public final boolean component12() {
        return this.isFromCompany;
    }

    @Nullable
    public final String component13() {
        return this.metroId;
    }

    @Nullable
    public final String component14() {
        return this.userHashId;
    }

    @Nullable
    public final String component15() {
        return this.locationId;
    }

    @Nullable
    public final String component16() {
        return this.shopId;
    }

    @NotNull
    public final AdvertisementVerticalAlias component17() {
        return this.verticalAlias;
    }

    @Nullable
    public final String component18() {
        return this.microCategoryId;
    }

    @NotNull
    public final VehicleType component19() {
        return this.vehicleType;
    }

    @NotNull
    public final SellerOnlineStatus component2() {
        return this.onlineStatus;
    }

    @NotNull
    public final String component20() {
        return this.source;
    }

    public final boolean component21() {
        return this.showTrade;
    }

    @Nullable
    public final IceBreakers component22() {
        return this.iceBreakers;
    }

    @Nullable
    public final Double component23() {
        return this.customerValue;
    }

    @Nullable
    public final Map<String, String> component24() {
        return this.viewItemAndBuyerEventsParams;
    }

    public final boolean component25() {
        return this.isMarketPlace;
    }

    @Nullable
    public final Image component3() {
        return this.avatar;
    }

    @NotNull
    public final UserIconType component4() {
        return this.iconType;
    }

    @NotNull
    public final String component5() {
        return this.advertId;
    }

    @NotNull
    public final String component6() {
        return this.advertTitle;
    }

    @NotNull
    public final String component7() {
        return this.advertDescription;
    }

    @Nullable
    public final AdvertPrice component8() {
        return this.advertPrice;
    }

    @Nullable
    public final Image component9() {
        return this.advertImage;
    }

    @NotNull
    public final ContactBarData copy(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus, @Nullable Image image, @NotNull UserIconType userIconType, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable AdvertPrice advertPrice2, @Nullable Image image2, @Nullable String str5, @Nullable String str6, boolean z, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @NotNull AdvertisementVerticalAlias advertisementVerticalAlias, @Nullable String str11, @NotNull VehicleType vehicleType2, @NotNull String str12, boolean z2, @Nullable IceBreakers iceBreakers2, @Nullable Double d, @Nullable Map<String, String> map, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "advertTitle");
        Intrinsics.checkNotNullParameter(str4, "advertDescription");
        Intrinsics.checkNotNullParameter(advertisementVerticalAlias, "verticalAlias");
        Intrinsics.checkNotNullParameter(vehicleType2, "vehicleType");
        Intrinsics.checkNotNullParameter(str12, "source");
        return new ContactBarData(str, sellerOnlineStatus, image, userIconType, str2, str3, str4, advertPrice2, image2, str5, str6, z, str7, str8, str9, str10, advertisementVerticalAlias, str11, vehicleType2, str12, z2, iceBreakers2, d, map, z3);
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
        if (!(obj instanceof ContactBarData)) {
            return false;
        }
        ContactBarData contactBarData = (ContactBarData) obj;
        return Intrinsics.areEqual(this.name, contactBarData.name) && Intrinsics.areEqual(this.onlineStatus, contactBarData.onlineStatus) && Intrinsics.areEqual(this.avatar, contactBarData.avatar) && Intrinsics.areEqual(this.iconType, contactBarData.iconType) && Intrinsics.areEqual(this.advertId, contactBarData.advertId) && Intrinsics.areEqual(this.advertTitle, contactBarData.advertTitle) && Intrinsics.areEqual(this.advertDescription, contactBarData.advertDescription) && Intrinsics.areEqual(this.advertPrice, contactBarData.advertPrice) && Intrinsics.areEqual(this.advertImage, contactBarData.advertImage) && Intrinsics.areEqual(this.categoryId, contactBarData.categoryId) && Intrinsics.areEqual(this.adjustCategoryId, contactBarData.adjustCategoryId) && this.isFromCompany == contactBarData.isFromCompany && Intrinsics.areEqual(this.metroId, contactBarData.metroId) && Intrinsics.areEqual(this.userHashId, contactBarData.userHashId) && Intrinsics.areEqual(this.locationId, contactBarData.locationId) && Intrinsics.areEqual(this.shopId, contactBarData.shopId) && Intrinsics.areEqual(this.verticalAlias, contactBarData.verticalAlias) && Intrinsics.areEqual(this.microCategoryId, contactBarData.microCategoryId) && Intrinsics.areEqual(this.vehicleType, contactBarData.vehicleType) && Intrinsics.areEqual(this.source, contactBarData.source) && this.showTrade == contactBarData.showTrade && Intrinsics.areEqual(this.iceBreakers, contactBarData.iceBreakers) && Intrinsics.areEqual(this.customerValue, contactBarData.customerValue) && Intrinsics.areEqual(this.viewItemAndBuyerEventsParams, contactBarData.viewItemAndBuyerEventsParams) && this.isMarketPlace == contactBarData.isMarketPlace;
    }

    @Nullable
    public final String getAdjustCategoryId() {
        return this.adjustCategoryId;
    }

    @NotNull
    public final String getAdvertDescription() {
        return this.advertDescription;
    }

    @NotNull
    public final String getAdvertId() {
        return this.advertId;
    }

    @Nullable
    public final Image getAdvertImage() {
        return this.advertImage;
    }

    @Nullable
    public final AdvertPrice getAdvertPrice() {
        return this.advertPrice;
    }

    @NotNull
    public final String getAdvertTitle() {
        return this.advertTitle;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final Double getCustomerValue() {
        return this.customerValue;
    }

    @Nullable
    public final IceBreakers getIceBreakers() {
        return this.iceBreakers;
    }

    @NotNull
    public final UserIconType getIconType() {
        return this.iconType;
    }

    @Nullable
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final String getMetroId() {
        return this.metroId;
    }

    @Nullable
    public final String getMicroCategoryId() {
        return this.microCategoryId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final SellerOnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    @Nullable
    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowTrade() {
        return this.showTrade;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getUserHashId() {
        return this.userHashId;
    }

    @NotNull
    public final VehicleType getVehicleType() {
        return this.vehicleType;
    }

    @NotNull
    public final AdvertisementVerticalAlias getVerticalAlias() {
        return this.verticalAlias;
    }

    @Nullable
    public final Map<String, String> getViewItemAndBuyerEventsParams() {
        return this.viewItemAndBuyerEventsParams;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SellerOnlineStatus sellerOnlineStatus = this.onlineStatus;
        int hashCode2 = (hashCode + (sellerOnlineStatus != null ? sellerOnlineStatus.hashCode() : 0)) * 31;
        Image image = this.avatar;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        UserIconType userIconType = this.iconType;
        int hashCode4 = (hashCode3 + (userIconType != null ? userIconType.hashCode() : 0)) * 31;
        String str2 = this.advertId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.advertTitle;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.advertDescription;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        AdvertPrice advertPrice2 = this.advertPrice;
        int hashCode8 = (hashCode7 + (advertPrice2 != null ? advertPrice2.hashCode() : 0)) * 31;
        Image image2 = this.advertImage;
        int hashCode9 = (hashCode8 + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str5 = this.categoryId;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.adjustCategoryId;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.isFromCompany;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode11 + i3) * 31;
        String str7 = this.metroId;
        int hashCode12 = (i6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.userHashId;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.locationId;
        int hashCode14 = (hashCode13 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.shopId;
        int hashCode15 = (hashCode14 + (str10 != null ? str10.hashCode() : 0)) * 31;
        AdvertisementVerticalAlias advertisementVerticalAlias = this.verticalAlias;
        int hashCode16 = (hashCode15 + (advertisementVerticalAlias != null ? advertisementVerticalAlias.hashCode() : 0)) * 31;
        String str11 = this.microCategoryId;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31;
        VehicleType vehicleType2 = this.vehicleType;
        int hashCode18 = (hashCode17 + (vehicleType2 != null ? vehicleType2.hashCode() : 0)) * 31;
        String str12 = this.source;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 31;
        boolean z2 = this.showTrade;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode19 + i7) * 31;
        IceBreakers iceBreakers2 = this.iceBreakers;
        int hashCode20 = (i10 + (iceBreakers2 != null ? iceBreakers2.hashCode() : 0)) * 31;
        Double d = this.customerValue;
        int hashCode21 = (hashCode20 + (d != null ? d.hashCode() : 0)) * 31;
        Map<String, String> map = this.viewItemAndBuyerEventsParams;
        if (map != null) {
            i = map.hashCode();
        }
        int i11 = (hashCode21 + i) * 31;
        boolean z3 = this.isMarketPlace;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        return i11 + i2;
    }

    public final boolean isFromCompany() {
        return this.isFromCompany;
    }

    public final boolean isMarketPlace() {
        return this.isMarketPlace;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactBarData(name=");
        L.append(this.name);
        L.append(", onlineStatus=");
        L.append(this.onlineStatus);
        L.append(", avatar=");
        L.append(this.avatar);
        L.append(", iconType=");
        L.append(this.iconType);
        L.append(", advertId=");
        L.append(this.advertId);
        L.append(", advertTitle=");
        L.append(this.advertTitle);
        L.append(", advertDescription=");
        L.append(this.advertDescription);
        L.append(", advertPrice=");
        L.append(this.advertPrice);
        L.append(", advertImage=");
        L.append(this.advertImage);
        L.append(", categoryId=");
        L.append(this.categoryId);
        L.append(", adjustCategoryId=");
        L.append(this.adjustCategoryId);
        L.append(", isFromCompany=");
        L.append(this.isFromCompany);
        L.append(", metroId=");
        L.append(this.metroId);
        L.append(", userHashId=");
        L.append(this.userHashId);
        L.append(", locationId=");
        L.append(this.locationId);
        L.append(", shopId=");
        L.append(this.shopId);
        L.append(", verticalAlias=");
        L.append(this.verticalAlias);
        L.append(", microCategoryId=");
        L.append(this.microCategoryId);
        L.append(", vehicleType=");
        L.append(this.vehicleType);
        L.append(", source=");
        L.append(this.source);
        L.append(", showTrade=");
        L.append(this.showTrade);
        L.append(", iceBreakers=");
        L.append(this.iceBreakers);
        L.append(", customerValue=");
        L.append(this.customerValue);
        L.append(", viewItemAndBuyerEventsParams=");
        L.append(this.viewItemAndBuyerEventsParams);
        L.append(", isMarketPlace=");
        return a.B(L, this.isMarketPlace, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeParcelable(this.onlineStatus, i);
        parcel.writeParcelable(this.avatar, i);
        ParcelsKt.writeEnum(parcel, this.iconType);
        parcel.writeString(this.advertId);
        parcel.writeString(this.advertTitle);
        parcel.writeString(this.advertDescription);
        parcel.writeParcelable(this.advertPrice, i);
        parcel.writeParcelable(this.advertImage, i);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.adjustCategoryId);
        ParcelsKt.writeBool(parcel, this.isFromCompany);
        parcel.writeString(this.metroId);
        parcel.writeString(this.userHashId);
        parcel.writeString(this.locationId);
        parcel.writeString(this.shopId);
        ParcelsKt.writeEnum(parcel, this.verticalAlias);
        parcel.writeString(this.microCategoryId);
        ParcelsKt.writeEnum(parcel, this.vehicleType);
        parcel.writeString(this.source);
        ParcelsKt.writeBool(parcel, this.showTrade);
        parcel.writeParcelable(this.iceBreakers, i);
        parcel.writeMap(this.viewItemAndBuyerEventsParams);
        ParcelsKt.writeBool(parcel, this.isMarketPlace);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactBarData(String str, SellerOnlineStatus sellerOnlineStatus, Image image, UserIconType userIconType, String str2, String str3, String str4, AdvertPrice advertPrice2, Image image2, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, AdvertisementVerticalAlias advertisementVerticalAlias, String str11, VehicleType vehicleType2, String str12, boolean z2, IceBreakers iceBreakers2, Double d, Map map, boolean z3, int i, j jVar) {
        this(str, sellerOnlineStatus, (i & 4) != 0 ? null : image, userIconType, str2, str3, str4, advertPrice2, image2, str5, str6, z, str7, str8, str9, str10, advertisementVerticalAlias, (i & 131072) != 0 ? null : str11, vehicleType2, str12, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? null : iceBreakers2, (i & 4194304) != 0 ? null : d, (i & 8388608) != 0 ? null : map, z3);
    }
}
