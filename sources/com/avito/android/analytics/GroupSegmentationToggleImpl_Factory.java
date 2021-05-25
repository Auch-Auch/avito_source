package com.avito.android.analytics;

import com.avito.android.Features;
import com.avito.android.remote.DeviceIdProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupSegmentationToggleImpl_Factory implements Factory<GroupSegmentationToggleImpl> {
    public final Provider<DeviceIdProvider> a;
    public final Provider<Features> b;

    public GroupSegmentationToggleImpl_Factory(Provider<DeviceIdProvider> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GroupSegmentationToggleImpl_Factory create(Provider<DeviceIdProvider> provider, Provider<Features> provider2) {
        return new GroupSegmentationToggleImpl_Factory(provider, provider2);
    }

    public static GroupSegmentationToggleImpl newInstance(DeviceIdProvider deviceIdProvider, Features features) {
        return new GroupSegmentationToggleImpl(deviceIdProvider, features);
    }

    @Override // javax.inject.Provider
    public GroupSegmentationToggleImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
