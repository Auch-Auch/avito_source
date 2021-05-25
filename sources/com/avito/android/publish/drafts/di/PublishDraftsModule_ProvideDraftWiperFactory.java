package com.avito.android.publish.drafts.di;

import android.app.Application;
import com.avito.android.photo_picker.legacy.DraftPhotosWiper;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvideDraftWiperFactory implements Factory<DraftPhotosWiper> {
    public final Provider<Application> a;
    public final Provider<BuildInfo> b;
    public final Provider<SchedulersFactory> c;

    public PublishDraftsModule_ProvideDraftWiperFactory(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishDraftsModule_ProvideDraftWiperFactory create(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<SchedulersFactory> provider3) {
        return new PublishDraftsModule_ProvideDraftWiperFactory(provider, provider2, provider3);
    }

    public static DraftPhotosWiper provideDraftWiper(Application application, BuildInfo buildInfo, SchedulersFactory schedulersFactory) {
        return (DraftPhotosWiper) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideDraftWiper(application, buildInfo, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public DraftPhotosWiper get() {
        return provideDraftWiper(this.a.get(), this.b.get(), this.c.get());
    }
}
