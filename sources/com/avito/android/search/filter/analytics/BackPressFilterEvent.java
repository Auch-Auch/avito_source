package com.avito.android.search.filter.analytics;

import com.avito.android.analytics.event.BackPressTreeEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/filter/analytics/BackPressFilterEvent;", "Lcom/avito/android/analytics/event/BackPressTreeEvent;", "", "f", "Ljava/lang/String;", "getSrcp", "()Ljava/lang/String;", "srcp", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", "isFromActionBar", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class BackPressFilterEvent extends BackPressTreeEvent {
    @NotNull
    public final String f = "filters";

    public BackPressFilterEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z) {
        super(j, treeClickStreamParent, z);
    }

    @Override // com.avito.android.analytics.event.BackPressTreeEvent
    @NotNull
    public String getSrcp() {
        return this.f;
    }
}
