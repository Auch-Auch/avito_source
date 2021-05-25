package com.avito.android.favorite_sellers;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellerAdvertsStatusProcessor;", "", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "list", "updateStatuses", "(Ljava/util/List;)Ljava/util/List;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellerAdvertsStatusProcessor {
    @NotNull
    List<FavoriteSellersItem> updateStatuses(@NotNull List<? extends FavoriteSellersItem> list);
}
