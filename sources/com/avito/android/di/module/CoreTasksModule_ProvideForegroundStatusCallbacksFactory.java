package com.avito.android.di.module;

import com.avito.android.util.ForegroundStatusCallbacks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreTasksModule_ProvideForegroundStatusCallbacksFactory implements Factory<ForegroundStatusCallbacks> {

    public static final class a {
        public static final CoreTasksModule_ProvideForegroundStatusCallbacksFactory a = new CoreTasksModule_ProvideForegroundStatusCallbacksFactory();
    }

    public static CoreTasksModule_ProvideForegroundStatusCallbacksFactory create() {
        return a.a;
    }

    public static ForegroundStatusCallbacks provideForegroundStatusCallbacks() {
        return (ForegroundStatusCallbacks) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideForegroundStatusCallbacks());
    }

    @Override // javax.inject.Provider
    public ForegroundStatusCallbacks get() {
        return provideForegroundStatusCallbacks();
    }
}
