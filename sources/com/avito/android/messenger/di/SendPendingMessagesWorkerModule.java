package com.avito.android.messenger.di;

import com.avito.android.PendingMessageHandlerModule;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/di/SendPendingMessagesWorkerModule;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class, PendingMessageHandlerModule.class})
public final class SendPendingMessagesWorkerModule {
    @NotNull
    public static final SendPendingMessagesWorkerModule INSTANCE = new SendPendingMessagesWorkerModule();
}
