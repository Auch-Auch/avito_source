package com.avito.android.favorite_sellers;

import android.net.Uri;
import com.avito.android.FavoriteSeller;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor;
import com.avito.android.remote.model.FavoriteSellersLoadingResult;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.util.rx3.Singles;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010=\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J'\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0018H\u0016¢\u0006\u0004\b!\u0010\u001bJ+\u0010$\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0019H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0019H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\u0013J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0007H\u0001¢\u0006\u0004\b+\u0010\u001fJ\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00072\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b+\u0010.R\u001c\u0010/\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u00102R\u001c\u0010;\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b;\u00100\u001a\u0004\b<\u00102¨\u0006@"}, d2 = {"Lcom/avito/android/favorite_sellers/ReadScreenMode;", "Lcom/avito/android/favorite_sellers/ScreenMode;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "", "userKey", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "needActivate", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "markSellersAsViewed", "()Lio/reactivex/rxjava3/core/Completable;", "", "userIds", "markSellersAsRead", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "", "updates", "()Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "()Lio/reactivex/rxjava3/core/Single;", "", "counterChanges", "isSubscribed", "isNotificationsActivated", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "clearSellers", "()V", "resetCounter", "executeCounterUpdate", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "loadSubscribes", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "withPullToRefresh", "Z", "getWithPullToRefresh", "()Z", "withSubscribeToggle", "getWithSubscribeToggle", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "shouldTrackOpenTabEvent", "getShouldTrackOpenTabEvent", "withNotificationsToggle", "getWithNotificationsToggle", "readInteractor", "<init>", "(Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class ReadScreenMode implements ScreenMode, FavoriteSellersReadInteractor {
    public final /* synthetic */ FavoriteSellersReadInteractor a;

    public ReadScreenMode(@NotNull FavoriteSellersReadInteractor favoriteSellersReadInteractor) {
        Intrinsics.checkNotNullParameter(favoriteSellersReadInteractor, "readInteractor");
        this.a = favoriteSellersReadInteractor;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Observable<Integer> counterChanges() {
        Observable<Integer> never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
        return never;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable executeCounterUpdate() {
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return Singles.toSingle(y.emptySet());
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return r.emptyMap();
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeAnalytics
    public boolean getShouldTrackOpenTabEvent() {
        return false;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithNotificationsToggle() {
        return false;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithPullToRefresh() {
        return false;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithSubscribeToggle() {
        return false;
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
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsViewed() {
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    public void resetCounter() {
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Single<SubscribeResult> never = Single.never();
        Intrinsics.checkNotNullExpressionValue(never, "Single.never()");
        return never;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        Observable<Unit> never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
        return never;
    }
}
