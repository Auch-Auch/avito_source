package com.avito.android.photo_gallery.tracker;

import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoGalleryTrackerImpl_Factory implements Factory<PhotoGalleryTrackerImpl> {
    public final Provider<ScreenDiInjectTracker> a;
    public final Provider<ScreenInitTracker> b;

    public PhotoGalleryTrackerImpl_Factory(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PhotoGalleryTrackerImpl_Factory create(Provider<ScreenDiInjectTracker> provider, Provider<ScreenInitTracker> provider2) {
        return new PhotoGalleryTrackerImpl_Factory(provider, provider2);
    }

    public static PhotoGalleryTrackerImpl newInstance(ScreenDiInjectTracker screenDiInjectTracker, ScreenInitTracker screenInitTracker) {
        return new PhotoGalleryTrackerImpl(screenDiInjectTracker, screenInitTracker);
    }

    @Override // javax.inject.Provider
    public PhotoGalleryTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
