package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ErrorTrackerModule_ProvideErrorTrackerFactory implements Factory<ErrorTracker> {
    public final ErrorTrackerModule a;

    public ErrorTrackerModule_ProvideErrorTrackerFactory(ErrorTrackerModule errorTrackerModule) {
        this.a = errorTrackerModule;
    }

    public static ErrorTrackerModule_ProvideErrorTrackerFactory create(ErrorTrackerModule errorTrackerModule) {
        return new ErrorTrackerModule_ProvideErrorTrackerFactory(errorTrackerModule);
    }

    public static ErrorTracker provideErrorTracker(ErrorTrackerModule errorTrackerModule) {
        return (ErrorTracker) Preconditions.checkNotNullFromProvides(errorTrackerModule.provideErrorTracker());
    }

    @Override // javax.inject.Provider
    public ErrorTracker get() {
        return provideErrorTracker(this.a);
    }
}
