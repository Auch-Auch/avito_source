package com.avito.android.messenger.conversation.mvi.sync;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.DaggerIncompleteMessageLoaderComponent;
import com.avito.android.messenger.di.IncompleteMessageLoaderComponent;
import com.avito.android.messenger.di.IncompleteMessageLoaderDependencies;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageLoadingService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "loader", "Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "getLoader$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "setLoader$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class IncompleteMessageLoadingService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public IncompleteMessageBodyLoader loader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageLoadingService$Companion;", "", "Landroid/content/Context;", "context", "", ChannelContext.Item.USER_ID, "channelId", "localId", "", "enqueueWork", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CHANNEL_ID_KEY", "Ljava/lang/String;", "", "JOB_ID", "I", "MESSAGE_LOCAL_ID", "TAG", "USER_ID_KEY", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void enqueueWork(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intent putExtra = new Intent(context, IncompleteMessageLoadingService.class).putExtra(ChannelContext.Item.USER_ID, str).putExtra("channelId", str2).putExtra("localId", str3);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, Incomple…ESSAGE_LOCAL_ID, localId)");
            JobIntentService.enqueueWork(context, IncompleteMessageLoadingService.class, 1001, putExtra);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final IncompleteMessageBodyLoader getLoader$messenger_release() {
        IncompleteMessageBodyLoader incompleteMessageBodyLoader = this.loader;
        if (incompleteMessageBodyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
        }
        return incompleteMessageBodyLoader;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        IncompleteMessageLoaderComponent.Builder builder = DaggerIncompleteMessageLoaderComponent.builder();
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        builder.incompleteMessageLoaderDependencies((IncompleteMessageLoaderDependencies) ComponentDependenciesKt.getDependencies(IncompleteMessageLoaderDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("IncompleteMessageLoadingService", a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " start"), null, 4, null);
        String stringExtra = intent.getStringExtra(ChannelContext.Item.USER_ID);
        if (stringExtra != null) {
            String stringExtra2 = intent.getStringExtra("channelId");
            if (stringExtra2 != null) {
                String stringExtra3 = intent.getStringExtra("localId");
                try {
                    IncompleteMessageBodyLoader incompleteMessageBodyLoader = this.loader;
                    if (incompleteMessageBodyLoader == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loader");
                    }
                    incompleteMessageBodyLoader.loadIncompleteMessageBodies(stringExtra, stringExtra2, stringExtra3).blockingAwait(60, TimeUnit.SECONDS);
                } catch (Exception e) {
                    Logs.debug("IncompleteMessageLoadingService", "Failed to load incomplete message bodies", e);
                }
            } else {
                Logs.error$default("IncompleteMessageLoadingService", "Parameter channelId was not passed!", null, 4, null);
            }
        } else {
            Logs.error$default("IncompleteMessageLoadingService", "Parameter userId was not passed!", null, 4, null);
        }
    }

    public final void setLoader$messenger_release(@NotNull IncompleteMessageBodyLoader incompleteMessageBodyLoader) {
        Intrinsics.checkNotNullParameter(incompleteMessageBodyLoader, "<set-?>");
        this.loader = incompleteMessageBodyLoader;
    }
}
