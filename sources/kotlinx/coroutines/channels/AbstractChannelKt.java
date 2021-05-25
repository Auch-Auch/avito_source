package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u001c\u0010\u0004\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001c\u0010\b\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u0012\u0004\b\t\u0010\u0007\"\u0016\u0010\n\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u001c\u0010\u000b\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u0012\u0004\b\f\u0010\u0007\"\u001c\u0010\r\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u0012\u0004\b\u000e\u0010\u0007\"\u0016\u0010\u000f\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0002\"\u001c\u0010\u0010\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u0012\u0004\b\u0011\u0010\u0007\"\u001c\u0010\u0012\u001a\u00020\u00038\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u0012\u0004\b\u0013\u0010\u0007*(\b\u0000\u0010\u0017\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014¨\u0006\u0018"}, d2 = {"", "RECEIVE_RESULT", "I", "Lkotlinx/coroutines/internal/Symbol;", "EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "getEMPTY$annotations", "()V", "OFFER_FAILED", "getOFFER_FAILED$annotations", "RECEIVE_THROWS_ON_CLOSE", "OFFER_SUCCESS", "getOFFER_SUCCESS$annotations", "ENQUEUE_FAILED", "getENQUEUE_FAILED$annotations", "RECEIVE_NULL_ON_CLOSE", "POLL_FAILED", "getPOLL_FAILED$annotations", "HANDLER_INVOKED", "getHANDLER_INVOKED$annotations", "Lkotlin/Function1;", "", "", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class AbstractChannelKt {
    @JvmField
    @NotNull
    public static final Symbol EMPTY = new Symbol("EMPTY");
    @JvmField
    @NotNull
    public static final Symbol ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    @JvmField
    @NotNull
    public static final Symbol HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");
    @JvmField
    @NotNull
    public static final Symbol OFFER_FAILED = new Symbol("OFFER_FAILED");
    @JvmField
    @NotNull
    public static final Symbol OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    @JvmField
    @NotNull
    public static final Symbol POLL_FAILED = new Symbol("POLL_FAILED");
    public static final int RECEIVE_NULL_ON_CLOSE = 1;
    public static final int RECEIVE_RESULT = 2;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;

    public static final Object access$toResult(Object obj) {
        if (obj instanceof Closed) {
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(((Closed) obj).closeCause));
        }
        ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
        return ValueOrClosed.m502constructorimpl(obj);
    }

    public static /* synthetic */ void getEMPTY$annotations() {
    }

    public static /* synthetic */ void getENQUEUE_FAILED$annotations() {
    }

    public static /* synthetic */ void getHANDLER_INVOKED$annotations() {
    }

    public static /* synthetic */ void getOFFER_FAILED$annotations() {
    }

    public static /* synthetic */ void getOFFER_SUCCESS$annotations() {
    }

    public static /* synthetic */ void getPOLL_FAILED$annotations() {
    }

    public static final Object access$toResult(Closed closed) {
        ValueOrClosed.Companion companion = ValueOrClosed.Companion;
        return ValueOrClosed.m502constructorimpl(new ValueOrClosed.Closed(closed.closeCause));
    }
}
