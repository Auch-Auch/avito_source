package com.avito.android.di.module;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.clickstream.ClickStreamCommonModule;
import com.avito.android.analytics.clickstream.ClickStreamEventSaturatorImpl;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.analytics.inhouse_transport.ClickStreamPendingTimer;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.provider.clickstream.ClickStreamPendingFlushInteractor;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/di/module/ClickStreamModule;", "", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "provideClickStreamEventSaturator", "(Lcom/avito/android/account/AccountStateProvider;)Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "taskScheduler", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "provideClickstreamFlushInteractor", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "provideClickstreamTimer", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {HttpClientModule.class, ClickStreamCommonModule.class})
public final class ClickStreamModule {
    @NotNull
    public static final ClickStreamModule INSTANCE = new ClickStreamModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final ClickStreamEventTracker.ClickStreamEventSaturator provideClickStreamEventSaturator(@NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        return new ClickStreamEventSaturatorImpl(accountStateProvider);
    }

    @Provides
    @JvmStatic
    @ClickStreamCommonModule.ClickStream
    @NotNull
    public static final InHouseAnalyticsFlushInteractor provideClickstreamFlushInteractor(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        return new ClickStreamPendingFlushInteractor(shortTaskExactScheduler);
    }

    @Provides
    @JvmStatic
    @ClickStreamCommonModule.ClickStream
    @NotNull
    @Singleton
    public static final InHouseAnalyticsTimer provideClickstreamTimer(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ClickStreamPendingTimer(schedulersFactory);
    }
}
