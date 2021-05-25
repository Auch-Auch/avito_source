package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/VerificationBanner;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/user_profile/items/VerificationBannerType;", "bannerType", "Lcom/avito/android/remote/model/user_profile/items/VerificationBannerType;", "getBannerType", "()Lcom/avito/android/remote/model/user_profile/items/VerificationBannerType;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "detailsText", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsText", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/user_profile/items/VerificationBannerType;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationBanner implements Parcelable {
    public static final Parcelable.Creator<VerificationBanner> CREATOR = new Creator();
    @SerializedName("bannerType")
    @NotNull
    private final VerificationBannerType bannerType;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("detailsText")
    @Nullable
    private final AttributedText detailsText;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VerificationBanner(parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(VerificationBanner.class.getClassLoader()), (VerificationBannerType) Enum.valueOf(VerificationBannerType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationBanner[] newArray(int i) {
            return new VerificationBanner[i];
        }
    }

    public VerificationBanner(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText, @NotNull VerificationBannerType verificationBannerType) {
        Intrinsics.checkNotNullParameter(verificationBannerType, "bannerType");
        this.title = str;
        this.description = str2;
        this.detailsText = attributedText;
        this.bannerType = verificationBannerType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final VerificationBannerType getBannerType() {
        return this.bannerType;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final AttributedText getDetailsText() {
        return this.detailsText;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.detailsText, i);
        parcel.writeString(this.bannerType.name());
    }
}
