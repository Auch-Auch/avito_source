package com.avito.android.brandspace.items.carousel;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJR\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000eJ\u001a\u0010!\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b#\u0010\u000eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b(\u0010)R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010.R\"\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u00103R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0004R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010;R\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u00108\u001a\u0004\b=\u0010\u000eR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u0011¨\u0006C"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "component3", "()Ljava/util/List;", "", "component4", "()I", "", "component5", "()Z", "component6", "id", "type", "items", "currentPosition", "needAutoScroll", "calculatedItemHeight", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/util/List;IZI)Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/util/List;", "getItems", "setItems", "(Ljava/util/List;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", AuthSource.SEND_ABUSE, "J", "getId", "d", "I", "getCurrentPosition", "setCurrentPosition", "(I)V", "f", "getCalculatedItemHeight", "e", "Z", "getNeedAutoScroll", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/util/List;IZI)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<CarouselItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public List<? extends BrandspaceItem> c;
    public int d;
    public final boolean e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CarouselItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarouselItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BrandspaceItem) parcel.readParcelable(CarouselItem.class.getClassLoader()));
                readInt--;
            }
            return new CarouselItem(readLong, blockType, arrayList, parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarouselItem[] newArray(int i) {
            return new CarouselItem[i];
        }
    }

    public CarouselItem(long j, @NotNull BlockType blockType, @NotNull List<? extends BrandspaceItem> list, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = j;
        this.b = blockType;
        this.c = list;
        this.d = i;
        this.e = z;
        this.f = i2;
    }

    public static /* synthetic */ CarouselItem copy$default(CarouselItem carouselItem, long j, BlockType blockType, List list, int i, boolean z, int i2, int i3, Object obj) {
        return carouselItem.copy((i3 & 1) != 0 ? carouselItem.getId() : j, (i3 & 2) != 0 ? carouselItem.getType() : blockType, (i3 & 4) != 0 ? carouselItem.c : list, (i3 & 8) != 0 ? carouselItem.d : i, (i3 & 16) != 0 ? carouselItem.e : z, (i3 & 32) != 0 ? carouselItem.f : i2);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem>, java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem> */
    @NotNull
    public final List<BrandspaceItem> component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    @NotNull
    public final CarouselItem copy(long j, @NotNull BlockType blockType, @NotNull List<? extends BrandspaceItem> list, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        return new CarouselItem(j, blockType, list, i, z, i2);
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
        if (!(obj instanceof CarouselItem)) {
            return false;
        }
        CarouselItem carouselItem = (CarouselItem) obj;
        return getId() == carouselItem.getId() && Intrinsics.areEqual(getType(), carouselItem.getType()) && Intrinsics.areEqual(this.c, carouselItem.c) && this.d == carouselItem.d && this.e == carouselItem.e && this.f == carouselItem.f;
    }

    public final int getCalculatedItemHeight() {
        return this.f;
    }

    public final int getCurrentPosition() {
        return this.d;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem>, java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem> */
    @NotNull
    public final List<BrandspaceItem> getItems() {
        return this.c;
    }

    public final boolean getNeedAutoScroll() {
        return this.e;
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
        List<? extends BrandspaceItem> list = this.c;
        if (list != null) {
            i = list.hashCode();
        }
        int i2 = (((hashCode + i) * 31) + this.d) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return ((i2 + i3) * 31) + this.f;
    }

    public final void setCurrentPosition(int i) {
        this.d = i;
    }

    public final void setItems(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.c = list;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CarouselItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", items=");
        L.append(this.c);
        L.append(", currentPosition=");
        L.append(this.d);
        L.append(", needAutoScroll=");
        L.append(this.e);
        L.append(", calculatedItemHeight=");
        return a.j(L, this.f, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        Iterator n0 = a.n0(this.c, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BrandspaceItem) n0.next(), i);
        }
        parcel.writeInt(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselItem(long j, BlockType blockType, List list, int i, boolean z, int i2, int i3, j jVar) {
        this(j, blockType, list, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? 0 : i2);
    }
}
