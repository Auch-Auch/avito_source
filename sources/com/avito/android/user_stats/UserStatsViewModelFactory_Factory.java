package com.avito.android.user_stats;

import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_stats.tab.UserStatsTabItemConverter;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserStatsViewModelFactory_Factory implements Factory<UserStatsViewModelFactory> {
    public final Provider<SavedStateRegistryOwner> a;
    public final Provider<UserStatsInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<UserStatsResourcesProvider> e;
    public final Provider<UserStatsTabItemConverter> f;
    public final Provider<Analytics> g;
    public final Provider<UserStatsTracker> h;

    public UserStatsViewModelFactory_Factory(Provider<SavedStateRegistryOwner> provider, Provider<UserStatsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<UserStatsResourcesProvider> provider5, Provider<UserStatsTabItemConverter> provider6, Provider<Analytics> provider7, Provider<UserStatsTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static UserStatsViewModelFactory_Factory create(Provider<SavedStateRegistryOwner> provider, Provider<UserStatsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<UserStatsResourcesProvider> provider5, Provider<UserStatsTabItemConverter> provider6, Provider<Analytics> provider7, Provider<UserStatsTracker> provider8) {
        return new UserStatsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static UserStatsViewModelFactory newInstance(SavedStateRegistryOwner savedStateRegistryOwner, UserStatsInteractor userStatsInteractor, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, UserStatsResourcesProvider userStatsResourcesProvider, UserStatsTabItemConverter userStatsTabItemConverter, Analytics analytics, UserStatsTracker userStatsTracker) {
        return new UserStatsViewModelFactory(savedStateRegistryOwner, userStatsInteractor, schedulersFactory3, typedErrorThrowableConverter, userStatsResourcesProvider, userStatsTabItemConverter, analytics, userStatsTracker);
    }

    @Override // javax.inject.Provider
    public UserStatsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
