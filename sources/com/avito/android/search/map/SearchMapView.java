package com.avito.android.search.map;

import com.avito.android.search.map.action.MapViewAction;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/search/map/SearchMapView;", "", "Lcom/avito/android/search/map/SearchMapState;", "newState", "", "render", "(Lcom/avito/android/search/map/SearchMapState;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapViewAction;", "getActions", "()Lio/reactivex/rxjava3/core/Observable;", "actions", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SearchMapView {
    @NotNull
    Observable<MapViewAction> getActions();

    void render(@NotNull SearchMapState searchMapState);
}
