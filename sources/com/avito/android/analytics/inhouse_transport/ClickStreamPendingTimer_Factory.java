package com.avito.android.analytics.inhouse_transport;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClickStreamPendingTimer_Factory implements Factory<ClickStreamPendingTimer> {
    public final Provider<SchedulersFactory> a;

    public ClickStreamPendingTimer_Factory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static ClickStreamPendingTimer_Factory create(Provider<SchedulersFactory> provider) {
        return new ClickStreamPendingTimer_Factory(provider);
    }

    public static ClickStreamPendingTimer newInstance(SchedulersFactory schedulersFactory) {
        return new ClickStreamPendingTimer(schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ClickStreamPendingTimer get() {
        return newInstance(this.a.get());
    }
}
