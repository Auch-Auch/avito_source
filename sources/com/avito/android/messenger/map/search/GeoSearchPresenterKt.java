package com.avito.android.messenger.map.search;

import com.avito.android.messenger.map.search.GeoSearchPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "getStr", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;)Ljava/lang/String;", "str", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class GeoSearchPresenterKt {
    @NotNull
    public static final String getStr(@NotNull GeoSearchPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "$this$str");
        return f.trimMargin$default("GeoSearchPresenter.State(\n        |   query=" + state.getQuery() + ",\n        |   listState=" + state.getListState() + ",\n        |   searchIsInProgress=" + state.getSearchIsInProgress() + ",\n        |   connectionErrorIndicatorState=" + state.getConnectionErrorIndicatorState() + ",\n        |   searchSuggests=" + state.getSearchSuggests() + ",\n        |   favoritePlaces=" + state.getFavoritePlaces() + "\n        |)", null, 1, null);
    }
}
