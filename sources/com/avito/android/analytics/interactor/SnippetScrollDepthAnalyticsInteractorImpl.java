package com.avito.android.analytics.interactor;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SnippetScrollDepthEventHome;
import com.avito.android.analytics.event.SnippetScrollDepthEventSerp;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "", "offset", "", "", "ids", "advertsItemsCount", "xHash", "totalItemsCount", "", "sendUserScrolledToItemOnHome", "(ILjava/util/List;ILjava/lang/String;I)V", "sendUserScrolledToItemOnSerp", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetScrollDepthAnalyticsInteractorImpl implements SnippetScrollDepthAnalyticsInteractor {
    public final Analytics a;

    @Inject
    public SnippetScrollDepthAnalyticsInteractorImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor
    public void sendUserScrolledToItemOnHome(int i, @NotNull List<String> list, int i2, @NotNull String str, int i3) {
        Intrinsics.checkNotNullParameter(list, "ids");
        Intrinsics.checkNotNullParameter(str, "xHash");
        this.a.track(new SnippetScrollDepthEventHome(i, list, i2, str, i3));
    }

    @Override // com.avito.android.analytics.interactor.SnippetScrollDepthAnalyticsInteractor
    public void sendUserScrolledToItemOnSerp(int i, @NotNull List<String> list, int i2, @NotNull String str, int i3) {
        Intrinsics.checkNotNullParameter(list, "ids");
        Intrinsics.checkNotNullParameter(str, "xHash");
        this.a.track(new SnippetScrollDepthEventSerp(i, list, i2, str, i3));
    }
}
