package com.avito.android.di.module;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.common.CounterInteractor;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.favorites.di.Favorites;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.ui.UserProfileStatusDataProvider;
import com.avito.android.ui.UserProfileStatusDataProviderImpl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/di/module/UserProfileStatusDataProviderModule;", "", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "notificationsInteractor", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterInteractor", "favoritesCounterInteractor", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionsSyncRunner", "Landroid/content/Context;", "context", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ui/UserProfileStatusDataProvider;", "provideUserProfileStatusDataBridge", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;Landroid/content/Context;Lcom/avito/android/Features;)Lcom/avito/android/ui/UserProfileStatusDataProvider;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserProfileStatusDataProviderModule {
    @NotNull
    public static final UserProfileStatusDataProviderModule INSTANCE = new UserProfileStatusDataProviderModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final UserProfileStatusDataProvider provideUserProfileStatusDataBridge(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull UnreadNotificationsInteractor unreadNotificationsInteractor, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @FavoriteSellers @NotNull CounterInteractor counterInteractor, @Favorites @NotNull CounterInteractor counterInteractor2, @NotNull SearchSubscriptionSyncRunner searchSubscriptionSyncRunner, @NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(unreadNotificationsInteractor, "notificationsInteractor");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoriteSellersCounterInteractor");
        Intrinsics.checkNotNullParameter(counterInteractor2, "favoritesCounterInteractor");
        Intrinsics.checkNotNullParameter(searchSubscriptionSyncRunner, "searchSubscriptionsSyncRunner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        return new UserProfileStatusDataProviderImpl(accountStorageInteractor, unreadNotificationsInteractor, counterInteractor, counterInteractor2, notificationCenterCounterInteractor, searchSubscriptionSyncRunner, context, features);
    }
}
