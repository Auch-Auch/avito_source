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
import com.avito.android.messenger.di.DaggerMessageIsReadMarkerComponent;
import com.avito.android.messenger.di.MessageIsReadMarkerComponent;
import com.avito.android.messenger.di.MessageIsReadMarkerDependencies;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "marker", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "getMarker$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "setMarker$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageIsReadMarkerWorker extends Worker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "MessageIsReadMarkerWorker";
    @Inject
    public MessageIsReadMarker marker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerWorker$Companion;", "", "Landroid/content/Context;", "context", "", ChannelContext.Item.USER_ID, "channelId", "", "timestamp", "Lkotlin/Pair;", "Ljava/util/UUID;", "Lcom/avito/android/WorkTagAndId;", "enqueue", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)Lkotlin/Pair;", "DEFAULT_TIMESTAMP", "J", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_TIMESTAMP", "KEY_USER_ID", "TAG", "TIMEOUT_SECONDS", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Pair<String, UUID> enqueue(@NotNull Context context, @NotNull String str, @NotNull String str2, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            String c3 = a.c3("MessageIsReadMarkerWorker-", str2);
            Data build2 = new Data.Builder().putString(ChannelContext.Item.USER_ID, str).putString("channelId", str2).putLong("timestamp", j).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Data.Builder()\n         …\n                .build()");
            WorkRequest build3 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(MessageIsReadMarkerWorker.class).setConstraints(build)).addTag(c3)).setInputData(build2)).build();
            Intrinsics.checkNotNullExpressionValue(build3, "OneTimeWorkRequest.Build…\n                .build()");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build3;
            WorkManager.getInstance(context).beginUniqueWork(c3, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest).enqueue();
            UUID id = oneTimeWorkRequest.getId();
            Intrinsics.checkNotNullExpressionValue(id, "workRequest.id");
            Pair<String, UUID> pair = TuplesKt.to(c3, id);
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" enqueued ");
            sb.append(pair);
            Logs.verbose$default(MessageIsReadMarkerWorker.TAG, sb.toString(), null, 4, null);
            return pair;
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageIsReadMarkerWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
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
            Intrinsics.checkNotNullExpressionValue(string, "inputData.getString(KEY_…esult.failure()\n        }");
            String string2 = getInputData().getString("channelId");
            if (string2 != null) {
                Intrinsics.checkNotNullExpressionValue(string2, "inputData.getString(KEY_…esult.failure()\n        }");
                long j = getInputData().getLong("timestamp", -1);
                if (j == -1) {
                    Logs.error$default(TAG, "No timestamp was passed!", null, 4, null);
                    ListenableWorker.Result failure = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
                    return failure;
                }
                MessageIsReadMarkerComponent.Builder builder = DaggerMessageIsReadMarkerComponent.builder();
                Context applicationContext = getApplicationContext();
                Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
                builder.messageIsReadMarkerDependencies((MessageIsReadMarkerDependencies) ComponentDependenciesKt.getDependencies(MessageIsReadMarkerDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
                try {
                    MessageIsReadMarker messageIsReadMarker = this.marker;
                    if (messageIsReadMarker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("marker");
                    }
                    if (messageIsReadMarker.markMessagesAsRead(string, string2, j).blockingAwait(15, TimeUnit.SECONDS)) {
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
                ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
                Intrinsics.checkNotNullExpressionValue(failure2, "Result.failure()");
                return failure2;
            }
        } else {
            Logs.error$default(TAG, "No userId was passed!", null, 4, null);
            ListenableWorker.Result failure3 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure3, "Result.failure()");
            return failure3;
        }
    }

    @NotNull
    public final MessageIsReadMarker getMarker$messenger_release() {
        MessageIsReadMarker messageIsReadMarker = this.marker;
        if (messageIsReadMarker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marker");
        }
        return messageIsReadMarker;
    }

    public final void setMarker$messenger_release(@NotNull MessageIsReadMarker messageIsReadMarker) {
        Intrinsics.checkNotNullParameter(messageIsReadMarker, "<set-?>");
        this.marker = messageIsReadMarker;
    }
}
