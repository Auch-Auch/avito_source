package com.avito.android.inline_filters.dialog;

import com.avito.android.remote.model.search.Filter;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class InlineFilterDialogFactoryKt {
    public static final boolean access$hasGroupsConfig(Filter.Widget widget) {
        Filter.Config config;
        List<Filter.OptionsGroup> groups;
        return ((widget == null || (config = widget.getConfig()) == null || (groups = config.getGroups()) == null) ? 0 : groups.size()) > 0;
    }
}
