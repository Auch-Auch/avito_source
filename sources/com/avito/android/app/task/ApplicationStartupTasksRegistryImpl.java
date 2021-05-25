package com.avito.android.app.task;

import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\u00020\u00152\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR*\u0010\u001e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTasksRegistryImpl;", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "Ljava/lang/Class;", "Lcom/avito/android/app/task/ApplicationStartupTask;", "taskType", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "taskState", "(Ljava/lang/Class;)Lcom/avito/android/app/task/ApplicationStartupTask$State;", "state", "", "requireAtLeast", "(Ljava/lang/Class;Ljava/lang/Class;)V", "onSchedule", "(Ljava/lang/Class;)V", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "result", "onExecuted", "(Ljava/lang/Class;Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;)V", "expectedState", AuthSource.SEND_ABUSE, "(Ljava/lang/Class;Lcom/avito/android/app/task/ApplicationStartupTask$State;)V", "", "reason", AuthSource.BOOKING_ORDER, "(Ljava/lang/Class;Lcom/avito/android/app/task/ApplicationStartupTask$State;Ljava/lang/String;)Ljava/lang/String;", "", "Z", "failOnMismatch", "", "Ljava/util/Map;", "states", "<init>", "(Z)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ApplicationStartupTasksRegistryImpl implements MutableApplicationStartupTasksRegistry {
    public final Map<Class<? extends ApplicationStartupTask>, ApplicationStartupTask.State> a = new LinkedHashMap();
    public final boolean b;

    public static final class a extends Lambda implements Function1<Map.Entry<Class<? extends ApplicationStartupTask>, ApplicationStartupTask.State>, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(Map.Entry<Class<? extends ApplicationStartupTask>, ApplicationStartupTask.State> entry) {
            Map.Entry<Class<? extends ApplicationStartupTask>, ApplicationStartupTask.State> entry2 = entry;
            Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
            return entry2.getKey().getName() + "=" + entry2.getValue().getClass().getSimpleName();
        }
    }

    public ApplicationStartupTasksRegistryImpl(boolean z) {
        this.b = z;
    }

    public final void a(Class<? extends ApplicationStartupTask> cls, ApplicationStartupTask.State state) {
        ApplicationStartupTask.State taskState = taskState(cls);
        if (!Intrinsics.areEqual(taskState, state)) {
            throw new IllegalArgumentException(b(cls, taskState, "expected exactly " + state + FormatterType.defaultDecimalSeparator).toString());
        }
    }

    public final String b(Class<? extends ApplicationStartupTask> cls, ApplicationStartupTask.State state, String str) {
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.a.entrySet(), null, null, null, 0, null, a.a, 31, null);
        StringBuilder L = a2.b.a.a.a.L("\n            |Unexpected state of task ");
        L.append(cls.getCanonicalName());
        L.append(": ");
        L.append(state.getClass().getSimpleName());
        L.append(".\n            |Reason: ");
        return f.trimMargin$default(a2.b.a.a.a.v(L, str, ".\n            |Check that you registered the task in DI.\n            |All tasks: ", joinToString$default, "\n            |"), null, 1, null);
    }

    @Override // com.avito.android.app.task.MutableApplicationStartupTasksRegistry
    public synchronized void onExecuted(@NotNull Class<? extends ApplicationStartupTask> cls, @NotNull ApplicationStartupTask.ExecutionResult executionResult) {
        Intrinsics.checkNotNullParameter(cls, "taskType");
        Intrinsics.checkNotNullParameter(executionResult, "result");
        a(cls, ApplicationStartupTask.State.Scheduled.INSTANCE);
        this.a.put(cls, new ApplicationStartupTask.State.Executed(executionResult));
    }

    @Override // com.avito.android.app.task.MutableApplicationStartupTasksRegistry
    public synchronized void onSchedule(@NotNull Class<? extends ApplicationStartupTask> cls) {
        Intrinsics.checkNotNullParameter(cls, "taskType");
        a(cls, ApplicationStartupTask.State.Unscheduled.INSTANCE);
        this.a.put(cls, ApplicationStartupTask.State.Scheduled.INSTANCE);
    }

    @Override // com.avito.android.app.task.ApplicationStartupTasksRegistry
    public synchronized void requireAtLeast(@NotNull Class<? extends ApplicationStartupTask> cls, @NotNull Class<? extends ApplicationStartupTask.State> cls2) {
        Intrinsics.checkNotNullParameter(cls, "taskType");
        Intrinsics.checkNotNullParameter(cls2, "state");
        ApplicationStartupTask.State taskState = taskState(cls);
        if (!taskState.isAtLeast(cls2)) {
            IllegalStateException illegalStateException = new IllegalStateException(b(cls, taskState, "expected at least " + cls2.getSimpleName()));
            if (!this.b) {
                Logs.error("AppStartupTaskRegistry", illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
    }

    @Override // com.avito.android.app.task.ApplicationStartupTasksRegistry
    @NotNull
    public synchronized ApplicationStartupTask.State taskState(@NotNull Class<? extends ApplicationStartupTask> cls) {
        ApplicationStartupTask.State state;
        Intrinsics.checkNotNullParameter(cls, "taskType");
        state = this.a.get(cls);
        if (state == null) {
            state = ApplicationStartupTask.State.Unscheduled.INSTANCE;
        }
        return state;
    }
}
