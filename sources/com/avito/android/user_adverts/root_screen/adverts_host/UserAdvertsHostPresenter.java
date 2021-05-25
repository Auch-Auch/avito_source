package com.avito.android.user_adverts.root_screen.adverts_host;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b \bf\u0018\u00002\u00020\u0001:\u0001@J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\fJ!\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010%\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b%\u0010&J1\u0010'\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H&¢\u0006\u0004\b)\u0010\fJ\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0015H&¢\u0006\u0004\b+\u0010,J)\u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020!2\b\b\u0002\u0010/\u001a\u00020!H&¢\u0006\u0004\b0\u00101J)\u00102\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020!2\b\b\u0002\u0010/\u001a\u00020!H&¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\u0004H&¢\u0006\u0004\b3\u0010\fJ\u000f\u00104\u001a\u00020\u0004H&¢\u0006\u0004\b4\u0010\fJ\u000f\u00105\u001a\u00020\u0004H&¢\u0006\u0004\b5\u0010\fJ\u000f\u00106\u001a\u00020\u0004H&¢\u0006\u0004\b6\u0010\fJ\u000f\u00107\u001a\u00020\u0004H&¢\u0006\u0004\b7\u0010\fJ\u000f\u00108\u001a\u00020\u0004H&¢\u0006\u0004\b8\u0010\fJ\u0017\u00109\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0015H&¢\u0006\u0004\b9\u0010,J\u0017\u0010:\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0015H&¢\u0006\u0004\b:\u0010,J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020!H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0004H&¢\u0006\u0004\b>\u0010\fJ\u000f\u0010?\u001a\u00020\u0004H&¢\u0006\u0004\b?\u0010\f¨\u0006A"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView$Presenter;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "view", "", "attachView", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;", "viewModel", "setHeaderViewModel", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewModel;)V", "detachView", "()V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "", "getActiveTabShortcut", "()Ljava/lang/String;", "onAuthenticationCancelled", "onNewAdvertCreated", "", "resultCode", "Landroid/content/Intent;", "data", "onAdvertDetailsResult", "(ILandroid/content/Intent;)V", "statusMessage", "", "updateContents", "soaUpdateText", "soaAdvertId", "onAdvertStatusChanged", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "onAdvertStatusBroadcast", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onShowAppRater", "categoryId", "loadSafetyInfo", "(Ljava/lang/String;)V", "shortcut", "animate", "animateToolbar", "onShowFloatingViews", "(Ljava/lang/String;ZZ)V", "onHideFloatingViews", "onPageLoadingError", "onStateInvalidated", "refreshActiveTab", "onRefreshSoaStatistics", "onRefreshTabs", "onInvalidateActiveTab", "requestTabChange", "openTabWithShortcut", "userCanBeLogout", "setUserCanBeLogout", "(Z)V", "onAddNewAdvertTabClicked", "onResume", "Router", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsHostPresenter extends UserAdvertsHostView.Presenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onAdvertStatusBroadcast$default(UserAdvertsHostPresenter userAdvertsHostPresenter, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                userAdvertsHostPresenter.onAdvertStatusBroadcast(str, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAdvertStatusBroadcast");
        }

        public static /* synthetic */ void onAdvertStatusChanged$default(UserAdvertsHostPresenter userAdvertsHostPresenter, String str, boolean z, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    str3 = null;
                }
                userAdvertsHostPresenter.onAdvertStatusChanged(str, z, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAdvertStatusChanged");
        }

        public static /* synthetic */ void onHideFloatingViews$default(UserAdvertsHostPresenter userAdvertsHostPresenter, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                userAdvertsHostPresenter.onHideFloatingViews(str, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onHideFloatingViews");
        }

        public static /* synthetic */ void onShowFloatingViews$default(UserAdvertsHostPresenter userAdvertsHostPresenter, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                userAdvertsHostPresenter.onShowFloatingViews(str, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onShowFloatingViews");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter$Router;", "", "", "showLoginScreen", "()V", "onAuthentificationFailed", "showAddAdvert", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onAuthentificationFailed();

        void showAddAdvert();

        void showLoginScreen();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@Nullable UserAdvertsHostView userAdvertsHostView);

    void detachRouter();

    void detachView();

    @NotNull
    String getActiveTabShortcut();

    void loadSafetyInfo(@NotNull String str);

    void onAddNewAdvertTabClicked();

    void onAdvertDetailsResult(int i, @Nullable Intent intent);

    void onAdvertStatusBroadcast(@Nullable String str, @Nullable String str2, @Nullable String str3);

    void onAdvertStatusChanged(@Nullable String str, boolean z, @Nullable String str2, @Nullable String str3);

    void onAuthenticationCancelled();

    void onHideFloatingViews(@NotNull String str, boolean z, boolean z2);

    void onInvalidateActiveTab();

    void onNewAdvertCreated();

    void onPageLoadingError();

    void onRefreshSoaStatistics();

    void onRefreshTabs();

    void onResume();

    @NotNull
    Bundle onSaveState();

    void onShowAppRater();

    void onShowFloatingViews(@NotNull String str, boolean z, boolean z2);

    void onStateInvalidated();

    void openTabWithShortcut(@NotNull String str);

    void refreshActiveTab();

    void requestTabChange(@NotNull String str);

    void setHeaderViewModel(@NotNull ProfileHeaderViewModel profileHeaderViewModel);

    void setUserCanBeLogout(boolean z);
}
