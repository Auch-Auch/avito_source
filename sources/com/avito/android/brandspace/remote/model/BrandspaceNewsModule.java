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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceNewsModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceNewsElement;", "component3", "()Ljava/util/List;", "version", "title", "items", "copy", "(ILjava/lang/String;Ljava/util/List;)Lcom/avito/android/brandspace/remote/model/BrandspaceNewsModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getVersion", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getItems", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceNewsModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceNewsModule> CREATOR = new Creator();
    @SerializedName("items")
    @NotNull
    private final List<BrandspaceNewsElement> items;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceNewsModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceNewsModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(BrandspaceNewsElement.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new BrandspaceNewsModule(readInt, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceNewsModule[] newArray(int i) {
            return new BrandspaceNewsModule[i];
        }
    }

    public BrandspaceNewsModule(int i, @Nullable String str, @NotNull List<BrandspaceNewsElement> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.version = i;
        this.title = str;
        this.items = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.BrandspaceNewsModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceNewsModule copy$default(BrandspaceNewsModule brandspaceNewsModule, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brandspaceNewsModule.version;
        }
        if ((i2 & 2) != 0) {
            str = brandspaceNewsModule.title;
        }
        if ((i2 & 4) != 0) {
            list = brandspaceNewsModule.items;
        }
        return brandspaceNewsModule.copy(i, str, list);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<BrandspaceNewsElement> component3() {
        return this.items;
    }

    @NotNull
    public final BrandspaceNewsModule copy(int i, @Nullable String str, @NotNull List<BrandspaceNewsElement> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new BrandspaceNewsModule(i, str, list);
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
        if (!(obj instanceof BrandspaceNewsModule)) {
            return false;
        }
        BrandspaceNewsModule brandspaceNewsModule = (BrandspaceNewsModule) obj;
        return this.version == brandspaceNewsModule.version && Intrinsics.areEqual(this.title, brandspaceNewsModule.title) && Intrinsics.areEqual(this.items, brandspaceNewsModule.items);
    }

    @NotNull
    public final List<BrandspaceNewsElement> getItems() {
        return this.items;
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
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<BrandspaceNewsElement> list = this.items;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceNewsModule(version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", items=");
        return a.w(L, this.items, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.version);
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.items, parcel);
        while (n0.hasNext()) {
            ((BrandspaceNewsElement) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
