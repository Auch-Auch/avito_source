package com.avito.android.communications_common.analytics;

import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/communications_common/analytics/ErrorTracker;", "", "", "cause", "", "message", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "track", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/Map;)V", "communications-common_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.communications_common.analytics.ErrorTracker */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void track$default(ErrorTracker errorTracker, Throwable th, String str, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    map = r.emptyMap();
                }
                errorTracker.track(th, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
    }

    void track(@NotNull Throwable th, @Nullable String str, @NotNull Map<String, ? extends Object> map);
}
