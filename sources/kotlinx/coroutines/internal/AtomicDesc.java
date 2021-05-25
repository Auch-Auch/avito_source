package kotlinx.coroutines.internal;

import com.avito.android.analytics.screens.PublicConstantsKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\b\u0010\tR&\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/AtomicDesc;", "", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "prepare", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", PublicConstantsKt.FAILURE, "", Tracker.Events.CREATIVE_COMPLETE, "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "setAtomicOp", "(Lkotlinx/coroutines/internal/AtomicOp;)V", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class AtomicDesc {
    @NotNull
    public AtomicOp<?> atomicOp;

    public abstract void complete(@NotNull AtomicOp<?> atomicOp2, @Nullable Object obj);

    @NotNull
    public final AtomicOp<?> getAtomicOp() {
        AtomicOp<?> atomicOp2 = this.atomicOp;
        if (atomicOp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("atomicOp");
        }
        return atomicOp2;
    }

    @Nullable
    public abstract Object prepare(@NotNull AtomicOp<?> atomicOp2);

    public final void setAtomicOp(@NotNull AtomicOp<?> atomicOp2) {
        this.atomicOp = atomicOp2;
    }
}
