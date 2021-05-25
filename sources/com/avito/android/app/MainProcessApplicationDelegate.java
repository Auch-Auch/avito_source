package com.avito.android.app;

import android.app.Application;
import com.avito.android.account.AccountStorageMigrationManager;
import com.avito.android.app.task.ApplicationStartupTasksExecutor;
import com.avito.android.app.task.SendStartupTimeTask;
import com.avito.android.enabler.RemoteFeaturesStartupMonitor;
import com.avito.android.preferences.migration.PreferencesMigrationManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/app/MainProcessApplicationDelegate;", "Lcom/avito/android/app/ApplicationDelegate;", "", "initialize", "()V", "", "startUpTimeMs", "onStartUpFinished", "(J)V", "Lcom/avito/android/preferences/migration/PreferencesMigrationManager;", "d", "Lcom/avito/android/preferences/migration/PreferencesMigrationManager;", "migrationManager", "Lcom/avito/android/account/AccountStorageMigrationManager;", "c", "Lcom/avito/android/account/AccountStorageMigrationManager;", "accountStorageMigrationManager", "Lcom/avito/android/app/task/SendStartupTimeTask;", "e", "Lcom/avito/android/app/task/SendStartupTimeTask;", "sendTimeTask", "Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", "startupTasksExecutor", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;", "f", "Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;", "remoteFeaturesStartupMonitor", "<init>", "(Landroid/app/Application;Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;Lcom/avito/android/account/AccountStorageMigrationManager;Lcom/avito/android/preferences/migration/PreferencesMigrationManager;Lcom/avito/android/app/task/SendStartupTimeTask;Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class MainProcessApplicationDelegate implements ApplicationDelegate {
    public final Application a;
    public final ApplicationStartupTasksExecutor b;
    public final AccountStorageMigrationManager c;
    public final PreferencesMigrationManager d;
    public final SendStartupTimeTask e;
    public final RemoteFeaturesStartupMonitor f;

    public MainProcessApplicationDelegate(@NotNull Application application, @NotNull ApplicationStartupTasksExecutor applicationStartupTasksExecutor, @NotNull AccountStorageMigrationManager accountStorageMigrationManager, @NotNull PreferencesMigrationManager preferencesMigrationManager, @NotNull SendStartupTimeTask sendStartupTimeTask, @NotNull RemoteFeaturesStartupMonitor remoteFeaturesStartupMonitor) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(applicationStartupTasksExecutor, "startupTasksExecutor");
        Intrinsics.checkNotNullParameter(accountStorageMigrationManager, "accountStorageMigrationManager");
        Intrinsics.checkNotNullParameter(preferencesMigrationManager, "migrationManager");
        Intrinsics.checkNotNullParameter(sendStartupTimeTask, "sendTimeTask");
        Intrinsics.checkNotNullParameter(remoteFeaturesStartupMonitor, "remoteFeaturesStartupMonitor");
        this.a = application;
        this.b = applicationStartupTasksExecutor;
        this.c = accountStorageMigrationManager;
        this.d = preferencesMigrationManager;
        this.e = sendStartupTimeTask;
        this.f = remoteFeaturesStartupMonitor;
    }

    @Override // com.avito.android.app.ApplicationDelegate
    public void initialize() {
        Logs.debug$default("MainAppDelegate", "initialize", null, 4, null);
        try {
            Intrinsics.checkNotNullExpressionValue(Class.forName("android.os.AsyncTask"), "Class.forName(\"android.os.AsyncTask\")");
        } catch (ClassNotFoundException unused) {
        }
        this.d.migrate();
        this.c.migrate();
        this.b.execute(this.a);
    }

    @Override // com.avito.android.app.ApplicationDelegate
    public void onStartUpFinished(long j) {
        this.e.sendTime(j);
        this.f.checkMonitorToggle();
    }
}
