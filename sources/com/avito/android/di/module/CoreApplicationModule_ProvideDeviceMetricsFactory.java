package com.avito.android.di.module;

import android.util.DisplayMetrics;
import android.view.Display;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideDeviceMetricsFactory implements Factory<DeviceMetrics> {
    public final CoreApplicationModule a;
    public final Provider<BuildInfo> b;
    public final Provider<Display> c;
    public final Provider<DisplayMetrics> d;

    public CoreApplicationModule_ProvideDeviceMetricsFactory(CoreApplicationModule coreApplicationModule, Provider<BuildInfo> provider, Provider<Display> provider2, Provider<DisplayMetrics> provider3) {
        this.a = coreApplicationModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static CoreApplicationModule_ProvideDeviceMetricsFactory create(CoreApplicationModule coreApplicationModule, Provider<BuildInfo> provider, Provider<Display> provider2, Provider<DisplayMetrics> provider3) {
        return new CoreApplicationModule_ProvideDeviceMetricsFactory(coreApplicationModule, provider, provider2, provider3);
    }

    public static DeviceMetrics provideDeviceMetrics(CoreApplicationModule coreApplicationModule, BuildInfo buildInfo, Display display, DisplayMetrics displayMetrics) {
        return (DeviceMetrics) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideDeviceMetrics(buildInfo, display, displayMetrics));
    }

    @Override // javax.inject.Provider
    public DeviceMetrics get() {
        return provideDeviceMetrics(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
