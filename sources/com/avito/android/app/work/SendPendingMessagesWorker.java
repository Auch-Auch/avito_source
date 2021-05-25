package com.avito.android.app.work;

import a2.a.a.j.b.c;
import a2.a.a.j.b.d;
import a2.a.a.j.b.e;
import a2.a.a.j.b.f;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.RxWorker;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.PendingMessageHandler;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.DaggerSendPendingMessagesWorkerComponent;
import com.avito.android.messenger.di.SendPendingMessagesWorkerComponent;
import com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import dagger.Lazy;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.messenger.internal.ConstantsKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/avito/android/app/work/SendPendingMessagesWorker;", "Landroidx/work/RxWorker;", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/Single;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lru/avito/android/persistence/messenger/MessageDao;", "messageDao", "Lru/avito/android/persistence/messenger/MessageDao;", "getMessageDao", "()Lru/avito/android/persistence/messenger/MessageDao;", "setMessageDao", "(Lru/avito/android/persistence/messenger/MessageDao;)V", "Ldagger/Lazy;", "Lcom/avito/android/app/task/PendingMessageHandler;", "pendingMessageHandler", "Ldagger/Lazy;", "getPendingMessageHandler", "()Ldagger/Lazy;", "setPendingMessageHandler", "(Ldagger/Lazy;)V", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "getAccountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountStateProvider", "(Lcom/avito/android/account/AccountStateProvider;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendPendingMessagesWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AccountStateProvider accountStateProvider;
    @Inject
    public MessageDao messageDao;
    @Inject
    public Lazy<PendingMessageHandler> pendingMessageHandler;
    @Inject
    public SchedulersFactory schedulers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/app/work/SendPendingMessagesWorker$Companion;", "", "Landroid/content/Context;", "context", "", "delayInSeconds", "", "replace", "Landroidx/work/WorkContinuation;", "beginWork", "(Landroid/content/Context;JZ)Landroidx/work/WorkContinuation;", "Landroidx/work/Operation;", "cancelWork", "(Landroid/content/Context;)Landroidx/work/Operation;", "", "WORK_NAME", "Ljava/lang/String;", "WORK_TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ WorkContinuation beginWork$default(Companion companion, Context context, long j, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 0;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.beginWork(context, j, z);
        }

        @CheckResult
        @SuppressLint({"EnqueueWork"})
        @NotNull
        public final WorkContinuation beginWork(@NotNull Context context, long j, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n  …\n                .build()");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(SendPendingMessagesWorker.class).setConstraints(build)).addTag(ConstantsKt.LOG_TAG)).setInitialDelay(j, timeUnit)).setBackoffCriteria(BackoffPolicy.LINEAR, 5, timeUnit)).build();
            Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…\n                .build()");
            WorkContinuation beginUniqueWork = WorkManager.getInstance(context).beginUniqueWork("SendPendingMessagesWork", z ? ExistingWorkPolicy.REPLACE : ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) build2);
            Intrinsics.checkNotNullExpressionValue(beginUniqueWork, "WorkManager.getInstance(…flictPolicy, workRequest)");
            return beginUniqueWork;
        }

        @NotNull
        public final Operation cancelWork(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Operation cancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork("SendPendingMessagesWork");
            Intrinsics.checkNotNullExpressionValue(cancelUniqueWork, "WorkManager.getInstance(…ncelUniqueWork(WORK_NAME)");
            return cancelUniqueWork;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<V> implements Callable<String> {
        public final /* synthetic */ SendPendingMessagesWorker a;

        public a(SendPendingMessagesWorker sendPendingMessagesWorker) {
            this.a = sendPendingMessagesWorker;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() {
            String currentUserId = this.a.getAccountStateProvider().getCurrentUserId();
            return currentUserId != null ? currentUserId : "";
        }
    }

    public static final class b<T, R> implements Function<String, SingleSource<? extends ListenableWorker.Result>> {
        public final /* synthetic */ SendPendingMessagesWorker a;

        public b(SendPendingMessagesWorker sendPendingMessagesWorker) {
            this.a = sendPendingMessagesWorker;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ListenableWorker.Result> apply(String str) {
            Single<R> single;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            if (str2.length() > 0) {
                single = this.a.getMessageDao().pendingMessageCount(str2).subscribeOn(this.a.getSchedulers().io()).observeOn(this.a.getSchedulers().computation()).map(a2.a.a.j.b.a.a).distinctUntilChanged().switchMapSingle(new c(this)).firstOrError().timeout(360, TimeUnit.SECONDS).onErrorReturn(d.a);
                Intrinsics.checkNotNullExpressionValue(single, "messageDao.pendingMessag…Return { Result.retry() }");
            } else {
                single = Singles.toSingle(ListenableWorker.Result.success());
            }
            return single.doOnSubscribe(e.a).doOnSuccess(f.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendPendingMessagesWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        Logs.verbose$default("SendPendingMessagesWorker", "work created", null, 4, null);
        SendPendingMessagesWorkerComponent.Builder builder = DaggerSendPendingMessagesWorkerComponent.builder();
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        builder.dependencies((SendPendingMessagesWorkerComponentDependencies) ComponentDependenciesKt.getDependencies(SendPendingMessagesWorkerComponentDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
    }

    @Override // androidx.work.RxWorker
    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        Single fromCallable = Single.fromCallable(new a(this));
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Single subscribeOn = fromCallable.subscribeOn(schedulersFactory.io());
        SchedulersFactory schedulersFactory2 = this.schedulers;
        if (schedulersFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Single<ListenableWorker.Result> flatMap = subscribeOn.observeOn(schedulersFactory2.computation()).flatMap(new b(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable { ac…          }\n            }");
        return flatMap;
    }

    @NotNull
    public final AccountStateProvider getAccountStateProvider() {
        AccountStateProvider accountStateProvider2 = this.accountStateProvider;
        if (accountStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountStateProvider");
        }
        return accountStateProvider2;
    }

    @NotNull
    public final MessageDao getMessageDao() {
        MessageDao messageDao2 = this.messageDao;
        if (messageDao2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageDao");
        }
        return messageDao2;
    }

    @NotNull
    public final Lazy<PendingMessageHandler> getPendingMessageHandler() {
        Lazy<PendingMessageHandler> lazy = this.pendingMessageHandler;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingMessageHandler");
        }
        return lazy;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    public final void setAccountStateProvider(@NotNull AccountStateProvider accountStateProvider2) {
        Intrinsics.checkNotNullParameter(accountStateProvider2, "<set-?>");
        this.accountStateProvider = accountStateProvider2;
    }

    public final void setMessageDao(@NotNull MessageDao messageDao2) {
        Intrinsics.checkNotNullParameter(messageDao2, "<set-?>");
        this.messageDao = messageDao2;
    }

    public final void setPendingMessageHandler(@NotNull Lazy<PendingMessageHandler> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.pendingMessageHandler = lazy;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }
}
