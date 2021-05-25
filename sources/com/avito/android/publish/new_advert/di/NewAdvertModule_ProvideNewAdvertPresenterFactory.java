package com.avito.android.publish.new_advert.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.new_advert.NewAdvertPresenter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewAdvertModule_ProvideNewAdvertPresenterFactory implements Factory<NewAdvertPresenter> {
    public final NewAdvertModule a;
    public final Provider<PublishDraftAvailabilityChecker> b;
    public final Provider<PublishDraftWiper> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<BuildInfo> e;
    public final Provider<PublishAnalyticsDataProvider> f;
    public final Provider<PublishSessionIdGenerator> g;

    public NewAdvertModule_ProvideNewAdvertPresenterFactory(NewAdvertModule newAdvertModule, Provider<PublishDraftAvailabilityChecker> provider, Provider<PublishDraftWiper> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<PublishSessionIdGenerator> provider6) {
        this.a = newAdvertModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static NewAdvertModule_ProvideNewAdvertPresenterFactory create(NewAdvertModule newAdvertModule, Provider<PublishDraftAvailabilityChecker> provider, Provider<PublishDraftWiper> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<PublishSessionIdGenerator> provider6) {
        return new NewAdvertModule_ProvideNewAdvertPresenterFactory(newAdvertModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NewAdvertPresenter provideNewAdvertPresenter(NewAdvertModule newAdvertModule, Lazy<PublishDraftAvailabilityChecker> lazy, PublishDraftWiper publishDraftWiper, SchedulersFactory schedulersFactory, BuildInfo buildInfo, PublishAnalyticsDataProvider publishAnalyticsDataProvider, PublishSessionIdGenerator publishSessionIdGenerator) {
        return (NewAdvertPresenter) Preconditions.checkNotNullFromProvides(newAdvertModule.provideNewAdvertPresenter(lazy, publishDraftWiper, schedulersFactory, buildInfo, publishAnalyticsDataProvider, publishSessionIdGenerator));
    }

    @Override // javax.inject.Provider
    public NewAdvertPresenter get() {
        return provideNewAdvertPresenter(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
