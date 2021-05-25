package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/messenger/channels/mvi/common/v3/OverlapChecker$Companion$create$1", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "key", "otherKey", "", "checkOverlap", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class OverlapChecker$Companion$create$1 implements OverlapChecker<KeyT> {
    public final /* synthetic */ Function2 a;

    public OverlapChecker$Companion$create$1(Function2 function2) {
        this.a = function2;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker
    public boolean checkOverlap(@NotNull KeyT keyt, @NotNull KeyT keyt2) {
        Intrinsics.checkNotNullParameter(keyt, "key");
        Intrinsics.checkNotNullParameter(keyt2, "otherKey");
        return ((Boolean) this.a.invoke(keyt, keyt2)).booleanValue();
    }
}
