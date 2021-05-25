package com.avito.android.analytics.event;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/avito/android/analytics/event/LoadSerpEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "f", "J", "total", "k", "Ljava/lang/String;", "xHash", "Lcom/avito/android/remote/model/SearchParams;", "e", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "i", "fromPage", "j", "fromSource", "", "", g.a, "Ljava/util/List;", "searchArea", "Lcom/avito/android/remote/model/SerpDisplayType;", "h", "Lcom/avito/android/remote/model/SerpDisplayType;", "serpDisplayType", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/SearchParams;JLjava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LoadSerpEvent extends TreeClickStreamEvent {
    public final SearchParams e;
    public final long f;
    public final List<Double> g;
    public final SerpDisplayType h;
    public final String i;
    public final String j;
    public final String k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadSerpEvent(long j2, TreeClickStreamParent treeClickStreamParent, SearchParams searchParams, long j3, List list, SerpDisplayType serpDisplayType, String str, String str2, String str3, int i2, j jVar) {
        this(j2, treeClickStreamParent, searchParams, j3, list, serpDisplayType, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? null : str2, (i2 & 256) != 0 ? null : str3);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0162  */
    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> extraParams() {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.event.LoadSerpEvent.extraParams():java.util.Map");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadSerpEvent(long j2, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull SearchParams searchParams, long j3, @Nullable List<Double> list, @Nullable SerpDisplayType serpDisplayType, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(j2, treeClickStreamParent, 2647, 7);
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        this.e = searchParams;
        this.f = j3;
        this.g = list;
        this.h = serpDisplayType;
        this.i = str;
        this.j = str2;
        this.k = str3;
    }
}
