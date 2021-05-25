package com.avito.android.db.favorites;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.remote.model.CloseableDataSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/db/favorites/FavoriteItemsDao;", "", "Lcom/avito/android/favorite/FavoriteModel;", "item", "", "save", "(Lcom/avito/android/favorite/FavoriteModel;)V", "", "items", "(Ljava/util/List;)V", "", "id", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", "ids", "wipe", "()V", "wipeAndSave", "Lcom/avito/android/remote/model/CloseableDataSource;", "getAdvertsDataSource", "()Lcom/avito/android/remote/model/CloseableDataSource;", "getInactiveIds", "()Ljava/util/List;", "favorite_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteItemsDao {
    @NotNull
    CloseableDataSource<FavoriteModel> getAdvertsDataSource();

    @NotNull
    List<String> getInactiveIds();

    void remove(@NotNull String str);

    void remove(@NotNull List<String> list);

    void save(@NotNull FavoriteModel favoriteModel);

    void save(@NotNull List<FavoriteModel> list);

    void wipe();

    void wipeAndSave(@NotNull List<FavoriteModel> list);
}
