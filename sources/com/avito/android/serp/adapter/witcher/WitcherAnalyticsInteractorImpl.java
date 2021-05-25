package com.avito.android.serp.adapter.witcher;

import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractorImpl;", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor$FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "", "sendClickWitcher", "(Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor$FromBlock;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherAnalyticsInteractorImpl implements WitcherAnalyticsInteractor {
    public final Analytics a;

    @Inject
    public WitcherAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractor
    public void sendClickWitcher(@NotNull WitcherAnalyticsInteractor.FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.a.track(new WitcherOpenSerpClickEvent(fromBlock.getValue()));
    }
}
