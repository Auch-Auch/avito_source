package com.avito.android.select.new_metro.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ7\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/select/new_metro/analytics/SelectMetroSingletonAnalyticsImpl;", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "", "locationId", "categoryId", "", "selectedMetro", "", "trackOpenScreen", "(ILjava/lang/Integer;Ljava/util/List;)V", "", "closedWithSave", "trackCloseScreen", "(ILjava/lang/Integer;ZLjava/util/List;)V", "dropSelected", "(ILjava/lang/Integer;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "sessionId", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroSingletonAnalyticsImpl implements SelectMetroAnalytics {
    public final String a = a.I2("UUID.randomUUID().toString()");
    public final Analytics b;

    public SelectMetroSingletonAnalyticsImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = analytics;
    }

    @Override // com.avito.android.select.new_metro.analytics.SelectMetroAnalytics
    public void dropSelected(int i, @Nullable Integer num) {
        this.b.track(new SelectMetroDropSelectedEvent(i, num));
    }

    @Override // com.avito.android.select.new_metro.analytics.SelectMetroAnalytics
    public void trackCloseScreen(int i, @Nullable Integer num, boolean z, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "selectedMetro");
        this.b.track(new SelectMetroCloseScreenEvent(i, num, z, list, this.a));
    }

    @Override // com.avito.android.select.new_metro.analytics.SelectMetroAnalytics
    public void trackOpenScreen(int i, @Nullable Integer num, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "selectedMetro");
        this.b.track(new SelectMetroOpenScreenEvent(i, num, list, this.a));
    }
}
