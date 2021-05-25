package com.avito.android.brandspace.presenter.virtualitems;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\nR\"\u0010\u0011\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\r\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/SnippetCarouselLoader;", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "replace", "(Ljava/util/List;)Ljava/util/List;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "component3", "()Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "id", "type", "carouselItem", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/brandspace/items/carousel/CarouselItem;)Lcom/avito/android/brandspace/presenter/virtualitems/SnippetCarouselLoader;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "getCarouselItem", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/brandspace/items/carousel/CarouselItem;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetCarouselLoader implements AddableItemsWithLoadingBrandspaceItem {
    public static final Parcelable.Creator<SnippetCarouselLoader> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final CarouselItem c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SnippetCarouselLoader> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetCarouselLoader createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SnippetCarouselLoader(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), CarouselItem.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetCarouselLoader[] newArray(int i) {
            return new SnippetCarouselLoader[i];
        }
    }

    public SnippetCarouselLoader(long j, @NotNull BlockType blockType, @NotNull CarouselItem carouselItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(carouselItem, "carouselItem");
        this.a = j;
        this.b = blockType;
        this.c = carouselItem;
    }

    public static /* synthetic */ SnippetCarouselLoader copy$default(SnippetCarouselLoader snippetCarouselLoader, long j, BlockType blockType, CarouselItem carouselItem, int i, Object obj) {
        if ((i & 1) != 0) {
            j = snippetCarouselLoader.getId();
        }
        if ((i & 2) != 0) {
            blockType = snippetCarouselLoader.getType();
        }
        if ((i & 4) != 0) {
            carouselItem = snippetCarouselLoader.c;
        }
        return snippetCarouselLoader.copy(j, blockType, carouselItem);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final CarouselItem component3() {
        return this.c;
    }

    @NotNull
    public final SnippetCarouselLoader copy(long j, @NotNull BlockType blockType, @NotNull CarouselItem carouselItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(carouselItem, "carouselItem");
        return new SnippetCarouselLoader(j, blockType, carouselItem);
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
        if (!(obj instanceof SnippetCarouselLoader)) {
            return false;
        }
        SnippetCarouselLoader snippetCarouselLoader = (SnippetCarouselLoader) obj;
        return getId() == snippetCarouselLoader.getId() && Intrinsics.areEqual(getType(), snippetCarouselLoader.getType()) && Intrinsics.areEqual(this.c, snippetCarouselLoader.c);
    }

    @NotNull
    public final CarouselItem getCarouselItem() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return AddableItemsWithLoadingBrandspaceItem.DefaultImpls.getTrackId(this);
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
        CarouselItem carouselItem = this.c;
        if (carouselItem != null) {
            i = carouselItem.hashCode();
        }
        return hashCode + i;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem
    @NotNull
    public List<CarouselItem> replace(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return d.listOf(CarouselItem.copy$default(this.c, 0, null, list, 0, false, 0, 59, null));
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SnippetCarouselLoader(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", carouselItem=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        this.c.writeToParcel(parcel, 0);
    }
}
