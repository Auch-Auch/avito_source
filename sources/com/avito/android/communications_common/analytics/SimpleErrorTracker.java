package com.avito.android.communications_common.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/communications_common/analytics/SimpleErrorTracker;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "", "cause", "", "message", "", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "track", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "communications-common_release"}, k = 1, mv = {1, 4, 2})
public class SimpleErrorTracker implements ErrorTracker {
    @NotNull
    public final Analytics a;

    public SimpleErrorTracker(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.a;
    }

    @Override // com.avito.android.communications_common.analytics.ErrorTracker
    public void track(@NotNull Throwable th, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        Analytics analytics = this.a;
        if (str == null) {
            str = "";
        }
        analytics.track(new NonFatalError(str, th, map));
    }
}
