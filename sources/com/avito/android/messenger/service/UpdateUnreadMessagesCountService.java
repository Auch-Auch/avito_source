package com.avito.android.messenger.service;

import a2.b.a.a.a;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.messenger.di.DaggerUpdateUnreadMessagesCountWorkerComponent;
import com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/avito/android/messenger/service/UpdateUnreadMessagesCountService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "client", "Lru/avito/messenger/MessengerClient;", "getClient", "()Lru/avito/messenger/MessengerClient;", "setClient", "(Lru/avito/messenger/MessengerClient;)V", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "unreadMessagesCounterConsumer", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "getUnreadMessagesCounterConsumer", "()Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "setUnreadMessagesCounterConsumer", "(Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "getAccountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountStateProvider", "(Lcom/avito/android/account/AccountStateProvider;)V", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/preferences/MessengerStorage;", "getMessengerStorage", "()Lcom/avito/android/preferences/MessengerStorage;", "setMessengerStorage", "(Lcom/avito/android/preferences/MessengerStorage;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateUnreadMessagesCountService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "UpdateUnreadMessagesCountService";
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/service/UpdateUnreadMessagesCountService$Companion;", "", "Landroid/content/Context;", "context", "", "enqueueWork", "(Landroid/content/Context;)V", "", "JOB_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void enqueueWork(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                JobIntentService.enqueueWork(context, UpdateUnreadMessagesCountService.class, 1000, new Intent());
            } catch (Exception e) {
                Logs.warning(UpdateUnreadMessagesCountService.TAG, "Failed to enqueue work", e);
            }
        }

        public Companion(j jVar) {
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

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerUpdateUnreadMessagesCountWorkerComponent.builder().updateUnreadMessagesCountWorkerDependencies((UpdateUnreadMessagesCountDependencies) ComponentDependenciesKt.getDependencies(UpdateUnreadMessagesCountDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default(TAG, a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " start"), null, 4, null);
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
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(']');
            sb.append(sb2.toString());
            sb.append(" SUCCESS");
            Logs.verbose$default(TAG, sb.toString(), null, 4, null);
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder I = a.I('[');
            Thread currentThread2 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
            I.append(currentThread2.getName());
            I.append(']');
            sb3.append(I.toString());
            sb3.append(" FAIL : ");
            sb3.append(th);
            Logs.warning$default(TAG, sb3.toString(), null, 4, null);
        }
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
