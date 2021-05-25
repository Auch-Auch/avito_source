package com.avito.android.serp.analytics;

import a2.g.r.g;
import com.avito.android.analytics.clickstream.AnalyticMetricsFormatter;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.serp.ad.BannerInfo;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001-BK\b\u0004\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010&\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010)\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020\u0010¢\u0006\u0004\b+\u0010,J\u0019\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/avito/android/serp/analytics/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "params", "", "addedParams", "(Ljava/util/Map;)V", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "i", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "type", "", "f", "I", "getRequestCount", "()I", "requestCount", "", "j", "J", "logTime", "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "e", "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "metricsFormatter", "Lcom/avito/android/serp/ad/BannerInfo;", g.a, "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerPageSource;", "h", "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "eventId", "version", "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/serp/analytics/BannerEvent$Type;JJLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;II)V", "Type", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class BannerEvent extends TreeClickStreamEvent {
    public final AnalyticMetricsFormatter e = new AnalyticMetricsFormatter();
    public final int f;
    public final BannerInfo g;
    public final BannerPageSource h;
    public final Type i;
    public final long j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/serp/analytics/BannerEvent$Type;", "", "<init>", "(Ljava/lang/String;I)V", MessengerShareContentUtility.PREVIEW_DEFAULT, "CREDIT", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        DEFAULT,
        CREDIT
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerEvent(@NotNull BannerInfo bannerInfo, @NotNull BannerPageSource bannerPageSource, @NotNull Type type, long j2, long j3, @Nullable TreeClickStreamParent treeClickStreamParent, int i2, int i3) {
        super(j2, treeClickStreamParent, i2, i3);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(type, "type");
        this.g = bannerInfo;
        this.h = bannerPageSource;
        this.i = type;
        this.j = j3;
        this.f = bannerInfo.getFallbackCount() + 1;
    }

    public void addedParams(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public final Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.g.toMap());
        putParam(linkedHashMap, "pagetype", this.h.getAnalyticsName());
        putParam(linkedHashMap, "from_block", Integer.valueOf(this.i.ordinal()));
        if (this.g.getPageCdtm() != 0) {
            putParam(linkedHashMap, "page_cdtm", this.e.formatTime(this.j - this.g.getPageCdtm(), TimeUnit.MILLISECONDS));
        }
        addedParams(linkedHashMap);
        return linkedHashMap;
    }

    public final int getRequestCount() {
        return this.f;
    }
}
