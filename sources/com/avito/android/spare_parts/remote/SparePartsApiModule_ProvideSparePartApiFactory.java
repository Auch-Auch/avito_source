package com.avito.android.spare_parts.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SparePartsApiModule_ProvideSparePartApiFactory implements Factory<SparePartsApi> {
    public final Provider<RetrofitFactory> a;

    public SparePartsApiModule_ProvideSparePartApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SparePartsApiModule_ProvideSparePartApiFactory create(Provider<RetrofitFactory> provider) {
        return new SparePartsApiModule_ProvideSparePartApiFactory(provider);
    }

    public static SparePartsApi provideSparePartApi(RetrofitFactory retrofitFactory) {
        return (SparePartsApi) Preconditions.checkNotNullFromProvides(SparePartsApiModule.INSTANCE.provideSparePartApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SparePartsApi get() {
        return provideSparePartApi(this.a.get());
    }
}
