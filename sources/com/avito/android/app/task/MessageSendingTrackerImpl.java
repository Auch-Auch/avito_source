package com.avito.android.app.task;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.google.firebase.iid.MessengerIpcClient;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/app/task/MessageSendingTrackerImpl;", "Lcom/avito/android/app/task/MessageSendingTracker;", "", "trackSendingStarted", "()V", "", "attemptsMade", "", "isSuccessful", "trackSendingCompleted", "(IZ)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Ljava/util/concurrent/atomic/AtomicLong;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/atomic/AtomicLong;", "startTimestamp", "isDebug", "<init>", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/server_time/TimeSource;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSendingTrackerImpl implements MessageSendingTracker {
    public final AtomicLong a = new AtomicLong(Long.MIN_VALUE);
    public final LocalMessage b;
    public final Analytics c;
    public final TimeSource d;

    public MessageSendingTrackerImpl(@NotNull LocalMessage localMessage, @NotNull Analytics analytics, @NotNull TimeSource timeSource, boolean z) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.b = localMessage;
        this.c = analytics;
        this.d = timeSource;
    }

    @Override // com.avito.android.app.task.MessageSendingTracker
    public void trackSendingCompleted(int i, boolean z) {
        String str;
        long andSet = this.a.getAndSet(Long.MIN_VALUE);
        MessageBody messageBody = this.b.body;
        if ((messageBody instanceof MessageBody.Text) || (messageBody instanceof MessageBody.Link)) {
            str = "text";
        } else if (messageBody instanceof MessageBody.Item) {
            str = "item";
        } else if (messageBody instanceof MessageBody.Location) {
            str = "location";
        } else {
            str = messageBody instanceof MessageBody.LocalImage ? "img" : MessengerIpcClient.KEY_UNSUPPORTED;
        }
        if (andSet == Long.MIN_VALUE || !(!Intrinsics.areEqual(str, MessengerIpcClient.KEY_UNSUPPORTED))) {
            Logs.debug$default("MessageSendingTracker", "Tracking skipped", null, 4, null);
            return;
        }
        long now = this.d.now();
        long millis = now - MessengerTimestamp.toMillis(this.b.created);
        String L2 = a.L2(str, FormatterType.defaultDecimalSeparator, z ? "success" : "error");
        this.c.track(new StatsdEvent.TimeEvent(a.c3("messenger.resend.attmp-time.", L2), Long.valueOf(now - andSet)));
        this.c.track(new StatsdEvent.TimeEvent(a.c3("messenger.resend.send-time.", L2), Long.valueOf(millis)));
        this.c.track(new StatsdEvent.CountEvent(a.c3("messenger.resend.result-cnt.", L2), 0, 2, null));
        if (i > 0) {
            this.c.track(new StatsdEvent.CountEvent(a.c3("messenger.resend.attmp-cnt.", L2), (long) i));
        }
    }

    @Override // com.avito.android.app.task.MessageSendingTracker
    public void trackSendingStarted() {
        this.a.compareAndSet(Long.MIN_VALUE, this.d.now());
    }
}
