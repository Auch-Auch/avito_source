package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 q2\u00020\u0001:\u0002qrBï\u0001\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010g\u001a\u00020\t\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010^\u001a\u00020]\u0012\b\b\u0002\u0010d\u001a\u00020]\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0004\bo\u0010pJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\"R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\"R\u0013\u0010=\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010\u000bR\"\u0010>\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\"R\u001e\u0010A\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010\u0018\u001a\u0004\bB\u0010\u001aR$\u0010C\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bD\u0010\u001a\"\u0004\bE\u0010\"R$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0018\u001a\u0004\bN\u0010\u001a\"\u0004\bO\u0010\"R$\u0010P\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0018\u001a\u0004\bQ\u0010\u001a\"\u0004\bR\u0010\"R\u001e\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001e\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020]8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\u001c\u0010g\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bg\u0010\u001c\u001a\u0004\bg\u0010\u000bR$\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006s"}, d2 = {"Lcom/avito/android/remote/model/Profile;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasLocation", "()Z", "hasMetro", "hasDistrict", "isIncomplete", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "userHashId", "Ljava/lang/String;", "getUserHashId", "()Ljava/lang/String;", "isPro", "Z", "setPro", "(Z)V", "name", "getName", "setName", "(Ljava/lang/String;)V", "socialId", "getSocialId", "setSocialId", "Lcom/avito/android/remote/model/UserType;", "type", "Lcom/avito/android/remote/model/UserType;", "getType", "()Lcom/avito/android/remote/model/UserType;", "setType", "(Lcom/avito/android/remote/model/UserType;)V", "", "Lcom/avito/android/remote/model/Action;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "setAvatar", "(Lcom/avito/android/remote/model/Image;)V", "locationId", "getLocationId", "setLocationId", "isShop", "status", "getStatus", "setStatus", "phone", "getPhone", "email", "getEmail", "setEmail", "Lcom/avito/android/remote/model/Social;", "social", "Lcom/avito/android/remote/model/Social;", "getSocial", "()Lcom/avito/android/remote/model/Social;", "setSocial", "(Lcom/avito/android/remote/model/Social;)V", "manager", "getManager", "setManager", ChannelContext.Item.USER_ID, "getUserId", "setUserId", "Lcom/avito/android/remote/model/SellerRating;", "rating", "Lcom/avito/android/remote/model/SellerRating;", "getRating", "()Lcom/avito/android/remote/model/SellerRating;", "Lcom/avito/android/remote/model/LinkedSocial;", "linkedSocial", "Lcom/avito/android/remote/model/LinkedSocial;", "getLinkedSocial", "()Lcom/avito/android/remote/model/LinkedSocial;", "", UrlParams.METRO_ID, "J", "getMetroId", "()J", "setMetroId", "(J)V", UrlParams.DISTRICT_ID, "getDistrictId", "setDistrictId", "isLegalPerson", "Lcom/avito/android/remote/model/Profile$Shop;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "Lcom/avito/android/remote/model/Profile$Shop;", "getShop", "()Lcom/avito/android/remote/model/Profile$Shop;", "setShop", "(Lcom/avito/android/remote/model/Profile$Shop;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Social;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/UserType;ZZLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lcom/avito/android/remote/model/Profile$Shop;Ljava/util/List;Lcom/avito/android/remote/model/SellerRating;Lcom/avito/android/remote/model/LinkedSocial;)V", "Companion", "Shop", "profile_release"}, k = 1, mv = {1, 4, 2})
public class Profile implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Profile> CREATOR = Parcels.creator(Profile$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("actions")
    @NotNull
    private final List<Action> actions;
    @SerializedName("avatar")
    @Nullable
    private Image avatar;
    @SerializedName(UrlParams.DISTRICT_ID)
    private long districtId;
    @SerializedName("email")
    @Nullable
    private String email;
    @SerializedName("isLegalPerson")
    private final boolean isLegalPerson;
    @SerializedName("isPRO")
    private boolean isPro;
    @SerializedName("linkedSocial")
    @Nullable
    private final LinkedSocial linkedSocial;
    @SerializedName("locationId")
    @Nullable
    private String locationId;
    @SerializedName("manager")
    @Nullable
    private String manager;
    @SerializedName(UrlParams.METRO_ID)
    private long metroId;
    @SerializedName("name")
    @Nullable
    private String name;
    @SerializedName("phone")
    @Nullable
    private final String phone;
    @SerializedName("rating")
    @Nullable
    private final SellerRating rating;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_SHOP)
    @Nullable
    private Shop shop;
    @SerializedName("social")
    @Nullable
    private Social social;
    @SerializedName("socialUserId")
    @Nullable
    private String socialId;
    @SerializedName("status")
    @NotNull
    private String status;
    @SerializedName("type")
    @NotNull
    private UserType type;
    @SerializedName("userHashId")
    @Nullable
    private final String userHashId;
    @SerializedName("id")
    @Nullable
    private String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Profile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Profile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b#\u0010$J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J2\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0016R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b!\u0010\u0013R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b\"\u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/Profile$Shop;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "id", "name", "site", "copy", "(JLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/Profile$Shop;", "toString", "Ljava/lang/String;", "getName", "J", "getId", "getSite", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Shop implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Shop> CREATOR = Parcels.creator(Profile$Shop$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("shopId")
        private final long id;
        @SerializedName("name")
        @Nullable
        private final String name;
        @SerializedName("url")
        @Nullable
        private final String site;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Profile$Shop$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Profile$Shop;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Shop() {
            this(0, null, null, 7, null);
        }

        public Shop(long j, @Nullable String str, @Nullable String str2) {
            this.id = j;
            this.name = str;
            this.site = str2;
        }

        public static /* synthetic */ Shop copy$default(Shop shop, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = shop.id;
            }
            if ((i & 2) != 0) {
                str = shop.name;
            }
            if ((i & 4) != 0) {
                str2 = shop.site;
            }
            return shop.copy(j, str, str2);
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.name;
        }

        @Nullable
        public final String component3() {
            return this.site;
        }

        @NotNull
        public final Shop copy(long j, @Nullable String str, @Nullable String str2) {
            return new Shop(j, str, str2);
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
            if (obj == null || !(obj instanceof Shop) || this.id != ((Shop) obj).id) {
                return false;
            }
            return true;
        }

        public final long getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getSite() {
            return this.site;
        }

        @Override // java.lang.Object
        public int hashCode() {
            long j = this.id;
            return (int) (j ^ (j >>> 32));
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Shop(id=");
            L.append(this.id);
            L.append(", name=");
            L.append(this.name);
            L.append(", site=");
            return a.t(L, this.site, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.site);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Shop(long j, String str, String str2, int i, j jVar) {
            this((i & 1) != 0 ? -1 : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }
    }

    public Profile() {
        this(null, null, null, null, null, null, null, null, null, false, false, null, null, 0, 0, null, null, null, null, null, 1048575, null);
    }

    public Profile(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Image image, @Nullable Social social2, @Nullable String str4, @NotNull String str5, @Nullable String str6, @NotNull UserType userType, boolean z, boolean z2, @Nullable String str7, @Nullable String str8, long j, long j2, @Nullable String str9, @Nullable Shop shop2, @NotNull List<Action> list, @Nullable SellerRating sellerRating, @Nullable LinkedSocial linkedSocial2) {
        Intrinsics.checkNotNullParameter(str5, "status");
        Intrinsics.checkNotNullParameter(userType, "type");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.userId = str;
        this.email = str2;
        this.name = str3;
        this.avatar = image;
        this.social = social2;
        this.socialId = str4;
        this.status = str5;
        this.phone = str6;
        this.type = userType;
        this.isPro = z;
        this.isLegalPerson = z2;
        this.manager = str7;
        this.locationId = str8;
        this.metroId = j;
        this.districtId = j2;
        this.userHashId = str9;
        this.shop = shop2;
        this.actions = list;
        this.rating = sellerRating;
        this.linkedSocial = linkedSocial2;
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
        return (obj instanceof Profile) && !(Intrinsics.areEqual(this.userId, ((Profile) obj).userId) ^ true);
    }

    @NotNull
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    public final long getDistrictId() {
        return this.districtId;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final LinkedSocial getLinkedSocial() {
        return this.linkedSocial;
    }

    @Nullable
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final String getManager() {
        return this.manager;
    }

    public final long getMetroId() {
        return this.metroId;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final SellerRating getRating() {
        return this.rating;
    }

    @Nullable
    public final Shop getShop() {
        return this.shop;
    }

    @Nullable
    public final Social getSocial() {
        return this.social;
    }

    @Nullable
    public final String getSocialId() {
        return this.socialId;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final UserType getType() {
        return this.type;
    }

    @Nullable
    public final String getUserHashId() {
        return this.userHashId;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public final boolean hasDistrict() {
        return this.districtId != -1;
    }

    public final boolean hasLocation() {
        String str = this.locationId;
        return !(str == null || str.length() == 0);
    }

    public final boolean hasMetro() {
        return this.metroId != -1;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.userId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isIncomplete() {
        Social social2 = this.social;
        return social2 != null && social2.isIncomplete();
    }

    public final boolean isLegalPerson() {
        return this.isLegalPerson;
    }

    public final boolean isPro() {
        return this.isPro;
    }

    public final boolean isShop() {
        return this.shop != null;
    }

    public final void setAvatar(@Nullable Image image) {
        this.avatar = image;
    }

    public final void setDistrictId(long j) {
        this.districtId = j;
    }

    public final void setEmail(@Nullable String str) {
        this.email = str;
    }

    public final void setLocationId(@Nullable String str) {
        this.locationId = str;
    }

    public final void setManager(@Nullable String str) {
        this.manager = str;
    }

    public final void setMetroId(long j) {
        this.metroId = j;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPro(boolean z) {
        this.isPro = z;
    }

    public final void setShop(@Nullable Shop shop2) {
        this.shop = shop2;
    }

    public final void setSocial(@Nullable Social social2) {
        this.social = social2;
    }

    public final void setSocialId(@Nullable String str) {
        this.socialId = str;
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setType(@NotNull UserType userType) {
        Intrinsics.checkNotNullParameter(userType, "<set-?>");
        this.type = userType;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.userId);
        parcel.writeString(this.email);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.social, i);
        parcel.writeString(this.socialId);
        parcel.writeString(this.status);
        parcel.writeString(this.phone);
        parcel.writeParcelable(this.type, i);
        ParcelsKt.writeBool(parcel, this.isPro);
        ParcelsKt.writeBool(parcel, this.isLegalPerson);
        parcel.writeString(this.manager);
        parcel.writeString(this.locationId);
        parcel.writeLong(this.metroId);
        parcel.writeLong(this.districtId);
        parcel.writeString(this.userHashId);
        parcel.writeParcelable(this.shop, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.actions, 0, 2, null);
        parcel.writeParcelable(this.rating, i);
        parcel.writeParcelable(this.linkedSocial, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Profile(String str, String str2, String str3, Image image, Social social2, String str4, String str5, String str6, UserType userType, boolean z, boolean z2, String str7, String str8, long j, long j2, String str9, Shop shop2, List list, SellerRating sellerRating, LinkedSocial linkedSocial2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : image, (i & 16) != 0 ? null : social2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? "active" : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? new UserType(UserTypeCode.PRIVATE, null, 2, null) : userType, (i & 512) != 0 ? false : z, (i & 1024) == 0 ? z2 : false, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? -1 : j, (i & 16384) == 0 ? j2 : -1, (32768 & i) != 0 ? null : str9, (i & 65536) != 0 ? null : shop2, (i & 131072) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 262144) != 0 ? null : sellerRating, (i & 524288) == 0 ? linkedSocial2 : null);
    }
}
