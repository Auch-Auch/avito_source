package com.avito.android.search.subscriptions;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\u000fJ#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0014\u0010\u000fJ-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "pushFrequency", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SearchSubscription;", "subscribeToSearch", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/Integer;Lcom/avito/android/remote/model/search/map/Area;)Lio/reactivex/rxjava3/core/Observable;", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SubscriptionResult;", "unsubscribeFromSearch", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "searchSubscriptionId", "updatePushFrequencyForSubscription", "filterId", "Lcom/avito/android/deep_linking/links/DeepLink;", "getSearchSubscriptionControlDeeplink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "search-base_release"}, k = 1, mv = {1, 4, 2})
public interface SubscribeSearchInteractor {
    @NotNull
    Observable<LoadingState<DeepLink>> getSearchSubscriptionControlDeeplink(@Nullable String str, @NotNull SearchParams searchParams);

    @NotNull
    Observable<LoadingState<SearchSubscription>> subscribeToSearch(@NotNull SearchParams searchParams, @Nullable Integer num, @Nullable Area area);

    @NotNull
    Observable<LoadingState<SearchSubscription>> subscribeToSearch(@NotNull String str, @Nullable Integer num);

    @NotNull
    Observable<LoadingState<SubscriptionResult>> unsubscribeFromSearch(@NotNull String str);

    @NotNull
    Observable<LoadingState<SubscriptionResult>> updatePushFrequencyForSubscription(@NotNull String str, @Nullable Integer num);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable subscribeToSearch$default(SubscribeSearchInteractor subscribeSearchInteractor, SearchParams searchParams, Integer num, Area area, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    area = null;
                }
                return subscribeSearchInteractor.subscribeToSearch(searchParams, num, area);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeToSearch");
        }

        public static /* synthetic */ Observable subscribeToSearch$default(SubscribeSearchInteractor subscribeSearchInteractor, String str, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                return subscribeSearchInteractor.subscribeToSearch(str, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeToSearch");
        }
    }
}
