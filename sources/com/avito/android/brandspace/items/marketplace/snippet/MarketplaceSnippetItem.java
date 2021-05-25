package com.avito.android.brandspace.items.marketplace.snippet;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u0018¢\u0006\u0004\bL\u0010MJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJh\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b%\u0010\nJ\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020&HÖ\u0001¢\u0006\u0004\b-\u0010(J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020&HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0011R\u0019\u0010\"\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u001aR\u0019\u0010!\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\nR!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u000eR\u0019\u0010 \u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0007¨\u0006N"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "component3", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "component4", "()Ljava/util/List;", "", "component5", "()Z", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component7", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceItemSnippetPrice;", "component8", "()Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceItemSnippetPrice;", "id", "type", "title", "badges", "hasDelivery", "image", "deeplink", "price", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Ljava/util/List;ZLcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceItemSnippetPrice;)Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Z", "getHasDelivery", "h", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceItemSnippetPrice;", "getPrice", g.a, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "c", "Ljava/lang/String;", "getTitle", "d", "Ljava/util/List;", "getBadges", "f", "Lcom/avito/android/remote/model/Image;", "getImage", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Ljava/util/List;ZLcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceItemSnippetPrice;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSnippetItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<MarketplaceSnippetItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final BlockType b;
    @NotNull
    public final String c;
    @Nullable
    public final List<SerpBadge> d;
    public final boolean e;
    @NotNull
    public final Image f;
    @NotNull
    public final DeepLink g;
    @NotNull
    public final MarketplaceItemSnippetPrice h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceSnippetItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSnippetItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SerpBadge) parcel.readParcelable(MarketplaceSnippetItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new MarketplaceSnippetItem(readLong, blockType, readString, arrayList, parcel.readInt() != 0, (Image) parcel.readParcelable(MarketplaceSnippetItem.class.getClassLoader()), (DeepLink) parcel.readParcelable(MarketplaceSnippetItem.class.getClassLoader()), MarketplaceItemSnippetPrice.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSnippetItem[] newArray(int i) {
            return new MarketplaceSnippetItem[i];
        }
    }

    public MarketplaceSnippetItem(long j, @NotNull BlockType blockType, @NotNull String str, @Nullable List<SerpBadge> list, boolean z, @NotNull Image image, @NotNull DeepLink deepLink, @NotNull MarketplaceItemSnippetPrice marketplaceItemSnippetPrice) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intrinsics.checkNotNullParameter(marketplaceItemSnippetPrice, "price");
        this.a = j;
        this.b = blockType;
        this.c = str;
        this.d = list;
        this.e = z;
        this.f = image;
        this.g = deepLink;
        this.h = marketplaceItemSnippetPrice;
    }

    public static /* synthetic */ MarketplaceSnippetItem copy$default(MarketplaceSnippetItem marketplaceSnippetItem, long j, BlockType blockType, String str, List list, boolean z, Image image, DeepLink deepLink, MarketplaceItemSnippetPrice marketplaceItemSnippetPrice, int i, Object obj) {
        return marketplaceSnippetItem.copy((i & 1) != 0 ? marketplaceSnippetItem.getId() : j, (i & 2) != 0 ? marketplaceSnippetItem.getType() : blockType, (i & 4) != 0 ? marketplaceSnippetItem.c : str, (i & 8) != 0 ? marketplaceSnippetItem.d : list, (i & 16) != 0 ? marketplaceSnippetItem.e : z, (i & 32) != 0 ? marketplaceSnippetItem.f : image, (i & 64) != 0 ? marketplaceSnippetItem.g : deepLink, (i & 128) != 0 ? marketplaceSnippetItem.h : marketplaceItemSnippetPrice);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final List<SerpBadge> component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final Image component6() {
        return this.f;
    }

    @NotNull
    public final DeepLink component7() {
        return this.g;
    }

    @NotNull
    public final MarketplaceItemSnippetPrice component8() {
        return this.h;
    }

    @NotNull
    public final MarketplaceSnippetItem copy(long j, @NotNull BlockType blockType, @NotNull String str, @Nullable List<SerpBadge> list, boolean z, @NotNull Image image, @NotNull DeepLink deepLink, @NotNull MarketplaceItemSnippetPrice marketplaceItemSnippetPrice) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intrinsics.checkNotNullParameter(marketplaceItemSnippetPrice, "price");
        return new MarketplaceSnippetItem(j, blockType, str, list, z, image, deepLink, marketplaceItemSnippetPrice);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketplaceSnippetItem)) {
            return false;
        }
        MarketplaceSnippetItem marketplaceSnippetItem = (MarketplaceSnippetItem) obj;
        return getId() == marketplaceSnippetItem.getId() && Intrinsics.areEqual(getType(), marketplaceSnippetItem.getType()) && Intrinsics.areEqual(this.c, marketplaceSnippetItem.c) && Intrinsics.areEqual(this.d, marketplaceSnippetItem.d) && this.e == marketplaceSnippetItem.e && Intrinsics.areEqual(this.f, marketplaceSnippetItem.f) && Intrinsics.areEqual(this.g, marketplaceSnippetItem.g) && Intrinsics.areEqual(this.h, marketplaceSnippetItem.h);
    }

    @Nullable
    public final List<SerpBadge> getBadges() {
        return this.d;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.g;
    }

    public final boolean getHasDelivery() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Image getImage() {
        return this.f;
    }

    @NotNull
    public final MarketplaceItemSnippetPrice getPrice() {
        return this.h;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return TrackableBrandspaceItem.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItem
    @NotNull
    public BlockType getType() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        BlockType type = getType();
        int i = 0;
        int hashCode = (a3 + (type != null ? type.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<SerpBadge> list = this.d;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        Image image = this.f;
        int hashCode4 = (i5 + (image != null ? image.hashCode() : 0)) * 31;
        DeepLink deepLink = this.g;
        int hashCode5 = (hashCode4 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        MarketplaceItemSnippetPrice marketplaceItemSnippetPrice = this.h;
        if (marketplaceItemSnippetPrice != null) {
            i = marketplaceItemSnippetPrice.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceSnippetItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", title=");
        L.append(this.c);
        L.append(", badges=");
        L.append(this.d);
        L.append(", hasDelivery=");
        L.append(this.e);
        L.append(", image=");
        L.append(this.f);
        L.append(", deeplink=");
        L.append(this.g);
        L.append(", price=");
        L.append(this.h);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        List<SerpBadge> list = this.d;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((SerpBadge) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        this.h.writeToParcel(parcel, 0);
    }
}
