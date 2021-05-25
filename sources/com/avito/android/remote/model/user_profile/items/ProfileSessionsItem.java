package com.avito.android.remote.model.user_profile.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/ProfileSessionsItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileSessionsItem extends UserProfileItem {
    public static final Parcelable.Creator<ProfileSessionsItem> CREATOR = new Creator();
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink deeplink;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProfileSessionsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileSessionsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ProfileSessionsItem(parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(ProfileSessionsItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileSessionsItem[] newArray(int i) {
            return new ProfileSessionsItem[i];
        }
    }

    public ProfileSessionsItem(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        a.W0(str, "title", str2, MessengerShareContentUtility.SUBTITLE, deepLink, "deeplink");
        this.title = str;
        this.subtitle = str2;
        this.deeplink = deepLink;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.deeplink, i);
    }
}
