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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0007R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u000eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceAboutModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "", "component3", "()Ljava/lang/String;", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "component4", "()Ljava/util/List;", "version", "image", "title", "paragraphs", "copy", "(ILcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/brandspace/remote/model/BrandspaceAboutModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getVersion", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/util/List;", "getParagraphs", "Ljava/lang/String;", "getTitle", "<init>", "(ILcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAboutModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceAboutModule> CREATOR = new Creator();
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("paragraphs")
    @NotNull
    private final List<BrandspaceAboutParagraphElement> paragraphs;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceAboutModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAboutModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            Image image = (Image) parcel.readParcelable(BrandspaceAboutModule.class.getClassLoader());
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(BrandspaceAboutParagraphElement.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new BrandspaceAboutModule(readInt, image, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAboutModule[] newArray(int i) {
            return new BrandspaceAboutModule[i];
        }
    }

    public BrandspaceAboutModule(int i, @Nullable Image image2, @Nullable String str, @NotNull List<BrandspaceAboutParagraphElement> list) {
        Intrinsics.checkNotNullParameter(list, "paragraphs");
        this.version = i;
        this.image = image2;
        this.title = str;
        this.paragraphs = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.BrandspaceAboutModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceAboutModule copy$default(BrandspaceAboutModule brandspaceAboutModule, int i, Image image2, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brandspaceAboutModule.version;
        }
        if ((i2 & 2) != 0) {
            image2 = brandspaceAboutModule.image;
        }
        if ((i2 & 4) != 0) {
            str = brandspaceAboutModule.title;
        }
        if ((i2 & 8) != 0) {
            list = brandspaceAboutModule.paragraphs;
        }
        return brandspaceAboutModule.copy(i, image2, str, list);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final Image component2() {
        return this.image;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final List<BrandspaceAboutParagraphElement> component4() {
        return this.paragraphs;
    }

    @NotNull
    public final BrandspaceAboutModule copy(int i, @Nullable Image image2, @Nullable String str, @NotNull List<BrandspaceAboutParagraphElement> list) {
        Intrinsics.checkNotNullParameter(list, "paragraphs");
        return new BrandspaceAboutModule(i, image2, str, list);
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
        if (!(obj instanceof BrandspaceAboutModule)) {
            return false;
        }
        BrandspaceAboutModule brandspaceAboutModule = (BrandspaceAboutModule) obj;
        return this.version == brandspaceAboutModule.version && Intrinsics.areEqual(this.image, brandspaceAboutModule.image) && Intrinsics.areEqual(this.title, brandspaceAboutModule.title) && Intrinsics.areEqual(this.paragraphs, brandspaceAboutModule.paragraphs);
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final List<BrandspaceAboutParagraphElement> getParagraphs() {
        return this.paragraphs;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        Image image2 = this.image;
        int i2 = 0;
        int hashCode = (i + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<BrandspaceAboutParagraphElement> list = this.paragraphs;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceAboutModule(version=");
        L.append(this.version);
        L.append(", image=");
        L.append(this.image);
        L.append(", title=");
        L.append(this.title);
        L.append(", paragraphs=");
        return a.w(L, this.paragraphs, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.paragraphs, parcel);
        while (n0.hasNext()) {
            ((BrandspaceAboutParagraphElement) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
