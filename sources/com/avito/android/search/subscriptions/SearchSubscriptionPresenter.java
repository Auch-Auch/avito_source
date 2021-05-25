package com.avito.android.search.subscriptions;

import android.os.Bundle;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.progress_overlay.OnRefreshListener;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter$Listener;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "view", "", "attachView", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionView;)V", "detachView", "()V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;)V", "detachRouter", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "", "success", "onLoginResult", "(Z)V", "onResume", "onViewPaused", "Router", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionPresenter extends OnRefreshListener, SearchSubscriptionItemPresenter.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;", "", "", "onAuthRequired", "()V", "", "id", "title", "openSearchSubscription", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showNotificationSettingsScreen", "closeScreen", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeScreen();

        void onAuthRequired();

        void openSearchSubscription(@NotNull DeepLink deepLink);

        void openSearchSubscription(@NotNull String str, @Nullable String str2);

        void showNotificationSettingsScreen();
    }

    void attachRouter(@Nullable Router router);

    void attachView(@Nullable SearchSubscriptionView searchSubscriptionView);

    void detachRouter();

    void detachView();

    void onLoginResult(boolean z);

    void onResume();

    @NotNull
    Bundle onSaveState();

    void onViewPaused();
}
