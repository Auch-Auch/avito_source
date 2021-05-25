package com.avito.android.calls_shared.tracker.errors;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.communications_common.analytics.SimpleErrorTracker;
import com.avito.android.util.Logs;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.AdError;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/calls_shared/tracker/errors/CallsErrorTracker;", "Lcom/avito/android/communications_common/analytics/SimpleErrorTracker;", "", "cause", "", "message", "", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "track", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "Companion", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallsErrorTracker extends SimpleErrorTracker {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/tracker/errors/CallsErrorTracker$Companion;", "", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final String access$categorizeError(Companion companion, Throwable th) {
            Objects.requireNonNull(companion);
            if (th instanceof CallIllegalMviStateException) {
                return "mvi";
            }
            if (th instanceof CallIllegalStateException) {
                return "state";
            }
            return th instanceof CallApiRequestException ? "api" : AdError.UNDEFINED_DOMAIN;
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CallsErrorTracker(@NotNull Analytics analytics) {
        super(analytics);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
    }

    @Override // com.avito.android.communications_common.analytics.SimpleErrorTracker, com.avito.android.communications_common.analytics.ErrorTracker
    public void track(@NotNull Throwable th, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        super.track(th, str, map);
        getAnalytics().track(new StatsdEvent.CountEvent(a.c3("calls.error.", Companion.access$categorizeError(Companion, th)), 0, 2, null));
        Logs.error("CallsErrorTracker", th);
    }
}
