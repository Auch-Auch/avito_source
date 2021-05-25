package com.avito.android.publish.drafts.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.app.work.PublishDraftsSyncWorker;
import com.avito.android.app.work.PublishDraftsSyncWorker_MembersInjector;
import com.avito.android.publish.drafts.PublishDraftAvailableDialog;
import com.avito.android.publish.drafts.PublishDraftAvailableDialog_MembersInjector;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent;
import com.google.gson.Gson;
import dagger.internal.Preconditions;
public final class DaggerPublishDraftAvailableDialogComponent implements PublishDraftAvailableDialogComponent {
    public final PublishDraftsDependencies a;

    public static final class b implements PublishDraftAvailableDialogComponent.Builder {
        public PublishDraftsDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent.Builder
        public PublishDraftAvailableDialogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishDraftsDependencies.class);
            return new DaggerPublishDraftAvailableDialogComponent(this.a, null);
        }

        @Override // com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent.Builder
        public PublishDraftAvailableDialogComponent.Builder publishDraftsDependencies(PublishDraftsDependencies publishDraftsDependencies) {
            this.a = (PublishDraftsDependencies) Preconditions.checkNotNull(publishDraftsDependencies);
            return this;
        }
    }

    public DaggerPublishDraftAvailableDialogComponent(PublishDraftsDependencies publishDraftsDependencies, a aVar) {
        this.a = publishDraftsDependencies;
    }

    public static PublishDraftAvailableDialogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent
    public void inject(PublishDraftAvailableDialog publishDraftAvailableDialog) {
        PublishDraftAvailableDialog_MembersInjector.injectPublishEventTracker(publishDraftAvailableDialog, PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory.providePublishEventTracker((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()), (Gson) Preconditions.checkNotNullFromComponent(this.a.analyticsSerializer())));
    }

    @Override // com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent
    public void inject(PublishDraftsSyncWorker publishDraftsSyncWorker) {
        PublishDraftsSyncWorker_MembersInjector.injectDraftRepository(publishDraftsSyncWorker, (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository()));
    }
}
