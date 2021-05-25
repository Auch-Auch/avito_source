package com.avito.android.publish.di;

import com.avito.android.app.task.PhotosCleanTask;
import com.avito.android.photo_picker.legacy.PhotoStorageCleaner;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishTasksModule_ProvidePhotosCleanTaskFactory implements Factory<PhotosCleanTask> {
    public final Provider<PublishDraftRepository> a;
    public final Provider<PhotoStorageCleaner> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<BuildInfo> d;

    public PublishTasksModule_ProvidePhotosCleanTaskFactory(Provider<PublishDraftRepository> provider, Provider<PhotoStorageCleaner> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishTasksModule_ProvidePhotosCleanTaskFactory create(Provider<PublishDraftRepository> provider, Provider<PhotoStorageCleaner> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        return new PublishTasksModule_ProvidePhotosCleanTaskFactory(provider, provider2, provider3, provider4);
    }

    public static PhotosCleanTask providePhotosCleanTask(PublishDraftRepository publishDraftRepository, PhotoStorageCleaner photoStorageCleaner, SchedulersFactory schedulersFactory, BuildInfo buildInfo) {
        return (PhotosCleanTask) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.providePhotosCleanTask(publishDraftRepository, photoStorageCleaner, schedulersFactory, buildInfo));
    }

    @Override // javax.inject.Provider
    public PhotosCleanTask get() {
        return providePhotosCleanTask(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
