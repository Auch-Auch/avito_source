package com.avito.android.location_list;

import android.view.View;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&¢\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0004R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u0006%"}, d2 = {"Lcom/avito/android/location_list/LocationListView;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "", "dismissLocationProgress", "()V", "", "isContentOverlayVisible", "()Z", "showStartLoading", "showContent", "showUnavailable", "showSearchKeyboard", "showLocationProblem", "Lkotlin/Function0;", "action", "showLocationSettingsDisabledMessage", "(Lkotlin/jvm/functions/Function0;)V", "showProgressDialog", PlatformActions.HIDE_KEYBOARD, "setHomeIconDiscard", "setHomeIconNormal", "notifyChanged", "showEmptyView", "showList", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Lio/reactivex/Observable;", "dismissCallback", "()Lio/reactivex/Observable;", "refreshCallback", "findLocationCallback", "navigationCallback", "scrollToTop", "", "getSearchQuery", "searchQuery", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListView extends OnRefreshListener {
    @NotNull
    Observable<Unit> dismissCallback();

    void dismissLocationProgress();

    @NotNull
    Observable<Unit> findLocationCallback();

    @NotNull
    View getRootView();

    @NotNull
    Observable<String> getSearchQuery();

    void hideKeyboard();

    boolean isContentOverlayVisible();

    @NotNull
    Observable<Unit> navigationCallback();

    void notifyChanged();

    @NotNull
    Observable<Unit> refreshCallback();

    void scrollToTop();

    void setHomeIconDiscard();

    void setHomeIconNormal();

    void showContent();

    void showEmptyView();

    void showList();

    void showLocationProblem();

    void showLocationSettingsDisabledMessage(@NotNull Function0<Unit> function0);

    void showProgressDialog();

    void showSearchKeyboard();

    void showStartLoading();

    void showUnavailable();
}
