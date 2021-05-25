package com.avito.android.app.task;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/task/DarkThemeTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "Lcom/avito/android/lib/util/DarkThemeConfig;", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "Lcom/avito/android/lib/util/DarkThemeManager;", "<init>", "(Lcom/avito/android/lib/util/DarkThemeManager;Lcom/avito/android/lib/util/DarkThemeConfig;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DarkThemeTask implements ApplicationBlockingStartupTask {
    public final DarkThemeConfig darkThemeConfig;
    public final DarkThemeManager darkThemeManager;

    public DarkThemeTask(@NotNull DarkThemeManager darkThemeManager2, @NotNull DarkThemeConfig darkThemeConfig2) {
        Intrinsics.checkNotNullParameter(darkThemeManager2, "darkThemeManager");
        Intrinsics.checkNotNullParameter(darkThemeConfig2, "darkThemeConfig");
        this.darkThemeManager = darkThemeManager2;
        this.darkThemeConfig = darkThemeConfig2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (this.darkThemeConfig.isEnabled()) {
            this.darkThemeManager.applyMode();
        } else {
            AppCompatDelegate.setDefaultNightMode(1);
        }
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
