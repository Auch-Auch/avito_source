package com.avito.android.ui;

import a2.g.r.g;
import android.content.Context;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.common.CounterInteractor;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.favorites.di.Favorites;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.avito.android.remote.model.notification.NotificationsCount;
import com.avito.android.remote.notification.AdvertsCount;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0001\u0010:\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\tR\u0016\u0010,\u001a\u00020+8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\tR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\tR\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002060\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\tR\u0016\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0019¨\u0006="}, d2 = {"Lcom/avito/android/ui/UserProfileStatusDataProviderImpl;", "Lcom/avito/android/ui/UserProfileStatusDataProvider;", "", "updateUnreadMessagesAndExpiredAdverts", "()V", "updateUserFavoritesCounters", "Lio/reactivex/rxjava3/core/Observable;", "", "getUnreadNotificationsCount", "()Lio/reactivex/rxjava3/core/Observable;", "unreadNotificationsCount", "getFavoritesCount", "favoritesCount", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "getFavoriteSellersCount", "favoriteSellersCount", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "f", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionsSyncRunner", "Lcom/avito/android/common/CounterInteractor;", "c", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterInteractor", "getSavedSearchesCount", "savedSearchesCount", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "e", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "unreadNotificationsInteractor", "Landroid/content/Context;", g.a, "Landroid/content/Context;", "context", "getUnreadMessagesCount", "unreadMessagesCount", "", "isLogged", "()Z", "getTotalBadgeCount", "totalBadgeCount", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "getExpiredAdvertsCount", "expiredAdvertsCount", "Lcom/avito/android/remote/model/ProfileInfo;", "getProfileInfo", "profileInfo", "d", "favoritesCounterInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;Landroid/content/Context;Lcom/avito/android/Features;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public class UserProfileStatusDataProviderImpl implements UserProfileStatusDataProvider {
    public final AccountStorageInteractor a;
    public final UnreadNotificationsInteractor b;
    public final CounterInteractor c;
    public final CounterInteractor d;
    public final NotificationCenterCounterInteractor e;
    public final SearchSubscriptionSyncRunner f;
    public final Context g;
    public final Features h;

    public static final class a<T, R> implements Function<AdvertsCount, Integer> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(AdvertsCount advertsCount) {
            return Integer.valueOf(advertsCount.getCount());
        }
    }

    public static final class b<T, R> implements Function<SavedSearchesCounter, Integer> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(SavedSearchesCounter savedSearchesCounter) {
            return Integer.valueOf(savedSearchesCounter.getUnreadCount());
        }
    }

    public static final class c<T, R> implements Function<UnreadMessagesCounter, Integer> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(UnreadMessagesCounter unreadMessagesCounter) {
            return Integer.valueOf(unreadMessagesCounter.getMessagesCount());
        }
    }

    public static final class d<T, R> implements Function<NotificationsCount, Integer> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(NotificationsCount notificationsCount) {
            return Integer.valueOf(notificationsCount.getUnread());
        }
    }

    public UserProfileStatusDataProviderImpl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull UnreadNotificationsInteractor unreadNotificationsInteractor, @FavoriteSellers @NotNull CounterInteractor counterInteractor, @Favorites @NotNull CounterInteractor counterInteractor2, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @NotNull SearchSubscriptionSyncRunner searchSubscriptionSyncRunner, @NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(unreadNotificationsInteractor, "unreadNotificationsInteractor");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoriteSellersCounterInteractor");
        Intrinsics.checkNotNullParameter(counterInteractor2, "favoritesCounterInteractor");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(searchSubscriptionSyncRunner, "searchSubscriptionsSyncRunner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = accountStorageInteractor;
        this.b = unreadNotificationsInteractor;
        this.c = counterInteractor;
        this.d = counterInteractor2;
        this.e = notificationCenterCounterInteractor;
        this.f = searchSubscriptionSyncRunner;
        this.g = context;
        this.h = features;
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getExpiredAdvertsCount() {
        Observable<R> map = this.b.expiredAdvertsCount().map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "unreadNotificationsInter…        .map { it.count }");
        return map;
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getFavoriteSellersCount() {
        return this.c.changes();
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getFavoritesCount() {
        return this.d.changes();
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<ProfileInfo> getProfileInfo() {
        return this.a.profileInfo();
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getSavedSearchesCount() {
        Observable<R> map = this.b.savedSearchesCount().map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "unreadNotificationsInter…  .map { it.unreadCount }");
        return map;
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getTotalBadgeCount() {
        ArrayList arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(getSavedSearchesCount(), getFavoriteSellersCount());
        if (this.h.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            arrayListOf.add(getFavoritesCount());
        }
        return Observables.combineLatest(arrayListOf, a2.a.a.g3.a.a);
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getUnreadMessagesCount() {
        Observable<R> map = this.b.unreadMessagesCount().map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "unreadNotificationsInter….map { it.messagesCount }");
        return map;
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    @NotNull
    public Observable<Integer> getUnreadNotificationsCount() {
        Observable<R> map = this.e.getCount().map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "notificationCenterCounte…       .map { it.unread }");
        return map;
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    public boolean isLogged() {
        return this.a.toBlocking().isAuthorized();
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    public void updateUnreadMessagesAndExpiredAdverts() {
        this.b.update();
    }

    @Override // com.avito.android.ui.UserProfileStatusDataProvider
    public void updateUserFavoritesCounters() {
        this.f.requestUpdate(this.g);
        CounterInteractor.DefaultImpls.requestUpdate$default(this.c, false, 1, null);
        if (this.h.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            CounterInteractor.DefaultImpls.requestUpdate$default(this.d, false, 1, null);
        }
    }
}
