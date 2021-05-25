package kotlinx.coroutines.selects;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\fHHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000e\u0010\u000f\"\u001c\u0010\u0014\u001a\u00020\u00068\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013\"\"\u0010\u0019\u001a\u00020\u00068\u0000@\u0001X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\"\u0010\u001d\u001a\u00020\u00068\u0000@\u0001X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001b\u0010\u0017\"\u001c\u0010 \u001a\u00020\u00068\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u0012\u0004\b\u001f\u0010\u0013\"\u001c\u0010%\u001a\u00020!8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u0012\u0004\b$\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/time/Duration;", "timeout", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "onTimeout-0lHKgQg", "(Lkotlinx/coroutines/selects/SelectBuilder;DLkotlin/jvm/functions/Function1;)V", "onTimeout", "Lkotlin/ExtensionFunctionType;", "builder", "select", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Ljava/lang/Object;", "getRESUMED$annotations", "()V", "RESUMED", AuthSource.SEND_ABUSE, "getNOT_SELECTED", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "NOT_SELECTED", AuthSource.BOOKING_ORDER, "getALREADY_SELECTED", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "Lkotlinx/coroutines/selects/SeqNumber;", "e", "Lkotlinx/coroutines/selects/SeqNumber;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class SelectKt {
    @NotNull
    public static final Object a = new Symbol("NOT_SELECTED");
    @NotNull
    public static final Object b = new Symbol("ALREADY_SELECTED");
    public static final Object c = new Symbol("UNDECIDED");
    public static final Object d = new Symbol("RESUMED");
    public static final SeqNumber e = new SeqNumber();

    @NotNull
    public static final Object getALREADY_SELECTED() {
        return b;
    }

    public static /* synthetic */ void getALREADY_SELECTED$annotations() {
    }

    @NotNull
    public static final Object getNOT_SELECTED() {
        return a;
    }

    public static /* synthetic */ void getNOT_SELECTED$annotations() {
    }

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    /* renamed from: onTimeout-0lHKgQg  reason: not valid java name */
    public static final <R> void m539onTimeout0lHKgQg(@NotNull SelectBuilder<? super R> selectBuilder, double d2, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.onTimeout(DelayKt.m497toDelayMillisLRDsOJo(d2), function1);
    }

    @Nullable
    public static final <R> Object select(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
