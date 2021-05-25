package com.avito.android.messenger.service;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class UpdateUnreadMessagesCountWorker_MembersInjector implements MembersInjector<UpdateUnreadMessagesCountWorker> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<UnreadMessagesCounterConsumer> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<MessengerStorage> d;
    public final Provider<SchedulersFactory> e;

    public UpdateUnreadMessagesCountWorker_MembersInjector(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<UnreadMessagesCounterConsumer> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerStorage> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<UpdateUnreadMessagesCountWorker> create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<UnreadMessagesCounterConsumer> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerStorage> provider4, Provider<SchedulersFactory> provider5) {
        return new UpdateUnreadMessagesCountWorker_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker.accountStateProvider")
    public static void injectAccountStateProvider(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker, AccountStateProvider accountStateProvider) {
        updateUnreadMessagesCountWorker.accountStateProvider = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker.client")
    public static void injectClient(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker, MessengerClient<AvitoMessengerApi> messengerClient) {
        updateUnreadMessagesCountWorker.client = messengerClient;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker.messengerStorage")
    public static void injectMessengerStorage(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker, MessengerStorage messengerStorage) {
        updateUnreadMessagesCountWorker.messengerStorage = messengerStorage;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker.schedulers")
    public static void injectSchedulers(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker, SchedulersFactory schedulersFactory) {
        updateUnreadMessagesCountWorker.schedulers = schedulersFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker.unreadMessagesCounterConsumer")
    public static void injectUnreadMessagesCounterConsumer(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker, UnreadMessagesCounterConsumer unreadMessagesCounterConsumer) {
        updateUnreadMessagesCountWorker.unreadMessagesCounterConsumer = unreadMessagesCounterConsumer;
    }

    public void injectMembers(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker) {
        injectClient(updateUnreadMessagesCountWorker, this.a.get());
        injectUnreadMessagesCounterConsumer(updateUnreadMessagesCountWorker, this.b.get());
        injectAccountStateProvider(updateUnreadMessagesCountWorker, this.c.get());
        injectMessengerStorage(updateUnreadMessagesCountWorker, this.d.get());
        injectSchedulers(updateUnreadMessagesCountWorker, this.e.get());
    }
}
