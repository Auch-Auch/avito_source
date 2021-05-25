package com.avito.android.messenger.service;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/service/OpenErrorTrackerSchedulerImpl;", "Lcom/avito/android/messenger/service/OpenErrorTrackerScheduler;", "", "channelId", "case", "", "scheduleTrackChatOpenError", "(Ljava/lang/String;Ljava/lang/String;)V", "scheduleTrackChatListOpenError", "()V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenErrorTrackerSchedulerImpl implements OpenErrorTrackerScheduler {
    public final Context a;

    @Inject
    public OpenErrorTrackerSchedulerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.messenger.service.OpenErrorTrackerScheduler
    public void scheduleTrackChatListOpenError() {
        OpenErrorTrackerService.Companion.enqueueTrackChatListOpenError(this.a);
        Logs.verbose$default("OpenErrorTrackerScheduler", "Enqueued OpenErrorTrackerService::trackChatListOpenError()", null, 4, null);
    }

    @Override // com.avito.android.messenger.service.OpenErrorTrackerScheduler
    public void scheduleTrackChatOpenError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "case");
        OpenErrorTrackerService.Companion.enqueueTrackChatOpenError(this.a, str, str2);
        Logs.verbose$default("OpenErrorTrackerScheduler", "Enqueued OpenErrorTrackerService::trackChatOpenError(channelId=" + str + ", case=" + str2 + ')', null, 4, null);
    }
}
