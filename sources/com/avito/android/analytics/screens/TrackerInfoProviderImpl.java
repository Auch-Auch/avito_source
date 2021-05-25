package com.avito.android.analytics.screens;

import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/screens/TrackerInfoProviderImpl;", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPrefixStatsd", "()Ljava/lang/String;", "prefixStatsd", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "<init>", "(Lcom/avito/android/analytics/grafana/GraphitePrefix;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class TrackerInfoProviderImpl implements TrackerInfoProvider {
    @NotNull
    public final String a;

    @Inject
    public TrackerInfoProviderImpl(@NotNull GraphitePrefix graphitePrefix) {
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        this.a = graphitePrefix.getVersionsPrefix() + ".screen-performance";
    }

    @Override // com.avito.android.analytics.screens.TrackerInfoProvider
    @NotNull
    public String getPrefixStatsd() {
        return this.a;
    }
}
