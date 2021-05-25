package com.avito.android.navigation;

import android.app.Activity;
import com.avito.android.app.ActivityProvider;
import com.avito.android.app.task.ActivityListenerTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.bottom_navigation.NavigationProvider;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/navigation/NavigationTabProviderImpl;", "Lcom/avito/android/navigation/NavigationTabProvider;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "currentTab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "startupTasksRegistry", "Lcom/avito/android/app/ActivityProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "<init>", "(Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationTabProviderImpl implements NavigationTabProvider {
    public final ActivityProvider a;
    public final ApplicationStartupTasksRegistry b;

    @Inject
    public NavigationTabProviderImpl(@NotNull ActivityProvider activityProvider, @NotNull ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "startupTasksRegistry");
        this.a = activityProvider;
        this.b = applicationStartupTasksRegistry;
    }

    @Override // com.avito.android.navigation.NavigationTabProvider
    @Nullable
    public NavigationTab currentTab() {
        this.b.requireAtLeast(ActivityListenerTask.class, ApplicationStartupTask.State.Executed.class);
        Activity activity = this.a.get();
        if (activity instanceof NavigationProvider) {
            return ((NavigationProvider) activity).currentTab();
        }
        return null;
    }
}
