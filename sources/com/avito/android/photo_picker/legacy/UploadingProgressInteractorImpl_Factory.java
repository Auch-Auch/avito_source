package com.avito.android.photo_picker.legacy;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UploadingProgressInteractorImpl_Factory implements Factory<UploadingProgressInteractorImpl> {
    public final Provider<String> a;
    public final Provider<PhotoInteractor> b;
    public final Provider<SchedulersFactory> c;

    public UploadingProgressInteractorImpl_Factory(Provider<String> provider, Provider<PhotoInteractor> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UploadingProgressInteractorImpl_Factory create(Provider<String> provider, Provider<PhotoInteractor> provider2, Provider<SchedulersFactory> provider3) {
        return new UploadingProgressInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UploadingProgressInteractorImpl newInstance(String str, PhotoInteractor photoInteractor, SchedulersFactory schedulersFactory) {
        return new UploadingProgressInteractorImpl(str, photoInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public UploadingProgressInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
