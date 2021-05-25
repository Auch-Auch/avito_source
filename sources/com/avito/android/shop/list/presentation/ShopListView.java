package com.avito.android.shop.list.presentation;

import com.avito.android.component.search.SearchBar;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Constants;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060 H&¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060 H&¢\u0006\u0004\b#\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060 H&¢\u0006\u0004\b$\u0010\"J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060 H&¢\u0006\u0004\b%\u0010\"J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0 H&¢\u0006\u0004\b'\u0010\"J\u000f\u0010(\u001a\u00020\u0006H&¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\u0006H&¢\u0006\u0004\b)\u0010\u000eJ\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001cH&¢\u0006\u0004\b+\u0010\u001fJ\u000f\u0010,\u001a\u00020\u0006H&¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010-\u001a\u00020\u0006H&¢\u0006\u0004\b-\u0010\u000e¨\u0006."}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListView;", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lcom/avito/android/component/search/SearchBar;", "", "error", "", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "hideEmptyView", "()V", "showEmptyView", "showActionButton", "hideActionButton", "text", "setActionText", "showSearchHintNoLocation", Constants.LOCATION_NAME, "showSearchHintWithLocation", "showRetryOverlay", "showLoading", "hideLoading", "stopPullRefresh", "dispose", "", "isEnabled", "setPullRefreshEnabled", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "searchClarifyEvents", "()Lio/reactivex/rxjava3/core/Observable;", "reloadEvents", "pullRefreshEvents", "actionClickEvents", "", "firstVisibleEvents", "hideShortcutsWithShift", "showShortcutsWithShift", "smooth", "scrollToTop", "addBottomSpace", "removeBottomSpace", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListView extends FloatingViewsPresenter.Subscriber, ShortcutNavigationBar, SearchBar {
    @NotNull
    Observable<Unit> actionClickEvents();

    void addBottomSpace();

    void dispose();

    @NotNull
    Observable<Integer> firstVisibleEvents();

    void hideActionButton();

    void hideEmptyView();

    void hideLoading();

    void hideShortcutsWithShift();

    void onDataChanged(@NotNull AppendingListener appendingListener);

    @NotNull
    Observable<Unit> pullRefreshEvents();

    @NotNull
    Observable<Unit> reloadEvents();

    void removeBottomSpace();

    void scrollToTop(boolean z);

    @NotNull
    Observable<Unit> searchClarifyEvents();

    void setActionText(@NotNull String str);

    void setPullRefreshEnabled(boolean z);

    void showActionButton();

    void showEmptyView();

    void showError(@NotNull String str);

    void showLoading();

    void showRetryOverlay();

    void showSearchHintNoLocation();

    void showSearchHintWithLocation(@NotNull String str);

    void showShortcutsWithShift();

    void stopPullRefresh();
}
