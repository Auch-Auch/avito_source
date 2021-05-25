package com.avito.android.photo_picker;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000eR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00104\u001a\u0004\b7\u0010\n¨\u0006:"}, d2 = {"Lcom/avito/android/photo_picker/SelectedPhoto;", "Landroid/os/Parcelable;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "component2", "()Lcom/avito/android/photo_picker/legacy/PhotoSource;", "", "component3", "()Ljava/lang/String;", "component4", "Lcom/avito/android/krop/util/Transformation;", "component5", "()Lcom/avito/android/krop/util/Transformation;", "component6", ShareConstants.MEDIA_URI, "source", "id", "originalUri", "state", "uploadId", "copy", "(Landroid/net/Uri;Lcom/avito/android/photo_picker/legacy/PhotoSource;Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;Ljava/lang/String;)Lcom/avito/android/photo_picker/SelectedPhoto;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "getSource", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "e", "Lcom/avito/android/krop/util/Transformation;", "getState", "d", "getOriginalUri", "f", "Ljava/lang/String;", "getUploadId", "c", "getId", "<init>", "(Landroid/net/Uri;Lcom/avito/android/photo_picker/legacy/PhotoSource;Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SelectedPhoto implements Parcelable {
    public static final Parcelable.Creator<SelectedPhoto> CREATOR = new Creator();
    @NotNull
    public final Uri a;
    @NotNull
    public final PhotoSource b;
    @NotNull
    public final String c;
    @Nullable
    public final Uri d;
    @Nullable
    public final Transformation e;
    @Nullable
    public final String f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SelectedPhoto> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectedPhoto createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SelectedPhoto((Uri) parcel.readParcelable(SelectedPhoto.class.getClassLoader()), (PhotoSource) Enum.valueOf(PhotoSource.class, parcel.readString()), parcel.readString(), (Uri) parcel.readParcelable(SelectedPhoto.class.getClassLoader()), (Transformation) parcel.readParcelable(SelectedPhoto.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectedPhoto[] newArray(int i) {
            return new SelectedPhoto[i];
        }
    }

    public SelectedPhoto(@NotNull Uri uri, @NotNull PhotoSource photoSource, @NotNull String str, @Nullable Uri uri2, @Nullable Transformation transformation, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(photoSource, "source");
        Intrinsics.checkNotNullParameter(str, "id");
        this.a = uri;
        this.b = photoSource;
        this.c = str;
        this.d = uri2;
        this.e = transformation;
        this.f = str2;
    }

    public static /* synthetic */ SelectedPhoto copy$default(SelectedPhoto selectedPhoto, Uri uri, PhotoSource photoSource, String str, Uri uri2, Transformation transformation, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = selectedPhoto.a;
        }
        if ((i & 2) != 0) {
            photoSource = selectedPhoto.b;
        }
        if ((i & 4) != 0) {
            str = selectedPhoto.c;
        }
        if ((i & 8) != 0) {
            uri2 = selectedPhoto.d;
        }
        if ((i & 16) != 0) {
            transformation = selectedPhoto.e;
        }
        if ((i & 32) != 0) {
            str2 = selectedPhoto.f;
        }
        return selectedPhoto.copy(uri, photoSource, str, uri2, transformation, str2);
    }

    @NotNull
    public final Uri component1() {
        return this.a;
    }

    @NotNull
    public final PhotoSource component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Uri component4() {
        return this.d;
    }

    @Nullable
    public final Transformation component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final SelectedPhoto copy(@NotNull Uri uri, @NotNull PhotoSource photoSource, @NotNull String str, @Nullable Uri uri2, @Nullable Transformation transformation, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(photoSource, "source");
        Intrinsics.checkNotNullParameter(str, "id");
        return new SelectedPhoto(uri, photoSource, str, uri2, transformation, str2);
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
        if (!(obj instanceof SelectedPhoto)) {
            return false;
        }
        SelectedPhoto selectedPhoto = (SelectedPhoto) obj;
        return Intrinsics.areEqual(this.a, selectedPhoto.a) && Intrinsics.areEqual(this.b, selectedPhoto.b) && Intrinsics.areEqual(this.c, selectedPhoto.c) && Intrinsics.areEqual(this.d, selectedPhoto.d) && Intrinsics.areEqual(this.e, selectedPhoto.e) && Intrinsics.areEqual(this.f, selectedPhoto.f);
    }

    @NotNull
    public final String getId() {
        return this.c;
    }

    @Nullable
    public final Uri getOriginalUri() {
        return this.d;
    }

    @NotNull
    public final PhotoSource getSource() {
        return this.b;
    }

    @Nullable
    public final Transformation getState() {
        return this.e;
    }

    @Nullable
    public final String getUploadId() {
        return this.f;
    }

    @NotNull
    public final Uri getUri() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Uri uri = this.a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        PhotoSource photoSource = this.b;
        int hashCode2 = (hashCode + (photoSource != null ? photoSource.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Uri uri2 = this.d;
        int hashCode4 = (hashCode3 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Transformation transformation = this.e;
        int hashCode5 = (hashCode4 + (transformation != null ? transformation.hashCode() : 0)) * 31;
        String str2 = this.f;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectedPhoto(uri=");
        L.append(this.a);
        L.append(", source=");
        L.append(this.b);
        L.append(", id=");
        L.append(this.c);
        L.append(", originalUri=");
        L.append(this.d);
        L.append(", state=");
        L.append(this.e);
        L.append(", uploadId=");
        return a.t(L, this.f, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeString(this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectedPhoto(Uri uri, PhotoSource photoSource, String str, Uri uri2, Transformation transformation, String str2, int i, j jVar) {
        this(uri, photoSource, str, (i & 8) != 0 ? null : uri2, (i & 16) != 0 ? null : transformation, (i & 32) != 0 ? null : str2);
    }
}
