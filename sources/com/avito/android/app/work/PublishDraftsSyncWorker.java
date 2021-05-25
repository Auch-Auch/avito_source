package com.avito.android.app.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.di.DaggerPublishDraftAvailableDialogComponent;
import com.avito.android.publish.drafts.di.PublishDraftAvailableDialogComponent;
import com.avito.android.publish.drafts.di.PublishDraftsDependencies;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/app/work/PublishDraftsSyncWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "draftRepository", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "getDraftRepository$publish_drafts_release", "()Lcom/avito/android/publish/drafts/PublishDraftRepository;", "setDraftRepository$publish_drafts_release", "(Lcom/avito/android/publish/drafts/PublishDraftRepository;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftsSyncWorker extends Worker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "PublishDraftsSyncWorker";
    @Inject
    public PublishDraftRepository draftRepository;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/app/work/PublishDraftsSyncWorker$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PublishDraftRepository.DraftSyncResult.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishDraftsSyncWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result result;
        try {
            PublishDraftAvailableDialogComponent.Builder builder = DaggerPublishDraftAvailableDialogComponent.builder();
            Context applicationContext = getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
            builder.publishDraftsDependencies((PublishDraftsDependencies) ComponentDependenciesKt.getDependencies(PublishDraftsDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
            PublishDraftRepository publishDraftRepository = this.draftRepository;
            if (publishDraftRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draftRepository");
            }
            PublishDraftRepository.DraftSyncResult blockingGet = publishDraftRepository.syncDraftIfNeeded().blockingGet();
            if (blockingGet != null) {
                if (blockingGet.ordinal() == 0) {
                    result = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(result, "when (finished) {\n      … Result.retry()\n        }");
                    return result;
                }
            }
            result = ListenableWorker.Result.retry();
            Intrinsics.checkNotNullExpressionValue(result, "when (finished) {\n      … Result.retry()\n        }");
            return result;
        } catch (Exception unused) {
            ListenableWorker.Result retry = ListenableWorker.Result.retry();
            Intrinsics.checkNotNullExpressionValue(retry, "Result.retry()");
            return retry;
        }
    }

    @NotNull
    public final PublishDraftRepository getDraftRepository$publish_drafts_release() {
        PublishDraftRepository publishDraftRepository = this.draftRepository;
        if (publishDraftRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftRepository");
        }
        return publishDraftRepository;
    }

    public final void setDraftRepository$publish_drafts_release(@NotNull PublishDraftRepository publishDraftRepository) {
        Intrinsics.checkNotNullParameter(publishDraftRepository, "<set-?>");
        this.draftRepository = publishDraftRepository;
    }
}
