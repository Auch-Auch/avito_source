package com.avito.android.shop.detailed;

import android.content.res.Resources;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopDetailedImageHeightProviderImpl_Factory implements Factory<ShopDetailedImageHeightProviderImpl> {
    public final Provider<DeviceMetrics> a;
    public final Provider<Resources> b;

    public ShopDetailedImageHeightProviderImpl_Factory(Provider<DeviceMetrics> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopDetailedImageHeightProviderImpl_Factory create(Provider<DeviceMetrics> provider, Provider<Resources> provider2) {
        return new ShopDetailedImageHeightProviderImpl_Factory(provider, provider2);
    }

    public static ShopDetailedImageHeightProviderImpl newInstance(DeviceMetrics deviceMetrics, Resources resources) {
        return new ShopDetailedImageHeightProviderImpl(deviceMetrics, resources);
    }

    @Override // javax.inject.Provider
    public ShopDetailedImageHeightProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
