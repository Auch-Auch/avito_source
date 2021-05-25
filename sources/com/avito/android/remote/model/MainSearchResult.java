package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryKt;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0011¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/MainSearchResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/CategorySearch;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/ShopSearch;", "component2", "()Lcom/avito/android/remote/model/ShopSearch;", "categories", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/ShopSearch;)Lcom/avito/android/remote/model/MainSearchResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCategories", "Lcom/avito/android/remote/model/ShopSearch;", "getShop", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/ShopSearch;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MainSearchResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MainSearchResult> CREATOR = Parcels.creator(MainSearchResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("categories")
    @Nullable
    private final List<CategorySearch> categories;
    @SerializedName(AmenityMarkerIconFactoryKt.AMENITY_TYPE_SHOPS)
    @Nullable
    private final ShopSearch shop;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/MainSearchResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/MainSearchResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public MainSearchResult(@Nullable List<CategorySearch> list, @Nullable ShopSearch shopSearch) {
        this.categories = list;
        this.shop = shopSearch;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.MainSearchResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MainSearchResult copy$default(MainSearchResult mainSearchResult, List list, ShopSearch shopSearch, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mainSearchResult.categories;
        }
        if ((i & 2) != 0) {
            shopSearch = mainSearchResult.shop;
        }
        return mainSearchResult.copy(list, shopSearch);
    }

    @Nullable
    public final List<CategorySearch> component1() {
        return this.categories;
    }

    @Nullable
    public final ShopSearch component2() {
        return this.shop;
    }

    @NotNull
    public final MainSearchResult copy(@Nullable List<CategorySearch> list, @Nullable ShopSearch shopSearch) {
        return new MainSearchResult(list, shopSearch);
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
        if (!(obj instanceof MainSearchResult)) {
            return false;
        }
        MainSearchResult mainSearchResult = (MainSearchResult) obj;
        return Intrinsics.areEqual(this.categories, mainSearchResult.categories) && Intrinsics.areEqual(this.shop, mainSearchResult.shop);
    }

    @Nullable
    public final List<CategorySearch> getCategories() {
        return this.categories;
    }

    @Nullable
    public final ShopSearch getShop() {
        return this.shop;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<CategorySearch> list = this.categories;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ShopSearch shopSearch = this.shop;
        if (shopSearch != null) {
            i = shopSearch.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MainSearchResult(categories=");
        L.append(this.categories);
        L.append(", shop=");
        L.append(this.shop);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeTypedList(this.categories);
        parcel.writeParcelable(this.shop, i);
    }
}
