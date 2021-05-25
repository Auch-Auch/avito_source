package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001]B÷\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u0012\u0006\u0010R\u001a\u00020\u0015\u0012\u0006\u0010G\u001a\u00020\u0015\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010-\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u00108\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010<\u001a\u00020\u0015\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001a\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010/\u001a\u00020\u0015\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0015\u0012\b\u00106\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b[\u0010\\J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001e\u0010!\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001c\u0010$\u001a\u00020#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019R\u001c\u0010/\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u0019R\u001e\u00102\u001a\u0004\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010\u0017\u001a\u0004\b7\u0010\u0019R\u001e\u00108\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u0010\u0017\u001a\u0004\b9\u0010\u0019R\u001e\u0010:\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019R\u001c\u0010<\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010\u0017\u001a\u0004\b=\u0010\u0019R\u001e\u0010>\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019R\u001e\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010E\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bE\u0010\u0017\u001a\u0004\bF\u0010\u0019R\u001c\u0010G\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bG\u0010\u0017\u001a\u0004\bH\u0010\u0019R\u001e\u0010I\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bI\u0010\u0017\u001a\u0004\bJ\u0010\u0019R\u001e\u0010K\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bK\u0010\u0017\u001a\u0004\bL\u0010\u0019R\u001c\u0010N\u001a\u00020M8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010R\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bR\u0010\u0017\u001a\u0004\bS\u0010\u0019R\u001e\u0010T\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bT\u0010\u0017\u001a\u0004\bU\u0010\u0019R\u001e\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/remote/model/FavoriteAdvert;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/FavoriteAdvert$Delivery;", "delivery", "Lcom/avito/android/remote/model/FavoriteAdvert$Delivery;", "getDelivery", "()Lcom/avito/android/remote/model/FavoriteAdvert$Delivery;", "Lcom/avito/android/remote/model/AdvertImage;", "image", "Lcom/avito/android/remote/model/AdvertImage;", "getImage", "()Lcom/avito/android/remote/model/AdvertImage;", "", UrlParams.DISTRICT_ID, "Ljava/lang/String;", "getDistrictId", "()Ljava/lang/String;", "", VKApiConst.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "id", "getId", UrlParams.METRO_ID, "getMetroId", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "Lcom/avito/android/remote/model/AdvertSeller;", "getSeller", "()Lcom/avito/android/remote/model/AdvertSeller;", "Lcom/avito/android/remote/model/AdvertPrice;", "price", "Lcom/avito/android/remote/model/AdvertPrice;", "getPrice", "()Lcom/avito/android/remote/model/AdvertPrice;", "title", "getTitle", "status", "getStatus", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "location", "getLocation", "shopTitle", "getShopTitle", "statusDescription", "getStatusDescription", "userType", "getUserType", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "", "expired", "Ljava/lang/Boolean;", "getExpired", "()Ljava/lang/Boolean;", "previousPrice", "getPreviousPrice", "locationId", "getLocationId", UrlParams.DIRECTION_ID, "getDirectionId", VKAttachments.TYPE_NOTE, "getNote", "", "time", "J", "getTime", "()J", "categoryId", "getCategoryId", "currentPrice", "getCurrentPrice", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/avito/android/remote/model/AdvertSeller;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/AdvertImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertPrice;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/FavoriteAdvert$Delivery;Ljava/lang/String;)V", "Delivery", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvert implements Parcelable {
    public static final Parcelable.Creator<FavoriteAdvert> CREATOR = new Creator();
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final String address;
    @SerializedName("categoryId")
    @NotNull
    private final String categoryId;
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coordinates;
    @SerializedName("currentPrice")
    @Nullable
    private final String currentPrice;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("delivery")
    @Nullable
    private final Delivery delivery;
    @SerializedName(UrlParams.DIRECTION_ID)
    @Nullable
    private final String directionId;
    @SerializedName(UrlParams.DISTRICT_ID)
    @Nullable
    private final String districtId;
    @SerializedName("expired")
    @Nullable
    private final Boolean expired;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final AdvertImage image;
    @SerializedName("location")
    @Nullable
    private final String location;
    @SerializedName("locationId")
    @NotNull
    private final String locationId;
    @SerializedName(UrlParams.METRO_ID)
    @Nullable
    private final String metroId;
    @SerializedName(VKAttachments.TYPE_NOTE)
    @Nullable
    private final String note;
    @SerializedName("previousPrice")
    @Nullable
    private final String previousPrice;
    @SerializedName("price")
    @Nullable
    private final AdvertPrice price;
    @SerializedName("seller")
    @NotNull
    private final AdvertSeller seller;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final List<String> services;
    @SerializedName("shopTitle")
    @Nullable
    private final String shopTitle;
    @SerializedName("status")
    @NotNull
    private final String status;
    @SerializedName("statusDescription")
    @Nullable
    private final String statusDescription;
    @SerializedName("time")
    private final long time;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("userType")
    @NotNull
    private final String userType;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FavoriteAdvert> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteAdvert createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            long readLong = parcel.readLong();
            String readString7 = parcel.readString();
            AdvertSeller advertSeller = (AdvertSeller) parcel.readParcelable(FavoriteAdvert.class.getClassLoader());
            Coordinates coordinates = (Coordinates) parcel.readParcelable(FavoriteAdvert.class.getClassLoader());
            AdvertImage advertImage = (AdvertImage) parcel.readParcelable(FavoriteAdvert.class.getClassLoader());
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString10 = parcel.readString();
            AdvertPrice advertPrice = (AdvertPrice) parcel.readParcelable(FavoriteAdvert.class.getClassLoader());
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            DeepLink deepLink = (DeepLink) parcel.readParcelable(FavoriteAdvert.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new FavoriteAdvert(readString, readString2, readString3, readString4, readString5, readString6, readLong, readString7, advertSeller, coordinates, advertImage, readString8, readString9, createStringArrayList, readString10, advertPrice, readString11, readString12, deepLink, bool, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Delivery.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteAdvert[] newArray(int i) {
            return new FavoriteAdvert[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/FavoriteAdvert$Delivery;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "favorite_release"}, k = 1, mv = {1, 4, 2})
    public static final class Delivery implements Parcelable {
        public static final Parcelable.Creator<Delivery> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Delivery> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Delivery createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new Delivery();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Delivery[] newArray(int i) {
                return new Delivery[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    public FavoriteAdvert(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, long j, @NotNull String str7, @NotNull AdvertSeller advertSeller, @Nullable Coordinates coordinates2, @Nullable AdvertImage advertImage, @Nullable String str8, @NotNull String str9, @Nullable List<String> list, @Nullable String str10, @Nullable AdvertPrice advertPrice, @NotNull String str11, @Nullable String str12, @Nullable DeepLink deepLink2, @Nullable Boolean bool, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable Delivery delivery2, @Nullable String str16) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(str3, "locationId");
        Intrinsics.checkNotNullParameter(str7, "title");
        Intrinsics.checkNotNullParameter(advertSeller, "seller");
        Intrinsics.checkNotNullParameter(str9, "userType");
        Intrinsics.checkNotNullParameter(str11, "status");
        this.id = str;
        this.categoryId = str2;
        this.locationId = str3;
        this.metroId = str4;
        this.directionId = str5;
        this.districtId = str6;
        this.time = j;
        this.title = str7;
        this.seller = advertSeller;
        this.coordinates = coordinates2;
        this.image = advertImage;
        this.shopTitle = str8;
        this.userType = str9;
        this.services = list;
        this.address = str10;
        this.price = advertPrice;
        this.status = str11;
        this.note = str12;
        this.deepLink = deepLink2;
        this.expired = bool;
        this.currentPrice = str13;
        this.previousPrice = str14;
        this.location = str15;
        this.delivery = delivery2;
        this.statusDescription = str16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final String getCurrentPrice() {
        return this.currentPrice;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final Delivery getDelivery() {
        return this.delivery;
    }

    @Nullable
    public final String getDirectionId() {
        return this.directionId;
    }

    @Nullable
    public final String getDistrictId() {
        return this.districtId;
    }

    @Nullable
    public final Boolean getExpired() {
        return this.expired;
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
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final String getMetroId() {
        return this.metroId;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.previousPrice;
    }

    @Nullable
    public final AdvertPrice getPrice() {
        return this.price;
    }

    @NotNull
    public final AdvertSeller getSeller() {
        return this.seller;
    }

    @Nullable
    public final List<String> getServices() {
        return this.services;
    }

    @Nullable
    public final String getShopTitle() {
        return this.shopTitle;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getStatusDescription() {
        return this.statusDescription;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.locationId);
        parcel.writeString(this.metroId);
        parcel.writeString(this.directionId);
        parcel.writeString(this.districtId);
        parcel.writeLong(this.time);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.seller, i);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.shopTitle);
        parcel.writeString(this.userType);
        parcel.writeStringList(this.services);
        parcel.writeString(this.address);
        parcel.writeParcelable(this.price, i);
        parcel.writeString(this.status);
        parcel.writeString(this.note);
        parcel.writeParcelable(this.deepLink, i);
        Boolean bool = this.expired;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.currentPrice);
        parcel.writeString(this.previousPrice);
        parcel.writeString(this.location);
        Delivery delivery2 = this.delivery;
        if (delivery2 != null) {
            parcel.writeInt(1);
            delivery2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.statusDescription);
    }
}
