package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.in_app_calls.service.callStartTasks.CallLoggingTask;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallStartupTasksModule_ProvideCallStartupTasksFactory implements Factory<CallStartTask> {
    public final CallStartupTasksModule a;
    public final Provider<Features> b;
    public final Provider<CallLoggingTask> c;

    public CallStartupTasksModule_ProvideCallStartupTasksFactory(CallStartupTasksModule callStartupTasksModule, Provider<Features> provider, Provider<CallLoggingTask> provider2) {
        this.a = callStartupTasksModule;
        this.b = provider;
        this.c = provider2;
    }

    public static CallStartupTasksModule_ProvideCallStartupTasksFactory create(CallStartupTasksModule callStartupTasksModule, Provider<Features> provider, Provider<CallLoggingTask> provider2) {
        return new CallStartupTasksModule_ProvideCallStartupTasksFactory(callStartupTasksModule, provider, provider2);
    }

    public static CallStartTask provideCallStartupTasks(CallStartupTasksModule callStartupTasksModule, Features features, CallLoggingTask callLoggingTask) {
        return (CallStartTask) Preconditions.checkNotNullFromProvides(callStartupTasksModule.provideCallStartupTasks(features, callLoggingTask));
    }

    @Override // javax.inject.Provider
    public CallStartTask get() {
        return provideCallStartupTasks(this.a, this.b.get(), this.c.get());
    }
}
