package com.avito.android.in_app_calls.di;

import android.app.Application;
import com.avito.android.in_app_calls.logging.LogFileProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideLogFileManagerFactory implements Factory<LogFileProvider> {
    public final InAppCallsModule a;
    public final Provider<Application> b;

    public InAppCallsModule_ProvideLogFileManagerFactory(InAppCallsModule inAppCallsModule, Provider<Application> provider) {
        this.a = inAppCallsModule;
        this.b = provider;
    }

    public static InAppCallsModule_ProvideLogFileManagerFactory create(InAppCallsModule inAppCallsModule, Provider<Application> provider) {
        return new InAppCallsModule_ProvideLogFileManagerFactory(inAppCallsModule, provider);
    }

    public static LogFileProvider provideLogFileManager(InAppCallsModule inAppCallsModule, Application application) {
        return (LogFileProvider) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideLogFileManager(application));
    }

    @Override // javax.inject.Provider
    public LogFileProvider get() {
        return provideLogFileManager(this.a, this.b.get());
    }
}
