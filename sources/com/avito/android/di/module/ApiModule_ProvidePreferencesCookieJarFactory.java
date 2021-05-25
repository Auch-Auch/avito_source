package com.avito.android.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CookieJar;
public final class ApiModule_ProvidePreferencesCookieJarFactory implements Factory<CookieJar> {
    public final ApiModule a;
    public final Provider<Context> b;

    public ApiModule_ProvidePreferencesCookieJarFactory(ApiModule apiModule, Provider<Context> provider) {
        this.a = apiModule;
        this.b = provider;
    }

    public static ApiModule_ProvidePreferencesCookieJarFactory create(ApiModule apiModule, Provider<Context> provider) {
        return new ApiModule_ProvidePreferencesCookieJarFactory(apiModule, provider);
    }

    public static CookieJar providePreferencesCookieJar(ApiModule apiModule, Context context) {
        return (CookieJar) Preconditions.checkNotNullFromProvides(apiModule.providePreferencesCookieJar(context));
    }

    @Override // javax.inject.Provider
    public CookieJar get() {
        return providePreferencesCookieJar(this.a, this.b.get());
    }
}
