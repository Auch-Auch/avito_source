package com.avito.android.advert.item.sellersubscription;

import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b:\u0010;J'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0007H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160*8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractorImpl;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;", "Lcom/avito/android/FavoriteSellersRepository;", "", "userKey", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "needActivate", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "clearSellers", "()V", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "isSubscribed", "isNotificationsActivated", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "updates", "()Lio/reactivex/rxjava3/core/Observable;", "e", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lcom/avito/android/remote/FavoriteSellersApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/FavoriteSellersApi;", "api", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "src", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "c", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "<init>", "(Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SellerSubscriptionInteractorImpl implements SellerSubscriptionInteractor, FavoriteSellersRepository {
    public final String a = SubscriptionSource.ADVERT_DETAILS.getValue();
    public final FavoriteSellersApi b;
    public final NotificationManagerProvider c;
    public final SchedulersFactory3 d;
    public final FavoriteSellersRepository e;
    public final Features f;

    @Inject
    public SellerSubscriptionInteractorImpl(@NotNull FavoriteSellersApi favoriteSellersApi, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = favoriteSellersApi;
        this.c = notificationManagerProvider;
        this.d = schedulersFactory3;
        this.e = favoriteSellersRepository;
        this.f = features;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "userKey");
        FavoriteSellersApi favoriteSellersApi = this.b;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable<TypedResult<Unit>> subscribeOn = favoriteSellersApi.changeNotifications(str2, str, z).subscribeOn(this.d.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.changeNotifications(…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.changeNotifications(…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
        this.e.clearSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return this.e.getSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return this.e.getSellersAsMap();
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "userKey");
        if (this.f.getSupportsSubscribeV2().getValue().booleanValue()) {
            FavoriteSellersApi favoriteSellersApi = this.b;
            if (subscriptionSource == null || (str3 = subscriptionSource.getValue()) == null) {
                str3 = this.a;
            }
            Observable subscribeOn = FavoriteSellersApi.DefaultImpls.subscribeV2$default(favoriteSellersApi, str3, str, this.c.getAreNotificationsEnabled(), false, 8, null).subscribeOn(this.d.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.subscribeV2(\n       …scribeOn(schedulers.io())");
            Single<SubscribeResult> firstOrError = TypedObservablesKt.toTyped(subscribeOn).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "api.subscribeV2(\n       …          .firstOrError()");
            return firstOrError;
        }
        FavoriteSellersApi favoriteSellersApi2 = this.b;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable subscribeOn2 = FavoriteSellersApi.DefaultImpls.subscribe$default(favoriteSellersApi2, str2, str, this.c.getAreNotificationsEnabled(), false, 8, null).subscribeOn(this.d.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "api.subscribe(\n         …scribeOn(schedulers.io())");
        Single<SubscribeResult> firstOrError2 = TypedObservablesKt.toTyped(subscribeOn2).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError2, "api.subscribe(\n         …          .firstOrError()");
        return firstOrError2;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "userKey");
        FavoriteSellersApi favoriteSellersApi = this.b;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable subscribeOn = FavoriteSellersApi.DefaultImpls.unsubscribe$default(favoriteSellersApi, str2, str, false, 4, null).subscribeOn(this.d.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.unsubscribe(source?.…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.unsubscribe(source?.…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.e.updateSeller(str, bool, bool2);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        return this.e.updates();
    }
}
