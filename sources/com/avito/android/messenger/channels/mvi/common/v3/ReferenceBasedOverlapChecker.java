package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/ReferenceBasedOverlapChecker;", "", "KeyT", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "key", "otherKey", "", "checkOverlap", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class ReferenceBasedOverlapChecker<KeyT> implements OverlapChecker<KeyT> {
    @Override // com.avito.android.messenger.channels.mvi.common.v3.OverlapChecker
    public boolean checkOverlap(@NotNull KeyT keyt, @NotNull KeyT keyt2) {
        Intrinsics.checkNotNullParameter(keyt, "key");
        Intrinsics.checkNotNullParameter(keyt2, "otherKey");
        return keyt == keyt2;
    }
}
