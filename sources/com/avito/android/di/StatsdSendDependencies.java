package com.avito.android.di;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.statsd.StatsdApi;
import com.avito.android.analytics.statsd.StatsdCommonModule;
import com.avito.android.analytics.statsd.StatsdRecord;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/StatsdSendDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/analytics/statsd/StatsdApi;", "statsdApi", "()Lcom/avito/android/analytics/statsd/StatsdApi;", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/analytics/statsd/StatsdRecord;", "statsdEventStorage", "()Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "userAgentInterceptor", "()Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface StatsdSendDependencies extends CoreComponentDependencies {
    @NotNull
    StatsdApi statsdApi();

    @StatsdCommonModule.Statsd
    @NotNull
    InHouseEventStorage<StatsdRecord> statsdEventStorage();

    @NotNull
    UserAgentInterceptor userAgentInterceptor();
}
