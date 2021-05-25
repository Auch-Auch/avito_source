package kotlinx.coroutines;

import com.avito.android.social.AppleSignInManagerKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u0006\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\tH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH'¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\u001d\u001a\u00020\r2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tH'¢\u0006\u0004\b\"\u0010#J<\u0010$\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006*"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "value", "", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", OkListener.KEY_EXCEPTION, "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "completeResume", "(Ljava/lang/Object;)V", "initCancellability", "()V", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", Tracker.Events.CREATIVE_RESUME, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isCompleted", "()Z", "isCancelled", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return cancellableContinuation.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.tryResume(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    boolean cancel(@Nullable Throwable th);

    @InternalCoroutinesApi
    void completeResume(@NotNull Object obj);

    @InternalCoroutinesApi
    void initCancellability();

    void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @ExperimentalCoroutinesApi
    void resume(T t, @Nullable Function1<? super Throwable, Unit> function1);

    @ExperimentalCoroutinesApi
    void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t);

    @ExperimentalCoroutinesApi
    void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T t, @Nullable Object obj);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1);

    @InternalCoroutinesApi
    @Nullable
    Object tryResumeWithException(@NotNull Throwable th);
}
