package com.avito.android.favorite_sellers.adapter.recommendation;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.RecommendationItem;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.Kundle;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;", "Lcom/avito/android/favorite_sellers/RecommendationItem;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "view", "", "attachView", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;)V", "detachView", "()V", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;)V", "detachRouter", "resetAutoScroll", "onSubscriptionDeepLinkReturned", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface RecommendationItemPresenter extends ItemPresenter<RecommendationItemView, RecommendationItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter$Router;", "", "", "openNotificationsSettings", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLinkFromRecommendations", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLinkFromRecommendations(@NotNull DeepLink deepLink);

        void openNotificationsSettings();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SubscriptionSettingsView subscriptionSettingsView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();

    void onSubscriptionDeepLinkReturned();

    void resetAutoScroll();
}
