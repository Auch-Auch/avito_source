package com.avito.android.app_rater.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragmentViewModelFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppRaterDialogModule_ProvideViewModelFactoryFactory implements Factory<AppRaterDialogFragmentViewModelFactory> {
    public final Provider<AppRaterInteractor> a;
    public final Provider<TimeSource> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;
    public final Provider<AppRaterEventSourcePage> e;

    public AppRaterDialogModule_ProvideViewModelFactoryFactory(Provider<AppRaterInteractor> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<AppRaterEventSourcePage> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AppRaterDialogModule_ProvideViewModelFactoryFactory create(Provider<AppRaterInteractor> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<AppRaterEventSourcePage> provider5) {
        return new AppRaterDialogModule_ProvideViewModelFactoryFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static AppRaterDialogFragmentViewModelFactory provideViewModelFactory(AppRaterInteractor appRaterInteractor, TimeSource timeSource, SchedulersFactory schedulersFactory, Analytics analytics, AppRaterEventSourcePage appRaterEventSourcePage) {
        return (AppRaterDialogFragmentViewModelFactory) Preconditions.checkNotNullFromProvides(AppRaterDialogModule.provideViewModelFactory(appRaterInteractor, timeSource, schedulersFactory, analytics, appRaterEventSourcePage));
    }

    @Override // javax.inject.Provider
    public AppRaterDialogFragmentViewModelFactory get() {
        return provideViewModelFactory(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
