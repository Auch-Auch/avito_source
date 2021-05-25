package com.avito.android.remote.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/remote/model/RawJson;", "orEmpty", "(Lcom/avito/android/remote/model/RawJson;)Lcom/avito/android/remote/model/RawJson;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class RawJsonKt {
    @NotNull
    public static final RawJson orEmpty(@Nullable RawJson rawJson) {
        return rawJson != null ? rawJson : RawJson.Companion.getEMPTY();
    }
}
