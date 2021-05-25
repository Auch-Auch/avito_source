package com.avito.android.extended_profile.adapter.category.category_header;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.data.CategoryData;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJb\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b$\u0010\u001fJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b)\u0010*R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b\u0016\u0010\u000bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b\u0015\u0010\u000bR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u0010,\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010;R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010\u0004¨\u0006@"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component3", "", "component4", "()Z", "component5", "component6", "Lcom/avito/android/extended_profile/data/CategoryData;", "component7", "()Lcom/avito/android/extended_profile/data/CategoryData;", "component8", "stringId", "gridItemType", "title", "isCollapsed", "isCollapsible", "isLoading", "category", "showAnimation", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;ZZZLcom/avito/android/extended_profile/data/CategoryData;Z)Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Z", g.a, "Lcom/avito/android/extended_profile/data/CategoryData;", "getCategory", "e", "c", "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "d", "h", "getShowAnimation", "setShowAnimation", "(Z)V", AuthSource.SEND_ABUSE, "getStringId", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;ZZZLcom/avito/android/extended_profile/data/CategoryData;Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryHeaderItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<CategoryHeaderItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @Nullable
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    @NotNull
    public final CategoryData g;
    public boolean h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryHeaderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryHeaderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryHeaderItem(parcel.readString(), (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, CategoryData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryHeaderItem[] newArray(int i) {
            return new CategoryHeaderItem[i];
        }
    }

    public CategoryHeaderItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, boolean z, boolean z2, boolean z3, @NotNull CategoryData categoryData, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(categoryData, "category");
        this.a = str;
        this.b = gridItemType;
        this.c = str2;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = categoryData;
        this.h = z4;
    }

    public static /* synthetic */ CategoryHeaderItem copy$default(CategoryHeaderItem categoryHeaderItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, boolean z, boolean z2, boolean z3, CategoryData categoryData, boolean z4, int i, Object obj) {
        return categoryHeaderItem.copy((i & 1) != 0 ? categoryHeaderItem.getStringId() : str, (i & 2) != 0 ? categoryHeaderItem.getGridItemType() : gridItemType, (i & 4) != 0 ? categoryHeaderItem.c : str2, (i & 8) != 0 ? categoryHeaderItem.d : z, (i & 16) != 0 ? categoryHeaderItem.e : z2, (i & 32) != 0 ? categoryHeaderItem.f : z3, (i & 64) != 0 ? categoryHeaderItem.g : categoryData, (i & 128) != 0 ? categoryHeaderItem.h : z4);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType component2() {
        return getGridItemType();
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final CategoryData component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    @NotNull
    public final CategoryHeaderItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, boolean z, boolean z2, boolean z3, @NotNull CategoryData categoryData, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(categoryData, "category");
        return new CategoryHeaderItem(str, gridItemType, str2, z, z2, z3, categoryData, z4);
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
        if (!(obj instanceof CategoryHeaderItem)) {
            return false;
        }
        CategoryHeaderItem categoryHeaderItem = (CategoryHeaderItem) obj;
        return Intrinsics.areEqual(getStringId(), categoryHeaderItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), categoryHeaderItem.getGridItemType()) && Intrinsics.areEqual(this.c, categoryHeaderItem.c) && this.d == categoryHeaderItem.d && this.e == categoryHeaderItem.e && this.f == categoryHeaderItem.f && Intrinsics.areEqual(this.g, categoryHeaderItem.g) && this.h == categoryHeaderItem.h;
    }

    @NotNull
    public final CategoryData getCategory() {
        return this.g;
    }

    @Override // com.avito.android.extended_profile.adapter.ExtendedProfileListItem
    @NotNull
    public ExtendedProfileSpanLookup.GridItemType getGridItemType() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ExtendedProfileListItem.DefaultImpls.getId(this);
    }

    public final boolean getShowAnimation() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        ExtendedProfileSpanLookup.GridItemType gridItemType = getGridItemType();
        int hashCode2 = (hashCode + (gridItemType != null ? gridItemType.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        boolean z2 = this.e;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        boolean z3 = this.f;
        if (z3) {
            z3 = true;
        }
        int i11 = z3 ? 1 : 0;
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = (i10 + i11) * 31;
        CategoryData categoryData = this.g;
        if (categoryData != null) {
            i = categoryData.hashCode();
        }
        int i15 = (i14 + i) * 31;
        boolean z4 = this.h;
        if (!z4) {
            i2 = z4 ? 1 : 0;
        }
        return i15 + i2;
    }

    public final boolean isCollapsed() {
        return this.d;
    }

    public final boolean isCollapsible() {
        return this.e;
    }

    public final boolean isLoading() {
        return this.f;
    }

    public final void setShowAnimation(boolean z) {
        this.h = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryHeaderItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", title=");
        L.append(this.c);
        L.append(", isCollapsed=");
        L.append(this.d);
        L.append(", isCollapsible=");
        L.append(this.e);
        L.append(", isLoading=");
        L.append(this.f);
        L.append(", category=");
        L.append(this.g);
        L.append(", showAnimation=");
        return a.B(L, this.h, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f ? 1 : 0);
        this.g.writeToParcel(parcel, 0);
        parcel.writeInt(this.h ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryHeaderItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, boolean z, boolean z2, boolean z3, CategoryData categoryData, boolean z4, int i, j jVar) {
        this((i & 1) != 0 ? "category_header_item" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, str2, z, z2, (i & 32) != 0 ? false : z3, categoryData, (i & 128) != 0 ? false : z4);
    }
}
