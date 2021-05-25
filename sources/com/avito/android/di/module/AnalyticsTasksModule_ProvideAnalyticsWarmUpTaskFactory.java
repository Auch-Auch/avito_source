package com.avito.android.di.module;

import com.avito.android.analytics.CrashReporter;
import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import com.avito.android.analytics.provider.metrica.Metrica;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.analytics_firebase.Firebase;
import com.avito.android.app.task.AnalyticsWarmUpTask;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideAnalyticsWarmUpTaskFactory implements Factory<AnalyticsWarmUpTask> {
    public final Provider<FirebaseCrashlyticsInitialization> a;
    public final Provider<Metrica> b;
    public final Provider<Adjust> c;
    public final Provider<Firebase> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<StartupAnalyticsTracker> f;
    public final Provider<CrashReporter> g;

    public AnalyticsTasksModule_ProvideAnalyticsWarmUpTaskFactory(Provider<FirebaseCrashlyticsInitialization> provider, Provider<Metrica> provider2, Provider<Adjust> provider3, Provider<Firebase> provider4, Provider<SchedulersFactory> provider5, Provider<StartupAnalyticsTracker> provider6, Provider<CrashReporter> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AnalyticsTasksModule_ProvideAnalyticsWarmUpTaskFactory create(Provider<FirebaseCrashlyticsInitialization> provider, Provider<Metrica> provider2, Provider<Adjust> provider3, Provider<Firebase> provider4, Provider<SchedulersFactory> provider5, Provider<StartupAnalyticsTracker> provider6, Provider<CrashReporter> provider7) {
        return new AnalyticsTasksModule_ProvideAnalyticsWarmUpTaskFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AnalyticsWarmUpTask provideAnalyticsWarmUpTask(FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization, Metrica metrica, Adjust adjust, Firebase firebase, SchedulersFactory schedulersFactory, StartupAnalyticsTracker startupAnalyticsTracker, CrashReporter crashReporter) {
        return (AnalyticsWarmUpTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideAnalyticsWarmUpTask(firebaseCrashlyticsInitialization, metrica, adjust, firebase, schedulersFactory, startupAnalyticsTracker, crashReporter));
    }

    @Override // javax.inject.Provider
    public AnalyticsWarmUpTask get() {
        return provideAnalyticsWarmUpTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
