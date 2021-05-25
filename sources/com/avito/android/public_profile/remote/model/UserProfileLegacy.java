package com.avito.android.public_profile.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Address;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.SellerConnection;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\b\u0010;\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00104\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00107\u001a\u000206\u0012\b\u0010=\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\u00020/8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000fR\u001c\u00107\u001a\u0002068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001e\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b;\u0010\r\u001a\u0004\b<\u0010\u000fR\u001e\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u0010\r\u001a\u0004\b>\u0010\u000f¨\u0006A"}, d2 = {"Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "activeItemsCount", "Ljava/lang/String;", "getActiveItemsCount", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Address;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Address;", "getAddress", "()Lcom/avito/android/remote/model/Address;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "name", "getName", ErrorBundle.SUMMARY_ENTRY, "getSummary", "setSummary", "(Ljava/lang/String;)V", "userType", "getUserType", "setUserType", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "setRating", "(Lcom/avito/android/remote/model/ProfileRating;)V", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "", "lastVisit", "J", "getLastVisit", "()J", "registered", "getRegistered", "Lcom/avito/android/remote/model/SellerConnection;", "connection", "Lcom/avito/android/remote/model/SellerConnection;", "getConnection", "()Lcom/avito/android/remote/model/SellerConnection;", "avatarStatus", "getAvatarStatus", "confirmedInformation", "getConfirmedInformation", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Address;Lcom/avito/android/remote/model/Image;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerConnection;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Lcom/avito/android/remote/model/ProfileRating;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileLegacy implements Parcelable {
    public static final Parcelable.Creator<UserProfileLegacy> CREATOR = new Creator();
    @SerializedName("activeItemsCount")
    @Nullable
    private final String activeItemsCount;
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @NotNull
    private final Address address;
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("avatarStatus")
    @Nullable
    private final String avatarStatus;
    @SerializedName("confirmedInformation")
    @Nullable
    private final String confirmedInformation;
    @SerializedName("connection")
    @NotNull
    private final SellerConnection connection;
    @SerializedName("lastVisit")
    private final long lastVisit;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("rating")
    @Nullable
    private ProfileRating rating;
    @SerializedName("registered")
    @NotNull
    private final String registered;
    @SerializedName("subscribeInfo")
    @Nullable
    private final SubscribeInfo subscribeInfo;
    @SerializedName(ErrorBundle.SUMMARY_ENTRY)
    @Nullable
    private String summary;
    @SerializedName("userType")
    @NotNull
    private String userType;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserProfileLegacy> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfileLegacy createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UserProfileLegacy(parcel.readString(), (Address) parcel.readParcelable(UserProfileLegacy.class.getClassLoader()), (Image) parcel.readParcelable(UserProfileLegacy.class.getClassLoader()), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), (SellerConnection) parcel.readParcelable(UserProfileLegacy.class.getClassLoader()), parcel.readString(), parcel.readString(), (SubscribeInfo) parcel.readParcelable(UserProfileLegacy.class.getClassLoader()), (ProfileRating) parcel.readParcelable(UserProfileLegacy.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfileLegacy[] newArray(int i) {
            return new UserProfileLegacy[i];
        }
    }

    public UserProfileLegacy(@NotNull String str, @NotNull Address address2, @Nullable Image image, @Nullable String str2, long j, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull SellerConnection sellerConnection, @Nullable String str6, @NotNull String str7, @Nullable SubscribeInfo subscribeInfo2, @Nullable ProfileRating profileRating) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(address2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(str3, "registered");
        Intrinsics.checkNotNullParameter(sellerConnection, "connection");
        Intrinsics.checkNotNullParameter(str7, "userType");
        this.name = str;
        this.address = address2;
        this.avatar = image;
        this.avatarStatus = str2;
        this.lastVisit = j;
        this.registered = str3;
        this.activeItemsCount = str4;
        this.summary = str5;
        this.connection = sellerConnection;
        this.confirmedInformation = str6;
        this.userType = str7;
        this.subscribeInfo = subscribeInfo2;
        this.rating = profileRating;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getActiveItemsCount() {
        return this.activeItemsCount;
    }

    @NotNull
    public final Address getAddress() {
        return this.address;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarStatus() {
        return this.avatarStatus;
    }

    @Nullable
    public final String getConfirmedInformation() {
        return this.confirmedInformation;
    }

    @NotNull
    public final SellerConnection getConnection() {
        return this.connection;
    }

    public final long getLastVisit() {
        return this.lastVisit;
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
    public final SubscribeInfo getSubscribeInfo() {
        return this.subscribeInfo;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    public final void setRating(@Nullable ProfileRating profileRating) {
        this.rating = profileRating;
    }

    public final void setSummary(@Nullable String str) {
        this.summary = str;
    }

    public final void setUserType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeParcelable(this.address, i);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.avatarStatus);
        parcel.writeLong(this.lastVisit);
        parcel.writeString(this.registered);
        parcel.writeString(this.activeItemsCount);
        parcel.writeString(this.summary);
        parcel.writeParcelable(this.connection, i);
        parcel.writeString(this.confirmedInformation);
        parcel.writeString(this.userType);
        parcel.writeParcelable(this.subscribeInfo, i);
        parcel.writeParcelable(this.rating, i);
    }
}
