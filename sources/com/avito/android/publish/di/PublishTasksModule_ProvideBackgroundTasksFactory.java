package com.avito.android.publish.di;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.PhotosCleanTask;
import com.avito.android.app.task.PublishDraftsCleanupTask;
import com.avito.android.app.task.PublishDraftsSyncTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class PublishTasksModule_ProvideBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<PublishDraftsCleanupTask> a;
    public final Provider<PhotosCleanTask> b;
    public final Provider<PublishDraftsSyncTask> c;

    public PublishTasksModule_ProvideBackgroundTasksFactory(Provider<PublishDraftsCleanupTask> provider, Provider<PhotosCleanTask> provider2, Provider<PublishDraftsSyncTask> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishTasksModule_ProvideBackgroundTasksFactory create(Provider<PublishDraftsCleanupTask> provider, Provider<PhotosCleanTask> provider2, Provider<PublishDraftsSyncTask> provider3) {
        return new PublishTasksModule_ProvideBackgroundTasksFactory(provider, provider2, provider3);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<PublishDraftsCleanupTask> lazy, Lazy<PhotosCleanTask> lazy2, Lazy<PublishDraftsSyncTask> lazy3) {
        return (List) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.provideBackgroundTasks(lazy, lazy2, lazy3));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a), DoubleCheck.lazy(this.b), DoubleCheck.lazy(this.c));
    }
}
