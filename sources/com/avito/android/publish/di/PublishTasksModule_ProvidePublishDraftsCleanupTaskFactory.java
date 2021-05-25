package com.avito.android.publish.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.PublishDraftsCleanupTask;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishTasksModule_ProvidePublishDraftsCleanupTaskFactory implements Factory<PublishDraftsCleanupTask> {
    public final Provider<AccountStateProvider> a;
    public final Provider<PublishDraftWiper> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<BuildInfo> d;

    public PublishTasksModule_ProvidePublishDraftsCleanupTaskFactory(Provider<AccountStateProvider> provider, Provider<PublishDraftWiper> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishTasksModule_ProvidePublishDraftsCleanupTaskFactory create(Provider<AccountStateProvider> provider, Provider<PublishDraftWiper> provider2, Provider<SchedulersFactory> provider3, Provider<BuildInfo> provider4) {
        return new PublishTasksModule_ProvidePublishDraftsCleanupTaskFactory(provider, provider2, provider3, provider4);
    }

    public static PublishDraftsCleanupTask providePublishDraftsCleanupTask(AccountStateProvider accountStateProvider, PublishDraftWiper publishDraftWiper, SchedulersFactory schedulersFactory, BuildInfo buildInfo) {
        return (PublishDraftsCleanupTask) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.providePublishDraftsCleanupTask(accountStateProvider, publishDraftWiper, schedulersFactory, buildInfo));
    }

    @Override // javax.inject.Provider
    public PublishDraftsCleanupTask get() {
        return providePublishDraftsCleanupTask(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
