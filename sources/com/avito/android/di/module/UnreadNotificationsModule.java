package com.avito.android.di.module;

import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.messenger.UnreadMessagesCounterObservable;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import com.avito.android.remote.notification.UnreadNotificationsInteractorImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/di/module/UnreadNotificationsModule;", "", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "searchSubscriptionObservable", "Lcom/avito/android/messenger/UnreadMessagesCounterObservable;", "unreadMessagesCounterObservable", "Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "userAdvertInfoCache", "Lcom/avito/android/db/SearchSubscriptionDao;", "searchSubscriptionDao", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "userAvertsInfoStorage", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "provideNotificationsInteractor", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;Lcom/avito/android/messenger/UnreadMessagesCounterObservable;Lcom/avito/android/user_advert/UserAdvertsInfoCache;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/preferences/MessengerStorage;Lcom/avito/android/preferences/UserAdvertsInfoStorage;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UnreadNotificationsModule {
    @NotNull
    public static final UnreadNotificationsModule INSTANCE = new UnreadNotificationsModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final UnreadNotificationsInteractor provideNotificationsInteractor(@NotNull SearchSubscriptionObservable searchSubscriptionObservable, @NotNull UnreadMessagesCounterObservable unreadMessagesCounterObservable, @NotNull UserAdvertsInfoCache userAdvertsInfoCache, @NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull MessengerStorage messengerStorage, @NotNull UserAdvertsInfoStorage userAdvertsInfoStorage, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchSubscriptionObservable, "searchSubscriptionObservable");
        Intrinsics.checkNotNullParameter(unreadMessagesCounterObservable, "unreadMessagesCounterObservable");
        Intrinsics.checkNotNullParameter(userAdvertsInfoCache, "userAdvertInfoCache");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "searchSubscriptionDao");
        Intrinsics.checkNotNullParameter(messengerStorage, "messengerStorage");
        Intrinsics.checkNotNullParameter(userAdvertsInfoStorage, "userAvertsInfoStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new UnreadNotificationsInteractorImpl(searchSubscriptionObservable, unreadMessagesCounterObservable, userAdvertsInfoCache, searchSubscriptionDao, messengerStorage, userAdvertsInfoStorage, schedulersFactory3);
    }
}
