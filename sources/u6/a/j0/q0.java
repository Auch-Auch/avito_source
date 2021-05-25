package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.Nullable;
public final class q0 extends AbstractSharedFlowSlot<p0<?>> {
    @JvmField
    public long a = -1;
    @JvmField
    @Nullable
    public Continuation<? super Unit> b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(p0<?> p0Var) {
        p0<?> p0Var2 = p0Var;
        if (this.a >= 0) {
            return false;
        }
        long j = p0Var2.f;
        if (j < p0Var2.g) {
            p0Var2.g = j;
        }
        this.a = j;
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(p0<?> p0Var) {
        long j = this.a;
        this.a = -1;
        this.b = null;
        return p0Var.n(j);
    }
}
