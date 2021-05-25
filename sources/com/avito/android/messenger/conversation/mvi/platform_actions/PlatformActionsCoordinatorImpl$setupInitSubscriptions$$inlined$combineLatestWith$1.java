package com.avito.android.messenger.conversation.mvi.platform_actions;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\t\u0010\t\u001a\u00028\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T1", "T2", "R", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/util/Observables$combineLatestWith$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class PlatformActionsCoordinatorImpl$setupInitSubscriptions$$inlined$combineLatestWith$1<T1, T2, R> implements BiFunction<T1, T2, R> {
    /* JADX WARN: Type inference failed for: r2v1, types: [com.avito.android.messenger.channels.mvi.common.Loading$Success, R] */
    @Override // io.reactivex.functions.BiFunction
    @NotNull
    public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
        Intrinsics.checkNotNullParameter(t1, "t1");
        Intrinsics.checkNotNullParameter(t2, "t2");
        return t1;
    }
}
