package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/PretendResultError;", "Lcom/avito/android/remote/model/Error;", "Lcom/avito/android/remote/model/PretendResult;", "pretendResult", "Lcom/avito/android/remote/model/PretendResult;", "getPretendResult", "()Lcom/avito/android/remote/model/PretendResult;", "", "code", "", "message", "<init>", "(ILjava/lang/String;Lcom/avito/android/remote/model/PretendResult;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PretendResultError extends Error {
    @SerializedName("messages")
    @Nullable
    private final PretendResult pretendResult;

    public PretendResultError(int i, @Nullable String str, @Nullable PretendResult pretendResult2) {
        super(i, str);
        this.pretendResult = pretendResult2;
    }

    @Nullable
    public final PretendResult getPretendResult() {
        return this.pretendResult;
    }
}
