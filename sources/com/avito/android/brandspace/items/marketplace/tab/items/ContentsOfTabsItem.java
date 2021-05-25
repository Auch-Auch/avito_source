package com.avito.android.brandspace.items.marketplace.tab.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R+\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\r¨\u0006/"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tab/items/ContentsOfTabsItem;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "", "", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItem;", "component3", "()Ljava/util/Map;", "id", "type", "tabs", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/util/Map;)Lcom/avito/android/brandspace/items/marketplace/tab/items/ContentsOfTabsItem;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "c", "Ljava/util/Map;", "getTabs", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/util/Map;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ContentsOfTabsItem implements BrandspaceItem {
    public static final Parcelable.Creator<ContentsOfTabsItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final BlockType b;
    @NotNull
    public final Map<String, List<MarketplaceSnippetItem>> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContentsOfTabsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContentsOfTabsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(MarketplaceSnippetItem.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                linkedHashMap.put(readString, arrayList);
                readInt--;
            }
            return new ContentsOfTabsItem(readLong, blockType, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContentsOfTabsItem[] newArray(int i) {
            return new ContentsOfTabsItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ContentsOfTabsItem(long j, @NotNull BlockType blockType, @NotNull Map<String, ? extends List<MarketplaceSnippetItem>> map) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(map, "tabs");
        this.a = j;
        this.b = blockType;
        this.c = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.items.marketplace.tab.items.ContentsOfTabsItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentsOfTabsItem copy$default(ContentsOfTabsItem contentsOfTabsItem, long j, BlockType blockType, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentsOfTabsItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = contentsOfTabsItem.getType();
        }
        if ((i & 4) != 0) {
            map = contentsOfTabsItem.c;
        }
        return contentsOfTabsItem.copy(j, blockType, map);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final Map<String, List<MarketplaceSnippetItem>> component3() {
        return this.c;
    }

    @NotNull
    public final ContentsOfTabsItem copy(long j, @NotNull BlockType blockType, @NotNull Map<String, ? extends List<MarketplaceSnippetItem>> map) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(map, "tabs");
        return new ContentsOfTabsItem(j, blockType, map);
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
        if (!(obj instanceof ContentsOfTabsItem)) {
            return false;
        }
        ContentsOfTabsItem contentsOfTabsItem = (ContentsOfTabsItem) obj;
        return getId() == contentsOfTabsItem.getId() && Intrinsics.areEqual(getType(), contentsOfTabsItem.getType()) && Intrinsics.areEqual(this.c, contentsOfTabsItem.c);
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Map<String, List<MarketplaceSnippetItem>> getTabs() {
        return this.c;
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
        Map<String, List<MarketplaceSnippetItem>> map = this.c;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContentsOfTabsItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", tabs=");
        return a.x(L, this.c, ")");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r5 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            long r0 = r3.a
            r4.writeLong(r0)
            com.avito.android.brandspace.items.BlockType r5 = r3.b
            java.lang.String r5 = r5.name()
            r4.writeString(r5)
            java.util.Map<java.lang.String, java.util.List<com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem>> r5 = r3.c
            java.util.Iterator r5 = a2.b.a.a.a.o0(r5, r4)
        L_0x0019:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r5.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = a2.b.a.a.a.n0(r0, r4)
        L_0x0036:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem r1 = (com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem) r1
            r2 = 0
            r1.writeToParcel(r4, r2)
            goto L_0x0036
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.tab.items.ContentsOfTabsItem.writeToParcel(android.os.Parcel, int):void");
    }
}
