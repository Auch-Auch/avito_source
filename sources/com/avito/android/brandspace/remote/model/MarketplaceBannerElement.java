package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\f¨\u00062"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceBannerElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/UniversalColor;", "component6", "()Lcom/avito/android/remote/model/UniversalColor;", "version", "title", "description", "uptitle", "image", "bgColor", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/brandspace/remote/model/MarketplaceBannerElement;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUptitle", "getTitle", "Lcom/avito/android/remote/model/UniversalColor;", "getBgColor", "getDescription", "I", "getVersion", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/UniversalColor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceBannerElement implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceBannerElement> CREATOR = new Creator();
    @NotNull
    private final UniversalColor bgColor;
    @Nullable
    private final String description;
    @NotNull
    private final Image image;
    @Nullable
    private final String title;
    @Nullable
    private final String uptitle;
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceBannerElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceBannerElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceBannerElement(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(MarketplaceBannerElement.class.getClassLoader()), (UniversalColor) parcel.readParcelable(MarketplaceBannerElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceBannerElement[] newArray(int i) {
            return new MarketplaceBannerElement[i];
        }
    }

    public MarketplaceBannerElement(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Image image2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(universalColor, "bgColor");
        this.version = i;
        this.title = str;
        this.description = str2;
        this.uptitle = str3;
        this.image = image2;
        this.bgColor = universalColor;
    }

    public static /* synthetic */ MarketplaceBannerElement copy$default(MarketplaceBannerElement marketplaceBannerElement, int i, String str, String str2, String str3, Image image2, UniversalColor universalColor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = marketplaceBannerElement.version;
        }
        if ((i2 & 2) != 0) {
            str = marketplaceBannerElement.title;
        }
        if ((i2 & 4) != 0) {
            str2 = marketplaceBannerElement.description;
        }
        if ((i2 & 8) != 0) {
            str3 = marketplaceBannerElement.uptitle;
        }
        if ((i2 & 16) != 0) {
            image2 = marketplaceBannerElement.image;
        }
        if ((i2 & 32) != 0) {
            universalColor = marketplaceBannerElement.bgColor;
        }
        return marketplaceBannerElement.copy(i, str, str2, str3, image2, universalColor);
    }

    public final int component1() {
        return this.version;
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
        return this.uptitle;
    }

    @NotNull
    public final Image component5() {
        return this.image;
    }

    @NotNull
    public final UniversalColor component6() {
        return this.bgColor;
    }

    @NotNull
    public final MarketplaceBannerElement copy(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Image image2, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(universalColor, "bgColor");
        return new MarketplaceBannerElement(i, str, str2, str3, image2, universalColor);
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
        if (!(obj instanceof MarketplaceBannerElement)) {
            return false;
        }
        MarketplaceBannerElement marketplaceBannerElement = (MarketplaceBannerElement) obj;
        return this.version == marketplaceBannerElement.version && Intrinsics.areEqual(this.title, marketplaceBannerElement.title) && Intrinsics.areEqual(this.description, marketplaceBannerElement.description) && Intrinsics.areEqual(this.uptitle, marketplaceBannerElement.uptitle) && Intrinsics.areEqual(this.image, marketplaceBannerElement.image) && Intrinsics.areEqual(this.bgColor, marketplaceBannerElement.bgColor);
    }

    @NotNull
    public final UniversalColor getBgColor() {
        return this.bgColor;
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
    public final String getUptitle() {
        return this.uptitle;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uptitle;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
        UniversalColor universalColor = this.bgColor;
        if (universalColor != null) {
            i2 = universalColor.hashCode();
        }
        return hashCode4 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceBannerElement(version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", uptitle=");
        L.append(this.uptitle);
        L.append(", image=");
        L.append(this.image);
        L.append(", bgColor=");
        L.append(this.bgColor);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.uptitle);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.bgColor, i);
    }
}
