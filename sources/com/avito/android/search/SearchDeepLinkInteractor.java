package com.avito.android.search;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.util.LoadingState;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JI\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/SearchDeepLinkInteractor;", "", "", "query", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "", "clearGeoFilters", UrlParams.SIMPLE_MAP, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Boolean;Z)Lio/reactivex/rxjava3/core/Observable;", "search-base_release"}, k = 1, mv = {1, 4, 2})
public interface SearchDeepLinkInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadSearchDeepLink$default(SearchDeepLinkInteractor searchDeepLinkInteractor, String str, SearchParams searchParams, String str2, Boolean bool, boolean z, int i, Object obj) {
            if (obj == null) {
                return searchDeepLinkInteractor.loadSearchDeepLink(str, searchParams, str2, bool, (i & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSearchDeepLink");
        }
    }

    @NotNull
    Observable<LoadingState<DeepLink>> loadSearchDeepLink(@NotNull String str, @NotNull SearchParams searchParams, @Nullable String str2, @Nullable Boolean bool, boolean z);
}
