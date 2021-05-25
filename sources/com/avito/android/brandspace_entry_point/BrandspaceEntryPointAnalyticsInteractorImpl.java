package com.avito.android.brandspace_entry_point;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.brandspace_entry_point.analytics.BrandspaceEntryPointViewEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractorImpl;", "Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;", "", "source", "brandSlug", "", "sendBrandspaceEntryPointView", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceEntryPointAnalyticsInteractorImpl implements BrandspaceEntryPointAnalyticsInteractor {
    public final Analytics a;
    public final Features b;

    public BrandspaceEntryPointAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = analytics;
        this.b = features;
    }

    @Override // com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor
    public void sendBrandspaceEntryPointView(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, "brandSlug");
        boolean z = false;
        if (ThreadLocalRandom.current().nextInt(100) <= (this.b.getBrandspaceEntryPointDebug().invoke().booleanValue() ? 49 : 0)) {
            z = true;
        }
        if (z) {
            this.a.track(new BrandspaceEntryPointViewEvent(str, str2));
        }
    }
}
