package com.avito.android.public_profile.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.SellerReplySpeed;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010-\u001a\u00020&\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u001c\u0010-\u001a\u00020&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*¨\u00061"}, d2 = {"Lcom/avito/android/public_profile/remote/model/UserProfile;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "Lcom/avito/android/remote/model/SellerReplySpeed;", "replySpeed", "Lcom/avito/android/remote/model/SellerReplySpeed;", "getReplySpeed", "()Lcom/avito/android/remote/model/SellerReplySpeed;", "Lcom/avito/android/remote/model/AdvertActions;", "contacts", "Lcom/avito/android/remote/model/AdvertActions;", "getContacts", "()Lcom/avito/android/remote/model/AdvertActions;", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "()Lcom/avito/android/remote/model/ProfileRating;", "setRating", "(Lcom/avito/android/remote/model/ProfileRating;)V", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "hashUserId", "getHashUserId", "name", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/SellerReplySpeed;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfile implements Parcelable {
    public static final Parcelable.Creator<UserProfile> CREATOR = new Creator();
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("contacts")
    @Nullable
    private final AdvertActions contacts;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("hashUserId")
    @Nullable
    private final String hashUserId;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("rating")
    @Nullable
    private ProfileRating rating;
    @SerializedName(ChannelContext.Item.REPLY_TIME)
    @Nullable
    private final SellerReplySpeed replySpeed;
    @SerializedName("subscribeInfo")
    @Nullable
    private final SubscribeInfo subscribeInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserProfile> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfile createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UserProfile(parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(UserProfile.class.getClassLoader()), (ProfileRating) parcel.readParcelable(UserProfile.class.getClassLoader()), (SubscribeInfo) parcel.readParcelable(UserProfile.class.getClassLoader()), (AdvertActions) parcel.readParcelable(UserProfile.class.getClassLoader()), (SellerReplySpeed) parcel.readParcelable(UserProfile.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserProfile[] newArray(int i) {
            return new UserProfile[i];
        }
    }

    public UserProfile(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Image image, @Nullable ProfileRating profileRating, @Nullable SubscribeInfo subscribeInfo2, @Nullable AdvertActions advertActions, @Nullable SellerReplySpeed sellerReplySpeed) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.description = str2;
        this.hashUserId = str3;
        this.avatar = image;
        this.rating = profileRating;
        this.subscribeInfo = subscribeInfo2;
        this.contacts = advertActions;
        this.replySpeed = sellerReplySpeed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final AdvertActions getContacts() {
        return this.contacts;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getHashUserId() {
        return this.hashUserId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.rating;
    }

    @Nullable
    public final SellerReplySpeed getReplySpeed() {
        return this.replySpeed;
    }

    @Nullable
    public final SubscribeInfo getSubscribeInfo() {
        return this.subscribeInfo;
    }

    public final void setRating(@Nullable ProfileRating profileRating) {
        this.rating = profileRating;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.hashUserId);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.rating, i);
        parcel.writeParcelable(this.subscribeInfo, i);
        parcel.writeParcelable(this.contacts, i);
        parcel.writeParcelable(this.replySpeed, i);
    }
}
