package com.avito.android.analytics.screens.fps;

import com.avito.android.Features;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import dagger.internal.Factory;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class FpsMetricsSupplier_Impl_Factory implements Factory<FpsMetricsSupplier.Impl> {
    public final Provider<Observable<Long>> a;
    public final Provider<FpsMetricsTracker> b;
    public final Provider<Screen> c;
    public final Provider<Integer> d;
    public final Provider<Features> e;

    public FpsMetricsSupplier_Impl_Factory(Provider<Observable<Long>> provider, Provider<FpsMetricsTracker> provider2, Provider<Screen> provider3, Provider<Integer> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FpsMetricsSupplier_Impl_Factory create(Provider<Observable<Long>> provider, Provider<FpsMetricsTracker> provider2, Provider<Screen> provider3, Provider<Integer> provider4, Provider<Features> provider5) {
        return new FpsMetricsSupplier_Impl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FpsMetricsSupplier.Impl newInstance(Observable<Long> observable, FpsMetricsTracker fpsMetricsTracker, Screen screen, int i, Features features) {
        return new FpsMetricsSupplier.Impl(observable, fpsMetricsTracker, screen, i, features);
    }

    @Override // javax.inject.Provider
    public FpsMetricsSupplier.Impl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().intValue(), this.e.get());
    }
}
