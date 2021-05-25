package com.avito.android.app.task;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendStartupTimeTask_Factory implements Factory<SendStartupTimeTask> {
    public final Provider<Analytics> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<BuildInfo> c;

    public SendStartupTimeTask_Factory(Provider<Analytics> provider, Provider<SchedulersFactory> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SendStartupTimeTask_Factory create(Provider<Analytics> provider, Provider<SchedulersFactory> provider2, Provider<BuildInfo> provider3) {
        return new SendStartupTimeTask_Factory(provider, provider2, provider3);
    }

    public static SendStartupTimeTask newInstance(Analytics analytics, SchedulersFactory schedulersFactory, BuildInfo buildInfo) {
        return new SendStartupTimeTask(analytics, schedulersFactory, buildInfo);
    }

    @Override // javax.inject.Provider
    public SendStartupTimeTask get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
