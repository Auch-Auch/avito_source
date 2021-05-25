package com.avito.android.analytics.di;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.lang.Thread;
import javax.inject.Provider;
public final class FirebaseCrashlyticsInitialization_ProvideFirebaseCrashlyticsInitializationFactory implements Factory<FirebaseCrashlyticsInitialization> {
    public final Provider<Application> a;
    public final Provider<Thread.UncaughtExceptionHandler> b;
    public final Provider<CrashRecorder> c;
    public final Provider<Features> d;
    public final Provider<BuildInfo> e;

    public FirebaseCrashlyticsInitialization_ProvideFirebaseCrashlyticsInitializationFactory(Provider<Application> provider, Provider<Thread.UncaughtExceptionHandler> provider2, Provider<CrashRecorder> provider3, Provider<Features> provider4, Provider<BuildInfo> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FirebaseCrashlyticsInitialization_ProvideFirebaseCrashlyticsInitializationFactory create(Provider<Application> provider, Provider<Thread.UncaughtExceptionHandler> provider2, Provider<CrashRecorder> provider3, Provider<Features> provider4, Provider<BuildInfo> provider5) {
        return new FirebaseCrashlyticsInitialization_ProvideFirebaseCrashlyticsInitializationFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static FirebaseCrashlyticsInitialization provideFirebaseCrashlyticsInitialization(Application application, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashRecorder crashRecorder, Features features, BuildInfo buildInfo) {
        return (FirebaseCrashlyticsInitialization) Preconditions.checkNotNullFromProvides(FirebaseCrashlyticsInitialization.INSTANCE.provideFirebaseCrashlyticsInitialization(application, uncaughtExceptionHandler, crashRecorder, features, buildInfo));
    }

    @Override // javax.inject.Provider
    public FirebaseCrashlyticsInitialization get() {
        return provideFirebaseCrashlyticsInitialization(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
