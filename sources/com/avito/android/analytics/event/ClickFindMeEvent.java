package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/event/ClickFindMeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "", "e", "Ljava/util/List;", "searchArea", "f", "Ljava/lang/String;", "searchHash", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/util/List;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClickFindMeEvent extends TreeClickStreamEvent {
    public final List<Double> e;
    public final String f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickFindMeEvent(long j, TreeClickStreamParent treeClickStreamParent, List list, String str, int i, j jVar) {
        this(j, treeClickStreamParent, (i & 4) != 0 ? null : list, str);
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "search_area", this.e);
        putParam(linkedHashMap, "x", this.f);
        return linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickFindMeEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable List<Double> list, @NotNull String str) {
        super(j, treeClickStreamParent, 2741, 4);
        Intrinsics.checkNotNullParameter(str, "searchHash");
        this.e = list;
        this.f = str;
    }
}
