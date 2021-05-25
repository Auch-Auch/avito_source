package com.avito.android.public_profile.ui;

import com.avito.android.Features;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.LegacyPublicProfileResult;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.FavoriteSellerCounter;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.UnsubscribeResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002./B9\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b,\u0010-J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl;", "Lcom/avito/android/public_profile/ui/PublicProfileInteractor;", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "loadPublicUserProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "", "needActivate", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/FavoriteSellersApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/FavoriteSellersApi;", "favoriteSellersApi", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "e", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "tracker", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "api", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "d", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "<init>", "(Lcom/avito/android/public_profile/remote/PublicProfileApi;Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/public_profile/tracker/PublicProfileTracker;Lcom/avito/android/Features;)V", "UserBannedError", "UserRemovedError", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileInteractorImpl implements PublicProfileInteractor, SubscribeInteractor {
    public final PublicProfileApi a;
    public final FavoriteSellersApi b;
    public final SchedulersFactory3 c;
    public final NotificationManagerProvider d;
    public final PublicProfileTracker e;
    public final Features f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl$UserBannedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserBannedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserBannedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileInteractorImpl$UserRemovedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRemovedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserRemovedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    public static final class a<T, R> implements Function<LegacyPublicProfileResult, ObservableSource<? extends DefaultPublicUserProfile>> {
        public final /* synthetic */ PublicProfileInteractorImpl a;

        public a(PublicProfileInteractorImpl publicProfileInteractorImpl) {
            this.a = publicProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends DefaultPublicUserProfile> apply(LegacyPublicProfileResult legacyPublicProfileResult) {
            LegacyPublicProfileResult legacyPublicProfileResult2 = legacyPublicProfileResult;
            if (legacyPublicProfileResult2 instanceof LegacyPublicProfileResult.Ok) {
                Observable just = Observable.just(((LegacyPublicProfileResult.Ok) legacyPublicProfileResult2).getProfile());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (legacyPublicProfileResult2 instanceof LegacyPublicProfileResult.UserBanned) {
                return PublicProfileInteractorImpl.access$toErrorObservable(this.a, new UserBannedError(((LegacyPublicProfileResult.UserBanned) legacyPublicProfileResult2).getMessage()));
            } else {
                if (legacyPublicProfileResult2 instanceof LegacyPublicProfileResult.UserRemoved) {
                    return PublicProfileInteractorImpl.access$toErrorObservable(this.a, new UserRemovedError(((LegacyPublicProfileResult.UserRemoved) legacyPublicProfileResult2).getMessage()));
                }
                if (legacyPublicProfileResult2 instanceof LegacyPublicProfileResult.FailedWithMessage) {
                    return PublicProfileInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((LegacyPublicProfileResult.FailedWithMessage) legacyPublicProfileResult2).getMessage()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ PublicProfileInteractorImpl a;

        public b(PublicProfileInteractorImpl publicProfileInteractorImpl) {
            this.a = publicProfileInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.e.startProfileServerLoading();
        }
    }

    public static final class c<T, R> implements Function<SubscribeResult, SubscribeInfo> {
        public final /* synthetic */ PublicProfileInteractorImpl a;

        public c(PublicProfileInteractorImpl publicProfileInteractorImpl) {
            this.a = publicProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SubscribeInfo apply(SubscribeResult subscribeResult) {
            SubscribeResult subscribeResult2 = subscribeResult;
            Boolean bool = Boolean.TRUE;
            Boolean isNotificationsActivated = subscribeResult2.isNotificationsActivated();
            FavoriteSellerCounter subscribers = subscribeResult2.getSubscribers();
            ProfileCounter profileCounter = null;
            ProfileCounter access$toProfileCounter = subscribers != null ? PublicProfileInteractorImpl.access$toProfileCounter(this.a, subscribers) : null;
            FavoriteSellerCounter subscriptions = subscribeResult2.getSubscriptions();
            if (subscriptions != null) {
                profileCounter = PublicProfileInteractorImpl.access$toProfileCounter(this.a, subscriptions);
            }
            return new SubscribeInfo(bool, isNotificationsActivated, access$toProfileCounter, profileCounter);
        }
    }

    public static final class d<T, R> implements Function<UnsubscribeResult, SubscribeInfo> {
        public final /* synthetic */ PublicProfileInteractorImpl a;

        public d(PublicProfileInteractorImpl publicProfileInteractorImpl) {
            this.a = publicProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SubscribeInfo apply(UnsubscribeResult unsubscribeResult) {
            UnsubscribeResult unsubscribeResult2 = unsubscribeResult;
            Boolean bool = Boolean.FALSE;
            FavoriteSellerCounter subscribers = unsubscribeResult2.getSubscribers();
            ProfileCounter access$toProfileCounter = subscribers != null ? PublicProfileInteractorImpl.access$toProfileCounter(this.a, subscribers) : null;
            FavoriteSellerCounter subscriptions = unsubscribeResult2.getSubscriptions();
            return new SubscribeInfo(bool, null, access$toProfileCounter, subscriptions != null ? PublicProfileInteractorImpl.access$toProfileCounter(this.a, subscriptions) : null);
        }
    }

    @Inject
    public PublicProfileInteractorImpl(@NotNull PublicProfileApi publicProfileApi, @NotNull FavoriteSellersApi favoriteSellersApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull PublicProfileTracker publicProfileTracker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publicProfileApi, "api");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "favoriteSellersApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(publicProfileTracker, "tracker");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = publicProfileApi;
        this.b = favoriteSellersApi;
        this.c = schedulersFactory3;
        this.d = notificationManagerProvider;
        this.e = publicProfileTracker;
        this.f = features;
    }

    public static final Observable access$toErrorObservable(PublicProfileInteractorImpl publicProfileInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(publicProfileInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    public static final ProfileCounter access$toProfileCounter(PublicProfileInteractorImpl publicProfileInteractorImpl, FavoriteSellerCounter favoriteSellerCounter) {
        Objects.requireNonNull(publicProfileInteractorImpl);
        return new ProfileCounter(favoriteSellerCounter.getTitle(), favoriteSellerCounter.getSubtitle(), null);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable ignoreElements = TypedObservablesKt.toTyped(this.b.changeNotifications("public_profile", str, z)).subscribeOn(this.c.io()).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "favoriteSellersApi.chang…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileInteractor
    @NotNull
    public Observable<DefaultPublicUserProfile> loadPublicUserProfile(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<DefaultPublicUserProfile> doOnSubscribe = TypedObservablesKt.toTyped(this.a.getLegacyPublicUserProfile(str, str2)).flatMap(new a(this)).subscribeOn(this.c.io()).doOnSubscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "api.getLegacyPublicUserP…tProfileServerLoading() }");
        return doOnSubscribe;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> subscribe(@NotNull String str) {
        Observable<TypedResult<SubscribeResult>> observable;
        Intrinsics.checkNotNullParameter(str, "userKey");
        if (this.f.getSupportsSubscribeV2().getValue().booleanValue()) {
            observable = this.b.subscribeV2("public_profile", str, this.d.getAreNotificationsEnabled(), true);
        } else {
            observable = this.b.subscribe("public_profile", str, this.d.getAreNotificationsEnabled(), true);
        }
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(observable).subscribeOn(this.c.io()).map(new c(this)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "subscribeResult.toTyped(…         }.firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> unsubscribe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(this.b.unsubscribe("public_profile", str, true)).subscribeOn(this.c.io()).map(new d(this)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "favoriteSellersApi.unsub…         }.firstOrError()");
        return firstOrError;
    }
}
