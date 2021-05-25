package com.avito.android.app.work;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.PendingMessageHandler;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessageDao;
public final class SendPendingMessagesWorker_MembersInjector implements MembersInjector<SendPendingMessagesWorker> {
    public final Provider<AccountStateProvider> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<MessageDao> c;
    public final Provider<PendingMessageHandler> d;

    public SendPendingMessagesWorker_MembersInjector(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2, Provider<MessageDao> provider3, Provider<PendingMessageHandler> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<SendPendingMessagesWorker> create(Provider<AccountStateProvider> provider, Provider<SchedulersFactory> provider2, Provider<MessageDao> provider3, Provider<PendingMessageHandler> provider4) {
        return new SendPendingMessagesWorker_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.app.work.SendPendingMessagesWorker.accountStateProvider")
    public static void injectAccountStateProvider(SendPendingMessagesWorker sendPendingMessagesWorker, AccountStateProvider accountStateProvider) {
        sendPendingMessagesWorker.accountStateProvider = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.app.work.SendPendingMessagesWorker.messageDao")
    public static void injectMessageDao(SendPendingMessagesWorker sendPendingMessagesWorker, MessageDao messageDao) {
        sendPendingMessagesWorker.messageDao = messageDao;
    }

    @InjectedFieldSignature("com.avito.android.app.work.SendPendingMessagesWorker.pendingMessageHandler")
    public static void injectPendingMessageHandler(SendPendingMessagesWorker sendPendingMessagesWorker, Lazy<PendingMessageHandler> lazy) {
        sendPendingMessagesWorker.pendingMessageHandler = lazy;
    }

    @InjectedFieldSignature("com.avito.android.app.work.SendPendingMessagesWorker.schedulers")
    public static void injectSchedulers(SendPendingMessagesWorker sendPendingMessagesWorker, SchedulersFactory schedulersFactory) {
        sendPendingMessagesWorker.schedulers = schedulersFactory;
    }

    public void injectMembers(SendPendingMessagesWorker sendPendingMessagesWorker) {
        injectAccountStateProvider(sendPendingMessagesWorker, this.a.get());
        injectSchedulers(sendPendingMessagesWorker, this.b.get());
        injectMessageDao(sendPendingMessagesWorker, this.c.get());
        injectPendingMessageHandler(sendPendingMessagesWorker, DoubleCheck.lazy(this.d));
    }
}
