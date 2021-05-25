package com.avito.android.section;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.section.title.SectionTitleItemView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/section/SectionItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/section/title/SectionTitleItemView;", "", "onDataSourceChanged", "()V", "", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "", "id", "setTag", "(Ljava/lang/String;)V", "setupViewForLargeItems", "setupViewForSmallItems", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoritesPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritesPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SectionItemView extends ItemView, FavoriteAdvertsView, ViewedAdvertsView, SectionTitleItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SectionItemView sectionItemView) {
            ItemView.DefaultImpls.onUnbind(sectionItemView);
        }
    }

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
