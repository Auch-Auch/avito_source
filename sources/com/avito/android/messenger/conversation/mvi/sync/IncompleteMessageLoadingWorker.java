package com.avito.android.messenger.conversation.mvi.sync;

import a2.b.a.a.a;
import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.DaggerIncompleteMessageLoaderComponent;
import com.avito.android.messenger.di.IncompleteMessageLoaderComponent;
import com.avito.android.messenger.di.IncompleteMessageLoaderDependencies;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageLoadingWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "loader", "Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "getLoader$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "setLoader$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class IncompleteMessageLoadingWorker extends Worker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "IncompleteMessageLoadingWorker";
    @Inject
    public IncompleteMessageBodyLoader loader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageLoadingWorker$Companion;", "", "Landroid/content/Context;", "context", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lkotlin/Pair;", "Ljava/util/UUID;", "Lcom/avito/android/WorkTagAndId;", "enqueue", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "CHANNEL_ID_KEY", "Ljava/lang/String;", "MESSAGE_LOCAL_ID_KEY", "TAG", "USER_ID_KEY", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Pair<String, UUID> enqueue(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
            String str4;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            if (str3 != null) {
                str4 = "IncompleteMessageLoadingWorker-" + str2 + '-' + str3;
            } else {
                str4 = a.c3("IncompleteMessageLoadingWorker-", str2);
            }
            Data build2 = new Data.Builder().putString(ChannelContext.Item.USER_ID, str).putString("channelId", str2).putString("localId", str3).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Data.Builder()\n         …\n                .build()");
            WorkRequest build3 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(IncompleteMessageLoadingWorker.class).setConstraints(build)).addTag(str4)).setInputData(build2)).build();
            Intrinsics.checkNotNullExpressionValue(build3, "OneTimeWorkRequest.Build…\n                .build()");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build3;
            WorkManager.getInstance(context).beginUniqueWork(str4, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest).enqueue();
            UUID id = oneTimeWorkRequest.getId();
            Intrinsics.checkNotNullExpressionValue(id, "workRequest.id");
            Pair<String, UUID> pair = TuplesKt.to(str4, id);
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" enqueued ");
            sb.append(pair);
            Logs.verbose$default(IncompleteMessageLoadingWorker.TAG, sb.toString(), null, 4, null);
            return pair;
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IncompleteMessageLoadingWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result result;
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" start ");
        sb.append(getId());
        Logs.verbose$default(TAG, sb.toString(), null, 4, null);
        String string = getInputData().getString(ChannelContext.Item.USER_ID);
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "inputData.getString(USER…esult.failure()\n        }");
            String string2 = getInputData().getString("channelId");
            if (string2 != null) {
                Intrinsics.checkNotNullExpressionValue(string2, "inputData.getString(CHAN…esult.failure()\n        }");
                String string3 = getInputData().getString("localId");
                IncompleteMessageLoaderComponent.Builder builder = DaggerIncompleteMessageLoaderComponent.builder();
                Context applicationContext = getApplicationContext();
                Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
                builder.incompleteMessageLoaderDependencies((IncompleteMessageLoaderDependencies) ComponentDependenciesKt.getDependencies(IncompleteMessageLoaderDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
                try {
                    IncompleteMessageBodyLoader incompleteMessageBodyLoader = this.loader;
                    if (incompleteMessageBodyLoader == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loader");
                    }
                    if (incompleteMessageBodyLoader.loadIncompleteMessageBodies(string, string2, string3).blockingAwait(60, TimeUnit.SECONDS)) {
                        Logs.verbose$default(TAG, "Completed userId=" + string + " channelId=" + string2, null, 4, null);
                        result = ListenableWorker.Result.success();
                    } else {
                        Logs.warning$default(TAG, "Timed out userId=" + string + " channelId=" + string2, null, 4, null);
                        result = ListenableWorker.Result.retry();
                    }
                    Intrinsics.checkNotNullExpressionValue(result, "if (finished) {\n        …ult.retry()\n            }");
                    return result;
                } catch (Exception e) {
                    Logs.warning(TAG, a.d("Failed userId=", string, " channelId=", string2), e);
                    ListenableWorker.Result retry = ListenableWorker.Result.retry();
                    Intrinsics.checkNotNullExpressionValue(retry, "Result.retry()");
                    return retry;
                }
            } else {
                Logs.error$default(TAG, "No channelId was passed!", null, 4, null);
                ListenableWorker.Result failure = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
                return failure;
            }
        } else {
            Logs.error$default(TAG, "No userId was passed!", null, 4, null);
            ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure2, "Result.failure()");
            return failure2;
        }
    }

    @NotNull
    public final IncompleteMessageBodyLoader getLoader$messenger_release() {
        IncompleteMessageBodyLoader incompleteMessageBodyLoader = this.loader;
        if (incompleteMessageBodyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
        }
        return incompleteMessageBodyLoader;
    }

    public final void setLoader$messenger_release(@NotNull IncompleteMessageBodyLoader incompleteMessageBodyLoader) {
        Intrinsics.checkNotNullParameter(incompleteMessageBodyLoader, "<set-?>");
        this.loader = incompleteMessageBodyLoader;
    }
}
