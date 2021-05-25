package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.provider.statsd.StatsdPendingFlushInteractor;
import com.avito.android.analytics.statsd.StatsdCommonModule;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/StatsdModule;", "", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "taskScheduler", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "provideFlushInteractor", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {StatsdCommonModule.class, UserAgentModule.class})
public final class StatsdModule {
    @NotNull
    public static final StatsdModule INSTANCE = new StatsdModule();

    @Provides
    @JvmStatic
    @NotNull
    @StatsdCommonModule.Statsd
    public static final InHouseAnalyticsFlushInteractor provideFlushInteractor(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        return new StatsdPendingFlushInteractor(shortTaskExactScheduler);
    }
}
