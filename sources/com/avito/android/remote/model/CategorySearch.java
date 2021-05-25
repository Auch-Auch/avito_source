package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B1\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0013\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\"\u0010\rR$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b%\u0010\r¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/CategorySearch;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/List;", "id", "parentId", "name", "children", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/CategorySearch;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getParentId", "Ljava/util/List;", "getChildren", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CategorySearch implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CategorySearch> CREATOR = Parcels.creator(CategorySearch$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("children")
    @Nullable
    private final List<CategorySearch> children;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("parentId")
    @Nullable
    private final String parentId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategorySearch$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/CategorySearch;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public CategorySearch(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable List<CategorySearch> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.id = str;
        this.parentId = str2;
        this.name = str3;
        this.children = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.CategorySearch */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategorySearch copy$default(CategorySearch categorySearch, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categorySearch.id;
        }
        if ((i & 2) != 0) {
            str2 = categorySearch.parentId;
        }
        if ((i & 4) != 0) {
            str3 = categorySearch.name;
        }
        if ((i & 8) != 0) {
            list = categorySearch.children;
        }
        return categorySearch.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.parentId;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final List<CategorySearch> component4() {
        return this.children;
    }

    @NotNull
    public final CategorySearch copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable List<CategorySearch> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new CategorySearch(str, str2, str3, list);
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
        if (!(obj instanceof CategorySearch)) {
            return false;
        }
        CategorySearch categorySearch = (CategorySearch) obj;
        return Intrinsics.areEqual(this.id, categorySearch.id) && Intrinsics.areEqual(this.parentId, categorySearch.parentId) && Intrinsics.areEqual(this.name, categorySearch.name) && Intrinsics.areEqual(this.children, categorySearch.children);
    }

    @Nullable
    public final List<CategorySearch> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getParentId() {
        return this.parentId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.parentId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<CategorySearch> list = this.children;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategorySearch(id=");
        L.append(this.id);
        L.append(", parentId=");
        L.append(this.parentId);
        L.append(", name=");
        L.append(this.name);
        L.append(", children=");
        return a.w(L, this.children, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.parentId);
        parcel.writeString(this.name);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.children, 0, 2, null);
    }
}
