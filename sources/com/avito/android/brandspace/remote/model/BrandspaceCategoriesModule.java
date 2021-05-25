package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceCategoriesModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceCategoryElement;", "component2", "()Ljava/util/List;", "version", "categories", "copy", "(ILjava/util/List;)Lcom/avito/android/brandspace/remote/model/BrandspaceCategoriesModule;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getCategories", "I", "getVersion", "<init>", "(ILjava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceCategoriesModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceCategoriesModule> CREATOR = new Creator();
    @SerializedName("categories")
    @NotNull
    private final List<BrandspaceCategoryElement> categories;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceCategoriesModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceCategoriesModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(BrandspaceCategoryElement.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new BrandspaceCategoriesModule(readInt, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceCategoriesModule[] newArray(int i) {
            return new BrandspaceCategoriesModule[i];
        }
    }

    public BrandspaceCategoriesModule(int i, @NotNull List<BrandspaceCategoryElement> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.version = i;
        this.categories = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.BrandspaceCategoriesModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceCategoriesModule copy$default(BrandspaceCategoriesModule brandspaceCategoriesModule, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brandspaceCategoriesModule.version;
        }
        if ((i2 & 2) != 0) {
            list = brandspaceCategoriesModule.categories;
        }
        return brandspaceCategoriesModule.copy(i, list);
    }

    public final int component1() {
        return this.version;
    }

    @NotNull
    public final List<BrandspaceCategoryElement> component2() {
        return this.categories;
    }

    @NotNull
    public final BrandspaceCategoriesModule copy(int i, @NotNull List<BrandspaceCategoryElement> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        return new BrandspaceCategoriesModule(i, list);
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
        if (!(obj instanceof BrandspaceCategoriesModule)) {
            return false;
        }
        BrandspaceCategoriesModule brandspaceCategoriesModule = (BrandspaceCategoriesModule) obj;
        return this.version == brandspaceCategoriesModule.version && Intrinsics.areEqual(this.categories, brandspaceCategoriesModule.categories);
    }

    @NotNull
    public final List<BrandspaceCategoryElement> getCategories() {
        return this.categories;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        List<BrandspaceCategoryElement> list = this.categories;
        return i + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceCategoriesModule(version=");
        L.append(this.version);
        L.append(", categories=");
        return a.w(L, this.categories, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        Iterator n0 = a.n0(this.categories, parcel);
        while (n0.hasNext()) {
            ((BrandspaceCategoryElement) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
