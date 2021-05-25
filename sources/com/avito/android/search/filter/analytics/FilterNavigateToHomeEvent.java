package com.avito.android.search.filter.analytics;

import com.avito.android.analytics.event.NavigateToHomeScreenEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/search/filter/analytics/FilterNavigateToHomeEvent;", "Lcom/avito/android/analytics/event/NavigateToHomeScreenEvent;", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FilterNavigateToHomeEvent extends NavigateToHomeScreenEvent {
    public FilterNavigateToHomeEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(j, treeClickStreamParent, "filters");
    }
}
