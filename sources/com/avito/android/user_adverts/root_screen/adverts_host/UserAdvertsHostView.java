package com.avito.android.user_adverts.root_screen.adverts_host;

import com.avito.android.deep_linking.links.DetailsSheetLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001$J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nH&¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "", "", "showProgress", "()V", "showError", "showEmpty", "showContent", "onTabsInvalidated", "onTabsChanged", "", "activeTab", "setActiveTab", "(I)V", "", "animate", "showFloatingViews", "(Z)V", "showAppRater", "hideFloatingViews", "removeListeners", "tabIndex", "onRefreshTab", "refreshActiveTab", "", "message", "showSnackBar", "(Ljava/lang/String;)V", "scrollToUp", "scrollToHeader", "showLogout", "Lcom/avito/android/deep_linking/links/DetailsSheetLink;", "deepLink", "showSafetyInfoBanner", "(Lcom/avito/android/deep_linking/links/DetailsSheetLink;)V", "showPublishButtonIfNeeded", "Presenter", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsHostView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView$Presenter;", "", "", "onRetryClicked", "()V", "onAddAdvertClicked", "", "activeTab", "onActiveTabChanged", "(I)V", "onLoginClick", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter {
        void onActiveTabChanged(int i);

        void onAddAdvertClicked();

        void onLoginClick();

        void onRetryClicked();
    }

    void hideFloatingViews(boolean z);

    void onRefreshTab(int i);

    void onTabsChanged();

    void onTabsInvalidated();

    void refreshActiveTab();

    void removeListeners();

    void scrollToHeader();

    void scrollToUp();

    void setActiveTab(int i);

    void showAppRater();

    void showContent();

    void showEmpty();

    void showError();

    void showFloatingViews(boolean z);

    void showLogout();

    void showProgress();

    void showPublishButtonIfNeeded();

    void showSafetyInfoBanner(@NotNull DetailsSheetLink detailsSheetLink);

    void showSnackBar(@NotNull String str);
}
