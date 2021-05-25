package com.avito.android.favorite_sellers.interactor;

import com.avito.android.Features;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.common.CounterInteractor;
import com.avito.android.di.FavoriteSellers;
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
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020#\u0012\b\b\u0001\u00105\u001a\u000202\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b6\u00107J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0012R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractorImpl;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;", "", "userKey", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "needActivate", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "markSellersAsViewed", "()Lio/reactivex/rxjava3/core/Completable;", "", "userIds", "markSellersAsRead", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "", "counterChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "resetCounter", "()V", "executeCounterUpdate", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "d", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationsManagerProvider", "Lcom/avito/android/remote/FavoriteSellersApi;", "e", "Lcom/avito/android/remote/FavoriteSellersApi;", "api", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "src", "Lcom/avito/android/common/CounterInteractor;", "c", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterInteractor", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/Features;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersWriteInteractorImpl implements FavoriteSellersWriteInteractor {
    public final String a;
    public final SchedulersFactory3 b;
    public final CounterInteractor c;
    public final NotificationManagerProvider d;
    public final FavoriteSellersApi e;
    public final Features f;

    public FavoriteSellersWriteInteractorImpl(@NotNull String str, @NotNull SchedulersFactory3 schedulersFactory3, @FavoriteSellers @NotNull CounterInteractor counterInteractor, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull FavoriteSellersApi favoriteSellersApi, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoriteSellersCounterInteractor");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationsManagerProvider");
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = str;
        this.b = schedulersFactory3;
        this.c = counterInteractor;
        this.d = notificationManagerProvider;
        this.e = favoriteSellersApi;
        this.f = features;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "userKey");
        FavoriteSellersApi favoriteSellersApi = this.e;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable<TypedResult<Unit>> subscribeOn = favoriteSellersApi.changeNotifications(str2, str, z).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.changeNotifications(…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.changeNotifications(…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Observable<Integer> counterChanges() {
        return this.c.changes();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable executeCounterUpdate() {
        return this.c.executeUpdate();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsRead(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "userIds");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put("hashUserIds[" + i + ']', t);
            i = i2;
        }
        Observable<TypedResult<Unit>> subscribeOn = this.e.markAsRead(linkedHashMap).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.markAsRead(idMap)\n  …scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.markAsRead(idMap)\n  …        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsViewed() {
        Observable<TypedResult<Unit>> subscribeOn = this.e.clearSellersCount().subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.clearSellersCount()\n…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.clearSellersCount()\n…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    public void resetCounter() {
        this.c.reset();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "userKey");
        if (this.f.getSupportsSubscribeV2().getValue().booleanValue()) {
            FavoriteSellersApi favoriteSellersApi = this.e;
            if (subscriptionSource == null || (str3 = subscriptionSource.getValue()) == null) {
                str3 = this.a;
            }
            Observable subscribeOn = FavoriteSellersApi.DefaultImpls.subscribeV2$default(favoriteSellersApi, str3, str, this.d.getAreNotificationsEnabled(), false, 8, null).subscribeOn(this.b.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.subscribeV2(source?.…scribeOn(schedulers.io())");
            Single<SubscribeResult> firstOrError = TypedObservablesKt.toTyped(subscribeOn).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "api.subscribeV2(source?.…          .firstOrError()");
            return firstOrError;
        }
        FavoriteSellersApi favoriteSellersApi2 = this.e;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable subscribeOn2 = FavoriteSellersApi.DefaultImpls.subscribe$default(favoriteSellersApi2, str2, str, this.d.getAreNotificationsEnabled(), false, 8, null).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "api.subscribe(source?.va…scribeOn(schedulers.io())");
        Single<SubscribeResult> firstOrError2 = TypedObservablesKt.toTyped(subscribeOn2).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError2, "api.subscribe(source?.va…          .firstOrError()");
        return firstOrError2;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "userKey");
        FavoriteSellersApi favoriteSellersApi = this.e;
        if (subscriptionSource == null || (str2 = subscriptionSource.getValue()) == null) {
            str2 = this.a;
        }
        Observable subscribeOn = FavoriteSellersApi.DefaultImpls.unsubscribe$default(favoriteSellersApi, str2, str, false, 4, null).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.unsubscribe(source?.…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.unsubscribe(source?.…        .ignoreElements()");
        return ignoreElements;
    }
}
