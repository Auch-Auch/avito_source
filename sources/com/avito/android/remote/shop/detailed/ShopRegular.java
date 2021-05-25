package com.avito.android.remote.shop.detailed;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ActionNullable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.SellerVerification;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010*\u001a\u00020\u000b\u0012\b\u00106\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010A\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010%\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010=\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R*\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000fR\u001e\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u00102\u001a\u0004\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b7\u0010\u000fR\u001e\u00109\u001a\u0004\u0018\u0001088\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u0010\r\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010@R$\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010A8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopRegular;", "Lcom/avito/android/remote/shop/detailed/ShopElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "site", "Lcom/avito/android/remote/model/Action;", "getSite", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "setSubscribeInfo", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "name", "getName", "categoryName", "getCategoryName", "Lcom/avito/android/remote/model/SellerVerification;", "sellerVerification", "Lcom/avito/android/remote/model/SellerVerification;", "getSellerVerification", "()Lcom/avito/android/remote/model/SellerVerification;", "", "analytics", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "userKey", "getUserKey", "Lcom/avito/android/remote/model/ActionNullable;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/ActionNullable;", "getAddress", "()Lcom/avito/android/remote/model/ActionNullable;", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "description", "getDescription", "Lcom/avito/android/remote/model/Image;", "logo", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "profProfileType", "getProfProfileType", "setProfProfileType", "(Ljava/lang/String;)V", "", "phones", "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerVerification;Lcom/avito/android/remote/model/ActionNullable;Ljava/util/List;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/ProfileRating;Ljava/util/Map;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Ljava/lang/String;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRegular implements ShopElement {
    public static final Parcelable.Creator<ShopRegular> CREATOR = new Creator();
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final ActionNullable address;
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName("categoryName")
    @Nullable
    private final String categoryName;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("logo")
    @Nullable
    private final Image logo;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("phones")
    @Nullable
    private final List<Action> phones;
    @SerializedName("profProfileType")
    @Nullable
    private String profProfileType;
    @SerializedName("rating")
    @Nullable
    private final ProfileRating rating;
    @SerializedName("verification")
    @Nullable
    private final SellerVerification sellerVerification;
    @SerializedName("site")
    @Nullable
    private final Action site;
    @SerializedName("subscribeInfo")
    @Nullable
    private SubscribeInfo subscribeInfo;
    @SerializedName("hashUserId")
    @NotNull
    private final String userKey;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopRegular> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopRegular createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            SellerVerification sellerVerification = (SellerVerification) parcel.readParcelable(ShopRegular.class.getClassLoader());
            ActionNullable actionNullable = (ActionNullable) parcel.readParcelable(ShopRegular.class.getClassLoader());
            LinkedHashMap linkedHashMap = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Action) parcel.readParcelable(ShopRegular.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            Action action = (Action) parcel.readParcelable(ShopRegular.class.getClassLoader());
            Image image = (Image) parcel.readParcelable(ShopRegular.class.getClassLoader());
            String readString5 = parcel.readString();
            ProfileRating profileRating = (ProfileRating) parcel.readParcelable(ShopRegular.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                    profileRating = profileRating;
                }
            }
            return new ShopRegular(readString, readString2, readString3, readString4, sellerVerification, actionNullable, arrayList, action, image, readString5, profileRating, linkedHashMap, (SubscribeInfo) parcel.readParcelable(ShopRegular.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopRegular[] newArray(int i) {
            return new ShopRegular[i];
        }
    }

    public ShopRegular(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable SellerVerification sellerVerification2, @Nullable ActionNullable actionNullable, @Nullable List<Action> list, @Nullable Action action, @Nullable Image image, @Nullable String str5, @Nullable ProfileRating profileRating, @Nullable Map<String, String> map, @Nullable SubscribeInfo subscribeInfo2, @Nullable String str6) {
        a.Z0(str, "id", str2, "name", str3, "userKey");
        this.id = str;
        this.name = str2;
        this.userKey = str3;
        this.description = str4;
        this.sellerVerification = sellerVerification2;
        this.address = actionNullable;
        this.phones = list;
        this.site = action;
        this.logo = image;
        this.categoryName = str5;
        this.rating = profileRating;
        this.analytics = map;
        this.subscribeInfo = subscribeInfo2;
        this.profProfileType = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ActionNullable getAddress() {
        return this.address;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Image getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Action> getPhones() {
        return this.phones;
    }

    @Nullable
    public final String getProfProfileType() {
        return this.profProfileType;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.rating;
    }

    @Nullable
    public final SellerVerification getSellerVerification() {
        return this.sellerVerification;
    }

    @Nullable
    public final Action getSite() {
        return this.site;
    }

    @Nullable
    public final SubscribeInfo getSubscribeInfo() {
        return this.subscribeInfo;
    }

    @NotNull
    public final String getUserKey() {
        return this.userKey;
    }

    public final void setProfProfileType(@Nullable String str) {
        this.profProfileType = str;
    }

    public final void setSubscribeInfo(@Nullable SubscribeInfo subscribeInfo2) {
        this.subscribeInfo = subscribeInfo2;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r4.id
            r5.writeString(r0)
            java.lang.String r0 = r4.name
            r5.writeString(r0)
            java.lang.String r0 = r4.userKey
            r5.writeString(r0)
            java.lang.String r0 = r4.description
            r5.writeString(r0)
            com.avito.android.remote.model.SellerVerification r0 = r4.sellerVerification
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.ActionNullable r0 = r4.address
            r5.writeParcelable(r0, r6)
            java.util.List<com.avito.android.remote.model.Action> r0 = r4.phones
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003d
            java.util.Iterator r0 = a2.b.a.a.a.l0(r5, r1, r0)
        L_0x002d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0040
            java.lang.Object r3 = r0.next()
            com.avito.android.remote.model.Action r3 = (com.avito.android.remote.model.Action) r3
            r5.writeParcelable(r3, r6)
            goto L_0x002d
        L_0x003d:
            r5.writeInt(r2)
        L_0x0040:
            com.avito.android.remote.model.Action r0 = r4.site
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.Image r0 = r4.logo
            r5.writeParcelable(r0, r6)
            java.lang.String r0 = r4.categoryName
            r5.writeString(r0)
            com.avito.android.remote.model.ProfileRating r0 = r4.rating
            r5.writeParcelable(r0, r6)
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.analytics
            if (r0 == 0) goto L_0x0079
            java.util.Iterator r0 = a2.b.a.a.a.m0(r5, r1, r0)
        L_0x005c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007c
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r5.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r5.writeString(r1)
            goto L_0x005c
        L_0x0079:
            r5.writeInt(r2)
        L_0x007c:
            com.avito.android.public_profile.remote.model.SubscribeInfo r0 = r4.subscribeInfo
            r5.writeParcelable(r0, r6)
            java.lang.String r6 = r4.profProfileType
            r5.writeString(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.shop.detailed.ShopRegular.writeToParcel(android.os.Parcel, int):void");
    }
}
