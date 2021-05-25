package com.avito.android.messenger.channels.mvi.common.v3;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a`\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0004\b\f\u0010\r\u001aJ\u0010\f\u001a\u00020\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0004\b\f\u0010\u000f¨\u0006\u0010"}, d2 = {"", "KeyT", "ValueT", "Lio/reactivex/Single;", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "lock", "", "operationName", "", "keys", "Lio/reactivex/Scheduler;", "scheduler", "withLock", "(Lio/reactivex/Single;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;Ljava/lang/String;Ljava/util/Set;Lio/reactivex/Scheduler;)Lio/reactivex/Single;", "Lio/reactivex/Completable;", "(Lio/reactivex/Completable;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;Ljava/lang/String;Ljava/util/Set;Lio/reactivex/Scheduler;)Lio/reactivex/Completable;", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class RxFairCompositeWriteLockKt {
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Single<T>, io.reactivex.Single<ValueT> */
    @NotNull
    public static final <KeyT, ValueT> Single<ValueT> withLock(@NotNull Single<ValueT> single, @NotNull RxFairCompositeWriteLock<KeyT> rxFairCompositeWriteLock, @NotNull String str, @NotNull Set<? extends KeyT> set, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(single, "$this$withLock");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(set, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        return (Single<T>) rxFairCompositeWriteLock.callSingle(single, str, set, scheduler);
    }

    @NotNull
    public static final <KeyT> Completable withLock(@NotNull Completable completable, @NotNull RxFairCompositeWriteLock<KeyT> rxFairCompositeWriteLock, @NotNull String str, @NotNull Set<? extends KeyT> set, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(completable, "$this$withLock");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        Intrinsics.checkNotNullParameter(str, "operationName");
        Intrinsics.checkNotNullParameter(set, "keys");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Single<T> singleDefault = completable.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, str, set, scheduler).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }
}
