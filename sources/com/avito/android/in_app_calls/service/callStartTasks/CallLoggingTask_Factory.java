package com.avito.android.in_app_calls.service.callStartTasks;

import android.content.Context;
import com.avito.android.in_app_calls.logging.CallLogWriter;
import com.avito.android.in_app_calls.logging.LogHeaderProvider;
import com.avito.android.in_app_calls.logging.LogStreamer;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallLoggingTask_Factory implements Factory<CallLoggingTask> {
    public final Provider<Context> a;
    public final Provider<LogStreamer> b;
    public final Provider<TimeSource> c;
    public final Provider<CallLogWriter> d;
    public final Provider<LogHeaderProvider> e;
    public final Provider<SchedulersFactory3> f;

    public CallLoggingTask_Factory(Provider<Context> provider, Provider<LogStreamer> provider2, Provider<TimeSource> provider3, Provider<CallLogWriter> provider4, Provider<LogHeaderProvider> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CallLoggingTask_Factory create(Provider<Context> provider, Provider<LogStreamer> provider2, Provider<TimeSource> provider3, Provider<CallLogWriter> provider4, Provider<LogHeaderProvider> provider5, Provider<SchedulersFactory3> provider6) {
        return new CallLoggingTask_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CallLoggingTask newInstance(Context context, LogStreamer logStreamer, TimeSource timeSource, CallLogWriter callLogWriter, LogHeaderProvider logHeaderProvider, SchedulersFactory3 schedulersFactory3) {
        return new CallLoggingTask(context, logStreamer, timeSource, callLogWriter, logHeaderProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public CallLoggingTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
