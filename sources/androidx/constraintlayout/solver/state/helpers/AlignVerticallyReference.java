package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;
public class AlignVerticallyReference extends HelperReference {
    public float c = 0.5f;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearVertical();
            Object obj = this.d;
            if (obj != null) {
                constraints.topToTop(obj);
            } else {
                Object obj2 = this.e;
                if (obj2 != null) {
                    constraints.topToBottom(obj2);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj3 = this.f;
            if (obj3 != null) {
                constraints.bottomToTop(obj3);
            } else {
                Object obj4 = this.g;
                if (obj4 != null) {
                    constraints.bottomToBottom(obj4);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f2 = this.c;
            if (f2 != 0.5f) {
                constraints.verticalBias(f2);
            }
        }
    }

    public void bias(float f2) {
        this.c = f2;
    }

    public void bottomToBottom(Object obj) {
        this.g = obj;
    }

    public void bottomToTop(Object obj) {
        this.f = obj;
    }

    public void topToBottom(Object obj) {
        this.e = obj;
    }

    public void topToTop(Object obj) {
        this.d = obj;
    }
}
