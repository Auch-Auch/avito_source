package com.avito.android.search.map.analytics.event;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.SearchParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/avito/android/search/map/analytics/event/SearchByMapEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "f", "J", "total", "", "i", "I", "mapZoom", "h", "Ljava/lang/String;", "searchHash", "Lcom/avito/android/remote/model/SearchParams;", "e", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "", g.a, "Ljava/util/List;", "searchArea", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/SearchParams;JLjava/util/List;Ljava/lang/String;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchByMapEvent extends TreeClickStreamEvent {
    public final SearchParams e;
    public final long f;
    public final List<Double> g;
    public final String h;
    public final int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchByMapEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull SearchParams searchParams, long j2, @Nullable List<Double> list, @NotNull String str, int i2) {
        super(j, treeClickStreamParent, 2743, 4);
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(str, "searchHash");
        this.e = searchParams;
        this.f = j2;
        this.g = list;
        this.h = str;
        this.i = i2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ef, code lost:
        if (r1.contains("company") != false) goto L_0x00f3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016a  */
    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> extraParams() {
        /*
        // Method dump skipped, instructions count: 424
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.analytics.event.SearchByMapEvent.extraParams():java.util.Map");
    }
}
