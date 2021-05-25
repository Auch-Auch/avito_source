package com.avito.android.brandspace.items.marketplace.tab.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.remote.model.ItemsShow;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0012\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "component1", "()J", "", "Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabDetailDataItem;", "component2", "()Ljava/util/List;", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "component3", "()Lcom/avito/android/brandspace/remote/model/ItemsShow;", "Lcom/avito/android/brandspace/items/BlockType;", "component4", "()Lcom/avito/android/brandspace/items/BlockType;", "id", "tabs", "itemShow", "type", "copy", "(JLjava/util/List;Lcom/avito/android/brandspace/remote/model/ItemsShow;Lcom/avito/android/brandspace/items/BlockType;)Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabsDataItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/brandspace/items/BlockType;", "getType", "c", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "getItemShow", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getTabs", "<init>", "(JLjava/util/List;Lcom/avito/android/brandspace/remote/model/ItemsShow;Lcom/avito/android/brandspace/items/BlockType;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabsDataItem implements BrandspaceItem {
    public static final Parcelable.Creator<MarketplaceTabsDataItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final List<MarketplaceTabDetailDataItem> b;
    @NotNull
    public final ItemsShow c;
    @NotNull
    public final BlockType d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabsDataItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsDataItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(MarketplaceTabDetailDataItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new MarketplaceTabsDataItem(readLong, arrayList, (ItemsShow) Enum.valueOf(ItemsShow.class, parcel.readString()), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsDataItem[] newArray(int i) {
            return new MarketplaceTabsDataItem[i];
        }
    }

    public MarketplaceTabsDataItem(long j, @NotNull List<MarketplaceTabDetailDataItem> list, @NotNull ItemsShow itemsShow, @NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        Intrinsics.checkNotNullParameter(itemsShow, "itemShow");
        Intrinsics.checkNotNullParameter(blockType, "type");
        this.a = j;
        this.b = list;
        this.c = itemsShow;
        this.d = blockType;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.brandspace.items.marketplace.tab.items.MarketplaceTabsDataItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplaceTabsDataItem copy$default(MarketplaceTabsDataItem marketplaceTabsDataItem, long j, List list, ItemsShow itemsShow, BlockType blockType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = marketplaceTabsDataItem.getId();
        }
        if ((i & 2) != 0) {
            list = marketplaceTabsDataItem.b;
        }
        if ((i & 4) != 0) {
            itemsShow = marketplaceTabsDataItem.c;
        }
        if ((i & 8) != 0) {
            blockType = marketplaceTabsDataItem.getType();
        }
        return marketplaceTabsDataItem.copy(j, list, itemsShow, blockType);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final List<MarketplaceTabDetailDataItem> component2() {
        return this.b;
    }

    @NotNull
    public final ItemsShow component3() {
        return this.c;
    }

    @NotNull
    public final BlockType component4() {
        return getType();
    }

    @NotNull
    public final MarketplaceTabsDataItem copy(long j, @NotNull List<MarketplaceTabDetailDataItem> list, @NotNull ItemsShow itemsShow, @NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        Intrinsics.checkNotNullParameter(itemsShow, "itemShow");
        Intrinsics.checkNotNullParameter(blockType, "type");
        return new MarketplaceTabsDataItem(j, list, itemsShow, blockType);
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
        if (!(obj instanceof MarketplaceTabsDataItem)) {
            return false;
        }
        MarketplaceTabsDataItem marketplaceTabsDataItem = (MarketplaceTabsDataItem) obj;
        return getId() == marketplaceTabsDataItem.getId() && Intrinsics.areEqual(this.b, marketplaceTabsDataItem.b) && Intrinsics.areEqual(this.c, marketplaceTabsDataItem.c) && Intrinsics.areEqual(getType(), marketplaceTabsDataItem.getType());
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final ItemsShow getItemShow() {
        return this.c;
    }

    @NotNull
    public final List<MarketplaceTabDetailDataItem> getTabs() {
        return this.b;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItem
    @NotNull
    public BlockType getType() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        List<MarketplaceTabDetailDataItem> list = this.b;
        int i = 0;
        int hashCode = (a3 + (list != null ? list.hashCode() : 0)) * 31;
        ItemsShow itemsShow = this.c;
        int hashCode2 = (hashCode + (itemsShow != null ? itemsShow.hashCode() : 0)) * 31;
        BlockType type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceTabsDataItem(id=");
        L.append(getId());
        L.append(", tabs=");
        L.append(this.b);
        L.append(", itemShow=");
        L.append(this.c);
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            ((MarketplaceTabDetailDataItem) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.c.name());
        parcel.writeString(this.d.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarketplaceTabsDataItem(long j, List list, ItemsShow itemsShow, BlockType blockType, int i, j jVar) {
        this(j, list, itemsShow, (i & 8) != 0 ? BlockType.MARKETPLACE_TABS : blockType);
    }
}
