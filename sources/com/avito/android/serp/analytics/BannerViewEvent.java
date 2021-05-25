package com.avito.android.serp.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/analytics/BannerViewEvent;", "Lcom/avito/android/serp/analytics/BannerEvent;", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "type", "", "stateId", "logTime", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/serp/analytics/BannerEvent$Type;JJLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerViewEvent extends BannerEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewEvent(@NotNull BannerInfo bannerInfo, @NotNull BannerPageSource bannerPageSource, @NotNull BannerEvent.Type type, long j, long j2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(bannerInfo, bannerPageSource, type, j, j2, treeClickStreamParent, 3968, 1);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
