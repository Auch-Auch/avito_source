package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "data", "Lcom/avito/android/remote/model/search/Filter;", "appliedFilter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValues", "Lio/reactivex/rxjava3/core/Observable;", "loadVerticalSearchForm", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;)Lio/reactivex/rxjava3/core/Observable;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface VerticalFilterInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadVerticalSearchForm$default(VerticalFilterInteractor verticalFilterInteractor, VerticalFilterData verticalFilterData, Filter filter, InlineFilterValue inlineFilterValue, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    filter = null;
                }
                if ((i & 4) != 0) {
                    inlineFilterValue = null;
                }
                return verticalFilterInteractor.loadVerticalSearchForm(verticalFilterData, filter, inlineFilterValue);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadVerticalSearchForm");
        }
    }

    @NotNull
    Observable<VerticalFilterData> loadVerticalSearchForm(@NotNull VerticalFilterData verticalFilterData, @Nullable Filter filter, @Nullable InlineFilterValue inlineFilterValue);
}
