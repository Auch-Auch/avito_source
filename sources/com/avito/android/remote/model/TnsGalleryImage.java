package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/TnsGalleryImage;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Size;", "component2", "()Lcom/avito/android/remote/model/Size;", "image", "originalSize", "copy", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Size;)Lcom/avito/android/remote/model/TnsGalleryImage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Lcom/avito/android/remote/model/Size;", "getOriginalSize", "<init>", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Size;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryImage implements Parcelable {
    public static final Parcelable.Creator<TnsGalleryImage> CREATOR = new Creator();
    @NotNull
    private final Image image;
    @Nullable
    private final Size originalSize;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TnsGalleryImage> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TnsGalleryImage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TnsGalleryImage((Image) parcel.readParcelable(TnsGalleryImage.class.getClassLoader()), (Size) parcel.readParcelable(TnsGalleryImage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TnsGalleryImage[] newArray(int i) {
            return new TnsGalleryImage[i];
        }
    }

    public TnsGalleryImage(@NotNull Image image2, @Nullable Size size) {
        Intrinsics.checkNotNullParameter(image2, "image");
        this.image = image2;
        this.originalSize = size;
    }

    public static /* synthetic */ TnsGalleryImage copy$default(TnsGalleryImage tnsGalleryImage, Image image2, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = tnsGalleryImage.image;
        }
        if ((i & 2) != 0) {
            size = tnsGalleryImage.originalSize;
        }
        return tnsGalleryImage.copy(image2, size);
    }

    @NotNull
    public final Image component1() {
        return this.image;
    }

    @Nullable
    public final Size component2() {
        return this.originalSize;
    }

    @NotNull
    public final TnsGalleryImage copy(@NotNull Image image2, @Nullable Size size) {
        Intrinsics.checkNotNullParameter(image2, "image");
        return new TnsGalleryImage(image2, size);
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
        if (!(obj instanceof TnsGalleryImage)) {
            return false;
        }
        TnsGalleryImage tnsGalleryImage = (TnsGalleryImage) obj;
        return Intrinsics.areEqual(this.image, tnsGalleryImage.image) && Intrinsics.areEqual(this.originalSize, tnsGalleryImage.originalSize);
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final Size getOriginalSize() {
        return this.originalSize;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Image image2 = this.image;
        int i = 0;
        int hashCode = (image2 != null ? image2.hashCode() : 0) * 31;
        Size size = this.originalSize;
        if (size != null) {
            i = size.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TnsGalleryImage(image=");
        L.append(this.image);
        L.append(", originalSize=");
        L.append(this.originalSize);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.originalSize, i);
    }
}
