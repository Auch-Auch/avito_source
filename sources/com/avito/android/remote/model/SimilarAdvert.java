package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B=\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/SimilarAdvert;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/AdvertPrice;", "price", "Lcom/avito/android/remote/model/AdvertPrice;", "getPrice", "()Lcom/avito/android/remote/model/AdvertPrice;", "", "isFavorite", "Z", "()Z", "id", "getId", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/AdvertImage;", "images", "Lcom/avito/android/remote/model/AdvertImage;", "getImages", "()Lcom/avito/android/remote/model/AdvertImage;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;ZLcom/avito/android/remote/model/AdvertImage;Lcom/avito/android/remote/model/AdvertPrice;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvert implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SimilarAdvert> CREATOR = Parcels.creator(SimilarAdvert$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final AdvertImage images;
    @SerializedName("isFavorite")
    private final boolean isFavorite;
    @SerializedName("price")
    @Nullable
    private final AdvertPrice price;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SimilarAdvert$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SimilarAdvert;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SimilarAdvert(@NotNull String str, @Nullable DeepLink deepLink2, @NotNull String str2, boolean z, @Nullable AdvertImage advertImage, @Nullable AdvertPrice advertPrice) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.deepLink = deepLink2;
        this.title = str2;
        this.isFavorite = z;
        this.images = advertImage;
        this.price = advertPrice;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AdvertImage getImages() {
        return this.images;
    }

    @Nullable
    public final AdvertPrice getPrice() {
        return this.price;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeString(this.title);
        ParcelsKt.writeBool(parcel, this.isFavorite);
        parcel.writeParcelable(this.images, i);
        parcel.writeParcelable(this.price, i);
    }
}
