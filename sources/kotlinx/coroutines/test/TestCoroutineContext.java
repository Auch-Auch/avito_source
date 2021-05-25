package kotlinx.coroutines.test;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentModule;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import u6.a.n0.a;
@Deprecated(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @ReplaceWith(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001LB\u0013\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010!¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001fJ+\u0010'\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#¢\u0006\u0004\b'\u0010(J+\u0010)\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#¢\u0006\u0004\b)\u0010(J+\u0010*\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#¢\u0006\u0004\b*\u0010(J1\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020!2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0+\u0012\u0004\u0012\u00020%0#¢\u0006\u0004\b,\u0010(J\u000f\u0010-\u001a\u00020!H\u0016¢\u0006\u0004\b-\u0010.R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020$0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u00100R\u0018\u00104\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010A\u001a\u00060>R\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0019\u0010G\u001a\b\u0012\u0004\u0012\u00020$0+8F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010C¨\u0006M"}, d2 = {"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "", "targetTime", "", AuthSource.SEND_ABUSE, "(J)V", "R", SharingMapFragmentModule.INITIAL_STATE, "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/TimeUnit;", "unit", "now", "(Ljava/util/concurrent/TimeUnit;)J", "delayTime", "advanceTimeBy", "(JLjava/util/concurrent/TimeUnit;)J", "advanceTimeTo", "(JLjava/util/concurrent/TimeUnit;)V", "triggerActions", "()V", "cancelAllActions", "", "message", "Lkotlin/Function1;", "", "", "predicate", "assertUnhandledException", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "assertAllUnhandledExceptions", "assertAnyUnhandledException", "", "assertExceptions", "toString", "()Ljava/lang/String;", "", "Ljava/util/List;", "uncaughtExceptions", g.a, "Ljava/lang/String;", "name", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lu6/a/n0/a;", "d", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "queue", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", AuthSource.BOOKING_ORDER, "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxDispatcher", "e", "J", "counter", "getExceptions", "()Ljava/util/List;", "exceptions", "f", "time", "<init>", "(Ljava/lang/String;)V", "Dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class TestCoroutineContext implements CoroutineContext {
    public final List<Throwable> a;
    public final Dispatcher b;
    public final CoroutineExceptionHandler c;
    public final ThreadSafeHeap<a> d;
    public long e;
    public long f;
    public final String g;

    public final class Dispatcher extends EventLoop implements Delay {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public Dispatcher() {
            EventLoop.incrementUseCount$default(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        @Nullable
        public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, j, continuation);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
            TestCoroutineContext.access$enqueue(TestCoroutineContext.this, runnable);
        }

        @Override // kotlinx.coroutines.Delay
        @NotNull
        public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return new TestCoroutineContext$Dispatcher$invokeOnTimeout$1(this, TestCoroutineContext.access$postDelayed(TestCoroutineContext.this, runnable, j));
        }

        @Override // kotlinx.coroutines.EventLoop
        public long processNextEvent() {
            return TestCoroutineContext.access$processNextEvent(TestCoroutineContext.this);
        }

        @Override // kotlinx.coroutines.Delay
        public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            TestCoroutineContext.access$postDelayed(TestCoroutineContext.this, new TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(this, cancellableContinuation), j);
        }

        @Override // kotlinx.coroutines.EventLoop
        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Dispatcher(");
            L.append(TestCoroutineContext.this);
            L.append(')');
            return L.toString();
        }
    }

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(@Nullable String str) {
        this.g = str;
        this.a = new ArrayList();
        this.b = new Dispatcher();
        this.c = new CoroutineExceptionHandler(CoroutineExceptionHandler.Key, this) { // from class: kotlinx.coroutines.test.TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1
            public final /* synthetic */ TestCoroutineContext a;

            {
                this.a = r2;
            }

            @Override // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
                TestCoroutineContext.access$getUncaughtExceptions$p(this.a).add(th);
            }
        };
        this.d = new ThreadSafeHeap<>();
    }

    public static final void access$enqueue(TestCoroutineContext testCoroutineContext, Runnable runnable) {
        ThreadSafeHeap<a> threadSafeHeap = testCoroutineContext.d;
        long j = testCoroutineContext.e;
        testCoroutineContext.e = 1 + j;
        threadSafeHeap.addLast(new a(runnable, j, 0, 4));
    }

    public static final a access$postDelayed(TestCoroutineContext testCoroutineContext, Runnable runnable, long j) {
        long j2 = testCoroutineContext.e;
        testCoroutineContext.e = 1 + j2;
        a aVar = new a(runnable, j2, TimeUnit.MILLISECONDS.toNanos(j) + testCoroutineContext.f);
        testCoroutineContext.d.addLast(aVar);
        return aVar;
    }

    public static final long access$processNextEvent(TestCoroutineContext testCoroutineContext) {
        a peek = testCoroutineContext.d.peek();
        if (peek != null) {
            testCoroutineContext.a(peek.e);
        }
        return testCoroutineContext.d.isEmpty() ? Long.MAX_VALUE : 0;
    }

    public static /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public static /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public static /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public static /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public static /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    public final void a(long j) {
        a aVar;
        while (true) {
            ThreadSafeHeap<a> threadSafeHeap = this.d;
            synchronized (threadSafeHeap) {
                a firstImpl = threadSafeHeap.firstImpl();
                aVar = null;
                if (firstImpl != null) {
                    if (firstImpl.e <= j) {
                        aVar = threadSafeHeap.removeAtImpl(0);
                    }
                }
            }
            a aVar2 = aVar;
            if (aVar2 != null) {
                long j2 = aVar2.e;
                if (j2 != 0) {
                    this.f = j2;
                }
                aVar2.c.run();
            } else {
                return;
            }
        }
    }

    public final long advanceTimeBy(long j, @NotNull TimeUnit timeUnit) {
        long j2 = this.f;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        advanceTimeTo(timeUnit.toNanos(j) + j2, timeUnit2);
        return timeUnit.convert(this.f - j2, timeUnit2);
    }

    public final void advanceTimeTo(long j, @NotNull TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        a(nanos);
        if (nanos > this.f) {
            this.f = nanos;
        }
    }

    public final void assertAllUnhandledExceptions(@NotNull String str, @NotNull Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.a;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!function1.invoke(it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void assertAnyUnhandledException(@NotNull String str, @NotNull Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.a;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (function1.invoke(it.next()).booleanValue()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void assertExceptions(@NotNull String str, @NotNull Function1<? super List<? extends Throwable>, Boolean> function1) {
        if (function1.invoke(this.a).booleanValue()) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void assertUnhandledException(@NotNull String str, @NotNull Function1<? super Throwable, Boolean> function1) {
        if (this.a.size() != 1 || !function1.invoke(this.a.get(0)).booleanValue()) {
            throw new AssertionError(str);
        }
        this.a.clear();
    }

    public final void cancelAllActions() {
        if (!this.d.isEmpty()) {
            this.d.clear();
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) function2.invoke((Object) function2.invoke(r, this.b), this.c);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        if (key == ContinuationInterceptor.Key) {
            Dispatcher dispatcher = this.b;
            Objects.requireNonNull(dispatcher, "null cannot be cast to non-null type E");
            return dispatcher;
        } else if (key != CoroutineExceptionHandler.Key) {
            return null;
        } else {
            CoroutineExceptionHandler coroutineExceptionHandler = this.c;
            Objects.requireNonNull(coroutineExceptionHandler, "null cannot be cast to non-null type E");
            return coroutineExceptionHandler;
        }
    }

    @NotNull
    public final List<Throwable> getExceptions() {
        return this.a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        if (key == ContinuationInterceptor.Key) {
            return this.c;
        }
        return key == CoroutineExceptionHandler.Key ? this.b : this;
    }

    public final long now(@NotNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f, TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        String str = this.g;
        if (str != null) {
            return str;
        }
        StringBuilder L = a2.b.a.a.a.L("TestCoroutineContext@");
        L.append(DebugStringsKt.getHexAddress(this));
        return L.toString();
    }

    public final void triggerActions() {
        a(this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestCoroutineContext(String str, int i, j jVar) {
        this((i & 1) != 0 ? null : str);
    }
}
