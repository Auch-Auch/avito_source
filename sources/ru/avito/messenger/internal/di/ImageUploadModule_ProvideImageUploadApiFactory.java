package ru.avito.messenger.internal.di;

import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.avito.messenger.MessengerImageUploadApi;
import ru.avito.messenger.internal.Config;
public final class ImageUploadModule_ProvideImageUploadApiFactory implements Factory<MessengerImageUploadApi> {
    public final ImageUploadModule a;
    public final Provider<OkHttpClient> b;
    public final Provider<Config> c;
    public final Provider<Gson> d;
    public final Provider<SchedulersFactory> e;

    public ImageUploadModule_ProvideImageUploadApiFactory(ImageUploadModule imageUploadModule, Provider<OkHttpClient> provider, Provider<Config> provider2, Provider<Gson> provider3, Provider<SchedulersFactory> provider4) {
        this.a = imageUploadModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ImageUploadModule_ProvideImageUploadApiFactory create(ImageUploadModule imageUploadModule, Provider<OkHttpClient> provider, Provider<Config> provider2, Provider<Gson> provider3, Provider<SchedulersFactory> provider4) {
        return new ImageUploadModule_ProvideImageUploadApiFactory(imageUploadModule, provider, provider2, provider3, provider4);
    }

    public static MessengerImageUploadApi provideImageUploadApi(ImageUploadModule imageUploadModule, Lazy<OkHttpClient> lazy, Config config, Gson gson, SchedulersFactory schedulersFactory) {
        return (MessengerImageUploadApi) Preconditions.checkNotNullFromProvides(imageUploadModule.provideImageUploadApi(lazy, config, gson, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public MessengerImageUploadApi get() {
        return provideImageUploadApi(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get(), this.e.get());
    }
}
