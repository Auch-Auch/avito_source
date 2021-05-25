package com.avito.android.messenger.conversation.mvi.sync;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.DaggerMessageIsReadMarkerComponent;
import com.avito.android.messenger.di.MessageIsReadMarkerComponent;
import com.avito.android.messenger.di.MessageIsReadMarkerDependencies;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "marker", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "getMarker$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "setMarker$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageIsReadMarkerService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public MessageIsReadMarker marker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerService$Companion;", "", "Landroid/content/Context;", "context", "", ChannelContext.Item.USER_ID, "channelId", "", "timestamp", "", "enqueueWork", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V", "DEFAULT_TIMESTAMP", "J", "", "JOB_ID", "I", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_TIMESTAMP", "KEY_USER_ID", "TAG", "TIMEOUT_SECONDS", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void enqueueWork(@NotNull Context context, @NotNull String str, @NotNull String str2, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intent putExtra = new Intent().putExtra(ChannelContext.Item.USER_ID, str).putExtra("channelId", str2).putExtra("timestamp", j);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n               …KEY_TIMESTAMP, timestamp)");
            JobIntentService.enqueueWork(context, MessageIsReadMarkerService.class, 1003, putExtra);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final MessageIsReadMarker getMarker$messenger_release() {
        MessageIsReadMarker messageIsReadMarker = this.marker;
        if (messageIsReadMarker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marker");
        }
        return messageIsReadMarker;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageIsReadMarkerComponent.Builder builder = DaggerMessageIsReadMarkerComponent.builder();
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        builder.messageIsReadMarkerDependencies((MessageIsReadMarkerDependencies) ComponentDependenciesKt.getDependencies(MessageIsReadMarkerDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("MessageIsReadMarkerService", a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " start"), null, 4, null);
        String stringExtra = intent.getStringExtra(ChannelContext.Item.USER_ID);
        if (stringExtra != null) {
            String stringExtra2 = intent.getStringExtra("channelId");
            if (stringExtra2 != null) {
                long longExtra = intent.getLongExtra("timestamp", -1);
                if (longExtra == -1) {
                    Logs.error$default("MessageIsReadMarkerService", "No timestamp was passed!", null, 4, null);
                    return;
                }
                try {
                    MessageIsReadMarker messageIsReadMarker = this.marker;
                    if (messageIsReadMarker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("marker");
                    }
                    if (messageIsReadMarker.markMessagesAsRead(stringExtra, stringExtra2, longExtra).blockingAwait(15, TimeUnit.SECONDS)) {
                        Logs.debug$default("MessageIsReadMarkerService", "Task has finished", null, 4, null);
                    } else {
                        Logs.debug$default("MessageIsReadMarkerService", "Task didn't finish within time limit", null, 4, null);
                    }
                } catch (Exception e) {
                    Logs.debug("MessageIsReadMarkerService", "Task failed", e);
                }
            } else {
                Logs.error$default("MessageIsReadMarkerService", "No channelId was passed!", null, 4, null);
            }
        } else {
            Logs.error$default("MessageIsReadMarkerService", "No userId was passed!", null, 4, null);
        }
    }

    public final void setMarker$messenger_release(@NotNull MessageIsReadMarker messageIsReadMarker) {
        Intrinsics.checkNotNullParameter(messageIsReadMarker, "<set-?>");
        this.marker = messageIsReadMarker;
    }
}
