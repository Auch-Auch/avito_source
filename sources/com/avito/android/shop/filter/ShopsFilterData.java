package com.avito.android.shop.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B)\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J6\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001b\u0010\nJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000eR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010\u0011¨\u0006,"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/Category;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Location;", "component2", "()Lcom/avito/android/remote/model/Location;", "component3", "categories", "defaultLocation", "location", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;)Lcom/avito/android/shop/filter/ShopsFilterData;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getDefaultLocation", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getCategories", "c", "getLocation", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;)V", "Companion", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsFilterData implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopsFilterData> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final List<Category> a;
    @NotNull
    public final Location b;
    @Nullable
    public final Location c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterData$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/shop/filter/ShopsFilterData;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShopsFilterData> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopsFilterData invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, Category.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new ShopsFilterData(createParcelableList, (Location) a2.b.a.a.a.z1(Location.class, parcel2), (Location) parcel2.readParcelable(Location.class.getClassLoader()));
        }
    }

    public ShopsFilterData(@NotNull List<Category> list, @NotNull Location location, @Nullable Location location2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(location, "defaultLocation");
        this.a = list;
        this.b = location;
        this.c = location2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.shop.filter.ShopsFilterData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopsFilterData copy$default(ShopsFilterData shopsFilterData, List list, Location location, Location location2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopsFilterData.a;
        }
        if ((i & 2) != 0) {
            location = shopsFilterData.b;
        }
        if ((i & 4) != 0) {
            location2 = shopsFilterData.c;
        }
        return shopsFilterData.copy(list, location, location2);
    }

    @NotNull
    public final List<Category> component1() {
        return this.a;
    }

    @NotNull
    public final Location component2() {
        return this.b;
    }

    @Nullable
    public final Location component3() {
        return this.c;
    }

    @NotNull
    public final ShopsFilterData copy(@NotNull List<Category> list, @NotNull Location location, @Nullable Location location2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(location, "defaultLocation");
        return new ShopsFilterData(list, location, location2);
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
        if (!(obj instanceof ShopsFilterData)) {
            return false;
        }
        ShopsFilterData shopsFilterData = (ShopsFilterData) obj;
        return Intrinsics.areEqual(this.a, shopsFilterData.a) && Intrinsics.areEqual(this.b, shopsFilterData.b) && Intrinsics.areEqual(this.c, shopsFilterData.c);
    }

    @NotNull
    public final List<Category> getCategories() {
        return this.a;
    }

    @NotNull
    public final Location getDefaultLocation() {
        return this.b;
    }

    @Nullable
    public final Location getLocation() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<Category> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Location location = this.b;
        int hashCode2 = (hashCode + (location != null ? location.hashCode() : 0)) * 31;
        Location location2 = this.c;
        if (location2 != null) {
            i = location2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ShopsFilterData(categories=");
        L.append(this.a);
        L.append(", defaultLocation=");
        L.append(this.b);
        L.append(", location=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList(parcel, this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopsFilterData(List list, Location location, Location location2, int i, j jVar) {
        this(list, location, (i & 4) != 0 ? null : location2);
    }
}
