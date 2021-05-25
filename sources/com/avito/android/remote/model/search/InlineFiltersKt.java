package com.avito.android.remote.model.search;

import com.avito.android.remote.model.search.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/search/Filter;", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "firstOption", "(Lcom/avito/android/remote/model/search/Filter;)Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class InlineFiltersKt {
    @Nullable
    public static final Filter.InnerOptions.Options firstOption(@NotNull Filter filter) {
        List<Filter.InnerOptions.Options> options;
        Intrinsics.checkNotNullParameter(filter, "$this$firstOption");
        List<Filter.InnerOptions> options2 = filter.getOptions();
        boolean z = true;
        if (options2 == null || options2.isEmpty()) {
            return null;
        }
        List<Filter.InnerOptions.Options> options3 = filter.getOptions().get(0).getOptions();
        if (options3 != null && !options3.isEmpty()) {
            z = false;
        }
        if (!z && (options = filter.getOptions().get(0).getOptions()) != null) {
            return options.get(0);
        }
        return null;
    }
}
