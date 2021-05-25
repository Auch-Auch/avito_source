package com.avito.android.developments_catalog.items.photoGallery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.developments_catalog.DevelopmentsCatalogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.ParcelableItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "c", "J", "getStateId", "()J", "stateId", "", "Lcom/avito/android/remote/model/Image;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", AuthSource.BOOKING_ORDER, "I", "getCurrentPosition", "setCurrentPosition", "(I)V", "currentPosition", "<init>", "(Ljava/util/List;IJLjava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryItem implements ParcelableItem {
    public static final Parcelable.Creator<PhotoGalleryItem> CREATOR = new Creator();
    @Nullable
    public final List<Image> a;
    public int b;
    public final long c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhotoGalleryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoGalleryItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Image) parcel.readParcelable(PhotoGalleryItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new PhotoGalleryItem(arrayList, parcel.readInt(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoGalleryItem[] newArray(int i) {
            return new PhotoGalleryItem[i];
        }
    }

    public PhotoGalleryItem(@Nullable List<Image> list, int i, long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = list;
        this.b = i;
        this.c = j;
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getCurrentPosition() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final List<Image> getImages() {
        return this.a;
    }

    public final long getStateId() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    public final void setCurrentPosition(int i) {
        this.b = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Image> list = this.a;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Image) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoGalleryItem(List list, int i, long j, String str, int i2, j jVar) {
        this(list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0 : j, (i2 & 8) != 0 ? DevelopmentsCatalogItem.ITEM_GALLERY.toString() : str);
    }
}
