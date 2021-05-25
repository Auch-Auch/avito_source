package com.avito.android.job.progress_bar;

import com.avito.android.job.common.Action;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/job/progress_bar/ProgressBarResponse;", "", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lcom/avito/android/job/common/Action;", "action", "Lcom/avito/android/job/common/Action;", "getAction", "()Lcom/avito/android/job/common/Action;", "<init>", "(Ljava/lang/String;Lcom/avito/android/job/common/Action;)V", "job_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressBarResponse {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("message")
    @NotNull
    private final String message;

    public ProgressBarResponse(@NotNull String str, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.message = str;
        this.action = action2;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
