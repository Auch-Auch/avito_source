package com.avito.android.remote.notification;

import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.messenger.UnreadMessagesCounterObservable;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ=\u0010\u000f\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t\u0018\u00010\u0005¢\u0006\u0002\b\u000e0\u0005¢\u0006\u0002\b\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001e¨\u00060"}, d2 = {"Lcom/avito/android/remote/notification/UnreadNotificationsInteractorImpl;", "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "", "update", "()V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/event/SavedSearchesCounter;", "savedSearchesCount", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/messenger/UnreadMessagesCounter;", "unreadMessagesCount", "Lcom/avito/android/remote/notification/AdvertsCount;", "expiredAdvertsCount", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/SearchSubscriptionDao;", "d", "Lcom/avito/android/db/SearchSubscriptionDao;", "subscriptionDao", "Lcom/avito/android/preferences/MessengerStorage;", "e", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "f", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "userAdvertsInfoStorage", "Lio/reactivex/rxjava3/subjects/PublishSubject;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "unreadMessagesSubject", "savedSearchesSubject", "Lcom/avito/android/util/SchedulersFactory3;", a2.g.r.g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "c", "expiredAdvertsCountSubject", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "searchSubscriptionObservable", "Lcom/avito/android/messenger/UnreadMessagesCounterObservable;", "unreadMessagesCounterObservable", "Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "userAdvertsInfoCache", "<init>", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;Lcom/avito/android/messenger/UnreadMessagesCounterObservable;Lcom/avito/android/user_advert/UserAdvertsInfoCache;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/preferences/MessengerStorage;Lcom/avito/android/preferences/UserAdvertsInfoStorage;Lcom/avito/android/util/SchedulersFactory3;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class UnreadNotificationsInteractorImpl implements UnreadNotificationsInteractor {
    public final PublishSubject<SavedSearchesCounter> a;
    public final PublishSubject<UnreadMessagesCounter> b;
    public final PublishSubject<Integer> c;
    public final SearchSubscriptionDao d;
    public final MessengerStorage e;
    public final UserAdvertsInfoStorage f;
    public final SchedulersFactory3 g;

    public static final class a<T, R> implements Function<Integer, AdvertsCount> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AdvertsCount apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return new AdvertsCount(num2.intValue());
        }
    }

    public static final class b<V> implements Callable<Integer> {
        public final /* synthetic */ UnreadNotificationsInteractorImpl a;

        public b(UnreadNotificationsInteractorImpl unreadNotificationsInteractorImpl) {
            this.a = unreadNotificationsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            return Integer.valueOf(this.a.e.getUnreadMessagesCount());
        }
    }

    public static final class c<T, R> implements Function<Integer, UnreadMessagesCounter> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public UnreadMessagesCounter apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            return new UnreadMessagesCounter(0, num2.intValue());
        }
    }

    public static final class d<T> implements Consumer<UnreadMessagesCounter> {
        public final /* synthetic */ UnreadNotificationsInteractorImpl a;

        public d(UnreadNotificationsInteractorImpl unreadNotificationsInteractorImpl) {
            this.a = unreadNotificationsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.subjects.PublishSubject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(UnreadMessagesCounter unreadMessagesCounter) {
            this.a.b.onNext(unreadMessagesCounter);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class f<T> implements Consumer<Integer> {
        public final /* synthetic */ UnreadNotificationsInteractorImpl a;

        public f(UnreadNotificationsInteractorImpl unreadNotificationsInteractorImpl) {
            this.a = unreadNotificationsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.subjects.PublishSubject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.c.onNext(num);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe expired adverts count", th);
        }
    }

    public UnreadNotificationsInteractorImpl(@NotNull SearchSubscriptionObservable searchSubscriptionObservable, @NotNull UnreadMessagesCounterObservable unreadMessagesCounterObservable, @NotNull UserAdvertsInfoCache userAdvertsInfoCache, @NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull MessengerStorage messengerStorage, @NotNull UserAdvertsInfoStorage userAdvertsInfoStorage, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchSubscriptionObservable, "searchSubscriptionObservable");
        Intrinsics.checkNotNullParameter(unreadMessagesCounterObservable, "unreadMessagesCounterObservable");
        Intrinsics.checkNotNullParameter(userAdvertsInfoCache, "userAdvertsInfoCache");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "subscriptionDao");
        Intrinsics.checkNotNullParameter(messengerStorage, "messengerStorage");
        Intrinsics.checkNotNullParameter(userAdvertsInfoStorage, "userAdvertsInfoStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.d = searchSubscriptionDao;
        this.e = messengerStorage;
        this.f = userAdvertsInfoStorage;
        this.g = schedulersFactory3;
        PublishSubject<SavedSearchesCounter> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.a = create;
        PublishSubject<UnreadMessagesCounter> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create()");
        this.b = create2;
        PublishSubject<Integer> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishSubject.create()");
        this.c = create3;
        unreadMessagesCounterObservable.observe().subscribe(create2);
        searchSubscriptionObservable.observeCounter().subscribe(create);
        userAdvertsInfoCache.expiredCountUpdates().subscribe(create3);
    }

    public final Observable<UnreadMessagesCounter> a() {
        return Observable.fromCallable(new b(this)).map(c.a).subscribeOn(this.g.io());
    }

    @Override // com.avito.android.remote.notification.UnreadNotificationsInteractor
    @NotNull
    public Observable<AdvertsCount> expiredAdvertsCount() {
        Observable<R> map = this.c.startWith(Observable.fromCallable(new a2.a.a.h2.a.b(this)).subscribeOn(this.g.io())).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "expiredAdvertsCountSubje….map { AdvertsCount(it) }");
        return map;
    }

    @Override // com.avito.android.remote.notification.UnreadNotificationsInteractor
    @NotNull
    public Observable<SavedSearchesCounter> savedSearchesCount() {
        Observable<SavedSearchesCounter> startWith = this.a.startWith(Observable.fromCallable(new a2.a.a.h2.a.c(this)).map(a2.a.a.h2.a.d.a).subscribeOn(this.g.io()));
        Intrinsics.checkNotNullExpressionValue(startWith, "savedSearchesSubject.sta…avedSearchesObservable())");
        return startWith;
    }

    @Override // com.avito.android.remote.notification.UnreadNotificationsInteractor
    @NotNull
    public Observable<UnreadMessagesCounter> unreadMessagesCount() {
        Observable<UnreadMessagesCounter> startWith = this.b.startWith(a());
        Intrinsics.checkNotNullExpressionValue(startWith, "unreadMessagesSubject.st…readMessagesObservable())");
        return startWith;
    }

    @Override // com.avito.android.remote.notification.UnreadNotificationsInteractor
    public void update() {
        a().subscribe(new d(this), e.a);
        Observable.fromCallable(new a2.a.a.h2.a.b(this)).subscribeOn(this.g.io()).subscribe(new f(this), g.a);
    }
}
