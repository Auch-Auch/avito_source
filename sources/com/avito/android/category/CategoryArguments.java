package com.avito.android.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u001f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\rR\"\u0010'\u001a\u00020\u001b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0010¨\u0006."}, d2 = {"Lcom/avito/android/category/CategoryArguments;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Location;", "component1", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component2", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "location", "treeParent", "copy", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/category/CategoryArguments;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getLocation", AuthSource.SEND_ABUSE, "Z", "isFirstStart$category_release", "()Z", "setFirstStart$category_release", "(Z)V", "isFirstStart", "c", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", "<init>", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "Companion", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryArguments implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CategoryArguments> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public boolean a;
    @Nullable
    public final Location b;
    @Nullable
    public final TreeClickStreamParent c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/category/CategoryArguments$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/category/CategoryArguments;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CategoryArguments> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CategoryArguments invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new CategoryArguments((Location) parcel2.readParcelable(Location.class.getClassLoader()), (TreeClickStreamParent) parcel2.readParcelable(TreeClickStreamParent.class.getClassLoader()));
        }
    }

    public CategoryArguments() {
        this(null, null, 3, null);
    }

    public CategoryArguments(@Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent) {
        this.b = location;
        this.c = treeClickStreamParent;
    }

    public static /* synthetic */ CategoryArguments copy$default(CategoryArguments categoryArguments, Location location, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
        if ((i & 1) != 0) {
            location = categoryArguments.b;
        }
        if ((i & 2) != 0) {
            treeClickStreamParent = categoryArguments.c;
        }
        return categoryArguments.copy(location, treeClickStreamParent);
    }

    @Nullable
    public final Location component1() {
        return this.b;
    }

    @Nullable
    public final TreeClickStreamParent component2() {
        return this.c;
    }

    @NotNull
    public final CategoryArguments copy(@Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent) {
        return new CategoryArguments(location, treeClickStreamParent);
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
        if (!(obj instanceof CategoryArguments)) {
            return false;
        }
        CategoryArguments categoryArguments = (CategoryArguments) obj;
        return Intrinsics.areEqual(this.b, categoryArguments.b) && Intrinsics.areEqual(this.c, categoryArguments.c);
    }

    @Nullable
    public final Location getLocation() {
        return this.b;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Location location = this.b;
        int i = 0;
        int hashCode = (location != null ? location.hashCode() : 0) * 31;
        TreeClickStreamParent treeClickStreamParent = this.c;
        if (treeClickStreamParent != null) {
            i = treeClickStreamParent.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isFirstStart$category_release() {
        return this.a;
    }

    public final void setFirstStart$category_release(boolean z) {
        this.a = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CategoryArguments(location=");
        L.append(this.b);
        L.append(", treeParent=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryArguments(Location location, TreeClickStreamParent treeClickStreamParent, int i, j jVar) {
        this((i & 1) != 0 ? null : location, (i & 2) != 0 ? null : treeClickStreamParent);
    }
}
