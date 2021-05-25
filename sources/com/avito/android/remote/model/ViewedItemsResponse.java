package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.db.FavoritesContract;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/ViewedItemsResponse;", "", "", "Lcom/avito/android/remote/model/FavoriteAdvert;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", FavoritesContract.TABLE_NAME, "nextPage", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/ViewedItemsResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNextPage", "Ljava/util/List;", "getFavorites", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsResponse {
    @SerializedName("items")
    @NotNull
    private final List<FavoriteAdvert> favorites;
    @SerializedName("nextPage")
    @Nullable
    private final String nextPage;

    public ViewedItemsResponse(@NotNull List<FavoriteAdvert> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, FavoritesContract.TABLE_NAME);
        this.favorites = list;
        this.nextPage = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ViewedItemsResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewedItemsResponse copy$default(ViewedItemsResponse viewedItemsResponse, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = viewedItemsResponse.favorites;
        }
        if ((i & 2) != 0) {
            str = viewedItemsResponse.nextPage;
        }
        return viewedItemsResponse.copy(list, str);
    }

    @NotNull
    public final List<FavoriteAdvert> component1() {
        return this.favorites;
    }

    @Nullable
    public final String component2() {
        return this.nextPage;
    }

    @NotNull
    public final ViewedItemsResponse copy(@NotNull List<FavoriteAdvert> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, FavoritesContract.TABLE_NAME);
        return new ViewedItemsResponse(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewedItemsResponse)) {
            return false;
        }
        ViewedItemsResponse viewedItemsResponse = (ViewedItemsResponse) obj;
        return Intrinsics.areEqual(this.favorites, viewedItemsResponse.favorites) && Intrinsics.areEqual(this.nextPage, viewedItemsResponse.nextPage);
    }

    @NotNull
    public final List<FavoriteAdvert> getFavorites() {
        return this.favorites;
    }

    @Nullable
    public final String getNextPage() {
        return this.nextPage;
    }

    public int hashCode() {
        List<FavoriteAdvert> list = this.favorites;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.nextPage;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ViewedItemsResponse(favorites=");
        L.append(this.favorites);
        L.append(", nextPage=");
        return a.t(L, this.nextPage, ")");
    }
}
