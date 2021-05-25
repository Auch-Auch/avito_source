package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\u0004R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceProductComparisonElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "component3", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceProductComparisonProperty;", "component4", "()Ljava/util/List;", "title", "image", "description", "properties", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/brandspace/remote/model/BrandspaceProductComparisonElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getProperties", "getDescription", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceProductComparisonElement implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceProductComparisonElement> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("properties")
    @NotNull
    private final List<BrandspaceProductComparisonProperty> properties;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceProductComparisonElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceProductComparisonElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            Image image = (Image) parcel.readParcelable(BrandspaceProductComparisonElement.class.getClassLoader());
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(BrandspaceProductComparisonProperty.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new BrandspaceProductComparisonElement(readString, image, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceProductComparisonElement[] newArray(int i) {
            return new BrandspaceProductComparisonElement[i];
        }
    }

    public BrandspaceProductComparisonElement(@Nullable String str, @Nullable Image image2, @Nullable String str2, @NotNull List<BrandspaceProductComparisonProperty> list) {
        Intrinsics.checkNotNullParameter(list, "properties");
        this.title = str;
        this.image = image2;
        this.description = str2;
        this.properties = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.BrandspaceProductComparisonElement */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceProductComparisonElement copy$default(BrandspaceProductComparisonElement brandspaceProductComparisonElement, String str, Image image2, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandspaceProductComparisonElement.title;
        }
        if ((i & 2) != 0) {
            image2 = brandspaceProductComparisonElement.image;
        }
        if ((i & 4) != 0) {
            str2 = brandspaceProductComparisonElement.description;
        }
        if ((i & 8) != 0) {
            list = brandspaceProductComparisonElement.properties;
        }
        return brandspaceProductComparisonElement.copy(str, image2, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Image component2() {
        return this.image;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final List<BrandspaceProductComparisonProperty> component4() {
        return this.properties;
    }

    @NotNull
    public final BrandspaceProductComparisonElement copy(@Nullable String str, @Nullable Image image2, @Nullable String str2, @NotNull List<BrandspaceProductComparisonProperty> list) {
        Intrinsics.checkNotNullParameter(list, "properties");
        return new BrandspaceProductComparisonElement(str, image2, str2, list);
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
        if (!(obj instanceof BrandspaceProductComparisonElement)) {
            return false;
        }
        BrandspaceProductComparisonElement brandspaceProductComparisonElement = (BrandspaceProductComparisonElement) obj;
        return Intrinsics.areEqual(this.title, brandspaceProductComparisonElement.title) && Intrinsics.areEqual(this.image, brandspaceProductComparisonElement.image) && Intrinsics.areEqual(this.description, brandspaceProductComparisonElement.description) && Intrinsics.areEqual(this.properties, brandspaceProductComparisonElement.properties);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final List<BrandspaceProductComparisonProperty> getProperties() {
        return this.properties;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Image image2 = this.image;
        int hashCode2 = (hashCode + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<BrandspaceProductComparisonProperty> list = this.properties;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceProductComparisonElement(title=");
        L.append(this.title);
        L.append(", image=");
        L.append(this.image);
        L.append(", description=");
        L.append(this.description);
        L.append(", properties=");
        return a.w(L, this.properties, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.description);
        Iterator n0 = a.n0(this.properties, parcel);
        while (n0.hasNext()) {
            ((BrandspaceProductComparisonProperty) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
