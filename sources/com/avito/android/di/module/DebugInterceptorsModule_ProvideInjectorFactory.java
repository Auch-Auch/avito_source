package com.avito.android.di.module;

import com.avito.android.util.OkHttpInjector;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class DebugInterceptorsModule_ProvideInjectorFactory implements Factory<OkHttpInjector> {
    public final DebugInterceptorsModule a;

    public DebugInterceptorsModule_ProvideInjectorFactory(DebugInterceptorsModule debugInterceptorsModule) {
        this.a = debugInterceptorsModule;
    }

    public static DebugInterceptorsModule_ProvideInjectorFactory create(DebugInterceptorsModule debugInterceptorsModule) {
        return new DebugInterceptorsModule_ProvideInjectorFactory(debugInterceptorsModule);
    }

    @Nullable
    public static OkHttpInjector provideInjector(DebugInterceptorsModule debugInterceptorsModule) {
        return debugInterceptorsModule.provideInjector();
    }

    @Override // javax.inject.Provider
    @Nullable
    public OkHttpInjector get() {
        return provideInjector(this.a);
    }
}
