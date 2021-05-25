package com.avito.android.advert.item.sellersubscription;

import com.avito.android.advert.item.AdvertDetailsItemsHolder;
import com.avito.android.advert.item.AdvertDetailsView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "attachSubscriptionSettingsView", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;)V", "detachView", "()V", "detachSubscriptionSettingsView", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;)V", "detachRouter", "Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;", "holder", "onItemsReady", "(Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "state", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "onAuthSuccess", "onAuthFailed", "onEnableNotificationDialogSuccess", "onSubscriptionDeepLinkReturned", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface SellerSubscriptionPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;", "", "", "openNotificationsSettings", "()V", "", "source", "onAuthRequired", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "req", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;I)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink, int i);

        void onAuthRequired(@Nullable String str);

        @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter.Router
        void openNotificationsSettings();
    }

    void attachRouter(@NotNull Router router);

    void attachSubscriptionSettingsView(@NotNull SubscriptionSettingsView subscriptionSettingsView);

    void attachView(@NotNull AdvertDetailsView advertDetailsView);

    void detachRouter();

    void detachSubscriptionSettingsView();

    void detachView();

    void onAuthFailed();

    void onAuthSuccess();

    void onEnableNotificationDialogSuccess();

    void onItemsReady(@NotNull AdvertDetailsItemsHolder advertDetailsItemsHolder);

    void onRestoreState(@NotNull Kundle kundle);

    @NotNull
    Kundle onSaveState();

    void onSubscriptionDeepLinkReturned();
}
