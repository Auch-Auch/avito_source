package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J>\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b\"\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceVideoGalleryElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "image", "title", "description", "videoUrl", "copy", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/remote/model/BrandspaceVideoGalleryElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getVideoUrl", "Lcom/avito/android/remote/model/Image;", "getImage", "getTitle", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceVideoGalleryElement implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceVideoGalleryElement> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("videoUrl")
    @Nullable
    private final String videoUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceVideoGalleryElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceVideoGalleryElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceVideoGalleryElement((Image) parcel.readParcelable(BrandspaceVideoGalleryElement.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceVideoGalleryElement[] newArray(int i) {
            return new BrandspaceVideoGalleryElement[i];
        }
    }

    public BrandspaceVideoGalleryElement(@NotNull Image image2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(image2, "image");
        this.image = image2;
        this.title = str;
        this.description = str2;
        this.videoUrl = str3;
    }

    public static /* synthetic */ BrandspaceVideoGalleryElement copy$default(BrandspaceVideoGalleryElement brandspaceVideoGalleryElement, Image image2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            image2 = brandspaceVideoGalleryElement.image;
        }
        if ((i & 2) != 0) {
            str = brandspaceVideoGalleryElement.title;
        }
        if ((i & 4) != 0) {
            str2 = brandspaceVideoGalleryElement.description;
        }
        if ((i & 8) != 0) {
            str3 = brandspaceVideoGalleryElement.videoUrl;
        }
        return brandspaceVideoGalleryElement.copy(image2, str, str2, str3);
    }

    @NotNull
    public final Image component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.videoUrl;
    }

    @NotNull
    public final BrandspaceVideoGalleryElement copy(@NotNull Image image2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(image2, "image");
        return new BrandspaceVideoGalleryElement(image2, str, str2, str3);
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
        if (!(obj instanceof BrandspaceVideoGalleryElement)) {
            return false;
        }
        BrandspaceVideoGalleryElement brandspaceVideoGalleryElement = (BrandspaceVideoGalleryElement) obj;
        return Intrinsics.areEqual(this.image, brandspaceVideoGalleryElement.image) && Intrinsics.areEqual(this.title, brandspaceVideoGalleryElement.title) && Intrinsics.areEqual(this.description, brandspaceVideoGalleryElement.description) && Intrinsics.areEqual(this.videoUrl, brandspaceVideoGalleryElement.videoUrl);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Image image2 = this.image;
        int i = 0;
        int hashCode = (image2 != null ? image2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.videoUrl;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceVideoGalleryElement(image=");
        L.append(this.image);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", videoUrl=");
        return a.t(L, this.videoUrl, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.videoUrl);
    }
}
