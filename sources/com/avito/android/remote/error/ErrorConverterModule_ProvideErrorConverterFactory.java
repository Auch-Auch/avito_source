package com.avito.android.remote.error;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ErrorConverterModule_ProvideErrorConverterFactory implements Factory<TypedErrorThrowableConverter> {
    public final Provider<Application> a;

    public ErrorConverterModule_ProvideErrorConverterFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ErrorConverterModule_ProvideErrorConverterFactory create(Provider<Application> provider) {
        return new ErrorConverterModule_ProvideErrorConverterFactory(provider);
    }

    public static TypedErrorThrowableConverter provideErrorConverter(Application application) {
        return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromProvides(ErrorConverterModule.provideErrorConverter(application));
    }

    @Override // javax.inject.Provider
    public TypedErrorThrowableConverter get() {
        return provideErrorConverter(this.a.get());
    }
}
