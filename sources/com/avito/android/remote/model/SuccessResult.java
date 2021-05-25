package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SuccessResult;", "", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuccessResult {
    @Nullable
    private final String message;

    @JvmOverloads
    public SuccessResult() {
        this(null, 1, null);
    }

    @JvmOverloads
    public SuccessResult(@Nullable String str) {
        this.message = str;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuccessResult(String str, int i, j jVar) {
        this((i & 1) != 0 ? null : str);
    }
}
