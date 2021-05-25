package com.avito.android.util;

import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "Lcom/avito/android/util/LoadingState;", "dataOrNull", "(Lcom/avito/android/util/LoadingState;)Ljava/lang/Object;", "loading-state_release"}, k = 2, mv = {1, 4, 2})
public final class LoadingStateKt {
    @Nullable
    public static final <T> T dataOrNull(@NotNull LoadingState<? super T> loadingState) {
        Intrinsics.checkNotNullParameter(loadingState, "$this$dataOrNull");
        if (loadingState instanceof LoadingState.Loaded) {
            return (T) ((LoadingState.Loaded) loadingState).getData();
        }
        return null;
    }
}
