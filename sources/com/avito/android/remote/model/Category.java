package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B!\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0013\u0010\u0018\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u001c\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0005R\u001c\u0010\u001f\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0005¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/Category;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Entity;", "", "toString", "()Ljava/lang/String;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "parentId", "Ljava/lang/String;", "getParentId", "isRoot", "()Z", "getHasParent", "hasParent", "isNull", "id", "getId", "name", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Category implements Parcelable, Entity<String> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Category> CREATOR = Parcels.creator(Category$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Category NULL = new Category("", "", null);
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("parentId")
    @Nullable
    private final String parentId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\nJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/Category$Companion;", "", "", "Lcom/avito/android/remote/model/Category;", "categories", "", "parentId", "getChildCategories", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "parentCategory", "(Ljava/util/List;Lcom/avito/android/remote/model/Category;)Ljava/util/List;", "getRootCategories", "(Ljava/util/List;)Ljava/util/List;", "categoryId", "getCategoryById", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/Category;", "NULL", "Lcom/avito/android/remote/model/Category;", "getNULL", "()Lcom/avito/android/remote/model/Category;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @Deprecated(message = "Use Kotlin collection extension instead")
        @Nullable
        public final Category getCategoryById(@Nullable List<Category> list, @Nullable String str) {
            T t;
            if (!(list == null || str == null)) {
                if (!(str.length() == 0)) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it.next();
                        if (Intrinsics.areEqual(t.getId(), str)) {
                            break;
                        }
                    }
                    T t2 = t;
                    return t2 != null ? t2 : new Category(str, "", null);
                }
            }
            return null;
        }

        @Deprecated(message = "Use Kotlin collection extension instead")
        @NotNull
        public final List<Category> getChildCategories(@NotNull List<Category> list, @Nullable Category category) {
            Intrinsics.checkNotNullParameter(list, "categories");
            return getChildCategories(list, category != null ? category.getId() : null);
        }

        @NotNull
        public final Category getNULL() {
            return Category.NULL;
        }

        @Deprecated(message = "Use Kotlin collection extension instead")
        @NotNull
        public final List<Category> getRootCategories(@NotNull List<Category> list) {
            Intrinsics.checkNotNullParameter(list, "categories");
            return getChildCategories(list, (String) null);
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        @Deprecated(message = "Use Kotlin collection extension instead")
        @NotNull
        public final List<Category> getChildCategories(@NotNull List<Category> list, @Nullable String str) {
            ArrayList i0 = a.i0(list, "categories");
            for (T t : list) {
                if (Intrinsics.areEqual(t.getParentId(), str)) {
                    i0.add(t);
                }
            }
            return i0;
        }
    }

    public Category(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.id = str;
        this.name = str2;
        this.parentId = str3;
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
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, Category.class)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.Category");
        return !(Intrinsics.areEqual(getId(), ((Category) obj).getId()) ^ true);
    }

    public final boolean getHasParent() {
        String str = this.parentId;
        return !(str == null || str.length() == 0);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public final String getParentId() {
        return this.parentId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }

    public final boolean isNull() {
        return getId().length() == 0;
    }

    public final boolean isRoot() {
        return !getHasParent();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Category[");
        L.append(getId());
        L.append(',');
        L.append(getName());
        L.append(']');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getId());
        parcel.writeString(getName());
        parcel.writeString(this.parentId);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}
