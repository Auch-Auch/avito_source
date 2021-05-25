package com.avito.android.remote.model;

import com.avito.android.db.FavoritesContract;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/FavoritesResponseV3;", "", "", "xHash", "Ljava/lang/String;", "getXHash", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/References;", "references", "Lcom/avito/android/remote/model/References;", "getReferences", "()Lcom/avito/android/remote/model/References;", "", "Lcom/avito/android/remote/model/FavoriteAdvert;", FavoritesContract.TABLE_NAME, "Ljava/util/List;", "getFavorites", "()Ljava/util/List;", "nextPage", "getNextPage", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/References;Ljava/lang/String;Ljava/lang/String;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesResponseV3 {
    @SerializedName("items")
    @NotNull
    private final List<FavoriteAdvert> favorites;
    @SerializedName("nextPage")
    @Nullable
    private final String nextPage;
    @SerializedName("refs")
    @Nullable
    private final References references;
    @SerializedName("xHash")
    @Nullable
    private final String xHash;

    public FavoritesResponseV3(@NotNull List<FavoriteAdvert> list, @Nullable References references2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, FavoritesContract.TABLE_NAME);
        this.favorites = list;
        this.references = references2;
        this.xHash = str;
        this.nextPage = str2;
    }

    @NotNull
    public final List<FavoriteAdvert> getFavorites() {
        return this.favorites;
    }

    @Nullable
    public final String getNextPage() {
        return this.nextPage;
    }

    @Nullable
    public final References getReferences() {
        return this.references;
    }

    @Nullable
    public final String getXHash() {
        return this.xHash;
    }
}
