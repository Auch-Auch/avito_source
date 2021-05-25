package com.avito.android.publish.di;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishParametersModule_ProvideUploadConverterFactory implements Factory<UploadConverter> {
    public final PublishParametersModule a;
    public final Provider<Context> b;
    public final Provider<Analytics> c;

    public PublishParametersModule_ProvideUploadConverterFactory(PublishParametersModule publishParametersModule, Provider<Context> provider, Provider<Analytics> provider2) {
        this.a = publishParametersModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PublishParametersModule_ProvideUploadConverterFactory create(PublishParametersModule publishParametersModule, Provider<Context> provider, Provider<Analytics> provider2) {
        return new PublishParametersModule_ProvideUploadConverterFactory(publishParametersModule, provider, provider2);
    }

    public static UploadConverter provideUploadConverter(PublishParametersModule publishParametersModule, Context context, Analytics analytics) {
        return (UploadConverter) Preconditions.checkNotNullFromProvides(publishParametersModule.provideUploadConverter(context, analytics));
    }

    @Override // javax.inject.Provider
    public UploadConverter get() {
        return provideUploadConverter(this.a, this.b.get(), this.c.get());
    }
}
