package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.MessengerWorkFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.messenger.conversation.mvi.sync.SyncJobSchedulerImpl;
import com.avito.android.messenger.conversation.mvi.sync.SyncJobsScheduler;
import com.avito.android.messenger.service.UnreadChatsCounterSyncAgent;
import com.avito.android.messenger.service.UnreadChatsCounterSyncAgentImpl;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerEventObserver;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0007\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u001d\u001a\u00020\u001a2\u0011\u0010\u0007\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/di/MessengerSyncModule;", "", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "client", "Lcom/avito/android/MessengerWorkFactory;", "workFactory", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgent;", "provideUnreadChatsCounterSyncAgent$messenger_release", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/MessengerWorkFactory;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgent;", "provideUnreadChatsCounterSyncAgent", "Landroid/content/Context;", "context", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;", "provideSyncJobScheduler$messenger_release", "(Landroid/content/Context;Lcom/avito/android/Features;)Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;", "provideSyncJobScheduler", "Lcom/avito/android/messenger/MessengerEntityConverter;", "converter", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "provideMessageBodyResolver$messenger_release", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "provideMessageBodyResolver", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class MessengerSyncModule {
    @NotNull
    public static final MessengerSyncModule INSTANCE = new MessengerSyncModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0013\u001a\u00020\u00122\u0011\u0010\u0003\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000fH'¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0016\u001a\u00020\u00152\u0011\u0010\u0003\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000fH'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/di/MessengerSyncModule$Declarations;", "", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgentImpl;", "impl", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "bindChannelSyncAgent", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgentImpl;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgentImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "bindMessageSyncAgent", "(Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgentImpl;)Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "bindMissingUsersSyncAgent", "(Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl;)Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lru/avito/messenger/MessengerEventObserver;", "bindMessengerEventObserver", "(Lru/avito/messenger/MessengerClient;)Lru/avito/messenger/MessengerEventObserver;", "Lru/avito/messenger/MessengerHistory;", "bindMessengerHistory", "(Lru/avito/messenger/MessengerClient;)Lru/avito/messenger/MessengerHistory;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        ChannelSyncAgent bindChannelSyncAgent(@NotNull ChannelSyncAgentImpl channelSyncAgentImpl);

        @Singleton
        @Binds
        @NotNull
        MessageSyncAgent bindMessageSyncAgent(@NotNull MessageSyncAgentImpl messageSyncAgentImpl);

        @Binds
        @NotNull
        MessengerEventObserver bindMessengerEventObserver(@NotNull MessengerClient<AvitoMessengerApi> messengerClient);

        @Binds
        @NotNull
        MessengerHistory bindMessengerHistory(@NotNull MessengerClient<AvitoMessengerApi> messengerClient);

        @Singleton
        @Binds
        @NotNull
        MissingUsersSyncAgent bindMissingUsersSyncAgent(@NotNull MissingUsersSyncAgentImpl missingUsersSyncAgentImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final MessageBodyResolver provideMessageBodyResolver$messenger_release(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new MessageBodyResolverImpl(messengerClient, messengerEntityConverter, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final SyncJobsScheduler provideSyncJobScheduler$messenger_release(@NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return new SyncJobSchedulerImpl(applicationContext, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final UnreadChatsCounterSyncAgent provideUnreadChatsCounterSyncAgent$messenger_release(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerWorkFactory messengerWorkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerWorkFactory, "workFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new UnreadChatsCounterSyncAgentImpl(messengerClient, accountStateProvider, messengerWorkFactory, schedulersFactory);
    }
}
