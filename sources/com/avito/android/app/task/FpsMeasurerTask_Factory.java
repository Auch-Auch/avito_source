package com.avito.android.app.task;

import com.avito.android.fps.FpsReporter;
import com.avito.android.fps.FramesListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FpsMeasurerTask_Factory implements Factory<FpsMeasurerTask> {
    public final Provider<FpsReporter> a;
    public final Provider<FramesListener> b;

    public FpsMeasurerTask_Factory(Provider<FpsReporter> provider, Provider<FramesListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FpsMeasurerTask_Factory create(Provider<FpsReporter> provider, Provider<FramesListener> provider2) {
        return new FpsMeasurerTask_Factory(provider, provider2);
    }

    public static FpsMeasurerTask newInstance(FpsReporter fpsReporter, FramesListener framesListener) {
        return new FpsMeasurerTask(fpsReporter, framesListener);
    }

    @Override // javax.inject.Provider
    public FpsMeasurerTask get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
