package com.avito.android.favorite_sellers;

import com.avito.android.remote.model.FavoriteSellersResult;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersConverter;", "", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "result", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "convert", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)Lio/reactivex/rxjava3/core/Single;", "convertSync", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)Ljava/util/List;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersConverter {
    @NotNull
    Single<List<FavoriteSellersItem>> convert(@NotNull FavoriteSellersResult favoriteSellersResult);

    @NotNull
    List<FavoriteSellersItem> convertSync(@NotNull FavoriteSellersResult favoriteSellersResult);
}
