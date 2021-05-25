package com.avito.android.ab_tests.models;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/ab_tests/models/RemoteAbTest;", "T", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public interface RemoteAbTest<T> extends AbTestGroup<T> {
    @NotNull
    String getRemoteKey();
}
