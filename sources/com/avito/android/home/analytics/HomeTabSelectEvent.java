package com.avito.android.home.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/avito/android/home/analytics/HomeTabSelectEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "f", "Ljava/lang/String;", "targetPage", "e", "fromPage", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeTabSelectEvent extends TreeClickStreamEvent {
    public final String e;
    public final String f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTabSelectEvent(@NotNull String str, @NotNull String str2, long j, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(j, treeClickStreamParent, 3426, 0);
        Intrinsics.checkNotNullParameter(str, "fromPage");
        Intrinsics.checkNotNullParameter(str2, "targetPage");
        this.e = str;
        this.f = str2;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.e);
        putParam(linkedHashMap, "target_page", this.f);
        return linkedHashMap;
    }
}
