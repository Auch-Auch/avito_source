package com.avito.android.publish.new_advert.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class NewAdvertModule_ProvideFloatingAddAdvertAnalyticsWrapperFactory implements Factory<FloatingAddAdvertAnalyticsWrapper> {
    public final NewAdvertModule a;
    public final Provider<AccountStateProvider> b;
    public final Provider<AddAdvertInteractor> c;
    public final Provider<PublishAnalyticsDataProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<PublishEventTracker> f;
    public final Provider<Analytics> g;

    public NewAdvertModule_ProvideFloatingAddAdvertAnalyticsWrapperFactory(NewAdvertModule newAdvertModule, Provider<AccountStateProvider> provider, Provider<AddAdvertInteractor> provider2, Provider<PublishAnalyticsDataProvider> provider3, Provider<SchedulersFactory3> provider4, Provider<PublishEventTracker> provider5, Provider<Analytics> provider6) {
        this.a = newAdvertModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static NewAdvertModule_ProvideFloatingAddAdvertAnalyticsWrapperFactory create(NewAdvertModule newAdvertModule, Provider<AccountStateProvider> provider, Provider<AddAdvertInteractor> provider2, Provider<PublishAnalyticsDataProvider> provider3, Provider<SchedulersFactory3> provider4, Provider<PublishEventTracker> provider5, Provider<Analytics> provider6) {
        return new NewAdvertModule_ProvideFloatingAddAdvertAnalyticsWrapperFactory(newAdvertModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FloatingAddAdvertAnalyticsWrapper provideFloatingAddAdvertAnalyticsWrapper(NewAdvertModule newAdvertModule, AccountStateProvider accountStateProvider, AddAdvertInteractor addAdvertInteractor, PublishAnalyticsDataProvider publishAnalyticsDataProvider, SchedulersFactory3 schedulersFactory3, PublishEventTracker publishEventTracker, Analytics analytics) {
        return (FloatingAddAdvertAnalyticsWrapper) Preconditions.checkNotNullFromProvides(newAdvertModule.provideFloatingAddAdvertAnalyticsWrapper(accountStateProvider, addAdvertInteractor, publishAnalyticsDataProvider, schedulersFactory3, publishEventTracker, analytics));
    }

    @Override // javax.inject.Provider
    public FloatingAddAdvertAnalyticsWrapper get() {
        return provideFloatingAddAdvertAnalyticsWrapper(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
