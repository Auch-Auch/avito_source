package com.avito.android.publish.di;

import android.app.Application;
import com.avito.android.app.task.PublishDraftsSyncTask;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishTasksModule_ProvidePublishDraftsSaveTaskFactory implements Factory<PublishDraftsSyncTask> {
    public final Provider<Application> a;
    public final Provider<BuildInfo> b;
    public final Provider<PublishDraftRepository> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ConnectivityProvider> e;

    public PublishTasksModule_ProvidePublishDraftsSaveTaskFactory(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<PublishDraftRepository> provider3, Provider<SchedulersFactory> provider4, Provider<ConnectivityProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PublishTasksModule_ProvidePublishDraftsSaveTaskFactory create(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<PublishDraftRepository> provider3, Provider<SchedulersFactory> provider4, Provider<ConnectivityProvider> provider5) {
        return new PublishTasksModule_ProvidePublishDraftsSaveTaskFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static PublishDraftsSyncTask providePublishDraftsSaveTask(Application application, BuildInfo buildInfo, PublishDraftRepository publishDraftRepository, SchedulersFactory schedulersFactory, ConnectivityProvider connectivityProvider) {
        return (PublishDraftsSyncTask) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.providePublishDraftsSaveTask(application, buildInfo, publishDraftRepository, schedulersFactory, connectivityProvider));
    }

    @Override // javax.inject.Provider
    public PublishDraftsSyncTask get() {
        return providePublishDraftsSaveTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
