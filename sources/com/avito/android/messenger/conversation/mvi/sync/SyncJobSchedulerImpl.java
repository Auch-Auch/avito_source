package com.avito.android.messenger.conversation.mvi.sync;

import a2.b.a.a.a;
import android.content.Context;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobSchedulerImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;", "", ChannelContext.Item.USER_ID, "channelId", "localId", "", "scheduleIncompleteMessageBodyLoading", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "timestamp", "scheduleMarkChannelAsRead", "(Ljava/lang/String;Ljava/lang/String;J)V", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SyncJobSchedulerImpl implements SyncJobsScheduler {
    public final Context a;
    public final Features b;

    public SyncJobSchedulerImpl(@NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = context;
        this.b = features;
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.SyncJobsScheduler
    public void scheduleIncompleteMessageBodyLoading(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        if (this.b.getMessengerWorkManager().invoke().booleanValue()) {
            Pair<String, UUID> enqueue = IncompleteMessageLoadingWorker.Companion.enqueue(this.a, str, str2, str3);
            Logs.verbose$default("SyncJobScheduler", "Enqueued IncompleteMessageLoadingWorker(" + enqueue + ')', null, 4, null);
            return;
        }
        IncompleteMessageLoadingService.Companion.enqueueWork(this.a, str, str2, str3);
        StringBuilder sb = new StringBuilder();
        a.n1(sb, "Enqueued IncompleteMessageLoadingService: userId = \"", str, "\", channelId = \"", str2);
        sb.append(Typography.quote);
        Logs.verbose$default("SyncJobScheduler", sb.toString(), null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.SyncJobsScheduler
    public void scheduleMarkChannelAsRead(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        if (this.b.getMessengerWorkManager().invoke().booleanValue()) {
            Pair<String, UUID> enqueue = MessageIsReadMarkerWorker.Companion.enqueue(this.a, str, str2, j);
            Logs.verbose$default("SyncJobScheduler", "Enqueued MessageIsReadMarkerWorker(" + enqueue + ')', null, 4, null);
            return;
        }
        MessageIsReadMarkerService.Companion.enqueueWork(this.a, str, str2, j);
        Logs.verbose$default("SyncJobScheduler", a.f("Enqueued MessageIsReadMarkerService: userId = \"", str, "\", channelId = \"", str2, "\", timestamp = \"timestamp\""), null, 4, null);
    }
}
