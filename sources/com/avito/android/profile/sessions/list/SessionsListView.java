package com.avito.android.profile.sessions.list;

import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListView;", "Lcom/avito/android/profile/sessions/list/SessionsMenuView;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;", "Lio/reactivex/rxjava3/core/Observable;", "", "refreshClicks", "()Lio/reactivex/rxjava3/core/Observable;", "errorRetryClicks", "networkErrorRetryClicks", "getNavigationCallbacks", "onDataChanged", "()V", "showProgress", "hideProgress", "stopRefreshing", "showError", "", "message", "showNetworkError", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsListView extends SessionsMenuView, SnackbarElementView, SessionLogoutConfirmationView {
    @NotNull
    Observable<Unit> errorRetryClicks();

    @NotNull
    Observable<Unit> getNavigationCallbacks();

    void hideProgress();

    @NotNull
    Observable<Unit> networkErrorRetryClicks();

    void onDataChanged();

    @NotNull
    Observable<Unit> refreshClicks();

    void showError();

    void showNetworkError(@NotNull String str);

    void showProgress();

    void stopRefreshing();
}
