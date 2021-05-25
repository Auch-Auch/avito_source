package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.in_app_calls.logging.DeleteCallLogsTask;
import com.avito.android.in_app_calls.task.InitCallClientTask;
import com.avito.android.in_app_calls.task.InitCallsTask;
import com.avito.android.in_app_calls.task.MicAccessTrackingTask;
import com.avito.android.in_app_calls.task.SetupCallNotificationChannelTask;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J]\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/in_app_calls/di/InAppCallsTasksModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/in_app_calls/task/MicAccessTrackingTask;", "micAccessTrackingTask", "Lcom/avito/android/in_app_calls/task/InitCallClientTask;", "initCallClientTask", "Lcom/avito/android/in_app_calls/task/SetupCallNotificationChannelTask;", "setupCallNotificationChannelTask", "Lcom/avito/android/in_app_calls/logging/DeleteCallLogsTask;", "deleteCallLogsTask", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "providerInAppCallsTasks", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/in_app_calls/task/InitCallsTask;", "initCallsTask", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "providerInAppCallsBlockingTasks", "(Lcom/avito/android/in_app_calls/task/InitCallsTask;Lcom/avito/android/Features;)Ljava/util/Set;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module
public class InAppCallsTasksModule {
    @Provides
    @ElementsIntoSet
    @NotNull
    public Set<ApplicationBlockingStartupTask> providerInAppCallsBlockingTasks(@NotNull InitCallsTask initCallsTask, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(initCallsTask, "initCallsTask");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getMessengerInAppCalls().invoke().booleanValue()) {
            return x.setOf(initCallsTask);
        }
        return y.emptySet();
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    public Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> providerInAppCallsTasks(@NotNull Lazy<MicAccessTrackingTask> lazy, @NotNull Lazy<InitCallClientTask> lazy2, @NotNull Lazy<SetupCallNotificationChannelTask> lazy3, @NotNull Lazy<DeleteCallLogsTask> lazy4, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(lazy, "micAccessTrackingTask");
        Intrinsics.checkNotNullParameter(lazy2, "initCallClientTask");
        Intrinsics.checkNotNullParameter(lazy3, "setupCallNotificationChannelTask");
        Intrinsics.checkNotNullParameter(lazy4, "deleteCallLogsTask");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getMessengerInAppCalls().invoke().booleanValue()) {
            return y.setOf((Object[]) new TypedLazy[]{new TypedLazy(SetupCallNotificationChannelTask.class, lazy3), new TypedLazy(InitCallClientTask.class, lazy2), new TypedLazy(MicAccessTrackingTask.class, lazy), new TypedLazy(DeleteCallLogsTask.class, lazy4)});
        }
        return y.emptySet();
    }
}
