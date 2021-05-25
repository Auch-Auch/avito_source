package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "value", "not", "(Z)Z", "", "toInt", "(Ljava/lang/Boolean;)I", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class BooleansKt {
    public static final boolean not(boolean z) {
        return !z;
    }

    public static final int toInt(@Nullable Boolean bool) {
        return Intrinsics.areEqual(bool, Boolean.TRUE) ? 1 : 0;
    }
}
