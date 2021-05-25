package com.avito.android.messenger.service;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.messenger.di.DaggerOpenErrorTrackerComponent;
import com.avito.android.messenger.di.OpenErrorTrackerComponent;
import com.avito.android.messenger.di.OpenErrorTrackerDependencies;
import com.avito.android.util.Logs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/service/OpenErrorTrackerService;", "Landroidx/core/app/JobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lcom/avito/android/messenger/service/OpenErrorTracker;", "openErrorTracker", "Lcom/avito/android/messenger/service/OpenErrorTracker;", "getOpenErrorTracker", "()Lcom/avito/android/messenger/service/OpenErrorTracker;", "setOpenErrorTracker", "(Lcom/avito/android/messenger/service/OpenErrorTracker;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenErrorTrackerService extends JobIntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public OpenErrorTracker openErrorTracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/service/OpenErrorTrackerService$Companion;", "", "Landroid/content/Context;", "context", "", "channelId", "case", "", "enqueueTrackChatOpenError", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "enqueueTrackChatListOpenError", "(Landroid/content/Context;)V", "", "JOB_ID", "I", "KEY_CASE", "Ljava/lang/String;", "KEY_CHANNEL_ID", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final void enqueueTrackChatListOpenError(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            JobIntentService.enqueueWork(context, OpenErrorTrackerService.class, 1005, new Intent());
        }

        public final void enqueueTrackChatOpenError(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "case");
            Intent putExtra = new Intent().putExtra("channel_id", str).putExtra("case", str2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n               ….putExtra(KEY_CASE, case)");
            JobIntentService.enqueueWork(context, OpenErrorTrackerService.class, 1005, putExtra);
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final OpenErrorTracker getOpenErrorTracker() {
        OpenErrorTracker openErrorTracker2 = this.openErrorTracker;
        if (openErrorTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openErrorTracker");
        }
        return openErrorTracker2;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        OpenErrorTrackerComponent.Builder builder = DaggerOpenErrorTrackerComponent.builder();
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        builder.dependencies((OpenErrorTrackerDependencies) ComponentDependenciesKt.getDependencies(OpenErrorTrackerDependencies.class, (HasComponentDependencies) applicationContext)).build().inject(this);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("OpenErrorTrackerService", a.g("Thread.currentThread()", a.I('['), ']', new StringBuilder(), " start"), null, 4, null);
        String stringExtra = intent.getStringExtra("channel_id");
        String stringExtra2 = intent.getStringExtra("case");
        if (stringExtra != null && stringExtra2 != null) {
            try {
                OpenErrorTracker openErrorTracker2 = this.openErrorTracker;
                if (openErrorTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openErrorTracker");
                }
                openErrorTracker2.trackChatOpenError(stringExtra, stringExtra2).blockingAwait();
            } catch (Throwable th) {
                Logs.error("OpenErrorTrackerService", a.d("Error while tracking ChatOpenError: channelId=", stringExtra, ", case=", stringExtra2), th);
            }
        } else if (stringExtra == null && stringExtra2 == null) {
            try {
                OpenErrorTracker openErrorTracker3 = this.openErrorTracker;
                if (openErrorTracker3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openErrorTracker");
                }
                openErrorTracker3.trackChatListOpenError().blockingAwait();
            } catch (Throwable th2) {
                Logs.error("OpenErrorTrackerService", "Error while tracking ChatListOpenError", th2);
            }
        } else {
            Logs.error$default("OpenErrorTrackerService", a.d("OpenErrorTrackerService needs both channelId & case to track ChatOpenError: channelId=", stringExtra, ", case=", stringExtra2), null, 4, null);
        }
    }

    public final void setOpenErrorTracker(@NotNull OpenErrorTracker openErrorTracker2) {
        Intrinsics.checkNotNullParameter(openErrorTracker2, "<set-?>");
        this.openErrorTracker = openErrorTracker2;
    }
}
