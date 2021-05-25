package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007*\u0010\b\u0007\u0010\t\"\u00020\u00012\u00020\u0001B\u0002\b\b¨\u0006\n"}, d2 = {"T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "lock", "Lkotlin/Function0;", "block", "synchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/coroutines/InternalCoroutinesApi;", "SynchronizedObject", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class SynchronizedKt {
    @InternalCoroutinesApi
    public static /* synthetic */ void SynchronizedObject$annotations() {
    }

    @InternalCoroutinesApi
    /* renamed from: synchronized  reason: not valid java name */
    public static final <T> T m538synchronized(@NotNull Object obj, @NotNull Function0<? extends T> function0) {
        T t;
        synchronized (obj) {
            try {
                t = (T) function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return t;
    }
}
