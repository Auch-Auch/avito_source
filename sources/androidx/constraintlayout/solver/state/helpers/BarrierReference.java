package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;
public class BarrierReference extends HelperReference {
    public State.Direction c;
    public int d;
    public Barrier e;

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r0 != 5) goto L_0x001b;
     */
    @Override // androidx.constraintlayout.solver.state.HelperReference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void apply() {
        /*
            r5 = this;
            r5.getHelperWidget()
            androidx.constraintlayout.solver.state.State$Direction r0 = r5.c
            int r0 = r0.ordinal()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x001b
            if (r0 == r3) goto L_0x001f
            if (r0 == r2) goto L_0x001b
            if (r0 == r1) goto L_0x001f
            r3 = 4
            if (r0 == r3) goto L_0x001d
            r2 = 5
            if (r0 == r2) goto L_0x0020
        L_0x001b:
            r1 = 0
            goto L_0x0020
        L_0x001d:
            r1 = 2
            goto L_0x0020
        L_0x001f:
            r1 = 1
        L_0x0020:
            androidx.constraintlayout.solver.widgets.Barrier r0 = r5.e
            r0.setBarrierType(r1)
            androidx.constraintlayout.solver.widgets.Barrier r0 = r5.e
            int r1 = r5.d
            r0.setMargin(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.state.helpers.BarrierReference.apply():void");
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.e == null) {
            this.e = new Barrier();
        }
        return this.e;
    }

    public void margin(Object obj) {
        margin(this.mState.convertDimension(obj));
    }

    public void setBarrierDirection(State.Direction direction) {
        this.c = direction;
    }

    public void margin(int i) {
        this.d = i;
    }
}
