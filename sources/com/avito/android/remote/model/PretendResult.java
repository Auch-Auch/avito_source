package com.avito.android.remote.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u000e\u0010\u000fR%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/PretendResult;", "", "", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "errors", "Ljava/util/Map;", "getErrors", "()Ljava/util/Map;", "", "success", "Z", "getSuccess", "()Z", "<init>", "(ZLjava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PretendResult {
    @NotNull
    private final Map<String, PretendErrorValue> errors;
    private final boolean success;

    public PretendResult() {
        this(false, null, 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends com.avito.android.remote.model.PretendErrorValue> */
    /* JADX WARN: Multi-variable type inference failed */
    public PretendResult(boolean z, @NotNull Map<String, ? extends PretendErrorValue> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        this.success = z;
        this.errors = map;
    }

    @NotNull
    public final Map<String, PretendErrorValue> getErrors() {
        return this.errors;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PretendResult(boolean z, Map map, int i, j jVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? r.emptyMap() : map);
    }
}
