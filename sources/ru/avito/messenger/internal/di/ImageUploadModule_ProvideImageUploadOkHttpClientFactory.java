package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class ImageUploadModule_ProvideImageUploadOkHttpClientFactory implements Factory<OkHttpClient> {
    public final ImageUploadModule a;
    public final Provider<OkHttpClient> b;

    public ImageUploadModule_ProvideImageUploadOkHttpClientFactory(ImageUploadModule imageUploadModule, Provider<OkHttpClient> provider) {
        this.a = imageUploadModule;
        this.b = provider;
    }

    public static ImageUploadModule_ProvideImageUploadOkHttpClientFactory create(ImageUploadModule imageUploadModule, Provider<OkHttpClient> provider) {
        return new ImageUploadModule_ProvideImageUploadOkHttpClientFactory(imageUploadModule, provider);
    }

    public static OkHttpClient provideImageUploadOkHttpClient(ImageUploadModule imageUploadModule, OkHttpClient okHttpClient) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(imageUploadModule.provideImageUploadOkHttpClient(okHttpClient));
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideImageUploadOkHttpClient(this.a, this.b.get());
    }
}
