package com.avito.android.public_profile.ui;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.util.Kundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u000eJ#\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010\u000eJ\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020!H&¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "", "Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;", "view", "", "attachContainerView", "(Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;)V", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "attachButtonsView", "(Lcom/avito/android/public_profile/ui/SubscribeButtonsView;)V", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "attachCounterView", "(Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;)V", "detachView", "()V", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "userKey", "contextId", "setUserData", "(Ljava/lang/String;Ljava/lang/String;)V", "onAuthCompleted", "onAuthCanceled", "onStartProfileLoading", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "info", "", "force", "updateSellersSubscription", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Z)V", "refreshNotificationMenuItem", "needSubscribe", "onSubscribeLinkFollow", "(Z)V", "subscriptionStatusChanged", "(Ljava/lang/String;)Z", "Router", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface SubscriptionsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void updateSellersSubscription$default(SubscriptionsPresenter subscriptionsPresenter, SubscribeInfo subscribeInfo, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                subscriptionsPresenter.updateSellersSubscription(subscribeInfo, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSellersSubscription");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "", "", "openNotificationsSettings", "()V", "openAuthScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openFavoriteSellers", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/public_profile/ui/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnBackPressedListener", "(Lcom/avito/android/public_profile/ui/OnBackPressedListener;)V", "removeOnBackPressedListener", "followDeepLinkFromSubscriptions", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void addOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener);

        void followDeepLinkFromSubscriptions(@NotNull DeepLink deepLink);

        void openAuthScreen();

        void openFavoriteSellers(@NotNull DeepLink deepLink);

        void openNotificationsSettings();

        void removeOnBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener);
    }

    void attachButtonsView(@NotNull SubscribeButtonsView subscribeButtonsView);

    void attachContainerView(@NotNull SubscriptionsContainerView subscriptionsContainerView);

    void attachCounterView(@NotNull SubscriptionsCounterView subscriptionsCounterView);

    void attachRouter(@Nullable Router router);

    void detachRouter();

    void detachView();

    void onAuthCanceled();

    void onAuthCompleted();

    @NotNull
    Kundle onSaveState();

    void onStartProfileLoading();

    void onSubscribeLinkFollow(boolean z);

    void refreshNotificationMenuItem();

    void setUserData(@NotNull String str, @Nullable String str2);

    boolean subscriptionStatusChanged(@NotNull String str);

    void updateSellersSubscription(@Nullable SubscribeInfo subscribeInfo, boolean z);
}
