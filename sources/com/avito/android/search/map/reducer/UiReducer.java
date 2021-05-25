package com.avito.android.search.map.reducer;

import com.avito.android.redux.Reducer;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/reducer/UiReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class UiReducer implements Reducer<SearchMapState, MapAction> {
    @NotNull
    public SearchMapState reduce(@NotNull SearchMapState searchMapState, @NotNull MapAction mapAction) {
        Intrinsics.checkNotNullParameter(searchMapState, "state");
        Intrinsics.checkNotNullParameter(mapAction, "action");
        if (!(mapAction instanceof MapViewAction.LocationRationalResult)) {
            return mapAction instanceof MapViewAction.LocationSnackBarCallback ? SearchMapState.copy$default(searchMapState, null, null, null, null, null, null, null, false, false, 383, null) : searchMapState;
        }
        if (((MapViewAction.LocationRationalResult) mapAction).getResult()) {
            return searchMapState;
        }
        return SearchMapState.copy$default(searchMapState, null, null, null, null, null, null, null, true, false, 383, null);
    }
}
