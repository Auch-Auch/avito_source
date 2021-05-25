package com.avito.android.analytics.clickstream;

import com.avito.android.AnalyticsToggles;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideClickStreamEventTrackerFactory implements Factory<ClickStreamEventTracker> {
    public final Provider<InHouseEventStorage<EventOuterClass.Event>> a;
    public final Provider<InHouseAnalyticsFlushInteractor> b;
    public final Provider<InHouseAnalyticsTimer> c;
    public final Provider<ClickStreamEventTracker.ClickStreamEventSaturator> d;
    public final Provider<Set<EventValidator>> e;
    public final Provider<TimeSource> f;
    public final Provider<AnalyticsToggles> g;
    public final Provider<BuildInfo> h;

    public ClickStreamCommonModule_ProvideClickStreamEventTrackerFactory(Provider<InHouseEventStorage<EventOuterClass.Event>> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<InHouseAnalyticsTimer> provider3, Provider<ClickStreamEventTracker.ClickStreamEventSaturator> provider4, Provider<Set<EventValidator>> provider5, Provider<TimeSource> provider6, Provider<AnalyticsToggles> provider7, Provider<BuildInfo> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ClickStreamCommonModule_ProvideClickStreamEventTrackerFactory create(Provider<InHouseEventStorage<EventOuterClass.Event>> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<InHouseAnalyticsTimer> provider3, Provider<ClickStreamEventTracker.ClickStreamEventSaturator> provider4, Provider<Set<EventValidator>> provider5, Provider<TimeSource> provider6, Provider<AnalyticsToggles> provider7, Provider<BuildInfo> provider8) {
        return new ClickStreamCommonModule_ProvideClickStreamEventTrackerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ClickStreamEventTracker provideClickStreamEventTracker(InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, InHouseAnalyticsTimer inHouseAnalyticsTimer, ClickStreamEventTracker.ClickStreamEventSaturator clickStreamEventSaturator, Set<EventValidator> set, TimeSource timeSource, AnalyticsToggles analyticsToggles, BuildInfo buildInfo) {
        return (ClickStreamEventTracker) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideClickStreamEventTracker(inHouseEventStorage, inHouseAnalyticsFlushInteractor, inHouseAnalyticsTimer, clickStreamEventSaturator, set, timeSource, analyticsToggles, buildInfo));
    }

    @Override // javax.inject.Provider
    public ClickStreamEventTracker get() {
        return provideClickStreamEventTracker(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
