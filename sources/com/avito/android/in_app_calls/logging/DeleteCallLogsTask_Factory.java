package com.avito.android.in_app_calls.logging;

import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeleteCallLogsTask_Factory implements Factory<DeleteCallLogsTask> {
    public final Provider<LogFileProvider> a;
    public final Provider<TimeSource> b;
    public final Provider<SchedulersFactory3> c;

    public DeleteCallLogsTask_Factory(Provider<LogFileProvider> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeleteCallLogsTask_Factory create(Provider<LogFileProvider> provider, Provider<TimeSource> provider2, Provider<SchedulersFactory3> provider3) {
        return new DeleteCallLogsTask_Factory(provider, provider2, provider3);
    }

    public static DeleteCallLogsTask newInstance(LogFileProvider logFileProvider, TimeSource timeSource, SchedulersFactory3 schedulersFactory3) {
        return new DeleteCallLogsTask(logFileProvider, timeSource, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public DeleteCallLogsTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
