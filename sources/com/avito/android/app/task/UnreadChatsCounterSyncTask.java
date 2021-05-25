package com.avito.android.app.task;

import com.avito.android.messenger.service.UnreadChatsCounterSyncAgent;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/app/task/UnreadChatsCounterSyncTask;", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "", "execute", "()V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgent;", "counterSyncAgent", "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UnreadChatsCounterSyncTask implements ApplicationForegroundStartupTask {
    public final Lazy<UnreadChatsCounterSyncAgent> counterSyncAgent;

    public UnreadChatsCounterSyncTask(@NotNull Lazy<UnreadChatsCounterSyncAgent> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "counterSyncAgent");
        this.counterSyncAgent = lazy;
    }

    @Override // com.avito.android.app.task.ApplicationForegroundStartupTask
    public void execute() {
        this.counterSyncAgent.get().subscribeToCounterUpdates();
    }
}
