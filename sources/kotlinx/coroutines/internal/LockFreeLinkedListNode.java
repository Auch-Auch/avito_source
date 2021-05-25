package kotlinx.coroutines.internal;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.k0.b;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u0005DEFGHB\u0007¢\u0006\u0004\bC\u0010,J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\t\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0010¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0002¢\u0006\u0004\b\u0014\u0010\u0006J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\f\b\u0000\u0010\u0015*\u00060\u0000j\u0002`\u00022\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\b¢\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\u001d\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0002\u0012\u0004\u0012\u00020\r0\u001bH\b¢\u0006\u0004\b\u001d\u0010\u001eJD\u0010\u001f\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0002\u0012\u0004\u0012\u00020\r0\u001b2\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\b¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002H\u0001¢\u0006\u0004\b!\u0010\"J/\u0010%\u001a\u00020$2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\u0006\u0010#\u001a\u00020\u000fH\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H\u0001¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0001¢\u0006\u0004\b-\u0010,J\u0015\u0010.\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b.\u0010*J\u0017\u00100\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00020/¢\u0006\u0004\b0\u00101J.\u00102\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0015\u0018\u00012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001bH\b¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H\u0014¢\u0006\u0004\b4\u0010*J'\u00108\u001a\u00020\u00042\n\u00105\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u0017\u0010=\u001a\u00060\u0000j\u0002`\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010*R\u0013\u0010\u0003\u001a\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\u00060\u0000j\u0002`\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010*R\u0016\u0010B\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010(¨\u0006I"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/Node;", "next", "", AuthSource.BOOKING_ORDER, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", AuthSource.SEND_ABUSE, "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addLast", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", ProductAction.ACTION_REMOVE, "()Z", "removeOrNext", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "helpRemove", "()V", "helpRemovePrev", "removeFirstOrNull", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "nextIfRemoved", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "", "toString", "()Ljava/lang/String;", "getNextNode", "nextNode", "getNext", "()Ljava/lang/Object;", "getPrevNode", "prevNode", "isRemoved", "<init>", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    private volatile Object _removedRef = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H$¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0004j\u0002`\u00052\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u00020\u00102\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!R\u001e\u0010$\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001e\u0010&\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", PublicConstantsKt.FAILURE, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "onRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/AtomicOp;", "prepare", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", Tracker.Events.CREATIVE_COMPLETE, "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            LockFreeLinkedListNode originalNext;
            boolean z = obj == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode != null && (originalNext = getOriginalNext()) != null) {
                if (LockFreeLinkedListNode.a.compareAndSet(affectedNode, atomicOp, z ? updatedNext(affectedNode, originalNext) : originalNext) && z) {
                    finishOnSuccess(affectedNode, originalNext);
                }
            }
        }

        @Nullable
        public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            return null;
        }

        public abstract void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void finishPrepare(@NotNull PrepareOp prepareOp);

        @Nullable
        public abstract LockFreeLinkedListNode getAffectedNode();

        @Nullable
        public abstract LockFreeLinkedListNode getOriginalNext();

        @Nullable
        public Object onPrepare(@NotNull PrepareOp prepareOp) {
            finishPrepare(prepareOp);
            return null;
        }

        public void onRemoved(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @Nullable
        public final Object prepare(@NotNull AtomicOp<?> atomicOp) {
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
                if (takeAffectedNode == null) {
                    return AtomicKt.RETRY_ATOMIC;
                }
                Object obj = takeAffectedNode._next;
                if (obj == atomicOp || atomicOp.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (atomicOp.isEarlierThan(opDescriptor)) {
                        return AtomicKt.RETRY_ATOMIC;
                    }
                    opDescriptor.perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj)) {
                        continue;
                    } else {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        PrepareOp prepareOp = new PrepareOp(takeAffectedNode, (LockFreeLinkedListNode) obj, this);
                        if (LockFreeLinkedListNode.a.compareAndSet(takeAffectedNode, obj, prepareOp)) {
                            try {
                                if (prepareOp.perform(takeAffectedNode) != LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                LockFreeLinkedListNode.a.compareAndSet(takeAffectedNode, prepareOp, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        public boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            return false;
        }

        @Nullable
        public LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        @NotNull
        public abstract Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0004\b \u0010\u0017J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00112\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001d\u001a\u00028\u00008\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001e¨\u0006!"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "next", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "getOriginalNext", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getAffectedNode", "affectedNode", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "queue", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode = null;
        @JvmField
        @NotNull
        public final T node;
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull T t) {
            this.queue = lockFreeLinkedListNode;
            this.node = t;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            this.node.b(this.queue);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@NotNull PrepareOp prepareOp) {
            a.compareAndSet(this, null, prepareOp.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            return obj != this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            return this.queue.a(opDescriptor);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @NotNull
        public Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            T t = this.node;
            LockFreeLinkedListNode.b.compareAndSet(t, t, lockFreeLinkedListNode);
            T t2 = this.node;
            LockFreeLinkedListNode.a.compareAndSet(t2, t2, this.queue);
            return this.node;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", PublicConstantsKt.FAILURE, "", Tracker.Events.CREATIVE_COMPLETE, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "oldNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "newNode", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    @PublishedApi
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode newNode;
        @JvmField
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        public void complete(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @Nullable Object obj) {
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode.a.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.b(lockFreeLinkedListNode4);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\u000fj\u0002`\u0010\u0012\n\u0010\u0016\u001a\u00060\u000fj\u0002`\u0010\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "finishPrepare", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "next", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class PrepareOp extends OpDescriptor {
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode affected;
        @JvmField
        @NotNull
        public final AbstractAtomicDesc desc;
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode next;

        public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull AbstractAtomicDesc abstractAtomicDesc) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = abstractAtomicDesc;
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @Nullable
        public Object perform(@Nullable Object obj) {
            Object obj2;
            Object obj3;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            Object onPrepare = this.desc.onPrepare(this);
            Object obj4 = LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            if (onPrepare == obj4) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
                if (LockFreeLinkedListNode.a.compareAndSet(lockFreeLinkedListNode, this, LockFreeLinkedListNode.access$removed(lockFreeLinkedListNode2))) {
                    this.desc.onRemoved(lockFreeLinkedListNode);
                    lockFreeLinkedListNode2.a(null);
                }
                return obj4;
            }
            if (onPrepare != null) {
                obj2 = getAtomicOp().decide(onPrepare);
            } else {
                obj2 = getAtomicOp().getConsensus();
            }
            if (obj2 == AtomicKt.NO_DECISION) {
                obj3 = getAtomicOp();
            } else if (obj2 == null) {
                obj3 = this.desc.updatedNext(lockFreeLinkedListNode, this.next);
            } else {
                obj3 = this.next;
            }
            LockFreeLinkedListNode.a.compareAndSet(lockFreeLinkedListNode, this, obj3);
            return null;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public String toString() {
            StringBuilder L = a.L("PrepareOp(op=");
            L.append(getAtomicOp());
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\"\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001e\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010!\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010%\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 ¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", PublicConstantsKt.FAILURE, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode queue;

        public RemoveFirstDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        public static /* synthetic */ void getResult$annotations() {
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            lockFreeLinkedListNode2.a(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@NotNull PrepareOp prepareOp) {
            a.compareAndSet(this, null, prepareOp.affected);
            b.compareAndSet(this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        public final T getResult() {
            T t = (T) getAffectedNode();
            Intrinsics.checkNotNull(t);
            return t;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            ((b) obj).a.helpRemovePrev();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        public final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor2 = (OpDescriptor) obj;
                    if (opDescriptor.isEarlierThan(opDescriptor2)) {
                        return null;
                    }
                    opDescriptor2.perform(this.queue);
                } else {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    return (LockFreeLinkedListNode) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @NotNull
        public final Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return LockFreeLinkedListNode.access$removed(lockFreeLinkedListNode2);
        }
    }

    public static final b access$removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        b bVar = (b) lockFreeLinkedListNode._removedRef;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(lockFreeLinkedListNode);
        c.lazySet(lockFreeLinkedListNode, bVar2);
        return bVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (kotlinx.coroutines.internal.LockFreeLinkedListNode.a.compareAndSet(r3, r2, ((u6.a.k0.b) r4).a) != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode a(kotlinx.coroutines.internal.OpDescriptor r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r6.isRemoved()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r7) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r5 == 0) goto L_0x0038
            if (r7 == 0) goto L_0x0032
            r0 = r4
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            boolean r0 = r7.isEarlierThan(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            kotlinx.coroutines.internal.OpDescriptor r4 = (kotlinx.coroutines.internal.OpDescriptor) r4
            r4.perform(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof u6.a.k0.b
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.a
            u6.a.k0.b r4 = (u6.a.k0.b) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x0007
        L_0x0052:
        */
        //  java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r4, r3)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r3 = r2
            r2 = r4
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.a(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final void addLast(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!getPrevNode().addNext(lockFreeLinkedListNode, this));
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            tryCondAddNext = getPrevNode().tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrev(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode prevNode;
        do {
            prevNode = getPrevNode();
            if (!function1.invoke(prevNode).booleanValue()) {
                return false;
            }
        } while (!prevNode.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1, @NotNull Function0<Boolean> function0) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            LockFreeLinkedListNode prevNode = getPrevNode();
            if (!function1.invoke(prevNode).booleanValue()) {
                return false;
            }
            tryCondAddNext = prevNode.tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.b(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        b.lazySet(lockFreeLinkedListNode, this);
        a.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (a.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.b(this);
                return true;
            }
        }
        return false;
    }

    public final void b(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
        } while (!b.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (isRemoved()) {
            lockFreeLinkedListNode.a(null);
        }
    }

    @NotNull
    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(@NotNull T t) {
        return new AddLastDesc<>(this, t);
    }

    @NotNull
    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    @NotNull
    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode a3 = a(null);
        if (a3 == null) {
            Object obj = this._prev;
            while (true) {
                a3 = (LockFreeLinkedListNode) obj;
                if (!a3.isRemoved()) {
                    break;
                }
                obj = a3._prev;
            }
        }
        return a3;
    }

    public final void helpRemove() {
        Object next = getNext();
        Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        ((b) next).a.a(null);
    }

    @PublishedApi
    public final void helpRemovePrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object next = lockFreeLinkedListNode.getNext();
            if (!(next instanceof b)) {
                lockFreeLinkedListNode.a(null);
                return;
            }
            lockFreeLinkedListNode = ((b) next).a;
        }
    }

    public boolean isRemoved() {
        return getNext() instanceof b;
    }

    @PublishedApi
    @NotNull
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        return new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
    }

    @Nullable
    public LockFreeLinkedListNode nextIfRemoved() {
        Object next = getNext();
        if (!(next instanceof b)) {
            next = null;
        }
        b bVar = (b) next;
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    public boolean remove() {
        return removeOrNext() == null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    @Nullable
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(@NotNull Function1<? super T, Boolean> function1) {
        LockFreeLinkedListNode removeOrNext;
        while (true) {
            Object next = getNext();
            Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if ((function1.invoke(lockFreeLinkedListNode).booleanValue() && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                return lockFreeLinkedListNode;
            }
            removeOrNext.helpRemovePrev();
        }
    }

    @Nullable
    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpRemove();
        }
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        b bVar;
        do {
            next = getNext();
            if (next instanceof b) {
                return ((b) next).a;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            Objects.requireNonNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            bVar = (b) lockFreeLinkedListNode._removedRef;
            if (bVar == null) {
                bVar = new b(lockFreeLinkedListNode);
                c.lazySet(lockFreeLinkedListNode, bVar);
            }
        } while (!a.compareAndSet(this, next, bVar));
        lockFreeLinkedListNode.a(null);
        return null;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    @PublishedApi
    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull CondAddOp condAddOp) {
        b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.perform(this) == null ? 1 : 2;
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
    }
}
