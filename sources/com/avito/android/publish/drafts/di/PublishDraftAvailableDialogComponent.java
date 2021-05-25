package com.avito.android.publish.drafts.di;

import com.avito.android.app.work.PublishDraftsSyncWorker;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.drafts.PublishDraftAvailableDialog;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/drafts/di/PublishDraftAvailableDialogComponent;", "", "Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog;", "dialogFragment", "", "inject", "(Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog;)V", "Lcom/avito/android/app/work/PublishDraftsSyncWorker;", "publishDraftsSyncWorker", "(Lcom/avito/android/app/work/PublishDraftsSyncWorker;)V", "Builder", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishDraftsDependencies.class}, modules = {PublishDraftsAnalyticsModule.class})
@PerFragment
public interface PublishDraftAvailableDialogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/drafts/di/PublishDraftAvailableDialogComponent$Builder;", "", "Lcom/avito/android/publish/drafts/di/PublishDraftsDependencies;", "publishDraftsDependencies", "(Lcom/avito/android/publish/drafts/di/PublishDraftsDependencies;)Lcom/avito/android/publish/drafts/di/PublishDraftAvailableDialogComponent$Builder;", "Lcom/avito/android/publish/drafts/di/PublishDraftAvailableDialogComponent;", "build", "()Lcom/avito/android/publish/drafts/di/PublishDraftAvailableDialogComponent;", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PublishDraftAvailableDialogComponent build();

        @NotNull
        Builder publishDraftsDependencies(@NotNull PublishDraftsDependencies publishDraftsDependencies);
    }

    void inject(@NotNull PublishDraftsSyncWorker publishDraftsSyncWorker);

    void inject(@NotNull PublishDraftAvailableDialog publishDraftAvailableDialog);
}
