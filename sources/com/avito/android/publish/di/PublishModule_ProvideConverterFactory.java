package com.avito.android.publish.di;

import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishModule_ProvideConverterFactory implements Factory<CategoryParametersConverter> {
    public final PublishModule a;

    public PublishModule_ProvideConverterFactory(PublishModule publishModule) {
        this.a = publishModule;
    }

    public static PublishModule_ProvideConverterFactory create(PublishModule publishModule) {
        return new PublishModule_ProvideConverterFactory(publishModule);
    }

    public static CategoryParametersConverter provideConverter(PublishModule publishModule) {
        return (CategoryParametersConverter) Preconditions.checkNotNullFromProvides(publishModule.provideConverter());
    }

    @Override // javax.inject.Provider
    public CategoryParametersConverter get() {
        return provideConverter(this.a);
    }
}
