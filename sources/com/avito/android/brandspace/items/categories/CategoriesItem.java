package com.avito.android.brandspace.items.categories;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.categories.categoryitem.CategoryItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jd\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\r2\b\b\u0002\u0010\u0019\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b$\u0010\u0013J \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*R+\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0011R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\fR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0004R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0013\"\u0004\b7\u00108R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u0010\u0004R\"\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/avito/android/brandspace/items/categories/CategoriesItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "component3", "", "", "component4", "()Ljava/util/List;", "", "", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItem;", "component5", "()Ljava/util/Map;", "component6", "()I", "id", "type", "categoriesId", "categories", "categoryItems", "selectedCategoryIndex", "copy", "(JLcom/avito/android/brandspace/items/BlockType;JLjava/util/List;Ljava/util/Map;I)Lcom/avito/android/brandspace/items/categories/CategoriesItem;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Ljava/util/Map;", "getCategoryItems", "d", "Ljava/util/List;", "getCategories", AuthSource.SEND_ABUSE, "J", "getId", "f", "I", "getSelectedCategoryIndex", "setSelectedCategoryIndex", "(I)V", "c", "getCategoriesId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;JLjava/util/List;Ljava/util/Map;I)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<CategoriesItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    public final long c;
    @NotNull
    public final List<String> d;
    @NotNull
    public final Map<Integer, List<CategoryItem>> e;
    public int f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoriesItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoriesItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            long readLong2 = parcel.readLong();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (true) {
                int readInt2 = parcel.readInt();
                if (readInt == 0) {
                    return new CategoriesItem(readLong, blockType, readLong2, createStringArrayList, linkedHashMap, readInt2);
                }
                Integer valueOf = Integer.valueOf(readInt2);
                int readInt3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList.add(CategoryItem.CREATOR.createFromParcel(parcel));
                    readInt3--;
                }
                linkedHashMap.put(valueOf, arrayList);
                readInt--;
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoriesItem[] newArray(int i) {
            return new CategoriesItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<java.lang.Integer, ? extends java.util.List<com.avito.android.brandspace.items.categories.categoryitem.CategoryItem>> */
    /* JADX WARN: Multi-variable type inference failed */
    public CategoriesItem(long j, @NotNull BlockType blockType, long j2, @NotNull List<String> list, @NotNull Map<Integer, ? extends List<CategoryItem>> map, int i) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(map, "categoryItems");
        this.a = j;
        this.b = blockType;
        this.c = j2;
        this.d = list;
        this.e = map;
        this.f = i;
    }

    public static /* synthetic */ CategoriesItem copy$default(CategoriesItem categoriesItem, long j, BlockType blockType, long j2, List list, Map map, int i, int i2, Object obj) {
        return categoriesItem.copy((i2 & 1) != 0 ? categoriesItem.getId() : j, (i2 & 2) != 0 ? categoriesItem.getType() : blockType, (i2 & 4) != 0 ? categoriesItem.c : j2, (i2 & 8) != 0 ? categoriesItem.d : list, (i2 & 16) != 0 ? categoriesItem.e : map, (i2 & 32) != 0 ? categoriesItem.f : i);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final List<String> component4() {
        return this.d;
    }

    @NotNull
    public final Map<Integer, List<CategoryItem>> component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    @NotNull
    public final CategoriesItem copy(long j, @NotNull BlockType blockType, long j2, @NotNull List<String> list, @NotNull Map<Integer, ? extends List<CategoryItem>> map, int i) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(map, "categoryItems");
        return new CategoriesItem(j, blockType, j2, list, map, i);
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
        if (!(obj instanceof CategoriesItem)) {
            return false;
        }
        CategoriesItem categoriesItem = (CategoriesItem) obj;
        return getId() == categoriesItem.getId() && Intrinsics.areEqual(getType(), categoriesItem.getType()) && this.c == categoriesItem.c && Intrinsics.areEqual(this.d, categoriesItem.d) && Intrinsics.areEqual(this.e, categoriesItem.e) && this.f == categoriesItem.f;
    }

    @NotNull
    public final List<String> getCategories() {
        return this.d;
    }

    public final long getCategoriesId() {
        return this.c;
    }

    @NotNull
    public final Map<Integer, List<CategoryItem>> getCategoryItems() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    public final int getSelectedCategoryIndex() {
        return this.f;
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
        int hashCode = (((a3 + (type != null ? type.hashCode() : 0)) * 31) + c.a(this.c)) * 31;
        List<String> list = this.d;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<Integer, List<CategoryItem>> map = this.e;
        if (map != null) {
            i = map.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.f;
    }

    public final void setSelectedCategoryIndex(int i) {
        this.f = i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoriesItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", categoriesId=");
        L.append(this.c);
        L.append(", categories=");
        L.append(this.d);
        L.append(", categoryItems=");
        L.append(this.e);
        L.append(", selectedCategoryIndex=");
        return a.j(L, this.f, ")");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map$Entry, java.lang.Object] */
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
            long r0 = r3.c
            r4.writeLong(r0)
            java.util.List<java.lang.String> r5 = r3.d
            r4.writeStringList(r5)
            java.util.Map<java.lang.Integer, java.util.List<com.avito.android.brandspace.items.categories.categoryitem.CategoryItem>> r5 = r3.e
            java.util.Iterator r5 = a2.b.a.a.a.o0(r5, r4)
        L_0x0023:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r5.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r4.writeInt(r1)
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = a2.b.a.a.a.n0(r0, r4)
        L_0x0044:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0023
            java.lang.Object r1 = r0.next()
            com.avito.android.brandspace.items.categories.categoryitem.CategoryItem r1 = (com.avito.android.brandspace.items.categories.categoryitem.CategoryItem) r1
            r2 = 0
            r1.writeToParcel(r4, r2)
            goto L_0x0044
        L_0x0055:
            int r5 = r3.f
            r4.writeInt(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.categories.CategoriesItem.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoriesItem(long j, BlockType blockType, long j2, List list, Map map, int i, int i2, j jVar) {
        this(j, blockType, j2, list, map, (i2 & 32) != 0 ? 0 : i);
    }
}
