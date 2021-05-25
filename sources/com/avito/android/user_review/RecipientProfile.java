package com.avito.android.user_review;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a¨\u0006*"}, d2 = {"Lcom/avito/android/user_review/RecipientProfile;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "", AuthSource.BOOKING_ORDER, "Z", "isShop", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "f", "getReplyDate", "replyDate", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "e", "getReply", "reply", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class RecipientProfile implements Parcelable {
    public static final Parcelable.Creator<RecipientProfile> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    @Nullable
    public final Image c;
    @Nullable
    public final DeepLink d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RecipientProfile> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecipientProfile createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RecipientProfile(parcel.readString(), parcel.readInt() != 0, (Image) parcel.readParcelable(RecipientProfile.class.getClassLoader()), (DeepLink) parcel.readParcelable(RecipientProfile.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecipientProfile[] newArray(int i) {
            return new RecipientProfile[i];
        }
    }

    public RecipientProfile(@NotNull String str, boolean z, @Nullable Image image, @Nullable DeepLink deepLink, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
        this.b = z;
        this.c = image;
        this.d = deepLink;
        this.e = str2;
        this.f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getAvatar() {
        return this.c;
    }

    @Nullable
    public final DeepLink getLink() {
        return this.d;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @Nullable
    public final String getReply() {
        return this.e;
    }

    @Nullable
    public final String getReplyDate() {
        return this.f;
    }

    public final boolean isShop() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
