package com.avito.android;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.EmptyChatsCleaner;
import com.avito.android.app.task.EmptyChatsCleanerImpl;
import com.avito.android.app.task.MessageSyncTask;
import com.avito.android.app.task.MessengerBackgroundInitializationTask;
import com.avito.android.app.task.MessengerDbMaintenanceTask;
import com.avito.android.app.task.MessengerPhotosCleaner;
import com.avito.android.app.task.MessengerPhotosCleanerImpl;
import com.avito.android.app.task.UnreadChatsCounterSyncTask;
import com.avito.android.messenger.analytics.graphite_counter.ChatImageSendCounter;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.messenger.di.MessengerRepoModule;
import com.avito.android.messenger.service.UnreadChatsCounterSyncAgent;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002&'B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\bH\u0007¢\u0006\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/MessengerTasksModule;", "", "Lcom/avito/android/app/task/MessengerDbMaintenanceTask;", "maintenanceTask", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideMessengerBlockingStartupTasks", "(Lcom/avito/android/app/task/MessengerDbMaintenanceTask;)Ljava/util/List;", "Ldagger/Lazy;", "Lcom/avito/android/app/task/MessengerBackgroundInitializationTask;", "messengerBackgroundInitializationTask", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideMessengerBackgroundTasks", "(Ldagger/Lazy;)Ljava/util/List;", "Lcom/avito/android/app/task/UnreadChatsCounterSyncTask;", "unreadChatsCounterSyncTask", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "provideMessengerForegroundTasks", "(Lcom/avito/android/app/task/UnreadChatsCounterSyncTask;)Ljava/util/List;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "provideChatImageSendCounter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "messageSyncAgent", "Lcom/avito/android/app/task/MessageSyncTask;", "provideMessageSyncTask", "(Ldagger/Lazy;)Lcom/avito/android/app/task/MessageSyncTask;", "Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgent;", "unreadChatsCounterSyncAgent", "provideUnreadChatsCounterSyncAgent", "(Ldagger/Lazy;)Lcom/avito/android/app/task/UnreadChatsCounterSyncTask;", "<init>", "()V", "Declarations", "MessengerTasks", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class, PendingMessageHandlerModule.class, Declarations.class})
public final class MessengerTasksModule {
    @NotNull
    public static final MessengerTasksModule INSTANCE = new MessengerTasksModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/MessengerTasksModule$Declarations;", "", "Lcom/avito/android/app/task/EmptyChatsCleanerImpl;", "impl", "Lcom/avito/android/app/task/EmptyChatsCleaner;", "bindEmptyChatsCleaner", "(Lcom/avito/android/app/task/EmptyChatsCleanerImpl;)Lcom/avito/android/app/task/EmptyChatsCleaner;", "Lcom/avito/android/app/task/MessengerPhotosCleanerImpl;", "Lcom/avito/android/app/task/MessengerPhotosCleaner;", "bindMessengerPhotosCleaner", "(Lcom/avito/android/app/task/MessengerPhotosCleanerImpl;)Lcom/avito/android/app/task/MessengerPhotosCleaner;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        EmptyChatsCleaner bindEmptyChatsCleaner(@NotNull EmptyChatsCleanerImpl emptyChatsCleanerImpl);

        @Binds
        @NotNull
        MessengerPhotosCleaner bindMessengerPhotosCleaner(@NotNull MessengerPhotosCleanerImpl messengerPhotosCleanerImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/MessengerTasksModule$MessengerTasks;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface MessengerTasks {
    }

    @Provides
    @NotNull
    public final MessengerGraphiteCounter provideChatImageSendCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ChatImageSendCounter(analytics, features);
    }

    @Provides
    @NotNull
    public final MessageSyncTask provideMessageSyncTask(@NotNull Lazy<MessageSyncAgent> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "messageSyncAgent");
        return new MessageSyncTask(lazy);
    }

    @Provides
    @MessengerTasks
    @NotNull
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideMessengerBackgroundTasks(@NotNull Lazy<MessengerBackgroundInitializationTask> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "messengerBackgroundInitializationTask");
        return d.listOf(new TypedLazy(MessengerBackgroundInitializationTask.class, lazy));
    }

    @Provides
    @MessengerTasks
    @NotNull
    public final List<ApplicationBlockingStartupTask> provideMessengerBlockingStartupTasks(@NotNull MessengerDbMaintenanceTask messengerDbMaintenanceTask) {
        Intrinsics.checkNotNullParameter(messengerDbMaintenanceTask, "maintenanceTask");
        return d.listOf(messengerDbMaintenanceTask);
    }

    @Provides
    @MessengerTasks
    @NotNull
    public final List<ApplicationForegroundStartupTask> provideMessengerForegroundTasks(@NotNull UnreadChatsCounterSyncTask unreadChatsCounterSyncTask) {
        Intrinsics.checkNotNullParameter(unreadChatsCounterSyncTask, "unreadChatsCounterSyncTask");
        return d.listOf(unreadChatsCounterSyncTask);
    }

    @Provides
    @NotNull
    public final UnreadChatsCounterSyncTask provideUnreadChatsCounterSyncAgent(@NotNull Lazy<UnreadChatsCounterSyncAgent> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "unreadChatsCounterSyncAgent");
        return new UnreadChatsCounterSyncTask(lazy);
    }
}
