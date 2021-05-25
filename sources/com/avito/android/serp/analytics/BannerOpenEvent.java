package com.avito.android.serp.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.analytics.BannerEvent;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\n¨\u0006#"}, d2 = {"Lcom/avito/android/serp/analytics/BannerOpenEvent;", "Lcom/avito/android/serp/analytics/BannerEvent;", "", "", "", "params", "", "addedParams", "(Ljava/util/Map;)V", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", "n", "I", VKApiConst.POSITION, "k", "categoryId", "l", "locationId", "o", "clickId", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "Lcom/avito/android/serp/analytics/BannerPageSource;", "source", "Lcom/avito/android/serp/analytics/BannerEvent$Type;", "type", "", "stateId", "logTime", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/serp/analytics/BannerPageSource;Lcom/avito/android/serp/analytics/BannerEvent$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerOpenEvent extends BannerEvent {
    public final String k;
    public final String l;
    public final String m;
    public final int n;
    public final String o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerOpenEvent(@NotNull BannerInfo bannerInfo, @NotNull BannerPageSource bannerPageSource, @NotNull BannerEvent.Type type, @Nullable String str, @Nullable String str2, @Nullable String str3, int i, @NotNull String str4, long j, long j2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        super(bannerInfo, bannerPageSource, type, j, j2, treeClickStreamParent, 3215, 17);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(bannerPageSource, "source");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str4, "clickId");
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = i;
        this.o = str4;
    }

    @Override // com.avito.android.serp.analytics.BannerEvent
    public void addedParams(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        String str = this.k;
        putParam(map, "cid", str != null ? Integer.valueOf(Integer.parseInt(str)) : null);
        putParam(map, "lid", this.l);
        putParam(map, "iid", this.m);
        putParam(map, VKApiConst.POSITION, Integer.valueOf(this.n + 1));
        putParam(map, "uuid", this.o);
    }
}
