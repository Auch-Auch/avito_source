package com.avito.android.favorites;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\bJ-\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/favorites/FavoritesView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "onDataChanged", "()V", "", "message", "showErrorOverlay", "(Ljava/lang/String;)V", "showProgress", "hideProgress", "stopPullToRefresh", "", "isVisible", "setMenuVisibility", "(Z)V", "showEmptyView", "hideEmptyView", "showMessage", "action", "Lkotlin/Function0;", "actionListener", "showMessageWithAction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "dismissMessageWithAction", "scrollToTop", "Presenter", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface FavoritesView extends ViewedAdvertsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showErrorOverlay$default(FavoritesView favoritesView, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                favoritesView.showErrorOverlay(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorOverlay");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/favorites/FavoritesView$Presenter;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter$Listener;", "", "onRetry", "()V", "onPullRefresh", "onRemoveAllClicked", "onRemoveInactiveClicked", "favorites_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter extends FavoriteAdvertItemPresenter.Listener, TestFavoriteAdvertItemPresenter.Listener {
        void onPullRefresh();

        void onRemoveAllClicked();

        void onRemoveInactiveClicked();

        void onRetry();
    }

    void dismissMessageWithAction();

    void hideEmptyView();

    void hideProgress();

    void onDataChanged();

    void scrollToTop();

    void setMenuVisibility(boolean z);

    void showEmptyView();

    void showErrorOverlay(@NotNull String str);

    void showMessage(@NotNull String str);

    void showMessageWithAction(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);

    void showProgress();

    void stopPullToRefresh();
}
