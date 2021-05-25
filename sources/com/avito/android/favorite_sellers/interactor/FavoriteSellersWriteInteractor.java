package com.avito.android.favorite_sellers.interactor;

import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.remote.model.SubscribeResult;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH&¢\u0006\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/avito/android/favorite_sellers/interactor/FavoriteSellersWriteInteractor;", "", "", "userKey", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "needActivate", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "markSellersAsViewed", "()Lio/reactivex/rxjava3/core/Completable;", "", "userIds", "markSellersAsRead", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Observable;", "", "counterChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "resetCounter", "()V", "executeCounterUpdate", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellersWriteInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable changeNotifications$default(FavoriteSellersWriteInteractor favoriteSellersWriteInteractor, String str, boolean z, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    subscriptionSource = null;
                }
                return favoriteSellersWriteInteractor.changeNotifications(str, z, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeNotifications");
        }

        public static /* synthetic */ Single subscribe$default(FavoriteSellersWriteInteractor favoriteSellersWriteInteractor, String str, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    subscriptionSource = null;
                }
                return favoriteSellersWriteInteractor.subscribe(str, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }

        public static /* synthetic */ Completable unsubscribe$default(FavoriteSellersWriteInteractor favoriteSellersWriteInteractor, String str, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    subscriptionSource = null;
                }
                return favoriteSellersWriteInteractor.unsubscribe(str, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unsubscribe");
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource);

    @NotNull
    Observable<Integer> counterChanges();

    @NotNull
    Completable executeCounterUpdate();

    @NotNull
    Completable markSellersAsRead(@NotNull List<String> list);

    @NotNull
    Completable markSellersAsViewed();

    void resetCounter();

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource);

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor
    @NotNull
    Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource);
}
