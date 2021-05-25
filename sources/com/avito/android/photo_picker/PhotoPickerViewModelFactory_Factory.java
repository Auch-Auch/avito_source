package com.avito.android.photo_picker;

import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoPickerViewModelFactory_Factory implements Factory<PhotoPickerViewModelFactory> {
    public final Provider<PhotoPickerInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PhotoPickerEventTracker> c;
    public final Provider<ComputerVisionInteractor> d;
    public final Provider<RandomKeyProvider> e;
    public final Provider<PublishIntentFactory.PhotoPickerMode> f;
    public final Provider<Integer> g;

    public PhotoPickerViewModelFactory_Factory(Provider<PhotoPickerInteractor> provider, Provider<SchedulersFactory> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<ComputerVisionInteractor> provider4, Provider<RandomKeyProvider> provider5, Provider<PublishIntentFactory.PhotoPickerMode> provider6, Provider<Integer> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static PhotoPickerViewModelFactory_Factory create(Provider<PhotoPickerInteractor> provider, Provider<SchedulersFactory> provider2, Provider<PhotoPickerEventTracker> provider3, Provider<ComputerVisionInteractor> provider4, Provider<RandomKeyProvider> provider5, Provider<PublishIntentFactory.PhotoPickerMode> provider6, Provider<Integer> provider7) {
        return new PhotoPickerViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PhotoPickerViewModelFactory newInstance(PhotoPickerInteractor photoPickerInteractor, SchedulersFactory schedulersFactory, PhotoPickerEventTracker photoPickerEventTracker, ComputerVisionInteractor computerVisionInteractor, RandomKeyProvider randomKeyProvider, PublishIntentFactory.PhotoPickerMode photoPickerMode, int i) {
        return new PhotoPickerViewModelFactory(photoPickerInteractor, schedulersFactory, photoPickerEventTracker, computerVisionInteractor, randomKeyProvider, photoPickerMode, i);
    }

    @Override // javax.inject.Provider
    public PhotoPickerViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get().intValue());
    }
}
