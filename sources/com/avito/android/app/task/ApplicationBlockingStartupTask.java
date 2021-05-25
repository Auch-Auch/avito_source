package com.avito.android.app.task;

import android.app.Application;
import androidx.annotation.MainThread;
import com.avito.android.app.task.ApplicationStartupTask;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Lcom/avito/android/app/task/ApplicationStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "getPriority", "()Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Priority", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicationBlockingStartupTask extends ApplicationStartupTask {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Priority getPriority(@NotNull ApplicationBlockingStartupTask applicationBlockingStartupTask) {
            return Priority.REGULAR;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "CRITICAL", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum Priority {
        REGULAR,
        CRITICAL
    }

    @MainThread
    @NotNull
    ApplicationStartupTask.ExecutionResult execute(@NotNull Application application);

    @NotNull
    Priority getPriority();
}
