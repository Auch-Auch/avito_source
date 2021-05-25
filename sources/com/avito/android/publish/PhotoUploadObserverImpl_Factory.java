package com.avito.android.publish;

import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoUploadObserverImpl_Factory implements Factory<PhotoUploadObserverImpl> {
    public final Provider<UploadingProgressInteractor> a;
    public final Provider<SchedulersFactory> b;

    public PhotoUploadObserverImpl_Factory(Provider<UploadingProgressInteractor> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhotoUploadObserverImpl_Factory create(Provider<UploadingProgressInteractor> provider, Provider<SchedulersFactory> provider2) {
        return new PhotoUploadObserverImpl_Factory(provider, provider2);
    }

    public static PhotoUploadObserverImpl newInstance(UploadingProgressInteractor uploadingProgressInteractor, SchedulersFactory schedulersFactory) {
        return new PhotoUploadObserverImpl(uploadingProgressInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public PhotoUploadObserverImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
