package com.avito.android.autoteka_details.core.analytics.event;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/autoteka_details/core/analytics/event/AutotekaDetailsGetReportClickTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "f", "Ljava/lang/String;", "url", "e", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", g.a, "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsGetReportClickTreeEvent extends TreeClickStreamEvent {
    public final String e;
    public final String f;
    public final FromBlock g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutotekaDetailsGetReportClickTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @NotNull String str2, @NotNull FromBlock fromBlock) {
        super(0, treeClickStreamParent, 2398, 2);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.e = str;
        this.f = str2;
        this.g = fromBlock;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        return r.mapOf(TuplesKt.to("iid", this.e), TuplesKt.to("url", this.f), TuplesKt.to("from_block", Integer.valueOf(this.g.getValue())));
    }
}
