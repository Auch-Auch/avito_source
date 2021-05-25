package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/app/task/MessageSyncTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "syncAgent", "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSyncTask implements ApplicationBackgroundStartupTask {
    public final Lazy<MessageSyncAgent> syncAgent;

    public MessageSyncTask(@NotNull Lazy<MessageSyncAgent> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "syncAgent");
        this.syncAgent = lazy;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.syncAgent.get().subscribeToBackendNotifications();
    }
}
