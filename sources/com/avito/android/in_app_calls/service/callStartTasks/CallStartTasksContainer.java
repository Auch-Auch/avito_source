package com.avito.android.in_app_calls.service.callStartTasks;

import a2.b.a.a.a;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTasksContainer;", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "task", "", "register", "(Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;)V", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "params", "run", "(Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;)V", "stop", "()V", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "tasks", "<init>", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallStartTasksContainer implements CallStartTask {
    public final List<CallStartTask> a = new ArrayList();

    public final void register(@NotNull CallStartTask callStartTask) {
        Intrinsics.checkNotNullParameter(callStartTask, "task");
        this.a.add(callStartTask);
    }

    @Override // com.avito.android.in_app_calls.service.callStartTasks.CallStartTask
    public void run(@NotNull CallStartTask.TaskParams taskParams) {
        Intrinsics.checkNotNullParameter(taskParams, "params");
        for (T t : this.a) {
            StringBuilder L = a.L("Start task: ");
            L.append(t.getClass().getSimpleName());
            Logs.debug$default("CallStartTasksContainer", L.toString(), null, 4, null);
            try {
                t.run(taskParams);
            } catch (Exception e) {
                StringBuilder L2 = a.L("Start task: ");
                L2.append(t.getClass().getSimpleName());
                L2.append(" failed");
                Logs.error("CallStartTasksContainer", L2.toString(), e);
            }
        }
    }

    @Override // com.avito.android.in_app_calls.service.callStartTasks.CallStartTask
    public void stop() {
        for (T t : this.a) {
            StringBuilder L = a.L("Stop task: ");
            L.append(t.getClass().getSimpleName());
            Logs.debug$default("CallStartTasksContainer", L.toString(), null, 4, null);
            try {
                t.stop();
            } catch (Exception e) {
                StringBuilder L2 = a.L("Stop task: ");
                L2.append(t.getClass().getSimpleName());
                L2.append(" failed");
                Logs.error("CallStartTasksContainer", L2.toString(), e);
            }
        }
    }
}
