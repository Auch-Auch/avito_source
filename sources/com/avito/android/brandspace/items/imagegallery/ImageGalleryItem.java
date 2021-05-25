package com.avito.android.brandspace.items.imagegallery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\"\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010)R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\n¨\u0006/"}, d2 = {"Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "id", "type", "image", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/brandspace/items/imagegallery/ImageGalleryItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ImageGalleryItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<ImageGalleryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final Image c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ImageGalleryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageGalleryItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ImageGalleryItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(ImageGalleryItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageGalleryItem[] newArray(int i) {
            return new ImageGalleryItem[i];
        }
    }

    public ImageGalleryItem(long j, @NotNull BlockType blockType, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        this.a = j;
        this.b = blockType;
        this.c = image;
    }

    public static /* synthetic */ ImageGalleryItem copy$default(ImageGalleryItem imageGalleryItem, long j, BlockType blockType, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            j = imageGalleryItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = imageGalleryItem.getType();
        }
        if ((i & 4) != 0) {
            image = imageGalleryItem.c;
        }
        return imageGalleryItem.copy(j, blockType, image);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final Image component3() {
        return this.c;
    }

    @NotNull
    public final ImageGalleryItem copy(long j, @NotNull BlockType blockType, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        return new ImageGalleryItem(j, blockType, image);
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
        if (!(obj instanceof ImageGalleryItem)) {
            return false;
        }
        ImageGalleryItem imageGalleryItem = (ImageGalleryItem) obj;
        return getId() == imageGalleryItem.getId() && Intrinsics.areEqual(getType(), imageGalleryItem.getType()) && Intrinsics.areEqual(this.c, imageGalleryItem.c);
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Image getImage() {
        return this.c;
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
        Image image = this.c;
        if (image != null) {
            i = image.hashCode();
        }
        return hashCode + i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ImageGalleryItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", image=");
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
