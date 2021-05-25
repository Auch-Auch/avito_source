package com.avito.android.search.map.interactor;

import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.remote.model.search.map.PinAdvertsResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJI\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000b0\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "Lcom/avito/android/component/search/SuggestInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "updateSearchParams", "(Lcom/avito/android/remote/model/SearchParams;)Z", "Lcom/avito/android/remote/model/search/map/Area;", "area", UrlParams.SIMPLE_MAP, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/search/map/MarkersResponse;", "loadMarkers", "(Lcom/avito/android/remote/model/search/map/Area;Z)Lio/reactivex/rxjava3/core/Observable;", "", "", "changesMap", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFilters", "(Ljava/util/Map;Z)Lio/reactivex/rxjava3/core/Observable;", "id", "", "limit", "isFirstPage", "Lcom/avito/android/remote/model/search/map/PinAdvertsResult;", "loadAdvertsInPin", "(Ljava/lang/String;IZ)Lio/reactivex/rxjava3/core/Observable;", "clearGeoFilters", "query", "context", "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SearchMapInteractor extends SuggestInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.search.map.interactor.SearchMapInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable loadInlineFilters$default(SearchMapInteractor searchMapInteractor, Map map, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return searchMapInteractor.loadInlineFilters(map, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInlineFilters");
        }

        public static /* synthetic */ Observable loadMarkers$default(SearchMapInteractor searchMapInteractor, Area area, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return searchMapInteractor.loadMarkers(area, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMarkers");
        }

        public static /* synthetic */ Observable loadSearchDeepLink$default(SearchMapInteractor searchMapInteractor, Boolean bool, String str, String str2, SearchParams searchParams, boolean z, int i, Object obj) {
            if (obj == null) {
                return searchMapInteractor.loadSearchDeepLink(bool, str, str2, searchParams, (i & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSearchDeepLink");
        }
    }

    @NotNull
    Observable<LoadingState<PinAdvertsResult>> loadAdvertsInPin(@NotNull String str, int i, boolean z);

    @NotNull
    Observable<LoadingState<InlineFilters>> loadInlineFilters(@NotNull Map<String, String> map, boolean z);

    @NotNull
    Observable<LoadingState<MarkersResponse>> loadMarkers(@Nullable Area area, boolean z);

    @NotNull
    Observable<LoadingState<DeepLink>> loadSearchDeepLink(@Nullable Boolean bool, @NotNull String str, @Nullable String str2, @NotNull SearchParams searchParams, boolean z);

    boolean updateSearchParams(@NotNull SearchParams searchParams);
}
