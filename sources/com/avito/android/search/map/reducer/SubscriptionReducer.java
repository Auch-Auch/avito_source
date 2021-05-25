package com.avito.android.search.map.reducer;

import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.redux.Reducer;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.search.map.LoadState;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.SubscriptionAction;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/reducer/SubscriptionReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionReducer implements Reducer<SearchMapState, MapAction> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SearchSubscribeReason.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @NotNull
    public SearchMapState reduce(@NotNull SearchMapState searchMapState, @NotNull MapAction mapAction) {
        SearchMapState.SerpState serpState;
        SearchMapState copy$default;
        SearchMapState.SerpState copy$default2;
        SearchPushSubscription subscription;
        Intrinsics.checkNotNullParameter(searchMapState, "state");
        Intrinsics.checkNotNullParameter(mapAction, "action");
        SearchMapState.SerpState serpState2 = searchMapState.getSerpState();
        String str = null;
        if (mapAction instanceof SubscriptionAction.ShowSubscriptionAction) {
            copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, ((SubscriptionAction.ShowSubscriptionAction) mapAction).getSubscribe(), null, false, 0, 0, false, null, null, null, 523263, null);
        } else if (mapAction instanceof SubscriptionAction.LoadSubscriptionAction) {
            SubscriptionAction.LoadSubscriptionAction loadSubscriptionAction = (SubscriptionAction.LoadSubscriptionAction) mapAction;
            LoadingState<SearchSubscription> state = loadSubscriptionAction.getState();
            if (state instanceof LoadingState.Loading) {
                copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, false, LoadState.LOADING, false, 0, 0, false, null, null, null, 522239, null);
            } else if (state instanceof LoadingState.Loaded) {
                copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, ((SearchSubscription) ((LoadingState.Loaded) loadSubscriptionAction.getState()).getData()).getId(), true, LoadState.LOAD, false, 0, 0, false, null, null, null, 520703, null);
            } else if (state instanceof LoadingState.Error) {
                copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, false, LoadState.ERROR, false, 0, 0, false, null, null, null, 522239, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (mapAction instanceof MapViewAction.PushSubscriptionStateChanged) {
                MapViewAction.PushSubscriptionStateChanged pushSubscriptionStateChanged = (MapViewAction.PushSubscriptionStateChanged) mapAction;
                SaveSearchLink second = pushSubscriptionStateChanged.getSubscribeData().getSecond();
                SaveSearchLink saveSearchLink = !(second instanceof SaveSearchLink) ? null : second;
                if (!(saveSearchLink == null || (subscription = saveSearchLink.getSubscription()) == null)) {
                    str = subscription.getFilterId();
                }
                SearchMapState.SerpState copy$default3 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, second instanceof SaveSearchLink.Edit, null, false, 0, 0, false, null, null, null, 523263, null);
                int ordinal = pushSubscriptionStateChanged.getSubscribeData().getFirst().ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        copy$default3 = SearchMapState.SerpState.copy$default(copy$default3, null, null, false, null, null, null, null, 0, null, null, false, null, false, 0, 0, false, null, null, null, 523775, null);
                    }
                } else if (str != null) {
                    copy$default3 = SearchMapState.SerpState.copy$default(copy$default3, null, null, false, null, null, null, null, 0, null, str, false, null, false, 0, 0, false, null, null, null, 523775, null);
                }
                serpState = copy$default3;
            } else if (mapAction instanceof SubscriptionAction.LoadUnsubscriptionAction) {
                LoadingState<SubscriptionResult> state2 = ((SubscriptionAction.LoadUnsubscriptionAction) mapAction).getState();
                if (state2 instanceof LoadingState.Loading) {
                    copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, false, LoadState.LOADING, false, 0, 0, false, null, null, null, 522239, null);
                } else if (state2 instanceof LoadingState.Loaded) {
                    copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, false, LoadState.LOAD, false, 0, 0, false, null, null, null, 521215, null);
                } else if (state2 instanceof LoadingState.Error) {
                    copy$default2 = SearchMapState.SerpState.copy$default(serpState2, null, null, false, null, null, null, null, 0, null, null, false, LoadState.ERROR, false, 0, 0, false, null, null, null, 522239, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                serpState = null;
            }
            return (serpState == null || (copy$default = SearchMapState.copy$default(searchMapState, null, null, null, null, null, serpState, null, false, false, 479, null)) == null) ? searchMapState : copy$default;
        }
        serpState = copy$default2;
        if (serpState == null) {
            return searchMapState;
        }
    }
}
