package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.ChannelSyncOnPushServiceComponent;
import com.avito.android.messenger.di.ChannelSyncOnPushServiceDependencies;
import com.avito.android.messenger.di.DaggerChannelSyncOnPushServiceComponent;
import com.avito.android.util.Logs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "agent", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "getAgent$messenger_release", "()Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "setAgent$messenger_release", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelSyncOnPushService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ChannelSyncOnPushAgent agent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushService$Companion;", "", "Landroid/content/Context;", "context", "", "channelId", "", "enqueueWork", "(Landroid/content/Context;Ljava/lang/String;)V", "", "JOB_ID", "I", "KEY_CHANNEL_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void enqueueWork(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intent putExtra = new Intent().putExtra("channelId", str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n               …EY_CHANNEL_ID, channelId)");
            JobIntentService.enqueueWork(context, ChannelSyncOnPushService.class, 1006, putExtra);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final ChannelSyncOnPushAgent getAgent$messenger_release() {
        ChannelSyncOnPushAgent channelSyncOnPushAgent = this.agent;
        if (channelSyncOnPushAgent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agent");
        }
        return channelSyncOnPushAgent;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ChannelSyncOnPushServiceComponent.Builder builder = DaggerChannelSyncOnPushServiceComponent.builder();
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        builder.dependencies((ChannelSyncOnPushServiceDependencies) ComponentDependenciesKt.getDependencies(ChannelSyncOnPushServiceDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("ChannelSyncOnPushService", a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " start"), null, 4, null);
        String stringExtra = intent.getStringExtra("channelId");
        if (stringExtra != null) {
            ChannelSyncOnPushAgent channelSyncOnPushAgent = this.agent;
            if (channelSyncOnPushAgent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agent");
            }
            channelSyncOnPushAgent.sync(stringExtra);
            return;
        }
        Logs.error$default("ChannelSyncOnPushService", "No channelId was passed!", null, 4, null);
    }

    public final void setAgent$messenger_release(@NotNull ChannelSyncOnPushAgent channelSyncOnPushAgent) {
        Intrinsics.checkNotNullParameter(channelSyncOnPushAgent, "<set-?>");
        this.agent = channelSyncOnPushAgent;
    }
}
