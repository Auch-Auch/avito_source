package com.avito.android.in_app_calls.task;

import io.reactivex.rxjava3.functions.BiFunction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\n\u0010\n\u001a\n \u0004*\u0004\u0018\u00018\u00028\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00018\u00018\u0001H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "T1", "T2", "R", "kotlin.jvm.PlatformType", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/util/rx3/Observables$combineLatestWith$$inlined$combineLatestWith$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class InitCallClientTask$execute$3$$special$$inlined$combineLatestWith$1<T1, T2, R> implements BiFunction<T1, T2, R> {
    @Override // io.reactivex.rxjava3.functions.BiFunction
    public final R apply(T1 t1, T2 t2) {
        Intrinsics.checkNotNullExpressionValue(t1, "t1");
        Intrinsics.checkNotNullExpressionValue(t2, "t2");
        return (R) TuplesKt.to(t1, t2);
    }
}
