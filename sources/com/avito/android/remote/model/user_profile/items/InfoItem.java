package com.avito.android.remote.model.user_profile.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Address;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.user_profile.Support;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.common.SNSConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00014Bu\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b2\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001c\u0010\u001e\u001a\u00020\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001c\u0010!\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001e\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001e\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/InfoItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "shopSite", "getShopSite", "name", "getName", "email", "getEmail", "Lcom/avito/android/remote/model/user_profile/Support;", SNSConstants.LinkType.SUPPORT, "Lcom/avito/android/remote/model/user_profile/Support;", "getSupport", "()Lcom/avito/android/remote/model/user_profile/Support;", "id", "getId", "manager", "getManager", "", "isIncomplete", "Z", "()Z", "registered", "getRegistered", "Lcom/avito/android/remote/model/Avatar;", "avatar", "Lcom/avito/android/remote/model/Avatar;", "getAvatar", "()Lcom/avito/android/remote/model/Avatar;", "Lcom/avito/android/remote/model/Address;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Address;", "getAddress", "()Lcom/avito/android/remote/model/Address;", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Avatar;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Address;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/Support;Ljava/lang/String;Lcom/avito/android/remote/model/ProfileRating;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItem extends UserProfileItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<InfoItem> CREATOR = Parcels.creator(InfoItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final Address address;
    @SerializedName("avatar")
    @Nullable
    private final Avatar avatar;
    @SerializedName("email")
    @Nullable
    private final String email;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("isIncomplete")
    private final boolean isIncomplete;
    @SerializedName("manager")
    @Nullable
    private final String manager;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("rating")
    @Nullable
    private final ProfileRating rating;
    @SerializedName("registered")
    @NotNull
    private final String registered;
    @SerializedName("shopSite")
    @Nullable
    private final String shopSite;
    @SerializedName(SNSConstants.LinkType.SUPPORT)
    @Nullable
    private final Support support;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/InfoItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/items/InfoItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public InfoItem(@NotNull String str, @Nullable Avatar avatar2, @NotNull String str2, @Nullable String str3, @Nullable Address address2, @NotNull String str4, boolean z, @NotNull String str5, @Nullable String str6, @Nullable Support support2, @Nullable String str7, @Nullable ProfileRating profileRating) {
        a.b1(str, "id", str2, "name", str4, "registered", str5, "type");
        this.id = str;
        this.avatar = avatar2;
        this.name = str2;
        this.email = str3;
        this.address = address2;
        this.registered = str4;
        this.isIncomplete = z;
        this.type = str5;
        this.manager = str6;
        this.support = support2;
        this.shopSite = str7;
        this.rating = profileRating;
    }

    @Nullable
    public final Address getAddress() {
        return this.address;
    }

    @Nullable
    public final Avatar getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getManager() {
        return this.manager;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.rating;
    }

    @NotNull
    public final String getRegistered() {
        return this.registered;
    }

    @Nullable
    public final String getShopSite() {
        return this.shopSite;
    }

    @Nullable
    public final Support getSupport() {
        return this.support;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean isIncomplete() {
        return this.isIncomplete;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        parcel.writeParcelable(this.address, i);
        parcel.writeString(this.registered);
        ParcelsKt.writeBool(parcel, this.isIncomplete);
        parcel.writeString(this.type);
        parcel.writeString(this.manager);
        parcel.writeParcelable(this.support, i);
        parcel.writeString(this.shopSite);
        parcel.writeParcelable(this.rating, i);
    }
}
