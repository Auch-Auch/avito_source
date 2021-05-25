package com.avito.android.computer_vision;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ComputerVisionModule_ProvideComputerVisionInteractorFactory implements Factory<ComputerVisionInteractor> {
    public final Provider<PickerApi> a;
    public final Provider<Application> b;
    public final Provider<PhotoPickerEventTracker> c;
    public final Provider<Analytics> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<PublishAnalyticsDataProvider> f;
    public final Provider<PrivatePhotosStorage> g;

    public ComputerVisionModule_ProvideComputerVisionInteractorFactory(Provider<PickerApi> provider, Provider<Application> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<Analytics> provider4, Provider<SchedulersFactory> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<PrivatePhotosStorage> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ComputerVisionModule_ProvideComputerVisionInteractorFactory create(Provider<PickerApi> provider, Provider<Application> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<Analytics> provider4, Provider<SchedulersFactory> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<PrivatePhotosStorage> provider7) {
        return new ComputerVisionModule_ProvideComputerVisionInteractorFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ComputerVisionInteractor provideComputerVisionInteractor(PickerApi pickerApi, Application application, PhotoPickerEventTracker photoPickerEventTracker, Analytics analytics, SchedulersFactory schedulersFactory, PublishAnalyticsDataProvider publishAnalyticsDataProvider, PrivatePhotosStorage privatePhotosStorage) {
        return (ComputerVisionInteractor) Preconditions.checkNotNullFromProvides(ComputerVisionModule.provideComputerVisionInteractor(pickerApi, application, photoPickerEventTracker, analytics, schedulersFactory, publishAnalyticsDataProvider, privatePhotosStorage));
    }

    @Override // javax.inject.Provider
    public ComputerVisionInteractor get() {
        return provideComputerVisionInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
