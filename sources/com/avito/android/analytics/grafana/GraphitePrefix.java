package com.avito.android.analytics.grafana;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/grafana/GraphitePrefix;", "", "", "getVersionsPrefix", "()Ljava/lang/String;", "versionsPrefix", "getAppType", "getAppType$annotations", "()V", "appType", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public interface GraphitePrefix {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Deprecated(message = "Never use directly.")
        public static /* synthetic */ void getAppType$annotations() {
        }
    }

    @NotNull
    String getAppType();

    @NotNull
    String getVersionsPrefix();
}
