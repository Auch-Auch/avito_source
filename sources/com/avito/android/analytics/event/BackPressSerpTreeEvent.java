package com.avito.android.analytics.event;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/event/BackPressSerpTreeEvent;", "Lcom/avito/android/analytics/event/BackPressTreeEvent;", "", "", "", "getExtraParams", "()Ljava/util/Map;", "f", "Ljava/lang/String;", "getSrcp", "()Ljava/lang/String;", "srcp", g.a, "categoryId", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", "isFromActionBar", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BackPressSerpTreeEvent extends BackPressTreeEvent {
    @NotNull
    public final String f = "search_shop";
    public final String g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackPressSerpTreeEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, boolean z) {
        super(j, treeClickStreamParent, z);
        Intrinsics.checkNotNullParameter(str, "categoryId");
        this.g = str;
    }

    @Override // com.avito.android.analytics.event.BackPressTreeEvent
    @NotNull
    public Map<String, Object> getExtraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "categoryid", this.g);
        return linkedHashMap;
    }

    @Override // com.avito.android.analytics.event.BackPressTreeEvent
    @NotNull
    public String getSrcp() {
        return this.f;
    }
}
