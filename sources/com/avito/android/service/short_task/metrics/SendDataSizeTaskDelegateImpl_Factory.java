package com.avito.android.service.short_task.metrics;

import com.avito.android.util.DiskSpaceAnalyticsTraverser;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendDataSizeTaskDelegateImpl_Factory implements Factory<SendDataSizeTaskDelegateImpl> {
    public final Provider<DiskSpaceAnalyticsTraverser> a;

    public SendDataSizeTaskDelegateImpl_Factory(Provider<DiskSpaceAnalyticsTraverser> provider) {
        this.a = provider;
    }

    public static SendDataSizeTaskDelegateImpl_Factory create(Provider<DiskSpaceAnalyticsTraverser> provider) {
        return new SendDataSizeTaskDelegateImpl_Factory(provider);
    }

    public static SendDataSizeTaskDelegateImpl newInstance(DiskSpaceAnalyticsTraverser diskSpaceAnalyticsTraverser) {
        return new SendDataSizeTaskDelegateImpl(diskSpaceAnalyticsTraverser);
    }

    @Override // javax.inject.Provider
    public SendDataSizeTaskDelegateImpl get() {
        return newInstance(this.a.get());
    }
}
