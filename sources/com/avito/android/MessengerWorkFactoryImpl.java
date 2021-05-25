package com.avito.android;

import a2.b.a.a.a;
import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.avito.android.app.work.OperationsKt;
import com.avito.android.app.work.SendPendingMessagesWorker;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountService;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.Completable;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/MessengerWorkFactoryImpl;", "Lcom/avito/android/MessengerWorkFactory;", "Lkotlin/Pair;", "", "Ljava/util/UUID;", "Lcom/avito/android/WorkTagAndId;", "enqueueUpdateUnreadMessagesCountWork", "()Lkotlin/Pair;", "", "delayInSeconds", "", "replace", "Lio/reactivex/Completable;", "enqueueSendPendingMessagesWork", "(JZ)Lio/reactivex/Completable;", "cancelSendPendingMessagesWork", "()Lio/reactivex/Completable;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerWorkFactoryImpl implements MessengerWorkFactory {
    public final Context a;
    public final Features b;

    @Inject
    public MessengerWorkFactoryImpl(@NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = features;
        this.a = context.getApplicationContext();
    }

    @Override // com.avito.android.MessengerWorkFactory
    @NotNull
    public Completable cancelSendPendingMessagesWork() {
        SendPendingMessagesWorker.Companion companion = SendPendingMessagesWorker.Companion;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return OperationsKt.completableResult$default(companion.cancelWork(context), null, 1, null);
    }

    @Override // com.avito.android.MessengerWorkFactory
    @NotNull
    public Completable enqueueSendPendingMessagesWork(long j, boolean z) {
        SendPendingMessagesWorker.Companion companion = SendPendingMessagesWorker.Companion;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Operation enqueue = companion.beginWork(context, j, z).enqueue();
        Intrinsics.checkNotNullExpressionValue(enqueue, "SendPendingMessagesWorke…e)\n            .enqueue()");
        return OperationsKt.completableResult$default(enqueue, null, 1, null);
    }

    @Override // com.avito.android.MessengerWorkFactory
    @Nullable
    public Pair<String, UUID> enqueueUpdateUnreadMessagesCountWork() {
        if (this.b.getMessengerWorkManager().invoke().booleanValue()) {
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(UpdateUnreadMessagesCountWorker.class).setConstraints(build)).addTag(UpdateUnreadMessagesCountWorker.TAG)).build();
            Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…\n                .build()");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) build2;
            WorkManager.getInstance(this.a).beginUniqueWork(UpdateUnreadMessagesCountWorker.TAG, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest).enqueue();
            UUID id = oneTimeWorkRequest.getId();
            Intrinsics.checkNotNullExpressionValue(id, "workRequest.id");
            Pair<String, UUID> pair = TuplesKt.to(UpdateUnreadMessagesCountWorker.TAG, id);
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" enqueued ");
            sb.append(pair);
            Logs.verbose$default("MessengerWorkFactory", sb.toString(), null, 4, null);
            return pair;
        }
        UpdateUnreadMessagesCountService.Companion companion = UpdateUnreadMessagesCountService.Companion;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.enqueueWork(context);
        return null;
    }
}
