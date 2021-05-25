package com.avito.android.extended_profile.adapter.category.category_button;

import a2.b.a.a.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b0\u00101R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b3\u0010\u0004¨\u00066"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component3", "", "component4", "()Z", "Lcom/avito/android/extended_profile/data/CategoryData;", "component5", "()Lcom/avito/android/extended_profile/data/CategoryData;", "stringId", "gridItemType", "title", "isLoading", "category", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;ZLcom/avito/android/extended_profile/data/CategoryData;)Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/extended_profile/data/CategoryData;", "getCategory", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "d", "Z", "setLoading", "(Z)V", "c", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;ZLcom/avito/android/extended_profile/data/CategoryData;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryButtonItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<CategoryButtonItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @Nullable
    public final String c;
    public boolean d;
    @NotNull
    public final CategoryData e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryButtonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryButtonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryButtonItem(parcel.readString(), (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0, CategoryData.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryButtonItem[] newArray(int i) {
            return new CategoryButtonItem[i];
        }
    }

    public CategoryButtonItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, boolean z, @NotNull CategoryData categoryData) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(categoryData, "category");
        this.a = str;
        this.b = gridItemType;
        this.c = str2;
        this.d = z;
        this.e = categoryData;
    }

    public static /* synthetic */ CategoryButtonItem copy$default(CategoryButtonItem categoryButtonItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, boolean z, CategoryData categoryData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryButtonItem.getStringId();
        }
        if ((i & 2) != 0) {
            gridItemType = categoryButtonItem.getGridItemType();
        }
        if ((i & 4) != 0) {
            str2 = categoryButtonItem.c;
        }
        if ((i & 8) != 0) {
            z = categoryButtonItem.d;
        }
        if ((i & 16) != 0) {
            categoryData = categoryButtonItem.e;
        }
        return categoryButtonItem.copy(str, gridItemType, str2, z, categoryData);
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

    @NotNull
    public final CategoryData component5() {
        return this.e;
    }

    @NotNull
    public final CategoryButtonItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, boolean z, @NotNull CategoryData categoryData) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(categoryData, "category");
        return new CategoryButtonItem(str, gridItemType, str2, z, categoryData);
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
        if (!(obj instanceof CategoryButtonItem)) {
            return false;
        }
        CategoryButtonItem categoryButtonItem = (CategoryButtonItem) obj;
        return Intrinsics.areEqual(getStringId(), categoryButtonItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), categoryButtonItem.getGridItemType()) && Intrinsics.areEqual(this.c, categoryButtonItem.c) && this.d == categoryButtonItem.d && Intrinsics.areEqual(this.e, categoryButtonItem.e);
    }

    @NotNull
    public final CategoryData getCategory() {
        return this.e;
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
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        CategoryData categoryData = this.e;
        if (categoryData != null) {
            i = categoryData.hashCode();
        }
        return i5 + i;
    }

    public final boolean isLoading() {
        return this.d;
    }

    public final void setLoading(boolean z) {
        this.d = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryButtonItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", title=");
        L.append(this.c);
        L.append(", isLoading=");
        L.append(this.d);
        L.append(", category=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        this.e.writeToParcel(parcel, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryButtonItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, boolean z, CategoryData categoryData, int i, j jVar) {
        this((i & 1) != 0 ? "category_button" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, str2, z, categoryData);
    }
}
