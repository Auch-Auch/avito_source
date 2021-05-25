package com.avito.android.remote.model.ab_tests;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;", "", "", "", "getAllKeys", "()Ljava/util/Set;", "key", "Lcom/avito/android/remote/model/ab_tests/AbTest;", "getAbTest", "(Ljava/lang/String;)Lcom/avito/android/remote/model/ab_tests/AbTest;", "", "rawValues", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "config_release"}, k = 1, mv = {1, 4, 2})
public final class AbTestsConfigResponse {
    private final Map<String, AbTest> rawValues;

    public AbTestsConfigResponse(@NotNull Map<String, AbTest> map) {
        Intrinsics.checkNotNullParameter(map, "rawValues");
        this.rawValues = map;
    }

    @Nullable
    public final AbTest getAbTest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.rawValues.get(str);
    }

    @NotNull
    public final Set<String> getAllKeys() {
        return this.rawValues.keySet();
    }
}
