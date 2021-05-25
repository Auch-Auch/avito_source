package com.avito.android.brandspace.items.marketplace.tab;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.VirtualItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0011HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004JT\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\"\u0010\u0016J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020#HÖ\u0001¢\u0006\u0004\b*\u0010%J \u0010.\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020#HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001c\u0010\u001b\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0010R\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u001f\u0010\u0004R+\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00118\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010<R\u001c\u0010\u001e\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0019¨\u0006B"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "Lcom/avito/android/brandspace/presenter/virtualitems/VirtualItem;", "", "isUnpackable", "()Z", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getUnpackItems", "()Ljava/util/List;", "oldItem", "newItem", "", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "", "component1", "()J", "", "", "component2", "()Ljava/util/Map;", "component3", "()Ljava/lang/String;", "Lcom/avito/android/brandspace/items/BlockType;", "component4", "()Lcom/avito/android/brandspace/items/BlockType;", "component5", "id", "tabs", "selectedTab", "type", "isReplaceableItem", "copy", "(JLjava/util/Map;Ljava/lang/String;Lcom/avito/android/brandspace/items/BlockType;Z)Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "J", "getId", "e", "Z", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getTabs", "c", "Ljava/lang/String;", "getSelectedTab", "setSelectedTab", "(Ljava/lang/String;)V", "d", "Lcom/avito/android/brandspace/items/BlockType;", "getType", "<init>", "(JLjava/util/Map;Ljava/lang/String;Lcom/avito/android/brandspace/items/BlockType;Z)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabsItem implements VirtualItem {
    public static final Parcelable.Creator<MarketplaceTabsItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final Map<String, List<BrandspaceItem>> b;
    @NotNull
    public String c;
    @NotNull
    public final BlockType d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsItem createFromParcel(@NotNull Parcel parcel) {
            String readString;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (true) {
                readString = parcel.readString();
                if (readInt == 0) {
                    break;
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add((BrandspaceItem) parcel.readParcelable(MarketplaceTabsItem.class.getClassLoader()));
                    readInt2--;
                }
                linkedHashMap.put(readString, arrayList);
                readInt--;
            }
            return new MarketplaceTabsItem(readLong, linkedHashMap, readString, (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabsItem[] newArray(int i) {
            return new MarketplaceTabsItem[i];
        }
    }

    public MarketplaceTabsItem(long j, @NotNull Map<String, List<BrandspaceItem>> map, @NotNull String str, @NotNull BlockType blockType, boolean z) {
        Intrinsics.checkNotNullParameter(map, "tabs");
        Intrinsics.checkNotNullParameter(str, "selectedTab");
        Intrinsics.checkNotNullParameter(blockType, "type");
        this.a = j;
        this.b = map;
        this.c = str;
        this.d = blockType;
        this.e = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplaceTabsItem copy$default(MarketplaceTabsItem marketplaceTabsItem, long j, Map map, String str, BlockType blockType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = marketplaceTabsItem.getId();
        }
        if ((i & 2) != 0) {
            map = marketplaceTabsItem.b;
        }
        if ((i & 4) != 0) {
            str = marketplaceTabsItem.c;
        }
        if ((i & 8) != 0) {
            blockType = marketplaceTabsItem.getType();
        }
        if ((i & 16) != 0) {
            z = marketplaceTabsItem.isReplaceableItem();
        }
        return marketplaceTabsItem.copy(j, map, str, blockType, z);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final Map<String, List<BrandspaceItem>> component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final BlockType component4() {
        return getType();
    }

    public final boolean component5() {
        return isReplaceableItem();
    }

    @NotNull
    public final MarketplaceTabsItem copy(long j, @NotNull Map<String, List<BrandspaceItem>> map, @NotNull String str, @NotNull BlockType blockType, boolean z) {
        Intrinsics.checkNotNullParameter(map, "tabs");
        Intrinsics.checkNotNullParameter(str, "selectedTab");
        Intrinsics.checkNotNullParameter(blockType, "type");
        return new MarketplaceTabsItem(j, map, str, blockType, z);
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
        if (!(obj instanceof MarketplaceTabsItem)) {
            return false;
        }
        MarketplaceTabsItem marketplaceTabsItem = (MarketplaceTabsItem) obj;
        return getId() == marketplaceTabsItem.getId() && Intrinsics.areEqual(this.b, marketplaceTabsItem.b) && Intrinsics.areEqual(this.c, marketplaceTabsItem.c) && Intrinsics.areEqual(getType(), marketplaceTabsItem.getType()) && isReplaceableItem() == marketplaceTabsItem.isReplaceableItem();
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getSelectedTab() {
        return this.c;
    }

    @NotNull
    public final Map<String, List<BrandspaceItem>> getTabs() {
        return this.b;
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return VirtualItem.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItem
    @NotNull
    public BlockType getType() {
        return this.d;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    @NotNull
    public List<BrandspaceItem> getUnpackItems() {
        List<BrandspaceItem> list = this.b.get(this.c);
        return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        Map<String, List<BrandspaceItem>> map = this.b;
        int i = 0;
        int hashCode = (a3 + (map != null ? map.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        BlockType type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean isReplaceableItem = isReplaceableItem();
        if (isReplaceableItem) {
            isReplaceableItem = true;
        }
        int i3 = isReplaceableItem ? 1 : 0;
        int i4 = isReplaceableItem ? 1 : 0;
        int i5 = isReplaceableItem ? 1 : 0;
        return i2 + i3;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public boolean isReplaceableItem() {
        return this.e;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public boolean isUnpackable() {
        return true;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public void replaceItem(@NotNull BrandspaceItem brandspaceItem, @NotNull BrandspaceItem brandspaceItem2) {
        List<BrandspaceItem> mutableList;
        Intrinsics.checkNotNullParameter(brandspaceItem, "oldItem");
        Intrinsics.checkNotNullParameter(brandspaceItem2, "newItem");
        String str = this.c;
        List<BrandspaceItem> list = this.b.get(str);
        if (list != null && (mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list)) != null) {
            int indexOf = mutableList.indexOf(brandspaceItem);
            mutableList.remove(indexOf);
            mutableList.add(indexOf, brandspaceItem2);
            this.b.put(str, mutableList);
        }
    }

    public final void setSelectedTab(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceTabsItem(id=");
        L.append(getId());
        L.append(", tabs=");
        L.append(this.b);
        L.append(", selectedTab=");
        L.append(this.c);
        L.append(", type=");
        L.append(getType());
        L.append(", isReplaceableItem=");
        L.append(isReplaceableItem());
        L.append(")");
        return L.toString();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            long r0 = r3.a
            r4.writeLong(r0)
            java.util.Map<java.lang.String, java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem>> r0 = r3.b
            java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r4)
        L_0x0010:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r1 = a2.b.a.a.a.n0(r1, r4)
        L_0x002d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0010
            java.lang.Object r2 = r1.next()
            com.avito.android.brandspace.presenter.BrandspaceItem r2 = (com.avito.android.brandspace.presenter.BrandspaceItem) r2
            r4.writeParcelable(r2, r5)
            goto L_0x002d
        L_0x003d:
            java.lang.String r5 = r3.c
            r4.writeString(r5)
            com.avito.android.brandspace.items.BlockType r5 = r3.d
            java.lang.String r5 = r5.name()
            r4.writeString(r5)
            boolean r5 = r3.e
            r4.writeInt(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarketplaceTabsItem(long j, Map map, String str, BlockType blockType, boolean z, int i, j jVar) {
        this(j, map, str, (i & 8) != 0 ? BlockType.MARKETPLACE_TABS : blockType, (i & 16) != 0 ? false : z);
    }
}
