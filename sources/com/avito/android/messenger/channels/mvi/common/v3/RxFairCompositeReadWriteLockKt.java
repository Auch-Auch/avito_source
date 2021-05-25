package com.avito.android.messenger.channels.mvi.common.v3;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001af\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\b¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\r\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\b¢\u0006\u0004\b\r\u0010\u0010*(\u0010\u0012\u001a\u0004\b\u0000\u0010\u0001\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u00112\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0011¨\u0006\u0013"}, d2 = {"", "KeyT", "ValueT", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "lock", "", "operationName", "", "", "keys", "Lio/reactivex/Scheduler;", "scheduler", "withLock", "(Lio/reactivex/Single;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;Ljava/lang/String;Ljava/util/Map;Lio/reactivex/Scheduler;)Lio/reactivex/Single;", "Lio/reactivex/Completable;", "(Lio/reactivex/Completable;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;Ljava/lang/String;Ljava/util/Map;Lio/reactivex/Scheduler;)Lio/reactivex/Completable;", "Lkotlin/Pair;", "KeyWithWriteAccessFlag", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class RxFairCompositeReadWriteLockKt {
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Single<T>, io.reactivex.Single<ValueT> */
    @NotNull
    public static final <KeyT, ValueT> Single<ValueT> withLock(@NotNull Single<ValueT> single, @NotNull RxFairCompositeReadWriteLock<KeyT> rxFairCompositeReadWriteLock, @NotNull String str, @NotNull Map<KeyT, Boolean> map, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(single, "$this$withLock");
        Intrinsics.checkNotNullParameter(rxFairCompositeReadWriteLock, "lock");
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(map, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        return (Single<T>) rxFairCompositeReadWriteLock.callSingle(single, str, map, scheduler);
    }

    @NotNull
    public static final <KeyT> Completable withLock(@NotNull Completable completable, @NotNull RxFairCompositeReadWriteLock<KeyT> rxFairCompositeReadWriteLock, @NotNull String str, @NotNull Map<KeyT, Boolean> map, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(completable, "$this$withLock");
        Intrinsics.checkNotNullParameter(rxFairCompositeReadWriteLock, "lock");
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(map, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Single<T> singleDefault = completable.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeReadWriteLock.callSingle(singleDefault, str, map, scheduler).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }
}
