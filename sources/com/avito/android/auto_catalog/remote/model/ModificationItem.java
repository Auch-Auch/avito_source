package com.avito.android.auto_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.ModelSpecifications;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/ModelSpecifications;", "component3", "()Lcom/avito/android/remote/model/ModelSpecifications;", "id", "title", "specification", "copy", "(ILjava/lang/String;Lcom/avito/android/remote/model/ModelSpecifications;)Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ModelSpecifications;", "getSpecification", "I", "getId", "Ljava/lang/String;", "getTitle", "<init>", "(ILjava/lang/String;Lcom/avito/android/remote/model/ModelSpecifications;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ModificationItem implements Parcelable {
    public static final Parcelable.Creator<ModificationItem> CREATOR = new Creator();
    @SerializedName("id")
    private final int id;
    @SerializedName("specification")
    @Nullable
    private final ModelSpecifications specification;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ModificationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModificationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ModificationItem(parcel.readInt(), parcel.readString(), (ModelSpecifications) parcel.readParcelable(ModificationItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModificationItem[] newArray(int i) {
            return new ModificationItem[i];
        }
    }

    public ModificationItem(int i, @Nullable String str, @Nullable ModelSpecifications modelSpecifications) {
        this.id = i;
        this.title = str;
        this.specification = modelSpecifications;
    }

    public static /* synthetic */ ModificationItem copy$default(ModificationItem modificationItem, int i, String str, ModelSpecifications modelSpecifications, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = modificationItem.id;
        }
        if ((i2 & 2) != 0) {
            str = modificationItem.title;
        }
        if ((i2 & 4) != 0) {
            modelSpecifications = modificationItem.specification;
        }
        return modificationItem.copy(i, str, modelSpecifications);
    }

    public final int component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final ModelSpecifications component3() {
        return this.specification;
    }

    @NotNull
    public final ModificationItem copy(int i, @Nullable String str, @Nullable ModelSpecifications modelSpecifications) {
        return new ModificationItem(i, str, modelSpecifications);
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
        if (!(obj instanceof ModificationItem)) {
            return false;
        }
        ModificationItem modificationItem = (ModificationItem) obj;
        return this.id == modificationItem.id && Intrinsics.areEqual(this.title, modificationItem.title) && Intrinsics.areEqual(this.specification, modificationItem.specification);
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final ModelSpecifications getSpecification() {
        return this.specification;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.id * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        ModelSpecifications modelSpecifications = this.specification;
        if (modelSpecifications != null) {
            i2 = modelSpecifications.hashCode();
        }
        return hashCode + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ModificationItem(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", specification=");
        L.append(this.specification);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.specification, i);
    }
}
