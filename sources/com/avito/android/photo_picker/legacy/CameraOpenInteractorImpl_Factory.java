package com.avito.android.photo_picker.legacy;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CameraOpenInteractorImpl_Factory implements Factory<CameraOpenInteractorImpl> {
    public final Provider<CameraSource> a;
    public final Provider<Analytics> b;

    public CameraOpenInteractorImpl_Factory(Provider<CameraSource> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CameraOpenInteractorImpl_Factory create(Provider<CameraSource> provider, Provider<Analytics> provider2) {
        return new CameraOpenInteractorImpl_Factory(provider, provider2);
    }

    public static CameraOpenInteractorImpl newInstance(CameraSource cameraSource, Analytics analytics) {
        return new CameraOpenInteractorImpl(cameraSource, analytics);
    }

    @Override // javax.inject.Provider
    public CameraOpenInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
