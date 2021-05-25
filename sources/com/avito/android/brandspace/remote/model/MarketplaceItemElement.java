package com.avito.android.brandspace.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceItemElement;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "badgeBar", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "getBadgeBar", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "", "id", "J", "getId", "()J", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "hasDelivery", "Z", "getHasDelivery", "()Z", "Lcom/avito/android/brandspace/remote/model/MarketplacePriceElement;", "price", "Lcom/avito/android/brandspace/remote/model/MarketplacePriceElement;", "getPrice", "()Lcom/avito/android/brandspace/remote/model/MarketplacePriceElement;", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;ZLcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/brandspace/remote/model/MarketplacePriceElement;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceItemElement implements Parcelable {
    public static final Parcelable.Creator<MarketplaceItemElement> CREATOR = new Creator();
    @Nullable
    private final SerpBadgeBar badgeBar;
    @NotNull
    private final DeepLink deeplink;
    private final boolean hasDelivery;
    private final long id;
    @NotNull
    private final Image image;
    @NotNull
    private final MarketplacePriceElement price;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceItemElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceItemElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceItemElement(parcel.readLong(), parcel.readString(), (SerpBadgeBar) parcel.readParcelable(MarketplaceItemElement.class.getClassLoader()), parcel.readInt() != 0, (Image) parcel.readParcelable(MarketplaceItemElement.class.getClassLoader()), (DeepLink) parcel.readParcelable(MarketplaceItemElement.class.getClassLoader()), MarketplacePriceElement.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceItemElement[] newArray(int i) {
            return new MarketplaceItemElement[i];
        }
    }

    public MarketplaceItemElement(long j, @NotNull String str, @Nullable SerpBadgeBar serpBadgeBar, boolean z, @NotNull Image image2, @NotNull DeepLink deepLink, @NotNull MarketplacePriceElement marketplacePriceElement) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intrinsics.checkNotNullParameter(marketplacePriceElement, "price");
        this.id = j;
        this.title = str;
        this.badgeBar = serpBadgeBar;
        this.hasDelivery = z;
        this.image = image2;
        this.deeplink = deepLink;
        this.price = marketplacePriceElement;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final SerpBadgeBar getBadgeBar() {
        return this.badgeBar;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    public final boolean getHasDelivery() {
        return this.hasDelivery;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final MarketplacePriceElement getPrice() {
        return this.price;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.badgeBar, i);
        parcel.writeInt(this.hasDelivery ? 1 : 0);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.deeplink, i);
        this.price.writeToParcel(parcel, 0);
    }
}
