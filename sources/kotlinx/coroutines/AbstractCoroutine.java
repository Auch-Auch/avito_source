package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u0019\u0012\u0006\u00109\u001a\u000202\u0012\b\b\u0002\u0010<\u001a\u00020\u0012¢\u0006\u0004\b=\u0010>J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0004¢\u0006\u0004\b\u001b\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010\u001f\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001f\u0010\u000fJ\u0017\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010%\u001a\u00020\u0016H\u0010¢\u0006\u0004\b$\u0010\u0018J6\u0010'\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u001c\u0010)\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190(ø\u0001\u0000¢\u0006\u0004\b'\u0010*JO\u0010'\u001a\u00020\u0006\"\u0004\b\u0001\u0010+2\u0006\u0010'\u001a\u00020&2\u0006\u0010,\u001a\u00028\u00012'\u0010)\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190-¢\u0006\u0002\b.ø\u0001\u0000¢\u0006\u0004\b'\u0010/R\u0016\u00100\u001a\u00020\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001f\u00108\u001a\u0002028\u0006@\u0006¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b7\u0010\b\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u0002028\u0004@\u0005X\u0004¢\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010;\u001a\u0002028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b:\u00106\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "", "initParentJob$kotlinx_coroutines_core", "()V", "initParentJob", "onStart", "onStartInternal$kotlinx_coroutines_core", "onStartInternal", "value", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "", "state", "onCompletionInternal", "Lkotlin/Result;", "result", "resumeWith", "afterResume", OkListener.KEY_EXCEPTION, "handleOnCompletionException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleOnCompletionException", "nameString$kotlinx_coroutines_core", "nameString", "Lkotlinx/coroutines/CoroutineStart;", Tracker.Events.CREATIVE_START, "Lkotlin/Function1;", "block", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "R", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "isActive", "()Z", "Lkotlin/coroutines/CoroutineContext;", AuthSource.BOOKING_ORDER, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "context", "parentContext", "getCoroutineContext", "coroutineContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    @NotNull
    public final CoroutineContext b;
    @JvmField
    @NotNull
    public final CoroutineContext parentContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i, j jVar) {
        this(coroutineContext, (i & 2) != 0 ? true : z);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    public void afterResume(@Nullable Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public final CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.b, th);
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.b);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return Typography.quote + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public void onCancelled(@NotNull Throwable th, boolean z) {
    }

    public void onCompleted(T t) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(@Nullable Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, completedExceptionally.getHandled());
            return;
        }
        onCompleted(obj);
    }

    public void onStart() {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(obj, null, 1, null));
        if (makeCompletingOnce$kotlinx_coroutines_core != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            afterResume(makeCompletingOnce$kotlinx_coroutines_core);
        }
    }

    public final void start(@NotNull CoroutineStart coroutineStart, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function1, this);
    }

    public AbstractCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.parentContext = coroutineContext;
        this.b = coroutineContext.plus(this);
    }

    public final <R> void start(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function2, r, this);
    }
}
