package com.avito.android.serp.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/analytics/BannerRenderEvent;", "Lcom/avito/android/serp/analytics/BannerEvent;", "", "", "", "params", "", "addedParams", "(Ljava/util/Map;)V", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "type", "", "stateId", "logTime", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/serp/analytics/BannerEvent$Type;JJLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerRenderEvent extends BannerEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerRenderEvent(@NotNull BannerInfo bannerInfo, @NotNull BannerPageSource bannerPageSource, @NotNull BannerEvent.Type type, long j, long j2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(bannerInfo, bannerPageSource, type, j, j2, treeClickStreamParent, 3970, 1);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // com.avito.android.serp.analytics.BannerEvent
    public void addedParams(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        putParam(map, "req_num", Integer.valueOf(getRequestCount()));
    }
}
