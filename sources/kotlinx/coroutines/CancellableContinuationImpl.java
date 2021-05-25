package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import u6.a.a;
import u6.a.g;
import u6.a.p;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000g\u0012\u0006\u0010^\u001a\u00020X¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0019\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"J8\u0010'\u001a\u00020\u00062!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0011\u0010-\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b-\u0010\u0012J \u00100\u001a\u00020\u00062\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J<\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00028\u00002#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0016¢\u0006\u0004\b3\u00104J8\u00106\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`5H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u00020\u0006H\u0000¢\u0006\u0004\b8\u0010\bJ#\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00028\u00002\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b;\u0010<JH\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00028\u00002\b\u0010:\u001a\u0004\u0018\u00010\u00102#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0016¢\u0006\u0004\b;\u0010=J\u0019\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u0015H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0010H\u0016¢\u0006\u0004\bB\u00101J\u001b\u0010D\u001a\u00020\u0006*\u00020C2\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u0006*\u00020C2\u0006\u0010>\u001a\u00020\u0015H\u0016¢\u0006\u0004\bF\u0010GJ\u001f\u0010K\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\bI\u0010JJ\u001b\u0010N\u001a\u0004\u0018\u00010\u00152\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0004\bL\u0010MJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020OH\u0014¢\u0006\u0004\bR\u0010QJ\u000f\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u0010\u000bJ\u000f\u0010T\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010\bJB\u0010U\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`52\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bU\u0010(JB\u0010V\u001a\u00020\u00062'\u0010 \u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060#j\u0002`52\b\u0010H\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\bV\u0010WJ\u0017\u0010Z\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bZ\u0010[JZ\u0010_\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u00102\u0006\u0010^\u001a\u00020X2#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b_\u0010`JH\u0010a\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\u00102\u0006\u0010^\u001a\u00020X2%\b\u0002\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0002¢\u0006\u0004\ba\u0010bJJ\u0010d\u001a\u0004\u0018\u00010c2\b\u0010]\u001a\u0004\u0018\u00010\u00102\b\u0010:\u001a\u0004\u0018\u00010\u00102#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0002¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\bf\u0010\bR\"\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00000g8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bf\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010p\u001a\u00020l8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010m\u001a\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\u000bR\u0016\u0010r\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u000bR\u0016\u0010s\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u000bR\u001e\u0010v\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0018\u0010H\u001a\u0004\u0018\u00010\u00108@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\bw\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "initCancellability", "()V", "", "resetStateReusable", "()Z", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "(Ljava/lang/Throwable;)Z", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "Lkotlinx/coroutines/CancelHandler;", "handler", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "callOnCancellation", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", Tracker.Events.CREATIVE_RESUME, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CompletionHandler;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", OkListener.KEY_EXCEPTION, "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "d", "i", AuthSource.SEND_ABUSE, "e", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "mode", "c", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "resumeMode", "h", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "f", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Symbol;", "j", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", AuthSource.BOOKING_ORDER, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isCompleted", "isCancelled", "isActive", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getState$kotlinx_coroutines_core", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile int _decision = 0;
    public volatile Object _parentHandle = null;
    private volatile Object _state = a.a;
    @NotNull
    public final CoroutineContext a;
    @NotNull
    public final Continuation<T> b;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.b = continuation;
        this.a = continuation.getContext();
    }

    public static /* synthetic */ void g(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        int i3 = i2 & 4;
        cancellableContinuationImpl.f(obj, i, null);
    }

    public final void a(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void b() {
        if (!d()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    public final void c(int i) {
        boolean z;
        while (true) {
            int i2 = this._decision;
            z = false;
            if (i2 == 0) {
                if (c.compareAndSet(this, 0, 2)) {
                    z = true;
                    break;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("Already resumed".toString());
            }
        }
        if (!z) {
            DispatchedTaskKt.dispatch(this, i);
        }
    }

    public final void callCancelHandler(@NotNull CancelHandler cancelHandler, @Nullable Throwable th) {
        try {
            cancelHandler.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!d.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        if (!z) {
            obj = null;
        }
        CancelHandler cancelHandler = (CancelHandler) obj;
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, th);
        }
        b();
        c(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof g) {
                    g gVar = (g) obj2;
                    if (!(gVar.e != null)) {
                        if (d.compareAndSet(this, obj2, g.a(gVar, null, null, null, null, th, 15))) {
                            CancelHandler cancelHandler = gVar.b;
                            if (cancelHandler != null) {
                                callCancelHandler(cancelHandler, th);
                            }
                            Function1<Throwable, Unit> function1 = gVar.c;
                            if (function1 != null) {
                                callOnCancellation(function1, th);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (d.compareAndSet(this, obj2, new g(obj2, null, null, null, th, 14))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object obj) {
        c(this.resumeMode);
    }

    public final boolean d() {
        Continuation<T> continuation = this.b;
        return (continuation instanceof DispatchedContinuation) && ((DispatchedContinuation) continuation).isReusable(this);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = (DisposableHandle) this._parentHandle;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        this._parentHandle = NonDisposableHandle.INSTANCE;
    }

    public final void e(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    public final void f(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(a2.b.a.a.a.b3("Already resumed, but proposed with update ", obj).toString());
            }
        } while (!d.compareAndSet(this, obj2, h((NotCompleted) obj2, obj, i, function1, null)));
        b();
        c(i);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.b;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.a;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job job) {
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.b;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        boolean z;
        Job job;
        i();
        while (true) {
            int i = this._decision;
            z = false;
            if (i == 0) {
                if (c.compareAndSet(this, 0, 1)) {
                    z = true;
                    break;
                }
            } else if (i != 2) {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z) {
            return t6.p.a.a.getCOROUTINE_SUSPENDED();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else if (!DispatchedTaskKt.isCancellableMode(this.resumeMode) || (job = (Job) getContext().get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        } else {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            throw cancellationException;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj instanceof g ? (T) ((g) obj).a : obj;
    }

    public final Object h(NotCompleted notCompleted, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (!DispatchedTaskKt.isCancellableMode(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(notCompleted instanceof CancelHandler) || (notCompleted instanceof BeforeResumeCancelHandler)) && obj2 == null)) {
            return obj;
        }
        if (!(notCompleted instanceof CancelHandler)) {
            notCompleted = null;
        }
        return new g(obj, (CancelHandler) notCompleted, function1, obj2, null, 16);
    }

    public final void i() {
        Job job;
        Throwable checkPostponedCancellation;
        boolean isCompleted = isCompleted();
        if (DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation<T> continuation = this.b;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (!(dispatchedContinuation == null || (checkPostponedCancellation = dispatchedContinuation.checkPostponedCancellation(this)) == null)) {
                if (!isCompleted) {
                    cancel(checkPostponedCancellation);
                }
                isCompleted = true;
            }
        }
        if (!isCompleted && ((DisposableHandle) this._parentHandle) == null && (job = (Job) this.b.getContext().get(Job.Key)) != null) {
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(job, this), 2, null);
            this._parentHandle = invokeOnCompletion$default;
            if (isCompleted() && !d()) {
                invokeOnCompletion$default.dispose();
                this._parentHandle = NonDisposableHandle.INSTANCE;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        i();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> function1) {
        CancelHandler pVar = function1 instanceof CancelHandler ? (CancelHandler) function1 : new p(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof a)) {
                Throwable th = null;
                if (!(obj instanceof CancelHandler)) {
                    boolean z = obj instanceof CompletedExceptionally;
                    if (z) {
                        if (!((CompletedExceptionally) obj).makeHandled()) {
                            e(function1, obj);
                            throw null;
                        } else if (obj instanceof CancelledContinuation) {
                            if (!z) {
                                obj = null;
                            }
                            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                            if (completedExceptionally != null) {
                                th = completedExceptionally.cause;
                            }
                            a(function1, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj instanceof g) {
                        g gVar = (g) obj;
                        if (gVar.b != null) {
                            e(function1, obj);
                            throw null;
                        } else if (!(pVar instanceof BeforeResumeCancelHandler)) {
                            Throwable th2 = gVar.e;
                            if (th2 != null) {
                                a(function1, th2);
                                return;
                            } else {
                                if (d.compareAndSet(this, obj, g.a(gVar, null, pVar, null, null, null, 29))) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (!(pVar instanceof BeforeResumeCancelHandler)) {
                        if (d.compareAndSet(this, obj, new g(obj, pVar, null, null, null, 28))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    e(function1, obj);
                    throw null;
                }
            } else if (d.compareAndSet(this, obj, pVar)) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public final Symbol j(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof g) || obj2 == null || ((g) obj3).d != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
        } while (!d.compareAndSet(this, obj3, h((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        b();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @NotNull
    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable th) {
        boolean z = false;
        if (DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation<T> continuation = this.b;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                z = dispatchedContinuation.postponeCancellation(th);
            }
        }
        if (!z) {
            cancel(th);
            b();
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        Object obj = this._state;
        if (!(obj instanceof g) || ((g) obj).d == null) {
            this._decision = 0;
            this._state = a.a;
            return true;
        }
        detachChild$kotlinx_coroutines_core();
        return false;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, @Nullable Function1<? super Throwable, Unit> function1) {
        f(t, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.b;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        g(this, t, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Continuation<T> continuation = this.b;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        g(this, completedExceptionally, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        g(this, CompletionStateKt.toState(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.b) + "){" + getState$kotlinx_coroutines_core() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj) {
        return j(t, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th) {
        return j(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        return j(t, obj, function1);
    }
}
