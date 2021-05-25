package com.avito.android.calls_shared;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/calls_shared/CallUuidProvider;", "", "", "Lcom/avito/android/calls_shared/CallId;", "nextCallUuid", "()Ljava/lang/String;", "getCurrentCallUuid", "currentCallUuid", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public interface CallUuidProvider {
    @NotNull
    String getCurrentCallUuid();

    @NotNull
    String nextCallUuid();
}
