package com.avito.android.home;

import com.avito.android.advert.actions.AdvertItemActionsView;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.component.search.SearchBar;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/home/HomeView;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/home/HomePresenterView;", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/util/architecture_components/auto_clear/LifecycleDestroyable;", "Lcom/avito/android/advert/actions/AdvertItemActionsView;", "", "message", "", "showMessage", "(Ljava/lang/String;)V", "title", "showEmptyView", "hideEmptyView", "()V", "hideShortcutsBlock", "showShortcutsBlock", "", "count", "setColumnsCount", "(I)V", "", "visible", "setCartFabVisible", "(Z)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeView extends ShortcutNavigationBar, SearchBar, HomePresenterView, FloatingViewsPresenter.Subscriber, FavoriteAdvertsView, ErrorMessageView, ViewedAdvertsView, LifecycleDestroyable, AdvertItemActionsView {
    void hideEmptyView();

    void hideShortcutsBlock();

    void setCartFabVisible(boolean z);

    void setColumnsCount(int i);

    void showEmptyView(@NotNull String str);

    void showMessage(@NotNull String str);

    void showShortcutsBlock();
}
