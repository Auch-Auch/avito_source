package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseCommonSendingModule;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegate;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegateImpl;
import com.avito.android.analytics.statsd.StatsdSender;
import com.avito.android.analytics.statsd.StatsdSenderImpl;
import com.avito.android.di.PerService;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/StatsdSendingModule;", "", "Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegateImpl;", "delegate", "Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "bindsSendStatsdEventsTaskDelegate", "(Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegateImpl;)Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "Lcom/avito/android/analytics/statsd/StatsdSenderImpl;", "Lcom/avito/android/analytics/statsd/StatsdSender;", "bindsStatsdSender", "(Lcom/avito/android/analytics/statsd/StatsdSenderImpl;)Lcom/avito/android/analytics/statsd/StatsdSender;", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {InHouseCommonSendingModule.class, UserAgentModule.class})
public interface StatsdSendingModule {
    @PerService
    @Binds
    @NotNull
    SendStatsdEventsTaskDelegate bindsSendStatsdEventsTaskDelegate(@NotNull SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl);

    @PerService
    @Binds
    @NotNull
    StatsdSender bindsStatsdSender(@NotNull StatsdSenderImpl statsdSenderImpl);
}
