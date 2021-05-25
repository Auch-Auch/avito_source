package com.avito.android.extended_profile.adapter.category.category_advert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004¨\u00064"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "Lcom/avito/android/serp/adapter/AdvertItem;", "component3", "()Lcom/avito/android/serp/adapter/AdvertItem;", "Landroid/os/Parcelable;", "component4", "()Landroid/os/Parcelable;", "stringId", "gridItemType", "advert", "advertGalleryState", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Lcom/avito/android/serp/adapter/AdvertItem;Landroid/os/Parcelable;)Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Landroid/os/Parcelable;", "getAdvertGalleryState", "setAdvertGalleryState", "(Landroid/os/Parcelable;)V", "c", "Lcom/avito/android/serp/adapter/AdvertItem;", "getAdvert", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Lcom/avito/android/serp/adapter/AdvertItem;Landroid/os/Parcelable;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<CategoryAdvertItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @NotNull
    public final AdvertItem c;
    @Nullable
    public Parcelable d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryAdvertItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryAdvertItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryAdvertItem(parcel.readString(), (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString()), (AdvertItem) parcel.readParcelable(CategoryAdvertItem.class.getClassLoader()), parcel.readParcelable(CategoryAdvertItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryAdvertItem[] newArray(int i) {
            return new CategoryAdvertItem[i];
        }
    }

    public CategoryAdvertItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull AdvertItem advertItem, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        this.a = str;
        this.b = gridItemType;
        this.c = advertItem;
        this.d = parcelable;
    }

    public static /* synthetic */ CategoryAdvertItem copy$default(CategoryAdvertItem categoryAdvertItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, AdvertItem advertItem, Parcelable parcelable, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryAdvertItem.getStringId();
        }
        if ((i & 2) != 0) {
            gridItemType = categoryAdvertItem.getGridItemType();
        }
        if ((i & 4) != 0) {
            advertItem = categoryAdvertItem.c;
        }
        if ((i & 8) != 0) {
            parcelable = categoryAdvertItem.d;
        }
        return categoryAdvertItem.copy(str, gridItemType, advertItem, parcelable);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType component2() {
        return getGridItemType();
    }

    @NotNull
    public final AdvertItem component3() {
        return this.c;
    }

    @Nullable
    public final Parcelable component4() {
        return this.d;
    }

    @NotNull
    public final CategoryAdvertItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull AdvertItem advertItem, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        return new CategoryAdvertItem(str, gridItemType, advertItem, parcelable);
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
        if (!(obj instanceof CategoryAdvertItem)) {
            return false;
        }
        CategoryAdvertItem categoryAdvertItem = (CategoryAdvertItem) obj;
        return Intrinsics.areEqual(getStringId(), categoryAdvertItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), categoryAdvertItem.getGridItemType()) && Intrinsics.areEqual(this.c, categoryAdvertItem.c) && Intrinsics.areEqual(this.d, categoryAdvertItem.d);
    }

    @NotNull
    public final AdvertItem getAdvert() {
        return this.c;
    }

    @Nullable
    public final Parcelable getAdvertGalleryState() {
        return this.d;
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

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        ExtendedProfileSpanLookup.GridItemType gridItemType = getGridItemType();
        int hashCode2 = (hashCode + (gridItemType != null ? gridItemType.hashCode() : 0)) * 31;
        AdvertItem advertItem = this.c;
        int hashCode3 = (hashCode2 + (advertItem != null ? advertItem.hashCode() : 0)) * 31;
        Parcelable parcelable = this.d;
        if (parcelable != null) {
            i = parcelable.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setAdvertGalleryState(@Nullable Parcelable parcelable) {
        this.d = parcelable;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryAdvertItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", advert=");
        L.append(this.c);
        L.append(", advertGalleryState=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryAdvertItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, AdvertItem advertItem, Parcelable parcelable, int i, j jVar) {
        this((i & 1) != 0 ? "advert_item" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.SINGLE_SPAN : gridItemType, advertItem, (i & 8) != 0 ? null : parcelable);
    }
}
