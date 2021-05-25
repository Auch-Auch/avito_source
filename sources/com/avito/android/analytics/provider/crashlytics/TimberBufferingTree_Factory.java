package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TimberBufferingTree_Factory implements Factory<TimberBufferingTree> {
    public final Provider<TimeSource> a;

    public TimberBufferingTree_Factory(Provider<TimeSource> provider) {
        this.a = provider;
    }

    public static TimberBufferingTree_Factory create(Provider<TimeSource> provider) {
        return new TimberBufferingTree_Factory(provider);
    }

    public static TimberBufferingTree newInstance(TimeSource timeSource) {
        return new TimberBufferingTree(timeSource);
    }

    @Override // javax.inject.Provider
    public TimberBufferingTree get() {
        return newInstance(this.a.get());
    }
}
