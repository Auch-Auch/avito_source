package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\b¢\u0006\u0004\b\u0013\u0010\u0014R>\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010'\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0004@BX\u000e¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "slot", "", "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "Lkotlin/Function1;", "block", "forEachSlotLocked", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", AuthSource.SEND_ABUSE, "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots$annotations", "()V", "slots", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "c", "I", "nextIndex", AuthSource.BOOKING_ORDER, "getNCollectors", "()I", "nCollectors", "Lkotlinx/coroutines/flow/MutableStateFlow;", "d", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    @Nullable
    public S[] a;
    public int b;
    public int c;
    public MutableStateFlow<Integer> d;

    public static /* synthetic */ void getSlots$annotations() {
    }

    @NotNull
    public final S allocateSlot() {
        S s;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] sArr = this.a;
            if (sArr == null) {
                sArr = createSlotArray(2);
                this.a = sArr;
            } else if (this.b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.a = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
            }
            int i = this.c;
            do {
                s = sArr[i];
                if (s == null) {
                    s = createSlot();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                if (s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s.allocateLocked(this));
            this.c = i;
            this.b++;
            mutableStateFlow = this.d;
        }
        if (mutableStateFlow != null) {
            StateFlowKt.increment(mutableStateFlow, 1);
        }
        return s;
    }

    @NotNull
    public abstract S createSlot();

    @NotNull
    public abstract S[] createSlotArray(int i);

    public final void forEachSlotLocked(@NotNull Function1<? super S, Unit> function1) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (!(this.b == 0 || (abstractSharedFlowSlotArr = this.a) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    function1.invoke(abstractSharedFlowSlot);
                }
            }
        }
    }

    public final void freeSlot(@NotNull S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i;
        Continuation<Unit>[] freeLocked;
        synchronized (this) {
            int i2 = this.b - 1;
            this.b = i2;
            mutableStateFlow = this.d;
            if (i2 == 0) {
                this.c = 0;
            }
            if (s != null) {
                freeLocked = s.freeLocked(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (Continuation<Unit> continuation : freeLocked) {
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m242constructorimpl(unit));
            }
        }
        if (mutableStateFlow != null) {
            StateFlowKt.increment(mutableStateFlow, -1);
        }
    }

    public final int getNCollectors() {
        return this.b;
    }

    @Nullable
    public final S[] getSlots() {
        return this.a;
    }

    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            mutableStateFlow = this.d;
            if (mutableStateFlow == null) {
                mutableStateFlow = StateFlowKt.MutableStateFlow(Integer.valueOf(this.b));
                this.d = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }
}
