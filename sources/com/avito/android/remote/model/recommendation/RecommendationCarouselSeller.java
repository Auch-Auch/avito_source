package com.avito.android.remote.model.recommendation;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u001e\u0010 \u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R$\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/recommendation/RecommendationCarouselSeller;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "userKey", "getUserKey", "description", "getDescription", "", "Lcom/avito/android/remote/model/recommendation/AdvertWithOverlay;", "adverts", "Ljava/util/List;", "getAdverts", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendationCarouselSeller implements Parcelable {
    public static final Parcelable.Creator<RecommendationCarouselSeller> CREATOR = new Creator();
    @SerializedName("items")
    @Nullable
    private final List<AdvertWithOverlay> adverts;
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("hashUserId")
    @NotNull
    private final String userKey;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RecommendationCarouselSeller> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationCarouselSeller createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList arrayList = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            Image image = (Image) parcel.readParcelable(RecommendationCarouselSeller.class.getClassLoader());
            DeepLink deepLink = (DeepLink) parcel.readParcelable(RecommendationCarouselSeller.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(AdvertWithOverlay.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new RecommendationCarouselSeller(readString, readString2, readString3, bool, image, deepLink, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationCarouselSeller[] newArray(int i) {
            return new RecommendationCarouselSeller[i];
        }
    }

    public RecommendationCarouselSeller(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Image image, @Nullable DeepLink deepLink2, @Nullable List<AdvertWithOverlay> list) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.userKey = str;
        this.name = str2;
        this.description = str3;
        this.isShop = bool;
        this.avatar = image;
        this.deepLink = deepLink2;
        this.adverts = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<AdvertWithOverlay> getAdverts() {
        return this.adverts;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUserKey() {
        return this.userKey;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.userKey);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        Boolean bool = this.isShop;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.deepLink, i);
        List<AdvertWithOverlay> list = this.adverts;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((AdvertWithOverlay) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
