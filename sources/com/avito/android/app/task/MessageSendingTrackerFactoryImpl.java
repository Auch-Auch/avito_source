package com.avito.android.app.task;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/app/task/MessageSendingTrackerFactoryImpl;", "Lcom/avito/android/app/task/MessageSendingTrackerFactory;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lcom/avito/android/app/task/MessageSendingTracker;", "createTracker", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lcom/avito/android/app/task/MessageSendingTracker;", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "c", "Z", "isDebug", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/server_time/TimeSource;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSendingTrackerFactoryImpl implements MessageSendingTrackerFactory {
    public final Analytics a;
    public final TimeSource b;
    public final boolean c;

    public MessageSendingTrackerFactoryImpl(@NotNull Analytics analytics, @NotNull TimeSource timeSource, boolean z) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.a = analytics;
        this.b = timeSource;
        this.c = z;
    }

    @Override // com.avito.android.app.task.MessageSendingTrackerFactory
    @NotNull
    public MessageSendingTracker createTracker(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        return new MessageSendingTrackerImpl(localMessage, this.a, this.b, this.c);
    }
}
