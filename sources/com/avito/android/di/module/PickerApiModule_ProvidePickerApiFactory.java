package com.avito.android.di.module;

import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PickerApiModule_ProvidePickerApiFactory implements Factory<PickerApi> {
    public final Provider<RetrofitFactory> a;

    public PickerApiModule_ProvidePickerApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PickerApiModule_ProvidePickerApiFactory create(Provider<RetrofitFactory> provider) {
        return new PickerApiModule_ProvidePickerApiFactory(provider);
    }

    public static PickerApi providePickerApi(RetrofitFactory retrofitFactory) {
        return (PickerApi) Preconditions.checkNotNullFromProvides(PickerApiModule.INSTANCE.providePickerApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PickerApi get() {
        return providePickerApi(this.a.get());
    }
}
