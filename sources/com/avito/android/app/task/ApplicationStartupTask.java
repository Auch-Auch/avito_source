package com.avito.android.app.task;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask;", "", "ExecutionResult", "State", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicationStartupTask {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "", "<init>", "()V", "Error", "Failure", "Success", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Success;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Error;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Failure;", "core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ExecutionResult {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Error;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ExecutionResult {
            @Nullable
            public final String a;
            @Nullable
            public final Throwable b;

            public Error() {
                this(null, null, 3, null);
            }

            public Error(@Nullable String str, @Nullable Throwable th) {
                super(null);
                this.a = str;
                this.b = th;
            }

            @Nullable
            public final Throwable getError() {
                return this.b;
            }

            @Nullable
            public final String getMessage() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Error(String str, Throwable th, int i, j jVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Failure;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ExecutionResult {
            @NotNull
            public final Throwable a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(@NotNull Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(th, "error");
                this.a = th;
            }

            @NotNull
            public final Throwable getError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult$Success;", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends ExecutionResult {
            @NotNull
            public static final Success INSTANCE = new Success();

            public Success() {
                super(null);
            }
        }

        public ExecutionResult() {
        }

        public ExecutionResult(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\b\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$State;", "", "Ljava/lang/Class;", "state", "", "isAtLeast", "(Ljava/lang/Class;)Z", "T", "()Z", "<init>", "()V", "Executed", "Scheduled", "Unscheduled", "Lcom/avito/android/app/task/ApplicationStartupTask$State$Unscheduled;", "Lcom/avito/android/app/task/ApplicationStartupTask$State$Scheduled;", "Lcom/avito/android/app/task/ApplicationStartupTask$State$Executed;", "core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$State$Executed;", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "Ljava/lang/Class;", "state", "", "isAtLeast", "(Ljava/lang/Class;)Z", "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "getResult", "()Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "result", "<init>", "(Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Executed extends State {
            @NotNull
            public final ExecutionResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Executed(@NotNull ExecutionResult executionResult) {
                super(null);
                Intrinsics.checkNotNullParameter(executionResult, "result");
                this.a = executionResult;
            }

            @NotNull
            public final ExecutionResult getResult() {
                return this.a;
            }

            @Override // com.avito.android.app.task.ApplicationStartupTask.State
            public boolean isAtLeast(@NotNull Class<? extends State> cls) {
                Intrinsics.checkNotNullParameter(cls, "state");
                return true;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$State$Scheduled;", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "Ljava/lang/Class;", "state", "", "isAtLeast", "(Ljava/lang/Class;)Z", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Scheduled extends State {
            @NotNull
            public static final Scheduled INSTANCE = new Scheduled();

            public Scheduled() {
                super(null);
            }

            @Override // com.avito.android.app.task.ApplicationStartupTask.State
            public boolean isAtLeast(@NotNull Class<? extends State> cls) {
                Intrinsics.checkNotNullParameter(cls, "state");
                if (!Intrinsics.areEqual(cls, Unscheduled.class) && !Intrinsics.areEqual(cls, Scheduled.class)) {
                    return false;
                }
                return true;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/app/task/ApplicationStartupTask$State$Unscheduled;", "Lcom/avito/android/app/task/ApplicationStartupTask$State;", "Ljava/lang/Class;", "state", "", "isAtLeast", "(Ljava/lang/Class;)Z", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unscheduled extends State {
            @NotNull
            public static final Unscheduled INSTANCE = new Unscheduled();

            public Unscheduled() {
                super(null);
            }

            @Override // com.avito.android.app.task.ApplicationStartupTask.State
            public boolean isAtLeast(@NotNull Class<? extends State> cls) {
                Intrinsics.checkNotNullParameter(cls, "state");
                return Intrinsics.areEqual(cls, Unscheduled.class);
            }
        }

        public State() {
        }

        public final /* synthetic */ <T extends State> boolean isAtLeast() {
            Intrinsics.reifiedOperationMarker(4, "T");
            return isAtLeast(State.class);
        }

        public abstract boolean isAtLeast(@NotNull Class<? extends State> cls);

        public State(j jVar) {
        }
    }
}
