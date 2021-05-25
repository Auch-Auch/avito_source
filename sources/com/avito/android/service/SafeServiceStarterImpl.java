package com.avito.android.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/service/SafeServiceStarterImpl;", "Lcom/avito/android/service/SafeServiceStarter;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", Tracker.Events.CREATIVE_START, "(Landroid/content/Context;Landroid/content/Intent;)V", "", "needForeground", "(Landroid/content/Intent;)Z", "Lcom/avito/android/util/BuildInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/util/BuildInfo;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SafeServiceStarterImpl implements SafeServiceStarter {
    public final BuildInfo a;

    @Inject
    public SafeServiceStarterImpl(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = buildInfo;
    }

    @Override // com.avito.android.service.SafeServiceStarter
    public boolean needForeground(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getBooleanExtra("service_need_foreground", false);
    }

    @Override // com.avito.android.service.SafeServiceStarter
    @SuppressLint({"NewApi"})
    public void start(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (this.a.getSdkVersion() >= 26) {
            intent.putExtra("service_need_foreground", true);
            context.startForegroundService(intent);
            return;
        }
        context.startService(intent);
    }
}
