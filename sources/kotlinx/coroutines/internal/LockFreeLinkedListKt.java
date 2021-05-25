package kotlinx.coroutines.internal;

import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import u6.a.k0.b;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0006\u001a\u00020\u00058\u0000@\u0001XT¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\"\u0010\u000f\u001a\u00020\u00008\u0000@\u0001X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r\"\"\u0010\u0013\u001a\u00020\u00008\u0000@\u0001X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\r\"\u001c\u0010\u0014\u001a\u00020\u00058\u0000@\u0001XT¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u0012\u0004\b\u0015\u0010\t\"\u001c\u0010\u0016\u001a\u00020\u00058\u0000@\u0001XT¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u0012\u0004\b\u0017\u0010\t*\n\u0010\u0019\"\u00020\u00182\u00020\u0018*\u001c\u0010\u001c\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\u0012\u0004\u0012\u00028\u00000\u001b*\f\b\u0002\u0010\u001d\"\u00020\u00012\u00020\u0001*\n\u0010\u001f\"\u00020\u001e2\u00020\u001e*\u001c\u0010!\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u00028\u00000 2\b\u0012\u0004\u0012\u00028\u00000 ¨\u0006\""}, d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", SberbankOnlineKt.RESULT_FAILURE, "I", "getFAILURE$annotations", "()V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "CONDITION_FALSE", AuthSource.BOOKING_ORDER, "getLIST_EMPTY", "getLIST_EMPTY$annotations", "LIST_EMPTY", "UNDECIDED", "getUNDECIDED$annotations", SberbankOnlineKt.RESULT_SUCCESS, "getSUCCESS$annotations", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AbstractAtomicDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class LockFreeLinkedListKt {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;
    @NotNull
    public static final Object a = new Symbol("CONDITION_FALSE");
    @NotNull
    public static final Object b = new Symbol("LIST_EMPTY");

    @NotNull
    public static final Object getCONDITION_FALSE() {
        return a;
    }

    @PublishedApi
    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getFAILURE$annotations() {
    }

    @NotNull
    public static final Object getLIST_EMPTY() {
        return b;
    }

    @PublishedApi
    public static /* synthetic */ void getLIST_EMPTY$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getUNDECIDED$annotations() {
    }

    @PublishedApi
    @NotNull
    public static final LockFreeLinkedListNode unwrap(@NotNull Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        b bVar = (b) (!(obj instanceof b) ? null : obj);
        if (bVar != null && (lockFreeLinkedListNode = bVar.a) != null) {
            return lockFreeLinkedListNode;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (LockFreeLinkedListNode) obj;
    }
}
