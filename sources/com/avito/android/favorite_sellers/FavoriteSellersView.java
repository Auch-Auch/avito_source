package com.avito.android.favorite_sellers;

import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH&¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0003H&¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u000eJ\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u001a\u0010\u0005J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH&¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H&¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\u0003H&¢\u0006\u0004\b'\u0010\n¨\u0006("}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "retryClicks", "()Lio/reactivex/rxjava3/core/Observable;", "refreshClicks", "", "scrollStateChanges", "notifyItemsChanged", "()V", "", "isVisible", "setEmptyVisible", "(Z)V", "showOverlayError", "hideOverlayError", "showProgress", "hideProgress", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationsDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "enabled", "setPullToRefreshEnabled", "scrollToTop", "setCommonErrorVisible", "retryButtonClick", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/favorite_sellers/ViewPortState;", "viewPortChanges", "()Lio/reactivex/rxjava3/core/Flowable;", "getViewPortState", "()Lcom/avito/android/favorite_sellers/ViewPortState;", "Lkotlin/Function0;", "actionListener", "showUndoSnackbar", "(Lkotlin/jvm/functions/Function0;)V", "dismissUndoSnackbar", "showUndoProgress", "hideUndoProgress", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersView extends SubscriptionSettingsView {
    void dismissUndoSnackbar();

    @NotNull
    ViewPortState getViewPortState();

    void hideOverlayError();

    void hideProgress();

    void hideUndoProgress();

    void notifyItemsChanged();

    @NotNull
    Observable<Unit> refreshClicks();

    @NotNull
    Observable<Unit> retryButtonClick();

    @NotNull
    Observable<Unit> retryClicks();

    @NotNull
    Observable<Integer> scrollStateChanges();

    void scrollToTop();

    void setCommonErrorVisible(boolean z);

    void setEmptyVisible(boolean z);

    void setPullToRefreshEnabled(boolean z);

    @NotNull
    Maybe<Unit> showEnableNotificationsDialog();

    void showOverlayError();

    void showProgress();

    void showUndoProgress();

    void showUndoSnackbar(@NotNull Function0<Unit> function0);

    @NotNull
    Flowable<ViewPortState> viewPortChanges();
}
