package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\fR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b'\u0010\u0004R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\t¨\u0006,"}, d2 = {"Lcom/avito/android/brandspace/remote/model/Brandspace;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "component3", "()Ljava/util/List;", "Lcom/avito/android/brandspace/remote/model/BrandspaceAdjustParameters;", "component4", "()Lcom/avito/android/brandspace/remote/model/BrandspaceAdjustParameters;", "id", "title", MessengerShareContentUtility.ELEMENTS, "adjustParameters", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/brandspace/remote/model/BrandspaceAdjustParameters;)Lcom/avito/android/brandspace/remote/model/Brandspace;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/brandspace/remote/model/BrandspaceAdjustParameters;", "getAdjustParameters", "getId", "Ljava/util/List;", "getElements", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/brandspace/remote/model/BrandspaceAdjustParameters;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class Brandspace implements Parcelable {
    public static final Parcelable.Creator<Brandspace> CREATOR = new Creator();
    @SerializedName("adjustParams")
    @Nullable
    private final BrandspaceAdjustParameters adjustParameters;
    @SerializedName("items")
    @Nullable
    private final List<BrandspaceElement> elements;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Brandspace> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Brandspace createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            BrandspaceAdjustParameters brandspaceAdjustParameters = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BrandspaceElement) parcel.readParcelable(Brandspace.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                brandspaceAdjustParameters = BrandspaceAdjustParameters.CREATOR.createFromParcel(parcel);
            }
            return new Brandspace(readString, readString2, arrayList, brandspaceAdjustParameters);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Brandspace[] newArray(int i) {
            return new Brandspace[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.brandspace.remote.model.BrandspaceElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public Brandspace(@NotNull String str, @NotNull String str2, @Nullable List<? extends BrandspaceElement> list, @Nullable BrandspaceAdjustParameters brandspaceAdjustParameters) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.elements = list;
        this.adjustParameters = brandspaceAdjustParameters;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.Brandspace */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Brandspace copy$default(Brandspace brandspace, String str, String str2, List list, BrandspaceAdjustParameters brandspaceAdjustParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandspace.id;
        }
        if ((i & 2) != 0) {
            str2 = brandspace.title;
        }
        if ((i & 4) != 0) {
            list = brandspace.elements;
        }
        if ((i & 8) != 0) {
            brandspaceAdjustParameters = brandspace.adjustParameters;
        }
        return brandspace.copy(str, str2, list, brandspaceAdjustParameters);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final List<BrandspaceElement> component3() {
        return this.elements;
    }

    @Nullable
    public final BrandspaceAdjustParameters component4() {
        return this.adjustParameters;
    }

    @NotNull
    public final Brandspace copy(@NotNull String str, @NotNull String str2, @Nullable List<? extends BrandspaceElement> list, @Nullable BrandspaceAdjustParameters brandspaceAdjustParameters) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new Brandspace(str, str2, list, brandspaceAdjustParameters);
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
        if (!(obj instanceof Brandspace)) {
            return false;
        }
        Brandspace brandspace = (Brandspace) obj;
        return Intrinsics.areEqual(this.id, brandspace.id) && Intrinsics.areEqual(this.title, brandspace.title) && Intrinsics.areEqual(this.elements, brandspace.elements) && Intrinsics.areEqual(this.adjustParameters, brandspace.adjustParameters);
    }

    @Nullable
    public final BrandspaceAdjustParameters getAdjustParameters() {
        return this.adjustParameters;
    }

    @Nullable
    public final List<BrandspaceElement> getElements() {
        return this.elements;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<BrandspaceElement> list = this.elements;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        BrandspaceAdjustParameters brandspaceAdjustParameters = this.adjustParameters;
        if (brandspaceAdjustParameters != null) {
            i = brandspaceAdjustParameters.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Brandspace(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", elements=");
        L.append(this.elements);
        L.append(", adjustParameters=");
        L.append(this.adjustParameters);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        List<BrandspaceElement> list = this.elements;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((BrandspaceElement) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        BrandspaceAdjustParameters brandspaceAdjustParameters = this.adjustParameters;
        if (brandspaceAdjustParameters != null) {
            parcel.writeInt(1);
            brandspaceAdjustParameters.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
