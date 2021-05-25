package kotlinx.coroutines.internal;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0000HHø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u000b\u0010\u0004\u001a!\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\f\u0010\u0004\u001a\u001b\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00060\u000fj\u0002`\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0019\u001a\u00020\u0018*\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u001e\u0010!\u001a\n \u001f*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 \"\u001e\u0010#\u001a\n \u001f*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010 *\f\b\u0000\u0010%\"\u00020$2\u00020$*\f\b\u0000\u0010&\"\u00020\u000f2\u00020\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"", ExifInterface.LONGITUDE_EAST, OkListener.KEY_EXCEPTION, "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "continuation", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "", "recoverAndThrow", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "", "message", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "artificialFrame", "(Ljava/lang/String;)Ljava/lang/StackTraceElement;", "", "isArtificial", "(Ljava/lang/StackTraceElement;)Z", "", "methodName", "", AuthSource.SEND_ABUSE, "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "cause", "", "initCause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "baseContinuationImplClassName", AuthSource.BOOKING_ORDER, "stackTraceRecoveryClassName", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class StackTraceRecoveryKt {
    public static final String a;
    public static final String b;

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m242constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m242constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m245exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) obj;
        try {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m242constructorimpl(Class.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.m242constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m245exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) obj2;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        Pair pair;
        boolean z;
        Throwable cause = th.getCause();
        int i = 0;
        if (cause == null || !Intrinsics.areEqual(cause.getClass(), th.getClass())) {
            pair = TuplesKt.to(th, new StackTraceElement[0]);
        } else {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (isArtificial(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                pair = TuplesKt.to(cause, stackTrace);
            } else {
                pair = TuplesKt.to(th, new StackTraceElement[0]);
            }
        }
        Throwable th2 = (Throwable) pair.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(th2);
        if (tryCopyException == null || (!Intrinsics.areEqual(tryCopyException.getMessage(), th2.getMessage()))) {
            return th;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        if (arrayDeque.isEmpty()) {
            return th;
        }
        if (th2 != th) {
            int length2 = stackTraceElementArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    i3 = -1;
                    break;
                } else if (isArtificial(stackTraceElementArr[i3])) {
                    break;
                } else {
                    i3++;
                }
            }
            int i4 = i3 + 1;
            int length3 = stackTraceElementArr.length - 1;
            if (length3 >= i4) {
                while (true) {
                    StackTraceElement stackTraceElement3 = stackTraceElementArr[length3];
                    StackTraceElement stackTraceElement4 = (StackTraceElement) arrayDeque.getLast();
                    if (stackTraceElement3.getLineNumber() == stackTraceElement4.getLineNumber() && Intrinsics.areEqual(stackTraceElement3.getMethodName(), stackTraceElement4.getMethodName()) && Intrinsics.areEqual(stackTraceElement3.getFileName(), stackTraceElement4.getFileName()) && Intrinsics.areEqual(stackTraceElement3.getClassName(), stackTraceElement4.getClassName())) {
                        arrayDeque.removeLast();
                    }
                    arrayDeque.addFirst(stackTraceElementArr[length3]);
                    if (length3 == i4) {
                        break;
                    }
                    length3--;
                }
            }
        }
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace2 = th2.getStackTrace();
        int a3 = a(stackTrace2, a);
        if (a3 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            tryCopyException.setStackTrace((StackTraceElement[]) array);
        } else {
            StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[(arrayDeque.size() + a3)];
            for (int i5 = 0; i5 < a3; i5++) {
                stackTraceElementArr2[i5] = stackTrace2[i5];
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr2[a3 + i] = (StackTraceElement) it.next();
                i++;
            }
            tryCopyException.setStackTrace(stackTraceElementArr2);
        }
        return tryCopyException;
    }

    @InternalCoroutinesApi
    @NotNull
    public static final StackTraceElement artificialFrame(@NotNull String str) {
        return new StackTraceElement(a.c3("\b\b\b(", str), "\b", "\b", -1);
    }

    public static final void initCause(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(@NotNull StackTraceElement stackTraceElement) {
        return m.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable th, @NotNull Continuation<?> continuation) {
        throw th;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e) {
        return e;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e, @NotNull Continuation<?> continuation) {
        return e;
    }

    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E e) {
        return e;
    }

    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (isArtificial(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }
}
