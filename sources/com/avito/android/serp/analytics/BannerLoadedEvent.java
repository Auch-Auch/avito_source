package com.avito.android.serp.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/avito/android/serp/analytics/BannerLoadedEvent;", "Lcom/avito/android/serp/analytics/BannerEvent;", "", "", "", "params", "", "addedParams", "(Ljava/util/Map;)V", "l", "Ljava/lang/String;", "locationId", AuthSource.OPEN_CHANNEL_LIST, BookingInfoActivity.EXTRA_ITEM_ID, "k", "categoryId", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "type", "", "stateId", "logTime", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/serp/analytics/BannerEvent$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerLoadedEvent extends BannerEvent {
    public final String k;
    public final String l;
    public final String m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerLoadedEvent(@NotNull BannerInfo bannerInfo, @NotNull BannerPageSource bannerPageSource, @NotNull BannerEvent.Type type, @Nullable String str, @Nullable String str2, @Nullable String str3, long j, long j2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(bannerInfo, bannerPageSource, type, j, j2, treeClickStreamParent, 3251, 5);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(type, "type");
        this.k = str;
        this.l = str2;
        this.m = str3;
    }

    @Override // com.avito.android.serp.analytics.BannerEvent
    public void addedParams(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        String str = this.k;
        putParam(map, "cid", str != null ? Integer.valueOf(Integer.parseInt(str)) : null);
        putParam(map, "lid", this.l);
        putParam(map, "iid", this.m);
        putParam(map, "req_num", Integer.valueOf(getRequestCount()));
    }
}
