package com.avito.android.publish.drafts;

import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishDraftAvailableDialog_MembersInjector implements MembersInjector<PublishDraftAvailableDialog> {
    public final Provider<PublishDraftEventTracker> a;

    public PublishDraftAvailableDialog_MembersInjector(Provider<PublishDraftEventTracker> provider) {
        this.a = provider;
    }

    public static MembersInjector<PublishDraftAvailableDialog> create(Provider<PublishDraftEventTracker> provider) {
        return new PublishDraftAvailableDialog_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.publish.drafts.PublishDraftAvailableDialog.publishEventTracker")
    public static void injectPublishEventTracker(PublishDraftAvailableDialog publishDraftAvailableDialog, PublishDraftEventTracker publishDraftEventTracker) {
        publishDraftAvailableDialog.publishEventTracker = publishDraftEventTracker;
    }

    public void injectMembers(PublishDraftAvailableDialog publishDraftAvailableDialog) {
        injectPublishEventTracker(publishDraftAvailableDialog, this.a.get());
    }
}
