package com.avito.android.shop.detailed.item;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShowcaseItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "onDataSourceChanged", "()V", "", "text", "bindTitle", "(Ljava/lang/String;)V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "id", "setTag", "setupViewForLargeItems", "setupViewForSmallItems", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoritesPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritesPresenter", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShowcaseItemView extends ItemView, FavoriteAdvertsView, ViewedAdvertsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShowcaseItemView showcaseItemView) {
            ItemView.DefaultImpls.onUnbind(showcaseItemView);
        }
    }

    void bindTitle(@Nullable String str);

    @NotNull
    AdapterPresenter getAdapterPresenter();

    @NotNull
    FavoriteAdvertsPresenter getFavoritesPresenter();

    @NotNull
    ViewedAdvertsPresenter getViewedAdvertsPresenter();

    void onDataSourceChanged();

    void setCurrentPosition(int i);

    void setTag(@NotNull String str);

    void setupViewForLargeItems();

    void setupViewForSmallItems();
}
