package com.avito.android.app.work;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/app/work/PublishDraftsSyncWorkFactoryImpl;", "Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;", "", "enqueue", "()V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftsSyncWorkFactoryImpl implements PublishDraftsSyncWorkFactory {
    @NotNull
    public final Context a;

    public PublishDraftsSyncWorkFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.app.work.PublishDraftsSyncWorkFactory
    public void enqueue() {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …TED)\n            .build()");
        WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(PublishDraftsSyncWorker.class).setConstraints(build)).setInitialDelay(15, TimeUnit.SECONDS)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…NDS)\n            .build()");
        WorkManager.getInstance(this.a).beginUniqueWork(PublishDraftsSyncWorker.TAG, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build2).enqueue();
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }
}
