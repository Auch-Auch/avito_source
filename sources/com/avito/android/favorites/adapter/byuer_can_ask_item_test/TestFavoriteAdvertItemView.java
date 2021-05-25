package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "status", "", "setStatus", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface TestFavoriteAdvertItemView extends FavoriteAdvertItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TestFavoriteAdvertItemView testFavoriteAdvertItemView) {
            FavoriteAdvertItemView.DefaultImpls.onUnbind(testFavoriteAdvertItemView);
        }
    }

    void setStatus(@Nullable FavoriteAdvertItem.Status status);
}
