package com.avito.android.di.module;

import com.avito.android.app.task.FpsMeasurerTask;
import com.avito.android.fps.FpsReporter;
import com.avito.android.fps.FramesListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideFpsMeasurerFactory implements Factory<FpsMeasurerTask> {
    public final Provider<FpsReporter> a;
    public final Provider<FramesListener> b;

    public AnalyticsTasksModule_ProvideFpsMeasurerFactory(Provider<FpsReporter> provider, Provider<FramesListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AnalyticsTasksModule_ProvideFpsMeasurerFactory create(Provider<FpsReporter> provider, Provider<FramesListener> provider2) {
        return new AnalyticsTasksModule_ProvideFpsMeasurerFactory(provider, provider2);
    }

    public static FpsMeasurerTask provideFpsMeasurer(FpsReporter fpsReporter, FramesListener framesListener) {
        return (FpsMeasurerTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideFpsMeasurer(fpsReporter, framesListener));
    }

    @Override // javax.inject.Provider
    public FpsMeasurerTask get() {
        return provideFpsMeasurer(this.a.get(), this.b.get());
    }
}
