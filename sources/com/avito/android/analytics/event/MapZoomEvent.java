package com.avito.android.analytics.event;

import a2.g.r.g;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/analytics/event/MapZoomEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "", "e", "Ljava/util/List;", "searchArea", "f", "Ljava/lang/String;", "searchHash", "", g.a, "I", "mapZoom", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/util/List;Ljava/lang/String;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapZoomEvent extends TreeClickStreamEvent {
    public final List<Double> e;
    public final String f;
    public final int g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MapZoomEvent(long j, TreeClickStreamParent treeClickStreamParent, List list, String str, int i, int i2, j jVar) {
        this(j, treeClickStreamParent, (i2 & 4) != 0 ? null : list, str, i);
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "search_area", this.e);
        putParam(linkedHashMap, "x", this.f);
        putParam(linkedHashMap, "map_zoom", Integer.valueOf(this.g));
        return linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapZoomEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable List<Double> list, @NotNull String str, int i) {
        super(j, treeClickStreamParent, 2740, 3);
        Intrinsics.checkNotNullParameter(str, "searchHash");
        this.e = list;
        this.f = str;
        this.g = i;
    }
}
