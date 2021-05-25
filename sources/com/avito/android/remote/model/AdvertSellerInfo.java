package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/AdvertSellerInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SellerVerification;", "verification", "Lcom/avito/android/remote/model/SellerVerification;", "getVerification", "()Lcom/avito/android/remote/model/SellerVerification;", "sellerTypeName", "getSellerTypeName", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/SellerRating;", "rating", "Lcom/avito/android/remote/model/SellerRating;", "getRating", "()Lcom/avito/android/remote/model/SellerRating;", Sort.DATE, "getDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerVerification;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/SellerRating;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerInfo implements Parcelable {
    public static final Parcelable.Creator<AdvertSellerInfo> CREATOR = new Creator();
    @SerializedName(Sort.DATE)
    @Nullable
    private final String date;
    @SerializedName("logo")
    @Nullable
    private final Image image;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    @SerializedName("link")
    @Nullable
    private final DeepLink link;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("rating")
    @Nullable
    private final SellerRating rating;
    @SerializedName("sellerTypeName")
    @Nullable
    private final String sellerTypeName;
    @SerializedName("verification")
    @Nullable
    private final SellerVerification verification;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertSellerInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertSellerInfo createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            SellerVerification createFromParcel = parcel.readInt() != 0 ? SellerVerification.CREATOR.createFromParcel(parcel) : null;
            Image image = (Image) parcel.readParcelable(AdvertSellerInfo.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AdvertSellerInfo(readString, readString2, createFromParcel, image, bool, (DeepLink) parcel.readParcelable(AdvertSellerInfo.class.getClassLoader()), (SellerRating) parcel.readParcelable(AdvertSellerInfo.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertSellerInfo[] newArray(int i) {
            return new AdvertSellerInfo[i];
        }
    }

    public AdvertSellerInfo(@NotNull String str, @Nullable String str2, @Nullable SellerVerification sellerVerification, @Nullable Image image2, @Nullable Boolean bool, @Nullable DeepLink deepLink, @Nullable SellerRating sellerRating, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.sellerTypeName = str2;
        this.verification = sellerVerification;
        this.image = image2;
        this.isShop = bool;
        this.link = deepLink;
        this.rating = sellerRating;
        this.date = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final DeepLink getLink() {
        return this.link;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final SellerRating getRating() {
        return this.rating;
    }

    @Nullable
    public final String getSellerTypeName() {
        return this.sellerTypeName;
    }

    @Nullable
    public final SellerVerification getVerification() {
        return this.verification;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.sellerTypeName);
        SellerVerification sellerVerification = this.verification;
        if (sellerVerification != null) {
            parcel.writeInt(1);
            sellerVerification.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.image, i);
        Boolean bool = this.isShop;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.link, i);
        parcel.writeParcelable(this.rating, i);
        parcel.writeString(this.date);
    }
}
