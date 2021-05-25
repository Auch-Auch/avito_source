package com.avito.android.remote;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/ApartmentNumberRequestLink;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/ApartmentNumberRequestLink;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "domoteka_release"}, k = 1, mv = {1, 4, 2})
public final class ApartmentNumberRequestLink implements Parcelable {
    public static final Parcelable.Creator<ApartmentNumberRequestLink> CREATOR = new Creator();
    @SerializedName("link")
    @NotNull
    private final DeepLink link;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ApartmentNumberRequestLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ApartmentNumberRequestLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ApartmentNumberRequestLink((DeepLink) parcel.readParcelable(ApartmentNumberRequestLink.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ApartmentNumberRequestLink[] newArray(int i) {
            return new ApartmentNumberRequestLink[i];
        }
    }

    public ApartmentNumberRequestLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        this.link = deepLink;
    }

    public static /* synthetic */ ApartmentNumberRequestLink copy$default(ApartmentNumberRequestLink apartmentNumberRequestLink, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            deepLink = apartmentNumberRequestLink.link;
        }
        return apartmentNumberRequestLink.copy(deepLink);
    }

    @NotNull
    public final DeepLink component1() {
        return this.link;
    }

    @NotNull
    public final ApartmentNumberRequestLink copy(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        return new ApartmentNumberRequestLink(deepLink);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ApartmentNumberRequestLink) && Intrinsics.areEqual(this.link, ((ApartmentNumberRequestLink) obj).link);
        }
        return true;
    }

    @NotNull
    public final DeepLink getLink() {
        return this.link;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DeepLink deepLink = this.link;
        if (deepLink != null) {
            return deepLink.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.m(a.L("ApartmentNumberRequestLink(link="), this.link, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.link, i);
    }
}
