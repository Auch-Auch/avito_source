package com.avito.android.favorite_sellers;

import android.net.Uri;
import com.avito.android.FavoriteSeller;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.SubscribeResult;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015H\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001b\u0010\u001eJ\u001e\u0010!\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\tH\u0001¢\u0006\u0004\b#\u0010\u0014J\u0010\u0010$\u001a\u00020\fH\u0001¢\u0006\u0004\b$\u0010\u000eJ(\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00152\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b&\u0010'J\"\u0010(\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b(\u0010)J,\u0010,\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0001¢\u0006\u0004\b.\u0010\u0012R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170/8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersInteractorImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersInteractor;", "Lcom/avito/android/favorite_sellers/ScreenModeInteractor;", "", "userKey", "", "needActivate", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "clearSellers", "()V", "Lio/reactivex/rxjava3/core/Observable;", "", "counterChanges", "()Lio/reactivex/rxjava3/core/Observable;", "executeCounterUpdate", "()Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "loadSubscribes", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "", "userIds", "markSellersAsRead", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Completable;", "markSellersAsViewed", "resetCounter", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "isSubscribed", "isNotificationsActivated", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "updates", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite_sellers/ScreenModeInteractor;", "screenModeInteractor", "<init>", "(Lcom/avito/android/favorite_sellers/ScreenModeInteractor;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersInteractorImpl implements FavoriteSellersInteractor, ScreenModeInteractor {
    public final ScreenModeInteractor a;

    @Inject
    public FavoriteSellersInteractorImpl(@NotNull ScreenModeInteractor screenModeInteractor) {
        Intrinsics.checkNotNullParameter(screenModeInteractor, "screenModeInteractor");
        this.a = screenModeInteractor;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.a.changeNotifications(str, z, subscriptionSource);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
        this.a.clearSellers();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Observable<Integer> counterChanges() {
        return this.a.counterChanges();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable executeCounterUpdate() {
        return this.a.executeCounterUpdate();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return this.a.getSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return this.a.getSellersAsMap();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes() {
        return this.a.loadSubscribes();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return this.a.loadSubscribes(uri);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsRead(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "userIds");
        return this.a.markSellersAsRead(list);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsViewed() {
        return this.a.markSellersAsViewed();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    public void resetCounter() {
        this.a.resetCounter();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.a.subscribe(str, subscriptionSource);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.a.unsubscribe(str, subscriptionSource);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.a.updateSeller(str, bool, bool2);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        return this.a.updates();
    }
}
