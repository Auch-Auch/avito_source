package com.avito.android.di.module;

import com.avito.android.photo_picker.legacy.api.UploadInteractor;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ImageUploadServiceModule_ProvideUploadInteractorsFactory implements Factory<Map<String, UploadInteractor>> {
    public final Provider<PickerApi> a;
    public final Provider<Messenger<AvitoMessengerApi>> b;

    public ImageUploadServiceModule_ProvideUploadInteractorsFactory(Provider<PickerApi> provider, Provider<Messenger<AvitoMessengerApi>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImageUploadServiceModule_ProvideUploadInteractorsFactory create(Provider<PickerApi> provider, Provider<Messenger<AvitoMessengerApi>> provider2) {
        return new ImageUploadServiceModule_ProvideUploadInteractorsFactory(provider, provider2);
    }

    public static Map<String, UploadInteractor> provideUploadInteractors(PickerApi pickerApi, Messenger<AvitoMessengerApi> messenger) {
        return (Map) Preconditions.checkNotNullFromProvides(ImageUploadServiceModule.provideUploadInteractors(pickerApi, messenger));
    }

    @Override // javax.inject.Provider
    public Map<String, UploadInteractor> get() {
        return provideUploadInteractors(this.a.get(), this.b.get());
    }
}
