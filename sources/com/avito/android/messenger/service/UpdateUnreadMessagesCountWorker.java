package com.avito.android.messenger.service;

import a2.b.a.a.a;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.messenger.di.DaggerUpdateUnreadMessagesCountWorkerComponent;
import com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies;
import com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/avito/android/messenger/service/UpdateUnreadMessagesCountWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "getAccountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountStateProvider", "(Lcom/avito/android/account/AccountStateProvider;)V", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "unreadMessagesCounterConsumer", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "getUnreadMessagesCounterConsumer", "()Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "setUnreadMessagesCounterConsumer", "(Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;)V", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/preferences/MessengerStorage;", "getMessengerStorage", "()Lcom/avito/android/preferences/MessengerStorage;", "setMessengerStorage", "(Lcom/avito/android/preferences/MessengerStorage;)V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "client", "Lru/avito/messenger/MessengerClient;", "getClient", "()Lru/avito/messenger/MessengerClient;", "setClient", "(Lru/avito/messenger/MessengerClient;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateUnreadMessagesCountWorker extends Worker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "UpdateUnreadMessagesCountWorker";
    @Inject
    public AccountStateProvider accountStateProvider;
    @Inject
    public MessengerClient<AvitoMessengerApi> client;
    @Inject
    public MessengerStorage messengerStorage;
    @Inject
    public SchedulersFactory schedulers;
    @Inject
    public UnreadMessagesCounterConsumer unreadMessagesCounterConsumer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/service/UpdateUnreadMessagesCountWorker$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateUnreadMessagesCountWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        HasComponentDependencies hasComponentDependencies;
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
        UpdateUnreadMessagesCountWorkerComponent.Builder builder = DaggerUpdateUnreadMessagesCountWorkerComponent.builder();
        Context applicationContext = getApplicationContext();
        if (this instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) this;
        } else if (applicationContext instanceof HasComponentDependencies) {
            hasComponentDependencies = (HasComponentDependencies) applicationContext;
        } else {
            throw new IllegalStateException("Can not find suitable dagger provider of HasComponentDependencies for " + this);
        }
        builder.updateUnreadMessagesCountWorkerDependencies((UpdateUnreadMessagesCountDependencies) ComponentDependenciesKt.getDependencies(UpdateUnreadMessagesCountDependencies.class, hasComponentDependencies)).build().inject(this);
        try {
            MessengerClient<AvitoMessengerApi> messengerClient = this.client;
            if (messengerClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("client");
            }
            UnreadMessagesCounterConsumer unreadMessagesCounterConsumer2 = this.unreadMessagesCounterConsumer;
            if (unreadMessagesCounterConsumer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unreadMessagesCounterConsumer");
            }
            AccountStateProvider accountStateProvider2 = this.accountStateProvider;
            if (accountStateProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("accountStateProvider");
            }
            MessengerStorage messengerStorage2 = this.messengerStorage;
            if (messengerStorage2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messengerStorage");
            }
            SchedulersFactory schedulersFactory = this.schedulers;
            if (schedulersFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schedulers");
            }
            UpdateUnreadMessagesCountWorkerKt.updateUnreadMessageModel(TAG, messengerClient, unreadMessagesCounterConsumer2, accountStateProvider2, messengerStorage2, schedulersFactory);
            ListenableWorker.Result success = ListenableWorker.Result.success();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb3.append('[');
            Thread currentThread2 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
            sb3.append(currentThread2.getName());
            sb3.append(']');
            sb2.append(sb3.toString());
            sb2.append(" SUCCESS ");
            sb2.append(getId());
            Logs.verbose$default(TAG, sb2.toString(), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(success, "Result.success().also {\n…CCESS $id\")\n            }");
            return success;
        } catch (Throwable th) {
            ListenableWorker.Result retry = ListenableWorker.Result.retry();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder I2 = a.I('[');
            Thread currentThread3 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread3, "Thread.currentThread()");
            I2.append(currentThread3.getName());
            I2.append(']');
            sb4.append(I2.toString());
            sb4.append(" RETRY ");
            sb4.append(getId());
            sb4.append(": ");
            sb4.append(th);
            Logs.warning$default(TAG, sb4.toString(), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(retry, "Result.retry().also {\n  …Y $id: $t\")\n            }");
            return retry;
        }
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
    public final MessengerClient<AvitoMessengerApi> getClient() {
        MessengerClient<AvitoMessengerApi> messengerClient = this.client;
        if (messengerClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        return messengerClient;
    }

    @NotNull
    public final MessengerStorage getMessengerStorage() {
        MessengerStorage messengerStorage2 = this.messengerStorage;
        if (messengerStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messengerStorage");
        }
        return messengerStorage2;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @NotNull
    public final UnreadMessagesCounterConsumer getUnreadMessagesCounterConsumer() {
        UnreadMessagesCounterConsumer unreadMessagesCounterConsumer2 = this.unreadMessagesCounterConsumer;
        if (unreadMessagesCounterConsumer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unreadMessagesCounterConsumer");
        }
        return unreadMessagesCounterConsumer2;
    }

    public final void setAccountStateProvider(@NotNull AccountStateProvider accountStateProvider2) {
        Intrinsics.checkNotNullParameter(accountStateProvider2, "<set-?>");
        this.accountStateProvider = accountStateProvider2;
    }

    public final void setClient(@NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        Intrinsics.checkNotNullParameter(messengerClient, "<set-?>");
        this.client = messengerClient;
    }

    public final void setMessengerStorage(@NotNull MessengerStorage messengerStorage2) {
        Intrinsics.checkNotNullParameter(messengerStorage2, "<set-?>");
        this.messengerStorage = messengerStorage2;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    public final void setUnreadMessagesCounterConsumer(@NotNull UnreadMessagesCounterConsumer unreadMessagesCounterConsumer2) {
        Intrinsics.checkNotNullParameter(unreadMessagesCounterConsumer2, "<set-?>");
        this.unreadMessagesCounterConsumer = unreadMessagesCounterConsumer2;
    }
}
