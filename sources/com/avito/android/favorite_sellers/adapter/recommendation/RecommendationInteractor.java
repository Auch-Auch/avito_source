package com.avito.android.favorite_sellers.adapter.recommendation;

import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.remote.model.SubscribeResult;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "", "", "userKey", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SubscribeResult;", "subscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Completable;", "unsubscribe", "(Ljava/lang/String;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "", "needActivate", "changeNotifications", "(Ljava/lang/String;ZLcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lio/reactivex/rxjava3/core/Completable;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface RecommendationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable changeNotifications$default(RecommendationInteractor recommendationInteractor, String str, boolean z, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    subscriptionSource = null;
                }
                return recommendationInteractor.changeNotifications(str, z, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeNotifications");
        }

        public static /* synthetic */ Single subscribe$default(RecommendationInteractor recommendationInteractor, String str, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    subscriptionSource = null;
                }
                return recommendationInteractor.subscribe(str, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }

        public static /* synthetic */ Completable unsubscribe$default(RecommendationInteractor recommendationInteractor, String str, SubscriptionSource subscriptionSource, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    subscriptionSource = null;
                }
                return recommendationInteractor.unsubscribe(str, subscriptionSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unsubscribe");
        }
    }

    @NotNull
    Completable changeNotifications(@NotNull String str, boolean z, @Nullable SubscriptionSource subscriptionSource);

    @NotNull
    Single<SubscribeResult> subscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource);

    @NotNull
    Completable unsubscribe(@NotNull String str, @Nullable SubscriptionSource subscriptionSource);
}
