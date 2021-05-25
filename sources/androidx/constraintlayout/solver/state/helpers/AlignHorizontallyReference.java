package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;
public class AlignHorizontallyReference extends HelperReference {
    public float c = 0.5f;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearHorizontal();
            Object obj = this.d;
            if (obj != null) {
                constraints.startToStart(obj);
            } else {
                Object obj2 = this.e;
                if (obj2 != null) {
                    constraints.startToEnd(obj2);
                } else {
                    constraints.startToStart(State.PARENT);
                }
            }
            Object obj3 = this.f;
            if (obj3 != null) {
                constraints.endToStart(obj3);
            } else {
                Object obj4 = this.g;
                if (obj4 != null) {
                    constraints.endToEnd(obj4);
                } else {
                    constraints.endToEnd(State.PARENT);
                }
            }
            float f2 = this.c;
            if (f2 != 0.5f) {
                constraints.horizontalBias(f2);
            }
        }
    }

    public void bias(float f2) {
        this.c = f2;
    }

    public void endToEnd(Object obj) {
        this.g = obj;
    }

    public void endToStart(Object obj) {
        this.f = obj;
    }

    public void startToEnd(Object obj) {
        this.e = obj;
    }

    public void startToStart(Object obj) {
        this.d = obj;
    }
}
