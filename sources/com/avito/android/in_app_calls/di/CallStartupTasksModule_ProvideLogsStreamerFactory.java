package com.avito.android.in_app_calls.di;

import com.avito.android.in_app_calls.logging.LogStreamer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CallStartupTasksModule_ProvideLogsStreamerFactory implements Factory<LogStreamer> {
    public final CallStartupTasksModule a;

    public CallStartupTasksModule_ProvideLogsStreamerFactory(CallStartupTasksModule callStartupTasksModule) {
        this.a = callStartupTasksModule;
    }

    public static CallStartupTasksModule_ProvideLogsStreamerFactory create(CallStartupTasksModule callStartupTasksModule) {
        return new CallStartupTasksModule_ProvideLogsStreamerFactory(callStartupTasksModule);
    }

    public static LogStreamer provideLogsStreamer(CallStartupTasksModule callStartupTasksModule) {
        return (LogStreamer) Preconditions.checkNotNullFromProvides(callStartupTasksModule.provideLogsStreamer());
    }

    @Override // javax.inject.Provider
    public LogStreamer get() {
        return provideLogsStreamer(this.a);
    }
}
