package com.avito.android.photo_picker.legacy;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\nJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*R\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010/R$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u00103R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b8\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b<\u0010\u0007¨\u0006?"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "", "component3", "()I", "component4", "component5", "component6", "component7", "id", "source", VKApiConst.POSITION, "from", "thumbnail", ShareConstants.MEDIA_URI, "uploadId", "copy", "(Ljava/lang/String;Landroid/net/Uri;IILandroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getSource", "isLoaded", "()Z", "c", "I", "getPosition", "setPosition", "(I)V", "f", "getUri", "setUri", "(Landroid/net/Uri;)V", g.a, "Ljava/lang/String;", "getUploadId", "d", "getFrom", AuthSource.SEND_ABUSE, "getId", "e", "getThumbnail", "<init>", "(Ljava/lang/String;Landroid/net/Uri;IILandroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PickerPhoto implements Parcelable {
    public static final Parcelable.Creator<PickerPhoto> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final Uri b;
    public int c;
    public final int d;
    @Nullable
    public final Uri e;
    @Nullable
    public Uri f;
    @Nullable
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PickerPhoto> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PickerPhoto createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PickerPhoto(parcel.readString(), (Uri) parcel.readParcelable(PickerPhoto.class.getClassLoader()), parcel.readInt(), parcel.readInt(), (Uri) parcel.readParcelable(PickerPhoto.class.getClassLoader()), (Uri) parcel.readParcelable(PickerPhoto.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PickerPhoto[] newArray(int i) {
            return new PickerPhoto[i];
        }
    }

    public PickerPhoto(@NotNull String str, @NotNull Uri uri, int i, int i2, @Nullable Uri uri2, @Nullable Uri uri3, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, "source");
        this.a = str;
        this.b = uri;
        this.c = i;
        this.d = i2;
        this.e = uri2;
        this.f = uri3;
        this.g = str2;
    }

    public static /* synthetic */ PickerPhoto copy$default(PickerPhoto pickerPhoto, String str, Uri uri, int i, int i2, Uri uri2, Uri uri3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pickerPhoto.a;
        }
        if ((i3 & 2) != 0) {
            uri = pickerPhoto.b;
        }
        if ((i3 & 4) != 0) {
            i = pickerPhoto.c;
        }
        if ((i3 & 8) != 0) {
            i2 = pickerPhoto.d;
        }
        if ((i3 & 16) != 0) {
            uri2 = pickerPhoto.e;
        }
        if ((i3 & 32) != 0) {
            uri3 = pickerPhoto.f;
        }
        if ((i3 & 64) != 0) {
            str2 = pickerPhoto.g;
        }
        return pickerPhoto.copy(str, uri, i, i2, uri2, uri3, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final Uri component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @Nullable
    public final Uri component5() {
        return this.e;
    }

    @Nullable
    public final Uri component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final PickerPhoto copy(@NotNull String str, @NotNull Uri uri, int i, int i2, @Nullable Uri uri2, @Nullable Uri uri3, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, "source");
        return new PickerPhoto(str, uri, i, i2, uri2, uri3, str2);
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
        if (!(obj instanceof PickerPhoto)) {
            return false;
        }
        PickerPhoto pickerPhoto = (PickerPhoto) obj;
        return Intrinsics.areEqual(this.a, pickerPhoto.a) && Intrinsics.areEqual(this.b, pickerPhoto.b) && this.c == pickerPhoto.c && this.d == pickerPhoto.d && Intrinsics.areEqual(this.e, pickerPhoto.e) && Intrinsics.areEqual(this.f, pickerPhoto.f) && Intrinsics.areEqual(this.g, pickerPhoto.g);
    }

    public final int getFrom() {
        return this.d;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    public final int getPosition() {
        return this.c;
    }

    @NotNull
    public final Uri getSource() {
        return this.b;
    }

    @Nullable
    public final Uri getThumbnail() {
        return this.e;
    }

    @Nullable
    public final String getUploadId() {
        return this.g;
    }

    @Nullable
    public final Uri getUri() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Uri uri = this.b;
        int hashCode2 = (((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.c) * 31) + this.d) * 31;
        Uri uri2 = this.e;
        int hashCode3 = (hashCode2 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Uri uri3 = this.f;
        int hashCode4 = (hashCode3 + (uri3 != null ? uri3.hashCode() : 0)) * 31;
        String str2 = this.g;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public final boolean isLoaded() {
        return this.f != null;
    }

    public final void setPosition(int i) {
        this.c = i;
    }

    public final void setUri(@Nullable Uri uri) {
        this.f = uri;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PickerPhoto(id=");
        L.append(this.a);
        L.append(", source=");
        L.append(this.b);
        L.append(", position=");
        L.append(this.c);
        L.append(", from=");
        L.append(this.d);
        L.append(", thumbnail=");
        L.append(this.e);
        L.append(", uri=");
        L.append(this.f);
        L.append(", uploadId=");
        return a.t(L, this.g, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeString(this.g);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PickerPhoto(String str, Uri uri, int i, int i2, Uri uri2, Uri uri3, String str2, int i3, j jVar) {
        this(str, uri, i, i2, (i3 & 16) != 0 ? null : uri2, (i3 & 32) != 0 ? null : uri3, (i3 & 64) != 0 ? null : str2);
    }
}
