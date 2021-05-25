package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.NextActionType;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class VerticalFilterPresenterKt {
    public static final NextActionType access$nexActionType(Filter filter) {
        Filter.Widget widget;
        Filter.Config config;
        Filter.NextAction nextAction;
        if (filter == null || (widget = filter.getWidget()) == null || (config = widget.getConfig()) == null || (nextAction = config.getNextAction()) == null) {
            return null;
        }
        return nextAction.getType();
    }
}
