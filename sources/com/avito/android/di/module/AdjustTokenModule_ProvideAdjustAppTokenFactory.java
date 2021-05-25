package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdjustTokenModule_ProvideAdjustAppTokenFactory implements Factory<String> {

    public static final class a {
        public static final AdjustTokenModule_ProvideAdjustAppTokenFactory a = new AdjustTokenModule_ProvideAdjustAppTokenFactory();
    }

    public static AdjustTokenModule_ProvideAdjustAppTokenFactory create() {
        return a.a;
    }

    public static String provideAdjustAppToken() {
        return (String) Preconditions.checkNotNullFromProvides(AdjustTokenModule.provideAdjustAppToken());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAdjustAppToken();
    }
}
