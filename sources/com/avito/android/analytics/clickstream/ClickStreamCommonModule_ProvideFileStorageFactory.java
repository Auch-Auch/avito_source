package com.avito.android.analytics.clickstream;

import android.app.Application;
import com.avito.android.analytics.inhouse_transport.FileStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamCommonModule_ProvideFileStorageFactory implements Factory<FileStorage> {
    public final Provider<Application> a;

    public ClickStreamCommonModule_ProvideFileStorageFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ClickStreamCommonModule_ProvideFileStorageFactory create(Provider<Application> provider) {
        return new ClickStreamCommonModule_ProvideFileStorageFactory(provider);
    }

    public static FileStorage provideFileStorage(Application application) {
        return (FileStorage) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideFileStorage(application));
    }

    @Override // javax.inject.Provider
    public FileStorage get() {
        return provideFileStorage(this.a.get());
    }
}
