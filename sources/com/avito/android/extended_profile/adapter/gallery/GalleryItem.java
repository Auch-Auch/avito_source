package com.avito.android.extended_profile.adapter.gallery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TnsGalleryImage;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0007¨\u00060"}, d2 = {"Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component3", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "component4", "()Ljava/util/List;", "stringId", "gridItemType", "title", "images", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/extended_profile/adapter/gallery/GalleryItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/util/List;", "getImages", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;Ljava/util/List;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<GalleryItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @Nullable
    public final String c;
    @Nullable
    public final List<TnsGalleryImage> d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GalleryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GalleryItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            ExtendedProfileSpanLookup.GridItemType gridItemType = (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString());
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((TnsGalleryImage) parcel.readParcelable(GalleryItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new GalleryItem(readString, gridItemType, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GalleryItem[] newArray(int i) {
            return new GalleryItem[i];
        }
    }

    public GalleryItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        this.a = str;
        this.b = gridItemType;
        this.c = str2;
        this.d = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.extended_profile.adapter.gallery.GalleryItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GalleryItem copy$default(GalleryItem galleryItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = galleryItem.getStringId();
        }
        if ((i & 2) != 0) {
            gridItemType = galleryItem.getGridItemType();
        }
        if ((i & 4) != 0) {
            str2 = galleryItem.c;
        }
        if ((i & 8) != 0) {
            list = galleryItem.d;
        }
        return galleryItem.copy(str, gridItemType, str2, list);
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

    @Nullable
    public final List<TnsGalleryImage> component4() {
        return this.d;
    }

    @NotNull
    public final GalleryItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @Nullable String str2, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        return new GalleryItem(str, gridItemType, str2, list);
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
        if (!(obj instanceof GalleryItem)) {
            return false;
        }
        GalleryItem galleryItem = (GalleryItem) obj;
        return Intrinsics.areEqual(getStringId(), galleryItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), galleryItem.getGridItemType()) && Intrinsics.areEqual(this.c, galleryItem.c) && Intrinsics.areEqual(this.d, galleryItem.d);
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

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.d;
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
        List<TnsGalleryImage> list = this.d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("GalleryItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", title=");
        L.append(this.c);
        L.append(", images=");
        return a.w(L, this.d, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        List<TnsGalleryImage> list = this.d;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((TnsGalleryImage) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GalleryItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, List list, int i, j jVar) {
        this((i & 1) != 0 ? "gallery_item" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, str2, (i & 8) != 0 ? null : list);
    }
}
