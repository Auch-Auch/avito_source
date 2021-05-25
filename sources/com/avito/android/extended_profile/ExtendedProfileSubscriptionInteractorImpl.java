package com.avito.android.extended_profile;

import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoriteSellerCounter;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.remote.model.UnsubscribeResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileSubscriptionInteractorImpl;", "Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "", "userKey", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "", "needActivate", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/remote/FavoriteSellersApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/FavoriteSellersApi;", "favoriteSellersApi", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "<init>", "(Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSubscriptionInteractorImpl implements SubscribeInteractor {
    public final FavoriteSellersApi a;
    public final NotificationManagerProvider b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<SubscribeResult, SubscribeInfo> {
        public final /* synthetic */ ExtendedProfileSubscriptionInteractorImpl a;

        public a(ExtendedProfileSubscriptionInteractorImpl extendedProfileSubscriptionInteractorImpl) {
            this.a = extendedProfileSubscriptionInteractorImpl;
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
            ProfileCounter access$toProfileCounter = subscribers != null ? ExtendedProfileSubscriptionInteractorImpl.access$toProfileCounter(this.a, subscribers) : null;
            FavoriteSellerCounter subscriptions = subscribeResult2.getSubscriptions();
            if (subscriptions != null) {
                profileCounter = ExtendedProfileSubscriptionInteractorImpl.access$toProfileCounter(this.a, subscriptions);
            }
            return new SubscribeInfo(bool, isNotificationsActivated, access$toProfileCounter, profileCounter);
        }
    }

    public static final class b<T, R> implements Function<UnsubscribeResult, SubscribeInfo> {
        public final /* synthetic */ ExtendedProfileSubscriptionInteractorImpl a;

        public b(ExtendedProfileSubscriptionInteractorImpl extendedProfileSubscriptionInteractorImpl) {
            this.a = extendedProfileSubscriptionInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SubscribeInfo apply(UnsubscribeResult unsubscribeResult) {
            UnsubscribeResult unsubscribeResult2 = unsubscribeResult;
            Boolean bool = Boolean.FALSE;
            FavoriteSellerCounter subscribers = unsubscribeResult2.getSubscribers();
            ProfileCounter access$toProfileCounter = subscribers != null ? ExtendedProfileSubscriptionInteractorImpl.access$toProfileCounter(this.a, subscribers) : null;
            FavoriteSellerCounter subscriptions = unsubscribeResult2.getSubscriptions();
            return new SubscribeInfo(bool, null, access$toProfileCounter, subscriptions != null ? ExtendedProfileSubscriptionInteractorImpl.access$toProfileCounter(this.a, subscriptions) : null);
        }
    }

    @Inject
    public ExtendedProfileSubscriptionInteractorImpl(@NotNull FavoriteSellersApi favoriteSellersApi, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "favoriteSellersApi");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = favoriteSellersApi;
        this.b = notificationManagerProvider;
        this.c = schedulersFactory3;
    }

    public static final ProfileCounter access$toProfileCounter(ExtendedProfileSubscriptionInteractorImpl extendedProfileSubscriptionInteractorImpl, FavoriteSellerCounter favoriteSellerCounter) {
        Objects.requireNonNull(extendedProfileSubscriptionInteractorImpl);
        return new ProfileCounter(favoriteSellerCounter.getTitle(), favoriteSellerCounter.getSubtitle(), null);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable ignoreElements = TypedObservablesKt.toTyped(this.a.changeNotifications("extended_profile", str, z)).subscribeOn(this.c.io()).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "favoriteSellersApi.chang…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> subscribe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(this.a.subscribe("extended_profile", str, this.b.getAreNotificationsEnabled(), true)).subscribeOn(this.c.io()).map(new a(this)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "favoriteSellersApi.subsc…         }.firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeInteractor
    @NotNull
    public Single<SubscribeInfo> unsubscribe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Single<SubscribeInfo> firstOrError = TypedObservablesKt.toTyped(this.a.unsubscribe("extended_profile", str, true)).subscribeOn(this.c.io()).map(new b(this)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "favoriteSellersApi.unsub…         }.firstOrError()");
        return firstOrError;
    }
}
