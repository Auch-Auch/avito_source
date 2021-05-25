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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\tJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\u0011\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/ImageUploadResult;", "Lcom/avito/android/remote/model/ImageUpload;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "uploadId", "image", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/ImageUploadResult;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUploadId", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadResult extends ImageUpload {
    public static final Parcelable.Creator<ImageUploadResult> CREATOR = new Creator();
    @NotNull
    private final Image image;
    @NotNull
    private final String uploadId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ImageUploadResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageUploadResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ImageUploadResult(parcel.readString(), (Image) parcel.readParcelable(ImageUploadResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageUploadResult[] newArray(int i) {
            return new ImageUploadResult[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageUploadResult(@NotNull String str, @NotNull Image image2) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(image2, "image");
        this.uploadId = str;
        this.image = image2;
    }

    public static /* synthetic */ ImageUploadResult copy$default(ImageUploadResult imageUploadResult, String str, Image image2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageUploadResult.uploadId;
        }
        if ((i & 2) != 0) {
            image2 = imageUploadResult.image;
        }
        return imageUploadResult.copy(str, image2);
    }

    @NotNull
    public final String component1() {
        return this.uploadId;
    }

    @NotNull
    public final Image component2() {
        return this.image;
    }

    @NotNull
    public final ImageUploadResult copy(@NotNull String str, @NotNull Image image2) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(image2, "image");
        return new ImageUploadResult(str, image2);
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
        return (obj instanceof ImageUploadResult) && !(Intrinsics.areEqual(this.uploadId, ((ImageUploadResult) obj).uploadId) ^ true);
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getUploadId() {
        return this.uploadId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.uploadId.hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ImageUploadResult(uploadId=");
        L.append(this.uploadId);
        L.append(", image=");
        L.append(this.image);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uploadId);
        parcel.writeParcelable(this.image, i);
    }
}
