package com.avito.android.app.work;

import com.avito.android.publish.drafts.PublishDraftRepository;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishDraftsSyncWorker_MembersInjector implements MembersInjector<PublishDraftsSyncWorker> {
    public final Provider<PublishDraftRepository> a;

    public PublishDraftsSyncWorker_MembersInjector(Provider<PublishDraftRepository> provider) {
        this.a = provider;
    }

    public static MembersInjector<PublishDraftsSyncWorker> create(Provider<PublishDraftRepository> provider) {
        return new PublishDraftsSyncWorker_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.app.work.PublishDraftsSyncWorker.draftRepository")
    public static void injectDraftRepository(PublishDraftsSyncWorker publishDraftsSyncWorker, PublishDraftRepository publishDraftRepository) {
        publishDraftsSyncWorker.draftRepository = publishDraftRepository;
    }

    public void injectMembers(PublishDraftsSyncWorker publishDraftsSyncWorker) {
        injectDraftRepository(publishDraftsSyncWorker, this.a.get());
    }
}
