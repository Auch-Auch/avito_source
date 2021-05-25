package com.avito.android.remote.model.recommended_sellers;

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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\b\b\u0002\u0010+\u001a\u00020\u001a\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u001c\u0010 \u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R$\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010$R$\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/avito/android/remote/model/recommended_sellers/RecommendedSeller;", "Lcom/avito/android/remote/model/recommended_sellers/RecommendedSellerElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "description", "getDescription", "userKey", "getUserKey", "isNotificationsActivated", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "", "Lcom/avito/android/remote/model/recommended_sellers/AdvertImageWithOverlay;", "images", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "isSubscribed", "Z", "()Z", "setSubscribed", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;ZLjava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RecommendedSeller implements RecommendedSellerElement {
    public static final Parcelable.Creator<RecommendedSeller> CREATOR = new Creator();
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("images")
    @Nullable
    private final List<AdvertImageWithOverlay> images;
    @Nullable
    private Boolean isNotificationsActivated;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    private boolean isSubscribed;
    @SerializedName("title")
    @NotNull
    private final String name;
    @SerializedName("hashUserId")
    @NotNull
    private final String userKey;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RecommendedSeller> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendedSeller createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            Image image = (Image) parcel.readParcelable(RecommendedSeller.class.getClassLoader());
            String readString3 = parcel.readString();
            DeepLink deepLink = (DeepLink) parcel.readParcelable(RecommendedSeller.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(AdvertImageWithOverlay.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            return new RecommendedSeller(readString, readString2, bool, image, readString3, deepLink, arrayList, z2, bool2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendedSeller[] newArray(int i) {
            return new RecommendedSeller[i];
        }
    }

    public RecommendedSeller(@NotNull String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Image image, @NotNull String str3, @Nullable DeepLink deepLink2, @Nullable List<AdvertImageWithOverlay> list, boolean z, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.userKey = str;
        this.description = str2;
        this.isShop = bool;
        this.avatar = image;
        this.name = str3;
        this.deepLink = deepLink2;
        this.images = list;
        this.isSubscribed = z;
        this.isNotificationsActivated = bool2;
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
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<AdvertImageWithOverlay> getImages() {
        return this.images;
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
    public final Boolean isNotificationsActivated() {
        return this.isNotificationsActivated;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setNotificationsActivated(@Nullable Boolean bool) {
        this.isNotificationsActivated = bool;
    }

    public final void setSubscribed(boolean z) {
        this.isSubscribed = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.userKey);
        parcel.writeString(this.description);
        Boolean bool = this.isShop;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.deepLink, i);
        List<AdvertImageWithOverlay> list = this.images;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((AdvertImageWithOverlay) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.isSubscribed ? 1 : 0);
        Boolean bool2 = this.isNotificationsActivated;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendedSeller(String str, String str2, Boolean bool, Image image, String str3, DeepLink deepLink2, List list, boolean z, Boolean bool2, int i, j jVar) {
        this(str, str2, bool, image, str3, deepLink2, list, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : bool2);
    }
}
