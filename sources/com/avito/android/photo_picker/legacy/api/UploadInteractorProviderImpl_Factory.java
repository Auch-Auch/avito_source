package com.avito.android.photo_picker.legacy.api;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
public final class UploadInteractorProviderImpl_Factory implements Factory<UploadInteractorProviderImpl> {
    public final Provider<Map<String, UploadInteractor>> a;

    public UploadInteractorProviderImpl_Factory(Provider<Map<String, UploadInteractor>> provider) {
        this.a = provider;
    }

    public static UploadInteractorProviderImpl_Factory create(Provider<Map<String, UploadInteractor>> provider) {
        return new UploadInteractorProviderImpl_Factory(provider);
    }

    public static UploadInteractorProviderImpl newInstance(Map<String, UploadInteractor> map) {
        return new UploadInteractorProviderImpl(map);
    }

    @Override // javax.inject.Provider
    public UploadInteractorProviderImpl get() {
        return newInstance(this.a.get());
    }
}
