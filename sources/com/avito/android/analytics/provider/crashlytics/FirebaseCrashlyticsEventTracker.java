package com.avito.android.analytics.provider.crashlytics;

import com.facebook.applinks.AppLinkData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "", "", "message", "", "trackEvent", "(Ljava/lang/String;)V", "", "cause", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "trackException", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "", "logs", "dumpLogs", "(Ljava/util/List;)V", "dumpLogsFromBuffer", "()V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public interface FirebaseCrashlyticsEventTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trackException$default(FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker, String str, Throwable th, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = r.emptyMap();
                }
                firebaseCrashlyticsEventTracker.trackException(str, th, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackException");
        }
    }

    void dumpLogs(@NotNull List<String> list);

    void dumpLogsFromBuffer();

    void trackEvent(@NotNull String str);

    void trackException(@Nullable String str, @NotNull Throwable th, @NotNull Map<String, ? extends Object> map);
}
