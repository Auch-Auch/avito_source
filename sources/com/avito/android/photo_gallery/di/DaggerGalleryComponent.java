package com.avito.android.photo_gallery.di;

import com.avito.android.Features;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.photo_gallery.GalleryFragment;
import com.avito.android.photo_gallery.GalleryFragment_MembersInjector;
import com.avito.android.photo_gallery.di.GalleryComponent;
import com.avito.android.photo_gallery.tracker.GalleryTracker;
import com.avito.android.photo_gallery.tracker.GalleryTrackerImpl;
import com.avito.android.photo_gallery.tracker.GalleryTrackerImpl_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerGalleryComponent implements GalleryComponent {
    public final GalleryDependencies a;
    public Provider<ScreenTrackerFactory> b;
    public Provider<Screen> c;
    public Provider<Boolean> d;
    public Provider<TimerFactory> e;
    public Provider<ScreenDiInjectTracker> f;
    public Provider<ScreenInitTracker> g = DoubleCheck.provider(GalleryTrackerModule_ProvidesScreenInitTrackerFactory.create(this.b, this.c, this.d, this.e));
    public Provider<ScreenFlowTrackerProvider> h;
    public Provider<GalleryTrackerImpl> i;
    public Provider<GalleryTracker> j;

    public static final class b implements GalleryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.photo_gallery.di.GalleryComponent.Factory
        public GalleryComponent create(GalleryDependencies galleryDependencies, Screen screen, boolean z) {
            Preconditions.checkNotNull(galleryDependencies);
            Preconditions.checkNotNull(screen);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            return new DaggerGalleryComponent(galleryDependencies, screen, Boolean.valueOf(z), null);
        }
    }

    public static class c implements Provider<ScreenTrackerFactory> {
        public final GalleryDependencies a;

        public c(GalleryDependencies galleryDependencies) {
            this.a = galleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class d implements Provider<TimerFactory> {
        public final GalleryDependencies a;

        public d(GalleryDependencies galleryDependencies) {
            this.a = galleryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerGalleryComponent(GalleryDependencies galleryDependencies, Screen screen, Boolean bool, a aVar) {
        this.a = galleryDependencies;
        this.b = new c(galleryDependencies);
        this.c = InstanceFactory.create(screen);
        Factory create = InstanceFactory.create(bool);
        this.d = create;
        d dVar = new d(galleryDependencies);
        this.e = dVar;
        this.f = DoubleCheck.provider(GalleryTrackerModule_ProvidesScreenDiInjectTracker$photo_gallery_releaseFactory.create(this.b, this.c, create, dVar));
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(GalleryTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.b, this.c, this.e));
        this.h = provider;
        GalleryTrackerImpl_Factory create2 = GalleryTrackerImpl_Factory.create(this.f, this.g, provider);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
    }

    public static GalleryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.photo_gallery.di.GalleryComponent
    public void inject(GalleryFragment galleryFragment) {
        GalleryFragment_MembersInjector.injectTracker(galleryFragment, this.j.get());
        GalleryFragment_MembersInjector.injectAnalytics(galleryFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        GalleryFragment_MembersInjector.injectConnectivityProvider(galleryFragment, (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider()));
        GalleryFragment_MembersInjector.injectFeatures(galleryFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        GalleryFragment_MembersInjector.injectAutotekaTeaserInGalleryTestGroup(galleryFragment, (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.getAutotekaTeaserInGalleryTestGroup()));
    }
}
