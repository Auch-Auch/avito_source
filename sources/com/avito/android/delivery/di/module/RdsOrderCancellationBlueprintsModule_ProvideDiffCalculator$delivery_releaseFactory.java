package com.avito.android.delivery.di.module;

import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory implements Factory<DiffCalculator> {

    public static final class a {
        public static final RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory a = new RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory();
    }

    public static RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory create() {
        return a.a;
    }

    public static DiffCalculator provideDiffCalculator$delivery_release() {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(RdsOrderCancellationBlueprintsModule.INSTANCE.provideDiffCalculator$delivery_release());
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator$delivery_release();
    }
}
