package com.avito.android.publish.new_advert.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.di.PerActivity;
import com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.new_advert.NewAdvertPresenter;
import com.avito.android.publish.new_advert.NewAdvertPresenterImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JE\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/publish/new_advert/di/NewAdvertModule;", "", "Lcom/avito/android/account/AccountStateProvider;", "accountLoginStateProvider", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "addAdvertInteractor", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "publishAnalyticsDataProvider", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "tracker", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "provideFloatingAddAdvertAnalyticsWrapper", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/component/floating_add_advert/AddAdvertInteractor;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "Ldagger/Lazy;", "Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", "publishDraftAvailabilityCheckerLazy", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/BuildInfo;", "build", "analyticsDataProvider", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "idGenerator", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "provideNewAdvertPresenter", "(Ldagger/Lazy;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;)Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NewAdvertModule {
    @Provides
    @PerActivity
    @NotNull
    public final FloatingAddAdvertAnalyticsWrapper provideFloatingAddAdvertAnalyticsWrapper(@NotNull AccountStateProvider accountStateProvider, @NotNull AddAdvertInteractor addAdvertInteractor, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishEventTracker publishEventTracker, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountLoginStateProvider");
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "addAdvertInteractor");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "publishAnalyticsDataProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new FloatingAddAdvertAnalyticsWrapper(accountStateProvider, publishAnalyticsDataProvider, addAdvertInteractor, schedulersFactory3, publishEventTracker, analytics);
    }

    @Provides
    @NotNull
    @PerActivity
    public final NewAdvertPresenter provideNewAdvertPresenter(@NotNull Lazy<PublishDraftAvailabilityChecker> lazy, @NotNull PublishDraftWiper publishDraftWiper, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator) {
        Intrinsics.checkNotNullParameter(lazy, "publishDraftAvailabilityCheckerLazy");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "idGenerator");
        return new NewAdvertPresenterImpl(lazy, publishDraftWiper, schedulersFactory, buildInfo, publishAnalyticsDataProvider, publishSessionIdGenerator);
    }
}
