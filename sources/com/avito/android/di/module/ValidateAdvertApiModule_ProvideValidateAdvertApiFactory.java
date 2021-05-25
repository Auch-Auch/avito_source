package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ValidateAdvertApiModule_ProvideValidateAdvertApiFactory implements Factory<ValidateAdvertApi> {
    public final Provider<RetrofitFactory> a;

    public ValidateAdvertApiModule_ProvideValidateAdvertApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ValidateAdvertApiModule_ProvideValidateAdvertApiFactory create(Provider<RetrofitFactory> provider) {
        return new ValidateAdvertApiModule_ProvideValidateAdvertApiFactory(provider);
    }

    public static ValidateAdvertApi provideValidateAdvertApi(RetrofitFactory retrofitFactory) {
        return (ValidateAdvertApi) Preconditions.checkNotNullFromProvides(ValidateAdvertApiModule.INSTANCE.provideValidateAdvertApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ValidateAdvertApi get() {
        return provideValidateAdvertApi(this.a.get());
    }
}
