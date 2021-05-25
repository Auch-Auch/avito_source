package com.avito.android.favorite_sellers;

import android.net.Uri;
import com.avito.android.FavoriteSeller;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersSyncInteractor;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010C\u001a\u00020\u0002\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\bF\u0010GJ\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\u000bJ,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001d\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b!\u0010\"J*\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00052\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b$\u0010%J$\u0010&\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020 H\u0001¢\u0006\u0004\b(\u0010\"J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0005H\u0001¢\u0006\u0004\b+\u0010\bJ,\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u0015H\u0001¢\u0006\u0004\b0\u0010\u0018R\u001c\u00105\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00108\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001c\u0010;\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020*0<8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001c\u0010B\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b@\u00102\u001a\u0004\bA\u00104¨\u0006H"}, d2 = {"Lcom/avito/android/favorite_sellers/WriteScreenMode;", "Lcom/avito/android/favorite_sellers/ScreenMode;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;", "Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/FavoriteSellersLoadingResult;", "loadSubscribes", "()Lio/reactivex/rxjava3/core/Single;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Single;", "", "userKey", "", "needActivate", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "", "counterChanges", "()Lio/reactivex/rxjava3/core/Observable;", "executeCounterUpdate", "()Lio/reactivex/rxjava3/core/Completable;", "", "userIds", "markSellersAsRead", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Completable;", "markSellersAsViewed", "", "resetCounter", "()V", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "clearSellers", "", "Lcom/avito/android/FavoriteSeller;", "getSellers", "isSubscribed", "isNotificationsActivated", "updateSeller", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Completable;", "updates", AuthSource.SEND_ABUSE, "Z", "getWithSubscribeToggle", "()Z", "withSubscribeToggle", "d", "getShouldTrackOpenTabEvent", "shouldTrackOpenTabEvent", AuthSource.BOOKING_ORDER, "getWithNotificationsToggle", "withNotificationsToggle", "", "getSellersAsMap", "()Ljava/util/Map;", "sellersAsMap", "c", "getWithPullToRefresh", "withPullToRefresh", "readInteractor", "writeInteractor", "syncInteractor", "<init>", "(Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersReadInteractor;Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersSyncInteractor;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class WriteScreenMode implements ScreenMode, FavoriteSellersReadInteractor, FavoriteSellersWriteInteractor, FavoriteSellersSyncInteractor {
    public final boolean a = true;
    public final boolean b = true;
    public final boolean c = true;
    public final boolean d = true;
    public final /* synthetic */ FavoriteSellersReadInteractor e;
    public final /* synthetic */ FavoriteSellersWriteInteractor f;
    public final /* synthetic */ FavoriteSellersSyncInteractor g;

    public WriteScreenMode(@NotNull FavoriteSellersReadInteractor favoriteSellersReadInteractor, @NotNull FavoriteSellersWriteInteractor favoriteSellersWriteInteractor, @NotNull FavoriteSellersSyncInteractor favoriteSellersSyncInteractor) {
        Intrinsics.checkNotNullParameter(favoriteSellersReadInteractor, "readInteractor");
        Intrinsics.checkNotNullParameter(favoriteSellersWriteInteractor, "writeInteractor");
        Intrinsics.checkNotNullParameter(favoriteSellersSyncInteractor, "syncInteractor");
        this.e = favoriteSellersReadInteractor;
        this.f = favoriteSellersWriteInteractor;
        this.g = favoriteSellersSyncInteractor;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.f.changeNotifications(str, z, subscriptionSource);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    public void clearSellers() {
        this.g.clearSellers();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Observable<Integer> counterChanges() {
        return this.f.counterChanges();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable executeCounterUpdate() {
        return this.f.executeCounterUpdate();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Single<Set<FavoriteSeller>> getSellers() {
        return this.g.getSellers();
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Map<String, FavoriteSeller> getSellersAsMap() {
        return this.g.getSellersAsMap();
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeAnalytics
    public boolean getShouldTrackOpenTabEvent() {
        return this.d;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithNotificationsToggle() {
        return this.b;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithPullToRefresh() {
        return this.c;
    }

    @Override // com.avito.android.favorite_sellers.ScreenModeButtons
    public boolean getWithSubscribeToggle() {
        return this.a;
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes() {
        return this.e.loadSubscribes();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractor
    @NotNull
    public Single<FavoriteSellersLoadingResult> loadSubscribes(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return this.e.loadSubscribes(uri);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsRead(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "userIds");
        return this.f.markSellersAsRead(list);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    @NotNull
    public Completable markSellersAsViewed() {
        return this.f.markSellersAsViewed();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor
    public void resetCounter() {
        this.f.resetCounter();
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.f.subscribe(str, subscriptionSource);
    }

    @Override // com.avito.android.favorite_sellers.interactor.FavoriteSellersWriteInteractor, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    public Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.f.unsubscribe(str, subscriptionSource);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Completable updateSeller(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return this.g.updateSeller(str, bool, bool2);
    }

    @Override // com.avito.android.FavoriteSellersRepository
    @NotNull
    public Observable<Unit> updates() {
        return this.g.updates();
    }
}
