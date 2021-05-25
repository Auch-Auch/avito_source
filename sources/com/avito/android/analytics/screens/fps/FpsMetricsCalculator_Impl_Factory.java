package com.avito.android.analytics.screens.fps;

import com.avito.android.analytics.screens.fps.FpsMetricsCalculator;
import dagger.internal.Factory;
public final class FpsMetricsCalculator_Impl_Factory implements Factory<FpsMetricsCalculator.Impl> {

    public static final class a {
        public static final FpsMetricsCalculator_Impl_Factory a = new FpsMetricsCalculator_Impl_Factory();
    }

    public static FpsMetricsCalculator_Impl_Factory create() {
        return a.a;
    }

    public static FpsMetricsCalculator.Impl newInstance() {
        return new FpsMetricsCalculator.Impl();
    }

    @Override // javax.inject.Provider
    public FpsMetricsCalculator.Impl get() {
        return newInstance();
    }
}
