package com.avito.android.serp;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/serp/InlineFiltersInteractor;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "", "changesMap", "", UrlParams.SIMPLE_MAP, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFilters", "(Lcom/avito/android/remote/model/SearchParams;Ljava/util/Map;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValues", "applyInlineFilters", "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable applyInlineFilters$default(InlineFiltersInteractor inlineFiltersInteractor, Filter filter, InlineFilterValue inlineFilterValue, SearchParams searchParams, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = false;
                }
                return inlineFiltersInteractor.applyInlineFilters(filter, inlineFilterValue, searchParams, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyInlineFilters");
        }

        public static /* synthetic */ Observable loadInlineFilters$default(InlineFiltersInteractor inlineFiltersInteractor, SearchParams searchParams, Map map, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return inlineFiltersInteractor.loadInlineFilters(searchParams, map, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInlineFilters");
        }
    }

    @NotNull
    Observable<InlineFilters> applyInlineFilters(@NotNull Filter filter, @NotNull InlineFilterValue inlineFilterValue, @Nullable SearchParams searchParams, boolean z);

    @NotNull
    Observable<InlineFilters> loadInlineFilters(@NotNull SearchParams searchParams, @NotNull Map<String, String> map, boolean z);
}
