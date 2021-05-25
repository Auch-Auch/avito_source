package com.avito.android.messenger.connection;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u000b\u0010\u000b\u001a\u00028\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0002H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "T1", "T2", "T3", "R", "t1", "t2", "t3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/util/Observables$combineLatestWith$$inlined$combineLatestWith$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class AvitoMessengerKeepConnectionProvider$shouldKeepConnection$1$$special$$inlined$combineLatestWith$1<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {
    @Override // io.reactivex.functions.Function3
    @NotNull
    public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
        Intrinsics.checkNotNullParameter(t1, "t1");
        Intrinsics.checkNotNullParameter(t2, "t2");
        Intrinsics.checkNotNullParameter(t3, "t3");
        return (R) new Triple(t1, t2, t3);
    }
}
