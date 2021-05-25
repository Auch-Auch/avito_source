package com.avito.android.in_app_calls.logging;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FullLogFormatter_Factory implements Factory<FullLogFormatter> {
    public final Provider<TimeSource> a;

    public FullLogFormatter_Factory(Provider<TimeSource> provider) {
        this.a = provider;
    }

    public static FullLogFormatter_Factory create(Provider<TimeSource> provider) {
        return new FullLogFormatter_Factory(provider);
    }

    public static FullLogFormatter newInstance(TimeSource timeSource) {
        return new FullLogFormatter(timeSource);
    }

    @Override // javax.inject.Provider
    public FullLogFormatter get() {
        return newInstance(this.a.get());
    }
}
