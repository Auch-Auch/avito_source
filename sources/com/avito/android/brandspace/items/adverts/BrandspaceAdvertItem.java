package com.avito.android.brandspace.items.adverts;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b6\u00107J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\u00198\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010\u0013R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000bR\u0016\u0010-\u001a\u00020\u00118\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\"\u0010\r\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\b\"\u0004\b1\u00102R\u001c\u0010\f\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0005¨\u00068"}, d2 = {"Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/serp/adapter/AdvertItem;", "component3", "()Lcom/avito/android/serp/adapter/AdvertItem;", "id", "type", "advertItem", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/serp/adapter/AdvertItem;)Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "isFavorite", "()Z", "setFavorite", "(Z)V", "getAnalyticsContext", "analyticsContext", "c", "Lcom/avito/android/serp/adapter/AdvertItem;", "getAdvertItem", "getStringId", "stringId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", AuthSource.SEND_ABUSE, "J", "getId", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/serp/adapter/AdvertItem;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdvertItem implements TrackableBrandspaceItem, FavorableItem {
    public static final Parcelable.Creator<BrandspaceAdvertItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final AdvertItem c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceAdvertItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAdvertItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceAdvertItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (AdvertItem) parcel.readParcelable(BrandspaceAdvertItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAdvertItem[] newArray(int i) {
            return new BrandspaceAdvertItem[i];
        }
    }

    public BrandspaceAdvertItem(long j, @NotNull BlockType blockType, @NotNull AdvertItem advertItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(advertItem, "advertItem");
        this.a = j;
        this.b = blockType;
        this.c = advertItem;
    }

    public static /* synthetic */ BrandspaceAdvertItem copy$default(BrandspaceAdvertItem brandspaceAdvertItem, long j, BlockType blockType, AdvertItem advertItem, int i, Object obj) {
        if ((i & 1) != 0) {
            j = brandspaceAdvertItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = brandspaceAdvertItem.getType();
        }
        if ((i & 4) != 0) {
            advertItem = brandspaceAdvertItem.c;
        }
        return brandspaceAdvertItem.copy(j, blockType, advertItem);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final AdvertItem component3() {
        return this.c;
    }

    @NotNull
    public final BrandspaceAdvertItem copy(long j, @NotNull BlockType blockType, @NotNull AdvertItem advertItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(advertItem, "advertItem");
        return new BrandspaceAdvertItem(j, blockType, advertItem);
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
        if (!(obj instanceof BrandspaceAdvertItem)) {
            return false;
        }
        BrandspaceAdvertItem brandspaceAdvertItem = (BrandspaceAdvertItem) obj;
        return getId() == brandspaceAdvertItem.getId() && Intrinsics.areEqual(getType(), brandspaceAdvertItem.getType()) && Intrinsics.areEqual(this.c, brandspaceAdvertItem.c);
    }

    @NotNull
    public final AdvertItem getAdvertItem() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.c.getAnalyticsContext();
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c.getStringId();
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
        AdvertItem advertItem = this.c;
        if (advertItem != null) {
            i = advertItem.hashCode();
        }
        return hashCode + i;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.c.isFavorite();
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z) {
        this.c.setFavorite(z);
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceAdvertItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", advertItem=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeParcelable(this.c, i);
    }
}
