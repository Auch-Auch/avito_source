package com.avito.android.publish.publish_advert_request.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModelFactory;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishAdvertRequestModule_ProvidePublishAdvertRequestViewModelFactoryFactory implements Factory<PublishAdvertRequestViewModelFactory> {
    public final PublishAdvertRequestModule a;
    public final Provider<PublishAdvertRepository> b;
    public final Provider<Analytics> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<UploadingInteractor> e;
    public final Provider<UploadingProgressInteractor> f;

    public PublishAdvertRequestModule_ProvidePublishAdvertRequestViewModelFactoryFactory(PublishAdvertRequestModule publishAdvertRequestModule, Provider<PublishAdvertRepository> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<UploadingInteractor> provider4, Provider<UploadingProgressInteractor> provider5) {
        this.a = publishAdvertRequestModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static PublishAdvertRequestModule_ProvidePublishAdvertRequestViewModelFactoryFactory create(PublishAdvertRequestModule publishAdvertRequestModule, Provider<PublishAdvertRepository> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<UploadingInteractor> provider4, Provider<UploadingProgressInteractor> provider5) {
        return new PublishAdvertRequestModule_ProvidePublishAdvertRequestViewModelFactoryFactory(publishAdvertRequestModule, provider, provider2, provider3, provider4, provider5);
    }

    public static PublishAdvertRequestViewModelFactory providePublishAdvertRequestViewModelFactory(PublishAdvertRequestModule publishAdvertRequestModule, PublishAdvertRepository publishAdvertRepository, Analytics analytics, SchedulersFactory schedulersFactory, UploadingInteractor uploadingInteractor, UploadingProgressInteractor uploadingProgressInteractor) {
        return (PublishAdvertRequestViewModelFactory) Preconditions.checkNotNullFromProvides(publishAdvertRequestModule.providePublishAdvertRequestViewModelFactory(publishAdvertRepository, analytics, schedulersFactory, uploadingInteractor, uploadingProgressInteractor));
    }

    @Override // javax.inject.Provider
    public PublishAdvertRequestViewModelFactory get() {
        return providePublishAdvertRequestViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
