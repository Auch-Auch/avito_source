package com.avito.android.in_app_calls.service.callStartTasks;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "params", "", "run", "(Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;)V", "stop", "()V", "TaskParams", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallStartTask {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "callId", "copy", "(Ljava/lang/String;)Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallId", "<init>", "(Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class TaskParams {
        @NotNull
        public final String a;

        public TaskParams(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "callId");
            this.a = str;
        }

        public static /* synthetic */ TaskParams copy$default(TaskParams taskParams, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskParams.a;
            }
            return taskParams.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final TaskParams copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "callId");
            return new TaskParams(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof TaskParams) && Intrinsics.areEqual(this.a, ((TaskParams) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getCallId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("TaskParams(callId="), this.a, ")");
        }
    }

    void run(@NotNull TaskParams taskParams);

    void stop();
}
