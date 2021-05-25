package t6.x;

import a2.b.a.a.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class c<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    public int a;
    public T b;
    public Iterator<? extends T> c;
    @Nullable
    public Continuation<? super Unit> d;

    public final Throwable a() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        StringBuilder L = a.L("Unexpected state of the iterator: ");
        L.append(this.a);
        return new IllegalStateException(L.toString());
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.c;
                    Intrinsics.checkNotNull(it);
                    if (it.hasNext()) {
                        this.a = 2;
                        return true;
                    }
                    this.c = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
            }
            this.a = 5;
            Continuation<? super Unit> continuation = this.d;
            Intrinsics.checkNotNull(continuation);
            this.d = null;
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m242constructorimpl(unit));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.c;
            Intrinsics.checkNotNull(it);
            return (T) it.next();
        } else if (i == 3) {
            this.a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw a();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        ResultKt.throwOnFailure(obj);
        this.a = 4;
    }

    @Override // kotlin.sequences.SequenceScope
    @Nullable
    public Object yield(T t, @NotNull Continuation<? super Unit> continuation) {
        this.b = t;
        this.a = 3;
        this.d = continuation;
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    @Override // kotlin.sequences.SequenceScope
    @Nullable
    public Object yieldAll(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.INSTANCE;
        }
        this.c = it;
        this.a = 2;
        this.d = continuation;
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == t6.p.a.a.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
