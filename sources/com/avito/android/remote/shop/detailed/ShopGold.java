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
import com.avito.android.remote.model.SerpElement;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001QB½\u0001\u0012\u0006\u0010-\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u00020\u0012\u0012\u0006\u0010F\u001a\u00020\u0012\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010H\u001a\u0004\u0018\u00010\f\u0012\b\u0010=\u001a\u0004\u0018\u00010/\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00109\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%R\u001e\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001e\u00105\u001a\u0004\u0018\u0001048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001e\u00109\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010#\u001a\u0004\b:\u0010%R\u001c\u0010;\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b;\u0010#\u001a\u0004\b<\u0010%R\u001e\u0010=\u001a\u0004\u0018\u00010/8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u00101\u001a\u0004\b>\u00103R\u001e\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001e\u0010D\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bD\u0010#\u001a\u0004\bE\u0010%R\u001c\u0010F\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bF\u0010#\u001a\u0004\bG\u0010%R\u001e\u0010H\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bH\u0010\u0018\u001a\u0004\bI\u0010\u001aR\u001e\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopGold;", "Lcom/avito/android/remote/shop/detailed/ShopElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/Action;", "phones", "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "", "", "analytics", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "description", "Lcom/avito/android/remote/model/Action;", "getDescription", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "setSubscribeInfo", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "profProfileType", "Ljava/lang/String;", "getProfProfileType", "()Ljava/lang/String;", "setProfProfileType", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/shop/detailed/ShopGold$Showcase;", "showcase", "Lcom/avito/android/remote/shop/detailed/ShopGold$Showcase;", "getShowcase", "()Lcom/avito/android/remote/shop/detailed/ShopGold$Showcase;", "id", "getId", "Lcom/avito/android/remote/model/Image;", "background", "Lcom/avito/android/remote/model/Image;", "getBackground", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/ActionNullable;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/ActionNullable;", "getAddress", "()Lcom/avito/android/remote/model/ActionNullable;", "categoryName", "getCategoryName", "name", "getName", "logo", "getLogo", "Lcom/avito/android/remote/model/SellerVerification;", "sellerVerification", "Lcom/avito/android/remote/model/SellerVerification;", "getSellerVerification", "()Lcom/avito/android/remote/model/SellerVerification;", "creationDate", "getCreationDate", "userKey", "getUserKey", "site", "getSite", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/shop/detailed/ShopGold$Showcase;Lcom/avito/android/remote/model/SellerVerification;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/ActionNullable;Ljava/util/List;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/ProfileRating;Ljava/util/Map;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Ljava/lang/String;)V", "Showcase", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGold implements ShopElement {
    public static final Parcelable.Creator<ShopGold> CREATOR = new Creator();
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final ActionNullable address;
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName("brandingImage")
    @Nullable
    private final Image background;
    @SerializedName("categoryName")
    @Nullable
    private final String categoryName;
    @SerializedName("creationDate")
    @Nullable
    private final String creationDate;
    @SerializedName("description")
    @Nullable
    private final Action description;
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
    @SerializedName("showcase")
    @Nullable
    private final Showcase showcase;
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
    public static class Creator implements Parcelable.Creator<ShopGold> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopGold createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Showcase createFromParcel = parcel.readInt() != 0 ? Showcase.CREATOR.createFromParcel(parcel) : null;
            SellerVerification sellerVerification = (SellerVerification) parcel.readParcelable(ShopGold.class.getClassLoader());
            String readString4 = parcel.readString();
            Action action = (Action) parcel.readParcelable(ShopGold.class.getClassLoader());
            ActionNullable actionNullable = (ActionNullable) parcel.readParcelable(ShopGold.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Action) parcel.readParcelable(ShopGold.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            Action action2 = (Action) parcel.readParcelable(ShopGold.class.getClassLoader());
            Image image = (Image) parcel.readParcelable(ShopGold.class.getClassLoader());
            Image image2 = (Image) parcel.readParcelable(ShopGold.class.getClassLoader());
            String readString5 = parcel.readString();
            ProfileRating profileRating = (ProfileRating) parcel.readParcelable(ShopGold.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                    image2 = image2;
                    image = image;
                }
            }
            return new ShopGold(readString, readString2, readString3, createFromParcel, sellerVerification, readString4, action, actionNullable, arrayList, action2, image, image2, readString5, profileRating, linkedHashMap, (SubscribeInfo) parcel.readParcelable(ShopGold.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopGold[] newArray(int i) {
            return new ShopGold[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopGold$Showcase;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Showcase implements Parcelable {
        public static final Parcelable.Creator<Showcase> CREATOR = new Creator();
        @SerializedName("list")
        @NotNull
        private final List<SerpElement> elements;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Showcase> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Showcase createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SerpElement) parcel.readParcelable(Showcase.class.getClassLoader()));
                    readInt--;
                }
                return new Showcase(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Showcase[] newArray(int i) {
                return new Showcase[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
        /* JADX WARN: Multi-variable type inference failed */
        public Showcase(@Nullable String str, @NotNull List<? extends SerpElement> list) {
            Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
            this.title = str;
            this.elements = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<SerpElement> getElements() {
            return this.elements;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.elements, parcel);
            while (n0.hasNext()) {
                parcel.writeParcelable((SerpElement) n0.next(), i);
            }
        }
    }

    public ShopGold(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Showcase showcase2, @Nullable SellerVerification sellerVerification2, @Nullable String str4, @Nullable Action action, @Nullable ActionNullable actionNullable, @Nullable List<Action> list, @Nullable Action action2, @Nullable Image image, @Nullable Image image2, @Nullable String str5, @Nullable ProfileRating profileRating, @Nullable Map<String, String> map, @Nullable SubscribeInfo subscribeInfo2, @Nullable String str6) {
        a.Z0(str, "id", str2, "name", str3, "userKey");
        this.id = str;
        this.name = str2;
        this.userKey = str3;
        this.showcase = showcase2;
        this.sellerVerification = sellerVerification2;
        this.creationDate = str4;
        this.description = action;
        this.address = actionNullable;
        this.phones = list;
        this.site = action2;
        this.logo = image;
        this.background = image2;
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
    public final Image getBackground() {
        return this.background;
    }

    @Nullable
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    public final String getCreationDate() {
        return this.creationDate;
    }

    @Nullable
    public final Action getDescription() {
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
    public final Showcase getShowcase() {
        return this.showcase;
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
            com.avito.android.remote.shop.detailed.ShopGold$Showcase r0 = r4.showcase
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0021
            r5.writeInt(r1)
            r0.writeToParcel(r5, r2)
            goto L_0x0024
        L_0x0021:
            r5.writeInt(r2)
        L_0x0024:
            com.avito.android.remote.model.SellerVerification r0 = r4.sellerVerification
            r5.writeParcelable(r0, r6)
            java.lang.String r0 = r4.creationDate
            r5.writeString(r0)
            com.avito.android.remote.model.Action r0 = r4.description
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.ActionNullable r0 = r4.address
            r5.writeParcelable(r0, r6)
            java.util.List<com.avito.android.remote.model.Action> r0 = r4.phones
            if (r0 == 0) goto L_0x0050
            java.util.Iterator r0 = a2.b.a.a.a.l0(r5, r1, r0)
        L_0x0040:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0053
            java.lang.Object r3 = r0.next()
            com.avito.android.remote.model.Action r3 = (com.avito.android.remote.model.Action) r3
            r5.writeParcelable(r3, r6)
            goto L_0x0040
        L_0x0050:
            r5.writeInt(r2)
        L_0x0053:
            com.avito.android.remote.model.Action r0 = r4.site
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.Image r0 = r4.logo
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.Image r0 = r4.background
            r5.writeParcelable(r0, r6)
            java.lang.String r0 = r4.categoryName
            r5.writeString(r0)
            com.avito.android.remote.model.ProfileRating r0 = r4.rating
            r5.writeParcelable(r0, r6)
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.analytics
            if (r0 == 0) goto L_0x0091
            java.util.Iterator r0 = a2.b.a.a.a.m0(r5, r1, r0)
        L_0x0074:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r5.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r5.writeString(r1)
            goto L_0x0074
        L_0x0091:
            r5.writeInt(r2)
        L_0x0094:
            com.avito.android.public_profile.remote.model.SubscribeInfo r0 = r4.subscribeInfo
            r5.writeParcelable(r0, r6)
            java.lang.String r6 = r4.profProfileType
            r5.writeString(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.shop.detailed.ShopGold.writeToParcel(android.os.Parcel, int):void");
    }
}
