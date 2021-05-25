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
public final class UpdateUnreadMessagesCountService_MembersInjector implements MembersInjector<UpdateUnreadMessagesCountService> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<UnreadMessagesCounterConsumer> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<MessengerStorage> d;
    public final Provider<SchedulersFactory> e;

    public UpdateUnreadMessagesCountService_MembersInjector(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<UnreadMessagesCounterConsumer> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerStorage> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<UpdateUnreadMessagesCountService> create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<UnreadMessagesCounterConsumer> provider2, Provider<AccountStateProvider> provider3, Provider<MessengerStorage> provider4, Provider<SchedulersFactory> provider5) {
        return new UpdateUnreadMessagesCountService_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountService.accountStateProvider")
    public static void injectAccountStateProvider(UpdateUnreadMessagesCountService updateUnreadMessagesCountService, AccountStateProvider accountStateProvider) {
        updateUnreadMessagesCountService.accountStateProvider = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountService.client")
    public static void injectClient(UpdateUnreadMessagesCountService updateUnreadMessagesCountService, MessengerClient<AvitoMessengerApi> messengerClient) {
        updateUnreadMessagesCountService.client = messengerClient;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountService.messengerStorage")
    public static void injectMessengerStorage(UpdateUnreadMessagesCountService updateUnreadMessagesCountService, MessengerStorage messengerStorage) {
        updateUnreadMessagesCountService.messengerStorage = messengerStorage;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountService.schedulers")
    public static void injectSchedulers(UpdateUnreadMessagesCountService updateUnreadMessagesCountService, SchedulersFactory schedulersFactory) {
        updateUnreadMessagesCountService.schedulers = schedulersFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.UpdateUnreadMessagesCountService.unreadMessagesCounterConsumer")
    public static void injectUnreadMessagesCounterConsumer(UpdateUnreadMessagesCountService updateUnreadMessagesCountService, UnreadMessagesCounterConsumer unreadMessagesCounterConsumer) {
        updateUnreadMessagesCountService.unreadMessagesCounterConsumer = unreadMessagesCounterConsumer;
    }

    public void injectMembers(UpdateUnreadMessagesCountService updateUnreadMessagesCountService) {
        injectClient(updateUnreadMessagesCountService, this.a.get());
        injectUnreadMessagesCounterConsumer(updateUnreadMessagesCountService, this.b.get());
        injectAccountStateProvider(updateUnreadMessagesCountService, this.c.get());
        injectMessengerStorage(updateUnreadMessagesCountService, this.d.get());
        injectSchedulers(updateUnreadMessagesCountService, this.e.get());
    }
}
