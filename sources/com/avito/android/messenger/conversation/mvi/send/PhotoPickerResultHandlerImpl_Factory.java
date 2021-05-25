package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoPickerResultHandlerImpl_Factory implements Factory<PhotoPickerResultHandlerImpl> {
    public final Provider<PhotoInteractor> a;
    public final Provider<MessengerPhotoStorage> b;
    public final Provider<SharedPhotosStorage> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<Analytics> e;

    public PhotoPickerResultHandlerImpl_Factory(Provider<PhotoInteractor> provider, Provider<MessengerPhotoStorage> provider2, Provider<SharedPhotosStorage> provider3, Provider<SchedulersFactory> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PhotoPickerResultHandlerImpl_Factory create(Provider<PhotoInteractor> provider, Provider<MessengerPhotoStorage> provider2, Provider<SharedPhotosStorage> provider3, Provider<SchedulersFactory> provider4, Provider<Analytics> provider5) {
        return new PhotoPickerResultHandlerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PhotoPickerResultHandlerImpl newInstance(PhotoInteractor photoInteractor, MessengerPhotoStorage messengerPhotoStorage, SharedPhotosStorage sharedPhotosStorage, SchedulersFactory schedulersFactory, Analytics analytics) {
        return new PhotoPickerResultHandlerImpl(photoInteractor, messengerPhotoStorage, sharedPhotosStorage, schedulersFactory, analytics);
    }

    @Override // javax.inject.Provider
    public PhotoPickerResultHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
