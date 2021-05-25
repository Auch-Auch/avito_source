package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JC\u0010\n\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/map/search/StateModifier;", "", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "query", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "searchSuggests", "favoritePlaces", "copy", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/List;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface StateModifier {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.map.search.StateModifier */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GeoSearchPresenter.State copy$default(StateModifier stateModifier, GeoSearchPresenter.State state, String str, Loading loading, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = state.getQuery();
                }
                if ((i & 2) != 0) {
                    loading = state.getSearchSuggests();
                }
                if ((i & 4) != 0) {
                    list = state.getFavoritePlaces();
                }
                return stateModifier.copy(state, str, loading, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
    }

    @NotNull
    GeoSearchPresenter.State copy(@NotNull GeoSearchPresenter.State state, @NotNull String str, @NotNull Loading<List<GeoSearchSuggestItem>> loading, @NotNull List<GeoSearchSuggestItem> list);
}
