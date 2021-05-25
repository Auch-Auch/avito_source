package com.avito.android.enabler.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/enabler/model/BooleanToggle;", "", "", "value", "Z", "getValue", "()Z", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Z)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class BooleanToggle {
    @NotNull
    private final String key;
    private final boolean value;

    public BooleanToggle(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.value = z;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final boolean getValue() {
        return this.value;
    }
}
