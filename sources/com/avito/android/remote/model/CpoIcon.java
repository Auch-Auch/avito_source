package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b#\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/CpoIcon;", "Landroid/os/Parcelable;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "component2", "component3", "component4", "x1ScaledLogo", "x2ScaledLogo", "x3ScaledLogo", "x4ScaledLogo", "copy", "(Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;)Lcom/avito/android/remote/model/CpoIcon;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "getX2ScaledLogo", "getX4ScaledLogo", "getX1ScaledLogo", "getX3ScaledLogo", "<init>", "(Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class CpoIcon implements Parcelable {
    public static final Parcelable.Creator<CpoIcon> CREATOR = new Creator();
    @SerializedName("210x48")
    @NotNull
    private final Uri x1ScaledLogo;
    @SerializedName("420x96")
    @NotNull
    private final Uri x2ScaledLogo;
    @SerializedName("630x144")
    @NotNull
    private final Uri x3ScaledLogo;
    @SerializedName("840x192")
    @NotNull
    private final Uri x4ScaledLogo;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CpoIcon> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpoIcon createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CpoIcon((Uri) parcel.readParcelable(CpoIcon.class.getClassLoader()), (Uri) parcel.readParcelable(CpoIcon.class.getClassLoader()), (Uri) parcel.readParcelable(CpoIcon.class.getClassLoader()), (Uri) parcel.readParcelable(CpoIcon.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpoIcon[] newArray(int i) {
            return new CpoIcon[i];
        }
    }

    public CpoIcon(@NotNull Uri uri, @NotNull Uri uri2, @NotNull Uri uri3, @NotNull Uri uri4) {
        Intrinsics.checkNotNullParameter(uri, "x1ScaledLogo");
        Intrinsics.checkNotNullParameter(uri2, "x2ScaledLogo");
        Intrinsics.checkNotNullParameter(uri3, "x3ScaledLogo");
        Intrinsics.checkNotNullParameter(uri4, "x4ScaledLogo");
        this.x1ScaledLogo = uri;
        this.x2ScaledLogo = uri2;
        this.x3ScaledLogo = uri3;
        this.x4ScaledLogo = uri4;
    }

    public static /* synthetic */ CpoIcon copy$default(CpoIcon cpoIcon, Uri uri, Uri uri2, Uri uri3, Uri uri4, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = cpoIcon.x1ScaledLogo;
        }
        if ((i & 2) != 0) {
            uri2 = cpoIcon.x2ScaledLogo;
        }
        if ((i & 4) != 0) {
            uri3 = cpoIcon.x3ScaledLogo;
        }
        if ((i & 8) != 0) {
            uri4 = cpoIcon.x4ScaledLogo;
        }
        return cpoIcon.copy(uri, uri2, uri3, uri4);
    }

    @NotNull
    public final Uri component1() {
        return this.x1ScaledLogo;
    }

    @NotNull
    public final Uri component2() {
        return this.x2ScaledLogo;
    }

    @NotNull
    public final Uri component3() {
        return this.x3ScaledLogo;
    }

    @NotNull
    public final Uri component4() {
        return this.x4ScaledLogo;
    }

    @NotNull
    public final CpoIcon copy(@NotNull Uri uri, @NotNull Uri uri2, @NotNull Uri uri3, @NotNull Uri uri4) {
        Intrinsics.checkNotNullParameter(uri, "x1ScaledLogo");
        Intrinsics.checkNotNullParameter(uri2, "x2ScaledLogo");
        Intrinsics.checkNotNullParameter(uri3, "x3ScaledLogo");
        Intrinsics.checkNotNullParameter(uri4, "x4ScaledLogo");
        return new CpoIcon(uri, uri2, uri3, uri4);
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
        if (!(obj instanceof CpoIcon)) {
            return false;
        }
        CpoIcon cpoIcon = (CpoIcon) obj;
        return Intrinsics.areEqual(this.x1ScaledLogo, cpoIcon.x1ScaledLogo) && Intrinsics.areEqual(this.x2ScaledLogo, cpoIcon.x2ScaledLogo) && Intrinsics.areEqual(this.x3ScaledLogo, cpoIcon.x3ScaledLogo) && Intrinsics.areEqual(this.x4ScaledLogo, cpoIcon.x4ScaledLogo);
    }

    @NotNull
    public final Uri getX1ScaledLogo() {
        return this.x1ScaledLogo;
    }

    @NotNull
    public final Uri getX2ScaledLogo() {
        return this.x2ScaledLogo;
    }

    @NotNull
    public final Uri getX3ScaledLogo() {
        return this.x3ScaledLogo;
    }

    @NotNull
    public final Uri getX4ScaledLogo() {
        return this.x4ScaledLogo;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Uri uri = this.x1ScaledLogo;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.x2ScaledLogo;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Uri uri3 = this.x3ScaledLogo;
        int hashCode3 = (hashCode2 + (uri3 != null ? uri3.hashCode() : 0)) * 31;
        Uri uri4 = this.x4ScaledLogo;
        if (uri4 != null) {
            i = uri4.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CpoIcon(x1ScaledLogo=");
        L.append(this.x1ScaledLogo);
        L.append(", x2ScaledLogo=");
        L.append(this.x2ScaledLogo);
        L.append(", x3ScaledLogo=");
        L.append(this.x3ScaledLogo);
        L.append(", x4ScaledLogo=");
        L.append(this.x4ScaledLogo);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.x1ScaledLogo, i);
        parcel.writeParcelable(this.x2ScaledLogo, i);
        parcel.writeParcelable(this.x3ScaledLogo, i);
        parcel.writeParcelable(this.x4ScaledLogo, i);
    }
}
