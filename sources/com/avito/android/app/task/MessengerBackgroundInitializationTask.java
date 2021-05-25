package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.util.LogsT;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/app/task/MessengerBackgroundInitializationTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/app/task/MessengerPhotosCleanupTask;", "messengerPhotosCleanupTask", "Lcom/avito/android/app/task/MessengerPhotosCleanupTask;", "Lcom/avito/android/app/task/ChannelSyncTask;", "channelSyncTask", "Lcom/avito/android/app/task/ChannelSyncTask;", "Lcom/avito/android/app/task/SendPendingMessagesTask;", "sendMessagesTask", "Lcom/avito/android/app/task/SendPendingMessagesTask;", "Lcom/avito/android/app/task/MessageSyncTask;", "messageSyncTask", "Lcom/avito/android/app/task/MessageSyncTask;", "Lcom/avito/android/app/task/MessengerEmptyChatsCleanupTask;", "messengerEmptyChatsCleanupTask", "Lcom/avito/android/app/task/MessengerEmptyChatsCleanupTask;", "<init>", "(Lcom/avito/android/app/task/MessengerEmptyChatsCleanupTask;Lcom/avito/android/app/task/MessengerPhotosCleanupTask;Lcom/avito/android/app/task/SendPendingMessagesTask;Lcom/avito/android/app/task/ChannelSyncTask;Lcom/avito/android/app/task/MessageSyncTask;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerBackgroundInitializationTask implements ApplicationBackgroundStartupTask {
    public final ChannelSyncTask channelSyncTask;
    public final MessageSyncTask messageSyncTask;
    public final MessengerEmptyChatsCleanupTask messengerEmptyChatsCleanupTask;
    public final MessengerPhotosCleanupTask messengerPhotosCleanupTask;
    public final SendPendingMessagesTask sendMessagesTask;

    @Inject
    public MessengerBackgroundInitializationTask(@NotNull MessengerEmptyChatsCleanupTask messengerEmptyChatsCleanupTask2, @NotNull MessengerPhotosCleanupTask messengerPhotosCleanupTask2, @NotNull SendPendingMessagesTask sendPendingMessagesTask, @NotNull ChannelSyncTask channelSyncTask2, @NotNull MessageSyncTask messageSyncTask2) {
        Intrinsics.checkNotNullParameter(messengerEmptyChatsCleanupTask2, "messengerEmptyChatsCleanupTask");
        Intrinsics.checkNotNullParameter(messengerPhotosCleanupTask2, "messengerPhotosCleanupTask");
        Intrinsics.checkNotNullParameter(sendPendingMessagesTask, "sendMessagesTask");
        Intrinsics.checkNotNullParameter(channelSyncTask2, "channelSyncTask");
        Intrinsics.checkNotNullParameter(messageSyncTask2, "messageSyncTask");
        this.messengerEmptyChatsCleanupTask = messengerEmptyChatsCleanupTask2;
        this.messengerPhotosCleanupTask = messengerPhotosCleanupTask2;
        this.sendMessagesTask = sendPendingMessagesTask;
        this.channelSyncTask = channelSyncTask2;
        this.messageSyncTask = messageSyncTask2;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    @ExperimentalUnsignedTypes
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        LogsT.verbose$default("MsgBgInitTask", "execute MessengerEmptyChatsCleanupTask", null, 4, null);
        this.messengerEmptyChatsCleanupTask.execute(application);
        LogsT.verbose$default("MsgBgInitTask", "execute MessengerPhotosCleanupTask", null, 4, null);
        this.messengerPhotosCleanupTask.execute(application);
        LogsT.verbose$default("MsgBgInitTask", "execute SendPendingMessagesTask", null, 4, null);
        this.sendMessagesTask.execute(application);
        LogsT.verbose$default("MsgBgInitTask", "execute ChannelSyncTask", null, 4, null);
        this.channelSyncTask.execute(application);
        LogsT.verbose$default("MsgBgInitTask", "execute MessageSyncTask", null, 4, null);
        this.messageSyncTask.execute(application);
    }
}
