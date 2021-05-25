package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "Listener", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface TestFavoriteAdvertItemPresenter extends ItemPresenter<TestFavoriteAdvertItemView, FavoriteAdvertItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter$Listener;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "", "itemId", "", "onAskSellerAboutItem", "(Ljava/lang/String;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener extends FavoriteAdvertItemPresenter.Listener {
        void onAskSellerAboutItem(@NotNull String str);
    }
}
