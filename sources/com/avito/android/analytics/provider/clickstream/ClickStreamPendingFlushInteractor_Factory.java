package com.avito.android.analytics.provider.clickstream;

import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClickStreamPendingFlushInteractor_Factory implements Factory<ClickStreamPendingFlushInteractor> {
    public final Provider<ShortTaskExactScheduler> a;

    public ClickStreamPendingFlushInteractor_Factory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static ClickStreamPendingFlushInteractor_Factory create(Provider<ShortTaskExactScheduler> provider) {
        return new ClickStreamPendingFlushInteractor_Factory(provider);
    }

    public static ClickStreamPendingFlushInteractor newInstance(ShortTaskExactScheduler shortTaskExactScheduler) {
        return new ClickStreamPendingFlushInteractor(shortTaskExactScheduler);
    }

    @Override // javax.inject.Provider
    public ClickStreamPendingFlushInteractor get() {
        return newInstance(this.a.get());
    }
}
